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
	private static final String PAGE_URL = BASE_URL+ "/AdverseReaction/Search"; // ����� ������, ����� ��� ������� ��������

    /*_______________________________ Core _______________________________*/
	public ADRregistry_My(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public boolean isAvailable(){
		return getADRreport().isAvailable(); // �������, ������� ��������� ��� �������� ��������(�.�. ����� ������)
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
		// ������� ���������
		new ADRFiltration_elements().getSearchAccordion().click();
		simpleWait(2);
		// ������� �������� � ����� ��������
		new ADRFiltration_elements().getFiltrationValue().selectByVisibleText("����� ���������");
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
		private String reportNumber="777_AutoTest";                                                                         // ����� ��������� 
		private String documentDate= "27.09.2016";				                                    						// ������� ����	
		private String upToDateInformationDate = "27.09.2016";                                      						// ���� ��������� ����������
		private String reportType="���������";																				// ��� ���������
		private String eventType="������"; 																					// ��� ������
		private String medicallyConfirmed="���";																			// ���������� ��������������
		private String drugTradeNane="�������� ��������";																	// ��� (�������� ��������)
		private String drugPharmaceuticalForm="��������";																	// ��� (����� �������)
		private String drugAuthorizationNumber="222";																		// ��� (� ���������������� �������������)
		private String drugManufacturer="������������� ��� ���������";														// ��� (�������������)
		private String drugManufacterCountry="�����";																		// ��� ������ ������������� 
		private String drugApplicant="��������";																			// ��� ���������
		private String drugApplicantCountry="�����";																		// ��� ������ ���������
		private String	reportSourceQualification="����";																	// ������������ ��������� ��������� 
	}
	
	
	
}
