package mypack1;
import java.util.*;

public class MyFormEvent extends EventObject
{
	private String name;
	private String occupation;
	private String genderSelected;
	private AgeCategory ageCategory;
	private String employmentStatus;
	private String USCitizenMessage;
	private String strTaxID;
	
	public MyFormEvent(Object source)
	{
		super(source);
	}
	
	public MyFormEvent(Object source,String name,String occupation,String genderSelected 
			,AgeCategory ageCategory,String employmentStatus
			,String USCitizenMessage, String strTaxID
			)
	{
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.genderSelected = genderSelected;
		this.ageCategory = ageCategory;
		this.employmentStatus = employmentStatus;
		this.USCitizenMessage = USCitizenMessage;
		this.strTaxID = strTaxID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getGenderSelected() {
		return genderSelected;
	}

	public void setGenderSelected(String genderSelected) {
		this.genderSelected = genderSelected;
	}
	
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
	
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	
	public String isUSCitizenMessage() {
		return USCitizenMessage;
	}

	public void setUSCitizenMessage(String USCitizenMessage) {
		this.USCitizenMessage = USCitizenMessage;
	}
	
	public String getStrTaxID() {
		return strTaxID;
	}
	
	public void setStrTaxID(String employmentStatus) {
		this.strTaxID = strTaxID;
	}

}
