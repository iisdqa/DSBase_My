package com.dsbase.core.web;

import org.openqa.selenium.WebDriver;

import com.dsbase.core.EnvironmentConfiguration;
import com.dsbase.core.YamlEnvironment;
import com.dsbase.core.web.pages.my.MainPage_My;

public abstract class WebPage<T extends WebPage<T>> extends Component<T>
{
	private static final EnvironmentConfiguration CONFIG = EnvironmentConfiguration.getConfig();
	private static final YamlEnvironment ENVIRONMENT = CONFIG.getEnvironmentSettings();
	protected static final String BASE_URL = ENVIRONMENT.scheme + "://" + 
			       						     ENVIRONMENT.host + ":" + 
			       						     ENVIRONMENT.port;
	
	public WebPage(WebDriver driver)
	{
		super(driver);
	}
	
	public abstract T load();
	
	public T loadAndWaitUntilAvailable()
	{
		load();
		return waitUntilAvailable();
	}
	
	// ������� �� ������� ���������
	public MainPage_My backToMainPage()
	{
		return new CommonActions().backToMainPage(driver);
	}
}
