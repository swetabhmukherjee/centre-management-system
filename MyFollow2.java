import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MyFollow2 extends Frame implements ActionListener,WindowListener
{                                                                  
	Label l1,l2,l3,l4,l5;
	TextField t1,t2,t3;
	Checkbox c1,c2;
	CheckboxGroup cbg;
	Choice c;
	Button b1;
	String s1,s2,s3,s4,s5,str;
	public static void main(String s[])
	{
		MyFollow2 mf2=new MyFollow2();
		mf2.job();
	}
	public MyFollow2()
	{
		l1=new Label("Student Name");
		l2=new Label("Course Name");
		l3=new Label("Gender");
		l4=new Label("Father's Name");
		l5=new Label("Mobile No");
		t1=new TextField(30);
		t2=new TextField(30);
		t3=new TextField(30);
		cbg=new CheckboxGroup();
		c1=new Checkbox("Male",true,cbg);
		c2=new Checkbox("Female",false,cbg);
		c=new Choice();
		c.add("BCA");
		c.add("MCA");
		c.add("BBA");
		c.add("MBA");
		b1=new Button("Submit");
		
	}
	public void job()
	{
		setTitle("Student Registration");
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
		l5.setBounds(40,240,80,30);
		add(l5);

		t1.setBounds(135,40,100,30);
		add(t1);		
		t2.setBounds(135,190,100,30);
		add(t2);
		t3.setBounds(135,240,100,30);
		add(t3);
		
		c1.setBounds(135,140,80,30);
		add(c1);
		c2.setBounds(230,140,80,30);
		add(c2);
		c.setBounds(135,90,80,30);
		add(c);
		b1.setBounds(100,290,100,30);
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
			s3=t3.getText();
			if(c1.getState())
				s4=c1.getLabel();
			else
			if(c2.getState())
				s4=c2.getLabel();
			s5=c.getSelectedItem();

			str="Insert into student values('"+s1+"','"+s5+"','"+s4+"','"+s2+"','"+s3+"')";

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st=conn.createStatement();
			if(ae.getSource()==b1)
			{
					st.executeUpdate(str);
					t1.setText("");
					t2.setText("");
					t3.setText("");
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