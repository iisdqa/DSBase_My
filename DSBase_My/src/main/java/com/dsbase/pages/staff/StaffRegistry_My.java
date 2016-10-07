package com.dsbase.pages.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;


public class StaffRegistry_My extends WebPage<StaffRegistry_My> {
	private static final String PAGE_URL = BASE_URL + "/Staff";
	public StaffRegistry_My(WebDriver driver){
		super (driver);
	}
	@Override
	public StaffRegistry_My load(){
		driver.get(PAGE_URL);
		return this;
	}
	@Override
	public boolean isAvailable(){
		return getAdd_Button().isAvailable();
	}
    //_______________________________________________Actions_____________________________________________________________//
	public void WaitForPageReady(){
		waitForBlockStatus(new ADRFiltration_elements().getGridDownload_Div(),false);
        simpleWait(2);	
	}
	//_______________________________________________Elements____________________________________________________________//
	// Кнопка добавления
	private Button getAdd_Button(){
		return new Button(driver, By.xpath("//input[contains(@title, 'Создать новую запись')]"));
	}
	private class ADRFiltration_elements{
		
		private Custom getGridDownload_Div(){
			return new Custom(driver, By.id("load_list_grid"));	
		}
		private Custom	getSearchAccordion(){
			return new Custom(driver, By.id("ui-accordion-accordFilter-header-0"));
		}
	}
}

