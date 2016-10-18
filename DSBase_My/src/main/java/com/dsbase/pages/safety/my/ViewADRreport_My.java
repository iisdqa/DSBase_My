package com.dsbase.pages.safety.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;


public class ViewADRreport_My extends WebPage<ViewADRreport_My>{
	private static final String PAGE_URL = BASE_URL + "/AdverseReaction/Create";
	
	public ViewADRreport_My(WebDriver driver) {
		super(driver);
	}

	@Override
	public ViewADRreport_My load(){
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable(){
	return new MainElements().getEditButton().isAvailable();
	}
/*___________________________ Actions ____________________________________________*/	
	public void GetEditADRreport(){
		new MainElements().getEditButton().click();
	}
	public void ExportWordADRreport(){
		new MainElements().getWordButton().click();
	}
	public void ExportPrintForm(){
		new MainElements().getPrintForme().click();
	}
	
/*___________________________ Elements ____________________________________________*/
	private class MainElements{
		// ������ �������������
		private Button getEditButton(){
			return new Button(driver, By.id("edit_btn"));
		}
		
		// ������ ������� � ����
		private Button getWordButton(){
			return new Button(driver, By.id("export_to_word"));
		}
		
		// ������ ������ ����� 
		private Button getPrintForme(){
			return new Button(driver, By.xpath("input[title='������ �����']"));
		}
		
	}
}
	
