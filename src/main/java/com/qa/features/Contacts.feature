Feature: Free CRM Contact Page Test

@CurrentlyWorking
Scenario: Enter New 5 Contacts
Given User Nevigate to Homepage
Then title of homepage is "CRMPRO"
Then User Moveover to New Contact Page
And Verify New Contact Form
Then User Enter New Contacts and Save