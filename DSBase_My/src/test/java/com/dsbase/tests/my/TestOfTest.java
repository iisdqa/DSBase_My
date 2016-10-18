package com.dsbase.tests.my;

import org.testng.annotations.Test;

import com.dsbase.core.BaseTest;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;
import com.dsbase.pages.events.my.AddEvent_My;
import com.dsbase.pages.events.my.EventsRegistry_My;
import com.dsbase.pages.staff.StaffAdd;
import com.dsbase.pages.staff.StaffRegistry_My;


public class TestOfTest  extends  BaseTest{
	@Test(groups = { "TestOfTest" }) 
	public void DrugRegistration_TestMethod(){
		// Переход на главную
		LogInPage_My authorizationPage = new MainPage_My(driver).redirectToLogInPage();
		MainPage_My mainPage_My=authorizationPage.logInAs("autotest_allroles", "aut0test_allr0les7_3");
	     
		
		StaffAdd staffAdd = mainPage_My.new goTo().staffRegistry_My().clickAddNewSTuffButton();
		staffAdd.FirstTabPersonal_FillUp();
		staffAdd.SaveFormeStaff();
		staffAdd.SecondTabAssignment_FillUp();
		staffAdd.SecondTabAssignment_Check();
		staffAdd.SaveFormeStaff();
		StaffRegistry_My staffRegistry = mainPage_My.new goTo().staffRegistry_My();
		staffRegistry.SearchStaff();
		staffRegistry.SearchStaff_Check();
		EventsRegistry_My eventsRegistry_My = mainPage_My.new goTo().eventsRegistry_My();
        AddEvent_My addEvent_My = eventsRegistry_My.clickAddNewEventButton();
		addEvent_My.FirstPartEvents_FillUp();
		addEvent_My.PopUpParticipantsFromRegistry_FillUp();
		addEvent_My.PopUpNewParticipants_FillUp();
		addEvent_My.SecondPartEvents_Check();
		addEvent_My.saveEvent();
		eventsRegistry_My = mainPage_My.new goTo().eventsRegistry_My();
		eventsRegistry_My.SearchEvent();
		eventsRegistry_My.SearchEvent_Check();
		eventsRegistry_My.Event_Delete();
		
      
	}
}
