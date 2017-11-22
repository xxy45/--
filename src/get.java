import java.awt.event.*;
import java.sql.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class get implements ActionListener{
	static String data1,data2; 
	static String d3,d4;
	static String c1,p1;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==DZT.b3){
			data1 = DateChooser.showDate1.getText();
			data2 = DateChooser.showDate2.getText();
			outdata o = new outdata();
			
			Connection conn;
			Statement stmt;
			ResultSet rs;
			String sql;
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pm25;";
			String d1 = (data1+' '+"00:00:00.000");
			String d2 = (data2+' '+"23:59:59.000");
			// System.out.println(d1+d2);
			if(OperatorListener.city=="全部"&&OperatorListener.place=="全部")
				sql = "select f_id,f_area,f_place,f_time,f_PM25per1h from pm25 where f_time between '"+d1+"'and '"+d2+"' order by f_place,f_id";
			else if(OperatorListener.city != "全部"&&OperatorListener.place=="全部")
				sql = "select f_id,f_area,f_place,f_time,f_PM25per1h from pm25 where f_time between '"+d1+"'and '"+d2+"'"
						+ " and f_area ='"+OperatorListener.city+"' order by f_place,f_id";
			else
				sql = "select f_id,f_area,f_place,f_time,f_PM25per1h from pm25 where f_time between '"+d1+"'and '"+d2+"'"
					+ " and f_area ='"+OperatorListener.city+"' and f_place = '"+OperatorListener.place+"' order by f_time";
			try {
			       // 连接数据库
			       conn = DriverManager.getConnection(url, "admin", "123");
			       // 建立Statement对象
			       stmt = conn.createStatement();
			       // 执行数据库查询语句
			       rs = stmt.executeQuery(sql);
			       int i = 0;
			       while (rs.next()) {
			    	 String area = rs.getString("f_area");  
			    	 String place = rs.getString("f_place");
			    	 String time = rs.getString("f_time");
			    	 int pm = rs.getInt("f_PM25per1h");
			    	 int id = rs.getInt("f_id");
			    	 			    				    	 
			       	 //System.out.println(area+"    "+place+"    "+time+"    "+pm);
			       	 if(i<200){
			       		outdata.a[i][0]=id; 
			       		outdata.a[i][1]=area;
			       		outdata.a[i][2]=place;
			       		outdata.a[i][3]=time;
			    		outdata.a[i][4]=pm;
			    		}
			    		i++;
			       }
			      if (rs != null) {
			       	rs.close();
			       	rs = null;
			       }
			       if (stmt != null) {
			       	stmt.close();
			       	stmt = null;
			       }
			       if (conn != null) {
			       	conn.close();
			       	conn = null;
			       }
			   } 
			   catch (SQLException e1) {}
		}
		
		if(e.getSource()==DZT.b4){
			data1 = DateChooser.showDate1.getText();
			data2 = DateChooser.showDate2.getText();
			d3 = (data1+' '+"00:00:00.000");
			d4 = (data2+' '+"23:59:59.000");
			
			try {
				Line line = new Line();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		
	}
	}
}
