import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class manage implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==admin0.dele){
			JOptionPane mess1 = new JOptionPane();
			String T1 = admin0.t1.getText();
		    if(T1.equals("")){
		    	JOptionPane.showMessageDialog(mess1,"操作失败,选项不能为空！","消息对话框",JOptionPane.WARNING_MESSAGE);
		    }
		    else{
		        try {
		        	System.out.println("加载数据库驱动成功");
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//声明数据库test的url
		            String user="admin";//数据库账号
		            String password="123";//数据库密码
		            //建立数据库连接，获得连接对象conn
		            Connection conn=DriverManager.getConnection(url, user, password);
		            System.out.println("连接数据库成功");
		            String sql="delete from pm25 where f_id = '"+T1+"'";//生成一条sql语句
		            Statement stmt=conn.createStatement();//创建一个Statement对象
		            stmt.executeUpdate(sql);//执行SQL语句
		            System.out.println("修改数据库成功");
		            conn.close();
		            System.out.println("关闭数据库成功");
		            JOptionPane.showMessageDialog(mess1,"操作成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
		         }
		         catch (SQLException ee) {
		            // TODO Auto-generated catch block
		        	  ee.printStackTrace();
		         }
		        try {
			    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		         
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//声明数据库test的url
		            String user="admin";//数据库账号
		            String password="123";//数据库密码
		            Connection conn=DriverManager.getConnection(url, user, password);
		            String s = "删除";
		            String a = "删除id为"+T1+"的数据";
		            String sql="insert into journal(time,type,information) values('"+df.format(new Date())+"','"+s+"','"+a+"')";//生成一条sql语句
		            Statement stmt=conn.createStatement();//创建一个Statement对象
		            stmt.executeUpdate(sql);//执行SQL语句
		            conn.close();
		            }
			    catch (SQLException ee) {
		            ee.printStackTrace();
		        }
		     }
		 }
		    if(e.getSource()==admin0.modi){
				 JOptionPane mess2 = new JOptionPane();
				 String T21 = admin0.t21.getText();
		         String T22 = admin0.t22.getText();
		        
		         if(T21.equals("")==false&&T22.equals("")==false){
		        	 
		        	 try {
			            System.out.println("加载数据库驱动成功");
			            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//声明数据库test的url
			            String user="admin";//数据库账号
			            String password="123";//数据库密码
			            String sql;
			            //建立数据库连接，获得连接对象conn
			            Connection conn=DriverManager.getConnection(url, user, password);
			            sql="update pm25 set f_PM25per1h = '"+T22+"' where f_id = '"+T21+"'";//生成一条sql语句
			            Statement stmt=conn.createStatement();//创建一个Statement对象
			            stmt.executeUpdate(sql);//执行SQL语句
			            conn.close();
			            JOptionPane.showMessageDialog(mess2,"操作成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
			        } catch (SQLException ee) {
			            // TODO Auto-generated catch block
			        	ee.printStackTrace();
			        }
		        	 try {
					    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		         
				            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//声明数据库test的url
				            String user="admin";//数据库账号
				            String password="123";//数据库密码
				            Connection conn=DriverManager.getConnection(url, user, password);
				            String s = "修改";
				            String a = "修改id为"+T21+"的数据，将原数据更改为"+T22;
				            String sql="insert into journal(time,type,information) values('"+df.format(new Date())+"','"+s+"','"+a+"')";//生成一条sql语句
				            Statement stmt=conn.createStatement();//创建一个Statement对象
				            stmt.executeUpdate(sql);//执行SQL语句
				            conn.close();
				            }
					    catch (SQLException ee) {
				            ee.printStackTrace();
				        }
		        }
		        else{
		        	 JOptionPane.showMessageDialog(mess2,"操作失败,选项不能为空！","消息对话框",JOptionPane.WARNING_MESSAGE);
		         }
		     	        
			 }
		
		if(e.getSource()==admin0.inse){
			JOptionPane mess3 = new JOptionPane();
			String T31 = admin0.t31.getText();
	         String T32 = admin0.t32.getText();
	         String T33 = admin0.t33.getText();
	         String T34 = admin0.t34.getText();
	         String T35 = admin0.t35.getText();
			if(T31.equals("")==false&&T32.equals("")==false&&T33.equals("")==false&&T34.equals("")==false&&T35.equals("")==false){
			 try {
		         
		            System.out.println("加载数据库驱动成功");
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//声明数据库test的url
		            String user="admin";//数据库账号
		            String password="123";//数据库密码
		            //建立数据库连接，获得连接对象conn
		            Connection conn=DriverManager.getConnection(url, user, password);
		            System.out.println("连接数据库成功");
		            String sql="insert into pm25(f_id,f_area,f_place,f_time,f_PM25per1h) values('"+T31+"','"+T32+"','"+T33+"','"+T34+"','"+T35+"')";//生成一条sql语句
		            Statement stmt=conn.createStatement();//创建一个Statement对象
		            stmt.executeUpdate(sql);//执行SQL语句
		            System.out.println("修改数据库成功");
		            conn.close();
		            System.out.println("关闭数据库成功");
		            JOptionPane.showMessageDialog(mess3,"操作成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
		        } catch (SQLException ee) {
		            // TODO Auto-generated catch block
		            ee.printStackTrace();
		        }
			 try {
			    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		         
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//声明数据库test的url
		            String user="admin";//数据库账号
		            String password="123";//数据库密码
		            Connection conn=DriverManager.getConnection(url, user, password);
		            String s = "插入";
		            String a = "插入一条id为"+T31+"的数据";
		            String sql="insert into journal(time,type,information) values('"+df.format(new Date())+"','"+s+"','"+a+"')";//生成一条sql语句
		            Statement stmt=conn.createStatement();//创建一个Statement对象
		            stmt.executeUpdate(sql);//执行SQL语句
		            conn.close();
		            }
			    catch (SQLException ee) {
		            ee.printStackTrace();
		        }
			}
			else{
	        	 JOptionPane.showMessageDialog(mess3,"操作失败,选项不能为空！","消息对话框",JOptionPane.WARNING_MESSAGE);
	        }
			
		 }
		if(e.getSource()==admin0.journal){
			Journal j = new Journal();
			 Connection conn;
			 Statement stmt;
			 ResultSet rs;
			 String sql;
			 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pm25;";
			 sql="select * from journal order by time";//生成一条sql语句
			 try {
				 conn = DriverManager.getConnection(url, "admin", "123");
			       // 建立Statement对象
			       stmt = conn.createStatement();
			       // 执行数据库查询语句
			       rs = stmt.executeQuery(sql);
		           int i = 0;
		            while (rs.next()) {
				           				    	 
				    	 String type = rs.getString("type");
				    	 String information = rs.getString("information");
				    	 String time = rs.getString("time");
				    	 if(i<200){
					       		Journal.a[i][0]=time; 
					       		Journal.a[i][1]=type;
					       		Journal.a[i][2]=information;
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
		            //conn.close();
		            System.out.println("关闭数据库成功");
		            //JOptionPane.showMessageDialog(mess2,"操作成功","消息对话框",JOptionPane.WARNING_MESSAGE);
		        } catch (SQLException ee) {
		            // TODO Auto-generated catch block
		        	ee.printStackTrace();
		        }
		}
	}
}


