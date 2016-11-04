package com.dsbase.pages.dcuments.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;


public class MasterFileRegistry_My extends WebPage<MasterFileRegistry_My> {
	private static final String PAGE_URL = BASE_URL + "/MasterFile/0/61";
	public MasterFileRegistry_My(WebDriver driver){
		super (driver);
	}
	@Override
	public  MasterFileRegistry_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable(){
		return getAdd_Button().isAvailable();
	}
	//_______________________________________________Actions_____________________________________________________________//
	public AddMasterFile_My clickAddPSURButton(){
		simpleWait(2);
		getAdd_Button().click();
		return new AddMasterFile_My(driver).waitUntilAvailable();
	}
	
	
	//_______________________________________________Elements____________________________________________________________//
	// ������ ����������
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, '������� ����� ������')]"));
	}
}
