package hehe;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.border.*;
public class BorrowUpdate extends JDialog implements ActionListener{   //负责更新记录的类
	JLabel hintLabel;
	JTextField inputNumber;  
	Object name[]={" 读者号","姓名","借阅图书编号","借阅日期","归还日期"};
	Object a[][]=new Object[1][5];
	JTable table;
	JButton enterModify;
	Connection con;
	Statement sql; 
	ResultSet rs;
	String  num;
	BorrowUpdate(String s){ 
		setTitle(s);
		hintLabel=new JLabel("读者号(回车确认):");
		inputNumber=new JTextField(20);
		table=new JTable(a,name);
		enterModify=new JButton("更新记录");
		setLayout(null);
		Box baseBox=Box.createHorizontalBox();
		baseBox.add(hintLabel);
		baseBox.add(inputNumber);
		baseBox.add(new JScrollPane(table));
		baseBox.add(enterModify);
		add(baseBox);
		baseBox.setBounds(60,70,800,50);
		inputNumber.addActionListener(this);
		enterModify.addActionListener(this);
		setBounds(20,100,900,200); 
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent e){
		
		
		if(e.getSource()==inputNumber)
			
		try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		catch(ClassNotFoundException ee){System.out.println(""+e);}
		try{con=DriverManager.getConnection("jdbc:odbc:hehe","","");
		    sql=con.createStatement();
			rs=sql.executeQuery("SELECT * FROM 读者借阅信息表 WHERE 读者号='"+num+"'");
			boolean boo=rs.next();
			if(boo==false){
				JOptionPane.showMessageDialog
				(this,"读者号不存在","提示",JOptionPane.WARNING_MESSAGE);
				}       
			else{ 
				a[0][0]=rs.getString(1);
				a[0][1]=rs.getString(2) ;
				a[0][2]=rs.getString(3) ;
				a[0][3]=rs.getString(4) ;
				a[0][4]=rs.getString(5) ;
			
				table.repaint();
			}
			con.close();
			}  
		catch(SQLException ee){ 
			System.out.println(ee);       }
		if(e.getSource()==enterModify){
			
			try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
			catch(ClassNotFoundException ee){System.out.println(""+e);}
			try{con=DriverManager.getConnection("jdbc:odbc:hehe","","");
			    sql=con.createStatement();
			sql.executeUpdate
			("UPDATE 读者借阅信息表 SET 读者编号='"+a[0][0]+"',姓名='"+a[0][1]+"',借阅图书编号= '"+a[0][2]+"',借阅日期='"+a[0][3]+"',归还日期='"+ a[0][4]+"',出版日期='"+a[0][5]+"'");
			JOptionPane.showMessageDialog
			(this,"更新成功","成功",JOptionPane.PLAIN_MESSAGE);   
			con.close();           } 
			catch(SQLException ee){      JOptionPane.showMessageDialog
				(this,"更新失败"+ee,"失败",JOptionPane.ERROR_MESSAGE);       } 
			}      }       
public static void main(String args[]) 

{ 
   
	BorrowUpdate b=new BorrowUpdate("更新");
	
}
}