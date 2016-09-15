package com.dsbase.pages.drugs.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Link;
import com.dsbase.core.web.elements.Text;





public class DrugPassportPage_My extends WebPage<DrugPassportPage_My> {
	private static final String PAGE_URL = BASE_URL + "/Drugs/View/";

	public DrugPassportPage_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public DrugPassportPage_My load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getDrugPassportButton().isAvailable();
	}

	/*================================================================ Методы============================================================*/
	public class GoTo{
		public DrugInstructionsPage_My instructionsPage(){
			new DrugRegistration_Elements().getInstructions_Link().click();
			simpleWait(1);
			return new DrugInstructionsPage_My(driver).waitUntilAvailable();
		}
		
		public DrugChangesPage_My changesPage(){
			new DrugRegistration_Elements().getChanges_Link().click();
			simpleWait(1);
			return new DrugChangesPage_My(driver).waitUntilAvailable();
		}
		
//		public DrugReferentsPage referentsPage() 										пока нет референтных
//		{
//			new DrugRegistration_Elements().getRefDrug_Link().click();
//			simpleWait(1);
//			return new DrugReferentsPage(driver).waitUntilAvailable();
//		}
	}
	
	public void addedPassport_Check(){
		// Проверка тайтла
		drugPassportTitle_Check();
		
		
		// Проверка блока МНН
		mnnPart_check("Add");
		
		// Проверка блока производители
		manufacturerPart_check();
		
		// Проверка части 'Регистрация ЛС'
		drugRegistrationPart_check();
		
		// Проверка части 'Состав ЛС'
		drugStructurePart_check("Add");
		
		// Проверка грида 'Перерегистрация ЛС'
		drugReRegistrationPart_check();
		
		// Проверка грида 'Изменения'
		drugChanges_check();
		
		// Проверка блока 'Дата предоставления документов на перерегистрацию' и близлежащих
		LastPart_check();
	
		// Проверка грида 'Сотрудники'
		employeesPart_check("Add");
		
		// Проверка грида 'Страны маркетирования'
		drugOtherCountries_check();
	}
	public DrugEditPage_My drug_Edit(){
		getDrugEdit_Button().click();
		simpleWait(2);
		return new DrugEditPage_My(driver).waitUntilAvailable();
	}
	private void drugPassportTitle_Check(){
		// Определение тайтла
		String expectedTitle = "Паспорт препарата: Катар, Тестовый препарат, Таблетки, 02.01.2012, 222";
		String actualTitle = new CustomMethods().StringSpacesCut(getDrugPassport_Title().getText());
		
		// Проверка соответствия
		assertThat(actualTitle, is(equalTo(expectedTitle)));
	}
	public void editedPassport_Check(){
		// Проверка тайтла
		drugPassportTitle_Check();
		
		// Проверка грида МНН
		mnnPart_check("Edit");
		
		// Проверка грида производители
		manufacturerPart_check();
		
		// Проверка части 'Состав ЛС'
		drugStructurePart_check("Edit");
		
		// Проверка части 'Регистрация ЛС'
		drugRegistrationPart_check();
		
		// Проверка грида 'Перерегистрация ЛС'
		drugReRegistrationPart_check();
		
		// Проверка грида 'Изменения'
		drugChanges_check();
		
		// Проверка блока 'Дата предоставления документов на перерегистрацию' и близлежащих
		LastPart_check();
	
		// Проверка грида 'Сотрудники'
		employeesPart_check("Edit");
		
		// Проверка грида 'Страны маркетирования'
		drugOtherCountries_check();
	}
	private void mnnPart_check(String CheckType){
		// Объявление переменной
		String Mnn = "";
		
		// Присвоение значения переменной в зависимости от типа проверки
		if(CheckType.equals("Add")) Mnn = new Grids_Elements().new Mnn().new Values().Mnn;
		else if(CheckType.equals("Edit")) Mnn = new Grids_Elements().new Mnn().new Values().editedMnn;
		
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {Mnn};
		
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Mnn().getGridBody());
		
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	private void manufacturerPart_check(){
		// Определение значений ячеек
		String manufacturerName = new Grids_Elements().new Manufacturer().new Values().manufactererName;
		String manufacturerCountry = new Grids_Elements().new Manufacturer().new Values().manufactererCountry;
		String manufacturerAdress = new Grids_Elements().new Manufacturer().new Values().manufactererAdress;
		
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {manufacturerName, manufacturerCountry, manufacturerAdress};
		
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Manufacturer().getGridBody());
		
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	/*_________________________________________________ Проверка действующего вещества _________________________________________________*/
	private void drugStructurePart_check(String CheckType){
		// Объявление переменной
		String activeSubstance = new DrugEditPage_My(driver).new Substance_Elements().new Values().substance;
		String activeSubstanceAuto = new DrugEditPage_My(driver).new Substance_Elements().new Values().substanceAuto;
		
		// Присвоение значения переменной в зависимости от типа проверки
		if(CheckType.equals("Edit")) {
			activeSubstance = new Grids_Elements().new Drug_Structure().new Values().editedActiveSubstance;
			activeSubstanceAuto = new Grids_Elements().new Drug_Structure().new Values().editedSubstanceAuto;
		}
		
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {activeSubstance,activeSubstanceAuto};
		
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Drug_Structure().getGridBody());
		
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	private void drugRegistrationPart_check(){
		/*___________________________________________ Проверка ссылок в блоке 'Регистрация ЛС' ___________________________________________*/
		
		// Определение ожидаемых значений
		String appTypeExpected = new DrugRegistration_Elements().new Values().appType;
		String regDateExpected = new DrugRegistration_Elements().new Values().regDate;
		String regNumExpected = new DrugRegistration_Elements().new Values().regNum;
		String instructionsExpected = new DrugRegistration_Elements().new Values().instructionsLink;
		String psurExpected = new DrugRegistration_Elements().new Values().psurLink;
		String prExpected = new DrugRegistration_Elements().new Values().prLink;
		String changesExpected = new DrugRegistration_Elements().new Values().changesLink;
		String refDrugExpected = new DrugRegistration_Elements().new Values().refDrugLink;
		
		// Определение реальных значений
		String appTypeActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getAppType_Link().getText());
		String regDateActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getRegDate_Link().getText());
		String regNumActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getRegNum_Link().getText());
		String instructionsActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getInstructions_Link().getText());
		String psurActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getPsur_Link().getText());
		String prActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getPrMessages_Link().getText());
		String changesActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getChanges_Link().getText());
		String refDrugActual = new CustomMethods().StringSpacesCut(new DrugRegistration_Elements().getRefDrug_Link().getText());

		// Проверка значений
		assertThat(appTypeActual, is(equalTo(appTypeExpected)));
		assertThat(regDateActual, is(equalTo(regDateExpected)));
		assertThat(regNumActual, is(equalTo(regNumExpected)));
		assertThat(instructionsActual, is(equalTo(instructionsExpected)));
		assertThat(psurActual, is(equalTo(psurExpected)));
		assertThat(prActual, is(equalTo(prExpected)));
		assertThat(changesActual, is(equalTo(changesExpected)));
		assertThat(refDrugActual, is(equalTo(refDrugExpected)));
	}
	//_________________________________________________________________________________________________________________________________//
//	/*================================================= Проверки связанные с другими тестами(пока не используется) ==============================================*/
//	public class For_Other_Tests
//	{
//		public class DrugChanges_Test
//		{
//			public void added_drugChanges_Check()
//			{	
//				// Определение значений ячеек
//				String orderNumber = new Values().orderNumber;
//				String orderDate = new Values().orderDate;
//				String changeType = new Values().changeType;
//				
//				// Определение ожидаемых значений
//				String[][] ExpectedValues = new String [1][];
//				ExpectedValues[0] = new String[] {"",
//												  orderNumber, 
//												  orderDate, 
//												  changeType};
//				
//				// Вытянуть значения из грида
//				String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Drug_Changes().getGridBody());
//				
//				// Проверка значений грида
//				new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
//			}
//			
//			public DrugChangeAddEditPage drugChange_Edit()
//			{
//				new Grids_Elements().new Drug_Changes().getEdit_Button().click();
//				simpleWait(1);
//				return new DrugChangeAddEditPage(driver).waitUntilAvailable();
//			}
//			
//			private class Values
//			{
//				private String orderNumber = "111222";	  						  		// № приказа
//				private String orderDate = "02.01.2012";								// Дата приказа
//				private String changeType = "Административные изменения";				// Тип изменения
//			}
//		}
//	}
	//________________________________________________________________________________________________________________________________//
	private class DrugRegistration_Elements{		
		private Link getAppType_Link(){
			return new Link(driver, By.xpath("(//span[contains(@onclick, 'ForEditRegistrations')])[1]"));
		}
		
		private Link getRegDate_Link(){
			return new Link(driver, By.xpath("(//span[contains(@onclick, 'ForEditRegistrations')])[2]"));
		}
		
		private Link getRegNum_Link(){
			return new Link(driver, By.xpath("(//span[contains(@onclick, 'ForEditRegistrations')])[3]"));
		}
		
		private Link getInstructions_Link(){
			return new Link(driver, By.xpath("//span[contains(@onclick, '/Instructions/List')]"));
		}
		
		private Link getPsur_Link(){
			return new Link(driver, By.xpath("//span[contains(@onclick, '?m=3')]"));
		}
		
		private Link getPrMessages_Link(){
			return new Link(driver, By.xpath("//span[contains(@onclick, '?m=4')]"));
		}
		
		private Link getChanges_Link(){
			return new Link(driver, By.xpath("//span[contains(@onclick, '/ChangesDrug/List')]"));
		}
		
		private Link getRefDrug_Link(){
			return new Link(driver, By.xpath("//span[contains(@onclick, '/ReferenceDrug/List')]"));
		}
		
		private class Values{
			private String appType = "Тестовый";	  										// Тип заявки при регистрации
			private String regDate = "02.01.2012";	  										// Дата регистрации
			private String regNum = "222";	  												// Номер РУ
			private String instructionsLink = "Инструкции";	  								// Инструкции
			private String psurLink = "Отчеты по безопасности";	  							// Отчеты по безопасности
			private String prLink = "Сообщения о ПР/ОЭ";	  								// Сообщения о ПР/ОЭ
			private String changesLink = "Изменения";	  									// Изменения
			private String refDrugLink = "Референтные ЛС";	  							    // Референтные ЛС
		}
	}
	private void drugReRegistrationPart_check(){
		// Проверка отсутствия значений в гриде 'Перерегистрация ЛС'
		new CustomMethods().elementExistenceCheck(new Grids_Elements().new Drug_Reregistration().getGridBody() , false);
	}
	
	private void drugChanges_check(){
		// Проверка отсутствия значений в гриде 'Изменения'
		new CustomMethods().elementExistenceCheck(new Grids_Elements().new Drug_Changes().getGridBody() , false);
	}
	
	private void LastPart_check(){
		// Определение значений ячеек грида
		String plannedDateTitle = new LastPart_Elements().new Values().plannedDateTitle;
		String plannedDate = new LastPart_Elements().new Values().plannedDate;
		String actualDateTitle = new LastPart_Elements().new Values().actualDateTitle;
		String actualDate = new LastPart_Elements().new Values().actualDate;
		String endRuDateTitle = new LastPart_Elements().new Values().endRuDateTitle;
		String endRuDate = new LastPart_Elements().new Values().endRuDate;
		String drugConditionTitle = new LastPart_Elements().new Values().drugConditionTitle;
		String drugCondition = new LastPart_Elements().new Values().drugCondition;
		
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [4][];
		ExpectedValues[0] = new String[] {plannedDateTitle, actualDateTitle};
		ExpectedValues[1] = new String[] {plannedDate, actualDate};
		ExpectedValues[2] = new String[] {endRuDateTitle, drugConditionTitle};
		ExpectedValues[3] = new String[] {endRuDate, drugCondition};
		
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new LastPart_Elements().getGridBody());
		
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	private void employeesPart_check(String CheckType){
		// Определение значений ячеек грида
		String FIO = new Grids_Elements().new Employees().new Values().fio;
		
		// Объявление переменной
		String Position = "";
		
		// Присвоение значения переменной в зависимости от типа проверки
		if(CheckType.equals("Add")) Position = new Grids_Elements().new Employees().new Values().position;
		else if(CheckType.equals("Edit")) Position = new Grids_Elements().new Employees().new Values().editedPosition;
		
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {FIO, Position};
		
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Employees().getGridBody());
		
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	private void drugOtherCountries_check(){
		// Проверка отсутствия значений в гриде 'Изменения'
		new CustomMethods().elementExistenceCheck(new Grids_Elements().new Drug_OtherCountries().getGridBody() , false);
	}
	
	/*==============================================Используемые элементы и действия с ними=============================================*/

	private Button getDrugPassportButton() {
		return new Button(driver, By.id("PasportPreparata"));
	}

	private Text getDrugPassport_Title() {
		return new Text(driver, By.xpath("//div[@class='content_page table_cell']/h1"));
	}

	private Button getDrugEdit_Button() {
		return new Button(driver, By.xpath("//input[@type='button' and contains(@onclick, 'EditFirstDrug')]"));
	}
	//__________________________________________________ Элементы блоков с гридами ___________________________________________________//
	
	private class Grids_Elements{
		// Грид 'МНН'
		private class Mnn{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_Mnn']/tbody"));
			}
			private class Values{
			    private String Mnn = "11122233344";      								// МНН
			    private String editedMnn = "111222333444";								// МНН после редактирования
			}
		}	
			
		// Грид 'Производители'
		private class Manufacturer{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_manufacturer']/tbody"));
			}
				
			private class Values{
				private String manufactererName = "Производитель для препарата";	  	// Название производителя
				private String manufactererCountry = "Катар";	  						// Страна производителя
				private String manufactererAdress = "ул. Тестовая, д. 1";	  			// Адрес производителя
			}
		}
			
		// Блок 'Состав ЛС'
		private class Drug_Structure{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_Substances']/tbody"));
			}
			private class Values{
				private String editedSubstanceAuto = "тест2";
				private String editedActiveSubstance = "Тестинин";						     	// Действующее вещество после редактирования
			}
		}
		// Грид 'Перерегистрация ЛС'
		private class Drug_Reregistration{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_re_registering']/tbody"));
			}
		}
		// Грид 'Изменения'
		private class Drug_Changes{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_drug_changes']/tbody"));
		}
//				private Button getEdit_Button(){
//					return new Button(driver, By.xpath("//td[@aria-describedby='list_drug_changes_edit']/input"));        // нет страницы DrugChangeAddEditPage_My
//				}
		}
		// Грид 'Сотрудники'
		private class Employees{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_staff']/tbody"));
			}
			private class Values{
				private String fio = "Автоматичний Петро Васильович";	  						// ФИО
				private String position = "Начальникэ";						     				// Сфера ответственности
				private String editedPosition = "Начальник";									// Отредактированная сфера ответственности
			}
		}
		// Грид 'Страны маркетирования'
		private class Drug_OtherCountries{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_countries']/tbody"));
			}
		}
	
	}
	private class LastPart_Elements{
		private WebElement getGridBody(){
			return driver.findElement(By.xpath("(//div[@class='content_page table_cell']/div[@class='max_width1010px']/table)[4]/tbody"));
		}
			
		private class Values{
			private String plannedDateTitle = "Запланированная:";	  			    // Название поля 'Запланированная дата'
			private String plannedDate = "01.01.2013";	  							// Значение поля 'Запланированная дата'
			private String actualDateTitle = "Фактическая:";	  					// Название поля 'Фактическая дата'
			private String actualDate = "";	  										// Значение поля 'Фактическая дата'
			private String endRuDateTitle = "Дата окончания РУ:";	  				// Название поля 'Дата окончания РУ'
			private String endRuDate = "01.01.2014";	  							// Значение поля 'Дата окончания РУ'
			private String drugConditionTitle = "Состояние по препарату:";	  		// Название поля 'Состояние по препарату'
			private String drugCondition = "в стадии разработки";	  				// Значение поля 'Состояние по препарату'
		}
	}
		
		
}
