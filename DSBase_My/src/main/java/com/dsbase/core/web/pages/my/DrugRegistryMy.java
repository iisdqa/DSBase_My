package com.dsbase.core.web.pages.my;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.dsbase.core.web.WebPage;
import com.dsbase.core.web.elements.Button;
import com.dsbase.core.web.elements.Custom;
import com.dsbase.core.web.elements.Text;
import com.dsbase.core.web.elements.TextInput;


public class DrugRegistryMy extends WebPage<DrugRegistryMy>
{
    private static final String PAGE_URL = BASE_URL; // Можно менять, нужно для прямого редирект

    /*_______________________________ Core _______________________________*/
	public DrugRegistryMy(WebDriver driver) {
	super(driver);
	}
		
	@Override
	public boolean isAvailable(){
			return getExcelButton().isAvailable(); // Элемент, который ожидается при загрузке страницы(т.е. можно менять)
	}
		
	@Override
	public DrugRegistryMy load() {
		// TODO Auto-generated method stub
		driver.get(PAGE_URL);
		return null;
	} 
	/*_______________________________ Actions _______________________________*/
	
	public void userNameCheck(String expectedUserName){
		// Найти текущее имя пользователя..
		String actualUserName = getUserName().getText();
		
		// Проверка равенства ожидаемого значения и реального значения
		assertThat(actualUserName, is(equalTo(expectedUserName)));
	}
	public void WaitForPageReady(){
		// Ожидание прогрузки грида
		waitForBlockStatus(new filtration_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}
	public void drug_Search()
	{
		// Открыть аккордеон
		new filtration_Elements().getSearch_Accordion().click();
		simpleWait(2);
		
		// Указать название и найти препарат
		new filtration_Elements().getFiltrationValue_Input().inputText("Тестовый препарат");
		new filtration_Elements().getSearch_Button().click();
		simpleWait(2);
		
		waitForBlockStatus(new filtration_Elements().getGridDownload_Div(), false);
		simpleWait(1);
	}
	
	
	
	
	/*_______________________________ Elements _______________________________*/
	private Button getExcelButton(){
		return new Button(driver, By.id("export_report_btn"));
    }
	private Text getUserName(){
		return new Text(driver, By.xpath("//*[@class='log']/span"));
	}
	private class filtration_Elements{
			private Custom getSearch_Accordion()
			{
				return new Custom(driver, By.xpath("//div[@id='accordFilter']/h3"));
			}
			
			private Select getFiltrationName_Select()
			{
				return new Select(driver.findElement(By.xpath("//select[contains(@id, 'name')]")));
			}
			
			private TextInput getFiltrationValue_Input()
			{
				return new TextInput(driver, By.xpath("//input[contains(@id, 'value')]"));
			}
			
			private Button getSearch_Button()
			{
				return new Button(driver, By.id("buttonSearch"));
		    }
			private Custom getGridDownload_Div()
			{
				return new Custom(driver, By.id("load_list_search"));
			}
	}
}


