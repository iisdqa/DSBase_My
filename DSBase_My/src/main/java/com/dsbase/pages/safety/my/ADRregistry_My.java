package com.dsbase.pages.safety.my;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.CustomMethods.Grid;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.TextInput;
import com.dsbase.core.web.pages.my.LogInPage_My;

import org.openqa.selenium.Keys;

public class ADRregistry_My extends WebPage<ADRregistry_My>{
	private static final String PAGE_URL = BASE_URL+ "/AdverseReaction/Search"; // Можно менять, нужно для прямого редирект

    /*_______________________________ Core _______________________________*/
	public ADRregistry_My(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public boolean isAvailable(){
		return getADRreport().isAvailable(); // Элемент, который ожидается при загрузке страницы(т.е. можно менять)
	}
		
	@Override
	public ADRregistry_My load() {
		// TODO Auto-generated method stub
		driver.get(PAGE_URL);
		return this;
	} 
	/*_______________________________ Actions _______________________________*/
	public void WaitForPageReady(){
		waitForBlockStatus(new ADRFiltration_elements().getGridDownload_Div(),false);
        simpleWait(2);	
	}
	public void SearchADRreport(){
		// Открыть аккордеон
		new ADRFiltration_elements().getSearchAccordion().click();
		simpleWait(2);
		// Указать название и найти препарат
		new ADRFiltration_elements().getFiltrationValue().selectByVisibleText("Номер сообщения");
		new ADRFiltration_elements().getFiltrationValue_Input().inputText("777_AutoTest"+"_"+new CustomMethods().getCurrentDate());
		new ADRFiltration_elements().getSearch_Button().click();
	}
	public void FoundADRreport_Check(){
		// Определение переменных с значениями
		String reportNumber = new Grid_Values().reportNumber;
		String documentDate = new Grid_Values().documentDate;
		String upToDateInformationDate = new Grid_Values().upToDateInformationDate;
		String reportType = new Grid_Values().reportType;
		String eventType = new Grid_Values().eventType;
		String medicallyConfirmed = new Grid_Values().medicallyConfirmed;
		String drugTradeNane = new Grid_Values().drugTradeNane;
		String drugPharmaceuticalForm = new Grid_Values().drugPharmaceuticalForm;
		String drugAuthorizationNumber = new Grid_Values().drugAuthorizationNumber;
		String drugManufacturer = new Grid_Values().drugManufacturer;
		String drugManufacterCountry = new Grid_Values().drugManufacterCountry;
		String drugApplicant= new Grid_Values().drugApplicant;
		String drugApplicantCountry = new Grid_Values().drugApplicantCountry;
		String reportSourceQualification = new Grid_Values().reportSourceQualification;
		String reportSourceCountry = new Grid_Values().reportSourceCountry;
		String reportSourseOrganization = new Grid_Values().reportSourseOrganization;
		String sendersCountry = new Grid_Values().sendersCountry;
		String patientInitials = new Grid_Values().patientInitials;
		String patientBirthday = new Grid_Values().patientBirthday;
		String patientSex = new Grid_Values().patientSex;
		String reportLanguage= new Grid_Values().reportLanguage;
		
		// Определение массива ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0]=new String []{"","","","","NotNull",reportNumber+"_"+new CustomMethods().getCurrentDate()," ",documentDate,upToDateInformationDate,reportType,eventType,medicallyConfirmed,drugTradeNane,drugPharmaceuticalForm,"",drugAuthorizationNumber,drugManufacturer,drugManufacterCountry,
						                       drugApplicant,drugApplicantCountry,reportSourceQualification," ",reportSourceCountry,reportSourseOrganization," ",sendersCountry,patientInitials,patientBirthday," "," ",patientSex," ","","","","","","NotNull",reportLanguage,""};
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods(). new Grid().GetAllRows(getGridBody());
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void ADRreport_Delete(){

		// Открытие поп-апа удаления 'Препарата'
		new Deletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
			
		// Подтверждение удаления прапарата
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
		
		//
		waitForBlockStatus(new ADRFiltration_elements().getGridDownload_Div(), false);
	

	}
	public LogInPage_My userOut(){
		// Выход из системы
		return new CommonActions().userOut(driver);
	}
	
	/*_______________________________ Elements_______________________________*/
	private Button getADRreport(){
		return new Button(driver, By.xpath("//input[@onclick='AddReaction()']"));
	}
	private WebElement getGridBody(){
		return driver.findElement(By.xpath("//table[@id='list_search']/tbody"));
	}
	
	private Custom getExcelButton(){
		return new Custom(driver, By.id("export_report_btn"));
	}
	private class ADRFiltration_elements{
		
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_search"));	
		}
		private Custom	getSearchAccordion(){
			return new Custom(driver, By.id("ui-accordion-accordFilter-header-0"));
		}
		private TextInput getFiltrationValue_Input(){
			return new TextInput(driver, By.xpath("//input[contains(@id,'value')]"));
		}
		private Button getSearch_Button(){
			return new Button(driver, By.id("buttonSearch"));
		}
		private Select getFiltrationValue(){
			return new Select(driver.findElement(By.xpath("//select[contains(@id,'name')]")));
		}
		// Крутилка

		public Custom blocker() { 
			return new Custom  (driver, By.xpath("//div[contains(@class, 'blockUI')]")); //не находит xpath
		}
		
	}
	private class Grid_Values{
		private String reportNumber = "777_AutoTest";                                                                       // номер сообщения 
		private String documentDate = new CustomMethods().getCurrentDate();				                                    // текущая дата	
		private String upToDateInformationDate = "27.09.2016";                                      						// дата последней инофрмации
		private String reportType ="первичное";																				// тип сообщения
		private String eventType = "Прочее"; 																				// вид случая
		private String medicallyConfirmed = "Нет";																			// Медецински подтвержденный
		private String drugTradeNane = "Тестовый препарат";																	// ПЛС (Торговое название)
		private String drugPharmaceuticalForm = "Таблетки";																	// ПЛС (Форма выпуска)
		private String drugAuthorizationNumber = "222";																		// ПЛС (№ регистрационного удостоверения)
		private String drugManufacturer = "Производитель для препарата";													// ПЛС (производитель)
		private String drugManufacterCountry = "Катар";																		// ПЛС страна производителя 
		private String drugApplicant = "Автотест_(только для автотестов)";																			// ПЛС заявитель
		private String drugApplicantCountry = "Катар";																		// ПЛС страна заявителя
		private String reportSourceQualification = "врач";																	// Квалификация источника сообщения 
		private String reportSourceCountry = "Катар";																		// Страна источника сообщения
		private String reportSourseOrganization = "USA organization"; 														// организация источника сообщения
		private String sendersCountry = "Катар";																			// страна отправителя
		private String patientInitials = "AVT";																				// инициалы пациента
		private String patientBirthday = "06.02.1998";																		// Дата рождения пациента
		private String patientSex = "неизвестно";																			// пол пациента
		private String reportLanguage = "ru";																				// язык
	}
	private class Deletion_PopUp{
		// Кнопка удаления
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_search_del']/input"));
		}
		// Поп-ап удаления
		private Custom getDeletion_PopUp(){
			return new Custom(driver, By.id("attention_delete"));
		}
		// Кнопка 'Да'
		private Button getDeletionYes_Button(){
			return new Button(driver, By.xpath("//span[text() = 'Да']"));
		}
	}
	
	
	
}
