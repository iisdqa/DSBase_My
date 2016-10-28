package com.dsbase.pages.safety.my;

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
    	// выбор препарата 
		new DrugPopUp().getButtonOpenDrugPopUp().waitUntilAvailable();
		new DrugPopUp().getButtonOpenDrugPopUp().click();
		new DrugPopUp().getSearchButton().waitUntilAvailable();
		// заполнение поля страна маркетирования
		new DrugPopUp().getMarketingCountry().selectByVisibleText(new DrugPopUp().new Values().marketingCountry);
		// заполнение поля Торговое название:
		new DrugPopUp().getTradeName().inputText(new DrugPopUp().new Values().tradeName);
		// нажимаем на кнопку "Найти"
		new DrugPopUp().getSearchButton().click();
		// ожидаем прогрузку грида
		waitForBlockStatus(new DrugPopUp().getGridDownload_Div(), false);
		// Кликнуть по ячейке 'Название препарата'
		Actions action = new Actions(driver);
		action.click((new DrugPopUp().getTradeNameCell())).perform();
		simpleWait(2);
		// Выбрать препарат
		new  DrugPopUp().getChooseButton().click();
		simpleWait(2);
	}
	public void OtherFields_FillUp(){
		// заполнение поля Название ПСУРа
		new OtherPSURFields().getNamePSUR().inputText(new OtherPSURFields().new OtherValues().name);
		// заполнение поля Дата начала отчетного периода
		new OtherPSURFields().getReportingPeriodSartDate().click();
		new OtherPSURFields().getReportingPeriodSartDate().inputText(new OtherPSURFields().new OtherValues().ReportingPeriodSartDate);
		// заполнение поля Дата окончания отчетного периода
		new OtherPSURFields().getReportingPeriodEndDate().click();
		new OtherPSURFields().getReportingPeriodEndDate().inputText(new OtherPSURFields().new OtherValues().ReportingPeriodEndDate);
		// заполнение поля Дата формирования отчета
		new OtherPSURFields().getReportCreationDate().click();
		new OtherPSURFields().getReportCreationDate().inputText(new OtherPSURFields().new OtherValues().ReportCreationDate);
		// Необходимая дата предоставления отчета в регуляторный орган
		new OtherPSURFields().getRequiredDate().click();
		new OtherPSURFields().getRequiredDate().inputText(new OtherPSURFields().new OtherValues().RequiredDate);
		// Фактическая дата предоставления отчета в регуляторный орган
		new OtherPSURFields().getActualDate().click();
		new OtherPSURFields().getActualDate().inputText(new OtherPSURFields().new OtherValues().ActualDate);
		// Дата подачи отчета в составе материалов на перерегистрацию:
		new OtherPSURFields().getSubmissionDate().click();
		new OtherPSURFields().getSubmissionDate().inputText(new OtherPSURFields().new OtherValues().SubmissionDate);
		// Дата начала следующего отчетного периода
		new OtherPSURFields().getNextStartDate().click();
		new OtherPSURFields().getNextStartDate().inputText(new OtherPSURFields().new OtherValues().NextStartDate);
		// Дата окончания следующего отчетного периода
		new OtherPSURFields().getNextEndDate().click();
		new OtherPSURFields().getNextEndDate().inputText(new OtherPSURFields().new OtherValues().NextEndDate);
		// Необходимая дата предоставления следующего отчета:
		new OtherPSURFields().getNextReportSubmitionDate().click();
		new OtherPSURFields().getNextReportSubmitionDate().inputText(new OtherPSURFields().new OtherValues().NextReportSubmitionDate);
	}
	public void SavePSUR(){
		new OtherPSURFields().getSaveButton().click();
	new BodyOfPSUR().getReportSectionsButton().waitUntilAvailable();
	}
	// заполнение разделов ПСУРа
	public void TitlePagePSUR_FillUp(){
		new BodyOfPSUR().getReportSectionsButton().click();
		simpleWait(2);
		// заполнение вкладки "Титульный лист"
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
		// переход на вкладку "Оглавление и резюме" 
		new BodyOfPSUR().new ContentsAndSummary().getContentAndSummaryTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,new BodyOfPSUR().new ContentsAndSummary().getFormatAndContentText(),
																   new BodyOfPSUR().new ContentsAndSummary().new Values().contentsAndSummary);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void Introduction_FillUp(){
		// переход на вкладку "Введение"
		new BodyOfPSUR().new Introduction().getIntroductionTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new Introduction().get1SectionTeхt(),
																   new BodyOfPSUR().new Introduction().new Values().introduction);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void WorldwideAuthorisationStatus_FillUp(){
		// переход на вкладку "2. Регистрационный статус в мире"
		new BodyOfPSUR().new WorldwideStatus().getWorldwideStatusTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 2"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new WorldwideStatus().get2SectionTeхt(),
																  new BodyOfPSUR().new WorldwideStatus().new Values().worldwideStatus);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void ActionsTaken_FillUP(){
		// переход на вкладку "3. Меры в связи с новыми данными по безопасности"
		new BodyOfPSUR().new ActionsTaken().getActionsTakenTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 2"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ActionsTaken().get3SectionTeхt(),
																   new BodyOfPSUR().new ActionsTaken().new Values().actionsTaken);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void ChangesSafetyInformation_FillUp(){
		// переход на вкладку "4. Изменения в СИ по безопасности"
		new BodyOfPSUR().new ChangesSafetyInformation().getChangesSafetyInformationTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 4"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ChangesSafetyInformation().get4SectionTeхt(),
																   new BodyOfPSUR().new ChangesSafetyInformation().new Values().changesSafetyInformation);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void EstimatedExposure_FillUp(){
		// переход на вкладку переход на вкладку "5. Сведения о количестве пациентов, получавших лекарственный препарат за отчетный период"
		new BodyOfPSUR().new EstimatedExposure().getEstimatedExposureTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 5"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get5SectionTeхt(),
																  new BodyOfPSUR().new EstimatedExposure().new Values().fiveSectionTeхt);
		// заполнение поля "Текст Текст пункта 5.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get51ItemTeхt(),
																   new BodyOfPSUR().new EstimatedExposure().new Values().fivePoint1Section);
		// заполнение поля "Текст Текст пункта 5.2"
				new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get52ItemTeхt(),
																		  new BodyOfPSUR().new EstimatedExposure().new Values().fivePoint2Section);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void DataInSummaryTabulations_FillUp(){
		// переход на вкладку переход на вкладку "6. Обобщенные табличные данные о выявленных нежелательных реакциях"
		new BodyOfPSUR().new DataInSummaryTabulations().getDataInSummaryTabulationsTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 6"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get6SectionTeхt(), 
																   new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixSectionText);
		// Заполненние поля "Текст пункта 6.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get61ItemTeхt(),
																   new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixPoint1ItemText);
		// Заполненние поля Текст пункта 6.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get62ItemTeхt(), 
																		new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixPoint2ItemText);
		// добавление сзначения в таблицу "Таблица 6.2"
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
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new DataInSummaryTabulations().get63ItemTeхt(),
																	new BodyOfPSUR().new DataInSummaryTabulations().new Values().sixPoint3ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void SummariesOfSignificantFindings_FillUp(){
		// переход на вкладку переход на вкладку "7. Резюме важных данных, полученных в ходе клинических исследований за отчетный период"
		new BodyOfPSUR().new SummariesOfSignificantFindings().getSummariesOfSignificantFindingsTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 7"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get7SectionTeхt()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenSectionText);	
		// Заполненние поля "Текст пункта 7.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get71ItemTeхt()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint1ItemText);
		// Заполненние поля Текст пункта 7.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get72ItemTeхt() 
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint2ItemText);
		// Заполненние поля Текст пункта 7.3
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get73ItemTeхt()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint3ItemText);
		// Заполненние поля Текст пункта 7.4
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get74ItemTeхt() 
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint4ItemText);
		// Заполненние поля Текст пункта 7.5
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SummariesOfSignificantFindings().get75ItemTeхt()
																   ,new BodyOfPSUR().new SummariesOfSignificantFindings().new Values().setSevenPoint5ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void FindingsFromNonInterventionalStudies_FillUp(){
	// переход на вкладку "8 Данніе неинтервенционных иследований"
		new BodyOfPSUR().new FindingsFromNonInterventionalStudies().getFindingsFromNonInterventionalStudiesTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 8"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new FindingsFromNonInterventionalStudies().get8SectionTeхt(),
																		   new BodyOfPSUR().new FindingsFromNonInterventionalStudies().new Values().setEightSectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void InformationFromOtherClinicalTrials_FillUp(){
		// переход на вкладку "8 Данніе неинтервенционных иследований"
		new BodyOfPSUR().new InformationFromOtherClinicalTrials().getInformationFromOtherClinicalTrialsTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 9"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new InformationFromOtherClinicalTrials().get9SectionTeхt(),
																   new BodyOfPSUR().new InformationFromOtherClinicalTrials().new Values().setNineSectionText);
		// Заполненние поля "Текст пункта 9.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new InformationFromOtherClinicalTrials().get91ItemTeхt()
																  ,new BodyOfPSUR().new InformationFromOtherClinicalTrials().new Values().setNinePoint1ItemText);
		// Заполненние поля Текст пункта 9.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new InformationFromOtherClinicalTrials().get92ItemTeхt() 
																   ,new BodyOfPSUR().new InformationFromOtherClinicalTrials().new Values().setNinePoint2ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void NonClinicalData_FillUp(){
		// переход на вкладку "10. Данные доклинических исследований"
		new BodyOfPSUR().new NonClinicalData().getNonClinicalDataTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 10"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new NonClinicalData().get10SectionTeхt(),
																		   new BodyOfPSUR().new NonClinicalData().new Values().setTenSectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void Literature_FillUp(){
		// переход на вкладку "10. Данные доклинических исследований"
		new BodyOfPSUR().new Literature().getLiteratureTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 10"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new Literature().get11SectionTeхt(),
																		   new BodyOfPSUR().new Literature().new Values().set11SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void OtherPeriodicReports_FillUp(){
		// переход на вкладку "12. Другие периодические отчеты (при наличии)"
		new BodyOfPSUR().new OtherPeriodicReports().getOtherPeriodicReportsTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 12"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new OtherPeriodicReports().get12SectionTeхt(),
																		   new BodyOfPSUR().new OtherPeriodicReports().new Values().set12SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void LackOfEfficacy_FillUp(){
		// переход на вкладку 13. Недостаточная терапевтическая эффективность в контролируемых клинических исследованиях
		new BodyOfPSUR().new LackOfEfficacy().getLackOfEfficacyTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 13"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new LackOfEfficacy().get13SectionTeхt(),
																		   new BodyOfPSUR().new LackOfEfficacy().new Values().set13SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void LateBreakingInformation_FillUp(){
		// переход на вкладку 14. Важная информация, полученная после завершения подготовки ПОБ
		new BodyOfPSUR().new LateBreakingInformation().getLateBreakingInformationTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 14"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new LateBreakingInformation().get14SectionTeхt(),
																		   new BodyOfPSUR().new LateBreakingInformation().new Values().set14SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void OverviewOfSignals_FillUP(){
		// переход на вкладку 14. Важная информация, полученная после завершения подготовки ПОБ
		new BodyOfPSUR().new OverviewOfSignals().getOverviewOfSignalsTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 14"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new OverviewOfSignals().get15SectionTeхt(),
																	       new BodyOfPSUR().new OverviewOfSignals().new Values().set15SectionText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void SignalAndRiskEvaluation_FillUp(){
		// переход на вкладку переход на вкладку "16. Сигналы безопасности и оценка риска применения лекарственного препарата"
		new BodyOfPSUR().new SignalAndRiskEvaluation().getSignalAndRiskEvaluationTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 16"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16SectionTeхt()
																  ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16SectionText);	
		// Заполненние поля "Текст пункта 16.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point1ItemTeхt()
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point1ItemText);
		// Заполненние поля Текст пункта 16.2
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point2ItemTeхt() 
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point2ItemText);
		// Заполненние поля Текст пункта 16.3
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point3ItemTeхt()
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point3ItemText);
		// Заполненние поля Текст пункта 16.4
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point4ItemTeхt() 
																   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point4ItemText);
		// Заполненние поля Текст пункта 16.5
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new SignalAndRiskEvaluation().get16Point5ItemTeхt()
																		   ,new BodyOfPSUR().new SignalAndRiskEvaluation().new Values().set16Point5ItemText);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}

		
	//______________________________________________Elements_____________________________________________________//
	
	private class DrugPopUp {
		// кнопка открытия поп-апа 
		private Button getButtonOpenDrugPopUp(){
			return new Button(driver, By.id("open_trade_names"));
		}
		// прогрузка грида препараты
		private Custom getGridDownload_Div(){															
			return new Custom(driver, By.id("load_list_tradenames"));
		}
		// Страна маркетирования
		private Select getMarketingCountry(){
			return new Select(driver.findElement(By.id("TradeNameControl_Country")));
		}
		// Торговое название
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
			private String marketingCountry = "Катар";                                   // Страна маркетирования
			private String tradeName = "Тестовый препарат";								 // Торговое название
			
		}
	}
	private class OtherPSURFields{
		// Название псура
		private TextInput getNamePSUR(){
			return new TextInput(driver, By.id("name"));
		}
		// Дата начала отчетного периода
		private TextInput getReportingPeriodSartDate(){
			return new TextInput(driver, By.id("start_period"));
		}
		// Дата окончания отчетного периода
		private TextInput getReportingPeriodEndDate(){
			return new TextInput(driver, By.id("end_period"));
		}
		// Дата формирования отчета
		private TextInput getReportCreationDate(){
			return new TextInput(driver, By.id("report_date"));
		}
		// Необходимая дата предоставления отчета в регуляторный орган
		private TextInput getRequiredDate(){
			return new TextInput(driver, By.id("required_provision"));
		}
		// Фактическая дата предоставления отчета в регуляторный орган
		private TextInput getActualDate(){
			return new TextInput(driver, By.id("fact_provision"));
		}
		// Дата подачи отчета в составе материалов на перерегистрацию:
		private TextInput getSubmissionDate(){
			return new TextInput(driver, By.id("filing_registration"));
		}
		// Дата начала следующего отчетного периода
		private TextInput getNextStartDate(){
			return new TextInput(driver, By.id("start_next_period"));
		}
		// Дата окончания следующего отчетного периода
		private TextInput getNextEndDate(){
			return new TextInput(driver, By.id("end_next_period"));
		}
		// Необходимая дата предоставления следующего отчета:
		private TextInput getNextReportSubmitionDate(){
			return new TextInput(driver, By.id("required_provision_next"));
		}
		// Кнопка сохранить
		private Button getSaveButton(){
			return new Button(driver, By.xpath("//input[@type='button' and contains(@value, 'Сохранить')]"));
		}
		private class OtherValues{
			private String name = "AutoTestPSUR"; 												// назва ПСУРа
			private String ReportingPeriodSartDate = new CustomMethods().getCurrentDate(); 		// Дата начала отчетного периода
			private String ReportingPeriodEndDate = new CustomMethods().getChangedDate(4);		// Дата окончания отчетного периода
			private String ReportCreationDate = new CustomMethods().getCurrentDate(); 		    // Дата формирования отчета
			private String RequiredDate = new CustomMethods().getCurrentDate();					// Необходимая дата предоставления отчета в регуляторный орган
			private String ActualDate = new CustomMethods().getChangedDate(1);					// Фактическая дата предоставления отчета в регуляторный орган
			private String SubmissionDate = new CustomMethods().getChangedDate(5);				// Дата подачи отчета в составе материалов на перерегистрацию:
			private String NextStartDate = new CustomMethods().getChangedDate(5);				// Дата начала следующего отчетного периода
			private String NextEndDate = new CustomMethods().getChangedDate(7);					// Дата окончания следующего отчетного периода
			private String NextReportSubmitionDate = new CustomMethods().getChangedDate(8);		// Необходимая дата предоставления следующего отчета:
			
		}
	}
	private class BodyOfPSUR{
		private final String pSURfilePath = "C:\\Selenium_TestData\\Projects\\DSBase\\PSUR\\";									 				// путь к файлу текстом для разделов 
		private final String readFile = new CustomMethods().new WorkWith_TextFiles().file_Read(pSURfilePath + "PSUR.txt");						// чтение файла (переобразованеие в строку)
		// Кнопка разделы отчета
		private Button getReportSectionsButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick, 'RedirectWithControllEdit')]"));
		}
		// Кнопка "Сохранить"(разделы ПСУРа)
		private Button getSaveButton(){
			return new Button(driver, By.id("save_btn"));
		}
		// кнопка добавить "Документ"
		private Button getAddDocumentButton(){
			return new Button(driver, By.id("add_edit_file"));
		}
		private class TitlePageElements{
			// Дата закрытия базы данных
			private TextInput getDatabaseClosureDate(){
				return new TextInput(driver, By.id("Tab0_ClosureDate"));
			}
			// Текст ТЛ:
			private WebElement getTitlePageText(){
				return driver.findElement(By.id("customTextEditor_Tab0Text1_DesignIFrame"));
						
			}
			// Положение о конфиденциальности
			private WebElement getPrivacyPolicy(){
				return driver.findElement(By.id("customTextEditor_Tab0PrivacyStatement_DesignIFrame"));
			}
			
			// Кнопка добавления документа 
			private Button getDocumetsButton(){
				return new Button(driver, By.id("add_edit_file"));
			}
			// Поле "Уполномоченное лицо по фармаконадзору"
			private TextInput getQualifiedPerson(){
				return new TextInput(driver, By.id("Tab0_PersonPharmacovigilance"));
			}
			// Данные для контакта
			private TextInput getContactData(){
				return new TextInput(driver, By.id("Tab0_ContactData"));
			}
			private class TitlePageValues{
				private String databaseClosureDate= new CustomMethods().getChangedDate(2);
				private String titlePageText = "тестовая информация";                                    	// поле Текст ТЛ
				private String privacyPolicy = "тестовая информация политики конфедициальности";			// поле политика Положения о конфиденциальности
				private String qualifiedPerson = "Бильбо Бэггинс";											// Поле "Уполномоченное лицо по фармаконадзору"
				private String contactData = "Шир, Ривенделл";												// Данные для контакта
			}	
		}
		private class ContentsAndSummary{
			//кнопка перехода на вкладку "Оглавление и резюме"
			private Custom getContentAndSummaryTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), 'Оглавление и резюме')]"));
			}
			// поле Текст ФиС
			private WebElement	getFormatAndContentText(){
				return driver.findElement(By.id("customTextEditor_Tab1Text1_DesignIFrame"));
			}
			private class Values{
				private String contentsAndSummary = readFile.substring(readFile.indexOf("#1"), readFile.indexOf("#2")); 							// "Оглавление и резюме"
			}
			
			
		}
		private class Introduction{
			//кнопка перехода на вкладку "Введение"
			private Custom getIntroductionTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '1. Введение')]"));
			}
			// поле "Текст Раздела 1"
			private WebElement	get1SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab2Text1_DesignIFrame"));
			}
			private class Values{
				private String introduction = readFile.substring(readFile.indexOf("#2"), readFile.indexOf("#3"));                                   // "Введение"
			}
			
		}
		private class WorldwideStatus{
			//кнопка перехода на вкладку "2. Регистрационный статус в мире"
			private Custom getWorldwideStatusTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '2. Регистрационный статус в мире')]"));
			}
			// поле "Текст Раздела 2"
			private WebElement	get2SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab3Text1_DesignIFrame"));
			}
			private class Values{
				private String worldwideStatus = readFile.substring(readFile.indexOf("#3"), readFile.indexOf("#4"));								// 2. Регистрационный статус в мире
			}
		}
		private class ActionsTaken{
			//кнопка перехода на вкладку "3. Меры в связи с новыми данными по безопасности"
			private Custom getActionsTakenTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '3. Меры в связи с новыми данными по безопасности')]"));
			}
			// поле "Текст Раздела 3"
			private WebElement	get3SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab4Text1_DesignIFrame"));
			}
			private class Values{
				private String actionsTaken = readFile.substring(readFile.indexOf("#4"), readFile.indexOf("#5")); 									// 3. Меры, принятые за отчетный период, в связи с выявлением новых данных по безопасности
			}
		}
		private class ChangesSafetyInformation{
			//кнопка перехода на вкладку "4. Изменения в СИ по безопасности"
			private Custom getChangesSafetyInformationTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '4. Изменения в СИ по безопасности')]"));
			}
			// поле "Текст Раздела 4"
			private WebElement	get4SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab5Text1_DesignIFrame"));
			}
			private class Values{
				private String changesSafetyInformation = readFile.substring(readFile.indexOf("#5"), readFile.indexOf("#6"));						// 4. Изменения в СИ по безопасности
			}
		}
		private class EstimatedExposure{
			//кнопка перехода на вкладку "5. Сведения о пациентах, получавших ЛП"
			private Custom getEstimatedExposureTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '5. Сведения о пациентах, получавших ЛП')]"));
			}
			// поле "Текст Раздела 5"
			private WebElement	get5SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab6Text_DesignIFrame"));
			}
			// поле "Текст пункта 5.1"
			private WebElement	get51ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab6Text1_DesignIFrame"));
			}
			// поле "Текст пункта 5.2"
			private WebElement	get52ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab6Text2_DesignIFrame"));
			}
			private class Values{
				private String fiveSectionTeхt = readFile.substring(readFile.indexOf("#6"), readFile.indexOf("#7"));								// Текст Раздела 5:
				private String fivePoint1Section = readFile.substring(readFile.indexOf("#7"), readFile.indexOf("#8"));								// текст пункта 5.1
				private String fivePoint2Section = readFile.substring(readFile.indexOf("#8"), readFile.indexOf("#9"));								// текст пункта 5.2
			}
		}
		private class DataInSummaryTabulations{
			//кнопка перехода на вкладку "6. Обобщенные таблицы  о НР"
			private Custom getDataInSummaryTabulationsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '6. Обобщенные таблицы  о НР')]"));
			}
			// поле "Текст Раздела 6"
			private WebElement	get6SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab7Text_DesignIFrame"));
			}
			// поле "Текст пункта 6.1"
			private WebElement	get61ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab7Text1_DesignIFrame"));
			}
			// поле "Текст пункта 6.2"
			private WebElement	get62ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab7Text2_DesignIFrame"));
			}
			// поле "Текст пункта 6.3"
			private WebElement	get63ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab7Text3_DesignIFrame"));
			}
			// кнопка добавления значения в "таблицу 6.2"
			private Button getNewTabValue(){
				return new Button(driver, By.id("add_edit_tab7"));
			}
			// кнопка открытия pop-up "MedDRA"
			private Button getMedDraButton(){
				return new Button(driver, By.xpath("//input[contains(@onclick, 'psur_tab7')]"));
			}
			// поле "Класс систем и органов"
			private TextInput getSystemOrganClass(){
				return new TextInput(driver, By.id("Tab7Grid_ClassSystems"));
			}
			// поле "Исследуемое лекарственное средство"
			private TextInput getInvestigationalProduct(){
				return new TextInput(driver, By.id("Tab7Grid_InvestigationalDrug"));
			}
			// поле "Ослепление"
			private TextInput getBlinded(){
				return new TextInput(driver, By.id("Tab7Grid_Blinding"));
			}
			// поле "Препарат сравнения"
			private TextInput getActiveComparator(){
				return new TextInput(driver, By.id("Tab7Grid_DrugComparisons"));
			}
			// поле "Плацебо"
			private TextInput getPlacebo(){
				return new TextInput(driver, By.id("Tab7Grid_Placebo"));
			}
			// кнопка сохранения в Поп-ап
			private Button getSaveDialogButton(){
				return new Button(driver, By.id("save_dialog_btn"));
			}
			// прогрузка грида
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_tab7"));
			}
			private class Values{
				private String sixSectionText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10"));	    // Текст раздела 6
				private String sixPoint1ItemText = readFile.substring(readFile.indexOf("#10"), readFile.indexOf("#11"));    // Текст пункта 6.1
				private String sixPoint2ItemText = readFile.substring(readFile.indexOf("#11"), readFile.indexOf("#12"));    // Текст пункта 6.2
				private String sixPoint3ItemText = readFile.substring(readFile.indexOf("#12"), readFile.indexOf("#13"));    // Текст пункта 6.3
				private String setSystemOrganClass = "10002019 - Amylobarbitone dependency"; 								// Класс систем и органов
				private String setInvestigationalProduct = "Тестовый препарат";      										// Исследуемое лекарственное средство
				private String setBlinded = "Sleeping";																		// Ослепление
				private String setActiveComparator = "Testing drug"; 														// Препарат сравнения
				private String setPlacebo = "vitamin";																		// Плацебо
		    }
			
		}
		private class SummariesOfSignificantFindings{
			//кнопка перехода на вкладку "7.  Резюме важных данных, полученных в ходе клинических исследований за отчетный период"
			private Custom getSummariesOfSignificantFindingsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '7. Резюме клинических исследований')]"));
			}
			// поле "Текст Раздела 7"
			private WebElement	get7SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab8Text_DesignIFrame"));
			}
			// поле "Текст пункта 7.1"
			private WebElement	get71ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab8Text1_DesignIFrame"));
			}
			// поле "Текст пункта 7.2"
			private WebElement	get72ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab8Text2_DesignIFrame"));
			}
			// поле "Текст пункта 7.3"
			private WebElement	get73ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab8Text3_DesignIFrame"));
			}
			// поле "Текст пункта 7.4"
			private WebElement	get74ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab8Text4_DesignIFrame"));
			}
			// поле "Текст пункта 7.5"
			private WebElement	get75ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab8Text5_DesignIFrame"));
			}
			private class Values{
				private String setSevenSectionText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10"));	     // Текст раздела 7
				private String setSevenPoint1ItemText = readFile.substring(readFile.indexOf("#10"), readFile.indexOf("#11"));    // Текст пункта 7.1
				private String setSevenPoint2ItemText = readFile.substring(readFile.indexOf("#11"), readFile.indexOf("#12"));    // Текст пункта 7.2
				private String setSevenPoint3ItemText = readFile.substring(readFile.indexOf("#12"), readFile.indexOf("#13"));    // Текст пункта 7.3
				private String setSevenPoint4ItemText = readFile.substring(readFile.indexOf("#13"), readFile.indexOf("#14"));    // Текст пункта 7.4
				private String setSevenPoint5ItemText = readFile.substring(readFile.indexOf("#14"), readFile.indexOf("#15"));    // Текст пункта 7.5
			}
		}
		private class FindingsFromNonInterventionalStudies{
			//кнопка перехода на вкладку "8. Данные неинтервенционных исследований"
			private Custom getFindingsFromNonInterventionalStudiesTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '8. Данные неинтервенционных исследований')]"));
			}
			// поле "Текст Раздела 8"
			private WebElement	get8SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab9Text1_DesignIFrame"));
			}
			private class Values{
				private String setEightSectionText = readFile.substring(readFile.indexOf("#15"), readFile.indexOf("#16"));	    // Текст раздела 8
			}
		}
		private class InformationFromOtherClinicalTrials{
			//кнопка перехода на вкладку "9. Данные других клинических исследований и из других источников"
			private Custom getInformationFromOtherClinicalTrialsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '9. Данные других КИ и источников')]"));
			}
			// поле "Текст Раздела 9"
			private WebElement	get9SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab10Text_DesignIFrame"));
			}
			// поле "Текст пункта 9.1"
			private WebElement	get91ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab10Text1_DesignIFrame"));
			}
			// поле "Текст пункта 9.2"
			private WebElement	get92ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab10Text2_DesignIFrame"));
			}
			private class Values{
				private String setNineSectionText = readFile.substring(readFile.indexOf("#16"), readFile.indexOf("#17"));	    // Текст раздела 9
				private String setNinePoint1ItemText = readFile.substring(readFile.indexOf("#17"), readFile.indexOf("#18"));    // Текст пункта 9.1
				private String setNinePoint2ItemText = readFile.substring(readFile.indexOf("#18"), readFile.indexOf("#19"));    // Текст пункта 9.2
			}
		}
		private class NonClinicalData{
			//кнопка перехода на вкладку "10. Данные доклинических исследований"
			private Custom getNonClinicalDataTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '10. Данные доклинических исследований')]"));
			}
			// поле "Текст Раздела 10"
			private WebElement	get10SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab11Text1_DesignIFrame"));
			}
			private class Values{
				private String setTenSectionText = readFile.substring(readFile.indexOf("#20"), readFile.indexOf("#21"));	    // Текст раздела 10
			}
		}
		private class Literature{
			//кнопка перехода на вкладку "11. Литература"
			private Custom getLiteratureTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '11. Литература')]"));
			}
			// поле "Текст Раздела 11"
			private WebElement	get11SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab12Text1_DesignIFrame"));
			}
			private class Values{
				private String set11SectionText = readFile.substring(readFile.indexOf("#21"), readFile.indexOf("#22"));	    // Текст раздела 11
			}
		}
		private class OtherPeriodicReports{
			//кнопка перехода на вкладку "12. Другие периодические отчеты (при наличии)"
			private Custom getOtherPeriodicReportsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '12. Другие периодические отчеты')]"));
			}
			// поле "Текст Раздела 12"
			private WebElement	get12SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab13Text1_DesignIFrame"));
			}
			private class Values{
				private String set12SectionText = readFile.substring(readFile.indexOf("#22"), readFile.indexOf("#23"));	    // Текст раздела 12
			}
		}
		private class LackOfEfficacy{
			//кнопка перехода на вкладку "13. Недостаточная терапевтическая эффективность в контролируемых клинических исследованиях"
			private Custom getLackOfEfficacyTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '13. Недостаточная ТЭ в контролируемых КИ')]"));
			}
			// поле "Текст Раздела 13"
			private WebElement	get13SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab14Text1_DesignIFrame"));
			}
			private class Values{
				private String set13SectionText = readFile.substring(readFile.indexOf("#23"), readFile.indexOf("#24"));	    // Текст раздела 13
			}	
		}
		private class LateBreakingInformation{
			//кнопка перехода на вкладку "14. Важная информация, полученная после завершения подготовки ПОБ"
			private Custom getLateBreakingInformationTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '14. Инф-ия, после подготовки ПОБ')]"));
			}
			// поле "Текст Раздела 14"
			private WebElement	get14SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab15Text1_DesignIFrame"));
			}
			private class Values{
				private String set14SectionText = readFile.substring(readFile.indexOf("#24"), readFile.indexOf("#25"));	    // Текст раздела 14
			}	
		}
		private class OverviewOfSignals{
			//кнопка перехода на вкладку "15. Обзор сигналов: новые, рассматриваемые и завершенные"
			private Custom getOverviewOfSignalsTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '15. Обзор сигналов')]"));
			}
			// поле "Текст Раздела 14"
			private WebElement	get15SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab16Text1_DesignIFrame"));
			}
			private class Values{
				private String set15SectionText = readFile.substring(readFile.indexOf("#25"), readFile.indexOf("#26"));	    // Текст раздела 15
			}	
		}
		private class SignalAndRiskEvaluation{
			//кнопка перехода на вкладку "16. Сигналы безопасности и оценка риска применения лекарственного препарата"
			private Custom getSignalAndRiskEvaluationTab(){
				return new Custom(driver, By.xpath("//div[contains(text(), '16. Сигналы и оценка риска')]"));
			}
			// поле "Текст Раздела 16"
			private WebElement	get16SectionTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab17Text_DesignIFrame"));
			}
			// поле "Текст пункта 16.1"
			private WebElement	get16Point1ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab17Text1_DesignIFrame"));
			}
			// поле "Текст пункта 16.2"
			private WebElement	get16Point2ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab17Text2_DesignIFrame"));
			}
			// поле "Текст пункта 16.3"
			private WebElement	get16Point3ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab17Text3_DesignIFrame"));
			}
			// поле "Текст пункта 16.4"
			private WebElement	get16Point4ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab17Text4_DesignIFrame"));
			}
			// поле "Текст пункта 16.5"
			private WebElement	get16Point5ItemTeхt(){
				return driver.findElement(By.id("customTextEditor_Tab17Text5_DesignIFrame"));
			}
			private class Values{
				private String set16SectionText = readFile.substring(readFile.indexOf("#26"), readFile.indexOf("#27"));	      // Текст раздела 16
				private String set16Point1ItemText = readFile.substring(readFile.indexOf("#27"), readFile.indexOf("#28"));    // Текст пункта 16.1
				private String set16Point2ItemText = readFile.substring(readFile.indexOf("#28"), readFile.indexOf("#29"));    // Текст пункта 16.2
				private String set16Point3ItemText = readFile.substring(readFile.indexOf("#29"), readFile.indexOf("#30"));    // Текст пункта 16.3
				private String set16Point4ItemText = readFile.substring(readFile.indexOf("#30"), readFile.indexOf("#31"));    // Текст пункта 16.4
				private String set16Point5ItemText = readFile.substring(readFile.indexOf("#31"), readFile.indexOf("#32"));    // Текст пункта 16.5
			}
		}
	}

}
