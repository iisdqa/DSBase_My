package com.dsbase.tests.my;

import org.testng.annotations.Test;

import com.dsbase.core.BaseTest;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;
import com.dsbase.pages.adr_reports.ADRregistry_My;
import com.dsbase.pages.adr_reports.AddADRreport_My;


public class TestOfTest  extends  BaseTest{
	@Test(groups = { "TestOfTest" }) 
	public void DrugRegistration_TestMethod(){
		// Переход на главную
		LogInPage_My authorizationPage = new MainPage_My(driver).redirectToLogInPage();
		MainPage_My mainPage_My=authorizationPage.logInAs("autotest_allroles", "aut0test_allr0les7_3");
	     
		
		AddADRreport_My addADRreport_My = mainPage_My.new goTo().customPage();
		addADRreport_My.mainFields_FillUpFirstTab();
	    addADRreport_My.goToSecondTab();
		addADRreport_My.mainFields_FillUpSecondTab();
		addADRreport_My.goToFifthTab();
		addADRreport_My.mainFields_FillUpFifthTab();
		addADRreport_My.goToSixthTab();
		addADRreport_My.suspectDrugs_Add();
		addADRreport_My.addSuspectDrug_Check();
		addADRreport_My.saveADRreport();
		// реестр сообщений ПР
		ADRregistry_My aDRregistry_My = mainPage_My.new goTo().aDRregistry_My();
		aDRregistry_My.WaitForPageReady();
		aDRregistry_My.SearchADRreport();
	}
}
