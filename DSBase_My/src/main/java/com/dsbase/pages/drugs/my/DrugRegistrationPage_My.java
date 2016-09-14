package com.dsbase.pages.drugs.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Text;
import com.dsbase.core.web.elements.TextInput;








public class DrugRegistrationPage_My extends WebPage<DrugRegistrationPage_My>{
	private static final String PAGE_URL = BASE_URL + "/Drugs/Registration";
	
	public DrugRegistrationPage_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public DrugRegistrationPage_My load(){
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable(){
		return new Main_Elements().getBirthday().isAvailable();
	}

/*_______________________________________________________________________*/	
	
/*_______________________________ Actions _______________________________*/
	 public void marketingCountry_Set(){

	String country = new Main_Elements().new Values().marketingCountry;
	
	// Страна маркетирования
	new Main_Elements().getMarketingCoutry().selectByVisibleText("<Другая страна>");
	
	// Ожидание прогрузки грида
	waitForBlockStatus(new Main_Elements().new CountriesPopUp().getGridDownload_Div(), false);
	simpleWait(1);
	
	// Поиск страны
	new Main_Elements().new CountriesPopUp().getCountryName().inputText(country);
	new Main_Elements().new CountriesPopUp().getCountrySearchButton().click();
	simpleWait(1);
	
	// Ожидание прогрузки грида
	waitForBlockStatus(new Main_Elements().new CountriesPopUp().getGridDownload_Div(), false);
	simpleWait(1);
	
	// Кликнуть по ячейке 'Страна'(были проблемы с мозилой)
	Actions action = new Actions(driver);
	action.click((new Main_Elements().new CountriesPopUp().getQatarCell())).perform();
	simpleWait(2);
	
	// Выбрать
	new Main_Elements().new CountriesPopUp().getCountryAcceptButton().click();
	simpleWait(2);
	
	// Проверка выбора страны и заполнение адреса
	String chosenCountry = new Main_Elements().getMarketingCoutry().getFirstSelectedOption().getText();
	assertThat(chosenCountry, is(equalTo(country)));
	}
	public void mainFields_FillUp(){    // Заполнение обязательных полей
		// Страна маркетирования
		marketingCountry_Set();
		
	    // Международная дата рождения
		new Main_Elements().getBirthday().click();
		new Main_Elements().getBirthday().inputText(new Main_Elements().new Values().Birthday);
		
		// Проверка подтягивания страны и адреса заявителя при выборе заявителя
		new Main_Elements().getDeclarer().inputText(new Main_Elements().new Values().Declarer);
		simpleWait(3);
		new Main_Elements().getAutocompletedDeclarer().click();
		simpleWait(2);
		assertThat(new Main_Elements().getDeclarerCountry().getAttribute("value"), is(equalTo(new Main_Elements().new Values().DeclarerCountry)));
		assertThat(new Main_Elements().getDeclarerCity().getAttribute("value"),is(equalTo(new Main_Elements().new Values().DeclarerCity)));
		assertThat(new Main_Elements().getDeclarerAdress().getAttribute("value"), is(equalTo(new Main_Elements().new Values().DeclarerAdress)));

		// Держатель РУ 
		new Main_Elements().getHolder().inputText(new Main_Elements(). new Values().holder);
		new CommonActions().autoCompleteValue_Set(driver, new Main_Elements().getHolder(), 1);
	
		// Торговое название препарата
		new Main_Elements().getTradeName().inputText(new Main_Elements().new Values().DrugTradeName);
		
		// Форма выпуска препарата
		new Main_Elements().getOutputForm().inputText(new Main_Elements().new Values().DrugOutputForm);
		
		// Фасовка
		new Main_Elements().getPacking().inputText(new Main_Elements().new Values().Packing);
		
		// Условия отпуска
		new Main_Elements().getLeaveCondition().inputText(new Main_Elements().new Values().DrugLeaveCondition);
		
		// Способ введения 
		new Main_Elements().getInjectionWay().selectByVisibleText(new Main_Elements().new Values().InjectionWay);
		
		// Вспомогательные вещества
		new Main_Elements().getAdditionalSubstance().inputText(new Main_Elements().new Values().AdditionalSubstance);
		
		// АТС код
		new Main_Elements().getAtcCode().inputText(new Main_Elements().new Values().AtcCode);
		
		// АТС группа
		new Main_Elements().getAtcGroup().inputText(new Main_Elements().new Values().AtcGroup);
		
		// Тип заявки при регистрации
		new Main_Elements().getApplicationType().inputText(new Main_Elements().new Values().ApplicationType);
		
		// Дата регистрации
		new Main_Elements().getRegistrationDate().click();
		new Main_Elements().getRegistrationDate().inputText(new Main_Elements().new Values().RegistrationDate);
		
		// № РУ
		new Main_Elements().getRegistrationNumber().inputText(new Main_Elements().new Values().RegistrationNumber);
		
		// Дата окончания РУ
		new Main_Elements().getRegistrationEndDate().click();
		new Main_Elements().getRegistrationEndDate().inputText(new Main_Elements().new Values().RegistrationEndDate);
		
		// Дата начала продаж
		new Main_Elements().getMarketLounchDate().click();
		new Main_Elements().getMarketLounchDate().inputText(new Main_Elements().new Values().marketLounchDate);
		
		// Фактическая дата предоставления документов на перерегистрацию
		new Main_Elements().getReRegFactDate().click();
		new Main_Elements().getReRegFactDate().inputText(new Main_Elements().new Values().ReRegFactDate);
		
		// Состояние по препарату
		new Main_Elements().getDrugCondition().selectByVisibleText(new Main_Elements().new Values().DrugCondition);
		
		// № приказа
		new Main_Elements().getOrderNumber().inputText(new Main_Elements().new Values().OrderNumber);
		
		// Показания для применения
		new Main_Elements().getIndicationForUSe().inputText(new Main_Elements().new Values().IndicationForUSe);
		
		// Срок хранения
		new Main_Elements().getShelfLife().inputText(new Main_Elements().new Values().shelfLife);
		
		// Условия хранения
		new Main_Elements().getStorageConditions().inputText(new Main_Elements().new Values().storageConditions);
		
		// Проверка подтягивания запланированной даты предоставления документов на перерегистрацию
		assertThat(new Main_Elements().getReRegPlannedDate().getAttribute("value"), is(equalTo(new Main_Elements().new Values().ReRegPlannedDate)));
		
		
	}
	/*_______________________________________________________________________________________________________________________*/
	public void mnn_Add(){  //  добавление МНН		
		// Открытие поп-апа добавления МНН
		new Mnn_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Mnn_Elements().getAddEditPopUp()));
		simpleWait(2);
		
		// Внести МНН
		new Mnn_Elements().getMnnField().inputText(new Mnn_Elements().new Values().mnn);
		
		// Сохранение МНН
		new Mnn_Elements().getSaveButton().click();
		simpleWait(1);
		
		// Ожидание прогрузки грида
		waitForBlockStatus(new Mnn_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}
	public void addedMnn_check(){ // Проверка добавления MHH
	
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
										  new Mnn_Elements().new Values().mnn,
										  ""};
		
		// Вытянуть последнее значения из грида
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Mnn_Elements().getMnnGridBody());
		
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	//____________________________________________________ Производитель _____________________________________________________________//
	
	public void manufacturer_Add(){		
			// Открытие поп-апа добавления производителя
		new Manufacterer_Elements().getAddButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Manufacterer_Elements().getAddEditPopUp()));
			simpleWait(2);
			
			// Выбрать производителя + проверка подтягивания страны и адреса производителя
		new Manufacterer_Elements().getManufacturerField().inputText(new Manufacterer_Elements().new Values().manufactererName);
			simpleWait(2);
		new Manufacterer_Elements().getAutocompletedManufacturer().click();
			simpleWait(2);
			assertThat(new Manufacterer_Elements().getManufacturerCountryField().getAttribute("value"), is(equalTo(new Manufacterer_Elements().new Values().manufactererCountry)));
			assertThat(new Manufacterer_Elements().getManufacturerAdressField().getAttribute("value"), is(equalTo(new Manufacterer_Elements().new Values().manufactererAdress)));
			
			// Сохранение производителя
		new Manufacterer_Elements().getSaveButton().click();
			simpleWait(1);
			
			// Ожидание прогрузки грида
			waitForBlockStatus(new Manufacterer_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
	public void addedManufacturer_check(){
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
					  						  new Manufacterer_Elements().new Values().manufactererName,
											  new Manufacterer_Elements().new Values().manufactererCountry,
											  new Manufacterer_Elements().new Values().manufactererAdress,
											  ""};
			
		// Определение актуальных значений
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Manufacterer_Elements().getManufacturerGridBody());
			
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
		//________________________________________________________________________________________________________________________________//
		
		//___________________________________________________ Действующее вещество _______________________________________________________//
		
	public void substance_Add(){		
		// Открытие поп-апа добавления действующего вещества
		new Substance_Elements().getAddButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Substance_Elements().getAddEditPopUp()));
			simpleWait(2);
			
		// Внести действующее вещество
		new Substance_Elements().getSubstanceField().inputText(new Substance_Elements().new Values().substance);
		new Substance_Elements().getSubstanceFieldAuto().inputText(new Substance_Elements().new Values().substance1);
		new CommonActions().autoCompleteValue_Set(driver, new Substance_Elements().getSubstanceFieldAuto(), 2);
	
			
		// Сохранение действующее вещество
		new Substance_Elements().getSaveButton().click();
			simpleWait(1);
		
		// Ожидание прогрузки грида
			waitForBlockStatus(new Substance_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
	public void addedSubstance_check(){
		// Определение ожидаемых значений
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
		//________________________________________________________________________________________________________________________________//
	//__________________________________________________Вспомагательные вещества__________________________________________________________//
	public void addExcipients(){
		// Открытие поп-апа добавления вспомагающего вещества
		new excipients_Elements().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new excipients_Elements().getAddEditPopUp()));
	    simpleWait(2);
	    
	    // Внести вспомогательное вещество
	    new excipients_Elements().getExcipientsSubstanceField().inputText(new excipients_Elements().new Values().excipientsSubstance);
	    new excipients_Elements().getSearchButton().click();
	    simpleWait(2);
	 // Ожидание прогрузки поп-
		waitForBlockStatus(new excipients_Elements().getGridDownload_Div(), false);
		simpleWait(1);
		
		// Кликнуть по ячейке 'Страна'(были проблемы с мозилой)
		Actions action = new Actions(driver);
		action.click((new excipients_Elements().getTestovoeCtell())).perform();
		simpleWait(2);
		
		// Выбрать
		new excipients_Elements().chooseButton().click();
		simpleWait(2);
	    
	}
	public void addExcipients_Check(){
		// Определение ожидаемых значений
				String[][] ExpectedValues = new String [1][];
				ExpectedValues[0] = new String[] {
							  					    new excipients_Elements().new Values().excipientsSubstance,
							  						new excipients_Elements().new Values().substanceCode,
							  						new excipients_Elements().new Values().instruction,
							  						new excipients_Elements().new Values().limitContent,
							  						new excipients_Elements().new Values().routeOfAdministration,
													  ""};
					
				// Определение актуальных значений
				String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new excipients_Elements().getExcipientsSubstancesGridBody());
					
				// Проверка значений грида
				new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
		
	}
	
	
/*__________________________________________________________________________________________________________________________________________*/	
		//________________________________________________________ Документы _____________________________________________________________//
		
	public void doc_Add(){		
		// Открытие поп-апа добавления документа
		new Docs_Elements().getAddButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Docs_Elements().getAddEditPopUp()));
			simpleWait(2);
			
		// Дата
		new Docs_Elements().getDate_Field().click();
			simpleWait(1);
		    new Docs_Elements().getDate_Field().inputText(new Docs_Elements().new Values().date);
			
		// Название документа
		new Docs_Elements().getName_Field().inputText(new Docs_Elements().new Values().name);
			
		// Описание документа
		new Docs_Elements().getDescription_Field().inputText(new Docs_Elements().new Values().docDescription);
			
		// Тип документа
		new Docs_Elements().getDocType_Field().selectByVisibleText(new Docs_Elements().new Values().docType);
			
		// Добавление файл + проверка подстановки в текстовое поле
		new Docs_Elements().getFileUpload_Button().inputText(new Docs_Elements().new Values().fileWay);
			simpleWait(2);
			assertThat(new Docs_Elements().getFile_Field().getAttribute("value"), is(equalTo(new Docs_Elements().new Values().fileName)));
			
		// Ссылка на файл
		new Docs_Elements().getFileLink_Field().inputText(new Docs_Elements().new Values().fileLink);
			
		// Сохранение действующее вещество
		new Docs_Elements().getSaveButton().click();
		    simpleWait(1);
			
		// Ожидание прогрузки грида
		waitForBlockStatus(new Docs_Elements().getGridDownload_Div(), false);
			simpleWait(1);
		}
		
	public void addedDoc_check(){
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
		
	public void fileUnload_check(){
		new CustomMethods().new WorkWith_TextFiles().fileDownload_Check(new Docs_Elements().getFileDownloadButton(), "ForDocAdd.txt");
		}
		//________________________________________________________________________________________________________________________________//
		
		//___________________________________________________ Сотрудники _______________________________________________________//
		
	public void employee_Add(){		
		// Открытие поп-апа добавления действующего вещества
		new Employee_Elements().getAddButton().click();
			simpleWait(2);
			waitUntilUnblocked((new Employee_Elements().getAddEditPopUp()));
			simpleWait(2);
			
		// Внести ФИО
		new Employee_Elements().getFioField().inputText(new Employee_Elements().new Values().fio);
			
		// Внести должность
		new Employee_Elements().getPositionField().inputText(new Employee_Elements().new Values().position);
			
		// Сохранение действующее вещество
		new Employee_Elements().getSaveButton().click();
			simpleWait(1);
			
		// Ожидание прогрузки грида
		waitForBlockStatus(new Employee_Elements().getGridDownload_Div(), false);
			simpleWait(1);
	}
		
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
	public DrugPassportPage_My drug_Save(){
			new Main_Elements().getSaveButton().click();
			return new DrugPassportPage_My(driver).waitUntilAvailable();
	}
	
		//________________________________________________________________________________________________________________________________//
	
/*_______________________________ Elements _______________________________*/
	private class Main_Elements{
		// 'Страна маркетирования'
		private Select getMarketingCoutry(){
			return new Select(driver.findElement(By.id("Country_drug_identification_marketing_country_id")));
		}
		
		// 'Международная дата рождения'
		private TextInput getBirthday(){
			return new TextInput(driver, By.id("World_drug_identification_drug_birthday"));
		}
		
		// 'Заявитель'
		private TextInput getDeclarer(){
			return new TextInput(driver,By.id("Dic_declarer_LCL_FNAM"));
		}
		
		// 'Заявитель' автокомплит
		private Text getAutocompletedDeclarer(){
			return new Text(driver,By.xpath("//strong[contains(text(), '" + new Values().Declarer + "')]"));
		}
		
		// Держатель РУ
		
		private TextInput getHolder(){
			return new TextInput(driver,By.id("Dic_owner_LCL_FNAM"));
		}
		
		// 'Страна заявителя'
		private TextInput getDeclarerCountry(){
			return new TextInput(driver,By.id("Dic_declarer_CountryName"));
		}
		private TextInput getDeclarerCity(){
			return new TextInput(driver,By.id("Dic_declarer_LCL_CITY"));
		}
		// 'Адрес заявителя'
		private TextInput getDeclarerAdress(){
			return new TextInput(driver, By.id("Dic_declarer_LCL_ADR"));
		}
		
		// 'Торговое название препарата'
		private TextInput getTradeName(){
			return new TextInput(driver, By.id("Drug_registration_trade_name"));
		}
		
		// 'Форма выпуска препарата'
		private TextInput getOutputForm(){
			return new TextInput(driver, By.id("Drug_registration_form"));
		}
		
		// 'Фасовка'
		private TextInput getPacking(){
			return new TextInput(driver, By.id("Drug_registration_packing"));
		}
		
		// 'Условия отпуска'
		private TextInput getLeaveCondition(){
			return new TextInput(driver, By.id("Drug_registration_conditions"));
		}
		
		// 'Способ введения'
		private Select getInjectionWay(){
			return new Select(driver.findElement(By.id("Drug_registration_introduction_mode")));
		}
		
		// 'Вспомогательные вещества'
		private TextInput getAdditionalSubstance(){
			return new TextInput(driver, By.id("Drug_registration_excipient"));
		}
		
		// 'ATC код'
		private TextInput getAtcCode(){
			return new TextInput(driver, By.id("Drug_registration_atc_raw"));
		}
		
		// 'ATC группа'
		private TextInput getAtcGroup(){
			return new TextInput(driver, By.id("Drug_registration_cf_group"));
		}
		
		// 'Тип заявки при регистрации'
		private TextInput getApplicationType(){
			return new TextInput(driver, By.id("Country_drug_identification_application_type"));
		}
		
		// 'Дата регистрации'
		private TextInput getRegistrationDate(){
			return new TextInput(driver, By.id("Country_drug_identification_first_reg_date"));
		}
		
		// '№ РУ'
		private TextInput getRegistrationNumber(){
			return new TextInput(driver, By.id("Country_drug_identification_first_reg_number"));
		}
		
		// 'Дата окончания РУ'
		private TextInput getRegistrationEndDate(){
			return new TextInput(driver, By.id("Drug_registration_reg_date_end"));
		}
		
		// Дата начала продаж 
		private TextInput getMarketLounchDate(){
			return new TextInput(driver, By.id("Country_drug_identification_beginning_of_sales"));
		}
		
		// 'Состояние по препарату'
		private Select getDrugCondition(){
			return new Select(driver.findElement(By.id("Drug_registration_dic_drug_state_id")));
		}
		
		// '№ приказа'
		private TextInput getOrderNumber(){
			return new TextInput(driver, By.id("Drug_registration_order_number"));
		}
		
		// 'Дата предоставления документов на перерегистрацию' -> 'Запланированная'
		private TextInput getReRegPlannedDate(){
			return new TextInput(driver, By.id("planned_date_reregistration"));
		}
		
		// Дата предоставления документов на перерегистрацию -> 'Фактическая'
		private TextInput getReRegFactDate(){
			return new TextInput(driver, By.id("Drug_registration_dossier_date"));
		}
		// Показания для применеия
		private TextInput getIndicationForUSe(){
			return new TextInput(driver, By.id("Drug_registration_indications_for_use_dr"));
		}
		
		// Срок хранения
		private TextInput getShelfLife(){
			return new TextInput(driver, By.id("Drug_registration_storage_term"));
		}
		
		// Условия хранения
		
		private TextInput getStorageConditions(){
			return new TextInput(driver, By.id("Drug_registration_storage_conditions"));
		}
		
		// Кнопка 'Сохранить'
		private Button getSaveButton(){
			return new Button(driver, By.id("save_btn"));
		}
		private class Values{
			private String marketingCountry = "Катар";     								// Страна маркетирования
			private String Birthday = "01.01.2012";     								// Международная дата рождения
			private String Declarer = "Автотетст";     					                // Заявитель
			private String holder = "Автотетст";										// Держатель РУ
			private String DeclarerCountry = "Катар";     								// Страна заявителя
			private String DeclarerCity = "Доха";                                   	// Город заявителя
			private String DeclarerAdress = "вул.Кульчицького, 34";     				// Адрес заявителя
			private String DrugTradeName = "Тестовый препарат";     				    // Торговое название препарата
			private String DrugOutputForm = "Таблетки";     							// Форма выпуска препарата
			private String Packing = "5г";     											// Фасовка
			private String InjectionWay = "в ухо";     									// Способ введения 
			private String DrugLeaveCondition = "Нет";     							    // Условия отпуска
			private String AdditionalSubstance = "Вода";     			        		// Вспомогательное вещество
			private String AtcCode = "111";     										// АТС код
			private String AtcGroup = "Тестовая";     									// АТС группа
			private String ApplicationType = "Тестовый";     				    		// Тип заявки при регистрации
			private String RegistrationDate = "02.01.2012";     	    			    // Дата регистрации
			private String RegistrationNumber = "222";     							    // № РУ
			private String RegistrationEndDate = "01.01.2014";     					    // Дата окончания регистрации
			private String DrugCondition = "в стадии разработки";     				    // Состояние по препарату
			private String OrderNumber = "333";     							    	// № приказа		
			private String ReRegPlannedDate = "01.01.2013";     						// Запланированная дата предоставления документов на перерегистрацию	
			private String IndicationForUSe="Без показаний";                            // Показаниия для применения 
			private String ReRegFactDate= "02.01.2013";									// Фактическая дата предоставления документов на перерегистрацию 
		    private String marketLounchDate="02.02.2012";								// Дата начала продаж
		    private String shelfLife="36 месяцев";										// Срок годности 
		    private String storageConditions="в прохладном темном месте";  				// Условия хранения 
				
			
		}
	private class CountriesPopUp{
			
		private TextInput getCountryName(){
			return new TextInput(driver, By.id("_VW_ISO_COUNTRIES-dictionary-txttext"));
		}
			
		private Button getCountrySearchButton(){
			return new Button(driver, By.id("_VW_ISO_COUNTRIES-dictionary-Search"));
		}
			
		// "Завантаження"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load__VW_ISO_COUNTRIES-dictionary-tree"));
		}
			
		private WebElement getQatarCell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='_VW_ISO_COUNTRIES-dictionary-tree_name']"));
		}
			
		private Button getCountryAcceptButton(){
			return new Button(driver, By.id("_VW_ISO_COUNTRIES-dictionary-OK"));
		}
	}
	}
	/*____________________________________________________________________________________________________________________*/	
	// Элементы блока 'МНН'
	private class Mnn_Elements {
		// Кнопка добавления
		private Button getAddButton(){
			return new Button(driver, By.xpath("//input[@onclick='AddEditMnn()']"));
		}
		// Поп-ап добавления
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}
				
		// "Завантаження"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_Mnn"));
		}
				
		// <tbody> грида
		private WebElement getMnnGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_Mnn']/tbody"));
		}
				
		// Мнн
		private TextInput getMnnField(){
			return new TextInput(driver, By.id("mnn_text"));
		}
				
		// Кнопка 'Сохранить'
		private Button getSaveButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick,'SaveMnn()')]"));
		}
				
		private class Values{
			private String addEditPopUpName = "Добавить МНН";						// Название поп-апа добавления/редактирования МНН
			private String mnn = "11122233344";	  									// МНН
		}
	}
		//________________________________________________________________________________________________________________________________//
			// Элементы блока 'Производитель препарата'
	private class Manufacterer_Elements{
		// Кнопка добавления
		private Button getAddButton(){
			return new Button(driver, By.xpath("//input[@onclick='AddEditManufacturer()']"));
		}
				
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
				
	    // Производитель препарта
		private TextInput getManufacturerField(){
			return new TextInput(driver, By.id("manufacturer"));
		}
				
		// 'Заявитель' автокомплит
		private Text getAutocompletedManufacturer(){
			return new Text(driver,By.xpath("//strong[contains(text(), '" + new Values().manufactererName + "')]"));
		}
				
		// Страна производителя
		private TextInput getManufacturerCountryField(){
			return new TextInput(driver, By.id("manufacturer_country"));
		}
				
		// Адрес производителя
		private TextInput getManufacturerAdressField(){
			return new TextInput(driver, By.id("manufacturer_address"));
		}
				
		// Кнопка 'Сохранить'
		private Button getSaveButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick,'OnSave()')]"));
		}
				
		private class Values{
			private String addEditPopUpName = "Добавить производителя препарата";   // Название поп-апа добавления/редактирования производителя
			private String manufactererName = "Производитель для препарата";	  	// Название производителя
			private String manufactererCountry = "Катар";	  						// Страна производителя
			private String manufactererAdress = "ул. Тестовая, д. 1";	  			// Адрес производителя
		}
	}
			//________________________________________________________________________________________________________________________________//
			// Элементы блока 'Действующие вещества'
	private class Substance_Elements{
		// Кнопка добавления
		private Button getAddButton(){
			return new Button(driver, By.xpath("//input[@onclick='AddEditSubstances()']"));
		}
				
		// Поп-ап добавления
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}
		
		// "Завантаження"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_Substances"));
		}
				
		// <tbody> грида
		private WebElement getSubstancesGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_Substances']/tbody"));
		}
				
		// Действующее вещество
		private TextInput getSubstanceField(){
			return new TextInput(driver, By.id("active_substance"));
		}
		// Действующее вещество автокоплит
		private TextInput getSubstanceFieldAuto(){
			return new TextInput(driver, By.id("active_substance_list_id_Name"));
		}
				
		// Кнопка 'Сохранить'
		private Button getSaveButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick,'SaveSubstances()')]"));
		}
				
		private class Values{
		    private String addEditPopUpName = "Добавить действующее вещество";		// Название поп-апа добавления/редактирования действующего вещества
		    private String substance1="тест1";                                      // Действуещее вещество автокомплит
		    private String substance = "Тест";	  									// Действующее вещество
		    
		}
	}
			//________________________________________________________________________________________________________________________________//
		
	//_________________________________________________________Элементы блока "Вспомающие вещества"___________________________________________//
	private class excipients_Elements{
		
		private Button getAddButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick,'open_exipient_names')]"));
		}
		// Поп-ап добавления
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}
		// "Завантаження"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_Substances_ex"));
		}
		// Кнопка поиска
		private Button getSearchButton(){
			return new Button(driver, By.id("ExipientNameControl_Find"));
		}
		
		// <tbody> грида
		private WebElement getExcipientsSubstancesGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_Substances_ex']/tbody"));
		}
		// поле ввода вспомогательного вещества
		private TextInput getExcipientsSubstanceField(){
			return new TextInput(driver, By.id("ExipientNameControl_substance_name"));
		}
		// выбор вспомогателного вещества 
		private WebElement getTestovoeCtell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_ExipientNames_substance_name']"));
		}
		// кнопка "Выбор"
		private Button chooseButton(){
			return new Button(driver, By.id("ExipientNameControl_Choose"));
		}
		
		private class Values{
			private String addEditPopUpName = "Вспомогательные вещества";             // Название поп-апа
			private String excipientsSubstance= "Тестовое";                           // Вспомогательное вещество
			private String substanceCode="а312";									  // код вещества
			private String instruction="без инструкции";							  // Инструкция для мед. применения
			private String limitContent="99";										// предельное содержание
			private String	routeOfAdministration="Обычный";                        // путь введения
		}
		
	}
	
	
	//________________________________________________________________________________________________________________________________________//
	
	// Элементы блока 'Документы'
	private class Docs_Elements{
		// Кнопка добавления
		private Button getAddButton(){
			return new Button(driver, By.xpath("//input[@onclick='AddEditFile()']"));
		}
					
		// Поп-ап добавления
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}
					
		// "Завантаження"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_file_load"));
		}
					
		// <tbody> грида
		private WebElement getDocsGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_file_load']/tbody"));
		}
					
		// Дата
		private TextInput getDate_Field(){
			return new TextInput(driver, By.id("Date"));
		}
					
		// Название документа
		private TextInput getName_Field(){
			return new TextInput(driver, By.id("Title"));
		}
					
		// Описание документа
		private TextInput getDescription_Field(){
			return new TextInput(driver, By.id("Description"));
		}
					
		// Описание документа
		private Select getDocType_Field(){
			return new Select(driver.findElement(By.id("TypeId")));
		}
					
		// Файл
		private TextInput getFile_Field(){
			return new TextInput(driver, By.id("FileName"));
		}
					
		private TextInput getFileUpload_Button(){
				return new TextInput(driver, By.id("file_source"));
		}
					
		// Ссылка на файл
		private TextInput getFileLink_Field(){
			return new TextInput(driver, By.id("FileLink"));
		}
					
		// Кнопка 'Сохранить'
		private Button getSaveButton(){
			return new Button(driver, By.id("save_file_btn"));
		}
					
		// Кнопка выгрузки файла
		private Button getFileDownloadButton(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_load']/input"));
		}
					
		private class Values{
			private String addEditPopUpName = "Добавление документа";				// Название поп-апа добавления/редактирования документа
			private String date = "05.01.2012";	  									// Дата
			private String name = "Фай";						     				// Название документа
			private String docDescription = "Тестовое";						    	// Описание документа
			private String docType = "Инструкция";						     		// Инструкция
			private String fileWay = "D:\\DSBase\\Files for testing\\ForDocAdd.txt";	// Ссылка на файл(реальная)
			private String fileName = "ForDocAdd.txt";								// Название файла
			private String fileLink = "www.getFile.com/get";			     		// Ссылка на файл 
		}
	}
		// Элементы блока 'Сотрудники'
	private class Employee_Elements{
		// Кнопка добавления
		private Button getAddButton(){
		return new Button(driver, By.xpath("//input[@onclick='AddEditPerson()']"));
		}
					
		// Поп-ап добавления
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}
					
		// "Завантаження"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_staff"));
		}
					
		// <tbody> грида
		private WebElement getEmployeeGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_staff']/tbody"));
		}
					
		// ФИО
		private TextInput getFioField(){
			return new TextInput(driver, By.id("full_name"));
		}
					
		// Сфера ответственности
		private TextInput getPositionField(){
			return new TextInput(driver, By.id("responsibilities"));
		}
					
		// Кнопка 'Сохранить'
		private Button getSaveButton(){
			return new Button(driver, By.xpath("//input[contains(@onclick,'SavePerson()')]"));
		}
		private class Values{
			private String addEditPopUpName = "Добавить сотрудников, которые ведут ЛС";		// Название поп-апа добавления/редактирования сотрудника
			private String fio = "Автоматичний Петро Васильович";	  						// ФИО
			private String position = "Начальникэ";						     				// Сфера ответственности
		}
	}
				//________________________________________________________________________________________________________________________________//

}

