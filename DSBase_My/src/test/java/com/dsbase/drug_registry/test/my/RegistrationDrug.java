package com.dsbase.drug_registry.test.my;

import org.testng.annotations.Test;

import com.dsbase.core.BaseTest;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;
import com.dsbase.pages.drugs.my.DrugRegistrationPage_My;
import com.dsbase.pages.drugs.my.DrugRegistryPage_My;

public class RegistrationDrug extends BaseTest{
	@Test(groups = { "DrugRegistration_Test" }) 
	public void DrugRegistration_TestMethod(){
		// ������� �� �������
		LogInPage_My authorizationPage = new MainPage_My(driver).redirectToLogInPage();
		MainPage_My mainPage_My=authorizationPage.logInAs("autotest_allroles", "aut0test_allr0les7_3");
	   
		// �������� �� "����������� ��"		
    	DrugRegistrationPage_My drugRegistrationPage_My = mainPage_My.new goTo().drugRegistrationPage_My();
		drugRegistrationPage_My.marketingCountry_Set();
		drugRegistrationPage_My.mainFields_FillUp();
		drugRegistrationPage_My.mnn_Add();
		drugRegistrationPage_My.addedMnn_check();
		drugRegistrationPage_My.substance_Add();
	    drugRegistrationPage_My.addedSubstance_check();
	    drugRegistrationPage_My.doc_Add();
	    drugRegistrationPage_My.addedDoc_check();
	    drugRegistrationPage_My.employee_Add();
	    drugRegistrationPage_My.addedEmployee_check();
	    drugRegistrationPage_My.manufacturer_Add();
	    drugRegistrationPage_My.addedManufacturer_check();
	    drugRegistrationPage_My.addExcipients();
	    drugRegistrationPage_My.addExcipients_Check();
	    drugRegistrationPage_My.drug_Save();
	    // ������� �� ����� ��
	    DrugRegistryPage_My drugRegistryPage_My=mainPage_My.new goTo().drugRegistryMy();
	    drugRegistryPage_My.WaitForPageReady();
	    drugRegistryPage_My.userNameCheck("����� ��� ����� ��� ����");
	    drugRegistryPage_My.drug_Search();
	    
	    
	    
	    
	    
	}
	
}

