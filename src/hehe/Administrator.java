package hehe;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Administrator extends Frame implements ActionListener{
	//TextArea ta;  //文本区
	MenuBar mb;   //MenuBar 类封装绑定到框架的菜单栏的
	Menu mnLog,mnJy,mnFy,mnLy;  //从菜单栏部署的下拉式菜单组件
	MenuItem mizhuce,milog,miExit,miyhzh,miyhxx;  //菜单中的所有项必须属于类 MenuItem 或其子类之一	
	MenuItem mifyshow,mifydelete,mifyinsert,mifymodify,milyshow,miyshow,mijyshow,mijyinsert,mijymodify;
	public Administrator(){
		super("图书管理系统");  //调用父类构造方法
	//	ta = new TextArea("",20,20);  //新建文本区，第一个参数是默认文本，第二个参数是行数，第三个是列数
		/*
		 * BorderLayout边框布局
		 * 添加文本区到Frame，BorderLayout.CENTER是居中位置
		 * */
	//	add(ta,BorderLayout.CENTER);  
		mb = new MenuBar();  //创建菜单栏对象
		/*
		 * 创建菜单，指定菜单名
		 * */
		mnLog= new Menu("退出");  
		mnFy= new Menu("读者信息管理");
		mnJy= new Menu("借阅管理");
		mnLy= new Menu("意见簿留言");
	    /* jLabel=new JLabel("欢迎进入设备管理系统"); 
	     jLabel.setHorizontalAlignment(JLabel.CENTER); 
	     jLabel.setForeground(Color.red);*/

		
		/*
		 * 创建子菜单，并指定名称
		 * */		
		miExit=new MenuItem("退出");
		miExit.addActionListener(this);  //为退出菜单添加监听
		
		/*
		 * 添加上面创建的子菜单到文件菜单下
		 * */		  
		mnLog.add(miExit);//将一个分隔线或连字符添加到菜单的当前位置

        /*
		 * 添加miBinary、miFont两个子菜单到mnFormat（格式）下
		 * */
 
		
		
		mifyshow=new MenuItem("查看");
		mifyshow.addActionListener(this);
		mnFy.add(mifyshow);
		milyshow=new MenuItem("留言");
		mnLy.add(milyshow);
		milyshow.addActionListener(this);
		miyshow=new MenuItem("查看");
		mnLy.add(miyshow);
		miyshow.addActionListener(this);
		
		mijyinsert=new MenuItem("借书");
		mijyinsert.addActionListener(this);
		mnJy.add(mijyinsert);
		/*
		 * 将文件、编辑、格式、帮助添加到菜单栏
		 * */
		mb.add(mnLog);
		mb.add(mnJy);
		mb.add(mnFy);
		mb.add(mnLy);
		
		setMenuBar(mb);  //添加菜单栏到Frame
		
		/*
		 * 关闭窗口时，关闭运行成语
		 * */
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String args[]){
		Administrator tm=new Administrator();
		tm.setSize(700,500);  //设置窗体的宽、高
		tm.setLocation(300,100);  //将组件移到新位置Component类方法
		tm.setVisible(true);  //设置显示窗体，true为显示，false为隐藏
	}
	
	/**
	 * 监听事件，实现ActionListener接口的actionPerformed方法
	 */
	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==miExit){
			System.exit(0);  //停止运行程序
		}
		 if(e.getSource()==mifyshow){
			 ReaderInquiry wo= new ReaderInquiry("查看");
		     	 this.setVisible(true);
		 }
		 if(e.getSource()==mijyinsert){
			 ReaderInsert wo= new ReaderInsert("借书");
		     	 this.setVisible(true);
		 }
		 if(e.getSource()==milyshow){
			 Message wo= new Message("留言");
		     	 this.setVisible(true);
		}
		 if(e.getSource()==miyshow){
			 MessageInquiry wo= new MessageInquiry("查看");
		     	 this.setVisible(true);
		}
		
	}}
