import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class CMS extends Frame implements ActionListener
{
	MenuBar mb;
	Menu m1,m2,m3,m4;
	MenuItem m11,m12,m21,m22,m23,m31,m41;
	JLabel l1;
	ImageIcon ii;
	
	public static void main(String s[])
	{
		CMS cm=new CMS();
		cm.job();
	}
	public CMS()
	{
		
		mb=new MenuBar();
		m1=new Menu("Admin");
		m2=new Menu("Registration");
		m3=new Menu("Search");
		m4=new Menu("Help");

		m11=new MenuItem("Login");
		m12=new MenuItem("Change Password");
		m21=new MenuItem("Staff Registration");
		m22=new MenuItem("Faculty Registration");
		m23=new MenuItem("Student Registration");
		m31=new MenuItem("Search");
		m41=new MenuItem("Help");

		ii=new ImageIcon("enmpl.jpg");
		l1=new JLabel(ii);

	}
	public void job()
	{
		setSize(550,550);
		setTitle("Centre Management Software");
		setLayout(new FlowLayout());
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		m2.setEnabled(false);
		m1.add(m11);
		m1.add(m12);
		m2.add(m21);
		m2.add(m22);
		m2.add(m23);
		m3.add(m31);
		m4.add(m41);
		m11.addActionListener(this);
		m12.addActionListener(this);
		m21.addActionListener(this);
		m22.addActionListener(this);
		m23.addActionListener(this);
		m31.addActionListener(this);
		m41.addActionListener(this);
		addWindowListener(new AA());
		setMenuBar(mb);
		add(l1);
		setVisible(true);
	}
		class AA extends WindowAdapter
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==m11)
		{	
			MyForm mf=new MyForm();
			mf.job();
		}
		if(ae.getSource()==m12)
			{
			ChangePass cp=new ChangePass();
			cp.job();
			}
		if(ae.getSource()==m21)
			{
			MyFollow m=new MyFollow();
			m.job();
			}
		if(ae.getSource()==m22)
			{
			MyFollow1 m1=new MyFollow1();
			m1.job();
			}
		if(ae.getSource()==m23)
			{
			MyFollow2 m2=new MyFollow2();
			m2.job();
			}
		if(ae.getSource()==m31)
			{
			Search s1=new Search();
			
			}
		if(ae.getSource()==m41)
			{
			try
			{
				Process p=Runtime.getRuntime().exec("cmd /c Help.txt");
				p.waitFor();
				System.out.println(p.exitValue());
			}
			catch(Exception e){}
			
			}
	}

	class MyForm extends Frame implements ActionListener
	{
		Label l1,l2;
		TextField t1,t2;
		Button b1;
		String s1,s2,str;
		
		public MyForm()
		{
			l1=new Label("EMAIL ID");
			l2=new Label("PASSWORD");
			t1=new TextField(20);
			t2=new TextField(20);
			b1=new Button("OK");
		
		}
		public void job()
		{
			setTitle("ADMIN LOGIN");
			setSize(300,200);
			setLayout(null);
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					dispose();
				}
			});
		
			l1.setBounds(40,40,80,30);
			add(l1);
			l2.setBounds(40,90,80,30);
			add(l2);
			t1.setBounds(135,40,100,20);
			add(t1);		
			t2.setBounds(135,90,100,20);
			add(t2);
			t2.setEchoChar('*');
			b1.setBounds(100,140,100,20);
			add(b1);
			b1.addActionListener(this);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent ae)
		{	                       
			try
			{
				if(ae.getSource()==b1)
				{
					s1=t1.getText();
					s2=t2.getText();
					str="select * from admin";
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
					Statement st=conn.createStatement();
					ResultSet rs;
					int flag=0;
					rs=st.executeQuery(str);
					while(rs.next())
					{
						flag=0;
						String str1=rs.getString("id");
						String str12=rs.getString("pass");
				
						if(s1.equals(str1) && s2.equals(str12))
						{
							flag=1;
							break;
						}
					
					}
					if(flag==1)
					{
						System.out.println("Connection granted");
						m2.setEnabled(true);
						m11.setEnabled(false);
						this.dispose();
					}				
					else
					{
						System.out.println("Connection not granted");	
						this.dispose();
					}
					
				
				}
			
			}
			catch(Exception e)
			{System.out.println(e);}
		}
	
	}
}
