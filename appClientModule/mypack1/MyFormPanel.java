package mypack1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyFormPanel extends JPanel
{
	private JLabel nameLabel,occupationLabel;
	private JTextField nameText, occupationText;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
//	private String ageCategory;
	private AgeCategory ageCategory;
	private String employmentStatus;
	private JButton addButton;
	private MyFormListener myFormListener;
	private JList ageList;
	private JComboBox empCombo;
	private JLabel usCitizenshipLabel,taxIDLabel;
	private JCheckBox usCitizenshipCheckBox;
	private JTextField taxID;
	
	public MyFormListener getMyFormListener() {
		return myFormListener;
	}
	
	public void setMyFormListener(MyFormListener myFormListener) {
		this.myFormListener = myFormListener;
	}
	
	public MyFormPanel()
	{
		Dimension dim = getPreferredSize();
		//System.out.println(dim);//java.awt.Dimension[width=10,height=10]
		//dim.height = 100;//The BorderLayoutManager is not respecting height so no use setting it
		dim.width = 250;//width is being respected
		setPreferredSize(dim);
		
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		nameLabel = new JLabel("Name:");
		occupationLabel = new JLabel("Occupation:");
		nameText = new JTextField(10);
		//setting up mnemonic
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nameLabel.setLabelFor(nameText);
		occupationText = new JTextField(10);
		usCitizenshipLabel = new JLabel("US Citizen");
		taxIDLabel = new JLabel("Tax ID:");
		taxID = new JTextField(10);
		usCitizenshipCheckBox = new JCheckBox();
		
		//setting up gender radio buttons
		maleRadio = new JRadioButton("male");
		femaleRadio = new JRadioButton("female");
		genderGroup = new ButtonGroup();
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		femaleRadio.setActionCommand("female");
		maleRadio.setActionCommand("male");
		femaleRadio.setSelected(true);
		
		// setting up JListBox
		ageList = new JList();
		DefaultListModel dlm = new DefaultListModel();		
//		dlm.addElement("under 18");
//		dlm.addElement("18 to 65");
//		dlm.addElement("66 and above");		
		dlm.addElement(new AgeCategory(0,"under 18"));
		dlm.addElement(new AgeCategory(1,"18 to 65"));
		dlm.addElement(new AgeCategory(2,"66 and above"));	
		ageList.setModel(dlm);
		ageList.setPreferredSize(new Dimension(105,60));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		
		//setting up JComboBox
		empCombo = new JComboBox();
		DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
		dcbm.addElement("Unemployed");
		dcbm.addElement("Employed");
		dcbm.addElement("Self-Employed");
		empCombo.setModel(dcbm);
		empCombo.setSelectedIndex(1);
			
		//setting up JCheckbox
		usCitizenshipLabel = new JLabel("US Citizen");
		usCitizenshipCheckBox = new JCheckBox();
		taxID = new JTextField(10);
		taxIDLabel.setEnabled(false);
		taxID.setEnabled(false);
		
		usCitizenshipCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{	
				boolean status = usCitizenshipCheckBox.isSelected();
				taxIDLabel.setEnabled(status);
				taxID.setEnabled(status);
			}
		});
		
		
		//setting up JButton
		addButton = new JButton("Add");
		addButton.setMnemonic(KeyEvent.VK_A);
		myLayoutSetter();	
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				String name = nameText.getText();
				String occupation = occupationText.getText();	
//				String ageCategory = (String)ageList.getSelectedValue();
				AgeCategory ageCategory = (AgeCategory) ageList.getSelectedValue();
				String employmentStatus = (String) empCombo.getSelectedItem();
				boolean USCitizen = (Boolean) usCitizenshipCheckBox.isSelected();
				String USCitizenMessage = "";
				if(USCitizen)
					USCitizenMessage = "YES";
				else
					USCitizenMessage = "NO";
				String strTaxID = taxID.getText();
				
				String genderSelected = (String )genderGroup.getSelection().getActionCommand();
				
				MyFormEvent fev = new MyFormEvent(this,name,occupation,genderSelected,ageCategory,employmentStatus,USCitizenMessage,strTaxID);
				if(myFormListener!=null)
				{
					myFormListener.myFormEventOccured(fev);
				}
			}
		});
		
		
	}//constructor ends
	
	public void myLayoutSetter()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc =new GridBagConstraints();
		
		gc.fill = GridBagConstraints.NONE;	
		
		
		//First Row//
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx=0;
		gc.gridy=0;	
		gc.anchor = GridBagConstraints.LINE_END;	
		gc.insets = new Insets(0,0,0,5);
		add(nameLabel,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(nameText,gc);
		
		//Next Row//
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx=0;
		gc.gridy=1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(occupationLabel,gc);
		
		gc.gridx=1;
		gc.gridy=1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(occupationText,gc);
		
		//Next Row//
		gc.weightx = 1;
		gc.weighty = 0.001;

		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Gender:"), gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(maleRadio,gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(femaleRadio,gc);
		
		//Next Row//
		gc.weightx = 1;
		gc.weighty = 0.1;
				
		gc.gridx=0;
		gc.gridy=4;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Age Category:"),gc);
		
		gc.gridx=1;
		gc.gridy=4;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(ageList,gc);
		
		//Next Row//
		gc.weightx = 1;
		gc.weighty = 0.1;
						
		gc.gridx=0;
		gc.gridy=5;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Employment Status:"),gc);
		
		gc.gridx=1;
		gc.gridy=5;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(empCombo,gc);
		
		//Next Row//
		gc.weightx = 1;
		gc.weighty = 0.1;
						
		gc.gridx=0;
		gc.gridy=6;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(usCitizenshipLabel,gc);
		
		gc.gridx=1;
		gc.gridy=6;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(usCitizenshipCheckBox,gc);
		
		//Next Row//
		gc.weightx = 1;
		gc.weighty = 0.1;
								
		gc.gridx=0;
		gc.gridy=7;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(taxIDLabel,gc);
				
		gc.gridx=1;
		gc.gridy=7;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(taxID,gc);
		
		//Next Row//
		gc.weightx = 1;
		gc.weighty = 2;	
		
		gc.gridx=1;
		gc.gridy=8;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(addButton,gc);
		
	}//myLayoutSetter() ends

}//class ends

class AgeCategory
{
	int id;
	String text;
	
	public AgeCategory(int id, String text)
	{
		this.id = id;
		this.text = text;
	}
	
	public String toString()
	{
		return text;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
