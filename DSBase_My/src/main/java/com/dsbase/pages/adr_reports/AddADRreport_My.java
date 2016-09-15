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
	public void mainFields_FillUp1(){    // ���������� ������������ �����
	
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
		new Main_ElementsFirstTab().getReportSourceQualification().selectByVisibleText("����"); //������� � ��������� ����������

		
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
		}
		
	}
	
	
	
		
}
