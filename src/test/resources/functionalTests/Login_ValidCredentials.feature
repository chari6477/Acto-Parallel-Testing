@Functional 
Feature: Positive Login Functionality 

	Description: The purpose of this feature is to test the login page with valid credentials

@RegressionTest @SanityTest
Scenario: Login with valid credentials 

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
	When User enter "thomas+2@actoapp.com" in the text field "userName" 
	And User clicks "SignInWithEmail" button 
	And User enter "p" in the text field "password" 
	And User clicks "SignInBtn" button 
	And I quit the application 
	
 