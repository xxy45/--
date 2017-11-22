import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;


public class OperatorListener implements ItemListener{
	
	public static String city ;
	public static String place;
	
	get workTogether;
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == DZT.cb1){
		
			 if(e.getStateChange()==ItemEvent.SELECTED){
				//DZT.cb2.removeAllItems();
			    city=DZT.cb1.getSelectedItem().toString();                 
			    
			// System.out.println(city);
			 Connection conn;
			 Statement stmt;
			 ResultSet rs;
			 String sql;
			 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pm25;";
				if(city == "全部"){
					DZT.cb2.addItem("全部");
					sql = " ";
				}
				else 		
					sql = "select distinct f_place from pm25 where f_area ='"+city+"'";
			ArrayList<String> list2 = new ArrayList<String>();
			
		   try {
		       // 连接数据库
		       conn = DriverManager.getConnection(url, "admin", "123");
		       // 建立Statement对象
		       stmt = conn.createStatement();
		       // 执行数据库查询语句
		       rs = stmt.executeQuery(sql);
		       while (rs.next()) {
		           
		    	 String place = rs.getString("f_place");
		       	 list2.add(place);
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
		   DZT.cb2.removeAllItems();
		   list2.add(0, "全部");
		   int temp = list2.size();
		   String[] b = (String[])list2.toArray(new String[temp]);
		   for(int i = 0;i <b.length;i ++){
			  // System.out.println(b[i]);
			   DZT.cb2.addItem(b[i]);
			}
		  
		}
	}                                           //cb1结束
		if(e.getSource() == DZT.cb2){
			 if(e.getStateChange()==ItemEvent.SELECTED){
				//DZT.cb2.removeAllItems();
			    place=DZT.cb2.getSelectedItem().toString();  
			 }
		} 
	}
	
public static void choose1(){
		 Connection conn;
		 Statement stmt;
		 ResultSet rs;
		 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pm25;";
		 String sql = "select distinct f_area,f_areacode from pm25";
		
		    
		ArrayList<String> list = new ArrayList<String>();
		
		
	    try {
	        // 连接数据库
	        conn = DriverManager.getConnection(url, "admin", "123");
	        // 建立Statement对象
	        stmt = conn.createStatement();
	        // 执行数据库查询语句
	        rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	         
	        	String area = rs.getString("f_area");
	        	
	        	 list.add(area);
	        	 
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
	    catch (SQLException e) {}
	    list.add(0,"全部");
	  
	    String[] a = (String[])list.toArray(new String[list.size()]);
	   
	   DZT.cb1 = new JComboBox(a);
	   }
	
}
