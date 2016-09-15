package com.dsbase.pages.adr_reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.pages.drugs.my.DrugRegistryPage_My;

public class ADRregistry_My extends WebPage<ADRregistry_My>{
	private static final String PAGE_URL = BASE_URL+ "/AdverseReaction/Search"; // Можно менять, нужно для прямого редирект

    /*_______________________________ Core _______________________________*/
	public ADRregistry_My(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public boolean isAvailable(){
		return getADRreport().isAvailable(); // Элемент, который ожидается при загрузке страницы(т.е. можно менять)
	}
		
	@Override
	public ADRregistry_My load() {
		// TODO Auto-generated method stub
		driver.get(PAGE_URL);
		return null;
	} 
	/*_______________________________ Actions _______________________________*/
	
	
	/*_______________________________ Elements_______________________________*/
	private Button getADRreport(){
		return new Button(driver, By.xpath("//input[@onclick='AddReaction()']"));
	}
	
}
