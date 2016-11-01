package com.dsbase.pages.safety.my;

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








public class PSURregistry_My extends WebPage<PSURregistry_My> {
	private static final String PAGE_URL = BASE_URL + "/Reports";
	public PSURregistry_My(WebDriver driver){
		super (driver);
	}
	@Override
	public  PSURregistry_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable(){
		return getAdd_Button().isAvailable();
	}
	//_______________________________________________Actions_____________________________________________________________//
	public AddPSUR_My clickAddPSURButton(){
		simpleWait(2);
		getAdd_Button().click();
		return new AddPSUR_My(driver).waitUntilAvailable();
	}
	public void WaitForPageReady(){
		simpleWait(2);
		waitForBlockStatus(new PSURregistry().getGridDownload_Div() , false);
	}
	public void SearchPSUR(){
		// Открыть аккордеон
		new PSURregistry().getSearchAccordion().click();
		simpleWait(2);
		new PSURregistry().getFiltrationValue().selectByVisibleText("Название");
		new PSURregistry().getFiltrationValue_Input().inputText(new Grid_Values().title);
		new PSURregistry().getSearch_Button().click();
	}
	public void FoundPSUR_Check(){
		// Определение переменных с значениями
		String title = new Grid_Values().title;
		String reportingPeriodSartDate = new Grid_Values().reportingPeriodSartDate;
		String reportingPeriodEndDate = new Grid_Values().reportingPeriodEndDate;
		String reportCreationDate = new Grid_Values().reportCreationDate;
		String requiredDate = new Grid_Values().requiredDate;
		String actualDate = new Grid_Values().actualDate;
		String submissionDate = new Grid_Values().submissionDate;
		String nextStartDate = new Grid_Values().nextStartDate;
		String nextEndDate = new Grid_Values().nextEndDate;
		String nextReportSubmitionDate = new Grid_Values().nextReportSubmitionDate;
		
		
		// Определение массива ожидаемых значений
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0]=new String []{"1","","","","",title,reportingPeriodSartDate,reportingPeriodEndDate,reportCreationDate,requiredDate,
						actualDate,submissionDate,nextStartDate,nextEndDate,nextReportSubmitionDate,"Файл","Тестовый препарат, Таблетки, 02.01.2012, 222","ru",""};
		// Вытянуть значения из грида
		String[][] ActualValues = new CustomMethods(). new Grid().GetAllRows(getGridBody());
		// Проверка значений грида
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void DocumentsGrid_Check(){
		// Кликнуть по ячейке 'Название препарата'
		Actions action = new Actions(driver);
		action.click(getPSURnameCell()).perform();
		simpleWait(2);
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
		new CustomMethods().new WorkWith_TextFiles().fileDownload_Check(new Docs_Elements().getFileDownloadButton(), new Docs_Elements().new Values().fileName);
	}
	public void File_Delete(){
		// Открытие поп-апа удаления 'Препарата'
		new FileDeletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new FileDeletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
			
		// Подтверждение удаления прапарата
		new FileDeletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
		//
		waitForBlockStatus(new Docs_Elements().getGridDownload_Div(), false);
	}
	public void PSUR_Delete(){
	// Открытие поп-апа удаления 'Препарата'
	new PSURDeletion_Elements().getDelete_Button().click();
	simpleWait(2);
	waitUntilUnblocked((new PSURDeletion_Elements().getDeletion_PopUp()));
	simpleWait(2);
	// Подтверждение удаления прапарата
	new PSURDeletion_Elements().getDeletionYes_Button().click();
	simpleWait(2);
	//
	waitForBlockStatus(new PSURregistry().getGridDownload_Div(), false);
	}
	
	
	//_______________________________________________Elements____________________________________________________________//
	// Кнопка добавления
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, 'Создать новую запись')]"));
	}
	private WebElement getPSURnameCell(){
		return driver.findElement(By.xpath("//td[@title='AutoTestPSUR']"));
	}
	private WebElement getGridBody(){
		return driver.findElement(By.xpath("//table[@id='list_search']/tbody"));
	}
	private class PSURregistry{
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_search"));	
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
		private String title = "AutoTestPSUR";     // название "ПСУРа"
		private String reportingPeriodSartDate = new CustomMethods().getCurrentDate(); 		// Дата начала отчетного периода
		private String reportingPeriodEndDate = new CustomMethods().getChangedDate(4);		// Дата окончания отчетного периода
		private String reportCreationDate = new CustomMethods().getCurrentDate(); 		    // Дата формирования отчета
		private String requiredDate = new CustomMethods().getCurrentDate();					// Необходимая дата предоставления отчета в регуляторный орган
		private String actualDate = new CustomMethods().getChangedDate(1);					// Фактическая дата предоставления отчета в регуляторный орган
		private String submissionDate = new CustomMethods().getChangedDate(5);				// Дата подачи отчета в составе материалов на перерегистрацию:
		private String nextStartDate = new CustomMethods().getChangedDate(5);				// Дата начала следующего отчетного периода
		private String nextEndDate = new CustomMethods().getChangedDate(7);					// Дата окончания следующего отчетного периода
		private String nextReportSubmitionDate = new CustomMethods().getChangedDate(8);		// Необходимая дата предоставления следующего отчета:
	}
	// Элементы блока 'Документы'
	private class Docs_Elements{	
		// <tbody> грида
		private WebElement getDocsGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_file_load']/tbody"));
		}
		// "Завантаження"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_file_load"));
		}
		// Кнопка выгрузки файла
		private Button getFileDownloadButton(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_load']/input"));
		}
		private class Values{
			private String fileName = "ForDocAdd.txt";								// Название файла
			private String date = new CustomMethods().getCurrentDate(); 	 		// Дата
			private String name = "Файл";						     				// Название документа
			private String docDescription = "Тестовое";						    	// Описание документа
			private String docType = "Инструкция";						     		// Инструкция
			private String fileLink = "www.getFile.com/get";			     		// Ссылка на файл 
		}
	}
	private class FileDeletion_PopUp{
		// Кнопка удаления
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_del']/input"));
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
	private class PSURDeletion_Elements{
		// Кнопка удаления
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_search_del']/input"));
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
