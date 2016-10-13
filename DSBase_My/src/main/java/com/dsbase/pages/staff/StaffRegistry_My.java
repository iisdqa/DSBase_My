package com.dsbase.pages.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.TextInput;




public class StaffRegistry_My extends WebPage<StaffRegistry_My> {
	private static final String PAGE_URL = BASE_URL + "/Staff";
	public StaffRegistry_My(WebDriver driver){
		super (driver);
	}
	@Override
	public StaffRegistry_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable(){
		return getAdd_Button().isAvailable();
	}
    //_______________________________________________Actions_____________________________________________________________//
	public void WaitForPageReady(){
		waitForBlockStatus(new StuffFiltration_elements().getGridDownload_Div(),false);
        simpleWait(2);	
	}
	public void SearchStaff(){
		// Открыть аккордеон
		new StuffFiltration_elements().getSearchAccordion().click();
		simpleWait(2);
		// Указать название и найти сотрудника
		new StuffFiltration_elements().getFiltrationValue().selectByVisibleText("ФИО");
		new StuffFiltration_elements().getFiltrationValue_Input().inputText("Пинкмэн Джеси Брюсович");
		new StuffFiltration_elements().getSearch_Button().click();
		simpleWait(1);
		waitForBlockStatus(new StuffFiltration_elements().getGridDownload_Div(),false);
	}
	public void SearchStaff_Check(){
		// Определение переменных с значениями
		String fullName = new Grid_Values().fullName;
		String sex= new Grid_Values().sex;
		String dateOfEmployment= new Grid_Values().dateOfEmployment;
		String dateOfDismissal= new Grid_Values().dateOfDismissal;
		String position = new Grid_Values().position;
		String region = new Grid_Values().region;
		String city = new Grid_Values().city;
		String direction = new Grid_Values().direction;
		String employeeCategory = new Grid_Values().employeeCategory;
		// Определение массива ожидаемых значений
		String[][] ExpectedValues = new String [1][]; 
		ExpectedValues[0]=new String []{"","",fullName,sex,dateOfEmployment,dateOfDismissal,position,region,city,
										direction,employeeCategory,"Тренинги","ru",""};
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods(). new Grid().GetAllRows(getGridBody());
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void Staff_Delete(){

		// Открытие поп-апа удаления 'Препарата'
		new Deletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
			
		// Подтверждение удаления прапарата
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
		
		//
		waitForBlockStatus(new StuffFiltration_elements().getGridDownload_Div(), false);
	}
	
	
	//_______________________________________________Elements____________________________________________________________//
	// Кнопка добавления
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, 'Создать новую запись')]"));
	}
	private WebElement getGridBody(){
		return driver.findElement(By.xpath("//table[@id='list_grid']/tbody"));
	}
	private class StuffFiltration_elements{
		
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_grid"));	
		}
		private Custom	getSearchAccordion(){
			return new Custom(driver, By.id("ui-accordion-accordFilter-header-0"));
		}
		private TextInput getFiltrationValue_Input(){
			return new TextInput(driver, By.xpath("//input[contains(@id,'value')]"));
		}
		private Button getSearch_Button(){
			return new Button(driver, By.id("buttonSearch"));
		}
		private Select getFiltrationValue(){
			return new Select(driver.findElement(By.xpath("//select[contains(@id,'name')]")));
		}                                                   
	}
	private class Grid_Values{
		private String fullName="Пинкмэн Джеси Брюсович";														// ФИО
		private String sex="мужской";																			// пол
		private String dateOfEmployment= new CustomMethods().getCurrentDate();									// дата принятия на роботу
		private String dateOfDismissal=" ";																		// дата увольнения 
		private String position="Senior assistant";																// дОЛжНОСТЬ
		private String region=" ";																				// Регион
		private String city=" ";																				// Город
		private String direction="комбинированное";																// Направление
		private String employeeCategory="Медработники, фармработники, руководители";							// Категория сотрудника
		
	}
	private class Deletion_PopUp{
		// Кнопка удаления
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_grid_del']/input"));
		}
		// Поп-ап удаления
		private Custom getDeletion_PopUp(){
			return new Custom(driver, By.id("attention_delete"));
		}
		// Кнопка 'Да'
		private Button getDeletionYes_Button(){
			return new Button(driver, By.xpath("//span[text() = 'Да']"));
		}
	}
}

