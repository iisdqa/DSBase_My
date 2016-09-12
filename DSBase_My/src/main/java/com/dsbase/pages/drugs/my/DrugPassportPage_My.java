package com.dsbase.pages.drugs.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.CustomMethods.Grid;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Text;




public class DrugPassportPage_My extends WebPage<DrugPassportPage_My> {
	private static final String PAGE_URL = BASE_URL + "/Drugs/View/";

	public DrugPassportPage_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public DrugPassportPage_My load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getDrugPassportButton().isAvailable();
	}

	/*================================================================ ������============================================================*/
	public void addedPassport_Check(){
		// �������� ������
		drugPassportTitle_Check();
		
		
		// �������� ����� ���
		mnnPart_check("Add");
		
		// �������� ����� �������������
		manufacturerPart_check();
		
		
		// �������� ����� '������ ��'
		drugStructurePart_check("Add");
		
		// �������� ����� '��������������� ��'
		drugReRegistrationPart_check();
		
		// �������� ����� '���������'
		drugChanges_check();
		
		// �������� ����� '���� �������������� ���������� �� ���������������' � �����������
		LastPart_check();
	
		// �������� ����� '����������'
		employeesPart_check("Add");
		
		// �������� ����� '������ ��������������'
		drugOtherCountries_check();
	}
	public DrugEditPage_My drug_Edit(){
		getDrugEdit_Button().click();
		simpleWait(2);
		return new DrugEditPage_My(driver).waitUntilAvailable();
	}
	private void drugPassportTitle_Check(){
		// ����������� ������
		String expectedTitle = "������� ���������: �����, �������� ��������, ��������, 02.01.2012, 222";
		String actualTitle = new CustomMethods().StringSpacesCut(getDrugPassport_Title().getText());
		
		// �������� ������������
		assertThat(actualTitle, is(equalTo(expectedTitle)));
	}
	public void editedPassport_Check(){
		// �������� ������
		drugPassportTitle_Check();
		
		// �������� ����� ���
		mnnPart_check("Edit");
		
		// �������� ����� �������������
		manufacturerPart_check();
		
		// �������� ����� '������ ��'
		drugStructurePart_check("Edit");
		
		// �������� ����� '��������������� ��'
		drugReRegistrationPart_check();
		
		// �������� ����� '���������'
		drugChanges_check();
		
		// �������� ����� '���� �������������� ���������� �� ���������������' � �����������
		LastPart_check();
	
		// �������� ����� '����������'
		employeesPart_check("Edit");
		
		// �������� ����� '������ ��������������'
		drugOtherCountries_check();
	}
	private void mnnPart_check(String CheckType){
		// ���������� ����������
		String Mnn = "";
		
		// ���������� �������� ���������� � ����������� �� ���� ��������
		if(CheckType.equals("Add")) Mnn = new Grids_Elements().new Mnn().new Values().Mnn;
		else if(CheckType.equals("Edit")) Mnn = new Grids_Elements().new Mnn().new Values().editedMnn;
		
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {Mnn};
		
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Mnn().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	private void manufacturerPart_check(){
		// ����������� �������� �����
		String manufacturerName = new Grids_Elements().new Manufacturer().new Values().manufactererName;
		String manufacturerCountry = new Grids_Elements().new Manufacturer().new Values().manufactererCountry;
		String manufacturerAdress = new Grids_Elements().new Manufacturer().new Values().manufactererAdress;
		
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {manufacturerName, manufacturerCountry, manufacturerAdress};
		
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Manufacturer().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	/*_________________________________________________ �������� ������������ �������� _________________________________________________*/
	private void drugStructurePart_check(String CheckType){
		// ���������� ����������
		String activeSubstance = new DrugEditPage_My(driver).new Substance_Elements().new Values().substance;
		String activeSubstanceAuto = new DrugEditPage_My(driver).new Substance_Elements().new Values().substanceAuto;
		
		// ���������� �������� ���������� � ����������� �� ���� ��������
		if(CheckType.equals("Edit")) {
			activeSubstance = new Grids_Elements().new Drug_Structure().new Values().editedActiveSubstance;
			activeSubstanceAuto = new Grids_Elements().new Drug_Structure().new Values().editedSubstanceAuto;
		}
		
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {activeSubstance,activeSubstanceAuto};
		
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Drug_Structure().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	//_________________________________________________________________________________________________________________________________//
//	/*================================================= �������� ��������� � ������� �������(���� �� ������������) ==============================================*/
//	public class For_Other_Tests
//	{
//		public class DrugChanges_Test
//		{
//			public void added_drugChanges_Check()
//			{	
//				// ����������� �������� �����
//				String orderNumber = new Values().orderNumber;
//				String orderDate = new Values().orderDate;
//				String changeType = new Values().changeType;
//				
//				// ����������� ��������� ��������
//				String[][] ExpectedValues = new String [1][];
//				ExpectedValues[0] = new String[] {"",
//												  orderNumber, 
//												  orderDate, 
//												  changeType};
//				
//				// �������� �������� �� �����
//				String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Drug_Changes().getGridBody());
//				
//				// �������� �������� �����
//				new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
//			}
//			
//			public DrugChangeAddEditPage drugChange_Edit()
//			{
//				new Grids_Elements().new Drug_Changes().getEdit_Button().click();
//				simpleWait(1);
//				return new DrugChangeAddEditPage(driver).waitUntilAvailable();
//			}
//			
//			private class Values
//			{
//				private String orderNumber = "111222";	  						  		// � �������
//				private String orderDate = "02.01.2012";								// ���� �������
//				private String changeType = "���������������� ���������";				// ��� ���������
//			}
//		}
//	}
	//________________________________________________________________________________________________________________________________//
	private void drugReRegistrationPart_check(){
		// �������� ���������� �������� � ����� '��������������� ��'
		new CustomMethods().elementExistenceCheck(new Grids_Elements().new Drug_Reregistration().getGridBody() , false);
	}
	
	private void drugChanges_check(){
		// �������� ���������� �������� � ����� '���������'
		new CustomMethods().elementExistenceCheck(new Grids_Elements().new Drug_Changes().getGridBody() , false);
	}
	
	private void LastPart_check(){
		// ����������� �������� ����� �����
		String plannedDateTitle = new LastPart_Elements().new Values().plannedDateTitle;
		String plannedDate = new LastPart_Elements().new Values().plannedDate;
		String actualDateTitle = new LastPart_Elements().new Values().actualDateTitle;
		String actualDate = new LastPart_Elements().new Values().actualDate;
		String endRuDateTitle = new LastPart_Elements().new Values().endRuDateTitle;
		String endRuDate = new LastPart_Elements().new Values().endRuDate;
		String drugConditionTitle = new LastPart_Elements().new Values().drugConditionTitle;
		String drugCondition = new LastPart_Elements().new Values().drugCondition;
		
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [4][];
		ExpectedValues[0] = new String[] {plannedDateTitle, actualDateTitle};
		ExpectedValues[1] = new String[] {plannedDate, actualDate};
		ExpectedValues[2] = new String[] {endRuDateTitle, drugConditionTitle};
		ExpectedValues[3] = new String[] {endRuDate, drugCondition};
		
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new LastPart_Elements().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	private void employeesPart_check(String CheckType){
		// ����������� �������� ����� �����
		String FIO = new Grids_Elements().new Employees().new Values().fio;
		
		// ���������� ����������
		String Position = "";
		
		// ���������� �������� ���������� � ����������� �� ���� ��������
		if(CheckType.equals("Add")) Position = new Grids_Elements().new Employees().new Values().position;
		else if(CheckType.equals("Edit")) Position = new Grids_Elements().new Employees().new Values().editedPosition;
		
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {FIO, Position};
		
		// �������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Grids_Elements().new Employees().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	private void drugOtherCountries_check(){
		// �������� ���������� �������� � ����� '���������'
		new CustomMethods().elementExistenceCheck(new Grids_Elements().new Drug_OtherCountries().getGridBody() , false);
	}
	
	/*==============================================������������ �������� � �������� � ����=============================================*/

	private Button getDrugPassportButton() {
		return new Button(driver, By.id("PasportPreparata"));
	}

	private Text getDrugPassport_Title() {
		return new Text(driver, By.xpath("//div[@class='content_page table_cell']/h1"));
	}

	private Button getDrugEdit_Button() {
		return new Button(driver, By.xpath("//input[@type='button' and contains(@onclick, 'EditFirstDrug')]"));
	}
	//__________________________________________________ �������� ������ � ������� ___________________________________________________//
	
	private class Grids_Elements{
		// ���� '���'
		private class Mnn{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_Mnn']/tbody"));
			}
			private class Values{
			    private String Mnn = "11122233344";      								// ���
			    private String editedMnn = "111222333444";								// ��� ����� ��������������
			}
		}	
			
		// ���� '�������������'
		private class Manufacturer{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_manufacturer']/tbody"));
			}
				
			private class Values{
				private String manufactererName = "������������� ��� ���������";	  	// �������� �������������
				private String manufactererCountry = "�����";	  						// ������ �������������
				private String manufactererAdress = "��. ��������, �. 1";	  			// ����� �������������
			}
		}
			
		// ���� '������ ��'
		private class Drug_Structure{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_Substances']/tbody"));
			}
			private class Values{
				private String editedSubstanceAuto = "����2";
				private String editedActiveSubstance = "��������";						     	// ����������� �������� ����� ��������������
			}
		}
		// ���� '��������������� ��'
		private class Drug_Reregistration{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_re_registering']/tbody"));
			}
		}
		// ���� '���������'
		private class Drug_Changes{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_drug_changes']/tbody"));
		}
//				private Button getEdit_Button(){
//					return new Button(driver, By.xpath("//td[@aria-describedby='list_drug_changes_edit']/input"));        // ��� �������� DrugChangeAddEditPage_My
//				}
		}
		// ���� '����������'
		private class Employees{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_staff']/tbody"));
			}
			private class Values{
				private String fio = "������������ ����� ����������";	  						// ���
				private String position = "����������";						     				// ����� ���������������
				private String editedPosition = "���������";									// ����������������� ����� ���������������
			}
		}
		// ���� '������ ��������������'
		private class Drug_OtherCountries{
			private WebElement getGridBody(){
				return driver.findElement(By.xpath("//table[@id='list_countries']/tbody"));
			}
		}
	
	}
	private class LastPart_Elements{
		private WebElement getGridBody(){
			return driver.findElement(By.xpath("(//div[@class='content_page table_cell']/div[@class='max_width1010px']/table)[4]/tbody"));
		}
			
		private class Values{
			private String plannedDateTitle = "���������������:";	  			    // �������� ���� '��������������� ����'
			private String plannedDate = "01.01.2013";	  							// �������� ���� '��������������� ����'
			private String actualDateTitle = "�����������:";	  					// �������� ���� '����������� ����'
			private String actualDate = "";	  										// �������� ���� '����������� ����'
			private String endRuDateTitle = "���� ��������� ��:";	  				// �������� ���� '���� ��������� ��'
			private String endRuDate = "01.01.2014";	  							// �������� ���� '���� ��������� ��'
			private String drugConditionTitle = "��������� �� ���������:";	  		// �������� ���� '��������� �� ���������'
			private String drugCondition = "� ������ ����������";	  				// �������� ���� '��������� �� ���������'
		}
	}
		
		
}
