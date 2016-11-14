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
	public void Anne�D_FillUp(){
		// ������� �� ������� ���������� D
		new Anne�D().getAnne�DTab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�D().getAnne�DTe�t(),
				new Anne�D().new Values().setAnne�DText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�D().getAnne�DElementsButton().click();
		new Anne�D().getNumberAnne�D().waitUntilAvailable();
		new Anne�D().getNumberAnne�D().inputText(new Anne�D().new Values().setNumberAnne�D);
		new Anne�D().getTitleAnne�D().inputText(new Anne�D().new Values().setTitleAnnexD);
		new Anne�D().getDateAnne�D().click();
		new Anne�D().getDateAnne�D().inputText(new Anne�D().new Values().setDateAnnexD);
		new Anne�D().getNoteAnne�D().inputText(new Anne�D().new Values().setNoteAnnexD);
		new Anne�D().getSaveAnne�DElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�D().getGridDownload_Div(), false);

		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�D().getElementNameCell()).perform();
		simpleWait(2);

		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�D().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�D().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�D().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�D().new Docs_Elements().getDate_Field().inputText(new Anne�D().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�D().new Docs_Elements().getName_Field().inputText(new Anne�D().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�D().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�D().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�D().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�D().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�D().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�D().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�D().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�D().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�D().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�D().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�D().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�D().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void Anne�E_FillUp(){
		// ������� �� ������� ���������� E
		new Anne�E().getAnne�ETab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�E().getAnne�ETe�t(),
				new Anne�E().new Values().setAnne�EText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�E().getAnne�EElementsButton().click();
		new Anne�E().getNumberAnne�E().waitUntilAvailable();
		new Anne�E().getNumberAnne�E().inputText(new Anne�E().new Values().setNumberAnne�E);
		new Anne�E().getTitleAnne�E().inputText(new Anne�E().new Values().setTitleAnne�E);
		new Anne�E().getDateAnne�E().click();
		new Anne�E().getDateAnne�E().inputText(new Anne�E().new Values().setDateAnne�E);
		new Anne�E().getNoteAnne�E().inputText(new Anne�E().new Values().setNoteAnne�E);
		new Anne�E().getSaveAnne�EElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�E().getGridDownload_Div(), false);

		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�E().getElementNameCell()).perform();
		simpleWait(2);

		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�E().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�E().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�E().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�E().new Docs_Elements().getDate_Field().inputText(new Anne�E().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�E().new Docs_Elements().getName_Field().inputText(new Anne�E().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�E().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�E().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�E().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�E().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�E().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�E().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�E().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�E().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�E().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�E().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�E().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�E().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void Anne�F_FillUp(){
		// ������� �� ������� ���������� F
		new Anne�F().getAnne�FTab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�F().getAnne�FTe�t(),
				new Anne�F().new Values().setAnne�FText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�F().getAnne�FElementsButton().click();
		new Anne�F().getNumberAnne�F().waitUntilAvailable();
		new Anne�F().getNumberAnne�F().inputText(new Anne�F().new Values().setNumberAnne�F);
		new Anne�F().getTitleAnne�F().inputText(new Anne�F().new Values().setTitleAnne�F);
		new Anne�F().getDateAnne�F().click();
		new Anne�F().getDateAnne�F().inputText(new Anne�F().new Values().setDateAnne�F);
		new Anne�F().getNoteAnne�F().inputText(new Anne�F().new Values().setNoteAnne�F);
		new Anne�F().getSaveAnne�FElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�F().getGridDownload_Div(), false);

		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�F().getElementNameCell()).perform();
		simpleWait(2);

		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�F().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�F().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�F().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�F().new Docs_Elements().getDate_Field().inputText(new Anne�F().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�F().new Docs_Elements().getName_Field().inputText(new Anne�F().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�F().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�F().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�F().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�F().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�F().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�F().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�F().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�F().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�F().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�F().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�F().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�F().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void Anne�G_FillUp(){
		// ������� �� ������� ���������� G
		new Anne�G().getAnne�GTab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�G().getAnne�GTe�t(),
				new Anne�G().new Values().setAnne�GText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�G().getAnne�FElementsButton().click();
		new Anne�G().getNumberAnne�G().waitUntilAvailable();
		new Anne�G().getNumberAnne�G().inputText(new Anne�G().new Values().setNumberAnne�G);
		new Anne�G().getTitleAnne�G().inputText(new Anne�G().new Values().setTitleAnne�G);
		new Anne�G().getDateAnne�G().click();
		new Anne�G().getDateAnne�G().inputText(new Anne�G().new Values().setDateAnne�G);
		new Anne�G().getNoteAnne�G().inputText(new Anne�G().new Values().setNoteAnne�G);
		new Anne�G().getSaveAnne�GElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�G().getGridDownload_Div(), false);

		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�G().getElementNameCell()).perform();
		simpleWait(2);

		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�G().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�G().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�G().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�G().new Docs_Elements().getDate_Field().inputText(new Anne�G().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�G().new Docs_Elements().getName_Field().inputText(new Anne�G().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�G().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�G().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�G().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�G().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�G().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�G().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�G().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�G().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�G().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�G().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�G().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�G().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void Anne�H_FillUp(){
		// ������� �� ������� ���������� ���������� H - ������������� ��������
		new Anne�H().getAnne�HTab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�H().getAnne�HTe�t(),
				new Anne�H().new Values().setAnne�HText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�H().getAnne�HElementsButton().click();
		new Anne�H().getNumberAnne�H().waitUntilAvailable();
		new Anne�H().getNumberAnne�H().inputText(new Anne�H().new Values().setNumberAnne�H);
		new Anne�H().getTitleAnne�H().inputText(new Anne�H().new Values().setTitleAnne�H);
		new Anne�H().getDateAnne�H().click();
		new Anne�H().getDateAnne�H().inputText(new Anne�H().new Values().setDateAnne�H);
		new Anne�H().getNoteAnne�H().inputText(new Anne�H().new Values().setNoteAnne�H);
		new Anne�H().getSaveAnne�HElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�H().getGridDownload_Div(), false);

		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�H().getElementNameCell()).perform();
		simpleWait(2);

		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�H().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�H().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�H().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�H().new Docs_Elements().getDate_Field().inputText(new Anne�H().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�H().new Docs_Elements().getName_Field().inputText(new Anne�H().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�H().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�H().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�H().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�H().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�H().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�H().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�H().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�H().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�H().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�H().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�H().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�H().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void Anne�I_FillUp(){
		// ������� �� ������� ���������� I - �������� ������������ � �������
		new Anne�I().getAnne�ITab().click();
		// ��������� ���� "����� ����������"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new Anne�I().getAnne�ITe�t(),
				new Anne�I().new Values().setAnne�IText);
		simpleWait(2);
		// ���������� �������� � ���� "�������� ����������"
		new Anne�I().getAnne�IElementsButton().click();
		new Anne�I().getNumberAnne�I().waitUntilAvailable();
		new Anne�I().getNumberAnne�I().inputText(new Anne�I().new Values().setNumberAnne�I);
		new Anne�I().getTitleAnne�I().inputText(new Anne�I().new Values().setTitleAnne�I);
		new Anne�I().getDateAnne�I().click();
		new Anne�I().getDateAnne�I().inputText(new Anne�I().new Values().setDateAnne�I);
		new Anne�I().getNoteAnne�I().inputText(new Anne�I().new Values().setNoteAnne�I);
		new Anne�I().getSaveAnne�IElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new Anne�I().getGridDownload_Div(), false);

		// �������� �� ������ '��������'
		Actions action = new Actions(driver);
		action.click(new Anne�I().getElementNameCell()).perform();
		simpleWait(2);

		// ���������� ���������

		// �������� ���-��� ���������� ���������
		new Anne�I().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Anne�I().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// ����
		new Anne�I().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new Anne�I().new Docs_Elements().getDate_Field().inputText(new Anne�I().new Docs_Elements().new Values().date);
		// �������� ���������
		new Anne�I().new Docs_Elements().getName_Field().inputText(new Anne�I().new Docs_Elements().new Values().name);
		// �������� ���������
		new Anne�I().new Docs_Elements().getDescription_Field()
				.inputText(new Anne�I().new Docs_Elements().new Values().docDescription);
		// ��� ���������
		new Anne�I().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new Anne�I().new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Anne�I().new Docs_Elements().getFileUpload_Button()
				.inputText(new Anne�I().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Anne�I().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new Anne�I().new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Anne�I().new Docs_Elements().getFileLink_Field()
				.inputText(new Anne�I().new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Anne�I().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Anne�I().new Docs_Elements().getGridDownload_Div(), false);
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
	private class Anne�D{
		// ������ �������� �� ������� "���������� D - �������������������� ������� � ��"
		private Custom getAnne�DTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� D - �������������������� ������� � ��')]"));
		}
		// ���� ����� ���������� � 
		private WebElement getAnne�DTe�t() {
			return driver.findElement(By.id("customTextEditor_Tab11_DText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnne�DElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain11_D"));
		}
		// ���� "�"
		private TextInput getNumberAnne�D(){
			return new TextInput(driver, By.id("Tab11EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnne�D(){
			return new TextInput(driver, By.id("Tab11EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnne�D(){
			return new TextInput(driver, By.id("Tab11EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnne�D(){
			return new TextInput(driver, By.id("Tab11EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnne�DElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main11_D"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main11_D_ElementsName']"));
		}
		private class Values{
			String setAnne�DText = readFile.substring(readFile.indexOf("#11"), readFile.indexOf("#12")); // ����� ����������
			String setNumberAnne�D = "444222";															// �����
			String setTitleAnnexD = "�������� �����";													// �������� 
			String setDateAnnexD = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnnexD = "��� ����������";													// ����������
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
				return new Custom(driver, By.id("load_list_tab11_D"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab11Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab11Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab11Grid_DocDescribe"));
			}
						
			// ��������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab11Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab11Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab11Grid_DocLinkFile"));
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
	private class Anne�E{
		// ������ �������� �� ������� "���������� � - �������� � ����������� ���������"
		private Custom getAnne�ETab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� � - �������� � ����������� ���������')]"));
		}
		// ���� ����� ���������� � 
		private WebElement getAnne�ETe�t() {
			return driver.findElement(By.id("customTextEditor_Tab12_EText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnne�EElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain12_E"));
		}
		// ���� "�"
		private TextInput getNumberAnne�E(){
			return new TextInput(driver, By.id("Tab12EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnne�E(){
			return new TextInput(driver, By.id("Tab12EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnne�E(){
			return new TextInput(driver, By.id("Tab12EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnne�E(){
			return new TextInput(driver, By.id("Tab12EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnne�EElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main12_E"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main12_E_ElementsName']"));
		}
		private class Values{
			String setAnne�EText = readFile.substring(readFile.indexOf("#12"), readFile.indexOf("#13")); // ����� ����������
			String setNumberAnne�E = "444222";															// �����
			String setTitleAnne�E = "�������� �����";													// �������� 
			String setDateAnne�E = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnne�E = "��� ����������";													// ����������
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
				return new Custom(driver, By.id("load_list_tab12_E"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab12Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab12Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab12Grid_DocDescribe"));
			}
						
			// ��������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab12Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab12Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab12Grid_DocLinkFile"));
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
	private class Anne�F{
		// ������ �������� �� ������� "���������� F - ������������� ������� ��������������"
		private Custom getAnne�FTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� F - ������������� ������� ��������������')]"));
		}
		// ���� ����� ���������� � 
		private WebElement getAnne�FTe�t() {
			return driver.findElement(By.id("customTextEditor_Tab13_FText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnne�FElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain13_F"));
		}
		// ���� "�"
		private TextInput getNumberAnne�F(){
			return new TextInput(driver, By.id("Tab13EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnne�F(){
			return new TextInput(driver, By.id("Tab13EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnne�F(){
			return new TextInput(driver, By.id("Tab13EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnne�F(){
			return new TextInput(driver, By.id("Tab13EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnne�FElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main13_F"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main13_F_ElementsName']"));
		}
		private class Values{
			String setAnne�FText = readFile.substring(readFile.indexOf("#13"), readFile.indexOf("#14")); // ����� ����������
			String setNumberAnne�F = "444222";															// �����
			String setTitleAnne�F = "�������� �����";													// �������� 
			String setDateAnne�F = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnne�F = "��� ����������";													// ����������
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
				return new Custom(driver, By.id("load_list_tab13_F"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab13Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab13Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab13Grid_DocDescribe"));
			}
						
			// ��������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab13Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab13Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab13Grid_DocLinkFile"));
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
	private class Anne�G{
		// ������ �������� �� ������� "���������� G - ������� �������� ��������"
		private Custom getAnne�GTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� G - ������� �������� ��������')]"));
		}
		// ���� ����� ���������� G 
		private WebElement getAnne�GTe�t() {
			return driver.findElement(By.id("customTextEditor_Tab14_GText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnne�FElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain14_G"));
		}
		// ���� "�"
		private TextInput getNumberAnne�G(){
			return new TextInput(driver, By.id("Tab14EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnne�G(){
			return new TextInput(driver, By.id("Tab14EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnne�G(){
			return new TextInput(driver, By.id("Tab14EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnne�G(){
			return new TextInput(driver, By.id("Tab14EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnne�GElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main14_G"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main14_G_ElementsName']"));
		}
		private class Values{
			String setAnne�GText = readFile.substring(readFile.indexOf("#14"), readFile.indexOf("#15")); // ����� ����������
			String setNumberAnne�G = "444222";															// �����
			String setTitleAnne�G = "�������� �����";													// �������� 
			String setDateAnne�G = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnne�G = "��� ����������";													// ����������
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
				return new Custom(driver, By.id("load_list_tab14_G"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab14Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab14Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab14Grid_DocDescribe"));
			}
						
			// ��������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab14Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab14Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab14Grid_DocLinkFile"));
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
	private class Anne�H{
		// ������ �������� �� ������� "���������� H - ������������� ��������"
		private Custom getAnne�HTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� H - ������������� ��������')]"));
		}
		// ���� ����� ���������� G 
		private WebElement getAnne�HTe�t() {
			return driver.findElement(By.id("customTextEditor_Tab15_HText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnne�HElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain15_H"));
		}
		// ���� "�"
		private TextInput getNumberAnne�H(){
			return new TextInput(driver, By.id("Tab15EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnne�H(){
			return new TextInput(driver, By.id("Tab15EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnne�H(){
			return new TextInput(driver, By.id("Tab15EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnne�H(){
			return new TextInput(driver, By.id("Tab15EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnne�HElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main15_H"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main15_H_ElementsName']"));
		}
		private class Values{
			String setAnne�HText = readFile.substring(readFile.indexOf("#15"), readFile.indexOf("#16")); // ����� ����������
			String setNumberAnne�H = "444222";															// �����
			String setTitleAnne�H = "�������� �����";													// �������� 
			String setDateAnne�H = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnne�H = "��� ����������";													// ����������
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
				return new Custom(driver, By.id("load_list_tab15_H"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab15Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab15Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab15Grid_DocDescribe"));
			}
						
			// ��������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab15Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab15Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab15Grid_DocLinkFile"));
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
	private class Anne�I{
		// ������ �������� �� ������� "���������� H - ������������� ��������"
		private Custom getAnne�ITab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '���������� I - �������� ������������ � �������')]"));
		}
		// ���� ����� ���������� I 
		private WebElement getAnne�ITe�t() {
			return driver.findElement(By.id("customTextEditor_Tab16_IText1_DesignIFrame"));
		}
		// ������ ���������� ��������� ���������� 
		private Button getAnne�IElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain16_I"));
		}
		// ���� "�"
		private TextInput getNumberAnne�I(){
			return new TextInput(driver, By.id("Tab16EGrid_ElementsNumber"));
		}
		// ���� �������� 
		private TextInput getTitleAnne�I(){
			return new TextInput(driver, By.id("Tab16EGrid_ElementsName"));
		}
		// ���� ����
		private TextInput getDateAnne�I(){
			return new TextInput(driver, By.id("Tab16EGrid_ElementsDate"));
		}
		// ���� ���������� 
		private TextInput getNoteAnne�I(){
			return new TextInput(driver, By.id("Tab16EGrid_ElementsNote"));
		}
		// ������ ���������(popUp)
		private Button getSaveAnne�IElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// �������� �����
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main16_I"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main16_I_ElementsName']"));
		}
		private class Values{
			String setAnne�IText = readFile.substring(readFile.indexOf("#16"), readFile.indexOf("#17")); // ����� ����������
			String setNumberAnne�I = "444222";															// �����
			String setTitleAnne�I = "�������� �����";													// �������� 
			String setDateAnne�I = new CustomMethods().getCurrentDate();								// ����
			String setNoteAnne�I = "��� ����������";													// ����������
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
				return new Custom(driver, By.id("load_list_tab16_I"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab16Grid_DocDate"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab16Grid_DocName"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab16Grid_DocDescribe"));
			}
						
			// ��������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab16Grid_DocCategory")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab16Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab16Grid_DocLinkFile"));
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
