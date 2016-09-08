package com.dsbase.tests.my;

import org.testng.annotations.Test;

import com.dsbase.core.BaseTest;
import com.dsbase.core.web.pages.my.DrugRegistryMy;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;


public class MainPage_My_Test extends BaseTest {

	@Test(groups = { "MainPage_My_Test" })
	public void TestMainPage_TestMethod() 
	{
		/* логин ..*/
		LogInPage_My authorizationPage = new MainPage_My(driver).redirectToLogInPage();
		MainPage_My mainPage = authorizationPage.logInAs("ulloph_rus", "ullophrus");
		
		//нажимаем на "Реестр ЛС"
		DrugRegistryMy drugRegistryPage = mainPage.new goTo().drugRegistryMy();
		drugRegistryPage.userNameCheck("Ivanov Ann");
	   
		
	}
}


