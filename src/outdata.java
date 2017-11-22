import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

 public class outdata extends JFrame{
	JPanel j;
	static JButton b;
	JTable table;
	JScrollPane s;
	static Object a[][];
	Object name[]={"id","城市","观测点","时间","PM2.5/h"};
	outdata(){
		 init(); 
	     setVisible(true);  
		 
		 setTitle("查询结果");
		 setResizable(false);
		 setSize(500,400);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		 setVisible(true);
		 b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				   
				     outdata.this.dispose();
				    }
				   });
	}
	void init(){
		a = new Object[200][5];
		table = new JTable(a,name);
		Container c=getContentPane();
		j = new JPanel();
		s = new JScrollPane(table);
		j.add(s);
		b = new JButton("确定");
		c.add(j,BorderLayout.CENTER);
		c.add(b,BorderLayout.SOUTH);
		table.setCellSelectionEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		}
}