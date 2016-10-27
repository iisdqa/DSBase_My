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
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new TitlePageElements().getTitlePageText(), new BodyOfPSUR().new TitlePageElements().new TitlePageValues().titlePageText);
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new TitlePageElements().getPrivacyPolicy(), new BodyOfPSUR().new TitlePageElements().new TitlePageValues().privacyPolicy);
		new BodyOfPSUR().new TitlePageElements().getQualifiedPerson().inputText(new BodyOfPSUR().new TitlePageElements().new TitlePageValues().qualifiedPerson);
		new BodyOfPSUR().new TitlePageElements().getContactData().inputText(new BodyOfPSUR().new TitlePageElements().new TitlePageValues().contactData);
		new BodyOfPSUR().getSaveButton().click();
	}
	public void ContentsAndSummary_FillUP(){
		// переход на вкладку "Оглавление и резюме" 
		new BodyOfPSUR().new ContentsAndSummary().getContentAndSummaryTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ContentsAndSummary().getFormatAndContentText(), new BodyOfPSUR().new Values().contentsAndSummary);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void Introduction_FillUp(){
		// переход на вкладку "Введение"
		new BodyOfPSUR().new Introduction().getIntroductionTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new Introduction().get1SectionTeхt(), new BodyOfPSUR().new Values().introduction);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void WorldwideAuthorisationStatus_FillUp(){
		// переход на вкладку "2. Регистрационный статус в мире"
		new BodyOfPSUR().new WorldwideStatus().getWorldwideStatusTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 2"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new WorldwideStatus().get2SectionTeхt(), new BodyOfPSUR().new Values().worldwideStatus);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void ActionsTaken_FillUP(){
		// переход на вкладку "3. Меры в связи с новыми данными по безопасности"
		new BodyOfPSUR().new ActionsTaken().getActionsTakenTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 2"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ActionsTaken().get3SectionTeхt(), new BodyOfPSUR().new Values().actionsTaken);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void ChangesSafetyInformation_FillUp(){
		// переход на вкладку "4. Изменения в СИ по безопасности"
		new BodyOfPSUR().new ChangesSafetyInformation().getChangesSafetyInformationTab().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 4"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new ChangesSafetyInformation().get4SectionTeхt(), new BodyOfPSUR().new Values().changesSafetyInformation);
		simpleWait(2);
		new BodyOfPSUR().getSaveButton().click();
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
	}
	public void EstimatedExposure_FillUp(){
		// переход на вкладку переход на вкладку "5. Сведения о количестве пациентов, получавших лекарственный препарат за отчетный период"
		new BodyOfPSUR().new EstimatedExposure().getEstimatedExposureTab().click();;
		new BodyOfPSUR().getAddDocumentButton().waitUntilAvailable();
		// заполнение поля "Текст Раздела 5"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get5SectionTeхt(), new BodyOfPSUR().new Values().fiveSectionTeхt);
		// заполнение поля "Текст Текст пункта 5.1"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get51ItemTeхt(), new BodyOfPSUR().new Values().fivePoint1Section);
		// заполнение поля "Текст Текст пункта 5.2"
				new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new BodyOfPSUR().new EstimatedExposure().get52ItemTeхt(), new BodyOfPSUR().new Values().fivePoint2Section);
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
			// кнопка добавления значения в "таблицу 6.2"
			private Button getNewValueTab(){
				return new Button(driver, By.id("add_edit_tab7"));
			}
			
		}
		private class Values{
			private String pSURfilePath = "C:\\Selenium_TestData\\Projects\\DSBase\\PSUR\\";									 				// путь к файлу текстом для разделов 
			private String readFile = new CustomMethods().new WorkWith_TextFiles().file_Read(pSURfilePath + "PSUR.txt");						// чтение файла (переобразованеие в строку)
			private String contentsAndSummary = readFile.substring(readFile.indexOf("#1"), readFile.indexOf("#2")); 							// "Оглавление и резюме"
			private String introduction = readFile.substring(readFile.indexOf("#2"), readFile.indexOf("#3"));                                   // "Введение"
			private String worldwideStatus = readFile.substring(readFile.indexOf("#3"), readFile.indexOf("#4"));								// 2. Регистрационный статус в мире
			private String actionsTaken = readFile.substring(readFile.indexOf("#4"), readFile.indexOf("#5")); 									// 3. Меры, принятые за отчетный период, в связи с выявлением новых данных по безопасности
			private String changesSafetyInformation = readFile.substring(readFile.indexOf("#5"), readFile.indexOf("#6"));						// 4. Изменения в СИ по безопасности
			private String fiveSectionTeхt = readFile.substring(readFile.indexOf("#6"), readFile.indexOf("#7"));								// Текст Раздела 5:
			private String fivePoint1Section = readFile.substring(readFile.indexOf("#7"), readFile.indexOf("#8"));								// текст пункта 5.1
			private String fivePoint2Section = readFile.substring(readFile.indexOf("#8"), readFile.indexOf("#9"));								// текст пункта 5.2
//never used			private String sixSectionText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10"));
			
			
		}
	}

}
