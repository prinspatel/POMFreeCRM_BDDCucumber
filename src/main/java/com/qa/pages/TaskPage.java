package com.qa.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.TestBase;

public class TaskPage extends TestBase{
	
	public TaskPage() throws InterruptedException {
		super();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Tasks']")
	WebElement tasklnk;
	
	@FindBy(xpath="(//td//em)[2]")
	WebElement tasktext;
	
	@FindBy(xpath="//a[normalize-space()='New Task']")
	WebElement newTask;

	@FindBy(id="title")
	WebElement title;
	
	@FindBy(xpath="//input[@name='prospect_lookup']")
	WebElement Deal;
	
	@FindBy(xpath="//input[@name='case_lookup']")
	WebElement cases;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyadd;
	
	@FindBy(xpath="(//input[@value='Save'])[1]")
	WebElement savebtn;
	
	@FindAll({@FindBy(xpath="//a//i[@title='Delete']")})
	List<WebElement> totaltask;
	
	public void initialPageFactory() {
		PageFactory.initElements(driver, this);
	}
	public void taskPageValidation() throws InterruptedException {
		tasklnk.click();
		Thread.sleep(2000);
		String ActualText = tasktext.getText();
		String ExText = "Showing all tasks";
		Assert.assertEquals(ActualText, ExText);
	}
	
	public void addNewTask(String tit,String del,String cas,String com) throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(tasklnk).build().perform();
		newTask.click();
		Thread.sleep(2000);
		
		
		title.sendKeys(tit);
		Deal.sendKeys(del);
		cases.sendKeys(cas);
		companyadd.sendKeys(com);
		
		savebtn.click();
		
	}
	
	public void verifyaddedtask() {
		tasklnk.click();
		System.out.println(totaltask.size());
		Assert.assertTrue(totaltask.size()>0);
	}
	
	public void delateTask() throws InterruptedException {
		tasklnk.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		for (int i = 1; i <= totaltask.size(); i++) {
			
			String webelemtn = "(//a//i[@title='Delete'])[1]";
			WebElement delate = driver.findElement(By.xpath(webelemtn));
			delate.click();
			 wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		}

		
	}

}
