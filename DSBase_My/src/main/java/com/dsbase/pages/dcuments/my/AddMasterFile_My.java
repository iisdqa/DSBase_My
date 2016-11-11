package com.dsbase.pages.dcuments.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
	public void AnneхA_FillUp(){
		// переход на вкладку приложение А 
		new AnneхA().getAnneхATab().click();
		// заплнение поля "Текст приложения"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver,
				new AnneхA().getAnneхATeхt(),
				new AnneхA().new Values().setAnnexAText);
		simpleWait(2);
		// добавление значения в грид "Элементы приложения"
		new AnneхA().getAnnexAElementsButton().click();
		new AnneхA().getNumberAnnexA().waitUntilAvailable();
		new AnneхA().getNumberAnnexA().inputText(new AnneхA().new Values().setNumberAnnexA);
		new AnneхA().getTitleAnnexA().inputText(new AnneхA().new Values().setTitleAnnexA);
		new AnneхA().getDateAnnexA().click();
		new AnneхA().getDateAnnexA().inputText(new AnneхA().new Values().setDateAnnexA);
		new AnneхA().getNoteAnnexA().inputText(new AnneхA().new Values().setNoteAnnexA);
		new AnneхA().getSaveAnnexAElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new AnneхA().getGridDownload_Div(), false);
	
		// Кликнуть по ячейке 'Название'
		Actions action = new Actions(driver);
		action.click(new AnneхA().getElementNameCell()).perform();
		simpleWait(2);
	
		// Добавление документа
	
		// Открытие поп-апа добавления документа
		new AnneхA().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new AnneхA().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);
				
		// Дата
		new AnneхA().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new AnneхA().new Docs_Elements().getDate_Field().inputText(new AnneхA().new Docs_Elements().new Values().date);
		// Название документа
		new AnneхA().new Docs_Elements().getName_Field().inputText(new AnneхA().new Docs_Elements().new Values().name);
		// Описание документа
		new AnneхA().new Docs_Elements().getDescription_Field().inputText(new AnneхA().new Docs_Elements().new Values().docDescription);	
		// Тип документа
		new AnneхA().new Docs_Elements().getDocType_Field().selectByVisibleText(new AnneхA().new Docs_Elements().new Values().docType);
		// Добавление файл + проверка подстановки в текстовое поле
		new AnneхA().new Docs_Elements().getFileUpload_Button().inputText(new AnneхA().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new AnneхA().new Docs_Elements().getFile_Field().getAttribute("value"), is(equalTo(new AnneхA().new Docs_Elements().new Values().fileName)));
		// Ссылка на файл
		new AnneхA().new Docs_Elements().getFileLink_Field().inputText(new AnneхA().new Docs_Elements().new Values().fileLink);
		// Сохранение файла
		new AnneхA().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// Ожидание прогрузки грида
		waitForBlockStatus(new AnneхA().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void AnneхB_FillUp(){
		// переход на вкладку приложение B
		new AnneхB().getAnneхBTab().click();
		// заплнение поля "Текст приложения"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new AnneхB().getAnneхBTeхt(),
				new AnneхB().new Values().setAnnexBText);
		simpleWait(2);
		
		// добавление значения в грид "Список договоров и соглашений"
		new AnneхB().getListOfAgreementsButton().click();
		new AnneхB().getAgreementNumber().waitUntilAvailable();
		new AnneхB().getAgreementNumber().waitUntilAvailable();	
		new AnneхB().getAgreementNumber().inputText(new AnneхB().new Values().setAgreementNumber);
		new AnneхB().getSignatureDate().click();
		new AnneхB().getSignatureDate().inputText(new AnneхB().new Values().setSignatureDate);
		new AnneхB().getOrganization().inputText(new AnneхB().new Values().setOrganization);
		new AnneхB().getTopic().inputText(new AnneхB().new Values().setTopic);
		new AnneхB().getEffectiveDate().click();
		new AnneхB().getEffectiveDate().inputText(new AnneхB().new Values().setEffectiveDate);
		new AnneхB().getCompletionDate().click();
		new AnneхB().getCompletionDate().inputText(new AnneхB().new Values().setCompletionDate);
		new AnneхB().getStatus().selectByVisibleText(new AnneхB().new Values().setStatus);
		new AnneхB().getNoteEgreements().inputText(new AnneхB().new Values().setNoteEgreements);
		new AnneхB().getSaveEgreementsButton().click();
		// Ожидание прогрузки грида
		waitForBlockStatus(new AnneхB().getAgreementsGridDownload_Div(), false);
		simpleWait(2);
		
		// добавление значения в грид "Элементы приложения"
		new AnneхB().getAnnexBElementsButton().click();
		new AnneхB().getNumberAnnexB().waitUntilAvailable();
		new AnneхB().getNumberAnnexB().inputText(new AnneхB().new Values().setNumberAnnexB);
		new AnneхB().getTitleAnnexB().inputText(new AnneхB().new Values().setTitleAnnexB);
		new AnneхB().getDateAnnexB().click();
		new AnneхB().getDateAnnexB().inputText(new AnneхB().new Values().setDateAnnexB);
		new AnneхB().getNoteAnnexB().inputText(new AnneхB().new Values().setNoteAnnexB);
		new AnneхB().getSaveAnnexBElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new AnneхB().getGridDownload_Div(), false);
		
		// Кликнуть по ячейке 'Название'
		Actions action = new Actions(driver);
		action.click(new AnneхB().getElementNameCell()).perform();
		simpleWait(2);
		
		// Добавление документа

		// Открытие поп-апа добавления документа
		new AnneхB().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new AnneхB().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// Дата
		new AnneхB().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new AnneхB().new Docs_Elements().getDate_Field().inputText(new AnneхB().new Docs_Elements().new Values().date);
		// Название документа
		new AnneхB().new Docs_Elements().getName_Field().inputText(new AnneхB().new Docs_Elements().new Values().name);
		// Описание документа
		new AnneхB().new Docs_Elements().getDescription_Field()
				.inputText(new AnneхB().new Docs_Elements().new Values().docDescription);
		// Тип документа
		new AnneхB().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new AnneхB().new Docs_Elements().new Values().docType);
		// Добавление файл + проверка подстановки в текстовое поле
		new AnneхB().new Docs_Elements().getFileUpload_Button()
				.inputText(new AnneхB().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new AnneхB().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new AnneхB().new Docs_Elements().new Values().fileName)));
		// Ссылка на файл
		new AnneхB().new Docs_Elements().getFileLink_Field()
				.inputText(new AnneхB().new Docs_Elements().new Values().fileLink);
		// Сохранение файла
		new AnneхB().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// Ожидание прогрузки грида
		waitForBlockStatus(new AnneхB().new Docs_Elements().getGridDownload_Div(), false);
		simpleWait(2);
		getSaveButton().click();
		getSaveButton().waitUntilAvailable();
	}
	public void AnneхC_FillUp(){
		// переход на вкладку приложение А
		new AnneхC().getAnneхCTab().click();
		// заплнение поля "Текст приложения"
		new CustomMethods().new WorkWith_TextEditor().setTextValue(driver, new AnneхC().getAnneхCTeхt(),
				new AnneхC().new Values().setAnnexCText);
		simpleWait(2);
		// добавление значения в грид "Элементы приложения"
		new AnneхC().getAnnexCElementsButton().click();
		new AnneхC().getNumberAnnexC().waitUntilAvailable();
		new AnneхC().getNumberAnnexC().inputText(new AnneхC().new Values().setNumberAnnexC);
		new AnneхC().getTitleAnnexC().inputText(new AnneхC().new Values().setTitleAnnexC);
		new AnneхC().getDateAnnexC().click();
		new AnneхC().getDateAnnexC().inputText(new AnneхC().new Values().setDateAnnexC);
		new AnneхC().getNoteAnnexC().inputText(new AnneхC().new Values().setNoteAnnexC);
		new AnneхC().getSaveAnnexCElemetsButton().click();
		simpleWait(2);
		waitForBlockStatus(new AnneхC().getGridDownload_Div(), false);

		// Кликнуть по ячейке 'Название'
		Actions action = new Actions(driver);
		action.click(new AnneхC().getElementNameCell()).perform();
		simpleWait(2);

		// Добавление документа

		// Открытие поп-апа добавления документа
		new AnneхC().new Docs_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new AnneхC().new Docs_Elements().getAddEditPopUp()));
		simpleWait(2);

		// Дата
		new AnneхC().new Docs_Elements().getDate_Field().click();
		simpleWait(1);
		new AnneхC().new Docs_Elements().getDate_Field().inputText(new AnneхC().new Docs_Elements().new Values().date);
		// Название документа
		new AnneхC().new Docs_Elements().getName_Field().inputText(new AnneхC().new Docs_Elements().new Values().name);
		// Описание документа
		new AnneхC().new Docs_Elements().getDescription_Field()
				.inputText(new AnneхC().new Docs_Elements().new Values().docDescription);
		// Тип документа
		new AnneхC().new Docs_Elements().getDocType_Field()
				.selectByVisibleText(new AnneхC().new Docs_Elements().new Values().docType);
		// Добавление файл + проверка подстановки в текстовое поле
		new AnneхC().new Docs_Elements().getFileUpload_Button()
				.inputText(new AnneхC().new Docs_Elements().new Values().fileWay);
		simpleWait(2);
		assertThat(new AnneхC().new Docs_Elements().getFile_Field().getAttribute("value"),
				is(equalTo(new AnneхC().new Docs_Elements().new Values().fileName)));
		// Ссылка на файл
		new AnneхC().new Docs_Elements().getFileLink_Field()
				.inputText(new AnneхC().new Docs_Elements().new Values().fileLink);
		// Сохранение файла
		new AnneхC().new Docs_Elements().getSaveButton().click();
		simpleWait(1);
		// Ожидание прогрузки грида
		waitForBlockStatus(new AnneхC().new Docs_Elements().getGridDownload_Div(), false);
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
			return new Custom(driver, By.xpath("//div[contains(text(), '7. Система качества')]"));
		}
		// поле Текст раздела:7. Система качества 
		private WebElement getSectionText7Tab() {
			return driver.findElement(By.id("customTextEditor_Tab7Text1_DesignIFrame"));
		}
		private class Values {
			private String setSectionText7Tab = readFile.substring(readFile.indexOf("#8"), readFile.indexOf("#9")); // Текст раздела
		}
	}
	private class AnneхA{
		// кнопка перехода на вкладку "Приложение А - УЛОФ
		private Custom getAnneхATab() {
			return new Custom(driver, By.xpath("//div[contains(text(), 'Приложение А - УЛОФ')]"));
		}
		// поле Текст приложения А 
		private WebElement getAnneхATeхt() {
			return driver.findElement(By.id("customTextEditor_Tab8_AText1_DesignIFrame"));
		}
		// кнопка добавления элементов приложения 
		private Button getAnnexAElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain8_A"));
		}
		// поле "№"
		private TextInput getNumberAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsNumber"));
		}
		// поле название 
		private TextInput getTitleAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsName"));
		}
		// поле дата
		private TextInput getDateAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsDate"));
		}
		// поле примечание 
		private TextInput getNoteAnnexA(){
			return new TextInput(driver, By.id("Tab8EGrid_ElementsNote"));
		}
		// кнопка сохранить(popUp)
		private Button getSaveAnnexAElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// загрузка грида
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main8_A"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main8_A_ElementsName']"));
		}
		private class Values{
			String setAnnexAText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10")); // Текст приложения
			String setNumberAnnexA = "444222";															// номер
			String setTitleAnnexA = "Звездные войны";													// название 
			String setDateAnnexA = new CustomMethods().getCurrentDate();								// дата
			String setNoteAnnexA = "Без примечаний";													// примечание
		}
		private class Docs_Elements{
			// Кнопка добавления
			private Button getAddButton(){
				return new Button(driver, By.id("add_edit_tab"));
			}
						
			// Поп-ап добавления
			private Custom getAddEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}
						
			// "Завантаження"
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_tab8_A"));
			}
						
			// Дата
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocDate"));
			}
						
			// Название документа
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocName"));
			}
						
			// Описание документа
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocDescribe"));
			}
						
			// Описание документа
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab8Grid_DocCategory")));
			}
						
			// Файл
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// Ссылка на файл
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab8Grid_DocLinkFile"));
			}
						
			// Кнопка 'Сохранить'
			private Button getSaveButton(){
				return new Button(driver, By.id("save_dialog_btn"));
			}
								
			private class Values{
				private String addEditPopUpName = "Создание новой записи";				// Название поп-апа добавления/редактирования документа
				private String date = new CustomMethods().getCurrentDate(); 	 		// Дата
				private String name = "Файл";						     				// Название документа
				private String docDescription = "Тестовое";						    	// Описание документа
				private String docType = "Должностная инструкция";						// Инструкция
				private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";	// Ссылка на файл(реальная)
				private String fileName = "ForDocAdd.txt";								// Название файла
				private String fileLink = "www.getFile.com/get";			     		// Ссылка на файл 
			}
			
		}
		
	}
	private class AnneхB{
		// кнопка перехода на вкладку "Приложение В - Организационная структура владельца РС"
		private Custom getAnneхBTab() {
			return new Custom(driver,
					By.xpath("//div[contains(text(), 'Приложение В - Организационная структура ВРС')]"));
		}
		// Кнопка добавления в грид Список договоров и соглашений
        private Button getListOfAgreementsButton(){
        	return new Button(driver, By.id("add_edit_tabContract9_B"));
        }
        // поле "Номер договора"
        private TextInput getAgreementNumber(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractNumber"));
        }
        // поле Дата подписания
        private TextInput getSignatureDate(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractDateConfirm"));
        }
        // поле Организация
        private TextInput getOrganization(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractOrganization"));
        }
        // поле тема
        private TextInput getTopic(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractTitle"));
        }
        // поле Дата начала действия:
        private TextInput getEffectiveDate(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractDateBegin"));
        }
        // поле Дата завершения действия:
        private TextInput getCompletionDate(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractDateEnd"));
        }
        // поле Статус
        private Select getStatus(){
        	return new Select(driver.findElement(By.id("Tab9CGrid_ContractStatus")));
        }
        // поле "Примечание"
        private TextInput getNoteEgreements(){
        	return new TextInput(driver, By.id("Tab9CGrid_ContractNote"));
        }
        private Button getSaveEgreementsButton(){
        	return new Button(driver, By.id("save_dialog_btn"));
        }
        // Загрузка грида Список договоров и соглашений
     	private Custom getAgreementsGridDownload_Div() {
     		return new Custom(driver, By.id("load_list_tab_main9_B"));
     	}
		// поле Текст приложения B
		private WebElement getAnneхBTeхt() {
			return driver.findElement(By.id("customTextEditor_Tab9_BText1_DesignIFrame"));
		}
		
		// кнопка добавления элементов приложения
		private Button getAnnexBElementsButton() {
			return new Button(driver, By.id("add_edit_tabMain9_B"));
		}

		// поле "№"
		private TextInput getNumberAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsNumber"));
		}

		// поле название
		private TextInput getTitleAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsName"));
		}

		// поле дата
		private TextInput getDateAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsDate"));
		}

		// поле примечание
		private TextInput getNoteAnnexB() {
			return new TextInput(driver, By.id("Tab9EGrid_ElementsNote"));
		}

		// кнопка сохранить(popUp)
		private Button getSaveAnnexBElemetsButton() {
			return new Button(driver, By.id("save_dialog_btn"));
		}

		// загрузка грида "Элементы приложения"
		private Custom getGridDownload_Div() {
			return new Custom(driver, By.id("load_list_tab_main9_B"));
		}

		private WebElement getElementNameCell() {
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main9_B_ElementsName']"));
		}

		private class Values {
			String setAgreementNumber = "4444"; 								// номер договора
			String setSignatureDate = new CustomMethods().getCurrentDate();		// Дата подписания:
			String setOrganization = "Конфедерация";    						// Организация
			String setTopic = "Захват галактики";								// тема
			String setEffectiveDate = new CustomMethods().getChangedDate(1);	// Дата начала действия
			String setCompletionDate = new CustomMethods().getChangedDate(2);   // Дата завершения действия
			String setStatus = "На рассмотрении";								// Статус
			String setNoteEgreements = "без примечаний";						// примечание
			
			
			
			
			String setAnnexBText = readFile.substring(readFile.indexOf("#10"), readFile.indexOf("#11"));  // Текст приложения
			String setNumberAnnexB = "444222"; 															  // номер
			String setTitleAnnexB = "Звездные войны";                                                     // название
			String setDateAnnexB = new CustomMethods().getCurrentDate();                                  // дата
			String setNoteAnnexB = "Без примечаний";                                                      // примечание
		}

		private class Docs_Elements {
			// Кнопка добавления
			private Button getAddButton() {
				return new Button(driver, By.id("add_edit_tab"));
			}

			// Поп-ап добавления
			private Custom getAddEditPopUp() {
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}

			// "Завантаження"
			private Custom getGridDownload_Div() {
				return new Custom(driver, By.id("load_list_tab9_B"));
			}

			// Дата
			private TextInput getDate_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocDate"));
			}

			// Название документа
			private TextInput getName_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocName"));
			}

			// Описание документа
			private TextInput getDescription_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocDescribe"));
			}

			// Описание документа
			private Select getDocType_Field() {
				return new Select(driver.findElement(By.id("Tab9Grid_DocCategory")));
			}

			// Файл
			private TextInput getFile_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocFileName"));
			}

			private TextInput getFileUpload_Button() {
				return new TextInput(driver, By.id("file_source"));
			}

			// Ссылка на файл
			private TextInput getFileLink_Field() {
				return new TextInput(driver, By.id("Tab9Grid_DocLinkFile"));
			}

			// Кнопка 'Сохранить'
			private Button getSaveButton() {
				return new Button(driver, By.id("save_dialog_btn"));
			}

			private class Values {
				private String addEditPopUpName = "Создание новой записи"; 				    // Название поп-апа добавления/редактирования документа
				private String date = new CustomMethods().getCurrentDate();				    // Дата
				private String name = "Файл"; 												// Название документа
				private String docDescription = "Тестовое"; 								// Описание документа
				private String docType = "Должностная инструкция";						    // Инструкция
				private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";    // Ссылка на файл(реальная)
				private String fileName = "ForDocAdd.txt"; 									// Название файла
				private String fileLink = "www.getFile.com/get"; 							// Ссылка на файл
			}

		}
	}
	private class AnneхC{
		// кнопка перехода на вкладку "Приложение C - Источники данных по безопасности
		private Custom getAnneхCTab() {
			return new Custom(driver, By.xpath("//div[contains(text(), 'Приложение C - Источники данных по безопасности')]"));
		}
		// поле Текст приложения А 
		private WebElement getAnneхCTeхt() {
			return driver.findElement(By.id("customTextEditor_Tab10_CText1_DesignIFrame"));
		}
		// кнопка добавления элементов приложения 
		private Button getAnnexCElementsButton(){
			return new Button(driver, By.id("add_edit_tabMain10_C"));
		}
		// поле "№"
		private TextInput getNumberAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsNumber"));
		}
		// поле название 
		private TextInput getTitleAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsName"));
		}
		// поле дата
		private TextInput getDateAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsDate"));
		}
		// поле примечание 
		private TextInput getNoteAnnexC(){
			return new TextInput(driver, By.id("Tab10EGrid_ElementsNote"));
		}
		// кнопка сохранить(popUp)
		private Button getSaveAnnexCElemetsButton(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// загрузка грида
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_main10_C"));	
		}
		private WebElement getElementNameCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_tab_main10_C_ElementsName']"));
		}
		private class Values{
			String setAnnexCText = readFile.substring(readFile.indexOf("#9"), readFile.indexOf("#10")); // Текст приложения
			String setNumberAnnexC = "444222";															// номер
			String setTitleAnnexC = "Звездные войны";													// название 
			String setDateAnnexC = new CustomMethods().getCurrentDate();								// дата
			String setNoteAnnexC = "Без примечаний";													// примечание
		}
		private class Docs_Elements{
			// Кнопка добавления
			private Button getAddButton(){
				return new Button(driver, By.id("add_edit_tab"));
			}
						
			// Поп-ап добавления
			private Custom getAddEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}
						
			// "Завантаження"
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_tab10_C"));
			}
						
			// Дата
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocDate"));
			}
						
			// Название документа
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocName"));
			}
						
			// Описание документа
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocDescribe"));
			}
						
			// Категория документа
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("Tab10Grid_DocCategory")));
			}
						
			// Файл
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocFileName"));
			}
						
			private TextInput getFileUpload_Button(){
					return new TextInput(driver, By.id("file_source"));
			}
						
			// Ссылка на файл
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("Tab10Grid_DocLinkFile"));
			}
						
			// Кнопка 'Сохранить'
			private Button getSaveButton(){
				return new Button(driver, By.id("save_dialog_btn"));
			}
								
			private class Values{
				private String addEditPopUpName = "Создание новой записи";				// Название поп-апа добавления/редактирования документа
				private String date = new CustomMethods().getCurrentDate(); 	 		// Дата
				private String name = "Файл";						     				// Название документа
				private String docDescription = "Тестовое";						    	// Описание документа
				private String docType = "Должностная инструкция";						// Инструкция
				private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";	// Ссылка на файл(реальная)
				private String fileName = "ForDocAdd.txt";								// Название файла
				private String fileLink = "www.getFile.com/get";			     		// Ссылка на файл 
			}
			
		}
		
	}

}
