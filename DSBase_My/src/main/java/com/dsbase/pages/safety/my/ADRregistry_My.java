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
		new ADRFiltration_elements().getFiltrationValue_Input().inputText("777_AutoTest"+"_"+new CustomMethods().getCurrentDate());
		new ADRFiltration_elements().getSearch_Button().click();
	}
	public void FoundADRreport_Check(){
		// ����������� ���������� � ����������
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
		
		// ����������� ������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0]=new String []{"","","","","NotNull",reportNumber+"_"+new CustomMethods().getCurrentDate()," ",documentDate,upToDateInformationDate,reportType,eventType,medicallyConfirmed,drugTradeNane,drugPharmaceuticalForm,"",drugAuthorizationNumber,drugManufacturer,drugManufacterCountry,
						                       drugApplicant,drugApplicantCountry,reportSourceQualification," ",reportSourceCountry,reportSourseOrganization," ",sendersCountry,patientInitials,patientBirthday," "," ",patientSex," ","","","","","","NotNull",reportLanguage,""};
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods(). new Grid().GetAllRows(getGridBody());
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void ADRreport_Delete(){

		// �������� ���-��� �������� '���������'
		new Deletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
			
		// ������������� �������� ���������
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
		
		//
		waitForBlockStatus(new ADRFiltration_elements().getGridDownload_Div(), false);
	

	}
	public LogInPage_My userOut(){
		// ����� �� �������
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
		// ��������

		public Custom blocker() { 
			return new Custom  (driver, By.xpath("//div[contains(@class, 'blockUI')]")); //�� ������� xpath
		}
		
	}
	private class Grid_Values{
		private String reportNumber = "777_AutoTest";                                                                       // ����� ��������� 
		private String documentDate = new CustomMethods().getCurrentDate();				                                    // ������� ����	
		private String upToDateInformationDate = "27.09.2016";                                      						// ���� ��������� ����������
		private String reportType ="���������";																				// ��� ���������
		private String eventType = "������"; 																				// ��� ������
		private String medicallyConfirmed = "���";																			// ���������� ��������������
		private String drugTradeNane = "�������� ��������";																	// ��� (�������� ��������)
		private String drugPharmaceuticalForm = "��������";																	// ��� (����� �������)
		private String drugAuthorizationNumber = "222";																		// ��� (� ���������������� �������������)
		private String drugManufacturer = "������������� ��� ���������";													// ��� (�������������)
		private String drugManufacterCountry = "�����";																		// ��� ������ ������������� 
		private String drugApplicant = "��������_(������ ��� ����������)";																			// ��� ���������
		private String drugApplicantCountry = "�����";																		// ��� ������ ���������
		private String reportSourceQualification = "����";																	// ������������ ��������� ��������� 
		private String reportSourceCountry = "�����";																		// ������ ��������� ���������
		private String reportSourseOrganization = "USA organization"; 														// ����������� ��������� ���������
		private String sendersCountry = "�����";																			// ������ �����������
		private String patientInitials = "AVT";																				// �������� ��������
		private String patientBirthday = "06.02.1998";																		// ���� �������� ��������
		private String patientSex = "����������";																			// ��� ��������
		private String reportLanguage = "ru";																				// ����
	}
	private class Deletion_PopUp{
		// ������ ��������
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_search_del']/input"));
		}
		// ���-�� ��������
		private Custom getDeletion_PopUp(){
			return new Custom(driver, By.id("attention_delete"));
		}
		// ������ '��'
		private Button getDeletionYes_Button(){
			return new Button(driver, By.xpath("//span[text() = '��']"));
		}
	}
	
	
	
}
