package com.dsbase.pages.adr_reports;


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
		new ADRFiltration_elements().getFiltrationValue_Input().inputText("777_AutoTest");
		new ADRFiltration_elements().getSearch_Button().click();
	}
	public void FoundADRreport_Check(){
		
	}
	
	/*_______________________________ Elements_______________________________*/
	private Button getADRreport(){
		return new Button(driver, By.xpath("//input[@onclick='AddReaction()']"));
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
		
	}
	private class Grid_Values{
		private String reportNumber="777_AutoTest";                                                                         // номер сообщения 
		private String documentDate= "27.09.2016";				                                    						// текущая дата	
		private String upToDateInformationDate = "27.09.2016";                                      						// дата последней инофрмации
		private String reportType="первичное";																				// тип сообщения
		private String eventType="Прочее"; 																					// вид случая
		private String medicallyConfirmed="Нет";																			// Медецински подтвержденный
		private String drugTradeNane="Тестовый препарат";																	// ПЛС (Торговое название)
		private String drugPharmaceuticalForm="Таблетки";																	// ПЛС (Форма выпуска)
		private String drugAuthorizationNumber="222";																		// ПЛС (№ регистрационного удостоверения)
		private String drugManufacturer="Производитель для препарата";														// ПЛС (производитель)
		private String drugManufacterCountry="Катар";																		// ПЛС страна производителя 
		private String drugApplicant="Автотест";																			// ПЛС заявитель
		private String drugApplicantCountry="Катар";																		// ПЛС страна заявителя
		private String	reportSourceQualification="врач";																	// Квалификация источника сообщения 
	}
	
	
	
}
