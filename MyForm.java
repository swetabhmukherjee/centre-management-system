import java.awt.*;
import java.awt.event.*;
class Password extends Frame implements WindowListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b1;
	public static void main(String s[])
	{
		Password mf=new Password();
		mf.job();
	}
	public Password()
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
		addWindowListener(this);
		
		l1.setBounds(40,40,80,30);
		add(l1);
		l2.setBounds(40,90,80,30);
		add(l2);
		t1.setBounds(135,40,100,20);
		add(t1);		
		t2.setBounds(135,90,100,20);
		add(t2);
		b1.setBounds(100,140,100,20);
		add(b1);
		setVisible(true);
	}
		
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
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