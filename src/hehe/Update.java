package hehe;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.border.*;
public class Update extends JDialog implements ActionListener{   //������¼�¼����
	JLabel hintLabel;
	JTextField inputNumber;  
	Object name[]={"ͼ����","����","�������","������","������","��������","����","�������"};
	Object a[][]=new Object[1][8];
	JTable table;
	JButton enterModify;
	Connection con;
	Statement sql; 
	ResultSet rs;
	String  num;
	Update(String s){ 
		setTitle(s);
		hintLabel=new JLabel("ͼ����(�س�ȷ��):");
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
			rs=sql.executeQuery("SELECT * FROM ͼ����Ϣ�� WHERE ͼ����='"+num+"'");
			boolean boo=rs.next();
			if(boo==false){
				JOptionPane.showMessageDialog
				(this,"ͼ���Ų�����","��ʾ",JOptionPane.WARNING_MESSAGE);
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
			("UPDATE ͼ����Ϣ�� SET ͼ����='"+a[0][0]+"',����='"+a[0][1]+"',�������= '"+a[0][2]+"',������='"+a[0][3]+"',������='"+ a[0][4]+"',��������='"+a[0][5]+"',����='"+a[0][6]+"',�������='"+a[0][7]+"''WHERE �豸���='"+num+"'");
			JOptionPane.showMessageDialog
			(this,"���³ɹ�","�ɹ�",JOptionPane.PLAIN_MESSAGE);   
			con.close();           } 
			catch(SQLException ee){      JOptionPane.showMessageDialog
				(this,"����ʧ��"+ee,"ʧ��",JOptionPane.ERROR_MESSAGE);       } 
			}      }       
public static void main(String args[]) 

{ 
   
	Update b=new Update("����");
	
}
} 