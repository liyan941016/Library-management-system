package hehe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Insert extends JDialog implements ActionListener{
	
	JLabel hintLabel;//标签
	Object ono[]={" 图书编号","书名","出版书号","编著者","出版社","出版日期","单价","库存数量"};
	 Object a[][]=new Object[1][8];
		JTable table;
		JButton enterInsert;
		Connection con;
		Statement sql;
		ResultSet rs;
		String num;
		Insert(String s){
		setTitle(s);
		hintLabel=new JLabel("输入新纪录");
		table=new JTable(a,ono);
		enterInsert=new JButton("插入新纪录");
		setLayout(null);
		Box baseBox=Box.createHorizontalBox();//横向
		baseBox.add(hintLabel);
		baseBox.add(new JScrollPane(table));
		baseBox.add(enterInsert);
		add(baseBox);
		baseBox.setBounds(10,40,600,38);
		enterInsert.addActionListener(this);
		setBounds(320,160,700,200);
		setVisible(true);
	}
	
	
	 


       public Insert() {
		// TODO 自动生成的构造函数存根
	}





	public void actionPerformed(ActionEvent e){  
		Connection con;
		Statement sql;
		ResultSet rs;
		try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		catch(ClassNotFoundException ee){System.out.println(""+e);}
		try{con=DriverManager.getConnection("jdbc:odbc:hehe","","");
		    sql=con.createStatement();
		int k=sql.executeUpdate("INSERT INTO  图书信息表  VALUES('"+a[0][0]+"','"+a[0][1]+"','"+a[0][2]+"','"+a[0][3]+"','"+a[0][4]+"','"+a[0][5]+"','"+a[0][6]+"','"+a[0][7]+"','"+a[0][8]+"' )");
		 //boolean a=sta.execute(str);
		if(k==1)
			JOptionPane.showMessageDialog(this,"插入成功");

		}


		catch(Exception e1) {  
		e1.printStackTrace();  

		//System.out.print("连接失败"); 
		}     
		 } 
	public static void main(String args[]) 

	 { 
	    
		Insert b=new Insert("插入");
		
	 }

		} 