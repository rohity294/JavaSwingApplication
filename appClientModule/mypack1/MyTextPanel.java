package mypack1;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyTextPanel extends JPanel
{
	private JTextArea jta;
//	public JTextArea getJTextArea()
//	{
//		return jta;
//	}
	
	public MyTextPanel()
	{
		jta = new JTextArea();
		setLayout(new BorderLayout());
//		add(jta,BorderLayout.CENTER);
		add(new JScrollPane(jta),BorderLayout.CENTER);

	}
	
	public void myAppend(String content)
	{
		jta.append(content);
	}
	
	
}