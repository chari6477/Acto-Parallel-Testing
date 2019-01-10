@Functional 
Feature: Username wrong Login Functionality 

	Description: The purpose of this feature is to test the login page with invalid username credentials

@SanityTest
Scenario: Wrong Username Login Functionality 

	Given User is on "Notifications_Popup" page 
	When User clicks "Allow" button 
	Then Verify user is on "App_Update_Available_Popup" update page 
	When User clicks update "NotNow" button 
	Then Verify user is on "Acto_Splash" page 
	When User clicks "LogIn" button 
	Then Verify user is on "Lets_Get_Started" page 
	When User enter "apaiva" in the text field "domainName" 
	And User clicks "continueBtn" button 
	Then Verify user is on "SignIn_Page" page 
	When User enter "valuelabsh6@actoapp.com" in the text field "userName" 
	And User clicks "SignInWithEmail" button 
	Then Verify user is on "OOPS_Page" page 
	When User clicks "EmailWrong_Oops_Ok" button 
	Then Verify user is on "SignIn_Page" page 
	And I quit the application 