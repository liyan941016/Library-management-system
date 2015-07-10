package hehe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 
	@SuppressWarnings("serial")
	public class ReaderInquiry extends JDialog implements ActionListener{//负责显示记录的类
		 JTable  table;//表格
	    Object a[][];
	    Object name[]={" 用户名","密码" };
	    JButton S; 
	    Connection con;
	    Statement sql; 
	    ResultSet rs;
	    ReaderInquiry(String title){  
	 	   setTitle(title);
	       S=new JButton("显示");
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
	            rs=sql.executeQuery("select * from  读者信息表");
	            rs.last();
	            int lastNumber=rs.getRow();
	            a=new Object[lastNumber][2];
	            int k=0;
	            rs.beforeFirst();
	            while(rs.next()){
	            	
	                 a[k][0]=rs.getString(1);
	                 a[k][1]=rs.getString(2);  
	    
	                 k++;
	                
	           }
	           con.close();
	       // System.out.print("连接失败"); 
	       }  
	       catch(SQLException ee){ 
	    	  // System.out.print("连接失败"); 
	           System.out.println(ee);
	       } 
	       table=new JTable(a,name);
	    getContentPane().removeAll();
	       add(S,BorderLayout.NORTH);
	      // System.out.print("连接失败"); 
	       add(new JScrollPane(table),BorderLayout.CENTER);//滚动条
	       validate();
	    }
		public static void main(String args[]) 

		 { 
		    
			ReaderInquiry  wo=new ReaderInquiry("查询");
			
		 }
	    }
