import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.sql.*;
public class MovieTicket
{
    public static void main(String[] args)
    {
		MyFrame f1 = new MyFrame();
	    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MyFrame extends JFrame
{
	JTextField t1,t2;
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	JPasswordField ps1;
	JPanel p1;
	JCheckBox c1;
	JButton b1,b2;
	Connection con;
	Statement st;
	ResultSet rs;
	
	public MyFrame()
	{
		try
		{
		setVisible(true);
		setTitle("Login Page");
		setResizable(true);
		setSize(1000,500);
		constructUI();
		designUI();
		handleEvent();
		
		makeConnection();
		rs=st.executeQuery("Select * from login");
		rs.first();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void constructUI()
	{
		ps1 = new JPasswordField(10);
		t1 = new JTextField(10);
		p1 = new JPanel();
		l = new JLabel("LOGIN");
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");
		l3 = new JLabel("MOVIE TICKET BOOKING ");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Cambria Math",Font.PLAIN,30));
		c1 = new JCheckBox("Show password");
		b1 = new JButton("Submit");
		b2 = new JButton("Sign UP");
		l4=new JLabel(new ImageIcon("C:\\Users\\BAALAJI\\Desktop\\java project\\Movie ticket\\6.jpg"));
		l5 = new JLabel("T BAALAJI - 20BCS089");
		l5.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
		l6 = new JLabel("KJ CHANDRU - 20BCS093 ");
		l6.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
		l7 = new JLabel("K JEYANTH BALAJI - 20BCS102");
		l7.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
	} 
	public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	 public void designUI()
	{
		getContentPane().add(l,BorderLayout.CENTER);
		getContentPane().add(l1,BorderLayout.CENTER);
		getContentPane().add(l2,BorderLayout.CENTER);
		getContentPane().add(l3,BorderLayout.CENTER);
		getContentPane().add(l5,BorderLayout.CENTER);
		getContentPane().add(l6,BorderLayout.CENTER);
		getContentPane().add(l7,BorderLayout.CENTER);
		getContentPane().add(t1,BorderLayout.CENTER);
		getContentPane().add(ps1,BorderLayout.CENTER);
		getContentPane().add(c1,BorderLayout.CENTER);
		getContentPane().add(b1,BorderLayout.CENTER);
		getContentPane().add(b2,BorderLayout.CENTER);
		l.setBounds(780,40,100,80);
		l3.setBounds(650,30,350,50);
		l1.setBounds(600,120,100,70);
		l5.setBounds(100,450,500,70);
		l6.setBounds(100,480,500,70);
		l7.setBounds(100,510,500,70);
		t1.setBounds(700,130,200,40);
		l2.setBounds(600,200,100,70);
		ps1.setBounds(700,205,200,40);
		c1.setBounds(700,255,150,40);
		b1.setBounds(600,300,200,40);
		b2.setBounds(860,300,200,40);
		p1.add(l4);
		add(p1);
		
	}
	public void handleEvent()
	{
		c1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				if(ie.getSource() == c1)
				{
					if (c1.isSelected() )
					{
						ps1.setEchoChar((char) 0);
					}
					else
						ps1.setEchoChar('*');
				}
			}
		});
	
	b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			try
			{
				rs.first();int flag =0;
				do{
					if (rs.getString(1).equals(t1.getText()) && rs.getString(2).equals(ps1.getText()))
					{
			MyFrame2 f2=new MyFrame2();
			flag=1;
			rs.first();
			break;
					}
				}
				while(rs.next());
				if(flag==0)
					JOptionPane.showMessageDialog(null," User is wrong");
			}
			catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
	});
	b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			SignUp f1 =new SignUp();
		}
	});
	}
}
 class New1
{
    public static void main(String[] args)
    {
		MyFrame f1 = new MyFrame();
	//MyFrame f2= new MyFrame();
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
class MyFrame2 extends JFrame
{   JLabel l1,l2,l3,l4;
	JButton b1,b2,b3;
	JPanel p1;
	//JScrollPane sp;
	MyFrame2()
	{

		setVisible(true);
		setTitle("Ticket1");
		setResizable(true);
		setSize(1000,1000);
		constructUI();
		designUI();
		handleevents();
	}		
	public void constructUI()
	{
		b1= new JButton("BOOK NOW");
		b2= new JButton("BOOK NOW");
		b3= new JButton("BOOK NOW");
		l1 = new JLabel(new ImageIcon("C:\\Users\\BAALAJI\\Desktop\\java project\\Movie ticket\\pic2.jpg"));
		l2 = new JLabel(new ImageIcon("C:\\Users\\BAALAJI\\Desktop\\java project\\Movie ticket\\pic1.jpg"));
		l3 = new JLabel(new ImageIcon("C:\\Users\\BAALAJI\\Desktop\\java project\\Movie ticket\\pic3.jpg"));
		l4 = new JLabel(new ImageIcon("C:\\Users\\BAALAJI\\Desktop\\java project\\Movie ticket\\6.jpg"));
		p1= new JPanel();
		//sp=new JScrollPane(p1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
	public void designUI()
	{
		getContentPane().add(l1,BorderLayout.CENTER);
		getContentPane().add(l2,BorderLayout.CENTER);
		getContentPane().add(l3,BorderLayout.CENTER);
		getContentPane().add(b1,BorderLayout.CENTER);
		getContentPane().add(b2,BorderLayout.CENTER);
		getContentPane().add(b3,BorderLayout.CENTER);
		l1.setBounds(50,50,450,600);
		l2.setBounds(550,50,450,600);
		l3.setBounds(1050,50,450,600);
		b1.setBounds(50,670,450,70);
		b2.setBounds(550,670,450,70);
		b3.setBounds(1050,670,450,70);
		p1.add(l4);
		//add(sp);
		add(p1);
	}
	void handleevents()
	{
	b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			MyFrame3 f2=new MyFrame3();
		}
	});
	b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			MyFrame3 f2=new MyFrame3();
		}
	});
	b3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			MyFrame3 f2=new MyFrame3();
		}
	});
	}
}


class MyFrame3 extends JFrame
{ 
    JPanel p;
	JLabel l1,l2,l3,l4,l5;
	JComboBox c1,c2,c3;
	JTextField t2,t1;
	JRadioButton r1,r2,r3,r4,r5;
	JButton b1,b2;
	Connection con;
	Statement st;
	ResultSet rs;
	MyFrame3()
	{
		try {
		setVisible(true);
		setTitle("Ticket1");
		setResizable(true);
		setSize(1000,500);
		constructUI();
		designUI();
		handleevent();
		makeConnection();
		rs=st.executeQuery("Select * from bookingdetails");
		rs.first();
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	
	public void constructUI()
	{
		c1= new JComboBox();
		//c2= new JComboBox();
		//c3= new JComboBox();
		l1= new JLabel("SHOW TIMING");
		l1.setForeground(Color.WHITE);
		l2= new JLabel("NO.Of TICKETS");
		l2.setForeground(Color.WHITE);
		l3 = new JLabel(new ImageIcon("\\Movie ticket\\13.jpg"));
		l4= new JLabel("RS.");
		l4.setForeground(Color.WHITE);
		b1= new JButton("PAY");
		b2=new JButton("Confirm Booking");
		//r1= new JRadioButton("1");
		//r1.setForeground(Color.BLACK);
		//r2= new JRadioButton("2");
		//r3= new JRadioButton("3");
		//r4= new JRadioButton("4");
		//r5= new JRadioButton("5");
		//r2= new JLabel("2");
		t2= new JTextField(10);
		t1= new JTextField(10);
		t1.setEnabled(false);
		p= new JPanel();
	}
	public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	public void designUI()
	{
		//String[] times = {"10:00 A.M","03:00 P.M","09:00 P.M"};
		//for(int i = 0; i< times.length ; i++ )
			//c1.addItem(times[i]);
		c1.addItem("10:30 AM");
		c1.addItem("3:00 PM");
		c1.addItem("9:00 PM");
		//c2.addItem("4");
		//c2.addItem("5");
		//c3.addItem("Child");
		//c3.addItem("Adult");
		getContentPane().add(l1,BorderLayout.CENTER);
		getContentPane().add(l2,BorderLayout.CENTER);
		getContentPane().add(l4,BorderLayout.CENTER);
		getContentPane().add(b1,BorderLayout.CENTER);
		getContentPane().add(b2,BorderLayout.CENTER);
		//getContentPane().add(l3,BorderLayout.NORTH);
		getContentPane().add(c1,BorderLayout.CENTER);
		getContentPane().add(t2,BorderLayout.CENTER);
		getContentPane().add(t1,BorderLayout.CENTER);
		/*p.add(r1);
		getContentPane().add(r1,BorderLayout.CENTER);
		p.add(r2);
		getContentPane().add(r2,BorderLayout.CENTER);
		p.add(r3);
		getContentPane().add(r3,BorderLayout.CENTER);
		p.add(r4);
		getContentPane().add(r4,BorderLayout.CENTER);
		p.add(r5);
		getContentPane().add(r5,BorderLayout.CENTER);
		//getContentPane().add(c3,BorderLayout.CENTER);*/
		l1.setBounds(200,150,100,70);
		l2.setBounds(500,150,100,70);
		t2.setBounds(500,200,100,35);
		l4.setBounds(470,300,100,70);
		b1.setBounds(200,300,150,50);
		b2.setBounds(200,400,475,50);
		//l3.setBounds(150,50,100,70);
		c1.setBounds(200,200,150,35);
		//c2.setBounds(500,200,150,35);
		t1.setBounds(500,310,150,35);
		//r1.setBounds(500,200,50,20);
		//r2.setBounds(550,200,50,20);
		//r3.setBounds(600,200,50,20);
		//r4.setBounds(650,200,50,20);
		//r5.setBounds(700,200,50,20);
		//c3.setBounds(900,100,150,25);
		p.add(l3);
		//p.add(r1);
		//p.add(r2);
		//p.add(r3);
		//p.add(r4);
		//p.add(r5);
		add(p);
	}
	public void handleevent()
	{
		b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		int x = Integer.parseInt(t2.getText());
		x*=120;
		t1.setText(x+"");
	}});
	/*b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		try{
				if ("".equals(t1.getText()) | "".equals(t1.getText()))
					JOptionPane.showMessageDialog(null,"Please fill the form");
				else{
					String x =t2.getText();
					String y =t1.getText();
					
				st.executeUpdate("Insert into bookingdetails values('"+unk+"','"+unk+"','"+unk+"','"+y+"','"+x+"')");
				JOptionPane.showMessageDialog(null,"Booked Successfully!");
				}
		}
				catch(Exception e)
		{
			System.out.println(e);
		}
				
	}});*/
		
	
		
}
}
		


class SignUp extends JFrame
{
	private JFrame frame;
	private JPanel p1;
	private JLabel l1, l2,l3,l4,l5,l6;
	private JTextField t1,t2,t3;
	private JPasswordField pf1,pf2;
	private JButton signu,home;
	Connection con;
	Statement st;
	ResultSet rs;
	SignUp()
	{
		frame = new JFrame();
		frame.setSize(1000,1000);
		frame.setVisible(true);
		frame.setTitle("SignUp");
		constructUI();
		designUI();
		handleEvent();	
		try{
		makeConnection();
		rs=st.executeQuery("Select * from login");
		rs.first();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void constructUI()
	{
		p1=new JPanel();
		l1 = new JLabel("Name:");
		l1.setForeground(Color.WHITE);
		l2 = new JLabel("Password:");
		l2.setForeground(Color.WHITE);
	//	l3 = new JLabel("Confirm Password:");
		l4 = new JLabel("email");
		l4.setForeground(Color.WHITE);
		l5 = new JLabel("Phone Number");
		l5.setForeground(Color.WHITE);
		l6 = new JLabel(new ImageIcon("C:\\Users\\BAALAJI\\Desktop\\java project\\Movie ticket\\13.jpg"));
		signu = new JButton("signup");	
		home = new JButton("Home");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		pf1 = new JPasswordField();
		pf1 = new JPasswordField();
	}
	public void designUI()
	{ 	
	try
	{
		p1.add(l1);
		frame.getContentPane().add(l1,BorderLayout.CENTER);
		l1.setBounds(50,50,200,30);	
		p1.add(t1);
		frame.getContentPane().add(t1,BorderLayout.CENTER);
		t1.setBounds(150,50,500,30);
		p1.add(l2);
		frame.getContentPane().add(l2,BorderLayout.CENTER);
		l2.setBounds(50,100,100,30);	
		p1.add(pf1);
		frame.getContentPane().add(pf1,BorderLayout.CENTER);
		pf1.setBounds(150,100,500,30);
		p1.add(l4);
		frame.getContentPane().add(l4,BorderLayout.CENTER);
		l4.setBounds(50,150,100,30);	
		p1.add(t2);
		frame.getContentPane().add(t2,BorderLayout.CENTER);
		t2.setBounds(150,150,500,30);
		p1.add(l5);
		frame.getContentPane().add(l5,BorderLayout.CENTER);
		l5.setBounds(50,200,100,30);	
		p1.add(t3);
		frame.getContentPane().add(t3,BorderLayout.CENTER);
		t3.setBounds(150,200,500,30);
		p1.add(signu);
		frame.getContentPane().add(signu,BorderLayout.CENTER);
		signu.setBounds(50,300,80,30);
		p1.add(home);
		frame.getContentPane().add(home,BorderLayout.CENTER);
		home.setBounds(500,300,80,30);
		p1.add(l6);
		frame.add(p1);
	}
		catch(Exception e)
	{
	}
	}
	public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void handleEvent()
	{
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try{
					String uname=t1.getText();
					String pass=pf1.getText();
					st.executeUpdate("Insert into login values('"+uname+"','"+pass+"')");
				 JOptionPane.showMessageDialog(null,"Registered Successfully!");
				}
				catch(Exception e)
		{
			System.out.println(e);
		}
				
			}
		});
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				MyFrame h = new MyFrame();
				//Myframe.dispose();
			}
		});
	}
}
/*public class ABCD
{
    public static void main(String[] args)
    {
		SignUp f1 = new SignUp();
	
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	java -cp .;mysql.jar Ticket1
}*/
