

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Line {
	
	static ArrayList list1 = new ArrayList();
	static ArrayList list2 = new ArrayList();
	static ArrayList list3 = new ArrayList();
	Line() throws SQLException{
		 String c="";
		String p="";
		String sum ;
		 Connection conn;
		 Statement stmt;
		 ResultSet rs;
		 String sql;
		 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pm25;";
		 if(OperatorListener.city != "全部"&&OperatorListener.place=="全部")
			sql = "select f_area,f_place,f_time,f_PM25per1h from pm25 where f_time between '"+get.d3+"'and '"+get.d4+"'"
						+ " and f_area ='"+OperatorListener.city+"' order by f_time";
		 else if(OperatorListener.city=="全部"&&OperatorListener.place=="全部")
			 sql = "select f_area,f_place,f_time,f_PM25per1h from pm25 where f_time between '"+get.d3+"'and '"+get.d4+"' order by f_time";				
		 else
			 sql = "select f_area,f_place,f_time,f_PM25per1h from pm25 where f_time between '"+get.d3+"'and '"+get.d4+"'"
					+ " and f_area ='"+OperatorListener.city+"' and f_place = '"+OperatorListener.place+"' order by f_time";
		
		// 连接数据库
	       conn = DriverManager.getConnection(url, "admin", "123");
	       // 建立Statement对象
	       stmt = conn.createStatement();
	       // 执行数据库查询语句
	       rs = stmt.executeQuery(sql);
	       DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
	       if(OperatorListener.city=="全部"&&OperatorListener.place=="全部"){
	    	   while( rs.next( ) ) 
		       {	
	    		  p = rs.getString("f_place");
		          if(p.endsWith("（总）")){
		             mDataset.setValue(rs.getInt("f_PM25per1h") ,rs.getString( "f_place" ),rs.getString("f_time"));
		          }
		       }
	    	   sum = "所有城市";
	       }
	       else{
	       while( rs.next( ) ) 
	       {	c= rs.getString("f_area");
	       		p= rs.getString("f_place");
	          mDataset.setValue( 
	          rs.getInt("f_PM25per1h") ,rs.getString( "f_place" ),rs.getString("f_time"));
	       }
	       if(OperatorListener.city != "全部"&&OperatorListener.place=="全部")
	    	   sum = c;
	       else
	    	   sum = c+p;
	       }
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);		
		//CategoryDataset mDataset = GetDataset();
		JFreeChart mChart = ChartFactory.createLineChart(
				sum+"PM2.5/h趋势图",
				"时间",
				"PM2.5/h",
				mDataset,
				PlotOrientation.VERTICAL,
				true, 
				true, 
				false);
		
		CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
		mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
		mPlot.setOutlinePaint(Color.RED);//边界线
		
		ChartFrame mChartFrame = new ChartFrame("折线图", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);

	}
/*	public static CategoryDataset GetDataset(){
		String[] x = (String[])list1.toArray(new String[list1.size()]);
		int a[] = new int[x.length];  
		for(int i=0;i<x.length;i++){  
		    a[i]=Integer.parseInt(x[i]); 
		}
		String[] b = (String[])list2.toArray(new String[list2.size()]);
		String[] c = (String[])list2.toArray(new String[list3.size()]);
		
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		for(int i=0;i<x.length;i++){
		mDataset.addValue(a[i],b[i],c[i]);
		System.out.println(a[i]);
		}
		return mDataset;
	}*/


}