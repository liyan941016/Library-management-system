package hehe;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.border.*;
public class Update extends JDialog implements ActionListener{   //负责更新记录的类
	JLabel hintLabel;
	JTextField inputNumber;  
	Object name[]={"图书编号","书名","出版书号","编著者","出版社","出版日期","单价","库存数量"};
	Object a[][]=new Object[1][8];
	JTable table;
	JButton enterModify;
	Connection con;
	Statement sql; 
	ResultSet rs;
	String  num;
	Update(String s){ 
		setTitle(s);
		hintLabel=new JLabel("图书编号(回车确认):");
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
			rs=sql.executeQuery("SELECT * FROM 图书信息表 WHERE 图书编号='"+num+"'");
			boolean boo=rs.next();
			if(boo==false){
				JOptionPane.showMessageDialog
				(this,"图书编号不存在","提示",JOptionPane.WARNING_MESSAGE);
				}       
			else{ 
				a[0][0]=rs.getString(1);
				a[0][1]=rs.getString(2) ;
				a[0][2]=rs.getString(3) ;
				a[0][3]=rs.getString(4) ;
				a[0][4]=rs.getString(5) ;
				a[0][5]=rs.getString(6) ;
				a[0][6]=rs.getString(7) ;
				a[0][7]=rs.getString(8) ;
			
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
			("UPDATE 图书信息表 SET 图书编号='"+a[0][0]+"',书名='"+a[0][1]+"',出版书号= '"+a[0][2]+"',编著者='"+a[0][3]+"',出版社='"+ a[0][4]+"',出版日期='"+a[0][5]+"',单价='"+a[0][6]+"',库存数量='"+a[0][7]+"''WHERE 设备编号='"+num+"'");
			JOptionPane.showMessageDialog
			(this,"更新成功","成功",JOptionPane.PLAIN_MESSAGE);   
			con.close();           } 
			catch(SQLException ee){      JOptionPane.showMessageDialog
				(this,"更新失败"+ee,"失败",JOptionPane.ERROR_MESSAGE);       } 
			}      }       
public static void main(String args[]) 

{ 
   
	Update b=new Update("更新");
	
}
} 