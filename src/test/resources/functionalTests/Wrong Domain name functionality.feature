@Functional 
Feature: Domain name wrong Functionality 

	Description: The purpose of this feature is to test the functionality of wrong domain name

@SanityTest
Scenario: Wrong Domain name Functionality 

	Given User is on "Notifications_Popup" page 
	When User clicks "Allow" button 
	Then Verify user is on "App_Update_Available_Popup" update page 
	When User clicks update "NotNow" button 
	Then Verify user is on "Acto_Splash" page 
	When User clicks "LogIn" button 
	Then Verify user is on "Lets_Get_Started" page 
	When User enter "wrongdomain" in the text field "domainName" 
	And User clicks "continueBtn" button 
	Then Verify user is on "OOPS_Page" page 
	When User clicks "DomainWrong_Oops_Ok" button 
	Then Verify user is on "Lets_Get_Started" page 
	And I quit the application 