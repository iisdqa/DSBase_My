package com.dsbase.pages.drugs.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.CustomMethods.Grid;
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
		// Открытие поп-апа удаления 'Действущего вещества'
		new Manufacterer_Elements().getDeleteButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Main_Elements().getDeletion_PopUp()));
		simpleWait(2);

		// Удаление МНН
		new Main_Elements().getDeletionYes_Button().click();
		simpleWait(1);

		// Ожидание прогрузки грида
		waitForBlockStatus(new Manufacterer_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}

	public void deletedManufacturer_check() {
		// Проверка отсутствия значений в гриде 'Действущие вещества'
		new CustomMethods().elementExistenceCheck(new Manufacterer_Elements().getManufacturerGridBody(), false);
	}
	// ________________________________________________________________________________________________________________________________//
	
	//___________________________________________________ Действующее вещество _______________________________________________________//
	
		public void addedSubstance_check()
		{
			String[][] ExpectedValues = new String [1][];
			ExpectedValues[0] = new String[] {"",
											  new Substance_Elements().new Values().substance,
											  new Substance_Elements().new Values().substance1,
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
				
			// Удаление МНН
			new Main_Elements().getDeletionYes_Button().click();
			simpleWait(1);
			
			// Ожидание прогрузки грида
			waitForBlockStatus(new Substance_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		//_______________________________________________________________________________________________//

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
			private String addEditPopUpName = "Добавить МНН"; // Название
																// поп-апа
																// добавления/редактирования
																// МНН
			private String mnn = "11122233344"; // МНН
			private String editedMnn = "111222333444"; // МНН после
														// редактирования
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
				private String addEditPopUpName = "Добавить производителя препарата";   // Название поп-апа добавления/редактирования производителя
				private String manufactererName = "Производитель для препарата";	    // Название производителя
				private String manufactererCountry = "Катар";	  						// Страна производителя
				private String manufactererAdress = "ул. Тестовая, д. 1";	  			// Адрес производителя
			}
		}
		
		
		//______________________________Элементы блока 'Действующие вещества'__________________________________________________//
		private class Substance_Elements
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
			
			private class Values
			{
				private String addEditPopUpName = "Добавить действующее вещество";		// Название поп-апа добавления/редактирования действующего вещества
				private String substance = "Тест";	  									// Действующее вещество
				private String editedSubstance = "Тестинин";						    // Действующее вещество после редактирования
				private String substance1="тест1";                                      // Действуещее вещество автокомплит
			}
		}
		//________________________________________________________________________________________________________________________________//

}

