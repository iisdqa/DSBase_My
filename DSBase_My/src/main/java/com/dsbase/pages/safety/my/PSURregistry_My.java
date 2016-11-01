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
		// ������� ���������
		new PSURregistry().getSearchAccordion().click();
		simpleWait(2);
		new PSURregistry().getFiltrationValue().selectByVisibleText("��������");
		new PSURregistry().getFiltrationValue_Input().inputText(new Grid_Values().title);
		new PSURregistry().getSearch_Button().click();
	}
	public void FoundPSUR_Check(){
		// ����������� ���������� � ����������
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
		
		
		// ����������� ������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0]=new String []{"1","","","","",title,reportingPeriodSartDate,reportingPeriodEndDate,reportCreationDate,requiredDate,
						actualDate,submissionDate,nextStartDate,nextEndDate,nextReportSubmitionDate,"����","�������� ��������, ��������, 02.01.2012, 222","ru",""};
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods(). new Grid().GetAllRows(getGridBody());
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void DocumentsGrid_Check(){
		// �������� �� ������ '�������� ���������'
		Actions action = new Actions(driver);
		action.click(getPSURnameCell()).perform();
		simpleWait(2);
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
										 new Docs_Elements().new Values().date,
										 new Docs_Elements().new Values().name,
										 new Docs_Elements().new Values().docDescription,
									     new Docs_Elements().new Values().docType,
										 new Docs_Elements().new Values().fileLink,
										 "",
										 ""};
					
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Docs_Elements().getDocsGridBody());
					
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void fileUnload_check(){
		new CustomMethods().new WorkWith_TextFiles().fileDownload_Check(new Docs_Elements().getFileDownloadButton(), new Docs_Elements().new Values().fileName);
	}
	public void File_Delete(){
		// �������� ���-��� �������� '���������'
		new FileDeletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new FileDeletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
			
		// ������������� �������� ���������
		new FileDeletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
		//
		waitForBlockStatus(new Docs_Elements().getGridDownload_Div(), false);
	}
	public void PSUR_Delete(){
	// �������� ���-��� �������� '���������'
	new PSURDeletion_Elements().getDelete_Button().click();
	simpleWait(2);
	waitUntilUnblocked((new PSURDeletion_Elements().getDeletion_PopUp()));
	simpleWait(2);
	// ������������� �������� ���������
	new PSURDeletion_Elements().getDeletionYes_Button().click();
	simpleWait(2);
	//
	waitForBlockStatus(new PSURregistry().getGridDownload_Div(), false);
	}
	
	
	//_______________________________________________Elements____________________________________________________________//
	// ������ ����������
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, '������� ����� ������')]"));
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
		private String title = "AutoTestPSUR";     // �������� "�����"
		private String reportingPeriodSartDate = new CustomMethods().getCurrentDate(); 		// ���� ������ ��������� �������
		private String reportingPeriodEndDate = new CustomMethods().getChangedDate(4);		// ���� ��������� ��������� �������
		private String reportCreationDate = new CustomMethods().getCurrentDate(); 		    // ���� ������������ ������
		private String requiredDate = new CustomMethods().getCurrentDate();					// ����������� ���� �������������� ������ � ������������ �����
		private String actualDate = new CustomMethods().getChangedDate(1);					// ����������� ���� �������������� ������ � ������������ �����
		private String submissionDate = new CustomMethods().getChangedDate(5);				// ���� ������ ������ � ������� ���������� �� ���������������:
		private String nextStartDate = new CustomMethods().getChangedDate(5);				// ���� ������ ���������� ��������� �������
		private String nextEndDate = new CustomMethods().getChangedDate(7);					// ���� ��������� ���������� ��������� �������
		private String nextReportSubmitionDate = new CustomMethods().getChangedDate(8);		// ����������� ���� �������������� ���������� ������:
	}
	// �������� ����� '���������'
	private class Docs_Elements{	
		// <tbody> �����
		private WebElement getDocsGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_file_load']/tbody"));
		}
		// "������������"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_file_load"));
		}
		// ������ �������� �����
		private Button getFileDownloadButton(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_load']/input"));
		}
		private class Values{
			private String fileName = "ForDocAdd.txt";								// �������� �����
			private String date = new CustomMethods().getCurrentDate(); 	 		// ����
			private String name = "����";						     				// �������� ���������
			private String docDescription = "��������";						    	// �������� ���������
			private String docType = "����������";						     		// ����������
			private String fileLink = "www.getFile.com/get";			     		// ������ �� ���� 
		}
	}
	private class FileDeletion_PopUp{
		// ������ ��������
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_del']/input"));
		}
		// ���-�� ��������
		private Custom getDeletion_PopUp(){
			return new Custom(driver, By.id("attention_delete"));
		}
		// ������ '��'
		private Button getDeletionYes_Button(){
			return new Button(driver, By.xpath("//span[text() = '��']"));
		}
	}
	private class PSURDeletion_Elements{
		// ������ ��������
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_search_del']/input"));
		}
		// ���-�� ��������
		private Custom getDeletion_PopUp(){
			return new Custom(driver, By.id("attention_delete"));
		}
		// ������ '��'
		private Button getDeletionYes_Button(){
			return new Button(driver, By.xpath("//span[text() = '��']"));
		}
	}

}
