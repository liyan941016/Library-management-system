package hehe;


	import java.awt.Color; 
	import java.awt.Container; 
	import java.awt.Dimension; 
	import java.awt.Font; 
	import java.awt.Toolkit; 
	import java.awt.Image;  
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.swing.ButtonGroup;
	import javax.swing.ImageIcon; 
	import javax.swing.JButton; 
	import javax.swing.JFrame; 
	import javax.swing.JLabel;  
	import javax.swing.JOptionPane;
	import javax.swing.JPasswordField; 
	import javax.swing.JRadioButton;
	import javax.swing.JTextField; 

	public class Landing implements ActionListener{ 
	public JFrame jf= new JFrame("ͼ�����ϵͳϵͳ"); 
	public Container con = jf.getContentPane();  
	public Toolkit toolkit = Toolkit.getDefaultToolkit();  //��ȡ���߰�
	public Dimension sc = toolkit.getScreenSize();  //getScreenSize(),���������������һ��Dimension���͵Ķ���.�Ƿ��ص��ȷֱ��ʵ�.

	Object a,b; 

	public JRadioButton rb1 = new JRadioButton("����"); 
	public JRadioButton rb2 = new JRadioButton("����Ա"); 
	public ButtonGroup group = new ButtonGroup (); 
	public JLabel yong_hu = new JLabel("�û���");  
	public JLabel mi_ma = new JLabel("����"); 
	public JTextField textName = new JTextField();  
	public JPasswordField textPs = new JPasswordField();  
	public JButton deng_ru = new JButton("��½");  
	public JButton qu_xiao = new JButton("ȡ��");  
	public Font font1 = new Font("����",1,14);  
	public Font font2 = new Font("����",0,12); 
	public Landing() { 
	//con.setLayout(null); 
	//jf.setSize(sc.width/1,sc.height/2);  //��С
	/*jf.setLocation(sc.width/5,sc.height/1010); */         /* public void setLocation(int x,
	                            int y)������Ƶ���λ�á�ͨ���������������ռ��е� x �� y ������ָ����λ�õ����Ͻǡ� ������
	                          x - ��������ռ�����λ�����Ͻǵ� x ����y - ��������ռ�����λ�����Ͻǵ� y ����*/
	con.setLayout(null);  
	group.add(rb1);  
	group.add(rb2);  


	deng_ru.addActionListener(this);
	qu_xiao.addActionListener(this);
	rb1.addActionListener(this);  
	rb2.addActionListener(this);  
	jf.setSize(/*sc.width/3*/500,sc.height/2);  
	jf.setLocation(sc.width/3,sc.height/4); 
	jf.setResizable(false);    
	yong_hu.setLocation(80,30);  //λ��
	yong_hu.setSize(100, 100);  //��С
	yong_hu.setFont(font1);   //��������
	yong_hu.setForeground(Color.BLUE );//������ɫ  
	rb1.setLocation(80,180);  //λ��
	rb1.setSize(65,20);  //��С
	rb2.setLocation(250,180);  //λ��
	rb2.setSize(80,20);  //��С
	mi_ma.setLocation(80,90);  
	mi_ma.setSize(100,100);   
	mi_ma.setForeground(Color.BLUE ) ; 
	mi_ma.setFont(font1);  
	textName.setSize(140, 20);  
	textName.setLocation(170, 70) ; 
	textPs.setSize(140, 20);  
	textPs.setLocation(170, 130) ;  
	//textPs.setEchoChar('*');    //���ء�
	deng_ru.setSize(90,25);  
	deng_ru.setLocation(80,220 ) ;
	deng_ru.setFont(font2);
	qu_xiao.setSize(90,25) ; 
	qu_xiao.setLocation(250, 220) ;

	qu_xiao.setFont(font2) ;   
	con.add(rb1) ; 
	con.add(rb2) ;  
	con.add(yong_hu) ; 
	con.add(mi_ma) ; 
	con.add(textName);  
	con.add(textPs);  
	con.add(deng_ru);  
	con.add(qu_xiao);   
	con.setBackground(Color.WHITE);    
	jf.setResizable(false);  
	jf.setVisible(true) ;  
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  


	}  
	   
	public void actionPerformed(ActionEvent e) 
	{ 
		Object dx;
		Connection con;
		Statement sql;
		ResultSet rs;
		
		  if(group.getSelection()==rb2.getModel()){  
			if(e.getSource()==deng_ru)
			{
				a=textName.getText();
			     char[]c=textPs.getPassword();
			     b= new String(c);

			     try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
					catch(ClassNotFoundException ee){System.out.println(""+e);}
					try{con=DriverManager.getConnection("jdbc:odbc:hehe","","");
					    sql=con.createStatement();
					
					 dx=new Object[1];
					 rs=sql.executeQuery("select * from ����Ա��Ϣ�� where �û���='"+a+"'");
					 boolean min=rs.next();
					 if(!min){
						// System.out.print("�û�������");
			            //	JOptionPane.showMessageDialog(this,"�û������������");
						 JOptionPane.showMessageDialog(null,"�û������������");
					 }
					 
					 if(min){	            	
			                 dx=rs.getString(2);     
			           }
					// ((String) dx).trim();
					// ((String) b).trim();
			            if(!dx.equals(b)){
			            
			            	JOptionPane.showMessageDialog(null,"�û������������");
			            }
			            if(dx.equals(b)){
			            	
			            	
			            	JOptionPane.showMessageDialog(null,"����ɹ�");
		                           
			            	  Reader n=new Reader();
				  	          n.setSize(500, 300);
				  	          n.setVisible(true);
			            	
			            }
			            }
			            catch(SQLException ee){ 
			     	        System.out.println(ee);
			     	       }
					if(e.getSource()==qu_xiao){
						System.exit(0);
					}
		
		           }  }
	        if(group.getSelection()==rb1.getModel()){   
		    if(e.getSource()==deng_ru)
		    {
			a=textName.getText();
		     char[]c=textPs.getPassword();
		     b= new String(c);

		     try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
				catch(ClassNotFoundException ee){System.out.println(""+e);}
				try{con=DriverManager.getConnection("jdbc:odbc:hehe","","");
				    sql=con.createStatement();
				 dx=new Object[1];
				 rs=sql.executeQuery("select * from ������Ϣ�� where �û���='"+a+"'");
				 boolean min=rs.next();
				 if(!min){
					 JOptionPane.showMessageDialog(null,"�û������������");
				 }
				 
				 if(min){	            	
		                 dx=rs.getString(2);     
		           }
				// ((String) dx).trim();
				// ((String) b).trim();
		            if(!dx.equals(b)){
		            
		            	JOptionPane.showMessageDialog(null,"�û������������");
		            }
		            if(dx.equals(b)){
		            	
		            	
		            	JOptionPane.showMessageDialog(null,"����ɹ�");
	                           

		            	 Reader n=new Reader();
			  	          n.setSize(500, 300);
			  	          n.setVisible(true); //������ʾ����
		            	
		            }
		            }
		            catch(SQLException ee){ 
		     	        System.out.println(ee);
		     	       }
		}
		
		} 



	}
	public static void main(String[] args) {
		  new Landing();
	}
	}
