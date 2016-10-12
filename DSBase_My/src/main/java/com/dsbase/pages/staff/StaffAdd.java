package com.dsbase.pages.staff;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.CustomMethods.Grid;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Text;
import com.dsbase.core.web.elements.TextInput;




public class StaffAdd extends WebPage<StaffAdd> {
	private static final String PAGE_URL = BASE_URL + "/Staff/0/79";
	public StaffAdd(WebDriver driver){
		super (driver);
	}
	@Override
	public StaffAdd load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable() {
		return new FirstTabPersonalElements().getLastName().isAvailable();
	}
	//________________________________________Actions_________________________________________________//
	public void FirstTabPersonal_FillUp(){
		// фамилия сотрудника
		new FirstTabPersonalElements().getLastName().inputText(new FirstTabPersonalElements().new Values().lastName);
		// имя сотрудника
		new FirstTabPersonalElements().getFirstName().inputText(new FirstTabPersonalElements().new Values().firstName);		
		// отчество сотрудника
		new FirstTabPersonalElements().getPatronymic().inputText(new FirstTabPersonalElements().new Values().patronymic);
		// дата рождения сотрудника
		new FirstTabPersonalElements().getBirthday().click();
		simpleWait(2);
		new FirstTabPersonalElements().getBirthday().inputText(new FirstTabPersonalElements().new Values().birthday);
		// пол сотрудника
		new FirstTabPersonalElements().getSex().selectByVisibleText("мужской");
		// Идентикафиционный код
		new FirstTabPersonalElements().getIdentificationCode().inputText(new FirstTabPersonalElements().new Values().identificationNumber);
		// Место рождения
		new FirstTabPersonalElements().getPlaceOfBirth().inputText(new FirstTabPersonalElements().new Values().placeOfBirth);
		// Добавление фото сотрудника 
		new FirstTabPersonalElements().getFotoFile().inputText(new FirstTabPersonalElements().new Values().fileFotoWay);
		simpleWait(2);
		assertThat(new FirstTabPersonalElements().getFotoFileName().getAttribute("value"),is(equalTo(new FirstTabPersonalElements().new Values().fileFotoName)));
		
		// Открыть аккордеон(чтобы потом завязаться на закрытие при сохранении вкладки)
		new FirstTabPersonalElements().getAdditionData_Accordion().click();
		// кнопка сохранить
		new FirstTabPersonalElements().getSaveButton().click();
		simpleWait(2);
		// Ожидание закрытия аккордеона
		new FirstTabPersonalElements().getAccortionClosed_Condition().waitUntilAvailable();
		
	}
	public void SaveFormeStaff(){
		// кнопка сохранить
			new FirstTabPersonalElements().getSaveButton().click();

	}
	public void SecondTabAssignment_FillUp(){
		// переход на 2 вкладку
		getNumberOfTab("2").click();
		// открытие поп-апа 
		new SecondTabAssignment().getHistoryAssignmentButton().click();
		waitUntilUnblocked(new SecondTabAssignment().getAddEditPopUp());
		// заполнение поля Дата начала работы 
		new SecondTabAssignment().getStartDate().click();
		new SecondTabAssignment().getStartDate().inputText(new SecondTabAssignment().new ValuesSecondTab().setStartDate);
		// заполнение поля Приказ №
		new SecondTabAssignment().getOrderNumber().inputText(new SecondTabAssignment(). new ValuesSecondTab().setOrderNumber);
		// заполнение поля Дата приказа:
		new SecondTabAssignment().getOrderDate().click();
		new SecondTabAssignment().getOrderDate().inputText(new SecondTabAssignment().new ValuesSecondTab().setOrderDate);
		// заполнение поля "Область"
		new SecondTabAssignment().getArea().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setArea);
		// заполнение поля Подразделение
		new SecondTabAssignment().getDepartment().inputText(new SecondTabAssignment().new ValuesSecondTab().setDepartment);
		simpleWait(2);
		// выбор значения в поле Подразделение
		new SecondTabAssignment().getDepartmentAutocomplete().click();
		// заполнение поля Категория сотрудника
		new SecondTabAssignment().getCategory().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setCategory);
		// Заполнение поля направление
		new SecondTabAssignment().getActivityArea().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setActivityArea);
		// Сохраняем вторую вкладку
		new SecondTabAssignment().getSaveButtonPopUp().click();
		waitWhileClickable(new SecondTabAssignment().getHistoryAssignmentButton());
	}
	public void SecondTabAssignment_Check(){
		// Определение ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"", 
										 	new SecondTabAssignment().new ValuesSecondTab().setStartDate,
										 	new SecondTabAssignment().new ValuesSecondTab().setOrderNumber,
										 	new SecondTabAssignment().new ValuesSecondTab().setOrderDate,
										 	" ",
										 	new SecondTabAssignment().new ValuesSecondTab().setArea,
										 	" ",
										 	new SecondTabAssignment().new ValuesSecondTab().setDepartment,
										 	" ",
										 	new SecondTabAssignment().new ValuesSecondTab().setCategory,
										 	new SecondTabAssignment().new ValuesSecondTab().setActivityArea,
										 	" ",
										 	" ",
										 	" ",
										 	"Не выбрано",
										 	"Не выбрано",
										 	""
										 };
		// Определение актуальных значений
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new SecondTabAssignment().getAssignmentGridBody());
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);		
	}
	public void SecondTabAssignment_Delete(){
		// Открытие поп-апа удаления 'Препарата'
		new Deletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
					
		// Подтверждение удаления прапарата
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
				
		//

		waitForBlockStatus(new SecondTabAssignment().getGridDownload_Div(), false);
	
	}
	public void SecondTabAssignment_DeleteCheck(){
		// Проверка отсутствия значений в гриде 'История назначений на должность'
		new CustomMethods().elementExistenceCheck(new SecondTabAssignment().getAssignmentGridBody(), false);
	}
	
	//________________________________________Elements________________________________________________//
	private class FirstTabPersonalElements{
		private TextInput getLastName(){																// Фамилия сотрудника
			return new TextInput(driver, By.id("Tab0_SurName"));										
		}
		private TextInput getFirstName(){																// Имя сотрудника
			return new TextInput(driver, By.id("Tab0_FirstName"));					
		}
		private TextInput getPatronymic(){																// Отсество сотрудника
			return new TextInput(driver, By.id("Tab0_MiddleName"));
		}
		private TextInput getBirthday(){																// Дата рождения 
			return new TextInput(driver, By.id("Tab0_DateBirth"));
		}
		private Select getSex(){																		// Пол сотрудника
			return new Select(driver.findElement(By.id("Tab0_Sex")));
		}
		private TextInput getIdentificationCode(){														// Идентикафиционный код
			return new TextInput(driver, By.id("Tab0_IdentificationCode"));
		}
		private TextInput getPlaceOfBirth(){															// Место рождения
			return new TextInput(driver, By.id("Tab0_BirthPlace"));
		}
		private TextInput getFotoFile(){																// кнопка добавления фото сотрудника
			return new TextInput(driver, By.id("file_source"));
		}
		private TextInput getFotoFileName(){															// имя добавленого файла
			return new TextInput(driver, By.id("Tab0_PictureFileName"));			
		}
		private Button getSaveButton(){																	// кнопка сохранения
			return new Button(driver, By.id("save_btn"));
		}
		private Custom getAdditionData_Accordion(){
			return new Custom(driver, By.id("accordHide"));
		}
		private Custom getAccortionClosed_Condition(){
			return new Custom(driver, By.xpath("//*[@id='ui-accordion-accordHide-header-0' and contains(@class, 'ui-corner-all')]"));
		}
		
		private class Values{
			private String lastName = "Пинкмэн"; 														// фамилия 
			private String firstName = "Джеси";															// имя
			private String patronymic = "Брюсович";														// Отчество
			private String birthday = "01.01.1989";														// дата рождения
			private String identificationNumber = "9996669991";											// идентификационный код
			private String placeOfBirth = "Альбукеркеб, штат Нью Мехико"; 								// место рождения 
			private String fileFotoWay = "C:\\Users\\rudyi\\Desktop\\photo\\testcat.jpg"; 				// Ссылка на файл(реальная)
			private String fileFotoName = "testcat.jpg";												// имя файла		
		}
		
	}
	//_____________________________________________Вторая вкладка "Назачения"_______________________________________________________//
	private class SecondTabAssignment{
		// кнопка добавления истории назначений на должность
		private Custom getHistoryAssignmentButton(){
			return new Custom(driver, By.id("add_edit_tab6_1"));
		}
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_6_1"));
		}
		private WebElement getAssignmentGridBody(){
			return driver.findElement(By.xpath("//table[@id='list_tab_6_1']/tbody"));
		}										
		// Pop-up добавления
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new ValuesSecondTab().setPopUpName + "']"));
		}
		// поле дата начала работы
		private TextInput getStartDate(){
			return new TextInput(driver, By.id("Tab6_1Grid_HTADateWorkBegin"));
		}
		// номер приказа
		private TextInput getOrderNumber(){
			return new TextInput(driver, By.id("Tab6_1Grid_HTACommandNumber"));
		}
		// Дата приказа
		private TextInput getOrderDate(){
			return new TextInput(driver, By.id("Tab6_1Grid_HTACommandDate"));
		}
		// Область
		private Select getArea(){
			return new Select(driver.findElement(By.id("Tab6_1Grid_HTAArea")));
		}
		// Подразделение
		private TextInput getDepartment(){
			return new TextInput (driver,By.id("Tab6_1Grid_HTADepartment"));
		}
		// подразделение автокоплит
		private Text getDepartmentAutocomplete(){
			return new Text(driver, By.xpath("//strong[contains(text(), '" + new ValuesSecondTab().setDepartment + "')]"));
		}                                   
		//Категория сотрудника:
		private Select getCategory(){
			return new Select(driver.findElement(By.id("Tab6_1Grid_HTACategoryStaff")));
		}
		//Направление
		private Select getActivityArea(){
			return new Select(driver.findElement(By.id("Tab6_1Grid_HTADirection")));
		}
		// Кнопка сохранить(pop-up)
		private Button getSaveButtonPopUp(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		private class ValuesSecondTab{
			private String setPopUpName = "Создание новой записи";								 // Название поп-апа 
			private String setStartDate = new CustomMethods().getCurrentDate();                  // начало работы
			private String setOrderNumber = "11112222";											 // номер приказа 
			private String setOrderDate = new CustomMethods().getChangedDate(-3); 				 // дата приказа 
			private String setArea = "г. Киев";													 // область
			private String setDepartment= "Administration";										 // подразделение
			private String setCategory= "Медработники, фармработники, руководители";			 // категория			
			private String setActivityArea= "комбинированное";									 // направление
					
		}
	}
	private class Deletion_PopUp{
		// Кнопка удаления
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_tab_6_1_del']/input"));
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
	
		//_________________________________________переход по вкладкам_________________________________________// 
	private Button getNumberOfTab(String insetNum){
		return new Button(driver, By.xpath("(//div[contains(@class, 'nav_item')])["+ insetNum +"]"));
	}
	
}	
	
	


