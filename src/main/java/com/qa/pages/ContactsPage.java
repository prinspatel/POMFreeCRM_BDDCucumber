package com.qa.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.TestBase;
import com.qa.utils.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactLabel;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Contacts')]/../../../../../..//input[@type='checkbox'][1]") })
	public List<WebElement> chechbox;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	public ContactsPage() throws InterruptedException {
		super();
	}

	public void contactlnk() {
		PageFactory.initElements(driver, this);
		contactsLink.click();
	}

	public boolean contactLabelDisplayed() {
		return contactLabel.isDisplayed();
	}

	public void selectCheckbox() throws InterruptedException {
		for (int i = 1; i < chechbox.size(); i++) {
			if (i == 1) {
				System.out.println("1");

				String selectcheckbox = "(//td[contains(text(),'Contacts')]/../../../../../..//input[@type='checkbox'][1])[2]";
				WebElement cbox = driver.findElement(By.xpath(selectcheckbox));
				cbox.click();
				boolean selected = cbox.isSelected();
				Assert.assertTrue(selected);
				break;
			}
		}
	}

	@FindBy(xpath = "//a[normalize-space()='New Contact']")
	WebElement newcontact;

	public void movetonewcontect() {
		PageFactory.initElements(driver, this);
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newcontact.click();
	}

	@FindBy(xpath = "//legend[normalize-space()='Contact Information']")
	WebElement newcontactform;

	public void verifynewContactForn() {
		Assert.assertTrue(newcontactform.getText().contains("Contact "));
	}

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement fsname;

	@FindBy(xpath = "//input[@id='middle_initial']")
	WebElement Mname;

	@FindBy(id = "surname")
	WebElement suname;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement companyname;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement savebtn;

	@FindBy(xpath = "//input[@id='company_position']")
	WebElement possition;

	@FindBy(xpath = "//input[@id='department']")
	WebElement department;

	public void webElementnewcontact(String Title, String FirstName, String MiddleName, String LastName,
			String CompanyName, String Possition, String Deparment) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(Title);

		fsname.sendKeys(FirstName);
		Mname.sendKeys(MiddleName);
		suname.sendKeys(LastName);
		companyname.sendKeys(CompanyName);
		possition.sendKeys(Possition);
		department.sendKeys(Deparment);

		savebtn.click();
		movetonewcontect();

	}

	public void AddNewContact() throws InterruptedException {

		Object[][] testData = TestUtil.getTestData("NewContact");

		for (Object[] data : testData) {

			String Title = (String) data[0];
			String FirstName = (String) data[1];
			String MiddleName = (String) data[2];
			String LastName = (String) data[3];
			String CompanyName = (String) data[4];
			String Possition = (String) data[5];
			String Deparment = (String) data[6];

			webElementnewcontact(Title, FirstName, MiddleName, LastName, CompanyName, Possition, Deparment);

		}

	}

}
