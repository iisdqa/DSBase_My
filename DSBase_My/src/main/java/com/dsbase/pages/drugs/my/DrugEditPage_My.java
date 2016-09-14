package com.dsbase.pages.drugs.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.TextInput;





public class DrugEditPage_My extends WebPage<DrugEditPage_My> {
	private static final String PAGE_URL = BASE_URL + "/Drugs/Edit";

	public DrugEditPage_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public DrugEditPage_My load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return new Main_Elements().getBirthday().isAvailable();
	}

	// __________________________________________actions____________________________________//
	public void waitForPageReady() {
		waitForBlockStatus(new Mnn_Elements().getGridDownload_Div(), false);
	}

	// ___________________________________________________________МНН________________________________________________________________//

	public void addedMnn_check() {
		// Ожидание прогрузки грида
		waitForBlockStatus(new Mnn_Elements().getGridDownload_Div(), false);
		simpleWait(1);

		// Определение ожидаемых значений
		String[][] ExpectedValues = new String[1][];
		ExpectedValues[0] = new String[] { "", new Mnn_Elements().new Values().mnn, "" };

		// Вытянуть последнее значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Mnn_Elements().getMnnGridBody());

		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}

	public void mnn_Edit() {
		// Открытие поп-апа добавления МНН
		new Mnn_Elements().getEditButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Mnn_Elements().getAddEditPopUp()));
		simpleWait(2);

		// Внести МНН
		new Mnn_Elements().getMnnField().clear();
		simpleWait(1);
		new Mnn_Elements().getMnnField().inputText(new Mnn_Elements().new Values().editedMnn);

		// Сохранение МНН
		new Mnn_Elements().getSaveButton().click();
		simpleWait(1);

		// Ожидание прогрузки грида
		waitForBlockStatus(new Mnn_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}

	public void editedMnn_check() {
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String[1][];
		ExpectedValues[0] = new String[] { "", new Mnn_Elements().new Values().editedMnn, "" };

		// Вытянуть последнее значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Mnn_Elements().getMnnGridBody());

		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}

	public void mnn_Delete() {
		// Открытие поп-апа удаления МНН
		new Mnn_Elements().getDeleteButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Main_Elements().getDeletion_PopUp()));
		simpleWait(2);

		// Удаление МНН
		new Main_Elements().getDeletionYes_Button().click();
		simpleWait(1);

		// Ожидание прогрузки грида
		waitForBlockStatus(new Mnn_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}

	public void deletedMnn_check() {
		// Проверка отсутствия значений в гриде 'МНН'
		new CustomMethods().elementExistenceCheck(new Mnn_Elements().getMnnGridBody(), false);
	}
	// ________________________________________________________________________________________________________________________________//

	// ____________________________________________________Производитель_____________________________________________________________//

	public void addedManufacturer_check() {
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String[1][];
		ExpectedValues[0] = new String[] { "", new Manufacterer_Elements().new Values().manufactererName,
				new Manufacterer_Elements().new Values().manufactererCountry,
				new Manufacterer_Elements().new Values().manufactererAdress, "" };

		// Определение актуальных значений
		String[][] ActualValues = new CustomMethods().new Grid()
				.GetAllRows(new Manufacterer_Elements().getManufacturerGridBody());

		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}

	public void manufacturer_Edit() {
		// Открытие поп-апа добавления производителя
		new Manufacterer_Elements().getEditButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Manufacterer_Elements().getAddEditPopUp()));
		simpleWait(2);

		// Сохранение производителя
		new Manufacterer_Elements().getSaveButton().click();
		simpleWait(1);

		// Ожидание прогрузки грида
		waitForBlockStatus(new Manufacterer_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}

	public void manufacturer_Delete() {
		// Открытие поп-апа удаления 'Производитель'
		new Manufacterer_Elements().getDeleteButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Main_Elements().getDeletion_PopUp()));
		simpleWait(2);

		// Удаление производителя
		new Main_Elements().getDeletionYes_Button().click();
		simpleWait(1);

		// Ожидание прогрузки грида
		waitForBlockStatus(new Manufacterer_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}

	public void deletedManufacturer_check() {
		// Проверка отсутствия значений в гриде 'Производитель'
		new CustomMethods().elementExistenceCheck(new Manufacterer_Elements().getManufacturerGridBody(), false);
	}
	// ________________________________________________________________________________________________________________________________//
	
	//___________________________________________________ Действующее вещество _______________________________________________________//
	
		public void addedSubstance_check()
		{
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
											  new Substance_Elements().new Values().substance,
											  new Substance_Elements().new Values().substanceAuto,
											  ""};
			
		// Определение актуальных значений
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Substance_Elements().getSubstancesGridBody());
			
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
		}
		
		public void substance_Edit()
		{
			// Открытие поп-апа добавления действующего вещества
			new Substance_Elements().getEditButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Substance_Elements().getAddEditPopUp()));
			simpleWait(2);
			
			// Внести действующее вещество
			new Substance_Elements().getSubstanceField().clear();
			simpleWait(1);
			new Substance_Elements().getSubstanceField().inputText(new Substance_Elements().new Values().editedSubstance);
			new Substance_Elements().getSubstanceFieldAuto().clear();
			new Substance_Elements().getSubstanceFieldAuto().inputText(new Substance_Elements().new Values().editedSubstanceAuto);
			new CommonActions().autoCompleteValue_Set(driver,new Substance_Elements().getSubstanceFieldAuto(), 2);
			
			// Сохранение действующее вещество
			new Substance_Elements().getSaveButton().click();
			simpleWait(1);
			
			// Ожидание прогрузки грида
			waitForBlockStatus(new Substance_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
		public void editedSubstance_check()
		{
			// Определение ожидаемых значений
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
					  						  new Substance_Elements().new Values().editedSubstance,
					  						  new Substance_Elements().new Values().editedSubstanceAuto,
											  ""};
			
			// Определение актуальных значений
			String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Substance_Elements().getSubstancesGridBody());
			
			// Проверка значений грида
			new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
		}
		
		public void substance_Delete()
		{
			// Открытие поп-апа удаления 'Действущего вещества'
			new Substance_Elements().getDeleteButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Main_Elements().getDeletion_PopUp()));
			simpleWait(2);
				
			// Удаление 'Действущего вещества'
			new Main_Elements().getDeletionYes_Button().click();
			simpleWait(1);
			
			// Ожидание прогрузки грида
			waitForBlockStatus(new Substance_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		//_______________________________________________________________________________________________//
		
		//________________________________________________________ Документы _____________________________________________________________//

		public void addedDoc_check()
		{
			// Определение ожидаемых значений
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
					  						  new Docs_Elements().new Values().date,
											  new Docs_Elements().new Values().name,
											  new Docs_Elements().new Values().docDescription,
											  new Docs_Elements().new Values().docType,
											  new Docs_Elements().new Values().fileLink,
											  "",
											  ""};
			
			// Определение актуальных значений
			String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Docs_Elements().getDocsGridBody());
			
			// Проверка значений грида
			new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
		}
		
		public void doc_Edit()
		{
			// Открытие поп-апа добавления действующего вещества
			new Docs_Elements().getEditButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Docs_Elements().getEditPopUp()));
			simpleWait(2);
			
			// Внести действующее вещество
			new Docs_Elements().getName_Field().clear();
			simpleWait(1);
			new Docs_Elements().getName_Field().inputText(new Docs_Elements().new Values().editedName);
			
			// Сохранение действующее вещество
			new Docs_Elements().getSaveButton().click();
			simpleWait(1);
			
			// Ожидание прогрузки грида
			waitForBlockStatus(new Docs_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
		public void editedDoc_check(){
			// Определение ожидаемых значений
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
					  						  new Docs_Elements().new Values().date,
					  						  new Docs_Elements().new Values().editedName,
					  						  new Docs_Elements().new Values().docDescription,
					  						  new Docs_Elements().new Values().docType,
					  						  new Docs_Elements().new Values().fileLink,
					  						  "",
					  						  ""};
			
			// Определение актуальных значений
			String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Docs_Elements().getDocsGridBody());
			
			// Проверка значений грида
			new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
		}
		public void doc_Delete(){
			// Открытие поп-апа удаления 'Действущего вещества'
			new Docs_Elements().getDeleteButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Main_Elements().getDeletion_PopUp()));
			simpleWait(2);
				
			// Удаление докумета
			new Main_Elements().getDeletionYes_Button().click();
			simpleWait(1);

			// Ожидание прогрузки грида
			waitForBlockStatus(new Docs_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
		public void deletedDoc_check(){
			// Проверка отсутствия значений в гриде 'Действущие вещества'
			new CustomMethods().elementExistenceCheck(new Docs_Elements().getDocsGridBody() , false);
		}
		//___________________________________________________ Сотрудники _______________________________________________________//
		
		public void addedEmployee_check(){
			// Определение ожидаемых значений
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
											  new Employee_Elements().new Values().fio,
											  new Employee_Elements().new Values().position,
											  ""};
			
			// Определение актуальных значений
			String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Employee_Elements().getEmployeeGridBody());
			
			// Проверка значений грида
			new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
		}
		
		public void employee_Edit(){
			// Открытие поп-апа добавления Сотрудники
			new Employee_Elements().getEditButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Employee_Elements().getAddEditPopUp()));
			simpleWait(2);
			
			// Внести сотрудника
			new Employee_Elements().getPositionField().clear();
			simpleWait(1);
			new Employee_Elements().getPositionField().inputText(new Employee_Elements().new Values().editedPosition);
			
			// Сохранение сотрудника
			new Employee_Elements().getSaveButton().click();
			simpleWait(1);
			
			// Ожидание прогрузки грида
			waitForBlockStatus(new Employee_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
		public void editedEmployee_check(){
			// Определение ожидаемых значений
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
					  						  new Employee_Elements().new Values().fio,
					  						  new Employee_Elements().new Values().editedPosition,
					  						  ""};
			
			// Определение актуальных значений
			String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Employee_Elements().getEmployeeGridBody());
			
			// Проверка значений грида
			new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
		}
		
		public void employee_Delete(){
			// Открытие поп-апа удаления 'Сотрудники'
			new Employee_Elements().getDeleteButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Main_Elements().getDeletion_PopUp()));
			simpleWait(2);
				
			// Удаление сотрудника
			new Main_Elements().getDeletionYes_Button().click();
			simpleWait(1);
			
			// Ожидание прогрузки грида
			waitForBlockStatus(new Employee_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
		public void deletedEmployee_check(){
			// Проверка отсутствия значений в гриде 'Сотрудники'
			new CustomMethods().elementExistenceCheck(new Employee_Elements().getEmployeeGridBody() , false);
		}
		public DrugPassportPage_My drug_Save(){
				new Main_Elements().getSaveButton().click();
				return new DrugPassportPage_My(driver).waitUntilAvailable();
		}
		//________________________________________________________________________________________________________________________________//
		

	// _______________________________________elements______________________________________//
	private class Main_Elements {
		// 'Международная дата рождения'
		private TextInput getBirthday() {
			return new TextInput(driver, By.id("World_drug_identification_drug_birthday"));
		}

		private Custom getDeletion_PopUp() {
			return new Custom(driver, By.id("attention_delete"));
		}

		// Кнопка 'Сохранить'
		private Button getDeletionYes_Button() {
			return new Button(driver, By.xpath("//span[text() = 'Да']"));
		}

		// Кнопка 'Сохранить'
		private Button getSaveButton() {
			return new Button(driver, By.xpath("//input[contains(@onclick,'Save()')]"));
		}
	}

	//_______________________________________________Элементы блока'МНН'____________________________________________________//
	private class Mnn_Elements {

		// Поп-ап добавления
		private Custom getAddEditPopUp() {
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}

		// "Завантаження"
		private Custom getGridDownload_Div() {
			return new Custom(driver, By.id("load_list_Mnn"));
		}

		// <tbody> грида
		private WebElement getMnnGridBody() {
			return driver.findElement(By.xpath("//*[@id='list_Mnn']/tbody"));
		}

		// Мнн
		private TextInput getMnnField() {
			return new TextInput(driver, By.id("mnn_text"));
		}

		// Кнопка 'Сохранить'
		private Button getSaveButton() {
			return new Button(driver, By.xpath("//input[contains(@onclick,'SaveMnn()')]"));
		}

		// Кнопка редактирования
		private Button getEditButton() {
			return new Button(driver, By.xpath("//td[@aria-describedby='list_Mnn_edit']/input"));
		}

		// Кнопка удаления
		private Button getDeleteButton() {
			return new Button(driver, By.xpath("//td[@aria-describedby='list_Mnn_del']/input"));
		}

		private class Values {
			private String addEditPopUpName = "Редактирование записи"; // Название поп-апа добавления/редактирования МНН
			private String mnn = "11122233344"; // МНН
			private String editedMnn = "111222333444"; // МНН после редактирования
		}
	}
	//________________________________________________________________________________________________________________________________//

	// Элементы блока 'Производитель препарата'
	private class Manufacterer_Elements{
			// Поп-ап добавления
			private Custom getAddEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}
			// "Завантаження"
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_manufacturer"));
			}
			// <tbody> грида
			private WebElement getManufacturerGridBody(){
				return driver.findElement(By.xpath("//*[@id='list_manufacturer']/tbody"));
			}
			// Кнопка 'Сохранить'
			private Button getSaveButton(){
				return new Button(driver, By.xpath("//input[contains(@onclick,'OnSave()')]"));
			}
			// Кнопка редактирования
			private Button getEditButton(){
				return new Button(driver, By.xpath("//td[@aria-describedby='list_manufacturer_edit']/input"));
			}
			// Кнопка удаления
			private Button getDeleteButton(){
				return new Button(driver, By.xpath("//td[@aria-describedby='list_manufacturer_del']/input"));
			}
			private class Values{
				private String addEditPopUpName = "Редактирование записи";   // Название поп-апа добавления/редактирования производителя
				private String manufactererName = "Производитель для препарата";	    // Название производителя
				private String manufactererCountry = "Катар";	  						// Страна производителя
				private String manufactererAdress = "ул. Тестовая, д. 1";	  			// Адрес производителя
			}
		}
		
		
		//______________________________Элементы блока 'Действующие вещества'__________________________________________________//
		public class Substance_Elements
		{		
			// Поп-ап добавления
			private Custom getAddEditPopUp()
			{
				return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
			}
			
			// "Завантаження"
			private Custom getGridDownload_Div()
			{
				return new Custom(driver, By.id("load_list_Substances"));
			}
			
			// <tbody> грида
			private WebElement getSubstancesGridBody()
			{
				return driver.findElement(By.xpath("//*[@id='list_Substances']/tbody"));
			}
			
			// Действующее вещество
			private TextInput getSubstanceField()
			{
				return new TextInput(driver, By.id("active_substance"));
			}
			// Действующее вещество автокоплит
			private TextInput getSubstanceFieldAuto(){
				return new TextInput(driver, By.id("active_substance_list_id_Name"));
			}
			
			// Кнопка 'Сохранить'
			private Button getSaveButton()
			{
				return new Button(driver, By.xpath("//input[contains(@onclick,'SaveSubstances()')]"));
			}
			
			// Кнопка редактирования
			private Button getEditButton()
			{
				return new Button(driver, By.xpath("//td[@aria-describedby='list_Substances_edit']/input"));
			}
			
			// Кнопка удаления
			private Button getDeleteButton()
			{
				return new Button(driver, By.xpath("//td[@aria-describedby='list_Substances_del']/input"));
			}
			
			public class Values
			{
				private String addEditPopUpName = "Редактирование записи";		// Название поп-апа добавления/редактирования действующего вещества
				public String substance = "Тест";	  									// Действующее вещество
				private String editedSubstance = "Тестинин";						    // Действующее вещество после редактирования
				public String substanceAuto="тест1";                                      // Действуещее вещество автокомплит
				private String editedSubstanceAuto="тест2";                                // Действуещее вещество автокомплит после редактирования
			}
		}
		//________________________________________________________________________________________________________________________________//

		//_________________________________________________________Элементы блока 'Документы'_____________________________________________//
			private class Docs_Elements{
					
				// Поп-ап добавления
				private Custom getEditPopUp(){
					return new Custom(driver, By.xpath("//span[text() = '" + new Values().editPopUpName + "']"));
				}
				// "Завантаження"
				private Custom getGridDownload_Div(){
					return new Custom(driver, By.id("load_list_file_load"));
				}
				// <tbody> грида
				private WebElement getDocsGridBody(){
						return driver.findElement(By.xpath("//*[@id='list_file_load']/tbody"));
				}
				// Название документа
				private TextInput getName_Field(){
					return new TextInput(driver, By.id("Title"));
				}
					
				// Кнопка 'Сохранить'
				private Button getSaveButton(){
					return new Button(driver, By.id("save_file_btn"));
				}
					
				// Кнопка редактирования
				private Button getEditButton(){
					return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_edit']/input"));
				}
					
				// Кнопка удаления
				private Button getDeleteButton(){
						return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_del']/input"));
				}
					
				private class Values{
					private String editPopUpName = "Редактирование документа";				// Название поп-апа добавления/редактирования документа
					private String date = "05.01.2012";	  									// Дата
					private String name = "Фай";						     				// Название документа
					private String editedName = "Файл";										// Название документа после редактирования
					private String docDescription = "Тестовое";						    	// Описание документа
					private String docType = "Инструкция";						     		// Инструкция
					private String fileLink = "www.getFile.com/get";			     		// Ссылка на файл
				}
			}
			// Элементы блока 'Сотрудники'
			private class Employee_Elements
			{	
				// Поп-ап добавления
				private Custom getAddEditPopUp()
				{
					return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
				}
				
				// "Завантаження"
				private Custom getGridDownload_Div()
				{
					return new Custom(driver, By.id("load_list_staff"));
				}
				
				// <tbody> грида
				private WebElement getEmployeeGridBody()
				{
					return driver.findElement(By.xpath("//*[@id='list_staff']/tbody"));
				}
				
				// Сфера ответственности
				private TextInput getPositionField()
				{
					return new TextInput(driver, By.id("responsibilities"));
				}
				
				// Кнопка 'Сохранить'
				private Button getSaveButton()
				{
					return new Button(driver, By.xpath("//input[contains(@onclick,'SavePerson()')]"));
				}
				
				// Кнопка редактирования
				private Button getEditButton()
				{
					return new Button(driver, By.xpath("//td[@aria-describedby='list_staff_edit']/input"));
				}
				
				// Кнопка удаления
				private Button getDeleteButton()
				{
					return new Button(driver, By.xpath("//td[@aria-describedby='list_staff_del']/input"));
				}
				
				private class Values
				{
					private String addEditPopUpName = "Редактирование записи";		// Название поп-апа добавления/редактирования сотрудника
					private String fio = "Автоматичний Петро Васильович";	  						// ФИО
					private String position = "Начальникэ";						     				// Сфера ответственности
					private String editedPosition = "Начальник";									// Отредактированная сфера ответственности
				}
			}
			//________________________________________________________________________________________________________________________________//
		
}

