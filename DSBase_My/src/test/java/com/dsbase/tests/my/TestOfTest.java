package com.dsbase.tests.my;

import org.testng.annotations.Test;

import com.dsbase.core.BaseTest;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;
import com.dsbase.core.web.pages.my.MainPage_My.goTo;
import com.dsbase.pages.dcuments.my.AddMasterFile_My;
import com.dsbase.pages.dcuments.my.MasterFileRegistry_My;
import com.dsbase.pages.drugs.my.DrugEditPage_My;
import com.dsbase.pages.drugs.my.DrugPassportPage_My;
import com.dsbase.pages.drugs.my.DrugRegistrationPage_My;
import com.dsbase.pages.drugs.my.DrugRegistryPage_My;
import com.dsbase.pages.events.my.AddEvent_My;
import com.dsbase.pages.events.my.EventsRegistry_My;
import com.dsbase.pages.safety.my.ADRregistry_My;
import com.dsbase.pages.safety.my.AddADRreport_My;
import com.dsbase.pages.safety.my.AddPSUR_My;
import com.dsbase.pages.safety.my.PSURregistry_My;
import com.dsbase.pages.staff.StaffAdd;
import com.dsbase.pages.staff.StaffRegistry_My;


public class TestOfTest  extends  BaseTest{
	@Test(groups = { "TestOfTest" }) 
	public void DrugRegistration_TestMethod(){
//		// Переход на главную
		LogInPage_My authorizationPage = new MainPage_My(driver).redirectToLogInPage();
		MainPage_My mainPage_My=authorizationPage.logInAs("autotest_allroles", "aut0test_allr0les7_3");
//		DrugRegistrationPage_My drugRegistrationPage_My = mainPage_My.new goTo().drugRegistrationPage_My();
//		drugRegistrationPage_My.marketingCountry_Set();
//		drugRegistrationPage_My.mainFields_FillUp();
//		drugRegistrationPage_My.mnn_Add();
//		drugRegistrationPage_My.addedMnn_check();
//		drugRegistrationPage_My.substance_Add();
//		drugRegistrationPage_My.addedSubstance_check();
//	    drugRegistrationPage_My.doc_Add();
//	    drugRegistrationPage_My.addedDoc_check();
//	    drugRegistrationPage_My.employee_Add();
//	    drugRegistrationPage_My.addedEmployee_check();
//	    drugRegistrationPage_My.manufacturer_Add();
//	    drugRegistrationPage_My.addedManufacturer_check();
//	    drugRegistrationPage_My.addExcipients();
//	    drugRegistrationPage_My.addExcipients_Check();
//	    DrugPassportPage_My drugPassportPage_My = drugRegistrationPage_My.drug_Save();
////	    
////	    // Редактируем сохраненный препарат
////	    
//	    DrugEditPage_My drugEditPage_My= drugPassportPage_My.drug_Edit();
//	    drugEditPage_My.addedMnn_check();
//	    drugEditPage_My.mnn_Edit();
//	    drugEditPage_My.editedMnn_check();
//	    drugEditPage_My.addedManufacturer_check();
//	    drugEditPage_My.manufacturer_Edit();
//	    drugEditPage_My.addedManufacturer_check();
//	    drugEditPage_My.addedSubstance_check();
//	    drugEditPage_My.substance_Edit();
//	    drugEditPage_My.editedSubstance_check();
//	    drugEditPage_My.addedDoc_check();
//	    drugEditPage_My.doc_Edit();
//	    drugEditPage_My.editedDoc_check();
//	    drugEditPage_My.addedEmployee_check();
//	    drugEditPage_My.employee_Edit();
//	    drugEditPage_My.editedEmployee_check();
//	    drugPassportPage_My = drugEditPage_My.drug_Save();	   
////	    
////	    // переход на реестр ЛС, проверка на то что все поля заполнены верно, удаление препарата.
////	    
//	    DrugRegistryPage_My drugRegistryPage_My=mainPage_My.new goTo().drugRegistryMy();
//	    drugRegistryPage_My.WaitForPageReady();
//	    drugRegistryPage_My.userNameCheck("Тамин бин Хамад Аль Тани");
//	    drugRegistryPage_My.drug_Search();
//	    drugRegistryPage_My.foundDrug_Check();
//////	    drugRegistryPage_My.drug_Delete();
//////      drugRegistryPage_My.deletedDrug_check();
////	   
//	    AddADRreport_My addADRreport_My = mainPage_My.new goTo().addADRreport_My();
//		addADRreport_My.mainFields_FillUpFirstTab();
//	    addADRreport_My.goToSecondTab();
//		addADRreport_My.mainFields_FillUpSecondTab();
//		addADRreport_My.goToFifthTab();
//		addADRreport_My.mainFields_FillUpFifthTab();
//		addADRreport_My.goToSixthTab();
//		addADRreport_My.suspectDrugs_Add();
//		addADRreport_My.addSuspectDrug_Check();
//		addADRreport_My.saveADRreport();
//		// реестр сообщений ПР
//		ADRregistry_My aDRregistry_My = mainPage_My.new goTo().aDRregistry_My();
//		aDRregistry_My.WaitForPageReady();
//		aDRregistry_My.SearchADRreport();
//		aDRregistry_My.WaitForPageReady();
//        aDRregistry_My.FoundADRreport_Check();
//        aDRregistry_My.ADRreport_Delete();
//		StaffAdd staffAdd = mainPage_My.new goTo().staffRegistry_My().clickAddNewSTuffButton();
//		staffAdd.FirstTabPersonal_FillUp();
//		staffAdd.SaveFormeStaff();
//		staffAdd.SecondTabAssignment_FillUp();
//		staffAdd.SecondTabAssignment_Check();
//		staffAdd.SaveFormeStaff();
//		StaffRegistry_My staffRegistry = mainPage_My.new goTo().staffRegistry_My();
//		staffRegistry.SearchStaff();
//		staffRegistry.SearchStaff_Check();
//		EventsRegistry_My eventsRegistry_My = mainPage_My.new goTo().eventsRegistry_My();
//        AddEvent_My addEvent_My = eventsRegistry_My.clickAddNewEventButton();
//		addEvent_My.FirstPartEvents_FillUp();
//		addEvent_My.PopUpParticipantsFromRegistry_FillUp();
//		addEvent_My.PopUpNewParticipants_FillUp();
//		addEvent_My.SecondPartEvents_Check();
//		addEvent_My.saveEvent();
//		eventsRegistry_My = mainPage_My.new goTo().eventsRegistry_My();
//		eventsRegistry_My.SearchEvent();
//		eventsRegistry_My.SearchEvent_Check();
//		eventsRegistry_My.Event_Delete();
//		//		 Добавление ПСУРа
//		PSURregistry_My pSURregistry_My = mainPage_My.new goTo().pSURregistry_My();
//		AddPSUR_My addPSUR_My = pSURregistry_My.clickAddPSURButton();
//		addPSUR_My.PopUpTradeNameFields_FillUp();
//		addPSUR_My.OtherFields_FillUp();
//		addPSUR_My.doc_Add();
//		addPSUR_My.addedDoc_check();
//		
//		addPSUR_My.fileUnload_check();
//		addPSUR_My.SavePSUR();
//		addPSUR_My.TitlePagePSUR_FillUp();
//		addPSUR_My.ContentsAndSummary_FillUP();
//		addPSUR_My.Introduction_FillUp();
//		addPSUR_My.WorldwideAuthorisationStatus_FillUp();
//		addPSUR_My.ActionsTaken_FillUP();
//		addPSUR_My.ChangesSafetyInformation_FillUp();
//		addPSUR_My.EstimatedExposure_FillUp();
//		addPSUR_My.DataInSummaryTabulations_FillUp();
//		addPSUR_My.FindingsFromNonInterventionalStudies_FillUp();
//		addPSUR_My.InformationFromOtherClinicalTrials_FillUp();
//		addPSUR_My.NonClinicalData_FillUp();
//		addPSUR_My.Literature_FillUp();
//		addPSUR_My.OtherPeriodicReports_FillUp();
//		addPSUR_My.LackOfEfficacy_FillUp();
//		addPSUR_My.LateBreakingInformation_FillUp();
//		addPSUR_My.OverviewOfSignals_FillUP();
//		addPSUR_My.SignalAndRiskEvaluation_FillUp();
//		addPSUR_My.BenefitEvaluation_FillUp();
//		addPSUR_My.IntegratedBenefitRisk_FillUp();
//		addPSUR_My.ConclusionsAndActions_FillUp();
//		addPSUR_My.AppendicesToThePSUR_FillUp();
//		addPSUR_My.MappingSignalsAndRisksToPSUR_FillUp();
//		pSURregistry_My= mainPage_My.new goTo().pSURregistry_My();
//		pSURregistry_My.WaitForPageReady();
//		pSURregistry_My.SearchPSUR();
//		pSURregistry_My.WaitForPageReady();
//		pSURregistry_My.FoundPSUR_Check();
//        pSURregistry_My.DocumentsGrid_Check();
//        pSURregistry_My.fileUnload_check();
//        pSURregistry_My.File_Delete();
//        pSURregistry_My.PSUR_Delete();
        MasterFileRegistry_My masterFileRegistry_My = mainPage_My.new goTo().masterFileRegistry_My();
        AddMasterFile_My addMasterFile_My = masterFileRegistry_My.clickAddPSURButton();
        addMasterFile_My.TitlePage_FillUp();
        addMasterFile_My.SectionOnQPPV_FillUP();
        addMasterFile_My.OrganisationalStructure_FillUP();
        addMasterFile_My.SourcesOfSafetyData_FillUp();
        addMasterFile_My.ComputerisedSystemsAndDb_FillUp();
        addMasterFile_My.PharmacovigilanceProcesses_FillUp();
        addMasterFile_My.PharmacovigilanceSystem_FillUp();
        addMasterFile_My.QualitySystem_FillUp();
        
	}
}
