package com.dsbase.tests.my;

import org.testng.annotations.Test;

import com.dsbase.core.BaseTest;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;

import com.dsbase.pages.staff.StaffAdd;


public class TestOfTest  extends  BaseTest{
	@Test(groups = { "TestOfTest" }) 
	public void DrugRegistration_TestMethod(){
		// Переход на главную
		LogInPage_My authorizationPage = new MainPage_My(driver).redirectToLogInPage();
		MainPage_My mainPage_My=authorizationPage.logInAs("autotest_allroles", "aut0test_allr0les7_3");
	     
		
		StaffAdd staffAdd = mainPage_My.new goTo().customPage();
		staffAdd.FirstTabPersonal_FillUp();
		staffAdd.SecondTabAssignment_FillUp();
		// реестр сообщений ПР
		
      
	}
}
