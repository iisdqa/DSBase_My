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

public class MainPage_My extends WebPage<MainPage_My>
{
    private static final String PAGE_URL = BASE_URL; // ����� ������, ����� ��� ������� ��������

    /*_______________________________ Core _______________________________*/
	public MainPage_My(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public boolean isAvailable(){
			return getAdministrationButton().isAvailable(); // �������, ������� ��������� ��� �������� ��������(�.�. ����� ������)
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
/*	private Link getDrugRegistryLink(){
		return new Link(driver, By.xpath("//a[@href='/Drugs/List']"));
	}*/

	private class DictionaryBlock_Elements{
		private WebElement getDictionaryButton(){
		WebElement element = driver.findElement(By.xpath("//span[text() = '���']"));
		return element;
		}
	}
	/*_______________________________________________________________________*/		
}	
			
