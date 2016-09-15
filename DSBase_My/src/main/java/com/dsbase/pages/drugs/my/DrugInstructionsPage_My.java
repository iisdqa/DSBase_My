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
import com.dsbase.core.web.elements.TextInput;
import com.dsbase.core.web.pages.my.LogInPage_My;

public class DrugInstructionsPage_My extends WebPage<DrugInstructionsPage_My> {
	private static final String PAGE_URL = BASE_URL + "/Instructions/List/";
	
	public DrugInstructionsPage_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public DrugInstructionsPage_My load(){
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable(){
		return new Instructions_Block().getAdd_Button().isAvailable();
	}
	
	//________________________________________________________ ���������� _____________________________________________________________//
	public void instruction_Add(){		
		// �������� ���-��� ���������� �������������
		new Instructions_Block().getAdd_Button().click();
		simpleWait(1);
		waitUntilUnblocked(new Instructions_Block().new AddEdit_PopUps_Elements().getAddPopUp());
		simpleWait(1);
		
		// ���������� ����������
		new Instructions_Block().instruction_FillUp();
		
		// ���������� �������������
		new Instructions_Block().new AddEdit_PopUps_Elements().getSave_Button().click();
		simpleWait(2);
		waitForBlockStatus(new Instructions_Block().getGridDownload_Div(), false);
	}
	
	public void addedInstruction_Check(){
		// ����������� ��������� ��������
		String approvalDate = new Instructions_Block().new Values().approvalDate;								// ���� �����������
		String changeNumber = new Instructions_Block().new Values().changeNumber;								// � ���������
		String changePoint = new Instructions_Block().new Values().changePoint;									// ���� ���������
		String orderNumber = new Instructions_Block().new Values().orderNumber;									// � �������
		String orderDate = new Instructions_Block().new Values().orderDate;										// ���� �������
		
		// ������ �������� � ������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
										  approvalDate, 
										  changeNumber, 
										  changePoint, 
										  orderNumber,
										  orderDate,
										  ""};
		
		// �������� ��������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Instructions_Block().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public void instruction_Edit(){
		// �������� ���-��� �������������� �������������
		new Instructions_Block().getEdit_Button().click();
		simpleWait(1);
		waitUntilUnblocked(new Instructions_Block().new AddEdit_PopUps_Elements().getEditPopUp());
		simpleWait(1);
		
		// ��������� � �������
		new Instructions_Block().new AddEdit_PopUps_Elements().getOrderNumber().clear();
		new Instructions_Block().new AddEdit_PopUps_Elements().getOrderNumber().inputText(new Instructions_Block().new Values().orderNumber_edited);
		
		// �������� ���������� ������������ '��������� ������������'
		String ActualValue = new Instructions_Block().new AddEdit_PopUps_Elements().getChangeSecurity_Yes_RadioButton().getAttribute("checked");
		assertThat(ActualValue, is(equalTo("true")));
		
		// ���������� �������������
		new Instructions_Block().new AddEdit_PopUps_Elements().getSave_Button().click();
		simpleWait(2);
		waitForBlockStatus(new Instructions_Block().getGridDownload_Div(), false);
	}
	
	public void editedInstruction_Check(){
		// ����������� ��������� ��������
		String approvalDate = new Instructions_Block().new Values().approvalDate;								// ���� �����������
		String changeNumber = new Instructions_Block().new Values().changeNumber;								// � ���������
		String changePoint = new Instructions_Block().new Values().changePoint;									// ���� ���������
		String orderNumber = new Instructions_Block().new Values().orderNumber_edited;						    // � �������
		String orderDate = new Instructions_Block().new Values().orderDate;										// ���� �������
		
		// ������ �������� � ������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
										  approvalDate, 
										  changeNumber, 
										  changePoint, 
										  orderNumber,
										  orderDate,
										  ""};
		
		// �������� ��������� �������� �� �����
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Instructions_Block().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public void instruction_Delete(){
		new Instructions_Block().getDelete_Button().click();
		simpleWait(1);
		waitUntilUnblocked(new Deletion_PopUp().getDeletionPopUp());
		new Deletion_PopUp().getDeletionAcceptButton().click();
		simpleWait(2);
		waitForBlockStatus(new Instructions_Block().getGridDownload_Div(), false);
	}
	
	public void deletedInstruction_Check(){
		// �������� ���������� �������� � ����� '���'
		new CustomMethods().elementExistenceCheck(new Instructions_Block().getGridBody() , false);
	}
	
	public void instruction_Set(){
		simpleWait(2);
		waitForBlockStatus(new Instructions_Block().getGridDownload_Div(), false);
		
		new Instructions_Block().getChangeNumber_Cell().click();		
		simpleWait(2);
	}
	
	//________________________________________________________________________________________________________________________________//
	
	
	//________________________________________________________ ��������� _____________________________________________________________//

	public void doc_Add(){		
		// �������� ���-��� ���������� ���������
		new Docs_Block().getAddButton().click();
		simpleWait(1);
		waitUntilUnblocked((new Docs_Block().new AddEdit_PopUps_Elements().getAddPopUp()));
		simpleWait(2);
		
		// ����
		new Docs_Block().new AddEdit_PopUps_Elements().getDate_Field().click();
		simpleWait(1);
		new Docs_Block().new AddEdit_PopUps_Elements().getDate_Field().inputText(new Docs_Block().new Values().date);
		
		// �������� ���������
		new Docs_Block().new AddEdit_PopUps_Elements().getName_Field().inputText(new Docs_Block().new Values().name);
		
		// �������� ���������
		new Docs_Block().new AddEdit_PopUps_Elements().getDescription_Field().inputText(new Docs_Block().new Values().docDescription);
		
		// ��� ���������
		new Docs_Block().new AddEdit_PopUps_Elements().getDocType_Field().selectByVisibleText(new Docs_Block().new Values().docType);
		
		// ���������� ���� + �������� ����������� � ��������� ����
		new Docs_Block().new AddEdit_PopUps_Elements().getFileUpload_Button().inputText(new Docs_Block().new Values().fileWay);
		simpleWait(2);
		assertThat(new Docs_Block().new AddEdit_PopUps_Elements().getFile_Field().getAttribute("value"), is(equalTo(new Docs_Block().new Values().fileName)));
		
		// ������ �� ����
		new Docs_Block().new AddEdit_PopUps_Elements().getFileLink_Field().inputText(new Docs_Block().new Values().fileLink);
		
		// ���������� ���������
		new Docs_Block().new AddEdit_PopUps_Elements().getSaveButton().click();
		simpleWait(2);
		waitForBlockStatus(new Docs_Block().getGridDownload_Div(), false);
	}
	
	public void addedDoc_Check(){
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
				  						  new Docs_Block().new Values().date,
										  new Docs_Block().new Values().name,
										  new Docs_Block().new Values().docDescription,
										  new Docs_Block().new Values().docType,
										  new Docs_Block().new Values().fileLink,
										  "",
										  ""};
		
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Docs_Block().getDocsGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public void fileUnload_Check(){
		new CustomMethods().new WorkWith_TextFiles().fileDownload_Check(new Docs_Block().getFileDownloadButton(), "ForDocAdd.txt");
	}
	
	public void doc_Edit(){
		// �������� ���-��� ���������� ���������
		new Docs_Block().getEdit_Button().click();
		simpleWait(1);
		waitUntilUnblocked((new Docs_Block().new AddEdit_PopUps_Elements().getEditPopUp()));
		simpleWait(2);
		
		// �������� ���
		new Docs_Block().new AddEdit_PopUps_Elements().getName_Field().clear();
		simpleWait(1);
		new Docs_Block().new AddEdit_PopUps_Elements().getName_Field().inputText(new Docs_Block().new Values().editedName);
		
		// ���������� ��������
		new Docs_Block().new AddEdit_PopUps_Elements().getSaveButton().click();
		simpleWait(2);
		waitForBlockStatus(new Docs_Block().getGridDownload_Div(), false);
	}
	
	public void editedDoc_Check(){
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
				  						  new Docs_Block().new Values().date,
				  						  new Docs_Block().new Values().editedName,
				  						  new Docs_Block().new Values().docDescription,
				  						  new Docs_Block().new Values().docType,
				  						  new Docs_Block().new Values().fileLink,
				  						  "",
				  						  ""};
		
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new Docs_Block().getDocsGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public void doc_Delete(){
		// �������� ���-��� ��������
		new Docs_Block().getDelete_Button().click();
		simpleWait(1);
		waitUntilUnblocked(new Deletion_PopUp().getDeletionPopUp());
		simpleWait(2);
			
		// �������� ���������
		new Deletion_PopUp().getDeletionAcceptButton().click();
		simpleWait(2);
		waitForBlockStatus(new Docs_Block().getGridDownload_Div(), false);
	}
	
	public void deletedDoc_check(){
		// �������� ���������� �������� � ����� '���������'
		new CustomMethods().elementExistenceCheck(new Docs_Block().getDocsGridBody() , false);
	}
	//________________________________________________________________________________________________________________________________//
	
	
	//________________________________________________________ ���������� ���������� _____________________________________________________________//

	public void instructionStructure_Add(){		
		// �������� ���-��� ���������� 
		new InstructionStructure_Block().getAddButton().click();
		simpleWait(1);
		waitUntilUnblocked((new InstructionStructure_Block().new AddEdit_PopUps_Elements().getAddEditPopUp()));
		simpleWait(2);
		
		// �������� �������
		new InstructionStructure_Block().new AddEdit_PopUps_Elements().getSectionName_SelectField().selectByIndex(2);
		
		// ����� �������
		new InstructionStructure_Block().new AddEdit_PopUps_Elements().getSectionText_Field().inputText(new InstructionStructure_Block().new Values().sectionText);
		
		// ���������� ���������� ����������
		new InstructionStructure_Block().new AddEdit_PopUps_Elements().getSaveButton().click();
		simpleWait(2);
		waitForBlockStatus(new InstructionStructure_Block().getGridDownload_Div(), false);
	}
	
	public void addedInstructionStructure_Check(){
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
				  						  new InstructionStructure_Block().new Values().sectionNumber,
				  						  new InstructionStructure_Block().new Values().sectionName,
										  new InstructionStructure_Block().new Values().sectionText,
										  ""};
		
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new InstructionStructure_Block().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public void instructionStructure_Edit(){
		// �������� ���-��� �������������� ���������� ����������
		new InstructionStructure_Block().getEdit_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new InstructionStructure_Block().new AddEdit_PopUps_Elements().getAddEditPopUp()));
		simpleWait(2);
		
		// �������� �����
		new InstructionStructure_Block().new AddEdit_PopUps_Elements().getSectionText_Field().clear();
		simpleWait(1);
		new InstructionStructure_Block().new AddEdit_PopUps_Elements().getSectionText_Field().inputText(new InstructionStructure_Block().new Values().sectionText_Edited);
		
		// ���������� ���������� ����������
		new InstructionStructure_Block().new AddEdit_PopUps_Elements().getSaveButton().click();
		simpleWait(2);
		waitForBlockStatus(new Docs_Block().getGridDownload_Div(), false);
	}
	
	public void editedInstructionStructure_Check(){
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[] {"",
				  						  new InstructionStructure_Block().new Values().sectionNumber,
				  						  new InstructionStructure_Block().new Values().sectionName,
										  new InstructionStructure_Block().new Values().sectionText_Edited,
										  ""};
		
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new InstructionStructure_Block().getGridBody());
		
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);
	}
	
	public void instructionStructure_Delete(){
		// �������� ���-��� ��������
		new InstructionStructure_Block().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked(new Deletion_PopUp().getDeletionPopUp());
		simpleWait(2);
			
		// �������� ���������� ����������
		new Deletion_PopUp().getDeletionAcceptButton().click();
		simpleWait(2);
		waitForBlockStatus(new InstructionStructure_Block().getGridDownload_Div(), false);
	}
	
	public void deletedInstructionStructure_Check(){
		// �������� ���������� �������� � ����� '���������� ����������'
		new CustomMethods().elementExistenceCheck(new InstructionStructure_Block().getGridBody() , false);
	}
	//________________________________________________________________________________________________________________________________//
	
	public LogInPage_My userOut(){
		// ����� �� ������� 
		return new CommonActions().userOut(driver);
	}
	
	public void addButtonsDisability_Check(){
		// �������� ���������
		driver.navigate().refresh();
		simpleWait(2);
		waitForBlockStatus(new InstructionStructure_Block().getGridDownload_Div(), false);
		
		// �������� ������ ���������� ���������
		assertThat(new Docs_Block().getAddButton().getAttribute("disabled"), is(equalTo("true")));
		
		// �������� ������ ���������� ���������� ����������
		assertThat(new InstructionStructure_Block().getAddButton().getAttribute("disabled"), is(equalTo("true")));
	}
	
	// �������� ����� '����������'
	private class Instructions_Block{
		// ������ ����������
		private Button getAdd_Button(){
			return new Button(driver, By.xpath("//input[contains(@onclick, 'AddEditInstruction')]"));
		}
		
		// ���� �������
		private WebElement getGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_instructions']/tbody"));
		}
		
		// "������������"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_instructions"));
		}
		
		// ������ ��������������
		private Button getEdit_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_instructions_edit']/input"));
		}
		
		// ������ ��������
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_instructions_del']/input"));
		}
		
		// ������ ��������
		private Custom getChangeNumber_Cell(){
			return new Custom(driver, By.xpath("//td[@aria-describedby='list_instructions_change_number']"));
		}
		
		private void instruction_FillUp(){
			// ���� �����������
			new AddEdit_PopUps_Elements().getApprovalDate().click();
			new AddEdit_PopUps_Elements().getApprovalDate().inputText(new Values().approvalDate);
			
			// � ���������
			new AddEdit_PopUps_Elements().getChangeNumber().inputText(new Values().changeNumber);
			
			// ��������� ���������
			new AddEdit_PopUps_Elements().getChangeReason().inputText(new Values().changeReason);
			
			// ���� ���������
			new AddEdit_PopUps_Elements().getApplicationDate().click();
			new AddEdit_PopUps_Elements().getApplicationDate().inputText(new Values().applicationDate);
			
			// ���� ���������
			new AddEdit_PopUps_Elements().getChangePoint().inputText(new Values().changePoint);
			
			// � �������
			new AddEdit_PopUps_Elements().getOrderNumber().inputText(new Values().orderNumber);
			
			// ���� �������
			new AddEdit_PopUps_Elements().getOrderDate().click();
			new AddEdit_PopUps_Elements().getOrderDate().inputText(new Values().orderDate);
			
			// ��������� ������������ - '��������� ������������' -> ��
			new AddEdit_PopUps_Elements().getChangeSecurity_Yes_RadioButton().click();
			
			// ���� ��������� � ������� ������ �� ������������
			new AddEdit_PopUps_Elements().getChangeSecurityPoint().inputText(new Values().changeSecurityPoint);
			
			// ������������ ���������
			new AddEdit_PopUps_Elements().getHideChanges().inputText(new Values().hideChanges);		
		}
		
		private class AddEdit_PopUps_Elements{
			private Custom getAddPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '"+ new Values().addPopUp_Name +"']"));
			}
			
			private Custom getEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '"+ new Values().editPopUp_Name +"']"));
			}
			
			private TextInput getApprovalDate(){
				return new TextInput(driver, By.id("date_of_approval"));
			}
			
			private TextInput getChangeNumber(){
				return new TextInput(driver, By.id("change_number"));
			}
			
			private TextInput getChangeReason(){
				return new TextInput(driver, By.id("change_essence"));
			}
			
			private TextInput getApplicationDate(){
				return new TextInput(driver, By.id("application_date"));
			}
			
			private TextInput getChangePoint(){
				return new TextInput(driver, By.id("change_reasons"));
			}
			
			private TextInput getOrderNumber(){
				return new TextInput(driver, By.id("order_number"));
			}
			
			private TextInput getOrderDate(){
				return new TextInput(driver, By.id("order_date"));
			}
			
			private Button getChangeSecurity_Yes_RadioButton(){
				return new Button(driver, By.xpath("//input[@id='is_change_security_id'][1]"));
			}
			
/*			private Button getChangeSecurity_No_RadioButton(){
				return new Button(driver, By.xpath("//input[@id='is_change_security_id'][2]"));
			}*/
			
			private TextInput getChangeSecurityPoint(){
				return new TextInput(driver, By.id("change_security_essence"));
			}
			
			private TextInput getHideChanges(){
				return new TextInput(driver, By.id("change_unrecognised"));
			}
			
			private Button getSave_Button(){
				return new Button(driver, By.xpath("//input[contains(@onclick, 'SaveInstruction')]"));
			}
		}
		
		// �������� ��� ���������� � ��������
		private class Values{
			private String addPopUp_Name = "���������� ����������";					// �������� ���-��� ����������
			private String editPopUp_Name = "��������� ����������";					// �������� ���-��� ��������������
			private String approvalDate = "01.01.2012";								// ���� �����������
			private String changeNumber = "111";	  								// � ���������
			private String changeReason = "��������";								// ��������� ���������
			private String applicationDate = "02.01.2012";						    // ���� ���������
			private String changePoint = "��������";								// ���� ���������
			private String orderNumber = "222";	  									// � �������
			private String orderNumber_edited = "333";	  					  		// � ������� ��� ��������������
			private String orderDate = "03.01.2012";								// ���� �������
/*			private String changeSecurity_Yes = "��";	  						    // ��������� ������������ -> ��
			private String changeSecurity_No = "���";	  						    // ��������� ������������ -> ���
*/			private String changeSecurityPoint = "�������� ������������";			// ���� ��������� � ������� ������ �� ������������
			private String hideChanges = "���";	  						    		// ������������ ���������
		}
	}
	
	// �������� ����� '���������'
	private class Docs_Block{
		// ������ ����������
		private Button getAddButton(){
			return new Button(driver, By.id("add_edit_file_ins"));
		}
		
		// <tbody> �����
		private WebElement getDocsGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_file_load_ins']/tbody"));
		}
		
		// "������������"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_file_load_ins"));
		}
		
		// ������ ��������������
		private Button getEdit_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_ins_edit']/input"));
		}
		
		// ������ ��������
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_ins_del']/input"));
		}
		
		// ������ �������� �����
		private Button getFileDownloadButton(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_file_load_ins_load']/input"));
		}
		
		private class AddEdit_PopUps_Elements{
			// ���-�� ����������
			private Custom getAddPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '"+ new Values().addPopUp_Name +"']"));
			}
			
			// ���-�� ��������������
			private Custom getEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '"+ new Values().editPopUp_Name +"']"));
			}
		
			// ����
			private TextInput getDate_Field(){
				return new TextInput(driver, By.id("Date"));
			}
			
			// �������� ���������
			private TextInput getName_Field(){
				return new TextInput(driver, By.id("Title"));
			}
			
			// �������� ���������
			private TextInput getDescription_Field(){
				return new TextInput(driver, By.id("Description"));
			}
			
			// �������� ���������
			private Select getDocType_Field(){
				return new Select(driver.findElement(By.id("TypeId")));
			}
			
			// ����
			private TextInput getFile_Field(){
				return new TextInput(driver, By.id("FileName"));
			}
			
			private TextInput getFileUpload_Button(){
				return new TextInput(driver, By.id("file_source"));
			}
			
			// ������ �� ����
			private TextInput getFileLink_Field(){
				return new TextInput(driver, By.id("FileLink"));
			}
			
			// ������ '���������'
			private Button getSaveButton(){
				return new Button(driver, By.id("save_file_btn"));
			}
		}
		
	private class Values{
		private String addPopUp_Name = "���������� ���������";					// �������� ���-��� ����������
		private String editPopUp_Name = "�������������� ���������";				// �������� ���-��� ��������������
			
		private String date = "05.01.2012";	  									// ����
		private String name = "���";						     				// �������� ���������
		private String editedName = "����";										// �������� ��������� ����� ��������������
		private String docDescription = "��������";						    	// �������� ���������
		private String docType = "����������";						     		// ����������
		private String fileWay = "C:\\Selenium_TestData\\Other\\ForDocAdd.txt";	// ������ �� ����(��������)
		private String fileName = "ForDocAdd.txt";								// �������� �����
		private String fileLink = "www.getFile.com/get";			     		// ������ �� ����
		}
	}
	
	// �������� ����� '���������'
	private class InstructionStructure_Block{
		// ������ ����������
		private Button getAddButton(){
			return new Button(driver, By.id("add_edit_ins_struct"));
		}
			
		// <tbody> �����
		private WebElement getGridBody(){
			return driver.findElement(By.xpath("//*[@id='list_ins_struct']/tbody"));
		}
			
		// "������������"
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_ins_struct"));
		}
			
		// ������ ��������������
		private Button getEdit_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_ins_struct_edit']/input"));
		}
			
		// ������ ��������
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_ins_struct_del']/input"));
		}
			
		private class AddEdit_PopUps_Elements{
			// ���-�� ����������/��������������
			private Custom getAddEditPopUp(){
				return new Custom(driver, By.xpath("//span[text() = '"+ new Values().addEditPopUp_Name +"']"));
			}
			
			// �������� �������
			private Select getSectionName_SelectField(){
				return new Select(driver.findElement(By.id("dic_section_names_id")));
			}
				
			// ����� �������
			private TextInput getSectionText_Field(){
				return new TextInput(driver, By.id("section_text"));
			}
						
			// ������ '���������'
			private Button getSaveButton(){
				return new Button(driver, By.id("save_btn"));
			}
		}
			
		private class Values{
			private String addEditPopUp_Name = "���������� ����������";					// �������� ���-��� ����������/��������������
				
			private String sectionNumber = "03";										// ����� �������
			private String sectionName = "�������� ��������";							// �������� �������
			private String sectionText = "�����";										// ����� �������
			private String sectionText_Edited = "����� �������";						// ����� �������, ��� ��������������
		}
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


