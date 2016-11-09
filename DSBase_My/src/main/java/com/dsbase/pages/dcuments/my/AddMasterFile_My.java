package com.dsbase.pages.dcuments.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.TextInput;

public class AddMasterFile_My extends WebPage<AddMasterFile_My> {
	private static final String PAGE_URL = BASE_URL + "/Reports/Add";
	public AddMasterFile_My(WebDriver driver){
		super (driver);
	}
	@Override
	public AddMasterFile_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override 
	public boolean isAvailable() {
		return  getSaveButton().isAvailable();
	}
	//______________________________________________Actions_______________________________________________________//
	//���������� ������� "��������� ��������"
	public void TitlePage_FillUp(){
		new TitlePageElements().getUniqueNumber().inputText(new TitlePageElements().new Values().setUniqueNumber);
		new TitlePageElements().getDateOfAddition().click();
		new TitlePageElements().getDateOfAddition().inputText(new TitlePageElements().new Values().setDateOfAddition);
		new TitlePageElements().getVersion().inputText(new TitlePageElements().new Values().setVersion);
		new TitlePageElements().getUpdateDate().click();
		new TitlePageElements().getUpdateDate().inputText(new TitlePageElements().new Values().setUpdateDate);
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new TitlePageElements().getSectionText(), new TitlePageElements().new Values().setSectionText);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	// ���������� ������� "1. ���������� � ����"
	public void SectionOnQPPV_FillUP(){
		new SectionOnQPPV().getSectionOnQPPVTab().click();
		getSaveButton().waitUntilAvailable();
		// ���������� ����� �� ������� "1. ���������� � ����"
		// ����
		new SectionOnQPPV().getFirstNameQPPV().inputText(new SectionOnQPPV().new Values().firstNameQPPV);
		new SectionOnQPPV().getLastNameQPPV().inputText(new SectionOnQPPV().new Values().lastNameQPPV);
		new SectionOnQPPV().getMiddleNameQPPV().inputText(new SectionOnQPPV().new Values().middleNameQPPV);
		new SectionOnQPPV().getAddressQPPV().inputText(new SectionOnQPPV().new Values().addressQPPV);
		new SectionOnQPPV().getPhoneQPPV().inputText(new SectionOnQPPV().new Values().phoneQPPV);
		new SectionOnQPPV().getEmailQPPV().inputText(new SectionOnQPPV().new Values().emailQPPV);
		// ������������ ����
		new SectionOnQPPV().getFirstNameSurrogateQPPV().inputText(new SectionOnQPPV().new Values().firstNameSurrogateQPPV);
		new SectionOnQPPV().getLastNameSurrogateQPPV().inputText(new SectionOnQPPV().new Values().lastNameSurrogateQPPV);
		new SectionOnQPPV().getMiddleNameSurrogateQPPV().inputText(new SectionOnQPPV().new Values().middleNameSurrogateQPPV);
		new SectionOnQPPV().getAddressSurrogateQPPV().inputText(new SectionOnQPPV().new Values().addressSurrogateQPPV);
		new SectionOnQPPV().getPhoneSurrogateQPPV().inputText(new SectionOnQPPV().new Values().phoneSurrogateQPPV);
		new SectionOnQPPV().getEmailSurrogateQPPV().inputText(new SectionOnQPPV().new Values().emailSurrogateQPPV);
		// ��������� ���� "����� �������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new SectionOnQPPV().getSectionText1Tab(), new SectionOnQPPV().new Values().setSectionText1Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void OrganisationalStructure_FillUP(){
		// ������� �� ������� 
		new OrganisationalStructure().getOrganisationalStructureTab().click();
		// ��������� ���� "����� �������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new OrganisationalStructure().getSectionText2Tab(), new OrganisationalStructure().new Values().setSectionText2Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}

	public void SourcesOfSafetyData_FillUp() {
		// ������� �� �������
		new SourcesOfSafetyData().getSourcesOfSafetyDataTab().click();
		// ��������� ���� "����� �������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new SourcesOfSafetyData().getSectionText3Tab(),
				new SourcesOfSafetyData().new Values().setSectionText3Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void ComputerisedSystemsAndDb_FillUp(){
		// ������� �� ������� 4. ���������� � �������������������� �������� � ����� ������
		new ComputerisedSystemsAndDb().getComputerisedSystemsAndDbTab().click();
		// ��������� ���� "����� �������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new ComputerisedSystemsAndDb().getSectionText4Tab(),
				new ComputerisedSystemsAndDb().new Values().setSectionText4Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void PharmacovigilanceProcesses_FillUp(){
		// ������� �� ������� 5. ���������� � ��������� ��������������
		new PharmacovigilanceProcesses().getPharmacovigilanceProcessesTab().click();
		// ��������� ���� "����� �������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new PharmacovigilanceProcesses().getSectionText5Tab(),
				new PharmacovigilanceProcesses().new Values().setSectionText5Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void PharmacovigilanceSystem_FillUp(){
		// ������� �� ������� 6. ���������� � �������������� ������� ��������������
		new PharmacovigilanceSystem().getPharmacovigilanceSystemTab().click();
		// ��������� ���� "����� �������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new PharmacovigilanceSystem().getSectionText6Tab(),
				new PharmacovigilanceSystem().new Values().setSectionText6Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();	
	}
	public void QualitySystem_FillUp(){
		// ������� �� ������� 7. ������� �������� 
		new QualitySystem().getQualitySystemTab().click();
		// ��������� ���� "����� �������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new QualitySystem().getSectionText7Tab(),
				new QualitySystem().new Values().setSectionText7Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();	
	}
	//______________________________________________Elements_______________________________________________________//
	private final String MasterfilePath = "C:\\Selenium_TestData\\Projects\\DSBase\\MasterFile\\";					// ���� � ����� ������� ��� �������� 
	private final String readFile = new CustomMethods().new WorkWith_TextFiles().file_Read(MasterfilePath + "MasterFile.txt");						// ������ ����� (���������������� � ������)
	// ������ ��������� ������ ����
	private Button getSaveButton(){
		return new Button(driver, By.id("save_btn"));
	}
	private class TitlePageElements{
		// ���� ���������� �����
		private TextInput getUniqueNumber(){
			return new TextInput(driver, By.id("Tab0_str_Id"));
		}
		// ���� ���� �����������
		private TextInput getDateOfAddition(){
			return new TextInput(driver, By.id("Tab0_DateOfLastAppeal"));
		}
		// ���� ������ 
		private TextInput getVersion(){
			return new TextInput(driver, By.id("Tab0_Version"));
		}
		// ���� ���� ����������
		private TextInput getUpdateDate(){
			return new TextInput(driver, By.id("Tab0_DateOfLastAppeal2"));
		}
		// ���� ����� �������
		private WebElement getSectionText(){
			return driver.findElement(By.id("customTextEditor_Tab0Text1_DesignIFrame"));
		}
		private class Values{
			private String setUniqueNumber =  "Droid"; // ���������� �����
			private String setDateOfAddition = new CustomMethods().getCurrentDate();	// ���� �����������
			private String setVersion = "R2-D2";	//version
			private String setUpdateDate = new CustomMethods().getChangedDate(2); // ���� ����������
			private String setSectionText = readFile.substring(readFile.indexOf("#1"), readFile.indexOf("#2")); // ����� �������
		}
	}
	private class SectionOnQPPV{
		//������ �������� �� ������� "���������� � ����"
		private Custom getSectionOnQPPVTab(){
			return new Custom(driver, By.xpath("//div[contains(text(), '1. ���������� � ����')]"));
		}
		// ���� ����� �������:���������� � ����
		private WebElement	getSectionText1Tab(){
			return driver.findElement(By.id("customTextEditor_Tab1Text1_DesignIFrame"));
		}
		// ���� ��� ����
		private TextInput getFirstNameQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofName"));
		}
		// ���� ������� ����
		private TextInput getLastNameQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofSurName"));
		}
		// ���� ��������� ����
		private TextInput getMiddleNameQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofMiddleName"));
		}
		// ���� ����� ����
		private TextInput getAddressQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofAddress"));
		}
		// ���� ������� ����
		private TextInput getPhoneQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofPhone"));
		}
		// ���� ����� ����
		private TextInput getEmailQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofMail"));
		}

		// ���� ��� ����������� ����
		private TextInput getFirstNameSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateName"));
		}

		// ���� ������� ����������� ����
		private TextInput getLastNameSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateSurName"));
		}

		// ���� ��������� ����������� ����
		private TextInput getMiddleNameSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateMiddleName"));
		}

		// ���� ����� ����������� ����
		private TextInput getAddressSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateAddress"));
		}

		// ���� ������� ����������� ����
		private TextInput getPhoneSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMatePhone"));
		}

		// ���� ����� ����������� ����
		private TextInput getEmailSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateMail"));
		}
		private class Values{
			private String firstNameQPPV="Anakin";																				// ���
			private String lastNameQPPV="Skywalker";																			// �������
			private String middleNameQPPV="Darth Vader"; 																	    // ��������
			private String addressQPPV="Death planet";																			// �����
			private String phoneQPPV="+380000000000";																			// �������
			private String emailQPPV="Anakin.Skywalker@darkside.com"; 															// �����
			private String firstNameSurrogateQPPV="Anakin";																		// ���
			private String lastNameSurrogateQPPV="Skywalker";																	// �������
			private String middleNameSurrogateQPPV="Darth Vader"; 															    // ��������
			private String addressSurrogateQPPV="Death planet";																	// �����
			private String phoneSurrogateQPPV="+380000000000";																	// �������
			private String emailSurrogateQPPV="Anakin.Skywalker@darkside.com"; 													// �����
			private String setSectionText1Tab = readFile.substring(readFile.indexOf("#2"), readFile.indexOf("#3")); 			// ����� �������
		}
	}
	private class OrganisationalStructure{
		//������ �������� �� ������� "2. ���������� �� ��������������� ��������� ��������� ��"
		private Custom getOrganisationalStructureTab(){
			return new Custom(driver, By.xpath("//div[contains(text(), '2. ��������������� ��������� ���')]"));
		}
		// ���� ����� �������:���������� �� ��������������� ��������� ��������� ��
		private WebElement	getSectionText2Tab(){
			return driver.findElement(By.id("customTextEditor_Tab2Text1_DesignIFrame"));
		}
		private class Values{
			private String setSectionText2Tab = readFile.substring(readFile.indexOf("#3"), readFile.indexOf("#4")); 			// ����� �������
		}
	}
	private class SourcesOfSafetyData{
		// ������ �������� �� ������� "3. ��������� ������ �� ������������"
		private Custom getSourcesOfSafetyDataTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '3. ��������� ������ �� ������������')]"));
		}
		// ���� ����� �������:3. ��������� ������ �� ������������
		private WebElement getSectionText3Tab() {
			return driver.findElement(By.id("customTextEditor_Tab3Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText3Tab = readFile.substring(readFile.indexOf("#4"), readFile.indexOf("#5")); // ����� �������
		}
	}
	private class ComputerisedSystemsAndDb{
		// ������ �������� �� ������� ":4. ���������� � �������������������� �������� � ����� ������
		private Custom getComputerisedSystemsAndDbTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '4. �������������������� ������� � ��')]"));
		}
		// ���� ����� �������:4. ���������� � �������������������� �������� � ����� ������
		private WebElement getSectionText4Tab() {
			return driver.findElement(By.id("customTextEditor_Tab4Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText4Tab = readFile.substring(readFile.indexOf("#5"), readFile.indexOf("#6")); // ����� �������
		}
	}
	private class PharmacovigilanceProcesses{
		// ������ �������� �� ������� "5. ���������� � ��������� ��������������
		private Custom getPharmacovigilanceProcessesTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '5. �������� ��������������')]"));
		}
		// ���� ����� �������:5. ���������� � ��������� ��������������
		private WebElement getSectionText5Tab() {
			return driver.findElement(By.id("customTextEditor_Tab5Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText5Tab = readFile.substring(readFile.indexOf("#6"), readFile.indexOf("#7")); // ����� �������
		}
	}
	private class PharmacovigilanceSystem{
		// ������ �������� �� ������� "6. ���������� � �������������� ������� ��������������
		private Custom getPharmacovigilanceSystemTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '6. �������������� ��')]"));
		}
		// ���� ����� �������:6. ���������� � �������������� ������� ��������������
		private WebElement getSectionText6Tab() {
			return driver.findElement(By.id("customTextEditor_Tab6Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText6Tab = readFile.substring(readFile.indexOf("#7"), readFile.indexOf("#8")); // ����� �������
		}
	}
	private class QualitySystem{
		// ������ �������� �� ������� "7. ������� �������� 
		private Custom getQualitySystemTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '7. ������� �������� ')]"));
		}
		// ���� ����� �������:7. ������� �������� 
		private WebElement getSectionText7Tab() {
			return driver.findElement(By.id("customTextEditor_Tab7Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText7Tab = readFile.substring(readFile.indexOf("#8"), readFile.indexOf("#9")); // ����� �������
		}
	}
	
}
