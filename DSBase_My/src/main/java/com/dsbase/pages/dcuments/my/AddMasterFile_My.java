package com.dsbase.pages.dcuments.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
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
	//Заполнение вкладки "Титульная страница"
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
	// заполнение вкладки "1. Информация о УЛОФ"
	public void SectionOnQPPV_FillUP(){
		new SectionOnQPPV().getSectionOnQPPVTab().click();
		getSaveButton().waitUntilAvailable();
		// заполнение полей на вкалдке "1. Информация о УЛОФ"
		// УЛОФ
		new SectionOnQPPV().getFirstNameQPPV().inputText(new SectionOnQPPV().new Values().firstNameQPPV);
		new SectionOnQPPV().getLastNameQPPV().inputText(new SectionOnQPPV().new Values().lastNameQPPV);
		new SectionOnQPPV().getMiddleNameQPPV().inputText(new SectionOnQPPV().new Values().middleNameQPPV);
		new SectionOnQPPV().getAddressQPPV().inputText(new SectionOnQPPV().new Values().addressQPPV);
		new SectionOnQPPV().getPhoneQPPV().inputText(new SectionOnQPPV().new Values().phoneQPPV);
		new SectionOnQPPV().getEmailQPPV().inputText(new SectionOnQPPV().new Values().emailQPPV);
		// Заместитетль УЛОФ
		new SectionOnQPPV().getFirstNameSurrogateQPPV().inputText(new SectionOnQPPV().new Values().firstNameSurrogateQPPV);
		new SectionOnQPPV().getLastNameSurrogateQPPV().inputText(new SectionOnQPPV().new Values().lastNameSurrogateQPPV);
		new SectionOnQPPV().getMiddleNameSurrogateQPPV().inputText(new SectionOnQPPV().new Values().middleNameSurrogateQPPV);
		new SectionOnQPPV().getAddressSurrogateQPPV().inputText(new SectionOnQPPV().new Values().addressSurrogateQPPV);
		new SectionOnQPPV().getPhoneSurrogateQPPV().inputText(new SectionOnQPPV().new Values().phoneSurrogateQPPV);
		new SectionOnQPPV().getEmailSurrogateQPPV().inputText(new SectionOnQPPV().new Values().emailSurrogateQPPV);
		// заплнение поля "Текст раздела"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new SectionOnQPPV().getSectionText1Tab(), new SectionOnQPPV().new Values().setSectionText1Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void OrganisationalStructure_FillUP(){
		// переход на вкладку 
		new OrganisationalStructure().getOrganisationalStructureTab().click();
		// заплнение поля "Текст раздела"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new OrganisationalStructure().getSectionText2Tab(), new OrganisationalStructure().new Values().setSectionText2Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}

	public void SourcesOfSafetyData_FillUp() {
		// переход на вкладку
		new SourcesOfSafetyData().getSourcesOfSafetyDataTab().click();
		// заплнение поля "Текст раздела"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new SourcesOfSafetyData().getSectionText3Tab(),
				new SourcesOfSafetyData().new Values().setSectionText3Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void ComputerisedSystemsAndDb_FillUp(){
		// переход на вкладку 4. Информация о компьютеризированных системах и базах данных
		new ComputerisedSystemsAndDb().getComputerisedSystemsAndDbTab().click();
		// заплнение поля "Текст раздела"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new ComputerisedSystemsAndDb().getSectionText4Tab(),
				new ComputerisedSystemsAndDb().new Values().setSectionText4Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void PharmacovigilanceProcesses_FillUp(){
		// переход на вкладку 5. Информация о процессах фармаконадзора
		new PharmacovigilanceProcesses().getPharmacovigilanceProcessesTab().click();
		// заплнение поля "Текст раздела"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new PharmacovigilanceProcesses().getSectionText5Tab(),
				new PharmacovigilanceProcesses().new Values().setSectionText5Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void PharmacovigilanceSystem_FillUp(){
		// переход на вкладку 6. Информация о продуктивности системы фармаконадзора
		new PharmacovigilanceSystem().getPharmacovigilanceSystemTab().click();
		// заплнение поля "Текст раздела"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new PharmacovigilanceSystem().getSectionText6Tab(),
				new PharmacovigilanceSystem().new Values().setSectionText6Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();	
	}
	public void QualitySystem_FillUp(){
		// переход на вкладку 7. Система качества 
		new QualitySystem().getQualitySystemTab().click();
		// заплнение поля "Текст раздела"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new QualitySystem().getSectionText7Tab(),
				new QualitySystem().new Values().setSectionText7Tab);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();	
	}
	//______________________________________________Elements_______________________________________________________//
	private final String MasterfilePath = "C:\\Selenium_TestData\\Projects\\DSBase\\MasterFile\\";					// путь к файлу текстом для разделов 
	private final String readFile = new CustomMethods().new WorkWith_TextFiles().file_Read(MasterfilePath + "MasterFile.txt");						// чтение файла (переобразованеие в строку)
	// Кнопка сохранить Мастер Файл
	private Button getSaveButton(){
		return new Button(driver, By.id("save_btn"));
	}
	private class TitlePageElements{
		// поле Уникальный номер
		private TextInput getUniqueNumber(){
			return new TextInput(driver, By.id("Tab0_str_Id"));
		}
		// поле дата Составления
		private TextInput getDateOfAddition(){
			return new TextInput(driver, By.id("Tab0_DateOfLastAppeal"));
		}
		// поле Версия 
		private TextInput getVersion(){
			return new TextInput(driver, By.id("Tab0_Version"));
		}
		// поле Дата обновления
		private TextInput getUpdateDate(){
			return new TextInput(driver, By.id("Tab0_DateOfLastAppeal2"));
		}
		// поле текст Раздела
		private WebElement getSectionText(){
			return driver.findElement(By.id("customTextEditor_Tab0Text1_DesignIFrame"));
		}
		private class Values{
			private String setUniqueNumber =  "Droid"; // уникальный номер
			private String setDateOfAddition = new CustomMethods().getCurrentDate();	// Дата составления
			private String setVersion = "R2-D2";	//version
			private String setUpdateDate = new CustomMethods().getChangedDate(2); // Дата обновления
			private String setSectionText = readFile.substring(readFile.indexOf("#1"), readFile.indexOf("#2")); // Текст раздела
		}
	}
	private class SectionOnQPPV{
		//кнопка перехода на вкладку "Информация о УЛОФ"
		private Custom getSectionOnQPPVTab(){
			return new Custom(driver, By.xpath("//div[contains(text(), '1. Информация о УЛОФ')]"));
		}
		// поле Текст раздела:Информация о УЛОФ
		private WebElement	getSectionText1Tab(){
			return driver.findElement(By.id("customTextEditor_Tab1Text1_DesignIFrame"));
		}
		// поле имя Улоф
		private TextInput getFirstNameQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofName"));
		}
		// поле фамилия Улоф
		private TextInput getLastNameQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofSurName"));
		}
		// поле отчетство Улоф
		private TextInput getMiddleNameQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofMiddleName"));
		}
		// поле адрес Улоф
		private TextInput getAddressQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofAddress"));
		}
		// поле телефон Улоф
		private TextInput getPhoneQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofPhone"));
		}
		// поле емейл Улоф
		private TextInput getEmailQPPV(){
			return new TextInput(driver, By.id("Tab1_UllofMail"));
		}

		// поле имя Заместителя Улоф
		private TextInput getFirstNameSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateName"));
		}

		// поле фамилия Заместителя Улоф
		private TextInput getLastNameSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateSurName"));
		}

		// поле отчетство Заместителя Улоф
		private TextInput getMiddleNameSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateMiddleName"));
		}

		// поле адрес Заместителя Улоф
		private TextInput getAddressSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateAddress"));
		}

		// поле телефон Заместителя Улоф
		private TextInput getPhoneSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMatePhone"));
		}

		// поле емейл Заместителя Улоф
		private TextInput getEmailSurrogateQPPV() {
			return new TextInput(driver, By.id("Tab1_UllofMateMail"));
		}
		private class Values{
			private String firstNameQPPV="Anakin";																				// Имя
			private String lastNameQPPV="Skywalker";																			// фамилия
			private String middleNameQPPV="Darth Vader"; 																	    // Отчество
			private String addressQPPV="Death planet";																			// Адрес
			private String phoneQPPV="+380000000000";																			// телефон
			private String emailQPPV="Anakin.Skywalker@darkside.com"; 															// емейл
			private String firstNameSurrogateQPPV="Anakin";																		// Имя
			private String lastNameSurrogateQPPV="Skywalker";																	// фамилия
			private String middleNameSurrogateQPPV="Darth Vader"; 															    // Отчество
			private String addressSurrogateQPPV="Death planet";																	// Адрес
			private String phoneSurrogateQPPV="+380000000000";																	// телефон
			private String emailSurrogateQPPV="Anakin.Skywalker@darkside.com"; 													// емейл
			private String setSectionText1Tab = readFile.substring(readFile.indexOf("#2"), readFile.indexOf("#3")); 			// Текст раздела
		}
	}
	private class OrganisationalStructure{
		//кнопка перехода на вкладку "2. Информация об организационной структуре владельца РС"
		private Custom getOrganisationalStructureTab(){
			return new Custom(driver, By.xpath("//div[contains(text(), '2. Организационная структура ВРС')]"));
		}
		// поле Текст раздела:Информация об организационной структуре владельца РС
		private WebElement	getSectionText2Tab(){
			return driver.findElement(By.id("customTextEditor_Tab2Text1_DesignIFrame"));
		}
		private class Values{
			private String setSectionText2Tab = readFile.substring(readFile.indexOf("#3"), readFile.indexOf("#4")); 			// Текст раздела
		}
	}
	private class SourcesOfSafetyData{
		// кнопка перехода на вкладку "3. Источники данных по безопасности"
		private Custom getSourcesOfSafetyDataTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '3. Источники данных по безопасности')]"));
		}
		// поле Текст раздела:3. Источники данных по безопасности
		private WebElement getSectionText3Tab() {
			return driver.findElement(By.id("customTextEditor_Tab3Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText3Tab = readFile.substring(readFile.indexOf("#4"), readFile.indexOf("#5")); // Текст раздела
		}
	}
	private class ComputerisedSystemsAndDb{
		// кнопка перехода на вкладку ":4. Информация о компьютеризированных системах и базах данных
		private Custom getComputerisedSystemsAndDbTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '4. Компьютеризированные системы и БД')]"));
		}
		// поле Текст раздела:4. Информация о компьютеризированных системах и базах данных
		private WebElement getSectionText4Tab() {
			return driver.findElement(By.id("customTextEditor_Tab4Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText4Tab = readFile.substring(readFile.indexOf("#5"), readFile.indexOf("#6")); // Текст раздела
		}
	}
	private class PharmacovigilanceProcesses{
		// кнопка перехода на вкладку "5. Информация о процессах фармаконадзора
		private Custom getPharmacovigilanceProcessesTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '5. Процессы фармаконадзора')]"));
		}
		// поле Текст раздела:5. Информация о процессах фармаконадзора
		private WebElement getSectionText5Tab() {
			return driver.findElement(By.id("customTextEditor_Tab5Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText5Tab = readFile.substring(readFile.indexOf("#6"), readFile.indexOf("#7")); // Текст раздела
		}
	}
	private class PharmacovigilanceSystem{
		// кнопка перехода на вкладку "6. Информация о продуктивности системы фармаконадзора
		private Custom getPharmacovigilanceSystemTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '6. Продуктивность СФ')]"));
		}
		// поле Текст раздела:6. Информация о продуктивности системы фармаконадзора
		private WebElement getSectionText6Tab() {
			return driver.findElement(By.id("customTextEditor_Tab6Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText6Tab = readFile.substring(readFile.indexOf("#7"), readFile.indexOf("#8")); // Текст раздела
		}
	}
	private class QualitySystem{
		// кнопка перехода на вкладку "7. Система качества 
		private Custom getQualitySystemTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), '7. Система качества ')]"));
		}
		// поле Текст раздела:7. Система качества 
		private WebElement getSectionText7Tab() {
			return driver.findElement(By.id("customTextEditor_Tab7Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText7Tab = readFile.substring(readFile.indexOf("#8"), readFile.indexOf("#9")); // Текст раздела
		}
	}
	
}
