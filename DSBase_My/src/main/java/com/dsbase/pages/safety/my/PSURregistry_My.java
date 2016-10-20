package com.dsbase.pages.safety.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;



public class PSURregistry_My extends WebPage<PSURregistry_My> {
	private static final String PAGE_URL = BASE_URL + "/Reports";
	public PSURregistry_My(WebDriver driver){
		super (driver);
	}
	@Override
	public  PSURregistry_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable(){
		return getAdd_Button().isAvailable();
	}
	//_______________________________________________Actions_____________________________________________________________//
	public AddPSUR_My clickAddPSURButton(){
		simpleWait(2);
		getAdd_Button().click();
		return new AddPSUR_My(driver).waitUntilAvailable();
	}
	
	
	//_______________________________________________Elements____________________________________________________________//
	// ������ ����������
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, '������� ����� ������')]"));
	}

}
