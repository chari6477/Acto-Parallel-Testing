@Functional 
Feature: Update application Functionality 

	Description: The purpose of this feature is to test the functionality of wrong domain name

@SmokeTest @Second
Scenario: Update the application when update is available 

	Given User is on "Notifications_Popup" page 
	When User clicks "Allow" button 
	Then Verify user is on "App_Update_Available_Popup" update page 
	When User clicks update "Update" button 
	Then Verify user is on "SignIn" page
	And I quit the application