import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;


public class Journal extends JFrame{
	JPanel j;
	static JButton b;
	JTable table;
	JScrollPane s;
	static Object a[][];
	Object name[]={"时间","操作类型","描述"};
	Journal(){
		 init(); 
	     setVisible(true);  
		 
		 setTitle("操作记录");
		 setResizable(false);
		 setSize(500,400);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		 setVisible(true);
		 b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				   
				     Journal.this.dispose();
				    }
				   });
	}
	void init(){
		a = new Object[200][3];
		table = new JTable(a,name);
		Container c=getContentPane();
		j = new JPanel();
		s = new JScrollPane(table);
		j.add(s);
		b = new JButton("确定");
		c.add(j,BorderLayout.CENTER);
		c.add(b,BorderLayout.SOUTH);
		table.setCellSelectionEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
	
		
		}
}
