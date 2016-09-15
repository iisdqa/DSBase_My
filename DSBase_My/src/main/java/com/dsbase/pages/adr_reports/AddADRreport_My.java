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
	public void mainFields_FillUp1(){    // Заполнение обязательных полей
	
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
		new Main_ElementsFirstTab().getReportSourceQualification().selectByVisibleText("врач"); //вывести в отдельную переменную

		
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
		}
		
	}
	
	
	
		
}
