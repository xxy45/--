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
		// TODO �Զ����ɵķ������
		if(e.getSource()==admin0.dele){
			JOptionPane mess1 = new JOptionPane();
			String T1 = admin0.t1.getText();
		    if(T1.equals("")){
		    	JOptionPane.showMessageDialog(mess1,"����ʧ��,ѡ���Ϊ�գ�","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		    }
		    else{
		        try {
		        	System.out.println("�������ݿ������ɹ�");
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//�������ݿ�test��url
		            String user="admin";//���ݿ��˺�
		            String password="123";//���ݿ�����
		            //�������ݿ����ӣ�������Ӷ���conn
		            Connection conn=DriverManager.getConnection(url, user, password);
		            System.out.println("�������ݿ�ɹ�");
		            String sql="delete from pm25 where f_id = '"+T1+"'";//����һ��sql���
		            Statement stmt=conn.createStatement();//����һ��Statement����
		            stmt.executeUpdate(sql);//ִ��SQL���
		            System.out.println("�޸����ݿ�ɹ�");
		            conn.close();
		            System.out.println("�ر����ݿ�ɹ�");
		            JOptionPane.showMessageDialog(mess1,"�����ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		         }
		         catch (SQLException ee) {
		            // TODO Auto-generated catch block
		        	  ee.printStackTrace();
		         }
		        try {
			    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		         
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//�������ݿ�test��url
		            String user="admin";//���ݿ��˺�
		            String password="123";//���ݿ�����
		            Connection conn=DriverManager.getConnection(url, user, password);
		            String s = "ɾ��";
		            String a = "ɾ��idΪ"+T1+"������";
		            String sql="insert into journal(time,type,information) values('"+df.format(new Date())+"','"+s+"','"+a+"')";//����һ��sql���
		            Statement stmt=conn.createStatement();//����һ��Statement����
		            stmt.executeUpdate(sql);//ִ��SQL���
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
			            System.out.println("�������ݿ������ɹ�");
			            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//�������ݿ�test��url
			            String user="admin";//���ݿ��˺�
			            String password="123";//���ݿ�����
			            String sql;
			            //�������ݿ����ӣ�������Ӷ���conn
			            Connection conn=DriverManager.getConnection(url, user, password);
			            sql="update pm25 set f_PM25per1h = '"+T22+"' where f_id = '"+T21+"'";//����һ��sql���
			            Statement stmt=conn.createStatement();//����һ��Statement����
			            stmt.executeUpdate(sql);//ִ��SQL���
			            conn.close();
			            JOptionPane.showMessageDialog(mess2,"�����ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
			        } catch (SQLException ee) {
			            // TODO Auto-generated catch block
			        	ee.printStackTrace();
			        }
		        	 try {
					    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		         
				            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//�������ݿ�test��url
				            String user="admin";//���ݿ��˺�
				            String password="123";//���ݿ�����
				            Connection conn=DriverManager.getConnection(url, user, password);
				            String s = "�޸�";
				            String a = "�޸�idΪ"+T21+"�����ݣ���ԭ���ݸ���Ϊ"+T22;
				            String sql="insert into journal(time,type,information) values('"+df.format(new Date())+"','"+s+"','"+a+"')";//����һ��sql���
				            Statement stmt=conn.createStatement();//����һ��Statement����
				            stmt.executeUpdate(sql);//ִ��SQL���
				            conn.close();
				            }
					    catch (SQLException ee) {
				            ee.printStackTrace();
				        }
		        }
		        else{
		        	 JOptionPane.showMessageDialog(mess2,"����ʧ��,ѡ���Ϊ�գ�","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
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
		         
		            System.out.println("�������ݿ������ɹ�");
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//�������ݿ�test��url
		            String user="admin";//���ݿ��˺�
		            String password="123";//���ݿ�����
		            //�������ݿ����ӣ�������Ӷ���conn
		            Connection conn=DriverManager.getConnection(url, user, password);
		            System.out.println("�������ݿ�ɹ�");
		            String sql="insert into pm25(f_id,f_area,f_place,f_time,f_PM25per1h) values('"+T31+"','"+T32+"','"+T33+"','"+T34+"','"+T35+"')";//����һ��sql���
		            Statement stmt=conn.createStatement();//����һ��Statement����
		            stmt.executeUpdate(sql);//ִ��SQL���
		            System.out.println("�޸����ݿ�ɹ�");
		            conn.close();
		            System.out.println("�ر����ݿ�ɹ�");
		            JOptionPane.showMessageDialog(mess3,"�����ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		        } catch (SQLException ee) {
		            // TODO Auto-generated catch block
		            ee.printStackTrace();
		        }
			 try {
			    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		         
		            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=PM25;";//�������ݿ�test��url
		            String user="admin";//���ݿ��˺�
		            String password="123";//���ݿ�����
		            Connection conn=DriverManager.getConnection(url, user, password);
		            String s = "����";
		            String a = "����һ��idΪ"+T31+"������";
		            String sql="insert into journal(time,type,information) values('"+df.format(new Date())+"','"+s+"','"+a+"')";//����һ��sql���
		            Statement stmt=conn.createStatement();//����һ��Statement����
		            stmt.executeUpdate(sql);//ִ��SQL���
		            conn.close();
		            }
			    catch (SQLException ee) {
		            ee.printStackTrace();
		        }
			}
			else{
	        	 JOptionPane.showMessageDialog(mess3,"����ʧ��,ѡ���Ϊ�գ�","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
	        }
			
		 }
		if(e.getSource()==admin0.journal){
			Journal j = new Journal();
			 Connection conn;
			 Statement stmt;
			 ResultSet rs;
			 String sql;
			 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pm25;";
			 sql="select * from journal order by time";//����һ��sql���
			 try {
				 conn = DriverManager.getConnection(url, "admin", "123");
			       // ����Statement����
			       stmt = conn.createStatement();
			       // ִ�����ݿ��ѯ���
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
		            System.out.println("�ر����ݿ�ɹ�");
		            //JOptionPane.showMessageDialog(mess2,"�����ɹ�","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		        } catch (SQLException ee) {
		            // TODO Auto-generated catch block
		        	ee.printStackTrace();
		        }
		}
	}
}


