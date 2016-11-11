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
import com.dsbase.core.web.elements.Link;
import com.dsbase.core.web.elements.TextInput;




public class AddADRreport_My extends WebPage<AddADRreport_My>{
	private static final String PAGE_URL = BASE_URL + "/AdverseReaction/Create";
	
	public AddADRreport_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public AddADRreport_My load(){
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable(){
	return new Main_ElementsFirstTab().getReportNumber().isAvailable();
	}
/*___________________________ Actions ____________________________________________*/	
	
	
	public void mainFields_FillUpFirstTab(){    // Заполнение обязательных полей
	
	    // Номер сообщения
		new Main_ElementsFirstTab().getReportNumber().click();
		new Main_ElementsFirstTab().getReportNumber().inputText(new Main_ElementsFirstTab().new Values().reportNumber + "_"+new CustomMethods().getCurrentDate());
		
		// Вид сообщения
		new Main_ElementsFirstTab().getEventType().selectByVisibleText("Прочее");
		
		//  Вид сообщения(Прочее)
		new Main_ElementsFirstTab().getEventTypeOther().click();
		new Main_ElementsFirstTab().getEventTypeOther().inputText(new Main_ElementsFirstTab().new Values().eventTypeOther);
		
		// Дата получения заявителем
		new Main_ElementsFirstTab().getApplicantReceiptDate().click();
		new Main_ElementsFirstTab().getApplicantReceiptDate().inputText(new Main_ElementsFirstTab().new Values().documentDate);
		
		// Организация
		new Main_ElementsFirstTab().getSourceOrganization().inputText(new Main_ElementsFirstTab().new Values().sourceOrganization);
		
		// Квалификация источника сообщения
		new Main_ElementsFirstTab().getReportSourceQualification().selectByVisibleText(new Main_ElementsFirstTab().new Values().reportSourceQualification);
		
	}
	/*__________________________________________________Вторая вкладка "Информация о пациенте"____________________________________*/
	public void goToSecondTab(){
		
		new Main_ElementsSecondTab().getSecondTab().click();
	}
	public void mainFields_FillUpSecondTab() {
		// Заполнение даты рождения
		new Main_ElementsSecondTab().getDayOfBirthday().inputText(new Main_ElementsSecondTab().new Values().dayOfBirthday);
		new Main_ElementsSecondTab().getMonthOfBirthday().inputText(new Main_ElementsSecondTab().new Values().monthOfBirthday);
		new Main_ElementsSecondTab().getYearOfBirthday().inputText(new Main_ElementsSecondTab().new Values().yearOfBirthday);
	
		// Заполнение поля "Инициалы пациента"
		new Main_ElementsSecondTab().getPatiensInitials().inputText(new Main_ElementsSecondTab().new Values().patientInitials);
		
	}
	
	/*________________________________________5 вкладка "Побочные реакции"__________________________________________*/
	// переход на 5 вкладку
	public void goToFifthTab(){
		new ADRCaseDescription().getFifthTab().click();
	}
	// заполнениие поля  "Описание ПР"
	public void mainFields_FillUpFifthTab(){
		new ADRCaseDescription().getADRdescription().inputText(new ADRCaseDescription().new Values().aDRdescription);
	}
	/*_________________________________________________6 вкладка _______________________________________________________*/
	// переход на 6 вкладку 
	public void goToSixthTab(){
		new Drugs_add().getSixthTab().click();
	}
	//Добавление препарата
	public void suspectDrugs_Add(){
		// Открытие поп-апа добавления подозреваемого препарата
		new Drugs_add().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Drugs_add().getAddEditPopUp()));
		simpleWait(2);
		
		//Ввести название препарата в поиск
		new Drugs_add().addDrugFromRegistry().click(); 
		// страна маркетирования 
		new Drugs_add().getMarketingCountry().selectByVisibleText("Катар");
		waitWhileClickable(new Drugs_add().getSaveDrugButton());
		simpleWait(2);
		new Drugs_add().getTradeName().inputText(new Drugs_add().new Values().tradeNaneDrug);
		simpleWait(2);
		new Drugs_add().getSearchButton().click();
		
		// ожидание прогрузки грида 
		waitForBlockStatus(new Drugs_add().getGridDownload_Div(), false);
		simpleWait(1);
		
		// Кликнуть по ячейке 'Название препарата'
				Actions action = new Actions(driver);
				action.click((new Drugs_add().getTradeNameCell())).perform();
				simpleWait(2);
		// Выбрать препарат
		new Drugs_add().getChooseButton().click();
		simpleWait(2);
		
		// нажать на кнопку "Сохранить"(Препарат)
		new  Drugs_add().getSaveDrugButton().click();
		simpleWait(2);
		
	}
	// проверка добавленного значения в грид "Подозреваемые ЛС"
	public void addSuspectDrug_Check(){
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {  "",
										 	new Drugs_add().new Values().tradeNaneDrug,
										 	new Drugs_add().new Values().farmaceuticalForme,
										 	"",
										 	" ",
										 	" ",
										 	" ",
										 	" ",
										 	" ",
										 	" ",
										 	" ",
										 	"",
										 };
		
		// Определение актуальных значений
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Drugs_add().getSuspectDrugGridBody());
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public ViewADRreport_My saveADRreport(){
		new Drugs_add().getSaveButton().click();
		return new ViewADRreport_My(driver).waitUntilAvailable();
	}
	
	/*_____________________________________________________Elements_______________________________________________________*/
/*___________________________________________Вкладка "Информация о сообщении"___________________________________________________________*/
	private class Main_ElementsFirstTab{
		//Номер сообщения
		private TextInput getReportNumber(){
			return new TextInput(driver, By.id("Safetyreport_safetyreportid"));
		}
		// Тип сообщения
		private Select getEventType(){
			return new Select(driver.findElement(By.id("Form_137_dic_case_type_id")));
		}
		private TextInput getEventTypeOther(){
			return new TextInput(driver, By.id("Form_137_other_case_type"));
		}
		// дата получения заявителем
		private TextInput getApplicantReceiptDate(){
			return new TextInput(driver, By.id("Safetyreport_receivedate"));
		}
		// организация источника 
		private TextInput getSourceOrganization(){
			return new TextInput(driver, By.id("Source_reporterorganization"));
		}
		private Select getReportSourceQualification(){
			return new Select(driver.findElement(By.id("Source_qualification_id")));
		}
		private class Values{
			private String reportNumber = "777_AutoTest";     																	// Номер Сообщения
			private String eventTypeOther = "Возможная передозировка";                      									// Вид случая прочее
			private String currentTime = new CustomMethods().getCurrentDate();				                                    // текущая дата	
			private String documentDate= "27.09.2016";
			private String sourceOrganization = "USA organization";																// организация источника 
			private String reportSourceQualification = "врач" ;  																// Квалификация источника сообщения
		}
		
		
	}
	/*______________________________________________________Вторая вкалдка "Информация о пациенте"___________________________________________________________*/
	private class Main_ElementsSecondTab{
		//переход на вторую вкладку
		private Link getSecondTab (){
			return new Link(driver, By.xpath("//a[@href='#tab2']"));
		}
		// Дата рождения день
		private TextInput getDayOfBirthday(){
			return new TextInput(driver, By.id("Patient_BirthDay"));
		}
		// Дата рождения месяц
		private TextInput getMonthOfBirthday(){
			return new TextInput(driver, By.id("Patient_BirthMonth"));
		}
		//Дата рождения год
		private TextInput getYearOfBirthday(){
			return new TextInput(driver, By.id("Patient_BirthYear"));
		}
		// Заполнение поля "Инициалы пациента"
		private TextInput getPatiensInitials(){
			return new TextInput(driver, By.id("Patient_patientinitial"));
		}
		private class Values {
			private String dayOfBirthday = "06";
			private String monthOfBirthday = "02";
			private String yearOfBirthday = "1998";
			private String patientInitials = "AVT";
		}
		
	}
	/*________________________________________________5 вкладка побочные реакции_________________________________________*/
	private class ADRCaseDescription {
		//переход на пятую вкладку
		private Link getFifthTab (){
			return new Link(driver, By.xpath("//a[@href='#tab5']"));
		}
		// заплнение поля "описание случая ПР"
		private TextInput getADRdescription(){
			return new TextInput(driver, By.id("Summary_narrativeincludeclinical"));
		}
		private class Values{
			private String aDRdescription="Головная боль, тошнота, потеря сознания";
		}
	}
	/*_______________________________________________6 вкладка____________________________________________________________*/
	private class Drugs_add {
		//переход на пятую вкладку
		private Link getSixthTab (){
			return new Link(driver, By.xpath("//a[@href='#tab6']"));
		}
		//страна маркетирования 
		private Select getMarketingCountry(){
			return new Select(driver.findElement(By.id("TradeNameControl_Country")));
		}
		// кнопка поп-ап "подозвеваемый ЛС"
		private Button getAddButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick,'AddEditDrug(null, 1)')]"));
		}
		// Поп-ап добавления
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}
		
		// кнопка "Реестр препаратов"
		private Button addDrugFromRegistry(){
			return new Button(driver, By.id("is_new_trade_names"));
		}
		// Завантаження грида "реестр препаратов"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tradenames"));
		}
		private TextInput getTradeName (){
			return new TextInput(driver, By.id("TradeNameControl_Name"));
		}
		private Button getSearchButton(){
			return new Button(driver, By.id("TradeNameControl_Find"));
		}
		private WebElement getTradeNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tradenames_TradeName']"));
		}
		private Button getChooseButton(){
			return new Button(driver, By.id("TradeNameControl_Choose"));
		}
		private Button getSaveDrugButton(){
			return new Button(driver, By.xpath("//input[@onclick='SaveDrugs()']"));
		}
		private WebElement getSuspectDrugGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_susdrugs']/tbody"));
		}
		private Button getSaveButton(){
			return new Button(driver, By.id("save_btn"));
		}

		private class Values{
			private String tradeNaneDrug = "Тестовый препарат";													// Название препарата
			private String addEditPopUpName = "Добавить подозреваемое ЛС";										// Название поп-апа 
			private String farmaceuticalForme = "Таблетки";														// Форма выпуска
		}
	
	}
		
}
