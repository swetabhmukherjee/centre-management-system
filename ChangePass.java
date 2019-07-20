import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ChangePass extends Frame implements ActionListener
{
	Label l1,l2,l3,l4;
	TextField tf1,tf2,tf3,tf4;
	Button b1;
	String s1,s2,s3,s4,str;
	public static void main(String s[])
	{
		ChangePass mf=new ChangePass();
		mf.job();
	}
	public ChangePass()
	{
		l1=new Label("EMAIL ID:");
		l2=new Label("OLD PASSWORD");
		l3=new Label("NEW PASSWORD");
		l4=new Label("CONFIRM PASSWORD");
		tf1=new TextField(20);
		tf2=new TextField(20);
		tf3=new TextField (20);
		tf4=new TextField (20);
		b1=new Button("CHANGE");

	}
	public void job()
	{
		setTitle("CHANGE PASSWORD");
		setSize(300,300);
		setLayout(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		
		l1.setBounds(40,40,75,25);
		add(l1);
		l2.setBounds(40,90,75,25);
		add(l2);
	                   l3.setBounds(40,140,75,25);
		add(l3);		
		l4.setBounds(40,190,75,25);
		add(l4);
		
		tf1.setBounds(135,40,100,25);
		add(tf1);
		tf2.setBounds(135,90,100,25);
		add(tf2);
		tf2.setEchoChar('*');
		tf3.setBounds(135,140,100,25);
		add(tf3);
		tf3.setEchoChar('*');
		tf4.setBounds(135,190,100,25);
		add(tf4);
		tf4.setEchoChar('*');
		b1.setBounds(100,240,100,25);
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
				s1=tf1.getText();
				s2=tf2.getText();
				s3=tf3.getText();
				s4=tf4.getText();
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
				if(flag==1 && s3.equals(s4))
				{
					str="update admin set pass='"+s3+"' where id='"+s1+"'";
					st.executeUpdate(str);
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