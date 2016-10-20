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
    	// ����� ��������� 
		new DrugPopUp().getButtonOpenDrugPopUp().waitUntilAvailable();
		new DrugPopUp().getButtonOpenDrugPopUp().click();
		new DrugPopUp().getSearchButton().waitUntilAvailable();
		// ���������� ���� ������ ��������������
		new DrugPopUp().getMarketingCountry().selectByVisibleText(new DrugPopUp().new Values().marketingCountry);
		// ���������� ���� �������� ��������:
		new DrugPopUp().getTradeName().inputText(new DrugPopUp().new Values().tradeName);
		// �������� �� ������ "�����"
		new DrugPopUp().getSearchButton().click();
		// ������� ��������� �����
		waitForBlockStatus(new DrugPopUp().getGridDownload_Div(), false);
		// �������� �� ������ '�������� ���������'
		Actions action = new Actions(driver);
		action.click((new DrugPopUp().getTradeNameCell())).perform();
		simpleWait(2);
		// ������� ��������
		new  DrugPopUp().getChooseButton().click();
		simpleWait(2);
	}
	public void OtherFields_FillUp(){
		// ���������� ���� �������� �����
		new OtherPSURFields().getNamePSUR().inputText(new OtherPSURFields().new OtherValues().name);
		// ���������� ���� ���� ������ ��������� �������
		new OtherPSURFields().getReportingPeriodSartDate().click();
		new OtherPSURFields().getReportingPeriodSartDate().inputText(new OtherPSURFields().new OtherValues().ReportingPeriodSartDate);
		// ���������� ���� ���� ��������� ��������� �������
		new OtherPSURFields().getReportingPeriodEndDate().click();
		new OtherPSURFields().getReportingPeriodEndDate().inputText(new OtherPSURFields().new OtherValues().ReportingPeriodEndDate);
		// ���������� ���� ���� ������������ ������
		new OtherPSURFields().getReportCreationDate().click();
		new OtherPSURFields().getReportCreationDate().inputText(new OtherPSURFields().new OtherValues().ReportCreationDate);
		// ����������� ���� �������������� ������ � ������������ �����
		new OtherPSURFields().getRequiredDate().click();
		new OtherPSURFields().getRequiredDate().inputText(new OtherPSURFields().new OtherValues().RequiredDate);
		// ����������� ���� �������������� ������ � ������������ �����
		new OtherPSURFields().getActualDate().click();
		new OtherPSURFields().getActualDate().inputText(new OtherPSURFields().new OtherValues().ActualDate);
		// ���� ������ ������ � ������� ���������� �� ���������������:
		new OtherPSURFields().getSubmissionDate().click();
		new OtherPSURFields().getSubmissionDate().inputText(new OtherPSURFields().new OtherValues().SubmissionDate);
		// ���� ������ ���������� ��������� �������
		new OtherPSURFields().getNextStartDate().click();
		new OtherPSURFields().getNextStartDate().inputText(new OtherPSURFields().new OtherValues().NextStartDate);
		// ���� ��������� ���������� ��������� �������
		new OtherPSURFields().getNextEndDate().click();
		new OtherPSURFields().getNextEndDate().inputText(new OtherPSURFields().new OtherValues().NextEndDate);
		// ����������� ���� �������������� ���������� ������:
		new OtherPSURFields().getNextReportSubmitionDate().click();
		new OtherPSURFields().getNextReportSubmitionDate().inputText(new OtherPSURFields().new OtherValues().NextReportSubmitionDate);
	}
	public void SavePSUR(){
		new OtherPSURFields().getSaveButton().click();
	new BodyOfPSUR().getReportSectionsButton().waitUntilAvailable();
	}
	
	
		
	//______________________________________________Elements_____________________________________________________//
	
	private class DrugPopUp {
		// ������ �������� ���-��� 
		private Button getButtonOpenDrugPopUp(){
			return new Button(driver, By.id("open_trade_names"));
		}
		// ��������� ����� ���������
		private Custom getGridDownload_Div(){															
			return new Custom(driver, By.id("load_list_tradenames"));
		}
		// ������ ��������������
		private Select getMarketingCountry(){
			return new Select(driver.findElement(By.id("TradeNameControl_Country")));
		}
		// �������� ��������
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
			private String tradeNamePopUpName = "������������� �� � ������� �� ������������";
			private String marketingCountry = "�����";                                   // ������ ��������������
			private String tradeName = "�������� ��������";								 // �������� ��������
			
		}
	}
	private class OtherPSURFields{
		// �������� �����
		private TextInput getNamePSUR(){
			return new TextInput(driver, By.id("name"));
		}
		// ���� ������ ��������� �������
		private TextInput getReportingPeriodSartDate(){
			return new TextInput(driver, By.id("start_period"));
		}
		// ���� ��������� ��������� �������
		private TextInput getReportingPeriodEndDate(){
			return new TextInput(driver, By.id("end_period"));
		}
		// ���� ������������ ������
		private TextInput getReportCreationDate(){
			return new TextInput(driver, By.id("report_date"));
		}
		// ����������� ���� �������������� ������ � ������������ �����
		private TextInput getRequiredDate(){
			return new TextInput(driver, By.id("required_provision"));
		}
		// ����������� ���� �������������� ������ � ������������ �����
		private TextInput getActualDate(){
			return new TextInput(driver, By.id("fact_provision"));
		}
		// ���� ������ ������ � ������� ���������� �� ���������������:
		private TextInput getSubmissionDate(){
			return new TextInput(driver, By.id("filing_registration"));
		}
		// ���� ������ ���������� ��������� �������
		private TextInput getNextStartDate(){
			return new TextInput(driver, By.id("start_next_period"));
		}
		// ���� ��������� ���������� ��������� �������
		private TextInput getNextEndDate(){
			return new TextInput(driver, By.id("end_next_period"));
		}
		// ����������� ���� �������������� ���������� ������:
				private TextInput getNextReportSubmitionDate(){
					return new TextInput(driver, By.id("required_provision_next"));
		}
		// ������ ���������
		private Button getSaveButton(){
			return new Button(driver, By.xpath("//input[@type='button' and contains(@value, '���������')]"));
		}
		private class OtherValues{
			private String name = "AutoTestPSUR"; 												// ����� �����
			private String ReportingPeriodSartDate = new CustomMethods().getCurrentDate(); 		// ���� ������ ��������� �������
			private String ReportingPeriodEndDate = new CustomMethods().getChangedDate(4);		// ���� ��������� ��������� �������
			private String ReportCreationDate = new CustomMethods().getCurrentDate(); 		    // ���� ������������ ������
			private String RequiredDate = new CustomMethods().getCurrentDate();					// ����������� ���� �������������� ������ � ������������ �����
			private String ActualDate = new CustomMethods().getChangedDate(1);					// ����������� ���� �������������� ������ � ������������ �����
			private String SubmissionDate = new CustomMethods().getChangedDate(5);				// ���� ������ ������ � ������� ���������� �� ���������������:
			private String NextStartDate = new CustomMethods().getChangedDate(5);				// ���� ������ ���������� ��������� �������
			private String NextEndDate = new CustomMethods().getChangedDate(7);					// ���� ��������� ���������� ��������� �������
			private String NextReportSubmitionDate = new CustomMethods().getChangedDate(8);		// ����������� ���� �������������� ���������� ������:
			
		}
	}
	private class BodyOfPSUR{
		// ������ ������� ������
		private Button getReportSectionsButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick, 'RedirectWithControllEdit')]"));
		}
	}

}