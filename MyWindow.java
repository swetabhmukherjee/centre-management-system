import java.awt.*;
public class MyWindow extends Frame
{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1;
	public static void main(String s[])
	{
		MyWindow m1=new MyWindow();
		m1.job();
	}
	public MyWindow()
	{
		l1=new Label("Name");
		l2=new Label("Password");
		l3=new Label("Confirm Password");
		t1=new TextField(20);
		t2=new TextField(20);
		t3=new TextField(20);
		b1=new Button("Submit");
	}
	public void job()
	{
		setTitle("My First Window Appl");
		setSize(200,350);
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(l2);
		t2.setEchoChar('*');
		add (t2);
		add(l3);
		t3.setEchoChar('*');
		add(t3);
		add(b1);
		setResizable(false);
		setVisible(true);
	}
}
