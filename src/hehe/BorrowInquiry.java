package hehe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 
	public class BorrowInquiry extends JDialog implements ActionListener{//������ʾ��¼����
		 JTable  table;//���
	    Object a[][];
	    Object name[]={" ���ߺ�","����","����ͼ����","��������","�黹����"};
	    JButton S; 
	    Connection con;
	    Statement sql; 
	    ResultSet rs;
	    BorrowInquiry(String title){  
	 	   setTitle(title);
	       S=new JButton("��ʾ��¼");
	       S.addActionListener(this);
	       add(S,BorderLayout.NORTH);
	       setBounds(200,60,800,250);
	       setVisible(true);
	       
	    }
	    public void actionPerformed(ActionEvent e){
	      
	    	Connection con;
			Statement sql;
			ResultSet rs;
			try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
			catch(ClassNotFoundException ee){System.out.println(""+e);}
			try{con=DriverManager.getConnection("jdbc:odbc:hehe","","");
			    sql=con.createStatement();
	            rs=sql.executeQuery("select * from  ���߽�����Ϣ��");
	            rs.last();
	            int lastNumber=rs.getRow();
	            a=new Object[lastNumber][5];
	            int k=0;
	            rs.beforeFirst();
	            while(rs.next()){
	            	
	                 a[k][0]=rs.getString(1);
	                 a[k][1]=rs.getString(2);  
	                 a[k][2]=rs.getString(3);
	                 a[k][3]=rs.getString(4);
	                 a[k][4]=rs.getString(5);
	                
	                 
	                 
	                 k++;
	                
	           }
	           con.close();
	          // System.out.print("����ʧ��"); 
	       }  
	       catch(SQLException ee){ 
	    	 //  System.out.print("����ʧ��"); 
	           System.out.println(ee);
	       } 
	       table=new JTable(a,name);
	    getContentPane().removeAll();
	       add(S,BorderLayout.NORTH);
	      // System.out.print("����ʧ��"); 
	       add(new JScrollPane(table),BorderLayout.CENTER);//������
	       validate();
	    }
		public static void main(String args[]) 

		 { 
		    
			BorrowInquiry  wo=new BorrowInquiry("��ѯ");
			
		 }
	    }
