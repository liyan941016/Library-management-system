package hehe;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.border.*;
public class BorrowUpdate extends JDialog implements ActionListener{   //������¼�¼����
	JLabel hintLabel;
	JTextField inputNumber;  
	Object name[]={" ���ߺ�","����","����ͼ����","��������","�黹����"};
	Object a[][]=new Object[1][5];
	JTable table;
	JButton enterModify;
	Connection con;
	Statement sql; 
	ResultSet rs;
	String  num;
	BorrowUpdate(String s){ 
		setTitle(s);
		hintLabel=new JLabel("���ߺ�(�س�ȷ��):");
		inputNumber=new JTextField(20);
		table=new JTable(a,name);
		enterModify=new JButton("���¼�¼");
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
			rs=sql.executeQuery("SELECT * FROM ���߽�����Ϣ�� WHERE ���ߺ�='"+num+"'");
			boolean boo=rs.next();
			if(boo==false){
				JOptionPane.showMessageDialog
				(this,"���ߺŲ�����","��ʾ",JOptionPane.WARNING_MESSAGE);
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
			("UPDATE ���߽�����Ϣ�� SET ���߱��='"+a[0][0]+"',����='"+a[0][1]+"',����ͼ����= '"+a[0][2]+"',��������='"+a[0][3]+"',�黹����='"+ a[0][4]+"',��������='"+a[0][5]+"'");
			JOptionPane.showMessageDialog
			(this,"���³ɹ�","�ɹ�",JOptionPane.PLAIN_MESSAGE);   
			con.close();           } 
			catch(SQLException ee){      JOptionPane.showMessageDialog
				(this,"����ʧ��"+ee,"ʧ��",JOptionPane.ERROR_MESSAGE);       } 
			}      }       
public static void main(String args[]) 

{ 
   
	BorrowUpdate b=new BorrowUpdate("����");
	
}
}