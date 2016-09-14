package com.dsbase.pages.drugs.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Text;
import com.dsbase.core.web.elements.TextInput;
import com.dsbase.core.web.pages.my.LogInPage_My;


public class DrugChangeAddEditPage_My extends WebPage<DrugChangeAddEditPage_My> {
	private static final String PAGE_URL = BASE_URL + "/ChangesDrug/Add/";
	
	public DrugChangeAddEditPage_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public DrugChangeAddEditPage_My load(){
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return new Main_Block().new Elements().getOrderNumber_Input().isAvailable();
	}
	
	//____________________________________________________ �������� ����� ____________________________________________________________//
	public void mainPart_FillUp() {
		// � �������
		new Main_Block().new Elements().getOrderNumber_Input().inputText(new Main_Block().new Values().orderNumber);
		
		// ���� �������
		new Main_Block().new Elements().getOrderDate_Input().click();
		new Main_Block().new Elements().getOrderDate_Input().inputText(new Main_Block().new Values().orderDate);

		// ��� ���������
		new Main_Block().new Elements().getChangeType_Select().selectByVisibleText(new Main_Block().new Values().changeType);
		
		// ���� ���������
		new Main_Block().new Elements().getChangePoint_Input().inputText(new Main_Block().new Values().changePoint);
		
		// �������� �������� ���������
		new Main_Block().new Elements().getTradeName_Input().inputText(new Main_Block().new Values().tradeName);
	
		// ����� �������
		new Main_Block().new Elements().getOutForm_Input().inputText(new Main_Block().new Values().outForm);
		
		// �������
		new Main_Block().new Elements().getPacking_Input().inputText(new Main_Block().new Values().packing);
	
		// ������� �������
		new Main_Block().new Elements().getOutCondition_Input().inputText(new Main_Block().new Values().outCondition);
		
		// ��������������� ��������
		new Main_Block().new Elements().getAdditionalSubstance_Input().inputText(new Main_Block().new Values().additionalSubstance);
		
		// ��� ���
		new Main_Block().new Elements().getAtcCode_Input().inputText(new Main_Block().new Values().atcCode);
		
		// ��� ������
		new Main_Block().new Elements().getAtcGroup_Input().inputText(new Main_Block().new Values().atcGroup);
		
		// ����������
		new Main_Block().new Elements().getComment_Input().inputText(new Main_Block().new Values().comment);
	}
	public void mainPart_Edit(){
		// ���� �������
		new Main_Block().new Elements().getOrderDate_Input().click();
		new Main_Block().new Elements().getOrderDate_Input().inputText(new Main_Block().new Values().editedOrderDate);
	}
	
	// �������� ���� �����, ����� '����� �������', '���� �������', '��� ���������' � ����� '�������������'
	public void mainPart_Fields_Check(){
		// ���� ���������
		assertThat(new Main_Block().new Elements().getChangePoint_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().changePoint)));
		
		// �������� �������� ���������
		assertThat(new Main_Block().new Elements().getTradeName_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().tradeName)));
		
		// ����� �������
		assertThat(new Main_Block().new Elements().getOutForm_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().outForm)));
		
		// �������
		assertThat(new Main_Block().new Elements().getPacking_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().packing)));
	
		// ������� �������
		assertThat(new Main_Block().new Elements().getOutCondition_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().outCondition)));
		
		// ��������������� ��������
		assertThat(new Main_Block().new Elements().getAdditionalSubstance_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().additionalSubstance)));
		
		// ��� ���
		assertThat(new Main_Block().new Elements().getAtcCode_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().atcCode)));
		
		// ��� ������
		assertThat(new Main_Block().new Elements().getAtcGroup_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().atcGroup)));
		
		// ����������
		assertThat(new Main_Block().new Elements().getComment_Input().getAttribute("value"), is(equalTo(new Main_Block().new Values().comment)));
	}
	//________________________________________________________________________________________________________________________________//
	
	
	//____________________________________________________ ������������� _____________________________________________________________//
	
	public void manufacturer_Add(){		
		// �������� ���-��� ���������� �������������
		new Manufacterer_Block().getAddButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Manufacterer_Block().getAddEditPopUp()));
		simpleWait(2);
		
		// ������� ������������� + �������� ������������ ������ � ������ �������������
		new Manufacterer_Block().getManufacturerField().inputText(new Manufacterer_Block().new Values().manufactererName);
		simpleWait(2);
		new Manufacterer_Block().getAutocompletedManufacturer().click();
		simpleWait(2);
		assertThat(new Manufacterer_Block().getManufacturerNameEnField().getAttribute("value"), is(equalTo(new Manufacterer_Block().new Values().manufactererNameEn)));
		assertThat(new Manufacterer_Block().getManufacturerCountryField().getAttribute("value"), is(equalTo(new Manufacterer_Block().new Values().manufactererCountry)));
		assertThat(new Manufacterer_Block().getManufacturerAdressField().getAttribute("value"), is(equalTo(new Manufacterer_Block().new Values().manufactererAdress)));
		
		// ���������� �������������
		new Manufacterer_Block().getSaveButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Manufacterer_Block().getManufacturerGrid()));
	}
	
	public void addedManufacturer_check() {
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
				  						  new Manufacterer_Block().new Values().manufactererName,
				  						  new Manufacterer_Block().new Values().manufactererNameEn,
										  new Manufacterer_Block().new Values().manufactererCountry,
										  new Manufacterer_Block().new Values().manufactererAdress,
										  ""};
		
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Manufacterer_Block().getManufacturerGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public void manufacturer_Edit(){
		// �������� ���-��� ���������� �������������
		new Manufacterer_Block().getEditButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Manufacterer_Block().getAddEditPopUp()));
		simpleWait(2);
		
		// ���������� �������������
		new Manufacterer_Block().getSaveButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Manufacterer_Block().getManufacturerGrid()));
	}
	
	public void manufacturer_Delete(){
		// �������� ���-��� �������� '����������� ��������'
		new Manufacterer_Block().getDeleteButton().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletionPopUp()));
		simpleWait(2);
			
		// �������� �������������
		new Deletion_PopUp().getDeletionAcceptButton().click();
		simpleWait(2);
		waitForBlockStatus(new Manufacterer_Block().getGridDownload_Div(), false);
	}
	
	public void deletedManufacturer_check(){
		// �������� ���������� �������� � ����� '���������� ��������'
		new CustomMethods().elementExistenceCheck(new Manufacterer_Block().getManufacturerGridBody() , false);
	}
	//________________________________________________________________________________________________________________________________//
	
	public DrugChangesPage_My change_Save(){
		getSaveButton().click();
		return new DrugChangesPage_My(driver).waitUntilAvailable();
	}
	
	public LogInPage_My userOut(){
		// ����� �� �������
		return new CommonActions().userOut(driver);
	}
	

	//____________________________________________________ ��������__________________________________________________________________//
	// �������� ��������� �����
	private class Main_Block{
		// ��������
		private class Elements{
			// ����� �������
			private TextInput getOrderNumber_Input(){
				return new TextInput(driver, By.id("order_number"));
			}
				
		    // ���� �������
			private TextInput getOrderDate_Input(){
				return new TextInput(driver, By.id("order_date"));
			}
				
			// ��� ���������	
			private Select getChangeType_Select(){
				return new Select(driver.findElement(By.id("dic_changes_type_id")));
			}
				
			// ���� ���������
			private TextInput getChangePoint_Input(){
				return new TextInput(driver, By.id("change_essence"));
			}
				
			// �������� �������� ���������
			private TextInput getTradeName_Input(){
				return new TextInput(driver, By.id("trade_name"));
			}
				
			// ����� ������� ���������
			private TextInput getOutForm_Input(){
				return new TextInput(driver, By.id("form"));
			}
				
			// �������
			private TextInput getPacking_Input(){
				return new TextInput(driver, By.id("packing"));
			}
				
			// ������� �������
			private TextInput getOutCondition_Input(){
				return new TextInput(driver, By.id("conditions"));
			}
				
			// ��������������� ��������
			private TextInput getAdditionalSubstance_Input(){
				return new TextInput(driver, By.id("excipient"));
			}
				
			// ��� ���
			private TextInput getAtcCode_Input(){
				return new TextInput(driver, By.id("atc_raw"));
			}
				
			// ��� ������
			private TextInput getAtcGroup_Input(){
				return new TextInput(driver, By.id("cf_group"));
			}
				
			// ����������
			private TextInput getComment_Input(){
				return new TextInput(driver, By.id("comment"));
			}
		}
		// �������� ��� ���������� � ��������
		private class Values{	
			private String orderNumber = "111222";	  								// � �������
			private String orderDate = "01.01.2012";								// ���� �������
			private String editedOrderDate = "02.01.2012";						 	// ���� �������(��� ��������������)
			private String changeType = "���������������� ���������";				// ��� ���������
			private String changePoint = "��������";								// ���� ���������
			private String tradeName = "��������";									// �������� �������� ���������
			private String outForm = "��������";	  								// ����� �������
			private String packing = "���";											// �������
			private String outCondition = "��������";						    	// ������� �������
			private String additionalSubstance = "����";	  					  	// ��������������� ��������
			private String atcCode = "333";											// ��� ���
			private String atcGroup = "����";	  						    		// ��� ������
			private String comment = "�������";	  						    		// ����������
		}

	}
	//____________________________________________�������� ����� '������������� ���������'________________________________________________//
		
	private class Manufacterer_Block {
		// ������ ����������
		private Button getAddButton() {
			return new Button(driver, By.xpath("//input[@onclick='AddEditManufacturer()']"));
		}

		// ���-�� ����������
		private Custom getAddEditPopUp() {
			return new Custom(driver, By.xpath("//span[text() = '" + new Values().addEditPopUpName + "']"));
		}

		// ����
		private Custom getManufacturerGrid() {
			return new Custom(driver, By.id("list_manufacturer"));
		}

		// <tbody> �����
		private WebElement getManufacturerGridBody() {
			return driver.findElement(By.xpath("//*[@id='list_manufacturer']/tbody"));
		}

		// "������������"
		private Custom getGridDownload_Div() {
			return new Custom(driver, By.id("load_list_manufacturer"));
		}

		// ������������� ��������
		private TextInput getManufacturerField() {
			return new TextInput(driver, By.id("manufacturer"));
		}

		// '���������' �����������
		private Text getAutocompletedManufacturer() {
			return new Text(driver, By.xpath("//strong[contains(text(), '" + new Values().manufactererName + "')]"));
		}

		// ������ �������������
		private TextInput getManufacturerNameEnField() {
			return new TextInput(driver, By.id("manufacturer_en"));
		}

		// ������ �������������
		private TextInput getManufacturerCountryField() {
			return new TextInput(driver, By.id("manufacturer_country"));
		}

		// ����� �������������
		private TextInput getManufacturerAdressField() {
			return new TextInput(driver, By.id("manufacturer_address"));
		}

		// ������ '���������'
		private Button getSaveButton() {
			return new Button(driver, By.xpath("//input[contains(@onclick,'OnSave()')]"));
		}

		// ������ ��������������
		private Button getEditButton() {
			return new Button(driver, By.xpath("//td[@aria-describedby='list_manufacturer_edit']/input"));
		}

		// ������ ��������
		private Button getDeleteButton() {
			return new Button(driver, By.xpath("//td[@aria-describedby='list_manufacturer_del']/input"));
		}

		// �������� ��� ���������� � ��������
		private class Values {
			private String addEditPopUpName = "�������� ������������� ���������";      // �������� ���-��� ����������/�������������� �������������
			private String manufactererName = "������������� ��� ���������";           // �������� �������������
			private String manufactererNameEn = "For drugAdd";                         // �������� ������������� �� ����.
			private String manufactererCountry = "�����";                              // ������ �������������
			private String manufactererAdress = "��. ��������, �. 1";                  // ����� �������������
		}
	}
    //________________________________________________________________________________________________________________________________//
	// ���-�� ��������
	private class Deletion_PopUp {
		private Custom getDeletionPopUp() {
			return new Custom(driver, By.id("attention_delete"));
		}

		private Custom getDeletionAcceptButton() {
			return new Custom(driver, By.xpath("//span[text() = '��']"));
		}
	}
	// ������ '���������'
	private Button getSaveButton(){
		return new Button(driver, By.xpath("//input[contains(@onclick,'SaveChanges')]"));
	}
}
