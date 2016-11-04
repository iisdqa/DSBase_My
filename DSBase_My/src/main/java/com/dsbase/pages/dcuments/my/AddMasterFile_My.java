package com.dsbase.pages.dcuments.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.TextInput;

public class AddMasterFile_My extends WebPage<AddMasterFile_My> {
	private static final String PAGE_URL = BASE_URL + "/Reports/Add";
	public AddMasterFile_My(WebDriver driver){
		super (driver);
	}
	@Override
	public AddMasterFile_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override 
	public boolean isAvailable() {
		return  getSaveButton().isAvailable();
	}
	//______________________________________________Actions_______________________________________________________//
	//���������� ������� "��������� ��������"
	public void TitlePage_FillUp(){
		new TitlePageElements().getUniqueNumber().inputText(new TitlePageElements().new Values().setUniqueNumber);
		new TitlePageElements().getDateOfAddition().click();
		new TitlePageElements().getDateOfAddition().inputText(new TitlePageElements().new Values().setDateOfAddition);
		new TitlePageElements().getVersion().inputText(new TitlePageElements().new Values().setVersion);
		new TitlePageElements().getUpdateDate().click();
		new TitlePageElements().getUpdateDate().inputText(new TitlePageElements().new Values().setUpdateDate);
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new TitlePageElements().getSectionText(), new TitlePageElements().new Values().setSectionText);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	
	//______________________________________________Elements_______________________________________________________//
	private final String MasterfilePath = "C:\\Selenium_TestData\\Projects\\DSBase\\MasterFile\\";					// ���� � ����� ������� ��� �������� 
	private final String readFile = new CustomMethods().new WorkWith_TextFiles().file_Read(MasterfilePath + "MasterFile.txt");						// ������ ����� (���������������� � ������)
	// ������ ��������� ������ ����
	private Button getSaveButton(){
		return new Button(driver, By.id("save_btn"));
	}
	private class TitlePageElements{
		// ���� ���������� �����
		private TextInput getUniqueNumber(){
			return new TextInput(driver, By.id("Tab0_str_Id"));
		}
		// ���� ���� �����������
		private TextInput getDateOfAddition(){
			return new TextInput(driver, By.id("Tab0_DateOfLastAppeal"));
		}
		// ���� ������ 
		private TextInput getVersion(){
			return new TextInput(driver, By.id("Tab0_Version"));
		}
		// ���� ���� ����������
		private TextInput getUpdateDate(){
			return new TextInput(driver, By.id("Tab0_DateOfLastAppeal2"));
		}
		// ���� ����� �������
		private WebElement getSectionText(){
			return driver.findElement(By.id("customTextEditor_Tab0Text1_DesignIFrame"));
		}
		private class Values{
			private String setUniqueNumber =  "Droid"; // ���������� �����
			private String setDateOfAddition = new CustomMethods().getCurrentDate();	// ���� �����������
			private String setVersion = "R2-D2";	//version
			private String setUpdateDate = new CustomMethods().getChangedDate(2); // ���� ����������
			private String setSectionText = readFile.substring(readFile.indexOf("#1"), readFile.indexOf("#2")); // ����� �������
		}
	}

	
}
