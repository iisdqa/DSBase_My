package com.dsbase.pages.dcuments.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.pages.my.LogInPage_My;


public class MasterFileRegistry_My extends WebPage<MasterFileRegistry_My> {
	private static final String PAGE_URL = BASE_URL + "/MasterFile";
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
	public LogInPage_My userOut(){
		// Выход из системы
		return new CommonActions().userOut(driver);
	}
	
	
	//_______________________________________________Elements____________________________________________________________//
	// Кнопка добавления
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, 'Создать новую запись')]"));
	}
}
