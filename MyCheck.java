import java.awt.*;
public class MyCheck extends Frame
{
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField t1,t2,t3;
	Checkbox c1,c2,c3,c4,c5;
	CheckboxGroup cbg;
	List l;
	Choice c;
	Button b;
	public static void main(String s[])
	{
		MyCheck cm=new MyCheck();
		cm.job();
	}
	public MyCheck()
	{
		l1=new Label("Name");
		l2=new Label("Password");
		l3=new Label("Confirm Password");
		l4=new Label("Gender");
		l5=new Label("Educational Qualification");
		l6=new Label("List Of Paper");
		l7=new Label("Hobbies");
		t1=new TextField(20);
		t2=new TextField(20);
		t3=new TextField(20);
		cbg=new CheckboxGroup();
		c1=new Checkbox("Male",false,cbg);
		c2=new Checkbox("Female",false,cbg);
		c3=new Checkbox("Cooking");
		c4=new Checkbox("Riding");
		c5=new Checkbox("Fishing");
		l=new List(4,false);
		l.add("Engeneering Drawing");
		l.add("Digital Logic");
		l.add("Java");
		l.add("C++");
		c=new Choice();
		c.add("Graduation");
		c.add("Post Graduation");
		c.add("Diploma");
		c.add("Doctrate");
		b=new Button("Ok");
	}
	public void job()
	{
		setTitle("MyLayout");
		setSize(700,700);
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(c1);
		add(c2);
		add(l5);
		add(c);
		add(l6);
		add(l);
		add(l7);
		add(c3);
		add(c4);
		add(c5);
		add(b);
		setVisible(true);
	}
}
		