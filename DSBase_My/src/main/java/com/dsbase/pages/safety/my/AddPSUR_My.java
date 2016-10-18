package com.dsbase.pages.safety.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;


public class AddPSUR_My extends WebPage<AddPSUR_My> {
	private static final String PAGE_URL = BASE_URL + "/Reports/Add";
	public AddPSUR_My(WebDriver driver){
		super (driver);
	}
	@Override
	public AddPSUR_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override 
	public boolean isAvailable() {
		return new DrugPopUp().getButtonOpenDrugPopUp().isAvailable();
	}
	//______________________________________________Actions_______________________________________________________//
	
	
	//______________________________________________Elements_____________________________________________________//
	private class DrugPopUp {
		// кнопка открытия поп-апа
		private Button getButtonOpenDrugPopUp(){
			return new Button(driver, By.id("open_trade_names"));
		}
		private Select getMarketingCountry(){
			return new Select(driver.findElement(By.id("TradeNameControl_Country")));
		}
		
	}

}
