package com.dsbase.pages.drugs.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Text;

public class DrugPasspotrPage_My extends WebPage<DrugPasspotrPage_My> {
	private static final String PAGE_URL = BASE_URL + "/Drugs/View/";
	public DrugPasspotrPage_My(WebDriver driver) 
	{
		super(driver);
	}
	@Override
	public DrugPasspotrPage_My load()
	{
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable()
	{
		return getDrugPassportButton().isAvailable();
	}
	/*================================================================ Методы ============================================================*/

	
	
	
	/*============================================== Используемые элементы и действия с ними ==============================================*/

	private Button getDrugPassportButton()
	{
		return new Button(driver, By.id("PasportPreparata"));
	}
	
	private Text getDrugPassport_Title()
	{
		return new Text(driver, By.xpath("//div[@class='content_page table_cell']/h1"));
	}
	
	private Button getDrugEdit_Button()
	{
		return new Button(driver, By.xpath("//input[@type='button' and contains(@onclick, 'EditFirstDrug')]"));
	}
}
