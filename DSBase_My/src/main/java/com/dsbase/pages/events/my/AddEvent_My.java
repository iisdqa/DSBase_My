package com.dsbase.pages.events.my;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.CheckBox;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Link;
import com.dsbase.core.web.elements.TextInput;


public class AddEvent_My extends WebPage<AddEvent_My> {
	private static final String PAGE_URL = BASE_URL + "/Events/0/100";
	public AddEvent_My(WebDriver driver){
		super (driver);
	}
	@Override
	public AddEvent_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable() {
		return new FirstPartEventsElements(). getFullEventTitle().isAvailable();
	}
	//________________________________________Actions_________________________________________________//
	public void FirstPartEvents_FillUp(){
		// ���������� ���� "������ �������� �����������"
		new FirstPartEventsElements().getFullEventTitle().inputText(new FirstPartEventsElements().new Values().fullEventTitle);
		// ���������� ���� "����������� �������� �����������"
		new FirstPartEventsElements(). getShortEventTitle().inputText(new FirstPartEventsElements(). new Values().shortEventTitle);
		// ���������� ���� "��� �����������"
		new FirstPartEventsElements().getEventType().selectByVisibleText(new FirstPartEventsElements().new Values().eventType);
		// ���������� ���� "������"
		new FirstPartEventsElements().getStatus().selectByVisibleText(new FirstPartEventsElements(). new Values().status);
		// ���������� ���� "���� ������"
		new FirstPartEventsElements().getStartDate().click();
		new FirstPartEventsElements().getStartDate().inputText(new FirstPartEventsElements(). new Values().startDate);
		// ���������� ���� "���� ����������"
		new FirstPartEventsElements().getEndDate().click();
		new FirstPartEventsElements().getEndDate().inputText(new FirstPartEventsElements(). new Values().endDate);
		// ���������� ���� ���� ����������� �����������
		new FirstPartEventsElements().getEventApprovalDate().click();
		new FirstPartEventsElements().getEventApprovalDate().inputText(new FirstPartEventsElements().new Values().eventApprovalDate);
		// ���������� ���� "����� ���������� �����������"
		new FirstPartEventsElements().getEventLocation().inputText(new FirstPartEventsElements(). new Values().eventLocation);
		// ������������ ������������ "���������� ������������" �� "���"
		new FirstPartEventsElements().getTestingRadioButton(2).click();
		// ���������� ���� "���� ������������"
		new FirstPartEventsElements().getTestingDate().click();
		new FirstPartEventsElements().getTestingDate().inputText(new FirstPartEventsElements().new Values().testingDate);
		// ���������� ���� "����������"
		new FirstPartEventsElements().getEventNotes().inputText(new FirstPartEventsElements().new Values().eventNotes);
	}
	public void PopUpParticipantsFromRegistry_FillUp(){
		// �������� ���-��� "����� �������� �� ������� �����������"
		new SecondPartEventsElements().getParticipants().click();
		new PopUpParticipantsFromRegistry().getParticipantsFromRegistry().click();
		new PopUpParticipantsFromRegistry().getSearchButton().waitUntilAvailable();
		// ���������� ���� "���������"
		new PopUpParticipantsFromRegistry().getCategory().selectByVisibleText(new PopUpParticipantsFromRegistry().new ValuesFromStaffRegistry().category);
		// ���������� ���� "�����������"
		new PopUpParticipantsFromRegistry().getActivityArea().selectByVisibleText(new PopUpParticipantsFromRegistry().new ValuesFromStaffRegistry().activityArea);
		// �������� �� ������ �����
		new PopUpParticipantsFromRegistry().getSearchButton().click();
		simpleWait(2);
		waitForBlockStatus(new PopUpParticipantsFromRegistry().getGridDownload_Div(), false);
		// �������� ����������
		new PopUpParticipantsFromRegistry().getSelectStaff().click();
		simpleWait(2);
		// ��������� ���������� � ���� "��������"
		new PopUpParticipantsFromRegistry().getChooseStaff().click();
	}
	public void PopUpNewParticipants_FillUp(){
		// �������� ���-��� "���������� ������ ����������"
		waitWhileClickable(new SecondPartEventsElements().getParticipants());
		new SecondPartEventsElements().getParticipants().click();
		new PopUpNewParticipants().getNewParticipants().click();
		new PopUpNewParticipants().getSaveNewParticipantButton().waitUntilAvailable();
		// ���������� ���� "�������"
		new PopUpNewParticipants().getSurname().inputText(new PopUpNewParticipants().new ValuesNewParticipants().surname);
		// ���������� ���� "���"
		new PopUpNewParticipants().getName().inputText(new PopUpNewParticipants().new ValuesNewParticipants().name);
		// ���������� ���� "��������"
		new PopUpNewParticipants().getPatronymic().inputText(new PopUpNewParticipants().new ValuesNewParticipants().patronymic);
		// ���������� ���� "���������"
		new PopUpNewParticipants().getPosition().inputText(new PopUpNewParticipants().new ValuesNewParticipants().position);
		// ���������� ���� "��������� ����������"
		new PopUpNewParticipants().getEmployeeCategory().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().category);
		// ���������� ���� "�����������"
		new PopUpNewParticipants().getActivityArea().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().activityArea);
		// ���������� ���� "�������������"
		new PopUpNewParticipants().getDepartment().inputText(new PopUpNewParticipants().new ValuesNewParticipants().department);
		// ���������� ���� "������"
		new PopUpNewParticipants().getRegion().inputText(new PopUpNewParticipants().new ValuesNewParticipants().region);
		// ���������� ���� "�����"
		new PopUpNewParticipants().getCity().inputText(new PopUpNewParticipants().new ValuesNewParticipants().city);
		// ���������� ���� "������� �������"
		new PopUpNewParticipants().getCoachSign().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().coachSign);
		// ���������� ���� "��������� ��������"
		new PopUpNewParticipants().getTrainingResult().selectByVisibleText(new PopUpNewParticipants().new ValuesNewParticipants().trainingResult);
		// ���������� ���� "��������� ��������"(�������� ����)
		new PopUpNewParticipants().getTrainingResultText().inputText(new PopUpNewParticipants().new ValuesNewParticipants().trainingResultText);
		// ���������� ���� "����������"
		new PopUpNewParticipants().getNote().inputText(new PopUpNewParticipants().new ValuesNewParticipants().note);
		// �������� ������ "���������"
		new PopUpNewParticipants().getSaveNewParticipantButton().click();
		simpleWait(2);
		waitForBlockStatus(new SecondPartEventsElements().getGridDownload_Div() , false);
	}
	public void SecondPartEvents_Check(){
		
		// ����������� ��������� ��������
				String[][] ExpectedValues = new String [2][];
				ExpectedValues[0] = new String[] {"",
					new PopUpNewParticipants().new ValuesNewParticipants().surname,
					new PopUpNewParticipants().new ValuesNewParticipants().name,
					new PopUpNewParticipants().new ValuesNewParticipants().patronymic,
					new PopUpNewParticipants().new ValuesNewParticipants().coachSign,
					new PopUpNewParticipants().new ValuesNewParticipants().trainingResult,
					new PopUpNewParticipants().new ValuesNewParticipants().trainingResultText,
					new PopUpNewParticipants().new ValuesNewParticipants().position,
					new PopUpNewParticipants().new ValuesNewParticipants().category,
					new PopUpNewParticipants().new ValuesNewParticipants().activityArea,
					new PopUpNewParticipants().new ValuesNewParticipants().department,
					new PopUpNewParticipants().new ValuesNewParticipants().region,
					new PopUpNewParticipants().new ValuesNewParticipants().city,
					new PopUpNewParticipants().new ValuesNewParticipants().note,
					""};
				ExpectedValues[1] = new String[] {"",
					"�������",
					"�����",
					"��������",
					" ",
					" ",
					" ",
					"Senior assistant",
					"������������, �������������, ������������",
					"���������������",
					"Administration",
					" ",
					" ",
					" ",
					""	
				};
		// ����������� ���������� ��������
		String[][] ActualValues = new CustomMethods().new Grid().GetAllRows(new SecondPartEventsElements().getGridBody());
		// �������� �������� �����
		new CustomMethods().new Grid().gridValuesEqualityCheck(ExpectedValues, ActualValues);	
	}
	public void saveEvent(){
		getSaveButton().click();
		simpleWait(2);
		waitForBlockStatus(new SecondPartEventsElements().getGridDownload_Div() , false);
	}
	
	
	//________________________________________Elements________________________________________________//
	private Button getSaveButton(){																		// ������ ����������
		return new Button(driver, By.id("save_btn"));
	}
	private class FirstPartEventsElements{
		private TextInput getFullEventTitle(){															// ������ �������� �����������
			return new TextInput(driver, By.id("Tab0_FullName"));			
		}
		private TextInput getShortEventTitle(){															// �������� �������� �����������
			return new TextInput(driver, By.id("Tab0_ShortName"));			
		}
		private Select getEventType(){																	// ��� ����������� 
			return new Select(driver.findElement(By.id("Tab0_EventType")));
		}
		private Select getStatus(){																		// ������
			return new Select(driver.findElement(By.id("Tab0_Status")));
		}
		private TextInput getStartDate(){																// ���� ������
			return new TextInput(driver, By.id("Tab0_DateBegin"));			
		}
		private TextInput getEndDate(){																	// ���� ���������
			return new TextInput(driver, By.id("Tab0_DateEnd"));			
		}
		private TextInput getEventApprovalDate(){														// ���� ����������� �����������
			return new TextInput(driver, By.id("Tab0_DateConfirm"));	
		}
		private TextInput getEventLocation(){															// ����� ���������� �����������
			return new TextInput(driver, By.id("Tab0_PlaceName"));
		}
		private Custom getTestingRadioButton(int buttonNum){											// buttonNum - 1 ��� 2 ���������� ������������(radioButton)
			return new Custom(driver, By.xpath("//input[@id='Tab0_IsTestedMap']["+buttonNum +"]"));
		}										
		private TextInput getTestingDate(){																// ���� ������������ 
			return new TextInput(driver, By.id("Tab0_DateTest"));			
		}
		private TextInput getEventNotes(){																// ����������
			return new TextInput(driver, By.id("Tab0_Note"));
		}
		private class Values{
			private String fullEventTitle = "chicken fest";												// ������ �������� �����������
			private String shortEventTitle = "cf";														// �������� �������� ����������� 
			private String eventType = "�������";														// ��� ����������� 
			private String status = "�����������";														// ������ 
			private String startDate = new CustomMethods().getChangedDate(-1);							// ���� ������ 
			private String endDate = new CustomMethods().getChangedDate(+2);							// ���� ���������
			private String eventApprovalDate = new CustomMethods().getChangedDate(+1);                  // ���� ����������� �����������
			private String eventLocation = "����������, ���� ��� ������";								// ����� ���������� �����������
			private String testingDate = new CustomMethods().getChangedDate(+2);						// ���� ������������
			private String eventNotes = "without comments";												// ����������
		
		}
	}
	private class SecondPartEventsElements{
		private Button getParticipants(){ 																// ������ ��������
			return new Button(driver, By.id("OpenListOfButton"));
		}
		private Custom getGridDownload_Div(){															// ��������� ����� "��������"
			return new Custom(driver, By.id("load_list_tab_0_2"));
		}
		private WebElement getGridBody(){																// ���� �����
			return driver.findElement(By.xpath("//table[@id='list_tab_0_2']/tbody"));
		}
	}
		// ����� ��������� �� ������� �����������
	private class PopUpParticipantsFromRegistry{
		private Link getParticipantsFromRegistry(){														// ������ ����� ���������� �� ������� ����������� 
			return new Link(driver, By.xpath("//p[@onclick='OpenChooseRangeStaff()']"));
		}
		private Select getCategory (){																	// ����� ���������
			return new Select(driver.findElement(By.id("CategoryId")));
		}
		private Select getActivityArea(){																// ����� �����������
			return new Select(driver.findElement(By.id("DirectionId")));
		}
		private Button getSearchButton(){																// ������ ������ � ���-���
			return new Button(driver, By.id("StaffNameControl_Find"));
		}
		private Custom getGridDownload_Div(){															// ��������� ����� ����������
			return new Custom(driver, By.id("load_list_staffnames"));
		}
		private CheckBox getSelectStaff(){																// ������� ������ ����������
			return new CheckBox(driver, By.id("isSelect_1"));
		}
		private Button getChooseStaff(){																// ������ "�������"
			return new Button(driver, By.id("StaffNameControl_Choose"));
		}
		private class ValuesFromStaffRegistry{
			private String category = "������������, �������������, ������������";						// ���������
			private String activityArea = "���������������";											// �����������
				
			}
		}
	// ���������� ������ ����������
	private class PopUpNewParticipants{
		private Button getSaveNewParticipantButton(){
			return new Button(driver, By.id("save_dialog_btn")); 										// ������ ��������� "������ ����������"
		}
		private Link getNewParticipants(){																// ������ ���������� ������ ��������
			return new Link(driver, By.xpath("//p[@onclick='OpenRecord0_2()']"));
		}
		private TextInput getSurname(){																	// ���� "�������"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberSurName"));
		}
		private TextInput getName(){																	// ���� "���"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberName"));
		}
		private TextInput getPatronymic(){																// ���� "��������"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberMiddleName"));
		}
		private TextInput getPosition(){																// ���� "���������"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberPost"));
		}
		private Select getEmployeeCategory(){															// ���� ��������� ���������� 
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberCategoryId")));
		}
		private Select getActivityArea(){																// ���� "�����������"
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberDirectionId")));
		}
		private TextInput getDepartment(){																// ���� "�������������"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberDepartment"));
		}
		private TextInput getRegion(){																	// ���� "������"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberRegion"));
		}
		private TextInput getCity(){																	// ���� "�����"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberCity"));
		}
		private Select getCoachSign(){																	// ���� "������� �������"
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberTrainerId")));
		}
		private Select getTrainingResult(){																// ���� "��������� ��������"
			return new Select(driver.findElement(By.id("Tab0_2Grid_MemberResultStudyId")));
		}
		private TextInput getTrainingResultText(){														// ��������� ���� "��������� ��������"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberResultStudy"));
		}
		private TextInput getNote(){																	// ���� "����������"
			return new TextInput(driver, By.id("Tab0_2Grid_MemberNote"));
		}
		private class ValuesNewParticipants{
			private String surname = "White";															// �������  
			private String name = "Walter";																// ��� 
			private String patronymic = "Hartwell";														// ��������
			private String position = "������� �����";													// ��������� 
			private String category = "������������, �������������, ������������";						// ��������� 
			private String activityArea = "���������������";											// �����������
			private String department = "Administration";												// �������������
			private String region = "���� ��� ������";										   			// ������
			private String city = "����������";															// �����
			private String coachSign = "������";														// ������� �������
			private String trainingResult = "���������";												// ��������� ��������
			private String trainingResultText = "�����";												// ��������� ��������(��������� ����)
			private String note = "without notes";														// ����������
		}
	}
}
	
	


