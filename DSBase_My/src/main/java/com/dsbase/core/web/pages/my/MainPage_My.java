package com.dsbase.core.web.pages.my;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsbase.core.web.CommonActions;
import com.dsbase.core.web.CustomMethods;
import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;

import com.dsbase.pages.safety.my.ADRregistry_My;
import com.dsbase.pages.safety.my.AddADRreport_My;
import com.dsbase.pages.safety.my.PSURregistry_My;
import com.dsbase.pages.dcuments.my.MasterFileRegistry_My;
import com.dsbase.pages.drugs.my.DrugRegistrationPage_My;
import com.dsbase.pages.drugs.my.DrugRegistryPage_My;
import com.dsbase.pages.events.my.EventsRegistry_My;
import com.dsbase.pages.staff.StaffAdd;
import com.dsbase.pages.staff.StaffRegistry_My;

public class MainPage_My extends WebPage<MainPage_My>{
    private static final String PAGE_URL = BASE_URL; // ����� ������, ����� ��� ������� ��������

    /*_______________________________ Core _______________________________*/
	public MainPage_My(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public boolean isAvailable(){
			return getLicense_Link().isAvailable(); // �������, ������� ��������� ��� �������� ��������(�.�. ����� ������)
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
		// �������� ��������� ��������
		waitForBlockStatus(getPageDownload(), false);
		simpleWait(1);
	}
	public LogInPage_My userOut(){
		// ����� �� �������
		return new CommonActions().userOut(driver);
	}
	
	public class goTo{
		public DrugRegistryPage_My drugRegistryMy(){
/*			// hover
			Actions actions = new Actions(driver);
			actions.moveToElement(menuCard_Item()).build().perform();
			simpleWait(1);*/
			
			// js click
			new CustomMethods().new Js_Actions().webElement_Click(driver, getDrugRegistryLink());
			return new DrugRegistryPage_My(driver).waitUntilAvailable();
		}
		public DrugRegistrationPage_My drugRegistrationPage_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getDrugRegistrationLink());
			return new DrugRegistrationPage_My(driver).waitUntilAvailable();	
		}

		public StaffAdd customPage(){
			driver.get("http://pais:8500/Staff/0/79");
			simpleWait(2);
			return new StaffAdd(driver).waitUntilAvailable();
		}
		public AddADRreport_My addADRreport_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getAddADRreport_MyLink());
			return new AddADRreport_My(driver).waitUntilAvailable();
		}
		public ADRregistry_My aDRregistry_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getADRregistryLink());
			return new ADRregistry_My(driver).waitUntilAvailable();
		}
		public StaffRegistry_My staffRegistry_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getStaffRegistryLink());
			return new StaffRegistry_My(driver).waitUntilAvailable();  
		}
		public EventsRegistry_My eventsRegistry_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getEventsRegister_Link());
			return new EventsRegistry_My(driver).waitUntilAvailable();
		}
		public PSURregistry_My pSURregistry_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getPSURregistry_Link());
			return new PSURregistry_My(driver).waitUntilAvailable();
		}
		public MasterFileRegistry_My masterFileRegistry_My(){
			new CustomMethods().new Js_Actions().webElement_Click(driver, getMasterFileRegistry_Link());
			return new MasterFileRegistry_My(driver).waitUntilAvailable();
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
	private WebElement getADRregistryLink(){
		return driver.findElement(By.xpath("//a[@href='/AdverseReaction/Search']"));
	}
	private WebElement getStaffRegistryLink(){
		return driver.findElement(By.xpath("//a[@href='/Staff']"));
	}
	private WebElement getAddADRreport_MyLink(){
		return driver.findElement(By.xpath("//a[@href='/AdverseReaction/Create']"));
	}
	private WebElement getEventsRegister_Link(){
		return driver.findElement(By.xpath("//a[@href='/Events']"));
	}
	private WebElement getPSURregistry_Link(){
		return driver.findElement(By.xpath("//a[@href='/Reports']"));
	}
	private WebElement getMasterFileRegistry_Link(){
		return driver.findElement(By.xpath("//a[@href='/MasterFile']"));
	}
	private Custom getLicense_Link(){
		return new Custom(driver, By.xpath("//span[text() = '��������']"));
	}

	private class DictionaryBlock_Elements{
		private WebElement getDictionaryButton(){
		WebElement element = driver.findElement(By.xpath("//span[text() = '���']"));
		return element;
		}
	}
	// "������������"
		private Custom getPageDownload()
		{
			return new Custom(driver, By.xpath("(//span[@class='span-url'])[1]"));
		}
	
	/*_______________________________________________________________________*/		
}	
			
