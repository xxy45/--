import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class admin0 extends JFrame{
	
	static JButton inse;
	static JButton dele;
	static JButton modi;
	static JButton journal;
	JPanel jpanel;
	JLabel l1,l21,l22,l31,l32,l33,l34,l35;
	static JTextField t1,t21,t22,t31,t32,t33,t34,t35;
	manage manager1,manager2,manager3,manager4;
		
	admin0(){
	    init();  
		setVisible(true);  
	    setSize(230,518);
	    setLocation(993,125);
	    setTitle("请输入...");
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setVisible(true);
	}
	void init(){
		 Container cc1=getContentPane();
		 inse =new JButton("插入"); 
		 dele =new JButton("删除"); 
		 modi =new JButton("修改");
		 journal = new JButton("日志");
		 manager1 = new manage();
		 manager2 = new manage();
		 manager3 = new manage();
		 manager4 = new manage();
		 inse.addActionListener(manager1);
		 dele.addActionListener(manager2);
		 modi.addActionListener(manager3);
		 journal.addActionListener(manager4);
		 
         jpanel = new JPanel();    
         l1 = new JLabel("编号:");           //删除
         l21 = new JLabel("编号:");          //修改
         l22  =new JLabel("PM2.5/h:");    
         l31 = new JLabel("编号:");            //插入
         l32 = new JLabel("城市:");
         l33 = new JLabel("观测点:");
         l34 = new JLabel("时间:");
         l35 = new JLabel("PM2.5/h:");
         t1 = new JTextField(10);
         t21 = new JTextField(10);
         t22 = new JTextField(10);
         t31 = new JTextField(10);
         t32 = new JTextField(10);
         t33 = new JTextField(10);
         t34 = new JTextField(10);
         t35 = new JTextField(10);
         

		 jpanel.setLayout(null);
         jpanel.add(l1);
		 jpanel.add(t1);
		 jpanel.add(dele);
		 jpanel.add(journal);

         jpanel.add(l21);
		 jpanel.add(t21);
		 jpanel.add(l22);
		 jpanel.add(t22);
		 jpanel.add(modi);
		 jpanel.add(l31);
		 jpanel.add(t31);
		 jpanel.add(l32);
		 jpanel.add(t32);
		 jpanel.add(l33);
		 jpanel.add(t33);
		 jpanel.add(l34);
		 jpanel.add(t34);
		 jpanel.add(l35);
		 jpanel.add(t35);
		 jpanel.add(inse);
		 jpanel.add(journal);
		 
		 l1.setBounds(30, 20, 30, 20);   //起始X 起始Y 宽  高 
		 t1.setBounds(80, 20, 120, 20); 
		 dele.setBounds(140, 50, 60, 20);
		 l21.setBounds(30, 100, 30, 20);
		 t21.setBounds(80, 100, 120, 20);
		 l22.setBounds(10, 130, 50, 20);
		 t22.setBounds(80, 130, 120, 20);
		 modi.setBounds(140, 160, 60, 20);
		 l31.setBounds(30, 210, 30, 20);
		 t31.setBounds(80, 210, 120, 20); 
		 l32.setBounds(30, 240, 30, 20);
		 t32.setBounds(80, 240, 120, 20); 
		 l33.setBounds(17, 270, 50, 20);
		 t33.setBounds(80, 270, 120, 20); 
		 l34.setBounds(30, 300, 30, 20);
		 t34.setBounds(80, 300, 120, 20); 
		 l35.setBounds(10, 330, 50, 20);
		 t35.setBounds(80, 330, 120, 20); 
		 inse.setBounds(140, 360, 60, 20);
		 journal.setBounds(50,400,130,40);
		 
		 cc1.add(jpanel,BorderLayout.CENTER);      //插入
	}
}
