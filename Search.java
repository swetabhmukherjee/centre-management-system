import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Search extends Frame implements ActionListener
{
	Checkbox rd1,rd2;
	CheckboxGroup cbg;
	Label l1,l2,l3;
	TextField t1,t2;
	TextArea ta;
	Button jb,jb1;
	JFrame fm=new JFrame();
	String sd,s1,s2,s3,s4,s5,s6,item="rd1",st;
	Connection con;
	ResultSet rs;
	int j=0;
	Statement stmt;
	
	Search()
	{
		setSize(600,400);
		setTitle("Search Student");
		l1=new Label("STUDENT NAME");
		l1.setBounds(5,40,200,20);
		t1=new TextField(20);
		t1.setBounds(220,40,200,20);
		t1.setEnabled(false);

		l2=new Label("STUD ID");
		l2.setBounds(5,80,200,20);
		t2=new TextField(20);
		t2.setBounds(220,80,200,20);
		t2.setEnabled(false);

		jb=new Button("SEARCH");
		//jb.setMnemonic('S');
		jb.setActionCommand("ser");
		jb.addActionListener(this);
		jb.setBounds(210,120,200,25);

		jb1=new Button("RESET");
		//jb1.setMnemonic('R');
		jb1.setActionCommand("r");
		jb1.addActionListener(this);
		jb1.setBounds(5,120,200,25);
		
		l3=new Label("Result:");
		l3.setBounds(5,160,75,25);

		ta=new TextArea(10,20);
		ta.setBounds(100,160,400,200);

		cbg=new CheckboxGroup();
		rd1=new Checkbox("Student Name",false,cbg);
		//rd1.setActionCommand("rd1");
		rd1.addItemListener(new RB());
		rd1.setBounds(180,0,100,15);
		
		rd2=new Checkbox("Student ID",false,cbg);
		//rd2.setActionCommand("rd2");
		rd2.addItemListener(new RD());
		rd2.setBounds(180,15,200,15);

		Panel jp=new Panel();
		jp.setLayout(null);
		jp.add(l1);
		jp.add(t1);
		jp.add(l2);
		jp.add(t2);
		jp.add(jb1);
		jp.add(jb);
		jp.add(rd1);
		jp.add(rd2);
		jp.add(l3);
		jp.add(ta);
		add(jp);
		addWindowListener(new WIND());
		setVisible(true);
		
	}

	class RB implements ItemListener
	{
		public void itemStateChanged(ItemEvent i1)
		{
			if(cbg.getSelectedCheckbox()==rd1)
			{
			item="rd1";
			t1.setEnabled(true);
			t2.setEnabled(false);
			t1.setText("");
			}
		}

	}

	class RD implements ItemListener
	{
		public void itemStateChanged(ItemEvent i1)
		{
			if(cbg.getSelectedCheckbox()==rd2)
			{
			item="rd2";
			t2.setEnabled(true);
			t1.setEnabled(false);
			t2.setText("");
			}
		}
	}

/*===========================SEARCH BUTTON=============================*/

	public void actionPerformed(ActionEvent t)
	{

		String sd=(String)t.getActionCommand();
		s1=t1.getText();
		//s1=s1.toLowerCase();
		s2=t2.getText();
		//s2=s2.toLowerCase();

		if(sd.equals("ser"))
		{
			
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			}
			catch(Exception ee)
			{
			}

			try
			{
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				con.setAutoCommit(false);
			}
			catch(Exception sqe)
			{
			}

			if((item.equals("rd1") && (s1==null||s1.equals(""))) || (item.equals("rd2") && (s2==null||s2.equals(""))))
			{
				try
				{
					con.rollback();
					con.close();
					JOptionPane.showMessageDialog(fm,"INPUT FIELD WITHOUT DATA !");

				}
				catch(Exception g)
				{
				}
			}

			else
			{
				if(item.equals("rd1"))
				{
					//s4=s2;
					
					try
					{
						ta.setText("");
						stmt=con.createStatement();
						rs=stmt.executeQuery("select Name,Course from student where Name='"+s1+"'");
						while(rs.next())
						{
							s3=rs.getString("Name");
							s4=rs.getString("Course");
							s5=s3+"      "+s4;
							if(s1.equals(s3))
							{
								ta.append(s5+"\n");
								j++;
							}
						}

						rs.close();
						stmt.close();
						con.close();
					}
					catch(Exception m)
					{
					}
				}

				if(item.equals("rd2"))
				{
					//s4=s2;
					
					try
					{
						ta.setText("");
						stmt=con.createStatement();
						rs=stmt.executeQuery("select Name,Course,MobileNo from student where MobileNo='"+s2+"'");
						while(rs.next())
						{
							s3=rs.getString("Name");
							s4=rs.getString("Course");
							s6=rs.getString("MobileNo");
							s5=s3+"      "+s4;
							if(s2.equals(s6))
							{
								ta.append(s5+"\n");
								j++;
							}
						}
						rs.close();
						stmt.close();
						con.close();
					}
					catch(Exception m)
					{
					}
				}

				if((s3==null)||(s4==null)||(s3.equals(""))||(s4.equals("")))
				{
					JOptionPane.showMessageDialog(fm," Student NOT FOUND !");
					j=0;
					s3=null;
					s4=null;
				}

				if(s3!=null)
				{
					JOptionPane.showMessageDialog(fm," Student FOUND ! \nNumber of Students found = "+j);
					j=0;
					s3=null;
					s4=null;
				}
				
			}
		}
/*===========================RESET BUTTON=============================*/

		if(sd.equals("r"))
		{
			rd1.setState(true);
			rd2.setState(false);
			t1.setText("");
			t1.setEnabled(true);
			t2.setText("");
			t2.setEnabled(false);
			ta.setText("");
			
		}

	}

/*===========================WINDOW CLOSING EVENT=============================*/

	private class WIND extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			
			dispose();
			
			
		}
	}
public static void main(String s[])
{
	Search sc=new Search();
	
}
	
}

