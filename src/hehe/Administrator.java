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
	//TextArea ta;  //�ı���
	MenuBar mb;   //MenuBar ���װ�󶨵���ܵĲ˵�����
	Menu mnLog,mnJy,mnFy,mnLy;  //�Ӳ˵������������ʽ�˵����
	MenuItem mizhuce,milog,miExit,miyhzh,miyhxx;  //�˵��е���������������� MenuItem ��������֮һ	
	MenuItem mifyshow,mifydelete,mifyinsert,mifymodify,milyshow,miyshow,mijyshow,mijyinsert,mijymodify;
	public Administrator(){
		super("ͼ�����ϵͳ");  //���ø��๹�췽��
	//	ta = new TextArea("",20,20);  //�½��ı�������һ��������Ĭ���ı����ڶ���������������������������
		/*
		 * BorderLayout�߿򲼾�
		 * ����ı�����Frame��BorderLayout.CENTER�Ǿ���λ��
		 * */
	//	add(ta,BorderLayout.CENTER);  
		mb = new MenuBar();  //�����˵�������
		/*
		 * �����˵���ָ���˵���
		 * */
		mnLog= new Menu("�˳�");  
		mnFy= new Menu("������Ϣ����");
		mnJy= new Menu("���Ĺ���");
		mnLy= new Menu("���������");
	    /* jLabel=new JLabel("��ӭ�����豸����ϵͳ"); 
	     jLabel.setHorizontalAlignment(JLabel.CENTER); 
	     jLabel.setForeground(Color.red);*/

		
		/*
		 * �����Ӳ˵�����ָ������
		 * */		
		miExit=new MenuItem("�˳�");
		miExit.addActionListener(this);  //Ϊ�˳��˵���Ӽ���
		
		/*
		 * ������洴�����Ӳ˵����ļ��˵���
		 * */		  
		mnLog.add(miExit);//��һ���ָ��߻����ַ���ӵ��˵��ĵ�ǰλ��

        /*
		 * ���miBinary��miFont�����Ӳ˵���mnFormat����ʽ����
		 * */
 
		
		
		mifyshow=new MenuItem("�鿴");
		mifyshow.addActionListener(this);
		mnFy.add(mifyshow);
		milyshow=new MenuItem("����");
		mnLy.add(milyshow);
		milyshow.addActionListener(this);
		miyshow=new MenuItem("�鿴");
		mnLy.add(miyshow);
		miyshow.addActionListener(this);
		
		mijyinsert=new MenuItem("����");
		mijyinsert.addActionListener(this);
		mnJy.add(mijyinsert);
		/*
		 * ���ļ����༭����ʽ��������ӵ��˵���
		 * */
		mb.add(mnLog);
		mb.add(mnJy);
		mb.add(mnFy);
		mb.add(mnLy);
		
		setMenuBar(mb);  //��Ӳ˵�����Frame
		
		/*
		 * �رմ���ʱ���ر����г���
		 * */
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String args[]){
		Administrator tm=new Administrator();
		tm.setSize(700,500);  //���ô���Ŀ���
		tm.setLocation(300,100);  //������Ƶ���λ��Component�෽��
		tm.setVisible(true);  //������ʾ���壬trueΪ��ʾ��falseΪ����
	}
	
	/**
	 * �����¼���ʵ��ActionListener�ӿڵ�actionPerformed����
	 */
	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==miExit){
			System.exit(0);  //ֹͣ���г���
		}
		 if(e.getSource()==mifyshow){
			 ReaderInquiry wo= new ReaderInquiry("�鿴");
		     	 this.setVisible(true);
		 }
		 if(e.getSource()==mijyinsert){
			 ReaderInsert wo= new ReaderInsert("����");
		     	 this.setVisible(true);
		 }
		 if(e.getSource()==milyshow){
			 Message wo= new Message("����");
		     	 this.setVisible(true);
		}
		 if(e.getSource()==miyshow){
			 MessageInquiry wo= new MessageInquiry("�鿴");
		     	 this.setVisible(true);
		}
		
	}}
