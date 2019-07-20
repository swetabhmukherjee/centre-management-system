import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MyFollow extends Frame implements ActionListener,WindowListener
{                                                                  
	Label l1,l2,l3,l4;
	TextField t1,t2;
	Checkbox c1,c2;
	CheckboxGroup cbg;
	Choice c;
	Button b1;
	String s1,s2,s3,s4,str;
	public static void main(String s[])
	{
		MyFollow mf=new MyFollow();
		mf.job();
	}
	public MyFollow()
	{
		l1=new Label("Name");
		l2=new Label("Address");
		l3=new Label("Gender");
		l4=new Label("Department");
		t1=new TextField(20);
		t2=new TextField(30);
		cbg=new CheckboxGroup();
		c1=new Checkbox("Male",true,cbg);
		c2=new Checkbox("Female",false,cbg);
		c=new Choice();
		c.add("cst");
		c.add("Mechanical");
		c.add("Civil");
		b1=new Button("OK");
		
	}
	public void job()
	{
		setTitle("Staff Registration");
		setSize(400,400);
		setLayout(null);
		addWindowListener(this);
		
		l1.setBounds(40,40,80,30);
		add(l1);
		l2.setBounds(40,90,80,30);
		add(l2);
		l3.setBounds(40,140,80,30);
		add(l3);
		l4.setBounds(40,190,80,30);
		add(l4);

		t1.setBounds(135,40,100,30);
		add(t1);		
		t2.setBounds(135,90,100,30);
		add(t2);
		
		c1.setBounds(135,140,80,30);
		add(c1);
		c2.setBounds(230,140,80,30);
		add(c2);
		c.setBounds(135,190,80,30);
		add(c);
		b1.setBounds(100,240,100,30);
		add(b1);
		b1.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			s1=t1.getText();
			s2=t2.getText();
			if(c1.getState())
				s3=c1.getLabel();
			else
			if(c2.getState())
				s3=c2.getLabel();
			s4=c.getSelectedItem();

			str="Insert into staff values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st=conn.createStatement();
			if(ae.getSource()==b1)
			{
					st.executeUpdate(str);
					t1.setText("");
					t2.setText("");
			}
			
		}
		catch(Exception e)
		{System.out.println(e);}
	}
		
	public void windowClosing(WindowEvent we)
	{
		dispose();
	}
	public void windowClosed(WindowEvent we)
	{ }
	public void windowOpened(WindowEvent we)
	{ }
	public void windowIconified(WindowEvent we)
	{ }
	public void windowDeiconified(WindowEvent we)
	{ }
	public void windowActivated(WindowEvent we)
	{ }
	public void windowDeactivated(WindowEvent we)
	{ }
}