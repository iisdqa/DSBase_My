package com.dsbase.core.web.pages.my;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Link;
import com.dsbase.pages.drugs.my.DrugRegistrationPage_My;

public class MainPage_My extends WebPage<MainPage_My>
{
    private static final String PAGE_URL = BASE_URL; // Можно менять, нужно для прямого редирект

    /*_______________________________ Core _______________________________*/
	public MainPage_My(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public boolean isAvailable(){
			return getAdministrationButton().isAvailable(); // Элемент, который ожидается при загрузке страницы(т.е. можно менять)
	}
		
	@Override
	public MainPage_My load() {
		// TODO Auto-generated method stub
		driver.get(PAGE_URL);
		return null;
	}
	/*_______________________________________________________________________*/	
	
	/*_______________________________ Actions _______________________________*/
	
	public LogInPage_My redirectToLogInPage(){
		load();
		return new LogInPage_My(driver).waitUntilAvailable();
	}
	
	public void waitForPageReady()
	{
		// Ожидание прогрузки страницы
		waitForBlockStatus(getPageDownload(), false);
		simpleWait(1);
	}
	
	public class goTo{
		public DrugRegistryMy drugRegistryMy(){
/*			// hover
			Actions actions = new Actions(driver);
			actions.moveToElement(menuCard_Item()).build().perform();
			simpleWait(1);*/
			
			// js click
			new CustomMethods().new Js_Actions().webElement_Click(driver, getDrugRegistryLink());
			return new DrugRegistryMy(driver).waitUntilAvailable();
		}
		public DrugRegistrationPage_My drugRegistrationPage_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getDrugRegistrationLink());
			return new DrugRegistrationPage_My(driver).waitUntilAvailable();	
		}
			
		
	    
		
	}
	/*_______________________________________________________________________*/				
			
	
	/*_______________________________ Elements _______________________________*/
		
	private Button getAdministrationButton(){
		return new Button(driver, By.xpath("//a[@href='/User']"));
	}

	private WebElement menuCard_Item(){
		return driver.findElement(By.className("home-grid-item"));
	}
	
	private WebElement getDrugRegistryLink(){
		return driver.findElement(By.xpath("//a[@href='/Drugs/List']"));
	}
	private WebElement getDrugRegistrationLink(){
		return driver.findElement(By.xpath("//a[@href='/Drugs/Registration']"));
	}

	private class DictionaryBlock_Elements{
		private WebElement getDictionaryButton(){
		WebElement element = driver.findElement(By.xpath("//span[text() = 'НСИ']"));
		return element;
		}
	}
	// "Завантаження"
		private Custom getPageDownload()
		{
			return new Custom(driver, By.xpath("(//span[@class='span-url'])[1]"));
		}
	
	/*_______________________________________________________________________*/		
}	
			
