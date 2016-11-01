package com.dsbase.pages.events.my;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.CheckBox;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Link;
import com.dsbase.core.web.elements.TextInput;


public class AddEvent_My extends WebPage<AddEvent_My> {
	private static final String PAGE_URL = BASE_URL + "/Events/0/100";
	public AddEvent_My(WebDriver driver){
		super (driver);
	}
	@Override
	public AddEvent_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable() {
		return new FirstPartEventsElements(). getFullEventTitle().isAvailable();
	}
	//________________________________________Actions_________________________________________________//
	public void FirstPartEvents_FillUp(){
		// заполнение поля "Полное название мероприятия"
		new FirstPartEventsElements().getFullEventTitle().inputText(new FirstPartEventsElements().new Values().fullEventTitle);
		// заполнение поля "Сокращенное название мероприятия"
		new FirstPartEventsElements(). getShortEventTitle().inputText(new FirstPartEventsElements(). new Values().shortEventTitle);
		// заполнение поля "Вид мероприятия"
		new FirstPartEventsElements().getEventType().selectByVisibleText(new FirstPartEventsElements().new Values().eventType);
		// заполнение поля "Статус"
		new FirstPartEventsElements().getStatus().selectByVisibleText(new FirstPartEventsElements(). new Values().status);
		// заполнение поля "Дата начала"
		new FirstPartEventsElements().getStartDate().click();
		new FirstPartEventsElements().getStartDate().inputText(new FirstPartEventsElements(). new Values().startDate);
		// заполнение поля "Дата завершения"
		new FirstPartEventsElements().getEndDate().click();
		new FirstPartEventsElements().getEndDate().inputText(new FirstPartEventsElements(). new Values().endDate);
		// заполнение поля Дата утверждения мероприятия
		new FirstPartEventsElements().getEventApprovalDate().click();
		new FirstPartEventsElements().getEventApprovalDate().inputText(new FirstPartEventsElements().new Values().eventApprovalDate);
		// заполнение поля "место проведения мероприятия"
		new FirstPartEventsElements().getEventLocation().inputText(new FirstPartEventsElements(). new Values().eventLocation);
		// переключение радиобаттона "Проведение тестирования" на "нет"
		new FirstPartEventsElements().getTestingRadioButton(2).click();
		// заполнение поля "Дата тестирования"
		new FirstPartEventsElements().getTestingDate().click();
		new FirstPartEventsElements().getTestingDate().inputText(new FirstPartEventsElements().new Values().testingDate);
		// заполнение поля "Примечание"
		new FirstPartEventsElements().getEventNotes().inputText(new FirstPartEventsElements().new Values().eventNotes);
	}
	public void PopUpParticipantsFromRegistry_FillUp(){
		// открытие поп-апа "выбор учасника из реестра сотрудников"
		new SecondPartEventsElements().getParticipants().click();
		new PopUpParticipantsFromRegistry().getParticipantsFromRegistry().click();
		new PopUpParticipantsFromRegistry().getSearchButton().waitUntilAvailable();
		// заполнение поля "Категория"
		new PopUpParticipantsFromRegistry().getCategory().selectByVisibleText(new PopUpParticipantsFromRegistry().new ValuesFromStaffRegistry().category);
		// заполнение поля "направление"
		new PopUpParticipantsFromRegistry().getActivityArea().selectByVisibleText(new PopUpParticipantsFromRegistry().new ValuesFromStaffRegistry().activityArea);
		// нажимаем на кнопку найти
		new PopUpParticipantsFromRegistry().getSearchButton().click();
		simpleWait(2);
		waitForBlockStatus(new PopUpParticipantsFromRegistry().getGridDownload_Div(), false);
		// выбираем сотрудника
		new PopUpParticipantsFromRegistry().getSelectStaff().click();
		simpleWait(2);
		// добавляем сотрудника в грид "Учасники"
		new PopUpParticipantsFromRegistry().getChooseStaff().click();
	}
	public void PopUpNewParticipants_FillUp(){
		// открытие поп-апа "Добавление нового сотрудника"
		waitWhileClickable(new SecondPartEventsElements().getParticipants());
		new SecondPartEventsElements().getParticipants().click();
		new PopUpNewParticipants().getNewParticipants().click();
		new PopUpNewParticipants().getSaveNewParticipantButton().waitUntilAvailable();
		// заполнение поля "Фамилия"
		new PopUpNewParticipants().getSurname().inputText(new PopUpNewParticipants().new ValuesNewParticipants().surname);
		// заполнение поля "Имя"
		new PopUpNewParticipants().getName().inputText(new PopUpNewParticipants().new ValuesNewParticipants().name);
		// заполнение поля "Отчество"
		new PopUpNewParticipants().getPatronymic().inputText(new PopUpNewParticipants().new ValuesNewParticipants().patronymic);
		// заполнение поля "Должность"
		new PopUpNewParticipants().getPosition().inputText(new PopUpNewParticipants().new ValuesNewParticipants().position);
		// заполнение поля "Категория сотрудника"
		new PopUpNewParticipants().getEmployeeCategory().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().category);
		// заполнение поля "Направление"
		new PopUpNewParticipants().getActivityArea().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().activityArea);
		// заполнение поля "Подразделение"
		new PopUpNewParticipants().getDepartment().inputText(new PopUpNewParticipants().new ValuesNewParticipants().department);
		// заполнение поля "Регион"
		new PopUpNewParticipants().getRegion().inputText(new PopUpNewParticipants().new ValuesNewParticipants().region);
		// заполнение поля "город"
		new PopUpNewParticipants().getCity().inputText(new PopUpNewParticipants().new ValuesNewParticipants().city);
		// заполнение поля "Признак тренера"
		new PopUpNewParticipants().getCoachSign().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().coachSign);
		// заполнение поля "Результат обучения"
		new PopUpNewParticipants().getTrainingResult().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().trainingResult);
		// заполнение поля "Результат обучения"(текствое поле)
		new PopUpNewParticipants().getTrainingResultText().inputText(new PopUpNewParticipants().new ValuesNewParticipants().trainingResultText);
		// заполнение поля "Примечание"
		new PopUpNewParticipants().getNote().inputText(new PopUpNewParticipants().new ValuesNewParticipants().note);
		// нажимаем кнопку "сохранить"
		new PopUpNewParticipants().getSaveNewParticipantButton().click();
		simpleWait(2);
		waitForBlockStatus(new SecondPartEventsElements().getGridDownload_Div() , false);
	}
	public void SecondPartEvents_Check(){
		
		// Определение ожидаемых значений
				String[][] ExpectedValues = new String [2][];
				ExpectedValues[0] = new String[] {"",
					new PopUpNewParticipants().new ValuesNewParticipants().surname,
					new PopUpNewParticipants().new ValuesNewParticipants().name,
					new PopUpNewParticipants().new ValuesNewParticipants().patronymic,
					new PopUpNewParticipants().new ValuesNewParticipants().coachSign,
					new PopUpNewParticipants().new ValuesNewParticipants().trainingResult,
					new PopUpNewParticipants().new ValuesNewParticipants().trainingResultText,
					new PopUpNewParticipants().new ValuesNewParticipants().position,
					new PopUpNewParticipants().new ValuesNewParticipants().category,
					new PopUpNewParticipants().new ValuesNewParticipants().activityArea,
					new PopUpNewParticipants().new ValuesNewParticipants().department,
					new PopUpNewParticipants().new ValuesNewParticipants().region,
					new PopUpNewParticipants().new ValuesNewParticipants().city,
					new PopUpNewParticipants().new ValuesNewParticipants().note,
					""};
				ExpectedValues[1] = new String[] {"",
					"Пинкмэн",
					"Джеси",
					"Брюсович",
					" ",
					" ",
					" ",
					"Senior assistant",
					"Медработники, фармработники, руководители",
					"комбинированное",
					"Administration",
					" ",
					" ",
					" ",
					""	
				};
		// Определение актуальных значений
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new SecondPartEventsElements().getGridBody());
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);	
	}
	public void saveEvent(){
		getSaveButton().click();
		simpleWait(2);
		waitForBlockStatus(new SecondPartEventsElements().getGridDownload_Div() , false);
	}
	
	
	//________________________________________Elements________________________________________________//
	private Button getSaveButton(){																		// кнопка Сохранения
		return new Button(driver, By.id("save_btn"));
	}
	private class FirstPartEventsElements{
		private TextInput getFullEventTitle(){															// Полное название мероприятия
			return new TextInput(driver, By.id("Tab0_FullName"));			
		}
		private TextInput getShortEventTitle(){															// Короткое название мероприятия
			return new TextInput(driver, By.id("Tab0_ShortName"));			
		}
		private Select getEventType(){																	// Тип мероприятия 
			return new Select(driver.findElement(By.id("Tab0_EventType")));
		}
		private Select getStatus(){																		// Статус
			return new Select(driver.findElement(By.id("Tab0_Status")));
		}
		private TextInput getStartDate(){																// Дата начала
			return new TextInput(driver, By.id("Tab0_DateBegin"));			
		}
		private TextInput getEndDate(){																	// Дата окончания
			return new TextInput(driver, By.id("Tab0_DateEnd"));			
		}
		private TextInput getEventApprovalDate(){														// Дата утверждения мероприятия
			return new TextInput(driver, By.id("Tab0_DateConfirm"));	
		}
		private TextInput getEventLocation(){															// Место проведения мероприятия
			return new TextInput(driver, By.id("Tab0_PlaceName"));
		}
		private Custom getTestingRadioButton(int buttonNum){											// buttonNum - 1 или 2 Проведение тестирования(radioButton)
			return new Custom(driver, By.xpath("//input[@id='Tab0_IsTestedMap']["+buttonNum +"]"));
		}										
		private TextInput getTestingDate(){																// Дата тестирования 
			return new TextInput(driver, By.id("Tab0_DateTest"));			
		}
		private TextInput getEventNotes(){																// Примечание
			return new TextInput(driver, By.id("Tab0_Note"));
		}
		private class Values{
			private String fullEventTitle = "chicken fest";												// полное название мероприятия
			private String shortEventTitle = "cf";														// короткое название мероприятия 
			private String eventType = "Семинар";														// тип мероприятия 
			private String status = "Действующий";														// статус 
			private String startDate = new CustomMethods().getChangedDate(-1);							// дата начала 
			private String endDate = new CustomMethods().getChangedDate(+2);							// дата окончания
			private String eventApprovalDate = new CustomMethods().getChangedDate(+1);                  // Дата утверждения мероприятия
			private String eventLocation = "Альбукерке, штат Нью Мехико";								// Место проведения мероприятия
			private String testingDate = new CustomMethods().getChangedDate(+2);						// Дата тестирования
			private String eventNotes = "without comments";												// Примечание
		
		}
	}
	private class SecondPartEventsElements{
		private Button getParticipants(){ 																// кнопка учасники
			return new Button(driver, By.id("OpenListOfButton"));
		}
		private Custom getGridDownload_Div(){															// прогрузка грида "Учасники"
			return new Custom(driver, By.id("load_list_tab_0_2"));
		}
		private WebElement getGridBody(){																// тело грида
			return driver.findElement(By.xpath("//table[@id='list_tab_0_2']/tbody"));
		}
	}
		// выбор учасников из реестра сотрудников
	private class PopUpParticipantsFromRegistry{
		private Link getParticipantsFromRegistry(){														// кнопка выбор участников из реестра сотрудников 
			return new Link(driver, By.xpath("//p[@onclick='OpenChooseRangeStaff()']"));
		}
		private Select getCategory (){																	// выбор категории
			return new Select(driver.findElement(By.id("CategoryId")));
		}
		private Select getActivityArea(){																// выбор направления
			return new Select(driver.findElement(By.id("DirectionId")));
		}
		private Button getSearchButton(){																// кнопка поиска в поп-апе
			return new Button(driver, By.id("StaffNameControl_Find"));
		}
		private Custom getGridDownload_Div(){															// прогрузка грида сотрудники
			return new Custom(driver, By.id("load_list_staffnames"));
		}
		private CheckBox getSelectStaff(){																// чекбокс выбора сотрудника
			return new CheckBox(driver, By.id("isSelect_1"));
		}
		private Button getChooseStaff(){																// кнопка "Выбрать"
			return new Button(driver, By.id("StaffNameControl_Choose"));
		}
		private class ValuesFromStaffRegistry{
			private String category = "Медработники, фармработники, руководители";						// категория
			private String activityArea = "комбинированное";											// Направление
				
			}
		}
	// добавление нового сотрудника
	private class PopUpNewParticipants{
		private Button getSaveNewParticipantButton(){
			return new Button(driver, By.id("save_dialog_btn")); 										// кнопка сохранить "нового сотрудника"
		}
		private Link getNewParticipants(){																// кнопка добавление нового учасника
			return new Link(driver, By.xpath("//p[@onclick='OpenRecord0_2()']"));
		}
		private TextInput getSurname(){																	// поле "Фамилия"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberSurName"));
		}
		private TextInput getName(){																	// поле "Имя"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberName"));
		}
		private TextInput getPatronymic(){																// поле "Отчество"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberMiddleName"));
		}
		private TextInput getPosition(){																// поле "Должность"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberPost"));
		}
		private Select getEmployeeCategory(){															// поле категория сотрудника 
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberCategoryId")));
		}
		private Select getActivityArea(){																// поле "Направление"
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberDirectionId")));
		}
		private TextInput getDepartment(){																// поле "подразделение"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberDepartment"));
		}
		private TextInput getRegion(){																	// поле "Регион"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberRegion"));
		}
		private TextInput getCity(){																	// поле "Город"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberCity"));
		}
		private Select getCoachSign(){																	// поле "Признак тренера"
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberTrainerId")));
		}
		private Select getTrainingResult(){																// поле "Результат обучения"
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberResultStudyId")));
		}
		private TextInput getTrainingResultText(){														// текстовое поле "Результат обучения"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberResultStudy"));
		}
		private TextInput getNote(){																	// поле "Примечание"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberNote"));
		}
		private class ValuesNewParticipants{
			private String surname = "White";															// фамилия  
			private String name = "Walter";																// имя 
			private String patronymic = "Hartwell";														// отчество
			private String position = "Учитель химии";													// должность 
			private String category = "Медработники, фармработники, руководители";						// категория 
			private String activityArea = "комбинированное";											// направление
			private String department = "Administration";												// подразделение
			private String region = "штат Нью Мехико";										   			// Регион
			private String city = "Альбукерке";															// город
			private String coachSign = "Тренер";														// Признак тренера
			private String trainingResult = "Засчитано";												// результат обучения
			private String trainingResultText = "зачет";												// результат обучения(текстовое поле)
			private String note = "without notes";														// примечание
		}
	}
}
	
	


