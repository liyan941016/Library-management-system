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
	
	JLabel hintLabel;//��ǩ
	Object ono[]={" ͼ����","����","�������","������","������","��������","����","�������"};
	 Object a[][]=new Object[1][8];
		JTable table;
		JButton enterInsert;
		Connection con;
		Statement sql;
		ResultSet rs;
		String num;
		Insert(String s){
		setTitle(s);
		hintLabel=new JLabel("�����¼�¼");
		table=new JTable(a,ono);
		enterInsert=new JButton("�����¼�¼");
		setLayout(null);
		Box baseBox=Box.createHorizontalBox();//����
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
		// TODO �Զ����ɵĹ��캯�����
	}





	public void actionPerformed(ActionEvent e){  
		Connection con;
		Statement sql;
		ResultSet rs;
		try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		catch(ClassNotFoundException ee){System.out.println(""+e);}
		try{con=DriverManager.getConnection("jdbc:odbc:hehe","","");
		    sql=con.createStatement();
		int k=sql.executeUpdate("INSERT INTO  ͼ����Ϣ��  VALUES('"+a[0][0]+"','"+a[0][1]+"','"+a[0][2]+"','"+a[0][3]+"','"+a[0][4]+"','"+a[0][5]+"','"+a[0][6]+"','"+a[0][7]+"','"+a[0][8]+"' )");
		 //boolean a=sta.execute(str);
		if(k==1)
			JOptionPane.showMessageDialog(this,"����ɹ�");

		}


		catch(Exception e1) {  
		e1.printStackTrace();  

		//System.out.print("����ʧ��"); 
		}     
		 } 
	public static void main(String args[]) 

	 { 
	    
		Insert b=new Insert("����");
		
	 }

		} 