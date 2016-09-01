package com.dsbase.core.web.pages.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.TextInput;
import com.dsbase.core.web.pages.my.MainPage_My;

public class LogInPage_My extends WebPage<LogInPage_My> 
{
	private static final String PAGE_URL = BASE_URL + "/login";
	
	public LogInPage_My(WebDriver driver) 
	{
		super(driver);
	}

	@Override
	public LogInPage_My load()
	{
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable()
	{
		return getUserNameInput().isAvailable() && 
			   getPasswordInput().isAvailable() && 
			   getSubmitButton().isAvailable();
	}

	
	/*_______________________________ Actions _______________________________*/
	
	public MainPage_My logInAs(String UserName, String Password)
	{
		getUserNameInput().inputText(UserName);
		getPasswordInput().inputText(Password);
		getSubmitButton().click();
		return new MainPage_My(driver).waitUntilAvailable();
	}
	/*_______________________________________________________________________*/				
			
	
	/*_______________________________ Elements _______________________________*/
	
	private TextInput getUserNameInput()
	{
		return new TextInput(driver, By.id("UserName"));
	}
		
	private TextInput getPasswordInput()
	{
		return new TextInput(driver, By.id("Password"));
	}
	
	private Button getSubmitButton()
	{
		return new Button(driver, By.xpath("//input[@type='submit' and @value='Войти']"));
	}
	
	/*_______________________________________________________________________*/	
}

