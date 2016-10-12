package com.dsbase.pages.events.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.TextInput;




public class EventsRegistry_My extends WebPage<EventsRegistry_My>{
	private static final String PAGE_URL = BASE_URL + "/Events";
	public EventsRegistry_My(WebDriver driver){
		super (driver);
	}
	@Override
	public EventsRegistry_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable(){
		return getAdd_Button().isAvailable();
	}
	//_______________________________________________Actions_____________________________________________________________//
	public AddEvent_My clickAddNewEventButton(){
		getAdd_Button().click();
		return new AddEvent_My(driver).waitUntilAvailable();
	}
	public void SearchEvent(){
		// Открыть аккордеон
		new EventsFiltration_elements().getSearchAccordion().click();
		simpleWait(2);
		// Указать название и найти мероприятие
		new EventsFiltration_elements().getFiltrationValue().selectByVisibleText("Краткое название");
		new EventsFiltration_elements().getFiltrationValue_Input().inputText(new EventsFiltration_elements().new Values().shortTitle);
		new EventsFiltration_elements().getSearch_Button().click();
		simpleWait(2);
		waitForBlockStatus(new EventsFiltration_elements().getGridDownload_Div(), false);
	}
	public void SearchEvent_Check(){
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
										  "",
										  new EventsFiltration_elements().new Values().shortTitle,
										  new EventsFiltration_elements().new Values().eventType,
										  new EventsFiltration_elements().new Values().coachFullName,
										  new EventsFiltration_elements().new Values().startDate,
										  new EventsFiltration_elements().new Values().endDate,
										  new EventsFiltration_elements().new Values().employeeCategory,
										  new EventsFiltration_elements().new Values().testingDate,
										  new EventsFiltration_elements().new Values().status,
										  new EventsFiltration_elements().new Values().language,
										  ""};
		// Определение актуальных значений
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(getGridBody());
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);	
	}
	public void Event_Delete(){
		// Открытие поп-апа удаления 'Препарата'
		new Deletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
		// Подтверждение удаления прапарата
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
	}
	//_______________________________________________Elements____________________________________________________________//
	// Кнопка добавления
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, 'Создать новую запись')]"));
	}
	private WebElement getGridBody(){
		return driver.findElement(By.xpath("//table[@id='list_grid']/tbody"));
	}
	private class EventsFiltration_elements{
		
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
		private class Values{
			private String shortTitle = "cf";															// короткое название
			private String eventType = "Семинар";														// вид мероприяти
			private String coachFullName = "White Walter Hartwell";										// ФИО
			private String startDate = new CustomMethods().getChangedDate(-1);							// дата начала
			private String endDate = new CustomMethods().getChangedDate(+2);							// дата окончания
			private String employeeCategory = "Медработники, фармработники, руководители";				// категория сотрудника
			private String testingDate	= new CustomMethods().getChangedDate(+2);						// дата тестирования
			private String status = "Действующий";														// Статус 
			private String language = "ru";																// язык
		}
	}
	private class Deletion_PopUp{
		// Кнопка удаления
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//input[@title='Удаление']"));
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
