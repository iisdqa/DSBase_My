package com.dsbase.drug_registry.test.my;

import org.testng.annotations.Test;

import com.dsbase.core.BaseTest;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;
import com.dsbase.pages.drugs.my.DrugEditPage_My;
import com.dsbase.pages.drugs.my.DrugPassportPage_My;
import com.dsbase.pages.drugs.my.DrugRegistrationPage_My;
import com.dsbase.pages.drugs.my.DrugRegistryPage_My;

public class RegistrationDrug extends BaseTest{
	@Test(groups = { "DrugRegistration_Test" }) 
	public void DrugRegistration_TestMethod(){
		// Переход на главную
		LogInPage_My authorizationPage = new MainPage_My(driver).redirectToLogInPage();
		MainPage_My mainPage_My=authorizationPage.logInAs("autotest_allroles", "aut0test_allr0les7_3");
	   
//		DrugPassportPage_My drugPassportPage_My = mainPage_My.new goTo().customPage();
		
		
		
		// нажимаем на "Регистрация ЛС"
		
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
	    DrugPassportPage_My drugPassportPage_My = drugRegistrationPage_My.drug_Save();
	    
	    // Редактируем сохраненный препарат
	    
	    DrugEditPage_My drugEditPage_My= drugPassportPage_My.drug_Edit();
	    drugEditPage_My.addedMnn_check();
	    drugEditPage_My.mnn_Edit();
	    drugEditPage_My.editedMnn_check();
	    drugEditPage_My.addedManufacturer_check();
	    drugEditPage_My.manufacturer_Edit();
	    drugEditPage_My.addedManufacturer_check();
	    drugEditPage_My.addedSubstance_check();
	    drugEditPage_My.substance_Edit();
	    drugEditPage_My.editedSubstance_check();
	    drugEditPage_My.addedDoc_check();
	    drugEditPage_My.doc_Edit();
	    drugEditPage_My.editedDoc_check();
	    drugEditPage_My.addedEmployee_check();
	    drugEditPage_My.employee_Edit();
	    drugEditPage_My.editedEmployee_check();
	    drugPassportPage_My = drugEditPage_My.drug_Save();	   
	    
	    // переход на реестh ЛС, проверка на то что все поля заполнены верно, удаление препарата.
	    
	    DrugRegistryPage_My drugRegistryPage_My=mainPage_My.new goTo().drugRegistryMy();
	    drugRegistryPage_My.WaitForPageReady();
	    drugRegistryPage_My.userNameCheck("Тамин бин Хамад Аль Тани");
	    drugRegistryPage_My.drug_Search();
	    drugRegistryPage_My.foundDrug_Check();
	    drugRegistryPage_My.drug_Delete();
	    drugRegistryPage_My.deletedDrug_check();
	    
	    
	    
	}
	
}

