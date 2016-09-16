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
	
	
	public void mainFields_FillUpFirstTab(){    // ���������� ������������ �����
	
	    // ����� ���������
		new Main_ElementsFirstTab().getReportNumber().click();
		new Main_ElementsFirstTab().getReportNumber().inputText(new Main_ElementsFirstTab().new Values().reportNumber);
		
		// ��� ���������
		new Main_ElementsFirstTab().getEventType().selectByVisibleText("������");
		
		//  ��� ���������(������)
		new Main_ElementsFirstTab().getEventTypeOther().click();
		new Main_ElementsFirstTab().getEventTypeOther().inputText(new Main_ElementsFirstTab().new Values().eventTypeOther);
		
		// ���� ��������� ����������
		new Main_ElementsFirstTab().getApplicantReceiptDate().inputText(new Main_ElementsFirstTab().new Values().currentTime);
		
		// �����������
		new Main_ElementsFirstTab().getSourceOrganization().inputText(new Main_ElementsFirstTab().new Values().sourceOrganization);
		
		// ������������ ��������� ���������
		new Main_ElementsFirstTab().getReportSourceQualification().selectByVisibleText(new Main_ElementsFirstTab().new Values().reportSourceQualification);
		
	}
	/*__________________________________________________������ ������� "���������� � ��������"____________________________________*/
	public void goToSecondTab(){
		
		new Main_ElementsSecondTab().getSecondTab().click();
	}
	public void mainFields_FillUpSecondTab() {
		// ���������� ���� ��������
		new Main_ElementsSecondTab().getDayOfBirthday().inputText(new Main_ElementsSecondTab().new Values().dayOfBirthday);
		new Main_ElementsSecondTab().getMonthOfBirthday().inputText(new Main_ElementsSecondTab().new Values().monthOfBirthday);
		new Main_ElementsSecondTab().getYearOfBirthday().inputText(new Main_ElementsSecondTab().new Values().yearOfBirthday);
	
		// ���������� ���� "�������� ��������"
		new Main_ElementsSecondTab().getPatiensInitials().inputText(new Main_ElementsSecondTab().new Values().patientInitials);
		
	}
	
	/*________________________________________5 ������� "�������� �������"__________________________________________*/
	// ������� �� 5 �������
	public void goToFifthTab(){
		new ADRCaseDescription().getFifthTab().click();
	}
	// ����������� ����  "�������� ��"
	public void mainFields_FillUpFifthTab(){
		new ADRCaseDescription().getADRdescription().inputText(new ADRCaseDescription().new Values().aDRdescription);
	}
	/*_________________________________________________6 ������� _______________________________________________________*/
	// ������� �� 6 ������� 
	public void goToSixthTab(){
		new Drugs_add().getSixthTab().click();
	}
	//���������� ���������
	public void suspectDrugs_Add(){
		// �������� ���-��� ���������� �������������� ���������
		new Drugs_add().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Drugs_add().getAddEditPopUp()));
		simpleWait(2);
		
		//������ �������� ��������� � �����
		new Drugs_add().addDrugFromRegistry().click(); 
		
	}
	
	
	/*_____________________________________________________Elements_______________________________________________________*/
/*___________________________________________������� "���������� � ���������"___________________________________________________________*/
	private class Main_ElementsFirstTab{
		//����� ���������
		private TextInput getReportNumber(){
			return new TextInput(driver, By.id("Safetyreport_safetyreportid"));
		}
		// ��� ���������
		private Select getEventType(){
			return new Select(driver.findElement(By.id("Form_137_dic_case_type_id")));
		}
		private TextInput getEventTypeOther(){
			return new TextInput(driver, By.id("Form_137_other_case_type"));
		}
		// ���� ��������� ����������
		private TextInput getApplicantReceiptDate(){
			return new TextInput(driver, By.id("Safetyreport_receivedate"));
		}
		// ����������� ��������� 
		private TextInput getSourceOrganization(){
			return new TextInput(driver, By.id("Source_reporterorganization"));
		}
		private Select getReportSourceQualification(){
			return new Select(driver.findElement(By.id("Source_qualification_id")));
		}
		private class Values{
			private String reportNumber = "777_AutoTest";     																	// ����� ���������
			private String eventTypeOther = "��������� �������������";                      									// ��� ������ ������
			private String currentTime = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());				// ������� ����	
			private String sourceOrganization = "USA organization";																// ����������� ��������� 
			private String reportSourceQualification = "����" ;  																// ������������ ��������� ���������
		}
		
		
	}
	/*______________________________________________________������ ������� "���������� � ��������"___________________________________________________________*/
	private class Main_ElementsSecondTab{
		//������� �� ������ �������
		private Link getSecondTab (){
			return new Link(driver, By.xpath("//a[@href='#tab2']"));
		}
		// ���� �������� ����
		private TextInput getDayOfBirthday(){
			return new TextInput(driver, By.id("Patient_BirthDay"));
		}
		// ���� �������� �����
		private TextInput getMonthOfBirthday(){
			return new TextInput(driver, By.id("Patient_BirthMonth"));
		}
		//���� �������� ���
		private TextInput getYearOfBirthday(){
			return new TextInput(driver, By.id("Patient_BirthYear"));
		}
		// ���������� ���� "�������� ��������"
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
	/*________________________________________________5 ������� �������� �������_________________________________________*/
	private class ADRCaseDescription {
		//������� �� ����� �������
		private Link getFifthTab (){
			return new Link(driver, By.xpath("//a[@href='#tab5']"));
		}
		// ��������� ���� "�������� ������ ��"
		private TextInput getADRdescription(){
			return new TextInput(driver, By.id("Summary_narrativeincludeclinical"));
		}
		private class Values{
			private String aDRdescription="�������� ����, �������, ������ ��������";
		}
	}
	/*_______________________________________________6 �������____________________________________________________________*/
	private class Drugs_add {
		//������� �� ����� �������
		private Link getSixthTab (){
			return new Link(driver, By.xpath("//a[@href='#tab6']"));
		}
		// ������ ���-�� "������������� ��"
		private Button getAddButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick,'AddEditDrug(null, 1)')]"));
		}
		// ���-�� ����������
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}
		
		// ������ "������ ����������"
		private Button addDrugFromRegistry(){
			return new Button(driver, By.id("is_new_trade_names"));
		}
	
		private class Values{
			private String addEditPopUpName = "�������� ������������� ��";										// �������� ���-��� 
			private String addEditPopUpNameRegistry = "����� ��"; 												// �������� ���-��� 
		}
	
	}
		
}
