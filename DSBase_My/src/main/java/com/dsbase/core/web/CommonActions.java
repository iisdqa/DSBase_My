package com.dsbase.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Link;
import com.dsbase.core.web.elements.TextInput;
import com.dsbase.core.web.pages.my.LogInPage_My;
import com.dsbase.core.web.pages.my.MainPage_My;

public class CommonActions {
	public LogInPage_My userOut(WebDriver driver) {
		new Elements().getUserOutButton(driver).click();
		return new LogInPage_My(driver).waitUntilAvailable();
	}

	public void autoCompleteValue_Set(WebDriver driver, TextInput element, int downSteps_Count) {
		try {
			element.click();
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			for (int i = 0; i < downSteps_Count; i++) {
				action.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public MainPage_My backToMainPage(WebDriver driver) {
		new Elements().getBackToMainLink(driver).click();
		return new MainPage_My(driver).waitUntilAvailable();
	}

	private class Elements {
		// Ссылка выхода из системы
		private Button getUserOutButton(WebDriver driver) {
			return new Button(driver, By.xpath("//a[@href='/Account/LogOff']"));
		}

		// Ссылка возврата на главную страничку(В header(е))
		private Link getBackToMainLink(WebDriver driver) {
			return new Link(driver, By.className("header_link"));
		}
	}
}
