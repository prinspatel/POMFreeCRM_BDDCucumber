package stepDefinition;

import com.qa.pages.ContactsPage;
import com.qa.utils.TestBase;

import io.cucumber.java.en.Then;

public class Contact_StepDefinition extends TestBase{

	
	public Contact_StepDefinition() throws InterruptedException {
		super();
	}
	
	ContactsPage cp=new ContactsPage();

	@Then("User Moveover to New Contact Page")
	public void user_moveover_to_new_contact_page() {
		cp.movetonewcontect();
	}

	@Then("Verify New Contact Form")
	public void verify_new_contact_form() {
		cp.verifynewContactForn();
	}

	
	
	@Then("User Enter New Contacts and Save")
	public void user_enter_new_contacts_and_save() throws InterruptedException {
		cp.AddNewContact();
	}

}
