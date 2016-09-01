package com.dsbase.core.web;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsbase.core.web.elements.Custom;

public abstract class Component <T extends Component<T>>
{
	protected WebDriver driver;
	
	private static final int WAIT_TIMEOUT = 10000;	
	private static final int WAIT_DELAY = 500;
	
	public Component(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public abstract boolean isAvailable();
	
	@SuppressWarnings("unchecked")
	public T waitUntilAvailable()
	{
		return new Wait<T>().forComponent((T) this).toBeAvailable();
	}
	
	// �������� ������������ ��������
	public void waitUntilUnblocked(Custom element)
	{
		// ����������� ����������� ����������
		boolean clickResult = false;
		int timePassed = 0;
		
		// ���� �������� 
		while(!clickResult && (timePassed < WAIT_TIMEOUT))
		{
			try
			{
				element.click();
				clickResult = true;
			}
			catch(Exception e)
			{
				clickResult = false;
			}
			timePassed = timePassed + delay();
		}
		
		if(!clickResult)
		{
			System.err.println("����� �������� ������������� �������� ��������� " + WAIT_TIMEOUT/1000 + "���." +
							   "\r\n �������: " + element.getWebElement().toString());
			Assert.fail();
		}
	}
	
	// �������� ������������� ������� ���������� ��������
	public void waitForBlockStatus(Custom element, boolean ExpectedBlockStatus)
	{
		// ���������� ���������� ��� ��������� ��������� ������� ���������� 
		boolean realBlockStatus = !ExpectedBlockStatus;
		
		// ����������� ����������� ����������
		int timePassed = 0;
		
		// ���� �������� 
		while((ExpectedBlockStatus != realBlockStatus) && (timePassed < WAIT_TIMEOUT))
		{
			// ��������� ����������
			boolean tempBlockStatus = false;
			
			// ���� ��������������, �� ��������� true ��������� ����������
			if(element.getCssValue("display").equals("block"))
			{
				tempBlockStatus = true;
			}
			timePassed = timePassed + delay();
			
			// ��������� �������� ��������� ���������� ��� ���������� ����������
			realBlockStatus = tempBlockStatus;
		}
		
		// ���� ��� �� ��������� ������ != ���������, �� �������� ������
		if(ExpectedBlockStatus != realBlockStatus)
		{
			System.err.println("����� �������� ������������� ��������� ���������� �������� ��������� " + WAIT_TIMEOUT/1000 + "���." +
							   "\r\n �������: " + element.getWebElement().toString() + 
							   "\r\n ��������� ��������� ����������: " + ExpectedBlockStatus + 
							   "\r\n �������� ��������� ����������: " + realBlockStatus);
			Assert.fail();
		}
	}
	
	public void simpleWait(int Seconds)
	{
		try
		{
			Thread.sleep(Seconds * 1000);
		}
		catch(InterruptedException e){throw new RuntimeException(e);}
	}
	
	private int delay()
	{
		try
		{
			Thread.sleep(WAIT_DELAY); 
			return WAIT_DELAY;
		}
		catch(InterruptedException e){throw new RuntimeException(e);}
	}
}
