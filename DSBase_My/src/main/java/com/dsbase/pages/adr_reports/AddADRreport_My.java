package com.dsbase.pages.adr_reports;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Link;
import com.dsbase.core.web.elements.TextInput;
import com.dsbase.pages.drugs.my.DrugRegistrationPage_My;



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
		new Main_ElementsFirstTab().getReportNumber().inputText(new Main_ElementsFirstTab().new Values().reportNumber);
		
		// Вид сообщения
		new Main_ElementsFirstTab().getEventType().selectByVisibleText("Прочее");
		
		//  Вид сообщения(Прочее)
		new Main_ElementsFirstTab().getEventTypeOther().click();
		new Main_ElementsFirstTab().getEventTypeOther().inputText(new Main_ElementsFirstTab().new Values().eventTypeOther);
		
		// Дата получения заявителем
		new Main_ElementsFirstTab().getApplicantReceiptDate().inputText(new Main_ElementsFirstTab().new Values().currentTime);
		
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
			private String currentTime = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());				// текущая дата	
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
	
		private class Values{
			private String addEditPopUpName = "Добавить подозреваемое ЛС";										// Название поп-апа 
			private String addEditPopUpNameRegistry = "Выбор ЛС"; 												// Название поп-апа 
		}
	
	}
		
}
