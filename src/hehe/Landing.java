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
	public JFrame jf= new JFrame("图书管理系统系统"); 
	public Container con = jf.getContentPane();  
	public Toolkit toolkit = Toolkit.getDefaultToolkit();  //获取工具包
	public Dimension sc = toolkit.getScreenSize();  //getScreenSize(),最后的这个方法返回一个Dimension类型的对象.是返回当先分辨率的.

	Object a,b; 

	public JRadioButton rb1 = new JRadioButton("读者"); 
	public JRadioButton rb2 = new JRadioButton("管理员"); 
	public ButtonGroup group = new ButtonGroup (); 
	public JLabel yong_hu = new JLabel("用户名");  
	public JLabel mi_ma = new JLabel("密码"); 
	public JTextField textName = new JTextField();  
	public JPasswordField textPs = new JPasswordField();  
	public JButton deng_ru = new JButton("登陆");  
	public JButton qu_xiao = new JButton("取消");  
	public Font font1 = new Font("宋体",1,14);  
	public Font font2 = new Font("宋体",0,12); 
	public Landing() { 
	//con.setLayout(null); 
	//jf.setSize(sc.width/1,sc.height/2);  //大小
	/*jf.setLocation(sc.width/5,sc.height/1010); */         /* public void setLocation(int x,
	                            int y)将组件移到新位置。通过此组件父级坐标空间中的 x 和 y 参数来指定新位置的左上角。 参数：
	                          x - 父级坐标空间中新位置左上角的 x 坐标y - 父级坐标空间中新位置左上角的 y 坐标*/
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
	yong_hu.setLocation(80,30);  //位置
	yong_hu.setSize(100, 100);  //大小
	yong_hu.setFont(font1);   //设置字体
	yong_hu.setForeground(Color.BLUE );//设置颜色  
	rb1.setLocation(80,180);  //位置
	rb1.setSize(65,20);  //大小
	rb2.setLocation(250,180);  //位置
	rb2.setSize(80,20);  //大小
	mi_ma.setLocation(80,90);  
	mi_ma.setSize(100,100);   
	mi_ma.setForeground(Color.BLUE ) ; 
	mi_ma.setFont(font1);  
	textName.setSize(140, 20);  
	textName.setLocation(170, 70) ; 
	textPs.setSize(140, 20);  
	textPs.setLocation(170, 130) ;  
	//textPs.setEchoChar('*');    //返回※
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
					 rs=sql.executeQuery("select * from 管理员信息表 where 用户名='"+a+"'");
					 boolean min=rs.next();
					 if(!min){
						// System.out.print("用户名错误");
			            //	JOptionPane.showMessageDialog(this,"用户名或密码错误");
						 JOptionPane.showMessageDialog(null,"用户名或密码错误");
					 }
					 
					 if(min){	            	
			                 dx=rs.getString(2);     
			           }
					// ((String) dx).trim();
					// ((String) b).trim();
			            if(!dx.equals(b)){
			            
			            	JOptionPane.showMessageDialog(null,"用户名或密码错误");
			            }
			            if(dx.equals(b)){
			            	
			            	
			            	JOptionPane.showMessageDialog(null,"登入成功");
		                           
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
				 rs=sql.executeQuery("select * from 读者信息表 where 用户名='"+a+"'");
				 boolean min=rs.next();
				 if(!min){
					 JOptionPane.showMessageDialog(null,"用户名或密码错误");
				 }
				 
				 if(min){	            	
		                 dx=rs.getString(2);     
		           }
				// ((String) dx).trim();
				// ((String) b).trim();
		            if(!dx.equals(b)){
		            
		            	JOptionPane.showMessageDialog(null,"用户名或密码错误");
		            }
		            if(dx.equals(b)){
		            	
		            	
		            	JOptionPane.showMessageDialog(null,"登入成功");
	                           

		            	 Reader n=new Reader();
			  	          n.setSize(500, 300);
			  	          n.setVisible(true); //设置显示窗体
		            	
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
