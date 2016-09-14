package com.dsbase.pages.drugs.my;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.pages.my.LogInPage_My;


public class DrugChangesPage_My extends WebPage<DrugChangesPage_My> {
	private static final String PAGE_URL = BASE_URL + "/ChangesDrug/List/";
	
	public DrugChangesPage_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public DrugChangesPage_My load(){
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable(){
		return getAdd_Button().isAvailable();
	}
	
	// �������� ��������� ���������� ���������
	public DrugChangeAddEditPage_My changeAdd_Open(){		
		getAdd_Button().click();
		return new DrugChangeAddEditPage_My(driver).waitUntilAvailable();
	}
	
	public void addedChange_Check(){
	// �������� ��������� �����
		simpleWait(1);
		waitForBlockStatus(getGridDownload_Div(), false);
		
		// ����������� ��������� ��������
		String orderNumber = new Values().orderNumber;									// � �������
		String orderDate = new Values().orderDate;										// ���� �������
		String changeType = new Values().changeType;									// ��� ���������
		
		// ������ �������� � ������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
										  orderNumber,
										  orderDate,
										  changeType,
										  ""};
		
		// �������� ��������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	// �������� ��������� ���������� ���������
	public DrugChangeAddEditPage_My changeEdit_Open(){		
		getEdit_Button().click();
		return new DrugChangeAddEditPage_My(driver).waitUntilAvailable();
	}
	
	public void editedChange_Check(){
		// �������� ��������� �����
		simpleWait(1);
		waitForBlockStatus(getGridDownload_Div(), false);
		
		// ����������� ��������� ��������
		String orderNumber = new Values().orderNumber;									// � �������
		String orderDate = new Values().editedOrderDate;								// ���� �������
		String changeType = new Values().changeType;									// ��� ���������
		
		// ������ �������� � ������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
										  orderNumber,
										  orderDate,
										  changeType,
										  ""};
		
		// �������� ��������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public DrugPassportPage_My back_ToPassport_Page(){
		get_GoToPassport_Button().click();
		simpleWait(1);
		return new DrugPassportPage_My(driver).waitUntilAvailable();
	}
	
	public void change_Delete(){
	    getDelete_Button().click();
		simpleWait(1);
		waitUntilUnblocked(new Deletion_PopUp().getDeletionPopUp());
		new Deletion_PopUp().getDeletionAcceptButton().click();
		simpleWait(2);
		waitForBlockStatus(getGridDownload_Div(), false);
	}
	
	public void deletedChange_Check(){
		// �������� ���������� �������� � ����� '���'
		new CustomMethods().elementExistenceCheck(getGridBody() , false);
	}
	//________________________________________________________________________________________________________________________________//
	
	public LogInPage_My userOut(){
		// ����� �� �������
		return new CommonActions().userOut(driver);
	}
	
	// ������ ����������
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@onclick, 'AddRecord')]"));
	}
	
	// ���� �������
	private WebElement getGridBody(){
		return driver.findElement(By.xpath("//*[@id='list_drug_changes']/tbody"));
	}
	
	// "������������"
	private Custom getGridDownload_Div(){
		return new Custom(driver, By.id("load_list_drug_changes"));
	}
	
	// ������ ��������������
	private Button getEdit_Button(){
		return new Button(driver, By.xpath("//td[@aria-describedby='list_drug_changes_edit']/input"));
	}
	
	// ������ ��������
	private Button get_GoToPassport_Button(){
		return new Button(driver, By.id("PasportPreparata"));
	}
	
	// �������� ��� ���������� � ��������
	private class Values{		
		private String orderNumber = "111222";	  						  		// � �������
		private String orderDate = "01.01.2012";								// ���� �������
		private String editedOrderDate = "02.01.2012";							// ���� ������� ����� ��������������
		private String changeType = "���������������� ���������";				// ��� ���������
	}
	
	// ������ ��������
	private Button getDelete_Button(){
		return new Button(driver, By.xpath("//td[@aria-describedby='list_drug_changes_del']/input"));
	}
	
	// ���-�� �������� 
	private class Deletion_PopUp{
		private Custom getDeletionPopUp(){
			return new Custom(driver, By.id("attention_delete"));
		}
		
		private Custom getDeletionAcceptButton(){
			return new Custom(driver, By.xpath("//span[text() = '��']"));
		}
	}
}
