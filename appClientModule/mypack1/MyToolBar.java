package mypack1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyToolBar extends JPanel implements ActionListener
{
	JButton jbtn1;
	JButton jbtn2;
	//JTextArea jta;
	//MyTextPanel mtp;
	
	private MyStringListener ml = null;
	public void setMyListener(MyStringListener ml)
	{
		this.ml = ml;
	}
	
	
	public MyToolBar()
	{
//	  MyToolBar(MyTextPanel mtp)
//	  {
		//this.mtp = mtp;
		jbtn1 = new JButton("Hello");
		jbtn2 = new JButton("GoodBye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEtchedBorder());
		
		add(jbtn1);
		add(jbtn2);
		
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		
		//jta = mtp.getJTextArea();

	}//constructor ends
	
	
	public void actionPerformed(ActionEvent ae)
	{
		JButton btnName = (JButton)ae.getSource();
//		System.out.println(btnName);
		if(btnName==jbtn1)
		{
			//System.out.println("Hello");
			//jta.append("Hello\n");
			printMessage("Hello");	
		}
		if(btnName==jbtn2)
		{
			//System.out.println("GoodBye");
			//jta.append("GoodBye\n");
			printMessage("GoodBye");
		}
	}
	
	public void printMessage(String message)
	{
		if(ml!=null)
		{
			ml.listenToStringEmitted(message);
		}
	}
	
	
}

