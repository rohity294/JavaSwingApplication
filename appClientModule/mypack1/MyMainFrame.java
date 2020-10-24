package mypack1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

//3//
class MyMainFrame extends JFrame
{
	//private JTextArea jta;
	private MyTextPanel mtp;
	private JButton jb;
	private MyToolBar myToolBar;
	private MyFormPanel myFormPanel;
	
	public MyMainFrame()//constructor begins
	{
	 super("Hello World");
	 //Google Search for visual guide Swing
	 setLayout(new BorderLayout());
	 
	 setJMenuBar(createMyJMenuBar());
	 
//	 jta = new JTextArea();
	 mtp = new MyTextPanel();
	 jb = new JButton("Click Me!");
	 myToolBar = new MyToolBar();
//	 myToolBar = new MyToolBar(mtp);
	 myFormPanel = new MyFormPanel();
	  
	 myToolBar.setMyListener(new MyStringListener() {
		public void listenToStringEmitted(String emittedString) {
			//System.out.println(emittedString+"\n");	
			mtp.myAppend(emittedString+"\n");
		}	 
	 });
	 
	 myFormPanel.setMyFormListener(new MyFormListener() {
		 public void myFormEventOccured(MyFormEvent fev) {
//			 mtp.myAppend("name: "+fev.getName()+","+"occupation: "+fev.getOccupation()+"\n");
//			 System.out.println(fev.getAgeCategory().id+":"+fev.getAgeCategory().text);
			 mtp.myAppend("name: "+fev.getName()+",occupation: "+fev.getOccupation()+",gender:"+fev.getGenderSelected()
+",age category id:"+fev.getAgeCategory().getId()+","+"age category text:"+fev.getAgeCategory().getText()
+ ",employment status:"+fev.getEmploymentStatus()
+ ",US Citizen?:"+fev.isUSCitizenMessage()
+ ",tax id:"+fev.getStrTaxID()
+"\n");
			 
		 }
	 });
	 
//	 add(jta,BorderLayout.CENTER);
	 add(mtp,BorderLayout.CENTER);
	 add(jb,BorderLayout.SOUTH);
	 add(myToolBar,BorderLayout.NORTH);
	 add(myFormPanel,BorderLayout.WEST);
	
	 jb.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent ae)
		 {
//			 jta.append("Button was clicked!\n");
			 mtp.myAppend("Button was clicked!\n");
		 }
	   });
	 
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setSize(600,600);
	 setVisible(true);
	 
	}//constructor ends
	
	public JMenuBar createMyJMenuBar()
	{
		JMenuBar myMenuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportMenuItem = new JMenuItem("Export Data");
		JMenuItem importMenuItem = new JMenuItem("Import Data");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exportMenuItem);
		fileMenu.add(importMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
	
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
//		JMenuItem showPersonFormMenuItem = new JMenuItem("Show Person Form");
		JCheckBoxMenuItem showPersonFormJCheckBoxMenuItem = new JCheckBoxMenuItem("Show Person Form");
		showPersonFormJCheckBoxMenuItem.setSelected(true);

		showMenu.add(showPersonFormJCheckBoxMenuItem);
		windowMenu.add(showMenu);
		
		myMenuBar.add(fileMenu);
		myMenuBar.add(windowMenu);
		
		showPersonFormJCheckBoxMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				JCheckBoxMenuItem actionSource = (JCheckBoxMenuItem)ae.getSource();
				myFormPanel.setVisible(actionSource.isSelected());
			}
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitMenuItem.setMnemonic(KeyEvent.VK_X);
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		
		return myMenuBar;
	}
}//class ends
