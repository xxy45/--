import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class DZT extends JFrame{
	DateChooser dateChooser1 ;
    DateChooser dateChooser2 ;
    


	  static JComboBox cb1 ;
	  static JComboBox cb2 ;
	 OperatorListener listener1;
	 OperatorListener listener2;
		 
    static JButton b3;   //��ѯ����
    static JButton b4;   //��ѯͼ��
    JButton b5;   //����Ա��¼
    get B4,B3;
    Textlistener text;
 
  
    
    String imgePath = "E:/Java �ļ�/DZT3.1.0/image2.png";
    JPanel p5;
    Image img = Toolkit.getDefaultToolkit().createImage(imgePath);
    
    
    DZT(){
    	cb1 = new JComboBox();
    	cb2 = new JComboBox();
    	cb2.addItem("ȫ��");
    	//cb1.setSelectedItem("ȫ��");
    	//cb2.setSelectedItem("ȫ��");
    	
    	OperatorListener.choose1();
    	listener1 = new OperatorListener();
     	cb1.addItemListener(listener1);
   	
  	  	listener2 = new OperatorListener();
  	  	cb2.addItemListener(listener2);
    	   	
    	 Container ct=getContentPane();
    
    	   	
    	 JLabel l1=new JLabel("����");               
    	 JLabel l2=new JLabel("�۲��");
    	 JLabel l3=new JLabel("��ʼʱ��");
    	 JLabel l31=new JLabel("����ʱ��");
    	 JLabel l4=new JLabel("PM2.5��ѯ");
    	
    	 b3=new JButton("��ѯ����");
    	 b4=new JButton("��ѯͼ��");
    	 b5=new JButton("����Ա��¼");
    	 B3 = new get();
    	 B4 = new get();
    	 b4.addActionListener(B4);
    	 b3.addActionListener(B3);       //������
    
    	 JPanel p1=new JPanel();       
    	 JPanel p2=new JPanel();       //����
    	 JPanel p3=new JPanel();       //�۲��
    	 JPanel p4=new JPanel();       //ʱ��
    	 
    	 dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
	     dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");
	    DateChooser.showDate1 = new JTextField("            ����ѡ������");
	    DateChooser.showDate2 = new JTextField("            ����ѡ������");
	   text = new Textlistener();
	   (DateChooser.showDate1.getDocument()).addDocumentListener(text);
	        dateChooser1.register(DateChooser.showDate1);
	        dateChooser2.register(DateChooser.showDate2);

	        get.data1 = DateChooser.showDate1.getText().toString();
	        
    	 
    	 b5.addActionListener(new LogininAction());
    	 
    	 p5=new JPanel(){
    	    protected  void paintChildren(Graphics g) {
    	    g.drawImage(img,0,0,this);
    	    super.paintChildren(g);
    	    }
    	 };
    
          //PM2.5��ѯ
          l4.setFont(new Font("����",Font.BOLD, 30));    //������
          l4.setOpaque(false);
         
          //����JLabel��͸��
          l1.setOpaque(false);
          l2.setOpaque(false);
          l3.setOpaque(false);
          
          //����
          p2.add(l1);
          p2.add(cb1);
          p2.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
          p2.setLayout(null);
          l1.setBounds(40, 10, 30, 20);      //��ʼX ��ʼY ��  �� 
          cb1.setBounds(130, 10, 150, 20);    //��ʼX ��ʼY ��  �� 
          p2.setOpaque(false);               //��͸��
          
          //�۲��
          p3.add(l2);
          p3.add(cb2);
          p3.setLayout(null);
          l2.setBounds(40, 10, 50, 20);     //��ʼX ��ʼY ��  �� 
          cb2.setBounds(130, 10, 150, 20);   //��ʼX ��ʼY ��  �� 
          p3.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
          p3.setOpaque(false);
        
          //ʱ��
          p4.add(l3);
          p4.add(l31);
          p4.add(DateChooser.showDate1);
          p4.add(DateChooser.showDate2);
          p4.setBorder(new MatteBorder(-3,-3,-3,-3,Color.CYAN));
          p4.setLayout(null);
          l3.setBounds(40, 10, 100, 20);    //��ʼX ��ʼY ��  �� 
          l31.setBounds(40, 50, 100, 20);   //��ʼX ��ʼY ��  �� 

          DateChooser.showDate1.setBounds(130, 10, 150, 20);  //��ʼX ��ʼY ��  �� 
          DateChooser.showDate2.setBounds(130, 50, 150, 20);  //��ʼX ��ʼY ��  �� 
          p4.setOpaque(false);
      
         
          
          
          //�ܲ���
          p5.setLayout(null);
          p5.add(l4);
          p5.add(p2);
          p5.add(p3);
          p5.add(p4);
          p5.add(b3);
          p5.add(b4);
          p5.add(b5);
          l4.setBounds(410, 45, 150, 45);     //��ʼX ��ʼY ��  �� 
          p2.setBounds(300, 100, 500, 45);     //��ʼX ��ʼY ��  �� 
          p3.setBounds(300, 150, 500, 45);     //��ʼX ��ʼY ��  �� 
          p4.setBounds(300, 200, 500, 75);     //��ʼX ��ʼY ��  �� 
          b3.setBounds(375, 300, 90, 30);
          b4.setBounds(495, 300, 90, 30);
          b5.setBounds(80, 25, 100, 30);
          
          //container
          ct.add(p5,BorderLayout.CENTER);
    
    }     
    
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		 DZT log=new DZT();
		 log.setTitle("PM2.5��ѯ");
		 log.setSize(699,518);
		 log.setVisible(true);
		 log.setResizable(false);
		 log.setLocationRelativeTo(null);
		 log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
    class LogininAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			final login jf = new login();
			
			login.b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {  
	        		 if((login.t1.getText()).equals("admin")&&(login.t2.getText()).equals("123")) {
	       		     jf.dispose();  
	       		     admin0 adm  = new admin0();
	       		     }
	        		 else JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������µ�¼","����",JOptionPane.ERROR_MESSAGE);
	       		  }
	        		
	              
	         }); 
		}  
	
	 }
	

		
}
