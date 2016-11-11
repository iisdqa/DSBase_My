package com.dsbase.pages.dcuments.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	public void Anne�A_FillUp(){
		// ������� �� ������� ���������� � 
		new Anne�A().getAnne�ATab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new Anne�A().getAnne�ATe�t(),
				new Anne�A().new Values().setAnnexAText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�A().getAnnexAElementsButton().click();
		new Anne�A().getNumberAnnexA().waitUntilAvailable();
		new Anne�A().getNumberAnnexA().inputText(new Anne�A().new Values().setNumberAnnexA);
		new Anne�A().getTitleAnnexA().inputText(new Anne�A().new Values().setTitleAnnexA);
		new Anne�A().getDateAnnexA().click();
		new Anne�A().getDateAnnexA().inputText(new Anne�A().new Values().setDateAnnexA);
		new Anne�A().getNoteAnnexA().inputText(new Anne�A().new Values().setNoteAnnexA);
		new Anne�A().getSaveAnnexAElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�A().getGridDownload_Div(), false);
	
		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�A().getElementNameCell()).perform();
		simpleWait(2);
	
		// ���������� ���������
	
		// �������� ���-��� ���������� ���������
		new Anne�A().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�A().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);
				
		// ����
		new Anne�A().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�A().new Docs_Elements().getDate_Field().inputText(new Anne�A().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�A().new Docs_Elements().getName_Field().inputText(new Anne�A().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�A().new Docs_Elements().getDescription_Field().inputText(new Anne�A().new Docs_Elements().new Values().docDescription);	
		// ��� ���������
		new Anne�A().new Docs_Elements().getDocType_Field().selectByVisibleText(new Anne�A().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�A().new Docs_Elements().getFileUpload_Button().inputText(new Anne�A().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�A().new Docs_Elements().getFile_Field().getAttribute("value"), is(equalTo(new Anne�A().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�A().new Docs_Elements().getFileLink_Field().inputText(new Anne�A().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�A().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�A().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void Anne�B_FillUp(){
		// ������� �� ������� ���������� B
		new Anne�B().getAnne�BTab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�B().getAnne�BTe�t(),
				new Anne�B().new Values().setAnnexBText);
		simpleWait(2);
		
		// ���������� �������� � ���� "������ ��������� � ����������"
		new Anne�B().getListOfAgreementsButton().click();
		new Anne�B().getAgreementNumber().waitUntilAvailable();
		new Anne�B().getAgreementNumber().waitUntilAvailable();	
		new Anne�B().getAgreementNumber().inputText(new Anne�B().new Values().setAgreementNumber);
		new Anne�B().getSignatureDate().click();
		new Anne�B().getSignatureDate().inputText(new Anne�B().new Values().setSignatureDate);
		new Anne�B().getOrganization().inputText(new Anne�B().new Values().setOrganization);
		new Anne�B().getTopic().inputText(new Anne�B().new Values().setTopic);
		new Anne�B().getEffectiveDate().click();
		new Anne�B().getEffectiveDate().inputText(new Anne�B().new Values().setEffectiveDate);
		new Anne�B().getCompletionDate().click();
		new Anne�B().getCompletionDate().inputText(new Anne�B().new Values().setCompletionDate);
		new Anne�B().getStatus().selectByVisibleText(new Anne�B().new Values().setStatus);
		new Anne�B().getNoteEgreements().inputText(new Anne�B().new Values().setNoteEgreements);
		new Anne�B().getSaveEgreementsButton().click();
		// �������� ��������� �����
		waitForBlockStatus(new Anne�B().getAgreementsGridDownload_Div(), false);
		simpleWait(2);
		
		// ���������� �������� � ���� "�������� ����������"
		new Anne�B().getAnnexBElementsButton().click();
		new Anne�B().getNumberAnnexB().waitUntilAvailable();
		new Anne�B().getNumberAnnexB().inputText(new Anne�B().new Values().setNumberAnnexB);
		new Anne�B().getTitleAnnexB().inputText(new Anne�B().new Values().setTitleAnnexB);
		new Anne�B().getDateAnnexB().click();
		new Anne�B().getDateAnnexB().inputText(new Anne�B().new Values().setDateAnnexB);
		new Anne�B().getNoteAnnexB().inputText(new Anne�B().new Values().setNoteAnnexB);
		new Anne�B().getSaveAnnexBElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�B().getGridDownload_Div(), false);
		
		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�B().getElementNameCell()).perform();
		simpleWait(2);
		
		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�B().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�B().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�B().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�B().new Docs_Elements().getDate_Field().inputText(new Anne�B().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�B().new Docs_Elements().getName_Field().inputText(new Anne�B().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�B().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�B().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�B().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�B().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�B().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�B().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�B().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�B().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�B().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�B().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�B().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�B().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void Anne�C_FillUp(){
		// ������� �� ������� ���������� �
		new Anne�C().getAnne�CTab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�C().getAnne�CTe�t(),
				new Anne�C().new Values().setAnnexCText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�C().getAnnexCElementsButton().click();
		new Anne�C().getNumberAnnexC().waitUntilAvailable();
		new Anne�C().getNumberAnnexC().inputText(new Anne�C().new Values().setNumberAnnexC);
		new Anne�C().getTitleAnnexC().inputText(new Anne�C().new Values().setTitleAnnexC);
		new Anne�C().getDateAnnexC().click();
		new Anne�C().getDateAnnexC().inputText(new Anne�C().new Values().setDateAnnexC);
		new Anne�C().getNoteAnnexC().inputText(new Anne�C().new Values().setNoteAnnexC);
		new Anne�C().getSaveAnnexCElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�C().getGridDownload_Div(), false);

		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�C().getElementNameCell()).perform();
		simpleWait(2);

		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�C().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�C().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�C().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�C().new Docs_Elements().getDate_Field().inputText(new Anne�C().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�C().new Docs_Elements().getName_Field().inputText(new Anne�C().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�C().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�C().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�C().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�C().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�C().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�C().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�C().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�C().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�C().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�C().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�C().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�C().new Docs_Elements().getGridDownload_Div(), false);
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
			return new Custom(driver, By.xpath("//div[contains(text(), '7. ������� ��������')]"));
		}
		// ���� ����� �������:7. ������� �������� 
		private WebElement getSectionText7Tab() {
			return driver.findElement(By.id("customTextEditor_Tab7Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText7Tab = readFile.substring(readFile.indexOf("#8"), readFile.indexOf("#9")); // ����� �������
		}
	}
	private class Anne�A{
		// ������ �������� �� ������� "���������� � - ����
		private Custom getAnne�ATab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� � - ����')]"));
		}
		// ���� ����� ���������� � 
		private WebElement getAnne�ATe�t() {
			return driver.findElement(By.id("customTextEditor_Tab8_AText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnnexAElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain8_A"));
		}
		// ���� "�"
		private TextInput getNumberAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnnexAElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main8_A"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main8_A_ElementsName']"));
		}
		private class Values{
			String setAnnexAText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10")); // ����� ����������
			String setNumberAnnexA = "444222";															// �����
			String setTitleAnnexA = "�������� �����";													// �������� 
			String setDateAnnexA = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnnexA = "��� ����������";													// ����������
		}
		private class Docs_Elements{
			// ������ ����������
			private Button getAddButton(){
				return new Button(driver, By.id("add_edit_tab"));
			}
						
			// ���-�� ����������
			private Custom getAddEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}
						
			// "������������"
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_tab8_A"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocDescribe"));
			}
						
			// �������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab8Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocLinkFile"));
			}
						
			// ������ '���������'
			private Button getSaveButton(){
				return new Button(driver, By.id("save_dialog_btn"));
			}
								
			private class Values{
				private String addEditPopUpName = "�������� ����� ������";				// �������� ���-��� ����������/�������������� ���������
				private String date = new CustomMethods().getCurrentDate(); 	 		// ����
				private String name = "����";						     				// �������� ���������
				private String docDescription = "��������";						    	// �������� ���������
				private String docType = "����������� ����������";						// ����������
				private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";	// ������ �� ����(��������)
				private String fileName = "ForDocAdd.txt";								// �������� �����
				private String fileLink = "www.getFile.com/get";			     		// ������ �� ���� 
			}
			
		}
		
	}
	private class Anne�B{
		// ������ �������� �� ������� "���������� � - ��������������� ��������� ��������� ��"
		private Custom getAnne�BTab() {
			return new Custom(driver,
					By.xpath("//div[contains(text(), '���������� � - ��������������� ��������� ���')]"));
		}
		// ������ ���������� � ���� ������ ��������� � ����������
        private Button getListOfAgreementsButton(){
        	return new Button(driver, By.id("add_edit_tabContract9_B"));
        }
        // ���� "����� ��������"
        private TextInput getAgreementNumber(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractNumber"));
        }
        // ���� ���� ����������
        private TextInput getSignatureDate(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractDateConfirm"));
        }
        // ���� �����������
        private TextInput getOrganization(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractOrganization"));
        }
        // ���� ����
        private TextInput getTopic(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractTitle"));
        }
        // ���� ���� ������ ��������:
        private TextInput getEffectiveDate(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractDateBegin"));
        }
        // ���� ���� ���������� ��������:
        private TextInput getCompletionDate(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractDateEnd"));
        }
        // ���� ������
        private Select getStatus(){
        	return new Select(driver.findElement(By.id("Tab9CGrid_ContractStatus")));
        }
        // ���� "����������"
        private TextInput getNoteEgreements(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractNote"));
        }
        private Button getSaveEgreementsButton(){
        	return new Button(driver, By.id("save_dialog_btn"));
        }
        // �������� ����� ������ ��������� � ����������
     	private Custom getAgreementsGridDownload_Div() {
     		return new Custom(driver, By.id("load_list_tab_main9_B"));
     	}
		// ���� ����� ���������� B
		private WebElement getAnne�BTe�t() {
			return driver.findElement(By.id("customTextEditor_Tab9_BText1_DesignIFrame"));
		}
		
		// ������ ���������� ��������� ����������
		private Button getAnnexBElementsButton() {
			return new Button(driver, By.id("add_edit_tabMain9_B"));
		}

		// ���� "�"
		private TextInput getNumberAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsNumber"));
		}

		// ���� ��������
		private TextInput getTitleAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsName"));
		}

		// ���� ����
		private TextInput getDateAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsDate"));
		}

		// ���� ����������
		private TextInput getNoteAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsNote"));
		}

		// ������ ���������(popUp)
		private Button getSaveAnnexBElemetsButton() {
			return new Button(driver, By.id("save_dialog_btn"));
		}

		// �������� ����� "�������� ����������"
		private Custom getGridDownload_Div() {
			return new Custom(driver, By.id("load_list_tab_main9_B"));
		}

		private WebElement getElementNameCell() {
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main9_B_ElementsName']"));
		}

		private class Values {
			String setAgreementNumber = "4444"; 								// ����� ��������
			String setSignatureDate = new CustomMethods().getCurrentDate();		// ���� ����������:
			String setOrganization = "������������";    						// �����������
			String setTopic = "������ ���������";								// ����
			String setEffectiveDate = new CustomMethods().getChangedDate(1);	// ���� ������ ��������
			String setCompletionDate = new CustomMethods().getChangedDate(2);   // ���� ���������� ��������
			String setStatus = "�� ������������";								// ������
			String setNoteEgreements = "��� ����������";						// ����������
			
			
			
			
			String setAnnexBText = readFile.substring(readFile.indexOf("#10"), readFile.indexOf("#11"));  // ����� ����������
			String setNumberAnnexB = "444222"; 															  // �����
			String setTitleAnnexB = "�������� �����";                                                     // ��������
			String setDateAnnexB = new CustomMethods().getCurrentDate();                                  // ����
			String setNoteAnnexB = "��� ����������";                                                      // ����������
		}

		private class Docs_Elements {
			// ������ ����������
			private Button getAddButton() {
				return new Button(driver, By.id("add_edit_tab"));
			}

			// ���-�� ����������
			private Custom getAddEditPopUp() {
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}

			// "������������"
			private Custom getGridDownload_Div() {
				return new Custom(driver, By.id("load_list_tab9_B"));
			}

			// ����
			private TextInput getDate_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocDate"));
			}

			// �������� ���������
			private TextInput getName_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocName"));
			}

			// �������� ���������
			private TextInput getDescription_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocDescribe"));
			}

			// �������� ���������
			private Select getDocType_Field() {
				return new Select(driver.findElement(By.id("Tab9Grid_DocCategory")));
			}

			// ����
			private TextInput getFile_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocFileName"));
			}

			private TextInput getFileUpload_Button() {
				return new TextInput(driver, By.id("file_source"));
			}

			// ������ �� ����
			private TextInput getFileLink_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocLinkFile"));
			}

			// ������ '���������'
			private Button getSaveButton() {
				return new Button(driver, By.id("save_dialog_btn"));
			}

			private class Values {
				private String addEditPopUpName = "�������� ����� ������"; 				    // �������� ���-��� ����������/�������������� ���������
				private String date = new CustomMethods().getCurrentDate();				    // ����
				private String name = "����"; 												// �������� ���������
				private String docDescription = "��������"; 								// �������� ���������
				private String docType = "����������� ����������";						    // ����������
				private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";    // ������ �� ����(��������)
				private String fileName = "ForDocAdd.txt"; 									// �������� �����
				private String fileLink = "www.getFile.com/get"; 							// ������ �� ����
			}

		}
	}
	private class Anne�C{
		// ������ �������� �� ������� "���������� C - ��������� ������ �� ������������
		private Custom getAnne�CTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� C - ��������� ������ �� ������������')]"));
		}
		// ���� ����� ���������� � 
		private WebElement getAnne�CTe�t() {
			return driver.findElement(By.id("customTextEditor_Tab10_CText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnnexCElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain10_C"));
		}
		// ���� "�"
		private TextInput getNumberAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnnexCElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main10_C"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main10_C_ElementsName']"));
		}
		private class Values{
			String setAnnexCText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10")); // ����� ����������
			String setNumberAnnexC = "444222";															// �����
			String setTitleAnnexC = "�������� �����";													// �������� 
			String setDateAnnexC = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnnexC = "��� ����������";													// ����������
		}
		private class Docs_Elements{
			// ������ ����������
			private Button getAddButton(){
				return new Button(driver, By.id("add_edit_tab"));
			}
						
			// ���-�� ����������
			private Custom getAddEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}
						
			// "������������"
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_tab10_C"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocDescribe"));
			}
						
			// ��������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab10Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocLinkFile"));
			}
						
			// ������ '���������'
			private Button getSaveButton(){
				return new Button(driver, By.id("save_dialog_btn"));
			}
								
			private class Values{
				private String addEditPopUpName = "�������� ����� ������";				// �������� ���-��� ����������/�������������� ���������
				private String date = new CustomMethods().getCurrentDate(); 	 		// ����
				private String name = "����";						     				// �������� ���������
				private String docDescription = "��������";						    	// �������� ���������
				private String docType = "����������� ����������";						// ����������
				private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";	// ������ �� ����(��������)
				private String fileName = "ForDocAdd.txt";								// �������� �����
				private String fileLink = "www.getFile.com/get";			     		// ������ �� ���� 
			}
			
		}
		
	}

}
