import java.awt.*;
import javax.swing.*;

public class login extends JFrame{
	
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	JPanel jp1;
	static JTextField t1;
	static JTextField t2;
    static JButton b1;   //log in
    JButton b2;   //rewrite
    static String power;
    
    
    login(){
	     init(); 
	     setVisible(true);  
		 setSize(300,320);
		 setTitle("����Ա��¼");
		 setResizable(false);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		 setVisible(true);
	
	 }
	void init(){
		 Container ct1=getContentPane();
		 jl1=new JLabel("��¼"); 
		 jl1.setFont(new Font("����",Font.BOLD, 30));
//		 jl1.setOpaque(false);
		 jl2 = new JLabel("�û���");
		 jl3 = new JLabel("����");
		 jp1= new JPanel();
		 t1=new JTextField(15);
         t2=new JPasswordField(15);
        
         //��¼����д
         b1=new JButton("Log in");
         b2=new JButton("Reset");
         
 //        b1.addKeyListener(this);
         b2.addActionListener(new ReWrite());   //����¼�
        
        
		 jp1.add(jl1);
		 jp1.add(jl2);
		 jp1.add(jl3);
		 jp1.add(t1);
		 jp1.add(t2);
		 jp1.add(b1);
		 jp1.add(b2);
		 jp1.setLayout(null);
		 jl1.setBounds(120, 15, 200, 100);   //��ʼX ��ʼY ��  �� 
		 jl2.setBounds(60, 120, 80, 20);   //��ʼX ��ʼY ��  �� 
		 jl3.setBounds(60, 150, 80, 20);   //��ʼX ��ʼY ��  �� 
		 t1.setBounds(170, 120, 80, 20);
		 t2.setBounds(170, 150, 80, 20);
		 b1.setBounds(55, 210, 80, 20);
		 b2.setBounds(165, 210, 80, 20);
		 ct1.add(jp1,BorderLayout.CENTER);
	     
		 
	}
	
      
	 
	
}
