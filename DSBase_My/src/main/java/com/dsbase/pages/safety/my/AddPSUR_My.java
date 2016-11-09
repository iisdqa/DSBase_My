package com.dsbase.pages.safety.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;

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






public class AddPSUR_My extends WebPage<AddPSUR_My> {
	private static final String PAGE_URL = BASE_URL + "/Reports/Add";
	public AddPSUR_My(WebDriver driver){
		super (driver);
	}
	@Override
	public AddPSUR_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override 
	public boolean isAvailable() {
		return new DrugPopUp().getButtonOpenDrugPopUp().isAvailable();
	}
	//______________________________________________Actions_______________________________________________________//
	public void PopUpTradeNameFields_FillUp(){    
    	// ����� ��������� 
		new DrugPopUp().getButtonOpenDrugPopUp().waitUntilAvailable();
		new DrugPopUp().getButtonOpenDrugPopUp().click();
		new DrugPopUp().getSearchButton().waitUntilAvailable();
		// ���������� ���� ������ ��������������
		new DrugPopUp().getMarketingCountry().selectByVisibleText(new DrugPopUp().new Values().marketingCountry);
		// ���������� ���� �������� ��������:
		new DrugPopUp().getTradeName().inputText(new DrugPopUp().new Values().tradeName);
		// �������� �� ������ "�����"
		new DrugPopUp().getSearchButton().click();
		// ������� ��������� �����
		waitForBlockStatus(new DrugPopUp().getGridDownload_Div(), false);
		// �������� �� ������ '�������� ���������'
		Actions action = new Actions(driver);
		action.click((new DrugPopUp().getTradeNameCell())).perform();
		simpleWait(2);
		// ������� ��������
		new  DrugPopUp().getChooseButton().click();
		simpleWait(2);
	}
	public void OtherFields_FillUp(){
		// ���������� ���� �������� �����
		new OtherPSURFields().getNamePSUR().inputText(new OtherPSURFields().new OtherValues().name);
		// ���������� ���� ���� ������ ��������� �������
		new OtherPSURFields().getReportingPeriodSartDate().click();
		new OtherPSURFields().getReportingPeriodSartDate().inputText(new OtherPSURFields().new OtherValues().ReportingPeriodSartDate);
		// ���������� ���� ���� ��������� ��������� �������
		new OtherPSURFields().getReportingPeriodEndDate().click();
		new OtherPSURFields().getReportingPeriodEndDate().inputText(new OtherPSURFields().new OtherValues().ReportingPeriodEndDate);
		// ���������� ���� ���� ������������ ������
		new OtherPSURFields().getReportCreationDate().click();
		new OtherPSURFields().getReportCreationDate().inputText(new OtherPSURFields().new OtherValues().ReportCreationDate);
		// ����������� ���� �������������� ������ � ������������ �����
		new OtherPSURFields().getRequiredDate().click();
		new OtherPSURFields().getRequiredDate().inputText(new OtherPSURFields().new OtherValues().RequiredDate);
		// ����������� ���� �������������� ������ � ������������ �����
		new OtherPSURFields().getActualDate().click();
		new OtherPSURFields().getActualDate().inputText(new OtherPSURFields().new OtherValues().ActualDate);
		// ���� ������ ������ � ������� ���������� �� ���������������:
		new OtherPSURFields().getSubmissionDate().click();
		new OtherPSURFields().getSubmissionDate().inputText(new OtherPSURFields().new OtherValues().SubmissionDate);
		// ���� ������ ���������� ��������� �������
		new OtherPSURFields().getNextStartDate().click();
		new OtherPSURFields().getNextStartDate().inputText(new OtherPSURFields().new OtherValues().NextStartDate);
		// ���� ��������� ���������� ��������� �������
		new OtherPSURFields().getNextEndDate().click();
		new OtherPSURFields().getNextEndDate().inputText(new OtherPSURFields().new OtherValues().NextEndDate);
		// ����������� ���� �������������� ���������� ������:
		new OtherPSURFields().getNextReportSubmitionDate().click();
		new OtherPSURFields().getNextReportSubmitionDate().inputText(new OtherPSURFields().new OtherValues().NextReportSubmitionDate);
	}
	public void doc_Add(){		
		// �������� ���-��� ���������� ���������
		new Docs_Elements().getAddButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Docs_Elements().getAddEditPopUp()));
			simpleWait(2);
			
		// ����
		new Docs_Elements().getDate_Field().click();
			simpleWait(1);
		    new Docs_Elements().getDate_Field().inputText(new Docs_Elements().new Values().date);
		// �������� ���������
		new Docs_Elements().getName_Field().inputText(new Docs_Elements().new Values().name);
		// �������� ���������
		new Docs_Elements().getDescription_Field().inputText(new Docs_Elements().new Values().docDescription);	
		// ��� ���������
		new Docs_Elements().getDocType_Field().selectByVisibleText(new Docs_Elements().new Values().docType);
		// ���������� ���� + �������� ����������� � ��������� ����
		new Docs_Elements().getFileUpload_Button().inputText(new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new Docs_Elements().getFile_Field().getAttribute("value"), is(equalTo(new Docs_Elements().new Values().fileName)));
		// ������ �� ����
		new Docs_Elements().getFileLink_Field().inputText(new Docs_Elements().new Values().fileLink);
		// ���������� �����
		new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// �������� ��������� �����
		waitForBlockStatus(new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}
	public void fileUnload_check(){
		new CustomMethods().new WorkWith_TextFiles().fileDownload_Check(new Docs_Elements().getFileDownloadButton(), "ForDocAdd.txt");
	}
	public void SavePSUR(){
		new OtherPSURFields().getSaveButton().click();
	new BodyOfPSUR().getReportSectionsButton().waitUntilAvailable();
	}
	// ���������� �������� �����
	public void TitlePagePSUR_FillUp(){
		new BodyOfPSUR().getReportSectionsButton().click();
		simpleWait(2);
		// ���������� ������� "��������� ����"
		new BodyOfPSUR().new TitlePageElements().getDocumetsButton().waitUntilAvailable();
		new BodyOfPSUR().new TitlePageElements().getDatabaseClosureDate().click();
		new BodyOfPSUR().new TitlePageElements().getDatabaseClosureDate().inputText(new BodyOfPSUR().new TitlePageElements().new TitlePageValues().databaseClosureDate);
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new TitlePageElements().getTitlePageText(), 
																   new BodyOfPSUR().new TitlePageElements().new TitlePageValues().titlePageText);
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new TitlePageElements().getPrivacyPolicy(),
																   new BodyOfPSUR().new TitlePageElements().new TitlePageValues().privacyPolicy);
		new BodyOfPSUR().new TitlePageElements().getQualifiedPerson().inputText(new BodyOfPSUR().new TitlePageElements().new TitlePageValues().qualifiedPerson);
		new BodyOfPSUR().new TitlePageElements().getContactData().inputText(new BodyOfPSUR().new TitlePageElements().new TitlePageValues().contactData);
		new BodyOfPSUR().getSaveButton().click();
	}
	public void ContentsAndSummary_FillUP(){
		// ������� �� ������� "���������� � ������" 
		new BodyOfPSUR().new ContentsAndSummary().getContentAndSummaryTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,new BodyOfPSUR().new ContentsAndSummary().getFormatAndContentText(),
																   new BodyOfPSUR().new ContentsAndSummary().new Values().contentsAndSummary);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void Introduction_FillUp(){
		// ������� �� ������� "��������"
		new BodyOfPSUR().new Introduction().getIntroductionTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new Introduction().get1SectionTe�t(),
																   new BodyOfPSUR().new Introduction().new Values().introduction);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void WorldwideAuthorisationStatus_FillUp(){
		// ������� �� ������� "2. ��������������� ������ � ����"
		new BodyOfPSUR().new WorldwideStatus().getWorldwideStatusTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 2"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new WorldwideStatus().get2SectionTe�t(),
																  new BodyOfPSUR().new WorldwideStatus().new Values().worldwideStatus);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void ActionsTaken_FillUP(){
		// ������� �� ������� "3. ���� � ����� � ������ ������� �� ������������"
		new BodyOfPSUR().new ActionsTaken().getActionsTakenTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 2"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ActionsTaken().get3SectionTe�t(),
																   new BodyOfPSUR().new ActionsTaken().new Values().actionsTaken);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void ChangesSafetyInformation_FillUp(){
		// ������� �� ������� "4. ��������� � �� �� ������������"
		new BodyOfPSUR().new ChangesSafetyInformation().getChangesSafetyInformationTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 4"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ChangesSafetyInformation().get4SectionTe�t(),
																   new BodyOfPSUR().new ChangesSafetyInformation().new Values().changesSafetyInformation);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void EstimatedExposure_FillUp(){
		// ������� �� ������� ������� �� ������� "5. �������� � ���������� ���������, ���������� ������������� �������� �� �������� ������"
		new BodyOfPSUR().new EstimatedExposure().getEstimatedExposureTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 5"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get5SectionTe�t(),
																  new BodyOfPSUR().new EstimatedExposure().new Values().fiveSectionTe�t);
		// ���������� ���� "����� ����� ������ 5.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get51ItemTe�t(),
																   new BodyOfPSUR().new EstimatedExposure().new Values().fivePoint1Section);
		// ���������� ���� "����� ����� ������ 5.2"
				new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get52ItemTe�t(),
																		  new BodyOfPSUR().new EstimatedExposure().new Values().fivePoint2Section);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void DataInSummaryTabulations_FillUp(){
		// ������� �� ������� ������� �� ������� "6. ���������� ��������� ������ � ���������� ������������� ��������"
		new BodyOfPSUR().new DataInSummaryTabulations().getDataInSummaryTabulationsTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 6"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get6SectionTe�t(), 
																   new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixSectionText);
		// ����������� ���� "����� ������ 6.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get61ItemTe�t(),
																   new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixPoint1ItemText);
		// ����������� ���� ����� ������ 6.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get62ItemTe�t(), 
																		new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixPoint2ItemText);
		// ���������� ��������� � ������� "������� 6.2"
		new BodyOfPSUR().new DataInSummaryTabulations().getNewTabValue().click();
		new BodyOfPSUR().new DataInSummaryTabulations().getMedDraButton().waitUntilAvailable();
		new BodyOfPSUR().new DataInSummaryTabulations().getSystemOrganClass().inputText(new BodyOfPSUR().new DataInSummaryTabulations().new Values().setSystemOrganClass); 
		new BodyOfPSUR().new DataInSummaryTabulations().getInvestigationalProduct().inputText(new BodyOfPSUR().new DataInSummaryTabulations().new Values().setInvestigationalProduct);
		new BodyOfPSUR().new DataInSummaryTabulations().getBlinded().inputText(new BodyOfPSUR().new DataInSummaryTabulations().new Values().setBlinded);
		new BodyOfPSUR().new DataInSummaryTabulations().getActiveComparator().inputText(new BodyOfPSUR().new DataInSummaryTabulations().new Values().setActiveComparator );
		new BodyOfPSUR().new DataInSummaryTabulations().getPlacebo().inputText(new BodyOfPSUR().new DataInSummaryTabulations().new Values().setPlacebo );
		simpleWait(2);
		new BodyOfPSUR().new DataInSummaryTabulations().getSaveDialogButton().click();
		simpleWait(2);
		waitForBlockStatus(new BodyOfPSUR().new DataInSummaryTabulations().getGridDownload_Div(), false);
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get63ItemTe�t(),
																	new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixPoint3ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void SummariesOfSignificantFindings_FillUp(){
		// ������� �� ������� ������� �� ������� "7. ������ ������ ������, ���������� � ���� ����������� ������������ �� �������� ������"
		new BodyOfPSUR().new SummariesOfSignificantFindings().getSummariesOfSignificantFindingsTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 7"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get7SectionTe�t()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenSectionText);	
		// ����������� ���� "����� ������ 7.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get71ItemTe�t()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint1ItemText);
		// ����������� ���� ����� ������ 7.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get72ItemTe�t() 
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint2ItemText);
		// ����������� ���� ����� ������ 7.3
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get73ItemTe�t()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint3ItemText);
		// ����������� ���� ����� ������ 7.4
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get74ItemTe�t() 
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint4ItemText);
		// ����������� ���� ����� ������ 7.5
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get75ItemTe�t()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint5ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void FindingsFromNonInterventionalStudies_FillUp(){
	// ������� �� ������� "8 ����� ����������������� �����������"
		new BodyOfPSUR().new FindingsFromNonInterventionalStudies().getFindingsFromNonInterventionalStudiesTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 8"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new FindingsFromNonInterventionalStudies().get8SectionTe�t(),
																		   new BodyOfPSUR().new FindingsFromNonInterventionalStudies().new Values().setEightSectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void InformationFromOtherClinicalTrials_FillUp(){
		// ������� �� ������� "8 ����� ����������������� �����������"
		new BodyOfPSUR().new InformationFromOtherClinicalTrials().getInformationFromOtherClinicalTrialsTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 9"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new InformationFromOtherClinicalTrials().get9SectionTe�t(),
																   new BodyOfPSUR().new InformationFromOtherClinicalTrials().new Values().setNineSectionText);
		// ����������� ���� "����� ������ 9.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new InformationFromOtherClinicalTrials().get91ItemTe�t()
																  ,new BodyOfPSUR().new InformationFromOtherClinicalTrials().new Values().setNinePoint1ItemText);
		// ����������� ���� ����� ������ 9.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new InformationFromOtherClinicalTrials().get92ItemTe�t() 
																   ,new BodyOfPSUR().new InformationFromOtherClinicalTrials().new Values().setNinePoint2ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void NonClinicalData_FillUp(){
		// ������� �� ������� "10. ������ ������������� ������������"
		new BodyOfPSUR().new NonClinicalData().getNonClinicalDataTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 10"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new NonClinicalData().get10SectionTe�t(),
																		   new BodyOfPSUR().new NonClinicalData().new Values().setTenSectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void Literature_FillUp(){
		// ������� �� ������� "10. ������ ������������� ������������"
		new BodyOfPSUR().new Literature().getLiteratureTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 10"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new Literature().get11SectionTe�t(),
																		   new BodyOfPSUR().new Literature().new Values().set11SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void OtherPeriodicReports_FillUp(){
		// ������� �� ������� "12. ������ ������������� ������ (��� �������)"
		new BodyOfPSUR().new OtherPeriodicReports().getOtherPeriodicReportsTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 12"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new OtherPeriodicReports().get12SectionTe�t(),
																		   new BodyOfPSUR().new OtherPeriodicReports().new Values().set12SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void LackOfEfficacy_FillUp(){
		// ������� �� ������� 13. ������������� ��������������� ������������� � �������������� ����������� �������������
		new BodyOfPSUR().new LackOfEfficacy().getLackOfEfficacyTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 13"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new LackOfEfficacy().get13SectionTe�t(),
																		   new BodyOfPSUR().new LackOfEfficacy().new Values().set13SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void LateBreakingInformation_FillUp(){
		// ������� �� ������� 14. ������ ����������, ���������� ����� ���������� ���������� ���
		new BodyOfPSUR().new LateBreakingInformation().getLateBreakingInformationTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 14"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new LateBreakingInformation().get14SectionTe�t(),
																		   new BodyOfPSUR().new LateBreakingInformation().new Values().set14SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void OverviewOfSignals_FillUP(){
		// ������� �� ������� 14. ������ ����������, ���������� ����� ���������� ���������� ���
		new BodyOfPSUR().new OverviewOfSignals().getOverviewOfSignalsTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 14"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new OverviewOfSignals().get15SectionTe�t(),
																	       new BodyOfPSUR().new OverviewOfSignals().new Values().set15SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void SignalAndRiskEvaluation_FillUp(){
		// ������� �� ������� ������� �� ������� "16. ������� ������������ � ������ ����� ���������� �������������� ���������"
		new BodyOfPSUR().new SignalAndRiskEvaluation().getSignalAndRiskEvaluationTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 16"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16SectionTe�t()
																  ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16SectionText);	
		// ����������� ���� "����� ������ 16.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point1ItemTe�t()
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point1ItemText);
		// ����������� ���� ����� ������ 16.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point2ItemTe�t() 
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point2ItemText);
		// ����������� ���� ����� ������ 16.3
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point3ItemTe�t()
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point3ItemText);
		// ����������� ���� ����� ������ 16.4
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point4ItemTe�t() 
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point4ItemText);
		// ����������� ���� ����� ������ 16.5
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point5ItemTe�t()
																		   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point5ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void BenefitEvaluation_FillUp(){
		// ������� �� ������� ������� �� ������� "17. ������ ������"
		new BodyOfPSUR().new BenefitEvaluation().getBenefitEvaluationTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 17"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new BenefitEvaluation().get17SectionTe�t()
																   ,new BodyOfPSUR().new BenefitEvaluation().new Values().set17SectionText);	
		// ����������� ���� "����� ������ 17.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new BenefitEvaluation().get17Point1ItemTe�t()
																   ,new BodyOfPSUR().new BenefitEvaluation().new Values().set17Point1ItemText);
		// ����������� ���� ����� ������ 17.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new BenefitEvaluation().get17Point2ItemTe�t() 
																   ,new BodyOfPSUR().new BenefitEvaluation().new Values().set17Point2ItemText);
		// ����������� ���� ����� ������ 17.3
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new BenefitEvaluation().get17Point3ItemTe�t()
																   ,new BodyOfPSUR().new BenefitEvaluation().new Values().set17Point3ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void IntegratedBenefitRisk_FillUp(){
		// ������� �� ������� ������� �� ������� "18. ������ ������"
		new BodyOfPSUR().new IntegratedBenefitRisk().getIntegratedBenefitRiskTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 18"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new IntegratedBenefitRisk().get18SectionTe�t()
																   ,new BodyOfPSUR().new IntegratedBenefitRisk().new Values().set18SectionText);	
		// ����������� ���� "����� ������ 18.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new IntegratedBenefitRisk().get18Point1ItemTe�t()
																   ,new BodyOfPSUR().new IntegratedBenefitRisk().new Values().set18Point1ItemText);
		// ����������� ���� ����� ������ 18.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new IntegratedBenefitRisk().get18Point2ItemTe�t() 
																   ,new BodyOfPSUR().new IntegratedBenefitRisk().new Values().set18Point2ItemText);
	}
	public void ConclusionsAndActions_FillUp(){
		// ������� �� ������� "19. ���������� � ��������"
		new BodyOfPSUR().new ConclusionsAndActions().getConclusionsAndActionsTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 19"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ConclusionsAndActions().get19SectionTe�t(),
																		   new BodyOfPSUR().new ConclusionsAndActions().new Values().set19SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void AppendicesToThePSUR_FillUp(){
		// ������� �� ������� "20. ���������� � ���"
		new BodyOfPSUR().new AppendicesToThePSUR().getAppendicesToThePSURTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 20"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new AppendicesToThePSUR().get20SectionTe�t(),
																		   new BodyOfPSUR().new AppendicesToThePSUR().new Values().set20SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void MappingSignalsAndRisksToPSUR_FillUp(){
		// ������� �� ������� "21. ����������� �������� � ������"
		new BodyOfPSUR().new MappingSignalsAndRisksToPSUR().getMappingSignalsAndRisksToPSURTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// ���������� ���� "����� ������� 21"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new MappingSignalsAndRisksToPSUR().get21SectionTe�t(),
																		   new BodyOfPSUR().new MappingSignalsAndRisksToPSUR().new Values().set21SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
//	public void tesr(){
//		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		  driver.switchTo().window(tabs.get(1));
//		 /* ���������� ��� ���� ����*/
//		 driver.close();
//		driver.switchTo().window(tabs.get(0));
//		
//	}

		
	//______________________________________________Elements_____________________________________________________//
	
	private class DrugPopUp {
		// ������ �������� ���-��� 
		private Button getButtonOpenDrugPopUp(){
			return new Button(driver, By.id("open_trade_names"));
		}
		// ��������� ����� ���������
		private Custom getGridDownload_Div(){															
			return new Custom(driver, By.id("load_list_tradenames"));
		}
		// ������ ��������������
		private Select getMarketingCountry(){
			return new Select(driver.findElement(By.id("TradeNameControl_Country")));
		}
		// �������� ��������
		private TextInput getTradeName(){
			return new TextInput(driver, By.id("TradeNameControl_Name"));
		}
		// Button "Search"
		private Button getSearchButton(){
			return new Button(driver, By.id("TradeNameControl_Find"));
		}
		// Button Choose
		private Button getChooseButton(){
			return new Button(driver, By.id("TradeNameControl_Choose"));
		}
		private WebElement getTradeNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tradenames_TradeName']"));
		}
		private class Values{
			private String marketingCountry = "�����";                                   // ������ ��������������
			private String tradeName = "�������� ��������";								 // �������� ��������
		}
		
	}
	// �������� ����� '���������'
		private class Docs_Elements{
			// ������ ����������
			private Button getAddButton(){
				return new Button(driver, By.xpath("//input[@onclick='AddEditFile()']"));
			}
						
			// ���-�� ����������
			private Custom getAddEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}
						
			// "������������"
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_file_load"));
			}
						
			// <tbody> �����
			private WebElement getDocsGridBody(){
				return driver.findElement(By.xpath("//*[@id='list_file_load']/tbody"));
			}
						
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Date"));
			}
						
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Title"));
			}
						
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Description"));
			}
						
			// �������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("TypeId")));
			}
						
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("FileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("FileLink"));
			}
						
			// ������ '���������'
			private Button getSaveButton(){
				return new Button(driver, By.id("save_file_btn"));
			}
						
			// ������ �������� �����
			private Button getFileDownloadButton(){
				return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_load']/input"));
			}
						
			private class Values{
				private String addEditPopUpName = "���������� ���������";				// �������� ���-��� ����������/�������������� ���������
				private String date = new CustomMethods().getCurrentDate(); 	 		// ����
				private String name = "����";						     				// �������� ���������
				private String docDescription = "��������";						    	// �������� ���������
				private String docType = "����������";						     		// ����������
				private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";	// ������ �� ����(��������)
				private String fileName = "ForDocAdd.txt";								// �������� �����
				private String fileLink = "www.getFile.com/get";			     		// ������ �� ���� 
			}
		}
		public void addedDoc_check(){
			// ����������� ��������� ��������
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
						  						  new Docs_Elements().new Values().date,
												  new Docs_Elements().new Values().name,
												  new Docs_Elements().new Values().docDescription,
												  new Docs_Elements().new Values().docType,
												  new Docs_Elements().new Values().fileLink,
												  "",
												  ""};
				
			// ����������� ���������� ��������
			String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Docs_Elements().getDocsGridBody());
				
			// �������� �������� �����
			new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
			}
	private class OtherPSURFields{
		// �������� �����
		private TextInput getNamePSUR(){
			return new TextInput(driver, By.id("name"));
		}
		// ���� ������ ��������� �������
		private TextInput getReportingPeriodSartDate(){
			return new TextInput(driver, By.id("start_period"));
		}
		// ���� ��������� ��������� �������
		private TextInput getReportingPeriodEndDate(){
			return new TextInput(driver, By.id("end_period"));
		}
		// ���� ������������ ������
		private TextInput getReportCreationDate(){
			return new TextInput(driver, By.id("report_date"));
		}
		// ����������� ���� �������������� ������ � ������������ �����
		private TextInput getRequiredDate(){
			return new TextInput(driver, By.id("required_provision"));
		}
		// ����������� ���� �������������� ������ � ������������ �����
		private TextInput getActualDate(){
			return new TextInput(driver, By.id("fact_provision"));
		}
		// ���� ������ ������ � ������� ���������� �� ���������������:
		private TextInput getSubmissionDate(){
			return new TextInput(driver, By.id("filing_registration"));
		}
		// ���� ������ ���������� ��������� �������
		private TextInput getNextStartDate(){
			return new TextInput(driver, By.id("start_next_period"));
		}
		// ���� ��������� ���������� ��������� �������
		private TextInput getNextEndDate(){
			return new TextInput(driver, By.id("end_next_period"));
		}
		// ����������� ���� �������������� ���������� ������:
		private TextInput getNextReportSubmitionDate(){
			return new TextInput(driver, By.id("required_provision_next"));
		}
		// ������ ���������
		private Button getSaveButton(){
			return new Button(driver, By.xpath("//input[@type='button' and contains(@value, '���������')]"));
		}
		private class OtherValues{
			private String name = "AutoTestPSUR"; 												// ����� �����
			private String ReportingPeriodSartDate = new CustomMethods().getCurrentDate(); 		// ���� ������ ��������� �������
			private String ReportingPeriodEndDate = new CustomMethods().getChangedDate(4);		// ���� ��������� ��������� �������
			private String ReportCreationDate = new CustomMethods().getCurrentDate(); 		    // ���� ������������ ������
			private String RequiredDate = new CustomMethods().getCurrentDate();					// ����������� ���� �������������� ������ � ������������ �����
			private String ActualDate = new CustomMethods().getChangedDate(1);					// ����������� ���� �������������� ������ � ������������ �����
			private String SubmissionDate = new CustomMethods().getChangedDate(5);				// ���� ������ ������ � ������� ���������� �� ���������������:
			private String NextStartDate = new CustomMethods().getChangedDate(5);				// ���� ������ ���������� ��������� �������
			private String NextEndDate = new CustomMethods().getChangedDate(7);					// ���� ��������� ���������� ��������� �������
			private String NextReportSubmitionDate = new CustomMethods().getChangedDate(8);		// ����������� ���� �������������� ���������� ������:
			
		}
	}
	private class BodyOfPSUR{
		private final String pSURfilePath = "C:\\Selenium_TestData\\Projects\\DSBase\\PSUR\\";									 				// ���� � ����� ������� ��� �������� 
		private final String readFile = new CustomMethods().new WorkWith_TextFiles().file_Read(pSURfilePath + "PSUR.txt");						// ������ ����� (���������������� � ������)
		// ������ ������� ������
		private Button getReportSectionsButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick, 'RedirectWithControllEdit')]"));
		}
		// ������ "���������"(������� �����)
		private Button getSaveButton(){
			return new Button(driver, By.id("save_btn"));
		}
		// ������ �������� "��������"
		private Button getAddDocumentButton(){
			return new Button(driver, By.id("add_edit_file"));
		}
		private class TitlePageElements{
			// ���� �������� ���� ������
			private TextInput getDatabaseClosureDate(){
				return new TextInput(driver, By.id("Tab0_ClosureDate"));
			}
			// ����� ��:
			private WebElement getTitlePageText(){
				return driver.findElement(By.id("customTextEditor_Tab0Text1_DesignIFrame"));
						
			}
			// ��������� � ������������������
			private WebElement getPrivacyPolicy(){
				return driver.findElement(By.id("customTextEditor_Tab0PrivacyStatement_DesignIFrame"));
			}
			
			// ������ ���������� ��������� 
			private Button getDocumetsButton(){
				return new Button(driver, By.id("add_edit_file"));
			}
			// ���� "�������������� ���� �� ��������������"
			private TextInput getQualifiedPerson(){
				return new TextInput(driver, By.id("Tab0_PersonPharmacovigilance"));
			}
			// ������ ��� ��������
			private TextInput getContactData(){
				return new TextInput(driver, By.id("Tab0_ContactData"));
			}
			private class TitlePageValues{
				private String databaseClosureDate= new CustomMethods().getChangedDate(2);
				private String titlePageText = "�������� ����������";                                    	// ���� ����� ��
				private String privacyPolicy = "�������� ���������� �������� �����������������";			// ���� �������� ��������� � ������������������
				private String qualifiedPerson = "������ �������";											// ���� "�������������� ���� �� ��������������"
				private String contactData = "���, ���������";												// ������ ��� ��������
			}	
		}
		private class ContentsAndSummary{
			//������ �������� �� ������� "���������� � ������"
			private Custom getContentAndSummaryTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '���������� � ������')]"));
			}
			// ���� ����� ���
			private WebElement	getFormatAndContentText(){
				return driver.findElement(By.id("customTextEditor_Tab1Text1_DesignIFrame"));
			}
			private class Values{
				private String contentsAndSummary = readFile.substring(readFile.indexOf("#1"), readFile.indexOf("#2")); 							// "���������� � ������"
			}
			
			
		}
		private class Introduction{
			//������ �������� �� ������� "��������"
			private Custom getIntroductionTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '1. ��������')]"));
			}
			// ���� "����� ������� 1"
			private WebElement	get1SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab2Text1_DesignIFrame"));
			}
			private class Values{
				private String introduction = readFile.substring(readFile.indexOf("#2"), readFile.indexOf("#3"));                                   // "��������"
			}
			
		}
		private class WorldwideStatus{
			//������ �������� �� ������� "2. ��������������� ������ � ����"
			private Custom getWorldwideStatusTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '2. ��������������� ������ � ����')]"));
			}
			// ���� "����� ������� 2"
			private WebElement	get2SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab3Text1_DesignIFrame"));
			}
			private class Values{
				private String worldwideStatus = readFile.substring(readFile.indexOf("#3"), readFile.indexOf("#4"));								// 2. ��������������� ������ � ����
			}
		}
		private class ActionsTaken{
			//������ �������� �� ������� "3. ���� � ����� � ������ ������� �� ������������"
			private Custom getActionsTakenTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '3. ���� � ����� � ������ ������� �� ������������')]"));
			}
			// ���� "����� ������� 3"
			private WebElement	get3SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab4Text1_DesignIFrame"));
			}
			private class Values{
				private String actionsTaken = readFile.substring(readFile.indexOf("#4"), readFile.indexOf("#5")); 									// 3. ����, �������� �� �������� ������, � ����� � ���������� ����� ������ �� ������������
			}
		}
		private class ChangesSafetyInformation{
			//������ �������� �� ������� "4. ��������� � �� �� ������������"
			private Custom getChangesSafetyInformationTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '4. ��������� � �� �� ������������')]"));
			}
			// ���� "����� ������� 4"
			private WebElement	get4SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab5Text1_DesignIFrame"));
			}
			private class Values{
				private String changesSafetyInformation = readFile.substring(readFile.indexOf("#5"), readFile.indexOf("#6"));						// 4. ��������� � �� �� ������������
			}
		}
		private class EstimatedExposure{
			//������ �������� �� ������� "5. �������� � ���������, ���������� ��"
			private Custom getEstimatedExposureTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '5. �������� � ���������, ���������� ��')]"));
			}
			// ���� "����� ������� 5"
			private WebElement	get5SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab6Text_DesignIFrame"));
			}
			// ���� "����� ������ 5.1"
			private WebElement	get51ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab6Text1_DesignIFrame"));
			}
			// ���� "����� ������ 5.2"
			private WebElement	get52ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab6Text2_DesignIFrame"));
			}
			private class Values{
				private String fiveSectionTe�t = readFile.substring(readFile.indexOf("#6"), readFile.indexOf("#7"));								// ����� ������� 5:
				private String fivePoint1Section = readFile.substring(readFile.indexOf("#7"), readFile.indexOf("#8"));								// ����� ������ 5.1
				private String fivePoint2Section = readFile.substring(readFile.indexOf("#8"), readFile.indexOf("#9"));								// ����� ������ 5.2
			}
		}
		private class DataInSummaryTabulations{
			//������ �������� �� ������� "6. ���������� �������  � ��"
			private Custom getDataInSummaryTabulationsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '6. ���������� �������  � ��')]"));
			}
			// ���� "����� ������� 6"
			private WebElement	get6SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab7Text_DesignIFrame"));
			}
			// ���� "����� ������ 6.1"
			private WebElement	get61ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab7Text1_DesignIFrame"));
			}
			// ���� "����� ������ 6.2"
			private WebElement	get62ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab7Text2_DesignIFrame"));
			}
			// ���� "����� ������ 6.3"
			private WebElement	get63ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab7Text3_DesignIFrame"));
			}
			// ������ ���������� �������� � "������� 6.2"
			private Button getNewTabValue(){
				return new Button(driver, By.id("add_edit_tab7"));
			}
			// ������ �������� pop-up "MedDRA"
			private Button getMedDraButton(){
				return new Button(driver, By.xpath("//input[contains(@onclick, 'psur_tab7')]"));
			}
			// ���� "����� ������ � �������"
			private TextInput getSystemOrganClass(){
				return new TextInput(driver, By.id("Tab7Grid_ClassSystems"));
			}
			// ���� "����������� ������������� ��������"
			private TextInput getInvestigationalProduct(){
				return new TextInput(driver, By.id("Tab7Grid_InvestigationalDrug"));
			}
			// ���� "����������"
			private TextInput getBlinded(){
				return new TextInput(driver, By.id("Tab7Grid_Blinding"));
			}
			// ���� "�������� ���������"
			private TextInput getActiveComparator(){
				return new TextInput(driver, By.id("Tab7Grid_DrugComparisons"));
			}
			// ���� "�������"
			private TextInput getPlacebo(){
				return new TextInput(driver, By.id("Tab7Grid_Placebo"));
			}
			// ������ ���������� � ���-��
			private Button getSaveDialogButton(){
				return new Button(driver, By.id("save_dialog_btn"));
			}
			// ��������� �����
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_tab7"));
			}
			private class Values{
				private String sixSectionText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10"));	    // ����� ������� 6
				private String sixPoint1ItemText = readFile.substring(readFile.indexOf("#10"), readFile.indexOf("#11"));    // ����� ������ 6.1
				private String sixPoint2ItemText = readFile.substring(readFile.indexOf("#11"), readFile.indexOf("#12"));    // ����� ������ 6.2
				private String sixPoint3ItemText = readFile.substring(readFile.indexOf("#12"), readFile.indexOf("#13"));    // ����� ������ 6.3
				private String setSystemOrganClass = "10002019 - Amylobarbitone dependency"; 								// ����� ������ � �������
				private String setInvestigationalProduct = "�������� ��������";      										// ����������� ������������� ��������
				private String setBlinded = "Sleeping";																		// ����������
				private String setActiveComparator = "Testing drug"; 														// �������� ���������
				private String setPlacebo = "vitamin";																		// �������
		    }
			
		}
		private class SummariesOfSignificantFindings{
			//������ �������� �� ������� "7.  ������ ������ ������, ���������� � ���� ����������� ������������ �� �������� ������"
			private Custom getSummariesOfSignificantFindingsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '7. ������ ����������� ������������')]"));
			}
			// ���� "����� ������� 7"
			private WebElement	get7SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab8Text_DesignIFrame"));
			}
			// ���� "����� ������ 7.1"
			private WebElement	get71ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab8Text1_DesignIFrame"));
			}
			// ���� "����� ������ 7.2"
			private WebElement	get72ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab8Text2_DesignIFrame"));
			}
			// ���� "����� ������ 7.3"
			private WebElement	get73ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab8Text3_DesignIFrame"));
			}
			// ���� "����� ������ 7.4"
			private WebElement	get74ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab8Text4_DesignIFrame"));
			}
			// ���� "����� ������ 7.5"
			private WebElement	get75ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab8Text5_DesignIFrame"));
			}
			private class Values{
				private String setSevenSectionText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10"));	     // ����� ������� 7
				private String setSevenPoint1ItemText = readFile.substring(readFile.indexOf("#10"), readFile.indexOf("#11"));    // ����� ������ 7.1
				private String setSevenPoint2ItemText = readFile.substring(readFile.indexOf("#11"), readFile.indexOf("#12"));    // ����� ������ 7.2
				private String setSevenPoint3ItemText = readFile.substring(readFile.indexOf("#12"), readFile.indexOf("#13"));    // ����� ������ 7.3
				private String setSevenPoint4ItemText = readFile.substring(readFile.indexOf("#13"), readFile.indexOf("#14"));    // ����� ������ 7.4
				private String setSevenPoint5ItemText = readFile.substring(readFile.indexOf("#14"), readFile.indexOf("#15"));    // ����� ������ 7.5
			}
		}
		private class FindingsFromNonInterventionalStudies{
			//������ �������� �� ������� "8. ������ ����������������� ������������"
			private Custom getFindingsFromNonInterventionalStudiesTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '8. ������ ����������������� ������������')]"));
			}
			// ���� "����� ������� 8"
			private WebElement	get8SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab9Text1_DesignIFrame"));
			}
			private class Values{
				private String setEightSectionText = readFile.substring(readFile.indexOf("#15"), readFile.indexOf("#16"));	    // ����� ������� 8
			}
		}
		private class InformationFromOtherClinicalTrials{
			//������ �������� �� ������� "9. ������ ������ ����������� ������������ � �� ������ ����������"
			private Custom getInformationFromOtherClinicalTrialsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '9. ������ ������ �� � ����������')]"));
			}
			// ���� "����� ������� 9"
			private WebElement	get9SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab10Text_DesignIFrame"));
			}
			// ���� "����� ������ 9.1"
			private WebElement	get91ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab10Text1_DesignIFrame"));
			}
			// ���� "����� ������ 9.2"
			private WebElement	get92ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab10Text2_DesignIFrame"));
			}
			private class Values{
				private String setNineSectionText = readFile.substring(readFile.indexOf("#16"), readFile.indexOf("#17"));	    // ����� ������� 9
				private String setNinePoint1ItemText = readFile.substring(readFile.indexOf("#17"), readFile.indexOf("#18"));    // ����� ������ 9.1
				private String setNinePoint2ItemText = readFile.substring(readFile.indexOf("#18"), readFile.indexOf("#19"));    // ����� ������ 9.2
			}
		}
		private class NonClinicalData{
			//������ �������� �� ������� "10. ������ ������������� ������������"
			private Custom getNonClinicalDataTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '10. ������ ������������� ������������')]"));
			}
			// ���� "����� ������� 10"
			private WebElement	get10SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab11Text1_DesignIFrame"));
			}
			private class Values{
				private String setTenSectionText = readFile.substring(readFile.indexOf("#20"), readFile.indexOf("#21"));	    // ����� ������� 10
			}
		}
		private class Literature{
			//������ �������� �� ������� "11. ����������"
			private Custom getLiteratureTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '11. ����������')]"));
			}
			// ���� "����� ������� 11"
			private WebElement	get11SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab12Text1_DesignIFrame"));
			}
			private class Values{
				private String set11SectionText = readFile.substring(readFile.indexOf("#21"), readFile.indexOf("#22"));	    // ����� ������� 11
			}
		}
		private class OtherPeriodicReports{
			//������ �������� �� ������� "12. ������ ������������� ������ (��� �������)"
			private Custom getOtherPeriodicReportsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '12. ������ ������������� ������')]"));
			}
			// ���� "����� ������� 12"
			private WebElement	get12SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab13Text1_DesignIFrame"));
			}
			private class Values{
				private String set12SectionText = readFile.substring(readFile.indexOf("#22"), readFile.indexOf("#23"));	    // ����� ������� 12
			}
		}
		private class LackOfEfficacy{
			//������ �������� �� ������� "13. ������������� ��������������� ������������� � �������������� ����������� �������������"
			private Custom getLackOfEfficacyTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '13. ������������� �� � �������������� ��')]"));
			}
			// ���� "����� ������� 13"
			private WebElement	get13SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab14Text1_DesignIFrame"));
			}
			private class Values{
				private String set13SectionText = readFile.substring(readFile.indexOf("#23"), readFile.indexOf("#24"));	    // ����� ������� 13
			}	
		}
		private class LateBreakingInformation{
			//������ �������� �� ������� "14. ������ ����������, ���������� ����� ���������� ���������� ���"
			private Custom getLateBreakingInformationTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '14. ���-��, ����� ���������� ���')]"));
			}
			// ���� "����� ������� 14"
			private WebElement	get14SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab15Text1_DesignIFrame"));
			}
			private class Values{
				private String set14SectionText = readFile.substring(readFile.indexOf("#24"), readFile.indexOf("#25"));	    // ����� ������� 14
			}	
		}
		private class OverviewOfSignals{
			//������ �������� �� ������� "15. ����� ��������: �����, ��������������� � �����������"
			private Custom getOverviewOfSignalsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '15. ����� ��������')]"));
			}
			// ���� "����� ������� 14"
			private WebElement	get15SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab16Text1_DesignIFrame"));
			}
			private class Values{
				private String set15SectionText = readFile.substring(readFile.indexOf("#25"), readFile.indexOf("#26"));	    // ����� ������� 15
			}	
		}
		private class SignalAndRiskEvaluation{
			//������ �������� �� ������� "16. ������� ������������ � ������ ����� ���������� �������������� ���������"
			private Custom getSignalAndRiskEvaluationTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '16. ������� � ������ �����')]"));
			}
			// ���� "����� ������� 16"
			private WebElement	get16SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab17Text_DesignIFrame"));
			}
			// ���� "����� ������ 16.1"
			private WebElement	get16Point1ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab17Text1_DesignIFrame"));
			}
			// ���� "����� ������ 16.2"
			private WebElement	get16Point2ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab17Text2_DesignIFrame"));
			}
			// ���� "����� ������ 16.3"
			private WebElement	get16Point3ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab17Text3_DesignIFrame"));
			}
			// ���� "����� ������ 16.4"
			private WebElement	get16Point4ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab17Text4_DesignIFrame"));
			}
			// ���� "����� ������ 16.5"
			private WebElement	get16Point5ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab17Text5_DesignIFrame"));
			}
			private class Values{
				private String set16SectionText = readFile.substring(readFile.indexOf("#26"), readFile.indexOf("#27"));	      // ����� ������� 16
				private String set16Point1ItemText = readFile.substring(readFile.indexOf("#27"), readFile.indexOf("#28"));    // ����� ������ 16.1
				private String set16Point2ItemText = readFile.substring(readFile.indexOf("#28"), readFile.indexOf("#29"));    // ����� ������ 16.2
				private String set16Point3ItemText = readFile.substring(readFile.indexOf("#29"), readFile.indexOf("#30"));    // ����� ������ 16.3
				private String set16Point4ItemText = readFile.substring(readFile.indexOf("#30"), readFile.indexOf("#31"));    // ����� ������ 16.4
				private String set16Point5ItemText = readFile.substring(readFile.indexOf("#31"), readFile.indexOf("#32"));    // ����� ������ 16.5
			}
		}
		private class  BenefitEvaluation{
			//������ �������� �� ������� "17. ������ ������"
			private Custom getBenefitEvaluationTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '17. ������ ������')]"));
			}
			// ���� "����� ������� 17"
			private WebElement	get17SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab18Text_DesignIFrame"));
			}
			// ���� "����� ������ 17.1"
			private WebElement	get17Point1ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab18Text1_DesignIFrame"));
			}
			// ���� "����� ������ 17.2"
			private WebElement	get17Point2ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab18Text2_DesignIFrame"));
			}
			// ���� "����� ������ 17.3"
			private WebElement	get17Point3ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab18Text3_DesignIFrame"));
			}
			private class Values{
				private String set17SectionText = readFile.substring(readFile.indexOf("#32"), readFile.indexOf("#33"));	      // ����� ������� 17
				private String set17Point1ItemText = readFile.substring(readFile.indexOf("#33"), readFile.indexOf("#34"));    // ����� ������ 17.1
				private String set17Point2ItemText = readFile.substring(readFile.indexOf("#34"), readFile.indexOf("#35"));    // ����� ������ 17.2
				private String set17Point3ItemText = readFile.substring(readFile.indexOf("#35"), readFile.indexOf("#36"));    // ����� ������ 17.3	
			}
		}
		private class IntegratedBenefitRisk{
			//������ �������� �� ������� "18. ��������������� ������ ����������� ������-���� �� ���������� ����������"
			private Custom getIntegratedBenefitRiskTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '18. ���-� ������ ������-����� �� ��')]"));
			}
			// ���� "����� ������� 18"
			private WebElement	get18SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab19Text_DesignIFrame"));
			}
			// ���� "����� ������ 18.1"
			private WebElement	get18Point1ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab19Text1_DesignIFrame"));
			}
			// ���� "����� ������ 18.2"
			private WebElement	get18Point2ItemTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab19Text2_DesignIFrame"));
			}
			private class Values{
				private String set18SectionText = readFile.substring(readFile.indexOf("#36"), readFile.indexOf("#37"));	      // ����� ������� 18
				private String set18Point1ItemText = readFile.substring(readFile.indexOf("#37"), readFile.indexOf("#38"));    // ����� ������ 18.1
				private String set18Point2ItemText = readFile.substring(readFile.indexOf("#38"), readFile.indexOf("#39"));    // ����� ������ 18.2
			}
		}
		private class ConclusionsAndActions{
			//������ �������� �� ������� "19. ���������� � ��������"
			private Custom getConclusionsAndActionsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '19. ���������� � ��������')]"));
			}
			// ���� "����� ������� 19"
			private WebElement	get19SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab20Text1_DesignIFrame"));
			}
			private class Values{
				private String set19SectionText = readFile.substring(readFile.indexOf("#39"), readFile.indexOf("#40"));	    // ����� ������� 19
			}
		}
		private class AppendicesToThePSUR{
			//������ �������� �� ������� "20. ���������� � ���"
			private Custom getAppendicesToThePSURTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '20. ���������� � ���')]"));
			}
			// ���� "����� ������� 20"
			private WebElement	get20SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab21Text1_DesignIFrame"));
			}
			private class Values{
				private String set20SectionText = readFile.substring(readFile.indexOf("#40"), readFile.indexOf("#41"));	    // ����� ������� 20
			}
		}
		private class MappingSignalsAndRisksToPSUR{
			//������ �������� �� ������� "21. ����������� �������� � ������" 
			private Custom getMappingSignalsAndRisksToPSURTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '21. ����������� �������� � ������')]"));
			}
			// ���� "����� ������� 21"
			private WebElement	get21SectionTe�t(){
				return driver.findElement(By.id("customTextEditor_Tab22Text1_DesignIFrame"));
			}
			private class Values{
				private String set21SectionText = readFile.substring(readFile.indexOf("#41"), readFile.indexOf("#42"));	    // ����� ������� 21
			}
		}
		
	}

}
