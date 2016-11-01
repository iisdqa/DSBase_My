package com.dsbase.pages.staff;

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
		// ������� ����������
		new FirstTabPersonalElements().getLastName().inputText(new FirstTabPersonalElements().new Values().lastName);
		// ��� ����������
		new FirstTabPersonalElements().getFirstName().inputText(new FirstTabPersonalElements().new Values().firstName);		
		// �������� ����������
		new FirstTabPersonalElements().getPatronymic().inputText(new FirstTabPersonalElements().new Values().patronymic);
		// ���� �������� ����������
		new FirstTabPersonalElements().getBirthday().click();
		simpleWait(2);
		new FirstTabPersonalElements().getBirthday().inputText(new FirstTabPersonalElements().new Values().birthday);
		// ��� ����������
		new FirstTabPersonalElements().getSex().selectByVisibleText("�������");
		// ����������������� ���
		new FirstTabPersonalElements().getIdentificationCode().inputText(new FirstTabPersonalElements().new Values().identificationNumber);
		// ����� ��������
		new FirstTabPersonalElements().getPlaceOfBirth().inputText(new FirstTabPersonalElements().new Values().placeOfBirth);
		// ���������� ���� ���������� 
		new FirstTabPersonalElements().getFotoFile().inputText(new FirstTabPersonalElements().new Values().fileFotoWay);
		simpleWait(2);
		assertThat(new FirstTabPersonalElements().getFotoFileName().getAttribute("value"),is(equalTo(new FirstTabPersonalElements().new Values().fileFotoName)));
		
		// ������� ���������(����� ����� ���������� �� �������� ��� ���������� �������)
		new FirstTabPersonalElements().getAdditionData_Accordion().click();
		// ������ ���������
		new FirstTabPersonalElements().getSaveButton().click();
		simpleWait(2);
		// �������� �������� ����������
		new FirstTabPersonalElements().getAccortionClosed_Condition().waitUntilAvailable();
		
	}
	public void SaveFormeStaff(){
		// ������ ���������
			new FirstTabPersonalElements().getSaveButton().click();

	}
	public void SecondTabAssignment_FillUp(){
		// ������� �� 2 �������
		getNumberOfTab("2").click();
		// �������� ���-��� 
		new SecondTabAssignment().getHistoryAssignmentButton().click();
		waitUntilUnblocked(new SecondTabAssignment().getAddEditPopUp());
		// ���������� ���� ���� ������ ������ 
		new SecondTabAssignment().getStartDate().click();
		new SecondTabAssignment().getStartDate().inputText(new SecondTabAssignment().new ValuesSecondTab().setStartDate);
		// ���������� ���� ������ �
		new SecondTabAssignment().getOrderNumber().inputText(new SecondTabAssignment(). new ValuesSecondTab().setOrderNumber);
		// ���������� ���� ���� �������:
		new SecondTabAssignment().getOrderDate().click();
		new SecondTabAssignment().getOrderDate().inputText(new SecondTabAssignment().new ValuesSecondTab().setOrderDate);
		// ���������� ���� "�������"
		new SecondTabAssignment().getArea().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setArea);
		// ���������� ���� �������������
		new SecondTabAssignment().getDepartment().inputText(new SecondTabAssignment().new ValuesSecondTab().setDepartment);
		simpleWait(2);
		// ����� �������� � ���� �������������
		new SecondTabAssignment().getDepartmentAutocomplete().click();
		// ����������� ���� "�������������"
		new SecondTabAssignment().getPositions().inputText(new SecondTabAssignment().new ValuesSecondTab().setPosition);
		simpleWait(2);
		// ����� �������� � ���� �������������
		new CommonActions().autoCompleteValue_Set(driver, new SecondTabAssignment().getPositions(), 2);
		// ���������� ���� ��������� ����������
		new SecondTabAssignment().getCategory().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setCategory);
		// ���������� ���� �����������
		new SecondTabAssignment().getActivityArea().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setActivityArea);
		// radioButton ������� ����������� ����������
		new SecondTabAssignment().getActualAssignmentSign(1).click();
		// radioButton ������� 1-�� ����������
		new SecondTabAssignment().getFirstAssignmentSign(1).click();
		// ��������� ������ �������
		new SecondTabAssignment().getSaveButtonPopUp().click();
		waitWhileClickable(new SecondTabAssignment().getHistoryAssignmentButton());
	}
	public void SecondTabAssignment_Check(){
		simpleWait(2);
		// ����������� ��������� ��������
		String[][] ExpectedValues = new String [1][];
		ExpectedValues[0] = new String[]    {"", 
										 	new SecondTabAssignment().new ValuesSecondTab().setStartDate,
										 	new SecondTabAssignment().new ValuesSecondTab().setOrderNumber,
										 	new SecondTabAssignment().new ValuesSecondTab().setOrderDate,
										 	" ",
										 	new SecondTabAssignment().new ValuesSecondTab().setArea,
										 	" ",
										 	new SecondTabAssignment().new ValuesSecondTab().setDepartment,
										 	new SecondTabAssignment().new ValuesSecondTab().setPosition,
										 	new SecondTabAssignment().new ValuesSecondTab().setCategory,
										 	new SecondTabAssignment().new ValuesSecondTab().setActivityArea,
										 	" ",
										 	" ",
										 	" ",
										 	"��",
										 	"��",
										 	""
										 };
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new SecondTabAssignment().getAssignmentGridBody());
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);		
	}
	public void SecondTabAssignment_Delete(){
		// �������� ���-��� �������� '���������'
		new Deletion_PopUp().getDelete_Button().click();
		simpleWait(2);
		waitUntilUnblocked((new Deletion_PopUp().getDeletion_PopUp()));
		simpleWait(2);
					
		// ������������� �������� ���������
		new Deletion_PopUp().getDeletionYes_Button().click();
		simpleWait(2);
				
		//

		waitForBlockStatus(new SecondTabAssignment().getGridDownload_Div(), false);
	
	}
	public void SecondTabAssignment_DeleteCheck(){
		// �������� ���������� �������� � ����� '������� ���������� �� ���������'
		new CustomMethods().elementExistenceCheck(new SecondTabAssignment().getAssignmentGridBody(), false);
	}
	
	//________________________________________Elements________________________________________________//
	private class FirstTabPersonalElements{
		private TextInput getLastName(){																// ������� ����������
			return new TextInput(driver, By.id("Tab0_SurName"));										
		}
		private TextInput getFirstName(){																// ��� ����������
			return new TextInput(driver, By.id("Tab0_FirstName"));					
		}
		private TextInput getPatronymic(){																// �������� ����������
			return new TextInput(driver, By.id("Tab0_MiddleName"));
		}
		private TextInput getBirthday(){																// ���� �������� 
			return new TextInput(driver, By.id("Tab0_DateBirth"));
		}
		private Select getSex(){																		// ��� ����������
			return new Select(driver.findElement(By.id("Tab0_Sex")));
		}
		private TextInput getIdentificationCode(){														// ����������������� ���
			return new TextInput(driver, By.id("Tab0_IdentificationCode"));
		}
		private TextInput getPlaceOfBirth(){															// ����� ��������
			return new TextInput(driver, By.id("Tab0_BirthPlace"));
		}
		private TextInput getFotoFile(){																// ������ ���������� ���� ����������
			return new TextInput(driver, By.id("file_source"));
		}
		private TextInput getFotoFileName(){															// ��� ����������� �����
			return new TextInput(driver, By.id("Tab0_PictureFileName"));			
		}
		private Button getSaveButton(){																	// ������ ����������
			return new Button(driver, By.id("save_btn"));
		}
		private Custom getAdditionData_Accordion(){
			return new Custom(driver, By.id("accordHide"));
		}
		private Custom getAccortionClosed_Condition(){
			return new Custom(driver, By.xpath("//*[@id='ui-accordion-accordHide-header-0' and contains(@class, 'ui-corner-all')]"));
		}
		
		private class Values{
			private String lastName = "�������"; 														// ������� 
			private String firstName = "�����";															// ���
			private String patronymic = "��������";														// ��������
			private String birthday = "01.01.1989";														// ���� ��������
			private String identificationNumber = "9996669991";											// ����������������� ���
			private String placeOfBirth = "�����������, ���� ��� ������"; 								// ����� �������� 
			private String fileFotoWay = "C:\\Users\\rudyi\\Desktop\\photo\\testcat.jpg"; 				// ������ �� ����(��������)
			private String fileFotoName = "testcat.jpg";												// ��� �����		
		}
		
	}
	//_____________________________________________������ ������� "���������"_______________________________________________________//
	private class SecondTabAssignment{
		// ������ ���������� ������� ���������� �� ���������
		private Custom getHistoryAssignmentButton(){
			return new Custom(driver, By.id("add_edit_tab6_1"));
		}
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_tab_6_1"));
		}
		private WebElement getAssignmentGridBody(){
			return driver.findElement(By.xpath("//table[@id='list_tab_6_1']/tbody"));
		}										
		// Pop-up ����������
		private Custom getAddEditPopUp(){
			return new Custom(driver, By.xpath("//span[text() = '" + new ValuesSecondTab().setPopUpName + "']"));
		}
		// ���� ���� ������ ������
		private TextInput getStartDate(){
			return new TextInput(driver, By.id("Tab6_1Grid_HTADateWorkBegin"));
		}
		// ����� �������
		private TextInput getOrderNumber(){
			return new TextInput(driver, By.id("Tab6_1Grid_HTACommandNumber"));
		}
		// ���� �������
		private TextInput getOrderDate(){
			return new TextInput(driver, By.id("Tab6_1Grid_HTACommandDate"));
		}
		// �������
		private Select getArea(){
			return new Select(driver.findElement(By.id("Tab6_1Grid_HTAArea")));
		}
		// �������������
		private TextInput getDepartment(){
			return new TextInput (driver,By.id("Tab6_1Grid_HTADepartment"));
		}
		// ���������
		private TextInput getPositions(){
			return new TextInput(driver, By.id("Tab6_1Grid_HTAPositionIdName"));
		}                            
		// ������������� ����������
		private Text getDepartmentAutocomplete(){
			return new Text(driver, By.xpath("//strong[contains(text(), '" + new ValuesSecondTab().setDepartment + "')]"));
		}                                   
		//��������� ����������:
		private Select getCategory(){
			return new Select(driver.findElement(By.id("Tab6_1Grid_HTACategoryStaff")));
		}
		//�����������
		private Select getActivityArea(){
			return new Select(driver.findElement(By.id("Tab6_1Grid_HTADirection")));
		}
		// ������ ���������(pop-up)
		private Button getSaveButtonPopUp(){
			return new Button(driver, By.id("save_dialog_btn"));
		}
		// ������ ������� ����������� ����������
		private Custom getActualAssignmentSign(int buttonNum){											// buttonNum - 1 ��� 2 ���������� ������������(radioButton)
			return new Custom(driver, By.xpath("//input[@id='Tab6_1Grid_HTAIsActualDestinationMap']["+buttonNum +"]"));
		}
		// ������ ������� 1-�� ����������:
		private Custom getFirstAssignmentSign(int buttonNum){											// buttonNum - 1 ��� 2 ���������� ������������(radioButton)
			return new Custom(driver, By.xpath("//input[@id='Tab6_1Grid_HTAIsFirstDestinationMap']["+buttonNum +"]"));
		}
		private class ValuesSecondTab{
			private String setPopUpName = "�������� ����� ������";								 // �������� ���-��� 
			private String setStartDate = new CustomMethods().getCurrentDate();                  // ������ ������
			private String setOrderNumber = "11112222";											 // ����� ������� 
			private String setOrderDate = new CustomMethods().getChangedDate(-3); 				 // ���� ������� 
			private String setArea = "�. ����";													 // �������
			private String setDepartment= "Administration";										 // �������������
			private String setPosition="Senior assistant";										 // ���������
			private String setCategory= "������������, �������������, ������������";			 // ���������			
			private String setActivityArea= "���������������";									 // �����������
		}
	}
	private class Deletion_PopUp{
		// ������ ��������
		private Button getDelete_Button(){
			return new Button(driver, By.xpath("//td[@aria-describedby='list_tab_6_1_del']/input"));
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
	
		//_________________________________________������� �� ��������_________________________________________// 
	private Button getNumberOfTab(String insetNum){
		return new Button(driver, By.xpath("(//div[contains(@class, 'nav_item')])["+ insetNum +"]"));
	}
	
}	
	
	


