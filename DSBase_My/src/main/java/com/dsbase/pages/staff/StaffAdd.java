package com.dsbase.pages.staff;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
		// ���������� ���� ��������� ����������
		new SecondTabAssignment().getCategory().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setCategory);
		// ���������� ���� �����������
		new SecondTabAssignment().getActivityArea().selectByVisibleText(new SecondTabAssignment().new ValuesSecondTab().setActivityArea);
		// ��������� ������ �������
		new SecondTabAssignment().getSaveButtonPopUp().click();
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
		private Button getHistoryAssignmentButton(){
			return new Button(driver, By.id("add_edit_tab6_1"));
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
		private class ValuesSecondTab{
			private String setPopUpName = "�������� ����� ������";								 // �������� ���-��� 
			private String setStartDate = new CustomMethods().getCurrentDate();                  // ������ ������
			private String setOrderNumber = "11112222";											 // ����� ������� 
			private String setOrderDate = new CustomMethods().getChangedDate(-3); 				 // ���� ������� 
			private String setArea = "�. ����";													 // �������
			private String setDepartment= "Administration";										 // �������������
			private String setCategory= "������������, �������������, ������������";			 // ���������			
			private String setActivityArea= "���������������";									 // �����������
					
		}
	}
	
		//_________________________________________������� �� ��������_________________________________________// 
	private Button getNumberOfTab(String insetNum){
		return new Button(driver, By.xpath("(//div[contains(@class, 'nav_item')])["+ insetNum +"]"));
	}
	
}	
	
	


