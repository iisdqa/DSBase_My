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
import com.dsbase.core.web.CustomMethods.Grid;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Text;
import com.dsbase.core.web.elements.TextInput;
import com.dsbase.core.web.pages.my.LogInPage_My;





public class DrugRegistryPage_My extends WebPage<DrugRegistryPage_My>{
    private static final String PAGE_URL = BASE_URL+ "/Drugs/List"; // ����� ������, ����� ��� ������� ��������

    /*_______________________________ Core _______________________________*/
	public DrugRegistryPage_My(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public boolean isAvailable(){
		return getExcelButton().isAvailable(); // �������, ������� ��������� ��� �������� ��������(�.�. ����� ������)
	}
		
	@Override
	public DrugRegistryPage_My load() {
		// TODO Auto-generated method stub
		driver.get(PAGE_URL);
		return null;
	} 
	/*_______________________________ Actions _______________________________*/
	
	public void userNameCheck(String expectedUserName){
		// ����� ������� ��� ������������..
		String actualUserName = getUserName().getText();
		
		// �������� ��������� ���������� �������� � ��������� ��������
		assertThat(actualUserName, is(equalTo(expectedUserName)));
	}
	public void WaitForPageReady(){
		// �������� ��������� �����
		waitForBlockStatus(new filtration_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}
	public void drug_Search(){
		// ������� ���������
		new filtration_Elements().getSearch_Accordion().click();
		simpleWait(2);
		
		// ������� �������� � ����� ��������
		new filtration_Elements().getFiltrationValue_Input().inputText("�������� ��������");
		new filtration_Elements().getSearch_Button().click();
		simpleWait(2);
		
		waitForBlockStatus(new filtration_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}
	public void foundDrug_Check(){
		// ����������� ���������� � ����������
		String drugTradeName = new Grid_Values().drugTradeName;
		String drugOutputForm = new Grid_Values().drugOutputForm;
		String packing = new Grid_Values().packing;
		String mnn = new Grid_Values().mnn;
		String editedActiveSubstance = new Grid_Values().editedActiveSubstance;
		String atcCode = new Grid_Values().atcCode;
		String atcGroup = new Grid_Values().atcGroup;
		String manufactererName = new Grid_Values().manufactererName;
		String manufactererCountry = new Grid_Values().manufactererCountry;
		String declarer = new Grid_Values().declarer;
		String declarerCountry = new Grid_Values().declarerCountry;
		String regDate = new Grid_Values().regDate;
		String regNum = new Grid_Values().regNum;
	    String reRegDate = new Grid_Values().reRegDate;
		String reRegNum = new Grid_Values().reRegNum;
	    String orderNum = new Grid_Values().orderNum;
		String endRuDate = new Grid_Values().endRegDate;
		String drugCondition = new Grid_Values().drugCondition;
		String language= new Grid_Values().language;
		
		
		// ����������� ������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"1", drugTradeName, drugOutputForm, packing, mnn, editedActiveSubstance, atcCode, atcGroup, manufactererName,
										  manufactererCountry, declarer, declarerCountry, regDate, regNum, reRegDate, reRegNum, orderNum, endRuDate, drugCondition, language, ""};
		
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods(). new Grid().GetAllRows(getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void foundBeforeDeletionDrug_Check(){
		// ����������� ���������� � ����������
		String drugTradeName = new Grid_Values().drugTradeName;
		String drugOutputForm = new Grid_Values().drugOutputForm;
		String packing = new Grid_Values().packing;
		String mnn = " ";
		String editedActiveSubstance = "";
		String atcCode = new Grid_Values().atcCode;
		String atcGroup = new Grid_Values().atcGroup;
		String manufactererName = "";
		String manufactererCountry = "";
		String declarer = new Grid_Values().declarer;
		String declarerCountry = new Grid_Values().declarerCountry;
		String regDate = new Grid_Values().regDate;
		String regNum = new Grid_Values().regNum;
	    String reRegDate = new Grid_Values().reRegDate;
		String reRegNum = new Grid_Values().reRegNum;
	    String orderNum = new Grid_Values().orderNum;
		String endRuDate = new Grid_Values().endRegDate;
		String drugCondition = new Grid_Values().drugCondition;
		String language= new Grid_Values().language;
		
		
		// ����������� ������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"1", drugTradeName, drugOutputForm, packing, mnn, editedActiveSubstance, atcCode, atcGroup, manufactererName,
										  manufactererCountry, declarer, declarerCountry, regDate, regNum, reRegDate, reRegNum, orderNum, endRuDate, drugCondition,language, ""};
		
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods(). new Grid().GetAllRows(getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	public void drug_Delete(){
		// �������� ���-��� �������� '���������'
		new Deletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
			
		// ������������� �������� ���������
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
		waitForBlockStatus(getGridDownload_Div(), false);
	}
	
	public void deletedDrug_check(){
		// �������� ���������� �������� � ����� '���������� ��������'
		new CustomMethods().elementExistenceCheck(getGridBody(), false);
	}
	public LogInPage_My userOut()
	{
		// ����� �� �������
		return new CommonActions().userOut(driver);
	}
	
	
	/*_______________________________ Elements _______________________________*/
	private WebElement getTopGridBody(){
		return driver.findElement(By.xpath("//table[@aria-labelledby='gbox_list_search']/thead"));
	}
	
	private WebElement getGridBody(){
		return driver.findElement(By.xpath("//table[@id='list_search']/tbody"));
	}
	private Button getExcelButton(){
		return new Button(driver, By.id("export_report_btn"));
    }
	private Text getUserName(){
		return new Text(driver, By.xpath("//*[@class='log left']/div"));
	}
	private class filtration_Elements{
		private Custom getSearch_Accordion(){
			return new Custom(driver, By.xpath("//div[@id='accordFilter']/h3"));
		}
			private Select getFiltrationName_Select(){
			return new Select(driver.findElement(By.xpath("//select[contains(@id, 'name')]")));
		}	
			private TextInput getFiltrationValue_Input(){
			return new TextInput(driver, By.xpath("//input[contains(@id, 'value')]"));
		}
		private Button getSearch_Button(){
			return new Button(driver, By.id("buttonSearch"));
		}
			private Custom getGridDownload_Div(){
				return new Custom(driver, By.id("load_list_search"));
		}
	}
	private class Grid_Values{
		private String drugTradeName = "�������� ��������";     				    // �������� �������� ���������
		private String drugOutputForm = "��������";     							// ����� ������� ���������
		private String packing = "5�";     											// �������
		private String mnn = "111222333444";     									// ���
		private String editedActiveSubstance = "��������";						    // ����������� �������� ����� ��������������
		private String atcCode = "111";	  											// ��� ���
		private String atcGroup = "��������";	  									// ��� ������
		private String manufactererName = "������������� ��� ���������";	  		// �������� �������������
		private String manufactererCountry = "�����";	  							// ������ �������������
		private String declarer = "���������";     									// ���������
		private String declarerCountry = "�����";     								// ������ ���������
		private String regDate = "02.01.2012";	  									// ���� �����������
		private String regNum = "222";	  											// ����� 1-�� ��
		private String reRegDate = " ";	  											// ���� ���������������
		private String reRegNum = " ";	  											// ����� ��
		private String orderNum = "333";	  										// ����� �������
		private String endRegDate = "01.01.2014";	  							    // ���� �������� �����������
		private String drugCondition = "� ������ ����������";	  				    // ��������� �� ���������
		private String language="ru"; 												// ����
	}
	private class Deletion_PopUp{
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
	// "������������"
	private Custom getGridDownload_Div(){
		return new Custom(driver, By.id("load_list_search"));
	}
	private WebElement getDrugName_Cell(){
			return driver.findElement(By.xpath("//td[@aria-describedby='list_search_TradeName']"));
	}
		
		
	
}
	


