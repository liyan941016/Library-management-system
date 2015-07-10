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


public class Message extends JDialog implements ActionListener{
	
	JLabel hintLabel;//标签
	Object ono[]={" 用户","留言"};
	 Object a[][]=new Object[1][2];
		JTable table;
		JButton enterInsert;
		Connection con;
		Statement sql;
		ResultSet rs;
		String num;
		Message(String s){
		setTitle(s);
		hintLabel=new JLabel("请输入留言");
		table=new JTable(a,ono);
		enterInsert=new JButton("留言");
		setLayout(null);
		Box baseBox=Box.createHorizontalBox();//横向
		baseBox.add(hintLabel);
		baseBox.add(new JScrollPane(table));
		baseBox.add(enterInsert);
		add(baseBox);
		baseBox.setBounds(10,40,600,38);
		enterInsert.addActionListener(this);
		setBounds(120,160,700,200);
		setVisible(true);
	}
	
	
	 


       public Message() {
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
		int k=sql.executeUpdate("INSERT INTO  意见留言表  VALUES('"+a[0][0]+"','"+a[0][1]+"' )");
		 //boolean a=sta.execute(str);
		if(k==1)
			JOptionPane.showMessageDialog(this,"留言成功");

		}


		catch(Exception e1) {  
		e1.printStackTrace();  

		//System.out.print("连接失败"); 
		}     
		 } 
	public static void main(String args[]) 

	 { 
	    
		Message b=new Message("留言");
		
	 }

		}
