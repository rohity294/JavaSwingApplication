package mypack1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyApp
{
 
	
	public static void main(String args[])
	{
		 SwingUtilities.invokeLater(new Runnable() {
			 public void run()
			 {
				 //3//
				 new MyMainFrame();
//2//				JFrame jf = new JFrame("Hello World");
//					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					jf.setSize(600,500);
//					jf.setVisible(true);	
			 }
		 });
		 
//1//	JFrame jf = new JFrame("Hello World");
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setSize(600,500);
//		jf.setVisible(true);	
	}

}//class ends




