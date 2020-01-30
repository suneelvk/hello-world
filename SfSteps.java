package org.suneel.stepdefinitions;


import java.util.List;


import org.openqa.selenium.Keys;
import org.suneel.base.TestBase;
import org.suneel.context.ScenarioContext;
import org.suneel.context.TestContext;



import org.suneel.models.CandTSalesforceModel;
import org.suneel.pages.SalesforceHomePage;
import org.suneel.pages.SalesforceLoginPagePOC;
import org.suneel.pages.SalesforceOpportunityPage;
import org.suneel.test.enums.Context;
import org.suneel.test.enums.WaitOppEleName;



import cucumber.api.PendingException;
import cucumber.api.Scenario;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

enum EnumScenarioName {

	RISKALS("Risk A L&S"), RISKANTP("Risk A NTP"), RISKBLS("Risk B L&S"), RISKBNTP("Risk B NTP"), RISKCLS("Risk C L&S"),
	RISKCNTP("Risk C NTP");

	private final String name;

	private EnumScenarioName(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

public class SalesforceSteps {
	TestContext testContext;
	SalesforceLoginPagePOC salesforceLoginPage;
	SalesforceHomePage salesforceHomePage;
	SalesforceOpportunityPage salesforceOpportunityPage;
	ScenarioContext salesforceStepsScenarioContext;

	private Scenario scenario;
	private int scenario_testdata_index;
	List<CandTSalesforceModel> testdata_Test_RiskA_LS;
	List<CandTSalesforceModel> testdata_Test_RiskA_NTP;
	List<CandTSalesforceModel> testdata_Test_RiskB_LS;
	List<CandTSalesforceModel> testdata_Test_RiskB_NTP;
	List<CandTSalesforceModel> testdata_Test_RiskC_LS;
	List<CandTSalesforceModel> testdata_Test_RiskC_NTP;
	List<CandTSalesforceModel> testdata_Test_Contacts;
	List<CandTSalesforceModel> testdata_Test_LogaCall;
	List<CandTSalesforceModel> testdata_Test_CallEmail;
	List<CandTSalesforceModel> testdata_Test_CaseCreation;
	List<CandTSalesforceModel> testdata_Test_CreateAnAccount;
	List<CandTSalesforceModel> testdata_Test_CallPlanReports;
	public static List<CandTSalesforceModel> td_LogaCall;

	public SalesforceSteps(TestContext context) {
		testContext = context;
		salesforceLoginPage = testContext.getPageObjectManager().getSalesforceLoginPage();
		salesforceHomePage = testContext.getPageObjectManager().getSalesforceHomePage();
		salesforceOpportunityPage = testContext.getPageObjectManager().getSalesforceOpportunityPage();

		testdata_Test_RiskA_LS = testContext.getTestObjectManager().setTestDataForTest_RiskA_LS();
		testdata_Test_RiskA_NTP = testContext.getTestObjectManager().setTestDataForTest_RiskA_NTP();

		testdata_Test_RiskB_LS = testContext.getTestObjectManager().setTestDataForTest_RiskB_LS();
		testdata_Test_RiskB_NTP = testContext.getTestObjectManager().setTestDataForTest_RiskB_NTP();

		testdata_Test_RiskC_LS = testContext.getTestObjectManager().setTestDataForTest_RiskC_LS();
		testdata_Test_RiskC_NTP = testContext.getTestObjectManager().setTestDataForTest_RiskC_NTP();

		testdata_Test_Contacts = testContext.getTestObjectManager().setTestDataForTest_Contacts();

		testdata_Test_LogaCall = testContext.getTestObjectManager().setTestDataForTest_LogaCall();
		testdata_Test_CallEmail = testContext.getTestObjectManager().setTestDataForTest_CallEmail();
		testdata_Test_CaseCreation = testContext.getTestObjectManager().setTestDataForTest_CaseCreation();
		testdata_Test_CreateAnAccount = testContext.getTestObjectManager().setTestDataForTest_CreateAnAccount();
		testdata_Test_CallPlanReports = testContext.getTestObjectManager().setTestDataForTest_CallPlanReports();

		salesforceStepsScenarioContext = testContext.getScenarioContext();
	}

	@Before(order = 1)
	public void setUp(Scenario scenario) {

		this.scenario = scenario;
		System.out.println(scenario.getSourceTagNames());
		if(scenario.getSourceTagNames().toString().contains("(")) {
			System.out.println(scenario.getSourceTagNames().toString().substring(scenario.getSourceTagNames().toString().indexOf("(")+1, scenario.getSourceTagNames().toString().indexOf(")")));
		}
		
		// System.out.println("From SalesforceSteps >> @Before
		// "+scenario.getName()+"::::"+scenario.getId());

	}

	@Given("^I am on the login page of  the Salesforce application$")
	public void i_am_on_the_login_page_of_the_Salesforce_application() {
		// salesforceLoginPage.navigatetoLoginPage("https://test.salesforce.com");
		// salesforceLoginPage.navigatetoLoginPage("https://shellcatalysttechnologies--fmuat.my.salesforce.com");
		//salesforceLoginPage.navigatetoLoginPage(TestBase.global_configProperties.get("salesforce_URL"));
		
		if (System.getProperty("SalesForceURL") != null ) {
			salesforceLoginPage.navigatetoLoginPage(System.getProperty("SalesForceURL"));
		}
		else {
			salesforceLoginPage.navigatetoLoginPage(TestBase.global_configProperties.get("salesforce_URL"));
		}

	}

	@When("^valid credentials are  being submitted$")
	public void valid_credentials_are_being_submitted() {
		salesforceLoginPage.loginToSalesforce("harshdeep.kaur@shell.com.ptsc.fmuat", "Shell@123");
//		salesforceLoginPage.loginToSalesforce("v.kalluru@shell.com.ptsc.fmuat", "Welcome@321");
//		salesforceLoginPage.TryVerificationCode("");
	}

	@Then("^I validate the Salesforce home-page appears$")
	public void i_validate_the_Salesforce_home_page_appears() {
		//salesforceHomePage.clickHome_Btn(TestBase.global_configProperties.get("salesforce_URL"));
		
		if (System.getProperty("SalesForceURL") != null ) {
			salesforceLoginPage.navigatetoLoginPage(System.getProperty("SalesForceURL"));
		}
		else {
			salesforceLoginPage.navigatetoLoginPage(TestBase.global_configProperties.get("salesforce_URL"));
		}
		
		
	}

	@Given("^Saleforce home page$")
	public void saleforce_home_page() {
		System.out.println("I am on the home - page");
	}

	@Given("^I will click on Setup$")
	public void i_will_click_on_Setup() {

		salesforceHomePage.clicksetup();
		salesforceHomePage.navigatetoTabOpened();

	}

	@Given("^I am on the Setup - page$")
	public void navigate_to_Setup() {

		salesforceHomePage.navigatetoSetupPage();
		;

	}

	@When("^I get quick find field$")
	public void i_get_quick_find_field() {
		System.out.println("Finding Quick Find - Search Box");
	}

	@Then("^I input \"([^\"]*)\"$")
	public void i_input(String arg1) {
		salesforceHomePage.inputquickfind(arg1);
	}

	@Given("^I click on the \"([^\"]*)\"$")
	public void i_click_on_the(String arg1) {
		salesforceHomePage.clickpermissionsets();
		try {
			Thread.sleep(10000);
			Thread.sleep(10000);
			Thread.sleep(10000);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	@Given("^Permission sets table appears$")
	public void permission_sets_table_appears() {
		System.out.println("Clicking 'C&T Accredited Deal Maker' - link ");

	}

	@And("^I click on Link \"([^\"]*)\"$")
	public void i_click_on_Link(String arg1) {
		salesforceHomePage.clickCTAccreditedDealMaker();

	}

	@Then("^I click on the Link \"([^\"]*)\"$")
	public void i_click_on_the_Link(String arg1) {
		salesforceHomePage.clickmanageassignments();

	}

	@When("^Set Up users table appears$")
	public void set_Up_users_table_appears() {
		System.out.println("Set Up users table appears ");

	}

	@Then("^Find row using name \"([^\"]*)\"$")
	public void find_row_using_name(String arg1) {

		salesforceHomePage.clickAgrawalBharatAfterSwitchToFrame();

	}

	@Then("^Click on Login link in that row$")
	public void click_on_Login_link_in_that_row() {
		System.out.println("Clicked on Login link of AgrawalBharat ");

	}

	@Then("^We login as Bharat Agarwal$")
	public void we_login_as_Bharat_Agarwal() {

		System.out.println("Logged in as AgrawalBharat ");

	}

	@Then("^We check if the newly loggedin user can create an oppurtunity$")
	public void tryNewoppurtunityCreation() {

		System.out
				.println("clicking Oppurtunities - Link to check if the newly loggedin user can create an oppurtunity");

		salesforceHomePage.clickOpportunities();
	}

	@Given("I check if Admin User Home page is loaded")
	public void salesforce_Admin_home_page_appears() {
		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.ADMIN_RECENTRECORDS_LBL,
				TestBase.global_configProperties.get("waituntil"));

		System.out.println("checked if Admin User Home page is loaded");
	}

	@Given("I check if Accredited User Home page is loaded")
	public void salesforce_Accredited_home_page_appears() {
		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.QUARTERLYPERFORMANCE_LBL,
				TestBase.global_configProperties.get("waituntil"));

		System.out.println("checked if Accredited User Home page is loaded");
	}

	// ------------------------------------------
	@Given("^Salesforce home page appears$")
	public void salesforce_home_page_appears() {
		

		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.OPPURTUNITY_LINK,
				TestBase.global_configProperties.get("waituntil"));

		if (salesforceOpportunityPage.CheckOpportunityLinkAppears()) {
			System.out.println("I am on the Home - page");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

		if (salesforceOpportunityPage.CheckOpportunityLinkAppears()) {
			System.out.println("I am on the Home - page");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}
	
	@Given("^I navigate to the respective oppurtunity$")
	public void navigateToOppurtunity() {

		String strUrl =  
		(String) salesforceStepsScenarioContext.getContext(Context.OPPURTUNITY_URL);
		
		salesforceOpportunityPage.navigateToURL(strUrl);

	}
	
	@Given("^I capture the oppurtunity url$")
	public void captureURL() {

		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.PAGELOAD,
				TestBase.global_configProperties.get("waituntil"));

		String strUrl =  salesforceOpportunityPage.getURL();

		salesforceStepsScenarioContext.setContext(Context.OPPURTUNITY_URL, strUrl);

	}

	@Given("^page load completes$")
	public void page_appears() {

		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.PAGELOAD,
				TestBase.global_configProperties.get("waituntil"));

		if (salesforceOpportunityPage.checkPageLoaded()) {
			System.out.println("page has loaded");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

		if (salesforceOpportunityPage.checkPageLoaded()) {
			System.out.println("page has loaded");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}

	@When("^I click on Call Plan/Report link$")
	public void i_click_on_Call_Plan_Report_link() {

		salesforceOpportunityPage.clickCallPlanReport_link();
	}

	@Then("^Call Plan/ Report window appears$")
	public void call_Plan_Report_window_appears() {

		salesforceOpportunityPage.CallPlanReport_WindowAppears();
		System.out.println("Call Plan Report Page appears");

	}

	@Then("^New call plan/report window appears$")
	public void new_call_plan_report_window_appears() {

		salesforceOpportunityPage.NewCallPlanReport_DialogueWindowAppears();
		System.out.println("New call plan/report dialogue window appears");

	}

	@Then("^I input \"([^\"]*)\" in cal plan/report name$")
	public void i_input_in_cal_plan_report_name(String arg1) {

		arg1 = testdata_Test_LogaCall.get(0).stropportunityName;

		salesforceOpportunityPage.inputCallPlanReportName(arg1);
	}

	@When("^I click on Opportunity$")
	public void i_click_on_Opportunity() {
		salesforceOpportunityPage.clickOpportunity();

	}

	@When("^I click on Opportunity again$")
	public void i_click_on_Opportunity_again() {

		try {
			Thread.sleep(10000);

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickOpportunity();

		try {
			Thread.sleep(700);
			Thread.sleep(700);

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("^Oppotunity list appears$")
	public void oppotunity_list_appears() {
		System.out.println("I am on the Oppurtunities - page");

	}

	@Then("^Opportunity list appears$")
	public void opportunity_list_appears() {
		System.out.println("I am on the Oppurtunities - page");
	}

	@Then("^I click on Risk B L&S Demo link$")
	public void i_click_on_Risk_B_L_S_Demo_link() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickRiskBLS_link();
		
	}

	@Then("^I click on Risk C non third party link$")
	public void i_click_on_Risk_C_non_third_party_link() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		String arg1 = testdata_Test_RiskC_NTP.get(0).stropportunityName;
		salesforceOpportunityPage.clickRiskCnonThirdParty_link(arg1);
		// salesforceOpportunityPage.clickRiskCnonThirdParty_link();

		try {
			Thread.sleep(1000);
			Thread.sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	}

	@Then("^I click on Risk B non third party link$")
	public void i_click_on_Risk_B_non_third_party_link() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		String arg1 = testdata_Test_RiskB_NTP.get(0).stropportunityName;
		salesforceOpportunityPage.clickRiskCnonThirdParty_link(arg1);
		// salesforceOpportunityPage.clickRiskBnonThirdParty_link();

		try {
			Thread.sleep(1000);
			Thread.sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	}

	@Then("^I click on Risk A L&S Demo link$")
	public void i_click_on_Risk_A_L_S_Demo_link() {

		try {
			Thread.sleep(500);

		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		String arg1 = testdata_Test_RiskA_LS.get(0).stropportunityName;
		salesforceOpportunityPage.clickRiskALS_link(arg1);
		try {
			Thread.sleep(1000);
			Thread.sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	}

	@Then("^I click on Risk A-non 3rd partyDemo link$")
	public void i_click_on_Risk_A_non_third_Demo_link() {

		try {
			Thread.sleep(500);

		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		String arg1 = testdata_Test_RiskA_NTP.get(0).stropportunityName;

		salesforceOpportunityPage.clickRiskALS_link(arg1);
		
	}

	@Then("^I click on Risk C L&S Demo link table$")
	public void i_click_on_Risk_C_L_S_Demo_link_table() {
		salesforceOpportunityPage.clickRiskCLS_link();

		try {
			Thread.sleep(1000);
			Thread.sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	}

	@Then("^Check if GetContractSigned popup appears and close it$")
	public void closeGetContractSignedPopup() {
		salesforceOpportunityPage.closeGetContractSignedPopup();

	}

	@Then("^I click on the New button$")
	public void i_click_on_New_button() {

		salesforceOpportunityPage.clickNewBtn();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	@Given("^New Opportunity Page$")
	public void new_Opportunity_Page() {

		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.NEW_OPP_WINDOW,
				TestBase.global_configProperties.get("waituntil"));

		System.out.println("I am on the New Opportunity  - Edit Template");

	}

	@Then("^I input \"([^\"]*)\" for Account Name Automation2$")
	public void i_input_for_Account_Name_Automation2(String arg1) {
		// salesforceOpportunityPage.inputAccountName("Automation ");

		// arg1 = testdata_Test_RiskA_LS.get(0).strAccountName.trim();
		/*
		 * if (scenario.getName().contains(EnumScenarioName.RISKALS.getName())) arg1 =
		 * testdata_Test_RiskA_LS.get(0).strAccountName; else if
		 * (scenario.getName().contains(EnumScenarioName.RISKANTP.getName())) arg1 =
		 * testdata_Test_RiskA_NTP.get(0).strAccountName; else if
		 * (scenario.getName().contains(EnumScenarioName.RISKBLS.getName())) arg1 =
		 * testdata_Test_RiskB_LS.get(0).strAccountName; else if
		 * (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName())) arg1 =
		 * testdata_Test_RiskB_NTP.get(0).strAccountName; else if
		 * (scenario.getName().contains(EnumScenarioName.RISKCLS.getName())) arg1 =
		 * testdata_Test_RiskC_LS.get(0).strAccountName; else if
		 * (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName())) arg1 =
		 * testdata_Test_RiskC_NTP.get(0).strAccountName;
		 */

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strAccountName;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strAccountName;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strAccountName;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strAccountName;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strAccountName;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strAccountName;

		salesforceOpportunityPage.inputAccountName(arg1);
		salesforceOpportunityPage.inputAccountName(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputAccountName(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(300);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.inputAccountName(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(500);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		// salesforceOpportunityPage.clickAutomation2();
		salesforceOpportunityPage.clickAutomation2(arg1);

	}



	@Then("^I input \"([^\"]*)\" for Account$")
	public void i_input_for_Account(String arg1) {

		arg1 = testdata_Test_Contacts.get(0).strAccountName;

		salesforceOpportunityPage.inputAccount(arg1);
		salesforceOpportunityPage.inputAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccount(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.inputAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccount(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.inputAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccount(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickAutomation2(arg1);

		

	}

	@Then("^I input \"([^\"]*)\" for Opportunity Name$")
	public void i_input_for_Opportunity_Name(String arg1) {

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).stropportunityName;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).stropportunityName;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).stropportunityName;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).stropportunityName;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).stropportunityName;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).stropportunityName;

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputOpportunityName(arg1);

	}

	@Then("^I input \"([^\"]*)\" for Total Revenue$")
	public void i_input_for_Total_Revenue(String arg1) {

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strTotalRevenue;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strTotalRevenue;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strTotalRevenue;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strTotalRevenue;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strTotalRevenue;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strTotalRevenue;

		salesforceOpportunityPage.inputTotalRevenue(arg1.substring(0, arg1.indexOf(".")));

	}

	@Then("^I select \"([^\"]*)\" from dropdown for Stage$")
	public void i_select_from_dropdown_for_Stage(String arg1) {
		salesforceOpportunityPage.clickStage();

		// arg1 = testdata_Test_RiskA_LS.get(0).strStage;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strStage;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strStage;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strStage;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strStage;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strStage;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strStage;

		salesforceOpportunityPage.clickDiscoverStage(arg1);
	}

	@Then("^I input current date for expected Date of Contract Signature$")
	public void i_input_current_date_for_expected_Date_of_Contract_Signature() {
		salesforceOpportunityPage.clickExpectedDate();
		salesforceOpportunityPage.clickCurrentDate();
	}

	@Then("^I select \"([^\"]*)\" for Opportunity Type$")
	public void i_select_for_Opportunity_Type(String arg1) {
		salesforceOpportunityPage.clickOpportunityType();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strOpportunityType;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strOpportunityType;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strOpportunityType;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strOpportunityType;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strOpportunityType;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strOpportunityType;

		try {
			Thread.sleep(700);
			Thread.sleep(200);

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		// arg1=testdata_Test_RiskA_LS.get(0).strOpportunityType;
		// salesforceOpportunityPage.clickOpportunityType();

		salesforceOpportunityPage.clickLiceningorServices_OpportunityType(arg1);
		// salesforceOpportunityPage.clickOpportunityType();
		// salesforceOpportunityPage.clickLiceningorServices_OpportunityType(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Opportunity Type for RiskA non (\\d+)rd$")
	public void i_select_for_Opportunity_Type_for_RiskA_non_rd(String arg1, int arg2) {
		salesforceOpportunityPage.clickOpportunityType();
		salesforceOpportunityPage.clickNon3rdPartyLicensingampServicesUpstreamampIntegratedGas_OpportunityType();
	}

	@Then("^I input \"([^\"]*)\" for Description$")
	public void i_input_for_Description(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strDescription_Discover;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strDescription_Discover;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strDescription_Discover;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strDescription_Discover;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strDescription_Discover;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strDescription_Discover;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strDescription_Discover;

		salesforceOpportunityPage.inputDescription(arg1);
	}

	@Then("^I click on save button$")
	public void i_click_on_save_button() {

		salesforceOpportunityPage.clickSave();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

//	@Given("^I click on Edit button$")
//	public void i_click_on_Edit_button(){
//	  salesforceOpportunityPage.clickEdit(); 
//	 }

	@Then("^I input \"([^\"]*)\" for Delivery Region$")
	public void i_input_for_Delivery_Region(String arg1) {
		salesforceOpportunityPage.clickDeliveryRegion();

		// arg1 = testdata_Test_RiskA_LS.get(0).strDeliveryRegion;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strDeliveryRegion;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strDeliveryRegion;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strDeliveryRegion;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strDeliveryRegion;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strDeliveryRegion;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strDeliveryRegion;

		salesforceOpportunityPage.clickAmericas_DeliveryRegion(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Catalyst Integrated Opportunity$")
	public void i_select_for_Catalyst_Integrated_Opportunity(String arg1) {
		salesforceOpportunityPage.clickCatalystIntegratedOpportunity();

		// arg1 = testdata_Test_RiskA_LS.get(0).strCatalystIntegratedOpportunity;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCatalystIntegratedOpportunity;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCatalystIntegratedOpportunity;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCatalystIntegratedOpportunity;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCatalystIntegratedOpportunity;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCatalystIntegratedOpportunity;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCatalystIntegratedOpportunity;

		salesforceOpportunityPage.clickYes_CatalystIntegratedOpportunity(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Risk Category$")
	public void i_select_for_Risk_Category(String arg1) {
		salesforceOpportunityPage.clickRiskCategory();

		// arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strRiskCategory;

		salesforceOpportunityPage.clickA_RiskCategory(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Risk Category Edit Risk B$")
	public void i_select_for_Risk_Category_Edit_Risk_B(String arg1) {
		salesforceOpportunityPage.clickRiskCategory();

		// arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strRiskCategory;

		salesforceOpportunityPage.clickB_RiskCategory(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Risk Category C$")
	public void i_select_for_Risk_Category_C(String arg1) {
		salesforceOpportunityPage.clickRiskCategory();

		// arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strRiskCategory;

		salesforceOpportunityPage.clickC_RiskCategory(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Contract Category$")
	public void i_select_for_Contract_Category(String arg1) {
		salesforceOpportunityPage.clickContractCategory();

		// arg1 = testdata_Test_RiskA_LS.get(0).strContractCategory;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strContractCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strContractCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strContractCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strContractCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strContractCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strContractCategory;

		salesforceOpportunityPage.clickCatalystNBD_ContractCategory(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Contract Type$")
	public void i_select_for_Contract_Type(String arg1) {
		salesforceOpportunityPage.clickContractType();
		salesforceOpportunityPage.clickDSLicenseAgreement_ContractType();
	}

	@Then("^I select \"([^\"]*)\" for Contract Type Edit Risk A$")
	public void i_select_for_Contract_Type_Edit_Risk_A(String arg1) {
		salesforceOpportunityPage.clickContractType();
		salesforceOpportunityPage.clickWorkOrder_ContractType();
	}

	@Then("^I select \"([^\"]*)\" for Shell Entity Edit Risk A$")
	public void i_select_for_Shell_Entity_Edit_Risk_A(String arg1) {
		salesforceOpportunityPage.clickShellEntity();
		salesforceOpportunityPage.clickShellGlobalSolutionsIntlBVNL27_ShellEntity();

	}

	@Then("^I select \"([^\"]*)\" for Shell Entity Edit Risk B$")
	public void i_select_for_Shell_Entity_Edit_Risk_B(String arg1) {
		salesforceOpportunityPage.clickShellEntity();
		salesforceOpportunityPage.clickShellGasNigeriaBVNL40_ShellEntity();
	}

	@Then("^I select \"([^\"]*)\" for Contract Sub Type$")
	public void i_select_for_Contract_Sub_Type(String arg1) {
		salesforceOpportunityPage.clickContractSubType();
		salesforceOpportunityPage.clickCrudeDistillerUnit_ContractSubType();
	}

	@Then("^I select \"([^\"]*)\" for Services Mandate$")
	public void i_select_for_Services_Mandate(String arg1) {
		salesforceOpportunityPage.clickServiceMandate();

		// arg1 = testdata_Test_RiskA_LS.get(0).strServicesMandate;

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strServicesMandate;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strServicesMandate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strServicesMandate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strServicesMandate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strServicesMandate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strServicesMandate;

		salesforceOpportunityPage.clickStrategic_ServicesMandate(arg1);
	}

	@Then("^I input current date in Start Date$")
	public void i_input_current_date_in_Start_Date() {
		salesforceOpportunityPage.clickStartDate();
		salesforceOpportunityPage.clickCurrentDate();
	}

	@Then("^I input End Date$")
	public void i_input_End_Date() {
		salesforceOpportunityPage.clickEndDate();
	}

	@Then("^I input \"([^\"]*)\" in Description$")
	public void i_input_in_Description(String arg1) {
		salesforceOpportunityPage.inputDescription_AddCashForecast(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Manpower Hours$")
	public void i_input_for_Manpower_Hours(String arg1) {
		salesforceOpportunityPage.inputManpowerHours(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Manpwer Costs$")
	public void i_input_for_Manpwer_Costs(String arg1) {
		salesforceOpportunityPage.inputManpowerCosts(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Type of Rates$")
	public void i_select_for_Type_of_Rates(String arg1) {
		salesforceOpportunityPage.clickTypeofRates_Dropdown();

	}

	@Then("^I input \"([^\"]*)\" for Travel Expenses$")
	public void i_input_for_Travel_Expenses(String arg1) {
		salesforceOpportunityPage.inputTravelExpenses(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Third Party Cost Expenses$")
	public void i_input_for_Third_Party_Cost_Expenses(String arg1) {
		salesforceOpportunityPage.inputThirdPartyCostExpenses(arg1);
	}

	@Then("^I input \"([^\"]*)\" for IP Fees Edit Risk A$")
	public void i_input_for_IP_Fees_Edit_Risk_A(String arg1) {
		salesforceOpportunityPage.inputIPFees(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Billing Accountant Edit Risk A$")
	public void i_input_for_Billing_Accountant_Edit_Risk_A(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strBillingAccountant;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strBillingAccountant;

		salesforceOpportunityPage.inputBillingAccountant(arg1);

		salesforceOpportunityPage.clickBillingAccountant(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Standard Terms and Conditions Edit Risk A$")
	public void i_select_for_Standard_Terms_and_Conditions_Edit_Risk_A(String arg1) {
		salesforceOpportunityPage.clickStandardTermsConditions();

		// arg1 = testdata_Test_RiskA_LS.get(0).strMovingForwardonStandaloneBasis;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strStandardTermsandConditions;

		salesforceOpportunityPage.clickYes_StandardTermsConditions(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Standard Rates, Fees & Payment Terms$")
	public void i_select_for_Standard_Rates_Fees_Payment_Terms(String arg1) {
		salesforceOpportunityPage.clickStandardRateseesampPaymentTerms();

		// arg1 = testdata_Test_RiskA_LS.get(0).strStandardRatesFeesPaymentTerms;

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strStandardRatesFeesPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strStandardRatesFeesPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strStandardRatesFeesPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strStandardRatesFeesPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strStandardRatesFeesPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strStandardRatesFeesPaymentTerms;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		// salesforceOpportunityPage.clickStandardRateseesampPaymentTerms();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickYes_StandardRateseesampPaymentTerms(arg1);
	}

	@Then("^I select \"([^\"]*)\" for All Design Products, Software, IP in BSP$")
	public void i_select_for_All_Design_Products_Software_IP_in_BSP(String arg1) {
		salesforceOpportunityPage.clickAllDesignProductsSoftwareIPinBSP_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strAllDesignProductsSoftwareIPinBSP;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strAllDesignProductsSoftwareIPinBSP;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strAllDesignProductsSoftwareIPinBSP;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strAllDesignProductsSoftwareIPinBSP;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strAllDesignProductsSoftwareIPinBSP;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strAllDesignProductsSoftwareIPinBSP;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strAllDesignProductsSoftwareIPinBSP;

		salesforceOpportunityPage.clickYes_AllDesignProductsSoftwareIPinBSP(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Lump Sum$")
	public void i_select_for_Lump_Sum(String arg1) {
		salesforceOpportunityPage.clickLumpSum_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strLumpSum;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strLumpSum;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strLumpSum;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strLumpSum;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strLumpSum;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strLumpSum;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strLumpSum;

		salesforceOpportunityPage.clickYes_LumpSum(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Risk Category Edit Risk C$")
	public void i_select_for_Risk_Category_Edit_Risk_C(String arg1) {
		salesforceOpportunityPage.clickRiskCategory();

		// arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strRiskCategory;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strRiskCategory;

		salesforceOpportunityPage.clickC_RiskCategory(arg1);

	}

	@Then("^I input \"([^\"]*)\" for Cal-day X Border Edit Risk A$")
	public void i_input_for_Cal_day_X_Border_Edit_Risk_A(String arg1) {
		salesforceOpportunityPage.inputCalDayXBorder(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Opportunity Advisor Edit Risk A$")
	public void i_input_in_Opportunity_Advisor_Edit_Risk_A(String arg1) {

		salesforceOpportunityPage.scrolltoLegacyID_Label();

		// arg1 = testdata_Test_RiskA_LS.get(0).strOpportunityAdvisor;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strOpportunityAdvisor;

		// salesforceOpportunityPage.inputOpportunityAdvisor(arg1);
		salesforceOpportunityPage.inputOpportunityAdvisor(arg1);
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickOpportunityAdvisor(arg1);
	}

	@Then("^I input \"([^\"]*)\" for General Manager$")
	public void i_input_for_General_Manager(String arg1) {

		salesforceOpportunityPage.scrolltoLegacyID_Label();

		// arg1 = testdata_Test_RiskA_LS.get(0).strGeneralManager;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strGeneralManager;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strGeneralManager;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strGeneralManager;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strGeneralManager;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strGeneralManager;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strGeneralManager;

//		salesforceOpportunityPage.inputGeneralManager_Txtbox(arg1);
//	    try {
//			  Thread.sleep(500);
//		  }catch (InterruptedException e)
//		  
//		  {e.printStackTrace();
//		 }
		salesforceOpportunityPage.inputGeneralManager_Txtbox(arg1);
		salesforceOpportunityPage.inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputGeneralManager_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputGeneralManager_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickGeneralManager(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Legal Advisor$")
	public void i_input_for_Legal_Advisor(String arg1) {

		salesforceOpportunityPage.scrolltoLegacyID_Label();

		// arg1 = testdata_Test_RiskA_LS.get(0).strLegalAdvisor;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strLegalAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strLegalAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strLegalAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strLegalAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strLegalAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strLegalAdvisor;

		// salesforceOpportunityPage.inputLegalAdvisor_Txtbox(arg1);

		salesforceOpportunityPage.inputLegalAdvisor_Txtbox(arg1);
		salesforceOpportunityPage.inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputLegalAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputLegalAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickLegalAdvisor(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Tax Advisor$")
	public void i_input_for_Tax_Advisor(String arg1) {

		salesforceOpportunityPage.scrolltoLegacyID_Label();

		// arg1 = testdata_Test_RiskA_LS.get(0).strTaxAdvisor;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strTaxAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strTaxAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strTaxAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strTaxAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strTaxAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strTaxAdvisor;

		// salesforceOpportunityPage.inputTaxAdvisor_Txtbox(arg1);
		salesforceOpportunityPage.inputTaxAdvisor_Txtbox(arg1);
		salesforceOpportunityPage.inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputTaxAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputTaxAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickTaxAdvisor(arg1);
	}

	@Then("^I click on Save button Edit Risk A$")
	public void i_click_on_Save_button_Edit_Risk_A() {
		salesforceOpportunityPage.clickSave_EditRiskANonThirdParty();

	}

	@Given("^I click on Save button Edit Risk B non third party$")
	public void i_click_on_Save_button_Edit_Risk_B_non_third_party() {
		salesforceOpportunityPage.clickSave_EditRiskBNonThirdParty();
	}

	@Then("^I click on Save button$")
	public void i_click_on_Save_button() {
		salesforceOpportunityPage.clickSaveButton();
	}

	@Given("^I click on Save button for Risk A LS$")
	public void i_click_on_Save_button_for_Risk_A_LS() {
		salesforceOpportunityPage.clickSave_Edit_RiskALS();
	}

	@Given("^I click on Save button Edit Risk C non-Third$")
	public void i_click_on_Save_button_Edit_Risk_C_non_Third() {
		salesforceOpportunityPage.clickSave_EditRiskCnonThirdParty();
	}

	@Given("^I click on Save button for Risk B demo LS$")
	public void i_click_on_Save_button_for_Risk_B_demo_LS() {
		salesforceOpportunityPage.clickSave_Edit_RiskBLS();
	}

	@Given("^I click on Save button for Risk B demo LS again$")
	public void i_click_on_Save_button_for_Risk_B_demo_LS_again() {
		salesforceOpportunityPage.clickSave_Edit_RiskBLS();
	}

	@Given("^I click on Save button for Risk B demo LS again(\\d+)$")
	public void i_click_on_Save_button_for_Risk_B_demo_LS_again(int arg1) {
		salesforceOpportunityPage.clickSave_Edit_RiskBLS();
	}

	@Given("^I click on Save button for Risk C demo LS$")
	public void i_click_on_Save_button_for_Risk_C_demo_LS() {
		salesforceOpportunityPage.clickSave_Edit_RiskCLS();
	}

	@Then("^I click on Save button for Risk C demo LS again$")
	public void i_click_on_Save_button_for_Risk_C_demo_LS_again() {
		salesforceOpportunityPage.clickSave_Edit_RiskCLS();
	}

	@Then("^I click on Save button for Risk C demo LS again(\\d+)$")
	public void i_click_on_Save_button_for_Risk_C_demo_LS_again(int arg1) {
		salesforceOpportunityPage.clickSave_Edit_RiskCLS();
	}

	@When("^I click on Mark Stage as Complete$")
	public void i_click_on() {
		salesforceOpportunityPage.clickMarkStageasComplete();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I click on Edit$")
	public void i_click_on_Edit() {

		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e)
		 * 
		 * { e.printStackTrace(); }
		 */
		salesforceOpportunityPage.clickEdit();
	}

	@Then("^I input \"([^\"]*)\" in Value Hypothesis edit box$")
	public void i_input_in_Value_Hypothesis_edit_box(String arg1) {

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strValueHypothesis;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strValueHypothesis;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strValueHypothesis;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strValueHypothesis;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strValueHypothesis;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strValueHypothesis;

		salesforceOpportunityPage.inputValueHypothesis(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Opportunity Advisor$")
	public void i_input_in_Opportunity_Advisor(String arg1) {
//	  salesforceOpportunityPage.inputOpportunityAdvisor("Pa");
//	  salesforceOpportunityPage.inputOpportunityAdvisor("ul");
//	  salesforceOpportunityPage.inputOpportunityAdvisor("ine Ho");
//	  salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
//	  salesforceOpportunityPage.inputOpportunityAdvisor("o");
//	  salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
//	  salesforceOpportunityPage.inputOpportunityAdvisor("o");

		// salesforceOpportunityPage.clickPaulineHo();
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strOpportunityAdvisor;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strOpportunityAdvisor;

		salesforceOpportunityPage.inputOpportunityAdvisor(arg1);
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		// salesforceOpportunityPage.clickAutomation2();
		salesforceOpportunityPage.clickOpportunityAdvisor(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Estimated Aquisition Cost$")
	public void i_input_in_Estimated_Aquisition_Cost(String arg1) {

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strEstimatedAquisitionCost;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strEstimatedAquisitionCost;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strEstimatedAquisitionCost;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strEstimatedAquisitionCost;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strEstimatedAquisitionCost;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strEstimatedAquisitionCost;

		salesforceOpportunityPage.inputEstimatedAquisitioncost(arg1.substring(0, arg1.indexOf(".")));
	}

	@Then("^I select \"([^\"]*)\" for Response to ITB/RFQ$")
	public void i_select_for_Response_to_ITB_RFQ(String arg1) {
		salesforceOpportunityPage.clickResponsetoITBRFQ();

		arg1 = testdata_Test_RiskA_LS.get(0).strResponsetoITBRFQ;
		salesforceOpportunityPage.Yes_ResponsetoITBRFQ(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Special Tax Considerations$")
	public void i_select_for_Special_Tax_Considerations(String arg1) {
		salesforceOpportunityPage.ClickSpecialtaxcondsideration();

		arg1 = testdata_Test_RiskA_LS.get(0).strResponsetoITBRFQ;
		salesforceOpportunityPage.Yes_ResponsetoITBRFQ(arg1);
	}

	/*
	 * @Then("^I select \"([^\"]*)\" for Special Tax Considerations$") public void
	 * i_select_for_Special_Tax_Considerations(String arg1){
	 * salesforceOpportunityPage }
	 * 
	 * @Then("^I select \"([^\"]*)\" for known issues with customers$") public void
	 * i_select_for_known_issues_with_customers(String arg1){
	 * salesforceOpportunityPage }
	 * 
	 * @Then("^I check Account Trade Controlled$") public void
	 * i_check_Account_Trade_Controlled(){ salesforceOpportunityPage }
	 * 
	 * @Then("^I check End Customer Trade Controlled$") public void
	 * i_check_End_Customer_Trade_Controlled(){ salesforceOpportunityPage }
	 */

	@Then("^I input \"([^\"]*)\" in Go/Get Evidence Comment editbox$")
	public void i_input_in_Go_Get_Evidence_Comment_editbox(String arg1) {
		arg1 = testdata_Test_RiskA_LS.get(0).strGoGetEvidence;
		salesforceOpportunityPage.inputGoGetEvidence(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Value to customer editbox$")
	public void i_input_in_Value_to_customer_editbox(String arg1) {
		arg1 = testdata_Test_RiskA_LS.get(0).strValuetoCustomer;
		salesforceOpportunityPage.inputValuetoCustomer(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Value to Shell Partner$")
	public void i_input_in_Value_to_Shell_Partner(String arg1) {
		arg1 = testdata_Test_RiskA_LS.get(0).strValuetoShellPartner;
		salesforceOpportunityPage.inputValueShellPartner(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Winning Strategy$")
	public void i_input_in_Winning_Strategy(String arg1) {
		arg1 = testdata_Test_RiskA_LS.get(0).strWinningStrategy;
		salesforceOpportunityPage.inputWinningStrategy(arg1);
	}

	@Then("^I press Save button$")
	public void i_press_Save_button() {
		salesforceOpportunityPage.clickSaveButton();
	}

	@Given("^I press Save button for Risk A LS$")
	public void i_press_Save_button_for_Risk_A_LS() {
		salesforceOpportunityPage.clickSave_Edit_RiskALS();
	}

	@Then("^I check for errors in the Edit Dialogue$")
	public void chk_Errors_On_Edit_Dialogue() {
		salesforceOpportunityPage.chkErrorsInEditDialogue();
		;
	}

	@When("^I click on Mark as complete-btn$")
	public void i_click_on_Mark_as_complete() {
		salesforceOpportunityPage.clickMarkStageasComplete();
	}

	@When("^I click on Mark as complete-btn again$")
	public void i_click_on_Mark_as_complete_again() {

		salesforceOpportunityPage.clickMarkStageasComplete();
	}

	@When("^I click on Mark as complete-btn again2$")
	public void i_click_on_Mark_as_complete_again2() {

		salesforceOpportunityPage.clickMarkStageasComplete2();
	}

	@Then("^I click on Edit button$")
	public void i_click_on_Edit_button() {
		try {
			Thread.sleep(500);
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickEdit();
	}

	@Then("^I input \"([^\"]*)\" for Main Delivery Group(\\d+)_Editbox$")
	public void i_input_for_Main_Delivery_Group__Editbox(String arg1, int arg2) {
		arg1 = testdata_Test_RiskA_LS.get(0).strDeliveryGroup1;
		salesforceOpportunityPage.inputMainDeliveryGroup1(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Main Delivery Group(\\d+)_Textbox$")
	public void i_input_for_Main_Delivery_Group__Textbox(String arg1, int arg2) {

		arg1 = testdata_Test_RiskA_LS.get(0).strDeliveryGroup2;
		salesforceOpportunityPage.inputMainDeliveryGroup2(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Main Delivery Group(\\d+)_edit$")
	public void i_input_for_Main_Delivery_Group__edit(String arg1, int arg2) {

		arg1 = testdata_Test_RiskA_LS.get(0).strDeliveryGroup3;
		salesforceOpportunityPage.inputMainDeliveryGroup3(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Main Delivery Group(\\d+)_text$")
	public void i_input_for_Main_Delivery_Group__text(String arg1, int arg2) {

		arg1 = testdata_Test_RiskA_LS.get(0).strDeliveryGroup4;
		salesforceOpportunityPage.inputMainDeliveryGroup4(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Main Delivery Group(\\d+)_edittext$")
	public void i_input_for_Main_Delivery_Group__edittext(String arg1, int arg2) {

		arg1 = testdata_Test_RiskA_LS.get(0).strDeliveryGroup5;
		salesforceOpportunityPage.inputMainDeliveryGroup5(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Cal-day X Border$")
	public void i_input_for_Cal_day_X_Border(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strCaldayXBorder;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCaldayXBorder;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCaldayXBorder;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCaldayXBorder;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCaldayXBorder;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCaldayXBorder;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCaldayXBorder;

		salesforceOpportunityPage.inputCalDayXBorder(arg1.substring(0, arg1.indexOf(".")));
	}

	@Then("^I select \"([^\"]*)\" for Confirmed by Catalyst GM$")
	public void i_select_for_Confirmed_by_Catalyst_GM(String arg1) {
		salesforceOpportunityPage.clickConfirmedByCatGM();

		arg1 = testdata_Test_RiskA_LS.get(0).strConfirmedbyCatalystGM;
		salesforceOpportunityPage.clickNA_ConfirmedByCatGM(arg1);
	}

	@Then("^I select \"([^\"]*)\" Yes for Confirmed by Catalyst GM$")
	public void i_select_for_Confirmed_by_Catalyst_GM_Need_to_make_changes_here(String arg1) {
		salesforceOpportunityPage.clickConfirmedByCatGM();

//	    arg1=testdata_Test_RiskA_LS.get(0).strConfirmedbyCatalystGM;
//	    salesforceOpportunityPage.clickYes_ConfirmedByCatGM(arg1);

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strConfirmedbyCatalystGM;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strConfirmedbyCatalystGM;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strConfirmedbyCatalystGM;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strConfirmedbyCatalystGM;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strConfirmedbyCatalystGM;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strConfirmedbyCatalystGM;

		salesforceOpportunityPage.clickNA_ConfirmedByCatGM(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Shell Entity$")
	public void i_select_for_Shell_Entity(String arg1) {
		salesforceOpportunityPage.clickShellEntity();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strShellEntity;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strShellEntity;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strShellEntity;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strShellEntity;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strShellEntity;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strShellEntity;

		salesforceOpportunityPage.clickShellChinaPTLimitedCN40_ShellEntity(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Expenses$")
	public void i_input_for_Expenses(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strExpenses;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strExpenses;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strExpenses;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strExpenses;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strExpenses;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strExpenses;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strExpenses;

		salesforceOpportunityPage.inputExpenses(arg1.substring(0, arg1.indexOf(".")));
	}

	@Then("^I select \"([^\"]*)\" for Moving Forward on Standalone Basis$")
	public void i_select_for_Moving_Forward_on_Standalone_Basis(String arg1) {
		salesforceOpportunityPage.clickMovingforwardStandaloneBasis();

		// arg1 = testdata_Test_RiskA_LS.get(0).strMovingForwardonStandaloneBasis;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strMovingForwardonStandaloneBasis;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strMovingForwardonStandaloneBasis;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strMovingForwardonStandaloneBasis;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strMovingForwardonStandaloneBasis;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strMovingForwardonStandaloneBasis;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strMovingForwardonStandaloneBasis;

		if (arg1.trim().toLowerCase().contains("yes"))
			salesforceOpportunityPage.clickYes_MovingforwardStandalonBasis();
		else
			salesforceOpportunityPage.clickNo_MovingforwardStandalonBasis();
	}

	@Then("^I select \"([^\"]*)\" for Standard Terms and Conditions$")
	public void i_select_for_Standard_Terms_and_Conditions(String arg1) {
		salesforceOpportunityPage.clickStandardTermsConditions();

		// arg1 = testdata_Test_RiskA_LS.get(0).strStandardTermsandConditions;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strStandardTermsandConditions;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strStandardTermsandConditions;

		// salesforceOpportunityPage.clickYes_StandardTermsConditions(arg1);

		if (arg1.trim().toLowerCase().contains("yes"))
			salesforceOpportunityPage.clickYes_StandardTermsConditions();
		else
			salesforceOpportunityPage.clickNo_StandardTermsConditions();
	}

	@Then("^I input \"([^\"]*)\" for IP Fees$")
	public void i_input_for_IP_Fees(String arg1) {

//		arg1 = testdata_Test_RiskA_LS.get(0).strIPFees;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strIPFees;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strIPFees;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strIPFees;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strIPFees;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strIPFees;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strIPFees;

		salesforceOpportunityPage.inputIPFees(arg1.substring(0, arg1.indexOf(".")));
	}

	@Then("^I input \"([^\"]*)\" for Manpower Costs$")
	public void i_input_for_Manpower_Costs(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strManpowerCosts;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strManpowerCosts;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strManpowerCosts;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strManpowerCosts;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strManpowerCosts;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strManpowerCosts;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strManpowerCosts;

		salesforceOpportunityPage.inputManpowerCosts(arg1.substring(0, arg1.indexOf(".")));
	}

	@Then("^I input \"([^\"]*)\" for Manpower hours$")
	public void i_input_for_Manpower_hours(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strManpowerhours;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strManpowerhours;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strManpowerhours;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strManpowerhours;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strManpowerhours;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strManpowerhours;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strManpowerhours;

		salesforceOpportunityPage.inputManpowerHours(arg1.substring(0, arg1.indexOf(".")));
	}

	@Then("^I input \"([^\"]*)\" for Billing Accountant$")
	public void i_input_for_Billing_Accountant(String arg1) {

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strBillingAccountant;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strBillingAccountant;

		salesforceOpportunityPage.inputBillingAccountant(arg1);

		// arg1 = testdata_Test_RiskA_LS.get(0).strBillingAccountant;
		/*
		 * if (scenario.getName().contains(EnumScenarioName.RISKALS.getName())) arg1 =
		 * testdata_Test_RiskA_LS.get(0).strBillingAccountant;
		 * 
		 * else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
		 * arg1 = testdata_Test_RiskA_NTP.get(0).strBillingAccountant.trim();
		 */

		salesforceOpportunityPage.clickBillingAccountant(arg1);
	}

	@Then("^I check Email Project Setup$")
	public void i_check_Email_Project_Setup() {
		salesforceOpportunityPage.checkmailProjectSetup();
	}

	@Given("^I click on Save_Edit button$")
	public void i_click_on_Save_Edit_button() {
		salesforceOpportunityPage.clickSaveButton();
	}

	@Given("^I click on Save button for Risk ALS$")
	public void i_click_on_Save_button_for_Risk_ALS() {
		salesforceOpportunityPage.clickSave_Edit_RiskALS();
	}

	@Then("^I check for errors in input of the Design Edit Dialogue$")
	public void chk_Errors_On_Design_Edit_Dialogue() {
		salesforceOpportunityPage.chkErrorsInDesignEditDialogue();
	}

	@When("^I click on Add Cash Forecast button$")
	public void i_click_on_Add_Cash_Forecast_button() {
		salesforceOpportunityPage.clickAddCashForcast();
	}

//	@Then("^Add Cash Forecast window appears$")
//	public void add_Cash_Forecast_window_appears(){
//	  salesforceOpportunityPage 
//	 }

	@Then("^I input \"([^\"]*)\" in Revenue Amount editbox$")
	public void i_input_in_Revenue_Amount_editbox(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strRevenueAmount;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strRevenueAmount;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strRevenueAmount;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strRevenueAmount;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strRevenueAmount;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strRevenueAmount;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strRevenueAmount;

		salesforceOpportunityPage.inputRevenueAmount(arg1.substring(0, arg1.indexOf(".")));
	}

	@Then("^I select \"([^\"]*)\" for Month$")
	public void i_select_for_Month(String arg1) {
		salesforceOpportunityPage.clickMonth_AddCashForecast();

		// arg1 = testdata_Test_RiskA_LS.get(0).strMonth;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strMonth;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strMonth;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strMonth;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strMonth;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strMonth;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strMonth;

		salesforceOpportunityPage.clickJanuary_Month_AddCashForecast(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Year$")
	public void i_select_for_Year(String arg1) {
		salesforceOpportunityPage.clickYear_AddCashForecastDropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strYear;

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strYear;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strYear;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strYear;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strYear;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strYear;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strYear;

		salesforceOpportunityPage.clickYear_AddCashForecast(arg1.substring(0, arg1.indexOf(".")));
	}

	@Given("^Then I click on save button$")
	public void then_I_click_on_save_button() {
		salesforceOpportunityPage.clickSaveAddCashForecast();

	}

	@Then("^I input \"([^\"]*)\" for Description textbox$")
	public void i_input_for_Description_textbox(String arg1) {

		// arg1 = testdata_Test_RiskA_LS.get(0).strDescription_AddtoForecast;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strDescription_AddtoForecast;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strDescription_AddtoForecast;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strDescription_AddtoForecast;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strDescription_AddtoForecast;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strDescription_AddtoForecast;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strDescription_AddtoForecast;

		salesforceOpportunityPage.inputDescription_AddCashForecast(arg1);
	}

/// #--------Fill the details for New Opportunity Risk Assessment: Services Risk
	@When("^I click on \"([^\"]*)\" option in Opportunity Risk Assessments - drop menu$")
	public void i_click_on_option_in_Opportunity_Risk_Assessments_drop_menu(String arg1) {

		salesforceOpportunityPage.clickOpportunityRiskAssessments_DropDown();

	}

//	@When("^I click on \"([^\"]*)\" option in Opportunity Risk Assessments$")
//	public void i_click_on_option_in_Opportunity_Risk_Assessments(String arg1)  {
//		try {
//			Thread.sleep(10000);
//			Thread.sleep(10000);
//			Thread.sleep(10000);
//			Thread.sleep(10000);
//		}catch (InterruptedException e)
//		
//		{
//			e.printStackTrace();
//		}
//		
//		salesforceOpportunityPage.clickOpportunityRiskAssessments_ShowMoreAction_Btn();
//		
//	}

	@Then("^\"([^\"]*)\" appears$")
	public void appears(String arg1) {
		System.out.println("New Opportunity Risk Assessment" + "- page appears");
	}

	/*
	 * @When("^I click on drop menu of Opportunity Risk Assessments \\((\\d+)\\)$")
	 * public void i_click_on_drop_menu_of_Opportunity_Risk_Assessments(int arg1){
	 * salesforceOpportunityPage.clickOpportunityRiskAssessments();
	 * 
	 * }
	 * 
	 * @Then("^\"([^\"]*)\" option appears$") public void option_appears(String
	 * arg1){ salesforceOpportunityPage.clickNew_OpportunityRiskAssessments();
	 * 
	 * }
	 */
//
//	@Then("^\"([^\"]*)\" appears$")
//	public void appears(String arg1){
//	  salesforceOpportunityPage 
//	 }

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) {

		salesforceOpportunityPage.clickNext_OpportunityRiskAssessments_Btn();

	}

	@When("^I click on \"([^\"]*)\" depr button$")
	public void i_click_on_depr_button(String arg1) {

		salesforceOpportunityPage.clickNext_OpportunityRiskAssessmentsDepr_Btn();

	}

	@Then("^I select \"([^\"]*)\" for HSSE$")
	public void i_select_for_HSSE(String arg1) {
		salesforceOpportunityPage.selectHSSE_DropDown();
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strHSSE;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strHSSE;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strHSSE;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strHSSE;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strHSSE;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strHSSE;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Compliance$")
	public void i_select_for_Compliance(String arg1) {

		salesforceOpportunityPage.selectCompliance_DropDown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCompliance;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Compliance B$")
	public void i_select_for_Compliance_B(String arg1) {
		salesforceOpportunityPage.selectBCompliance_DropDown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCompliance;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCompliance;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Export Control incl\\. GEC$")
	public void i_select_for_Export_Control_incl_GEC(String arg1) {

		salesforceOpportunityPage.selectExportControlIncGEC_DropDown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strExportControlinclGEC;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strExportControlinclGEC;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strExportControlinclGEC;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strExportControlinclGEC;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strExportControlinclGEC;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strExportControlinclGEC;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Conflict of Interest$")
	public void i_select_for_Conflict_of_Interest(String arg1) {

		salesforceOpportunityPage.selectConflictofInterest_Dropdownn();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strConflictofInterest;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strConflictofInterest;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strConflictofInterest;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strConflictofInterest;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strConflictofInterest;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strConflictofInterest;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Competitively Sensitive Information$")
	public void i_select_for_Competitively_Sensitive_Information(String arg1) {

		salesforceOpportunityPage.selectCompetitivelySensitiveInformation_Dropdown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCompetitivelySensitiveInformation;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCompetitivelySensitiveInformation;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCompetitivelySensitiveInformation;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCompetitivelySensitiveInformation;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCompetitivelySensitiveInformation;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCompetitivelySensitiveInformation;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Anti-bribery and Corruption Risk$")
	public void i_select_for_Anti_bribery_and_Corruption_Risk(String arg1) {

		salesforceOpportunityPage.selectAntiBriberyCorruptionRisk_Dropdown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strAntibriberyandCorruptionRisk;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strAntibriberyandCorruptionRisk;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strAntibriberyandCorruptionRisk;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strAntibriberyandCorruptionRisk;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strAntibriberyandCorruptionRisk;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strAntibriberyandCorruptionRisk;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Delays$")
	public void i_select_for_Delays(String arg1) {

		salesforceOpportunityPage.selectDelays_Dropdown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strDelays;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Delays B$")
	public void i_select_for_Delays_B(String arg1) {
		salesforceOpportunityPage.selectBDelays_Dropdown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strDelays;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strDelays;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for SCope Change$")
	public void i_select_for_SCope_Change(String arg1) {

		salesforceOpportunityPage.selectScopeChange_Dropdown();

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strSCopeChange;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strSCopeChange;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strSCopeChange;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strSCopeChange;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strSCopeChange;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strSCopeChange;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Technical Delivery$")
	public void i_select_for_Technical_Delivery(String arg1) {

		salesforceOpportunityPage.selectTechnicalDelivery_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strTechnicalDelivery;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strTechnicalDelivery;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strTechnicalDelivery;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strTechnicalDelivery;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strTechnicalDelivery;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strTechnicalDelivery;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strTechnicalDelivery;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Catalyst Availability$")
	public void i_select_for_Catalyst_Availability(String arg1) {

		salesforceOpportunityPage.selectCatalystAvailability_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strCatalystAvailability;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCatalystAvailability;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCatalystAvailability;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCatalystAvailability;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCatalystAvailability;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCatalystAvailability;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCatalystAvailability;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Secondment$")
	public void i_select_for_Secondment(String arg1) {
		salesforceOpportunityPage.selectSecondment_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strSecondment;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strSecondment;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Secondment B$")
	public void i_select_for_Secondment_B(String arg1) {
		salesforceOpportunityPage.selectBSecondment_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strSecondment;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strSecondment;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strSecondment;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Visitors to Customer Plant$")
	public void i_select_for_Visitors_to_Customer_Plant(String arg1) {

		salesforceOpportunityPage.selectA_VisitorsToCustomerPlant_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strVisitorstoCustomerPlant;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strVisitorstoCustomerPlant;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strVisitorstoCustomerPlant;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strVisitorstoCustomerPlant;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strVisitorstoCustomerPlant;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strVisitorstoCustomerPlant;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strVisitorstoCustomerPlant;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for PE - Onsite Presence$")
	public void i_select_for_PE_Onsite_Presence(String arg1) {

		salesforceOpportunityPage.selectPEOnsitePresence_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strPEOnsitePresence;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strPEOnsitePresence;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for PE - Onsite Presence B$")
	public void i_select_for_PE_Onsite_Presence_B(String arg1) {
		salesforceOpportunityPage.selectBPEOnsitePresence_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strPEOnsitePresence;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strPEOnsitePresence;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strPEOnsitePresence;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Baseline Data Volatility$")
	public void i_select_for_Baseline_Data_Volatility(String arg1) {

		salesforceOpportunityPage.selectBaselineDataVolatility_Dropdownn();

		// arg1 = testdata_Test_RiskA_LS.get(0).strBaselineDataVolatility;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strBaselineDataVolatility;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strBaselineDataVolatility;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strBaselineDataVolatility;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strBaselineDataVolatility;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strBaselineDataVolatility;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strBaselineDataVolatility;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Freedom of Action$")
	public void i_select_for_Freedom_of_Action(String arg1) {

		salesforceOpportunityPage.selectFreedomOfAction_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strFreedomofAction;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strFreedomofAction;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strFreedomofAction;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strFreedomofAction;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strFreedomofAction;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strFreedomofAction;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strFreedomofAction;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for IP Contamination$")
	public void i_select_for_IP_Contamination(String arg1) {

		salesforceOpportunityPage.selectIPContamination_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strIPContamination;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strIPContamination;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for IP Contamination B$")
	public void i_select_for_IP_Contamination_B(String arg1) {
		salesforceOpportunityPage.selectBIPContamination_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strIPContamination;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strIPContamination;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strIPContamination;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Liability$")
	public void i_select_for_Liability(String arg1) {

		salesforceOpportunityPage.selectLiability_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strLiability;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strLiability;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strLiability;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strLiability;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strLiability;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strLiability;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strLiability;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Indemnity$")
	public void i_select_for_Indemnity(String arg1) {

		salesforceOpportunityPage.selectIndemnity_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strIndemnity;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strIndemnity;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strIndemnity;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strIndemnity;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strIndemnity;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strIndemnity;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strIndemnity;

		salesforceOpportunityPage.selectAHSSE(arg1);
	}

	@Then("^I select \"([^\"]*)\" for Insurance$")
	public void i_select_for_Insurance(String arg1) {

		salesforceOpportunityPage.selectInsurance_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strInsurance;

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strInsurance;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strInsurance;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strInsurance;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strInsurance;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strInsurance;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strInsurance;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Law arbitration$")
	public void i_select_for_Law_arbitration(String arg1) {

		salesforceOpportunityPage.selectLawArbitration_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strLawArbitration;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strLawArbitration;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strLawArbitration;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strLawArbitration;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strLawArbitration;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strLawArbitration;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strLawArbitration;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Force Majeure$")
	public void i_select_for_Force_Majeure(String arg1) {

		salesforceOpportunityPage.selectForceMajeure_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strForceMajeure;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strForceMajeure;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strForceMajeure;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strForceMajeure;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strForceMajeure;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strForceMajeure;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strForceMajeure;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Change Of Onwership$")
	public void i_select_for_Change_Of_Onwership(String arg1) {

		salesforceOpportunityPage.selectChangeofOwnership_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strChangeOfOnwership;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strChangeOfOnwership;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strChangeOfOnwership;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strChangeOfOnwership;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strChangeOfOnwership;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strChangeOfOnwership;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strChangeOfOnwership;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Payment Structure$")
	public void i_select_for_Payment_Structure(String arg1) {

		salesforceOpportunityPage.selectPaymentStructure_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strPaymentStructure;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strPaymentStructure;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strPaymentStructure;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strPaymentStructure;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strPaymentStructure;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strPaymentStructure;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strPaymentStructure;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Payment Terms$")
	public void i_select_for_Payment_Terms(String arg1) {

		salesforceOpportunityPage.selectPaymentTerms_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strPaymentTerms;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strPaymentTerms;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strPaymentTerms;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Late Payment: Interest Rate$")
	public void i_select_for_Late_Payment_Interest_Rate(String arg1) {

		salesforceOpportunityPage.selectLatePaymentInterestRate_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strLatePaymentInterestRate;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strLatePaymentInterestRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strLatePaymentInterestRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strLatePaymentInterestRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strLatePaymentInterestRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strLatePaymentInterestRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strLatePaymentInterestRate;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Deal Customer Credit Check$")
	public void i_select_for_Deal_Customer_Credit_Check(String arg1) {

		salesforceOpportunityPage.selectDealCustomerCreditCheck_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strDealCustomerCreditCheck;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strDealCustomerCreditCheck;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strDealCustomerCreditCheck;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strDealCustomerCreditCheck;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strDealCustomerCreditCheck;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strDealCustomerCreditCheck;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strDealCustomerCreditCheck;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Foreign Exchange Rate$")
	public void i_select_for_Foreign_Exchange_Rate(String arg1) {

		salesforceOpportunityPage.selectForeignExchangeRate_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strForeignExchangeRate;

		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strForeignExchangeRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strForeignExchangeRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strForeignExchangeRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strForeignExchangeRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strForeignExchangeRate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strForeignExchangeRate;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Taxes$")
	public void i_select_for_Taxes(String arg1) {

		salesforceOpportunityPage.selectTaxes_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strTaxes;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strTaxes;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strTaxes;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strTaxes;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strTaxes;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strTaxes;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strTaxes;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Inflation$")
	public void i_select_for_Inflation(String arg1) {

		salesforceOpportunityPage.selectInflation_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strInflation;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strInflation;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strInflation;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strInflation;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strInflation;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strInflation;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strInflation;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Assignment$")
	public void i_select_for_Assignment(String arg1) {

		salesforceOpportunityPage.selectAssignment_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strAssignment;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strAssignment;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strAssignment;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strAssignment;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strAssignment;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strAssignment;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strAssignment;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Provide Bank Guarantee$")
	public void i_select_for_Provide_Bank_Guarantee(String arg1) {

		salesforceOpportunityPage.selectProvideBankGuarantee_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strProvideBankGuarantee;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strProvideBankGuarantee;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strProvideBankGuarantee;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strProvideBankGuarantee;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strProvideBankGuarantee;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strProvideBankGuarantee;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strProvideBankGuarantee;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Audit Rights$")
	public void i_select_for_Audit_Rights(String arg1) {

		salesforceOpportunityPage.selectAuditRights_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strAuditRights;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strAuditRights;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strAuditRights;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strAuditRights;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strAuditRights;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strAuditRights;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strAuditRights;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Agreement Value$")
	public void i_select_for_Agreement_Value(String arg1) {

		salesforceOpportunityPage.selectAgreementValue_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strAgreementValue;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strAgreementValue;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strAgreementValue;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strAgreementValue;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strAgreementValue;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strAgreementValue;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strAgreementValue;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Commercial Rates Inflator$")
	public void i_select_for_Commercial_Rates_Inflator(String arg1) {

		salesforceOpportunityPage.selectCommercialRatesInflator_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strCommercialRatesInflator;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCommercialRatesInflator;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCommercialRatesInflator;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCommercialRatesInflator;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCommercialRatesInflator;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCommercialRatesInflator;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCommercialRatesInflator;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Margin$")
	public void i_select_for_Margin(String arg1) {

		salesforceOpportunityPage.selectMargin_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strMargin;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strMargin;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strMargin;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strMargin;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strMargin;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strMargin;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strMargin;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Margin On Manpower$")
	public void i_select_for_Margin_On_Manpower(String arg1) {

		salesforceOpportunityPage.selectMarginOnManPower_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strMarginOnManpower;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strMarginOnManpower;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strMarginOnManpower;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strMarginOnManpower;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strMarginOnManpower;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strMarginOnManpower;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strMarginOnManpower;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Cash Flow$")
	public void i_select_for_Cash_Flow(String arg1) {

		salesforceOpportunityPage.selectCashFlow_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strCashFlow;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strCashFlow;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strCashFlow;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strCashFlow;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strCashFlow;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strCashFlow;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strCashFlow;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Brand/Reputation$")
	public void i_select_for_Brand_Reputation(String arg1) {

		salesforceOpportunityPage.selectBrandRaputation_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strBrandReputation;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strBrandReputation;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strBrandReputation;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strBrandReputation;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strBrandReputation;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strBrandReputation;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strBrandReputation;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Effective Date$")
	public void i_select_for_Effective_Date(String arg1) {

		salesforceOpportunityPage.selectEffectiveDate_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strEffectiveDate;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strEffectiveDate;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strEffectiveDate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strEffectiveDate;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strEffectiveDate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strEffectiveDate;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strEffectiveDate;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Waranty Guarantees$")
	public void i_select_for_Waranty_Guarantees(String arg1) {

		salesforceOpportunityPage.selectWarantyGuarantees_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strWarantyGuarantees;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strWarantyGuarantees;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strWarantyGuarantees;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strWarantyGuarantees;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strWarantyGuarantees;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strWarantyGuarantees;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strWarantyGuarantees;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Termination$")
	public void i_select_for_Termination(String arg1) {

		salesforceOpportunityPage.selectTermination_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strTermination;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strTermination;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strTermination;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strTermination;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strTermination;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strTermination;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strTermination;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Professional Certification/Registration$")
	public void i_select_for_Professional_Certification_Registration(String arg1) {

		salesforceOpportunityPage.selectProfessionalCertificationRegistration_Dropdown();

		// arg1 =
		// testdata_Test_RiskA_LS.get(0).strProfessionalCertificationRegistration;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strProfessionalCertificationRegistration;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strProfessionalCertificationRegistration;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strProfessionalCertificationRegistration;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strProfessionalCertificationRegistration;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strProfessionalCertificationRegistration;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strProfessionalCertificationRegistration;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I select \"([^\"]*)\" for Relationship Risks$")
	public void i_select_for_Relationship_Risks(String arg1) {

		salesforceOpportunityPage.selectRelationshipRisks_Dropdown();

		// arg1 = testdata_Test_RiskA_LS.get(0).strRelationshipRisks;
		if (scenario.getName().contains(EnumScenarioName.RISKALS.getName()))
			arg1 = testdata_Test_RiskA_LS.get(0).strRelationshipRisks;
		else if (scenario.getName().contains(EnumScenarioName.RISKANTP.getName()))
			arg1 = testdata_Test_RiskA_NTP.get(0).strRelationshipRisks;
		else if (scenario.getName().contains(EnumScenarioName.RISKBLS.getName()))
			arg1 = testdata_Test_RiskB_LS.get(0).strRelationshipRisks;
		else if (scenario.getName().contains(EnumScenarioName.RISKBNTP.getName()))
			arg1 = testdata_Test_RiskB_NTP.get(0).strRelationshipRisks;
		else if (scenario.getName().contains(EnumScenarioName.RISKCLS.getName()))
			arg1 = testdata_Test_RiskC_LS.get(0).strRelationshipRisks;
		else if (scenario.getName().contains(EnumScenarioName.RISKCNTP.getName()))
			arg1 = testdata_Test_RiskC_NTP.get(0).strRelationshipRisks;

		salesforceOpportunityPage.selectAHSSE(arg1);

	}

	@Then("^I input \"([^\"]*)\" for Others$")
	public void i_input_for_Others(String arg1) {

		salesforceOpportunityPage.inputOtherOpportunity_Textbox();
	}

	@Then("^I click on Save button on Line of Business$")
	public void i_click_on_Save_button_on_Line_of_Business() {
		salesforceOpportunityPage.selectSave_Opportunity_Btn();

	}

	@Then("^I click on Save button on Line of Business Depr$")
	public void i_click_on_Save_button_on_Line_of_Business_Depr() {

		// Clicking the Save - Button in OpportunityDepr
		salesforceOpportunityPage.selectSave_OpportunityDepr_Btn();

		// Waiting for home - page to appear
		salesforceOpportunityPage.check_ForHome_Page();

		int tryCount = 0;

		while (salesforceOpportunityPage.checkForOpportunitySpinner()
				&& tryCount < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			tryCount++;
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		String str_CUrl = TestBase.driver.getCurrentUrl();

		TestBase.driver.navigate().to(str_CUrl.substring(0, str_CUrl.indexOf("r/") + 2) + "Opportunity/"
				+ str_CUrl.substring(str_CUrl.indexOf("r/") + 2, str_CUrl.indexOf("/related")) + "/view");

		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.OPPURTUNITY_LINK,
				TestBase.global_configProperties.get("waituntil"));

		salesforceOpportunityPage.waitforElementforInterval(WaitOppEleName.PAGELOAD,
				TestBase.global_configProperties.get("waituntil"));

		// Waiting for home - page to appear
		// Waiting for home - page to appear
		salesforceOpportunityPage.check_ForHome_Page();
		// Waiting for page to load
		salesforceOpportunityPage.checkPageLoaded();

		

	}

	// **************SAVE BUTTON*********************************

	@When("^I click on Submit for Approval$")
	public void i_click_on_Submit_for_Approval() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.submitForApproval_Btn();
	}

	@When("^I click on Submit for Approval again$")
	public void i_click_on_Submit_for_Approval_again() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.submitForApproval_Btn();
	}

	@Then("^Submit for Approval window appears$")
	public void submit_for_Approval_window_appears() {
		salesforceOpportunityPage.SubmitForApproval_WindowAppears();

		// salesforceOpportunityPage.clickSubmitForApproval();

	}

	@Then("^Submit for Approval window appears again$")
	public void submit_for_Approval_window_appears_again() {
		salesforceOpportunityPage.SubmitForApproval_WindowAppears();

//	  salesforceOpportunityPage.clickSubmitForApproval(); 

	}

//
//	@Then("^Submit for Approval window appears$")
//	public void submit_for_Approval_window_appears(){
//	  salesforceOpportunityPage 
//	 }

	@Then("^I click on Submit button$")
	public void i_click_on_Submit_button() {
		;

		salesforceOpportunityPage.submit_SubmitBtnForApproval();

	}

	@Then("^I click on Submit button again$")
	public void i_click_on_Submit_button_again() {

		salesforceOpportunityPage.submit_SubmitBtnForApproval();

	}

	@Then("^I Log out as Bharat Agrawal$")
	public void i_Log_out_as_Bharat_Agrawal() {
		salesforceOpportunityPage.clickLogoutBharatAgrawal();
	}

	@Then("^I refresh the browser$")
	public void then_I_refresh_the_browser() {
		salesforceOpportunityPage.refreshBrowser();
	}

	@Then("^I perform page refresh again$")
	public void i_perform_page_refresh_again() {
		salesforceOpportunityPage.refreshBrowser();
	}

	@Then("^I approve all the approvals required by navigating to Approval History - Window$")
	public void i_Approve_all_under_Approval_History_Window() {

		salesforceOpportunityPage.completeApprovalActivity();
	}

	@Then("^I click on Approve under Approval History$")
	public void i_click_on_Approve_under_Approval_History() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShow4moreaction();
		salesforceOpportunityPage.clickApproveButtton();
	}

	@Then("^I check if Approval History appears$")
	public void check_ApprovalHistoryAppears() {

		if (salesforceOpportunityPage.checkIfApprovalHistoryAppears()) {

		} else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e)

			{
				e.printStackTrace();
			}
		}

		if (salesforceOpportunityPage.checkIfApprovalHistoryAppears()) {

		} else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e)

			{
				e.printStackTrace();
			}
		}
	}

	@Then("^I check if any pending approvals are required$")
	public void check_PendingApprovals() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShow4moreaction();

		int tryCount = 0;

		while (salesforceOpportunityPage.checkPendingApprovals() && tryCount < 4) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e)

			{
				e.printStackTrace();
			}
			// Click on Approve _ Menu
			salesforceOpportunityPage.clickApproveButtton();

			salesforceOpportunityPage.page_load_Wait();

			// Click on Approval - Window
			salesforceOpportunityPage.clickApproveButton();

			salesforceOpportunityPage.page_load_Wait();

			salesforceOpportunityPage.clickShow4moreaction();

			tryCount++;
		}
	}

	@When("^I click on Opportunity Advisor final approval under Approval History$")
	public void i_click_on_Opportunity_Advisor_final_approval_under_Approval_History() {
		salesforceOpportunityPage.clickOpportunityAdvisorfinalApproval();

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@When("^I click on Regional Manager Approval link under Approval History$")
	public void i_click_on_Regional_Manager_Approval_link_under_Approval_History() {
		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRegionalManagerApproval();
	}

	@When("^I click on Regional Manager Approval link under Approval History again$")
	public void i_click_on_Regional_Manager_Approval_link_under_Approval_History_again() {
		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRegionalManagerApproval();
	}

	@When("^I click on Regional Manager GoNo Go approval link under Approval History$")
	public void i_click_on_Regional_Manager_Go_No_Go_approval_link_under_Approval_History() {
		salesforceOpportunityPage.clickRegionalManagerGoNoGoApproval();
	}

	@When("^I click on Sales Review Board Scertary link$")
	public void i_click_on_Sales_Review_Board_Scertary_link() {
		salesforceOpportunityPage.clickSalesReviewBoardSecretary();
	}

	@Then("^I click on Approve button in Opportunity window$")
	public void i_click_on_Approve_button_in_Opportunity_window() {
		salesforceOpportunityPage.clickApproveButton();
	}

	@When("^I click on Approve button for RiskC L&S again$")
	public void i_click_on_Approve_button_for_RiskC_L_S_again() {
		salesforceOpportunityPage.clickApproveRiskCButtton();
	}

	@Then("^Approve Opportunity window appears again(\\d+)$")
	public void approve_Opportunity_window_appears_again(int arg1) {
		salesforceOpportunityPage.ApproveOpportunityWindowAppears();
	}

	@Then("^I input \"([^\"]*)\" in comments edit box again(\\d+)$")
	public void i_input_in_comments_edit_box_again(String arg1, int arg2) {
		salesforceOpportunityPage.inputComments_ApproveOpportunity_Txtbox(arg1);
	}

	@Then("^click on Approve button in Approve Opportunity window again(\\d+)$")
	public void click_on_Approve_button_in_Approve_Opportunity_window_again(int arg1) {
		salesforceOpportunityPage.clickApproveButton();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I perform page refresh$")
	public void i_perform_page_refresh() {
		salesforceOpportunityPage.refreshBrowser();
		try {

			Thread.sleep(1000);
			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I navigate to Permission settings$")
	public void i_navigate_Permission_settings() {

		salesforceOpportunityPage.navigateToPermissionsPage();

		/*
		 * try { Thread.sleep(1000); // Thread.sleep(1000);
		 * 
		 * } catch (InterruptedException e) { e.printStackTrace(); }
		 */
		/*
		 * try {
		 * 
		 * salesforceOpportunityPage.navigateToPermissionsPage();
		 * 
		 * } catch (TimeoutException e)
		 * 
		 * {
		 * 
		 * try {
		 * 
		 * // try refreshing the browser salesforceOpportunityPage.refreshBrowser();
		 * 
		 * } catch (TimeoutException te)
		 * 
		 * { throw te; }
		 * 
		 * 
		 * 
		 * }
		 */

//		try {
//
//			Thread.sleep(1000);
//			Thread.sleep(1000);
//			Thread.sleep(1000);
//
//		} catch (InterruptedException e)
//
//		{
//			e.printStackTrace();
//		}
	}

	@When("^I click on Opportunity Advisor Approval under Approval History$")
	public void i_click_on_Opportunity_Advisor_Approval_under_Approval_History() {

		salesforceOpportunityPage.clickOpportunityAdvisorfinalApproval();
	}

	@When("^I click on Opportunity Advisor Approval Tax Legal under Approval History$")
	public void i_click_on_Opportunity_Advisor_Approval_Tax_Legal_under_Approval_History() {
		salesforceOpportunityPage.clickOpportunityAdvisorApproval();
	}

	@Then("^Test Demo for Risk A L&S tab opens up$")
	public void test_Demo_for_Risk_A_L_S_tab_opens_up() {
		salesforceOpportunityPage.OppurtunityForApprove_PageAppears();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@When("^I click on Approve button for RiskA L&S$")
	public void i_click_on_Approve_button() {

		salesforceOpportunityPage.clickApproveButtton();
	}

	@When("^I click on Approve button for RiskC L&S$")
	public void i_click_on_Approve_button_for_RiskC_L_S() {

		salesforceOpportunityPage.clickApproveRiskCButtton();
	}

	@When("^I click on Approve button for RiskB L&S$")
	public void i_click_on_Approve_button_for_RiskB_L_S() {
		salesforceOpportunityPage.clickApproveRiskBButton();
	}

	@When("^I click on Approve button for RiskA L&S again$")
	public void i_click_on_Approve_button_again() {

		salesforceOpportunityPage.clickApproveButtton();
	}

	@Then("^Approve Opportunity window appears$")
	public void approve_Opportunity_window_appears() {
		salesforceOpportunityPage.ApproveOpportunityWindowAppears();
	}

	@Then("^Approve Opportunity window appears for RiskB$")
	public void approve_Opportunity_window_appears_for_RiskB() {
		salesforceOpportunityPage.ApproveOpportunityWindowAppears();
	}

	@Then("^I Click on second dropdown under Approval History$")
	public void i_Click_on_second_dropdown_under_Approval_History() {
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShow4moreaction();
		salesforceOpportunityPage.clickApproveButtton();
	}

	@Then("^I Click on second dropdown under Approval History again$")
	public void i_Click_on_second_dropdown_under_Approval_History_again() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShow4moreaction();
		salesforceOpportunityPage.clickApproveButtton();
	}

	@Then("^Approve Opportunity window appears again$")
	public void approve_Opportunity_window_appears_again() {
		salesforceOpportunityPage.ApproveOpportunityWindowAppears();
	}

	@Then("^I input \"([^\"]*)\" in comments edit box again$")
	public void i_input_in_comments_edit_box_again(String arg1) {
		salesforceOpportunityPage.inputComments_ApproveOpportunity_Txtbox(arg1);
	}

	@Then("^click on Approve button in Approve Opportunity window again$")
	public void click_on_Approve_button_in_Approve_Opportunity_window_again() {
		salesforceOpportunityPage.clickApproveButton();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

//	@Then("^Test Demo for Risk A L&S tab opens up$")
//	public void test_Demo_for_Risk_A_L_S_tab_opens_up(){
//	  salesforceOpportunityPage 
//	 }

//	@Then("^Approve Opportunity window appears$")
//	public void approve_Opportunity_window_appears(){
//	  salesforceOpportunityPage 
//	 }

	@Then("^I input \"([^\"]*)\" in comments edit box$")
	public void i_input_in_comments_edit_box(String arg1) {
		salesforceOpportunityPage.inputComments_ApproveOpportunity_Txtbox(arg1);

	}

	@Then("^I input \"([^\"]*)\" in comments edit box for RiskB$")
	public void i_input_in_comments_edit_box_for_RiskB(String arg1) {
		salesforceOpportunityPage.inputComments_ApproveOpportunity_Txtbox(arg1);

	}

	@Then("^click on Approve button in Approve Opportunity window$")
	public void click_on_Approve_button_inApproveWindow() {

		salesforceOpportunityPage.clickApproveButton();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^click on Approve button in Approve Opportunity window for RiskB$")
	public void click_on_Approve_button_in_Approve_Opportunity_window_for_RiskB() {

		salesforceOpportunityPage.clickApproveButton();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I Verify if the Oppurtunity is approved$")
	public void verifyOppurtunityApproved() {
		salesforceOpportunityPage.verifyOppurtunityApproved();

	}

	@Then("^I click on Risk B-L&S Demo link under Opportunity Name$")
	public void i_click_on_Risk_B_L_S_Demo_link_under_Opportunity_Name() {

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRiskBLSDemo();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on Risk C L&S Demo link$")
	public void i_click_on_Risk_C_L_S_Demo_link() {
		salesforceOpportunityPage.clickRiskCLS_link();
	}

	@Then("^I click on Risk C-L&S Demo link under Opportunity Name$")
	public void i_click_on_Risk_C_L_S_Demo_link_under_Opportunity_Name() throws Throwable {

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRiskCLS();

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on Risk C-L&S Demo link under Opportunity Name for RiskC$")
	public void i_click_on_Risk_C_L_S_Demo_link_under_Opportunity_Name_for_RiskC() {

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRiskCLS();

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on Risk C-L&S Demo link under Opportunity Name again(\\d+)$")
	public void i_click_on_Risk_C_L_S_Demo_link_under_Opportunity_Name_again(int arg1) {

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRiskCLS();

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on Risk C-L&S Demo link under Opportunity Name again$")
	public void i_click_on_Risk_C_L_S_Demo_link_under_Opportunity_Name_again() {

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRiskCLS();

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on Risk B-L&S Demo link under Opportunity Name for RiskB$")
	public void i_click_on_Risk_B_L_S_Demo_link_under_Opportunity_Name_for_RiskB() {

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickRiskBLSDemo();

		try {

			Thread.sleep(10000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on Risk B-L&S Demo link under Opportunity Name again$")
	public void i_click_on_Risk_B_L_S_Demo_link_under_Opportunity_Name_again() {
		salesforceOpportunityPage.clickRiskBLSDemo();
		;
	}

	@Then("^I click on Test Risk C-L&S$")
	public void i_click_on_Test_Risk_C_L_S() {
		salesforceOpportunityPage.clickRiskCLSDemo();
	}

	@Then("^I click on Risk CL&S Link$")
	public void i_click_on_Risk_CL_S_Link() {
		salesforceOpportunityPage.clickRiskCLS_Link();
	}

	@Then("^I click on \"([^\"]*)\" under Opportunity Name$")
	public void i_click_on_under_Opportunity_Name(String arg1) {
		// salesforceOpportunityPage.refreshBrowser();

		salesforceOpportunityPage.clickRiskAnon3rdpartyDemo();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("^I click on \"([^\"]*)\" Opportunity Name$")
	public void i_click_on_Opportunity_Name(String arg1) {
		salesforceOpportunityPage.clickTestDemoforRiskALS();
	}

	@Then("^I click on Approve under Approval History again$")
	public void i_click_on_Approve_under_Approval_History_again() {
		salesforceOpportunityPage.clickShow4moreaction();
		salesforceOpportunityPage.clickApproveButtton();
	}

	@Then("^I click on Approve button to Approve$")
	public void i_click_on_Approve_Button_to_Approve() {
		salesforceOpportunityPage.clickApproveButtton();
	}

//	@Then("^Then Opportunities tab opens$")
//	public void then_Opportunities_tab_opens(){
//	  salesforceOpportunityPage 
//	 }

	// **************************Case Creation**************************Case
	// Creation***********************************

	@Then("^I click on Cases tab$")
	public void i_click_on_Cases_tab() {
		salesforceOpportunityPage.CheckCasesLinkAppears();
		salesforceOpportunityPage.clickCases();
	}

	@Then("^New Case window appears$")
	public void new_Case_window_appears() {
		salesforceOpportunityPage.CasesWindow();
	}

	@Then("^I select Question for Type$")
	public void i_select_Question_for_Type() {
		salesforceOpportunityPage.selectType();
	}

	@Then("^I select New problem for Case Reason$")
	public void i_select_New_problem_for_Case_Reason() {
		salesforceOpportunityPage.selectCaseReason();
	}

	@Then("^I select Medium for Priority$")
	public void i_select_Medium_for_Priority() {
		salesforceOpportunityPage.selectPriority();

	}

	@Then("^I select New for Status$")
	public void i_select_New_for_Status() {
		salesforceOpportunityPage.selectStatus();
	}

	@Then("^I select Mobile for Category$")
	public void i_select_Mobile_for_Category() {
		salesforceOpportunityPage.selectCategory();
	}

	@Then("^I input \"([^\"]*)\" in Subject$")
	public void i_input_in_Subject(String arg1) {

		arg1 = testdata_Test_CallEmail.get(0).Subject;
		salesforceOpportunityPage.inputSubject(arg1);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("^I input \"([^\"]*)\" in Description for New Case$")
	public void i_input_in_Description_for_New_Case(String arg1) {
		salesforceOpportunityPage.inputDescription_Case(arg1);
	}

	@Then("^I press save button$")
	public void i_press_save_button() {
		salesforceOpportunityPage.clickSave_Case();
	}

	@Given("^I click on Add button$")
	public void i_click_on_Add_button() {
		salesforceOpportunityPage.clickAdd_Case();
	}

	@Then("^I input \"([^\"]*)\" in Name$")
	public void i_input_Disha_Amin_in_Name(String arg1) {

		arg1 = testdata_Test_CaseCreation.get(0).strOpportunityAdvisor;

		salesforceOpportunityPage.inputOpportunityAdvisor(arg1);
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		// salesforceOpportunityPage.clickAutomation2();
		salesforceOpportunityPage.clickOpportunityAdvisor(arg1);

		

	}

	@Then("^I press Save button for case demo$")
	public void i_press_Save_button_for_case_demo() {
		salesforceOpportunityPage.clickSave_CaseDemo_btn();
	}

	@Then("^I click on New Task tab$")
	public void i_click_on_New_Task_tab() {

		salesforceOpportunityPage.clickNewTask_link();
	}

	@Then("^I input \"([^\"]*)\" in Subject New task$")
	public void i_input_in_Subject_New_task(String arg1) {
		salesforceOpportunityPage.inputSubject_NewTask_txtbox(arg1);
	}

	@Then("^I input date in due date field$")
	public void i_input_date_in_due_date_field() {
		salesforceOpportunityPage.clickDueDate_txtbox();
		salesforceOpportunityPage.clickCurrentDate();
	}

	@Then("^I press Save button for case demo again$")
	public void i_press_Save_button_for_case_demo_again() {
		salesforceOpportunityPage.clickSave_CaseDemo_btn();
	}

	@Then("^I click on New Event tab$")
	public void i_click_on_New_Event_tab() {
		salesforceOpportunityPage.clickNewEvent_link();
	}

	/*
	 * @Then("^I input \"([^\"]*)\" in Subject New event$") public void
	 * i_input_in_Subject_New_event(String arg1) {
	 * salesforceOpportunityPage.inputSubject_NewTask_txtbox(arg1); }
	 */
	@Then("^I input \"([^\"]*)\" in Subject New event$")
	public void i_input_in_Subject_New_event(String arg1) {
		salesforceOpportunityPage.inputSubject_NewEvent_txtbox(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Description for New Event$")
	public void i_input_in_Description_for_New_Event(String arg1) {
		salesforceOpportunityPage.inputDescription_Case(arg1);
	}

	@Then("^I input \"([^\"]*)\" in Location$")
	public void i_input_in_Location(String arg1) {
		salesforceOpportunityPage.inputLocation_txtbox(arg1);
	}

	@Then("^I press Save button for case demo again(\\d+)$")
	public void i_press_Save_button_for_case_demo_again(int arg1) {
		// salesforceOpportunityPage.scrollDownSave();
		salesforceOpportunityPage.clickSave_CaseDemo_btn();
	}

	@Then("^I press Post link$")
	public void i_press_Post_link() {
		salesforceOpportunityPage.clickPost_link();
	}

	@Then("^I input \"([^\"]*)\" for Share an update$")
	public void i_input_for_Share_an_update(String arg1) {
		salesforceOpportunityPage.inputShareanUpdate_txtbox(arg1);
	}

	@Then("^I press Share button$")
	public void i_press_Share_button() {
		salesforceOpportunityPage.clickShare_btn();
	}

	@Then("^I click on Close Case tab$")
	public void i_click_on_Close_Case_tab() {
		salesforceOpportunityPage.clickCloseCase_link();
	}

	@Then("^I select On hold for Status$")
	public void i_select_On_hold_for_Status() {
		salesforceOpportunityPage.clickStatus_CaseDemo_Dropdown();
	}

	@Then("^I select In Development for Status$")
	public void i_select_In_Development_for_Status() {
		salesforceOpportunityPage.selectStatus_InDevelopment();
	}

	@Then("^I press Save button for Status case demo$")
	public void i_press_Save_button_for_Status_case_demo() {
		salesforceOpportunityPage.clickSave_CaseDemo_btn();
	}

	@Then("^I select High for Priority$")
	public void i_select_High_for_Priority() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.selectPriority_High();
	}

	@Then("^I press save button again$")
	public void i_press_save_button_again() {
		salesforceOpportunityPage.clickSave_EditCase_btn();
	}

	@Given("^I click on New note button$")
	public void i_click_on_New_note_button() {
		salesforceOpportunityPage.clickNewNote_btn();
	}

	@Then("^I input \"([^\"]*)\" for Untitled Note$")
	public void i_input_for_Untitled_Note(String arg1) {
		salesforceOpportunityPage.inputUntitledNote_txtbox(arg1);
	}

	@Then("^I input \"([^\"]*)\" for Enter a note$")
	public void i_input_for_Enter_a_note(String arg1) {
		salesforceOpportunityPage.inputEnteraNote_txtbox(arg1);
	}

	@Then("^I press Done button$")
	public void i_press_Done_button() {
		salesforceOpportunityPage.clickDone_btn();
	}

	@Given("^I click on Related link$")
	public void i_click_on_Related_link() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickRelated_button();
	}

	@Then("^I click on New button Case$")
	public void i_click_on_New_button_Case() {
		salesforceOpportunityPage.clickNew_button();
	}

	@Then("^New Case comment window appeares$")
	public void new_Case_comment_window_appeares() {
		salesforceOpportunityPage.NewCaseWindow();
	}

	@Then("^I input \"([^\"]*)\" for Body$")
	public void i_input_for_Body(String arg1) {
		salesforceOpportunityPage.inputBody_txtbox(arg1);
	}

	@Then("^I click Save button$")
	public void i_click_Save_button() {
		salesforceOpportunityPage.clickSave_Case();
	}

	@Then("^New Case is saved$")
	public void New_Case_is_saved() {

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		System.out.println("New case saved");

	}

	// ***************Create an
	// Account******************************************************************************************

	@Then("^I click on Accounts tab$")
	public void i_click_on_Accounts_tab() throws Throwable {
		

		salesforceOpportunityPage.clickAccounts_link();
	}

	@Then("^New Accounts window appears$")
	public void new_Accounts_window_appears() {
		System.out.println("New accounts page appear");
	}

	@Then("^I click on Next button$")
	public void i_click_on_Next_button() {
		salesforceOpportunityPage.clickNext_NewAccounts();
	}

	@Then("^I input \"([^\"]*)\" for Account Name(\\d+)$")
	public void i_input_for_Account_Name(String arg1, int arg2) throws Throwable {

		arg1 = testdata_Test_Contacts.get(0).strAccountName;

		salesforceOpportunityPage.inputAccountName2(arg1);
		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputAccountName2(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		

		salesforceOpportunityPage.clickAutomation2(arg1);
		// salesforceOpportunityPage.clickTestAutomationServicesLLC();

		// salesforceOpportunityPage.clickParentAccDropdownElement(arg1);
	}

	@Then("^I input \"([^\"]*)\" for ParentAccount(\\d+)$")
	public void i_input_for_ParentAccount(String arg1, int arg2) throws Throwable {

		arg1 = testdata_Test_CreateAnAccount.get(0).strAccountName;

		salesforceOpportunityPage.inputParentAccount(arg1);
		salesforceOpportunityPage.inputParentAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputParentAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputParentAccount(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputParentAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputParentAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputParentAccount(arg1.substring(arg1.length() - 2, arg1.length()));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.inputParentAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputParentAccount(Keys.BACK_SPACE.toString());
		salesforceOpportunityPage.inputParentAccount(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickTestAutomationServicesLLC2();
		// salesforceOpportunityPage.clickParentAccDropdownElement(arg1);
	}

	@Then("^Account gets created$")
	public void account_gets_created() throws Throwable {

		
		
		
		String arg1 = testdata_Test_CreateAnAccount.get(0).stropportunityName.trim();
		
		salesforceOpportunityPage.checkaccount_gets_created(arg1);
		
		System.out.println("Account got created");
	}

	// **********CALL
	// EMAIL*****************************************************************************************************************************************************************************

	@Given("^I select the call plan generated$")
	public void i_select_the_call_plan_generated() {
		System.out.println("Call Plan selected");
		
		String arg1 = testdata_Test_LogaCall.get(0).stropportunityName.trim();

		salesforceOpportunityPage.checkActivity_CallEmail_Tab(arg1);
	}

	@Then("^I click on activity tab$")
	public void i_click_on_activity_tab() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickActivity_CallEmail_Tab();
	}

	@Then("^I click on Email tab$")
	public void i_click_on_Email_tab() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickEmail_CallEmail_Link();
	}

	@Then("^I click on Write an email\\.\\.\\.$")
	public void i_click_on_Write_an_email() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickWriteAnEmail_Button();
	}

	@Then("^I input \"([^\"]*)\" in To field$")
	public void i_input_in_To_field(String arg1) {

		arg1 = testdata_Test_Contacts.get(0).Email;
		salesforceOpportunityPage.inputTo_Txtbox(arg1);
	}

//	@Then("^I input \"([^\"]*)\" in the textfield$")
//	public void i_input_in_the_textfield(String arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}

	@Then("^I click on Send button$")
	public void i_click_on_Send_button() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickSend_Email_Btn();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("^I click on today dropdown$")
	public void i_click_on_today_dropdown() {

		

		salesforceOpportunityPage.clickToday_Dropdown();
	}

	@Then("^I click on Delete button$")
	public void i_click_on_Delete_button() {
		salesforceOpportunityPage.clickDelete_Today();
	}

	@Then("^Delete Email Message window appears$")
	public void delete_Email_Message_window_appears() {

		try {
			Thread.sleep(400);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		System.out.println("Delete Email Message window appears");

	}

	@Then("^I click on Delete button in window$")
	public void i_click_on_Delete_button_in_window() throws Throwable {
		salesforceOpportunityPage.clickDelete_DeleteEmailMessage_Btn();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^Email is deleted$")
	public void Email_is_deleted() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		System.out.println("Email is deleted");

	}

	// ******NEW
	// CONTACT**************************************************************************************************

	@When("^I click on contacts tab$")
	public void i_click_on_contacts_tab() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickContacts_link();
	}

	@Then("^Contacts window appears$")
	public void contacts_window_appears() {
		salesforceOpportunityPage.Contactwindow();
	}

	@Then("^new contacts window appears$")
	public void new_contacts_window_appears() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.NewContactWindow();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("^I select \"([^\"]*)\" for salutation$")
	public void i_select_for_salutation(String arg1) {
		salesforceOpportunityPage.SelectSalutation();
	}

	@Then("^I input last name$")
	public void i_input_for_last_name() {
		String strLastName = salesforceOpportunityPage.input_LastName();

		salesforceStepsScenarioContext.setContext(Context.CONTACT_NAME, strLastName);
	}

	@Then("^I input Email$")
	public void i_input_for_Email() {
		salesforceOpportunityPage.input_Email();
	}

	@Then("^I click on save button for new contacts$")
	public void i_click_on_save_button_for_new_contacts() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		salesforceOpportunityPage.click_Save_NewContacts();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("^new contact created$")
	public void new_contact_created() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		String strContactName = (String) salesforceStepsScenarioContext.getContext(Context.CONTACT_NAME);

		salesforceOpportunityPage.chec_new_contact_created(strContactName);

	}

	// ************LOG A
	// CALL***************************************************************************************************************8

	@Then("^I click on Log a call tab$")
	public void i_click_on_Log_a_call_tab() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickLogaCall();

	}

	@Then("^I input \"([^\"]*)\" in comments$")
	public void i_input_in_comments(String arg1) {

		arg1 = testdata_Test_Contacts.get(0).strComments_ApproveOpportunity;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.input_Comments_logacall_textarea(arg1);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click save button$")
	public void i_click_save_button() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.click_Save_Logacall_btn();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I click on Edit from drop down$")
	public void i_click_on_Edit_from_drop_down() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShowMoreAction_Btn();
		salesforceOpportunityPage.clickEdit_ShowMoreAction();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I edit Subject by entering \"([^\"]*)\"$")
	public void i_edit_Subject_by_entering(String arg1) {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I click on save button for Edit Call$")
	public void i_click_on_save_button_for_Edit_Call() {

		salesforceOpportunityPage.clickSave_EditCall();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I click on Edit Comments from dropdown$")
	public void i_click_on_Edit_Comments_from_dropdown() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShowMoreAction_Btn();
		salesforceOpportunityPage.clickEditComments_ShowMoreAction();

		try {
			Thread.sleep(400);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I input \"([^\"]*)\" for comments$")
	public void i_input_for_comments(String arg1) {

		arg1 = testdata_Test_Contacts.get(0).strComments_ApproveOpportunity;

		try {
			Thread.sleep(400);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.input_Comments_logacall_textarea(arg1);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I press on save button for Edit Comments$")
	public void i_press_on_save_button_for_Edit_Comments() {

		try {
			Thread.sleep(400);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickSave_EditComments();

		try {
			Thread.sleep(500);
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I click on Change Date from dropdown$")
	public void i_click_on_Change_Date_from_dropdown() {

		try {
			Thread.sleep(400);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShowMoreAction_Btn();
		salesforceOpportunityPage.clickChangeDate_ShowMoreAction();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I input tomorrow's date$")
	public void i_input_tomorrow_s_date() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickDueDate_txtbox();
		salesforceOpportunityPage.clickCurrentDate();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on save button for Change date$")
	public void i_click_on_save_button_for_Change_date() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickSave_ChangeDate();

		try {
			Thread.sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I click on change status from dropdown$")
	public void i_click_on_change_status_from_dropdown() {

		//String arg1 = testdata_Test_Contacts.get(0).Status;

		try {
			Thread.sleep(400);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickShowMoreAction_Btn();
		salesforceOpportunityPage.clickChangeStatus_ShowMoreAction();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I select \"([^\"]*)\" for status$")
	public void i_select_for_status(String arg1) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.selectStatus_ChangeStatus();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on save button for Change status$")
	public void i_click_on_save_button_for_Change_status() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickSave_ChangeStatus();

		try {
			Thread.sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on change priority from drop down$")
	public void i_click_on_change_priority_from_drop_down() {
		salesforceOpportunityPage.clickShowMoreAction_Btn();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickChangePriority_ShowMoreAction();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I select \"([^\"]*)\" for priority$")
	public void i_select_for_priority(String arg1) {

		//String arg11 = testdata_Test_Contacts.get(0).Priority;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.selectPriority_ChangePriority();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I click on save button for change priority$")
	public void i_click_on_save_button_for_change_priority() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityPage.clickSave_ChangePriority();

		try {
			Thread.sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	@Then("^I click on Edit from drop down again$")
	public void i_click_on_Edit_from_drop_down_again() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I check create recurring series of tasks checkbox  \\(facing issue here\\)$")
	public void i_check_create_recurring_series_of_tasks_checkbox_facing_issue_here() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I click on save button for edit call plan/report$")
	public void i_click_on_save_button_for_edit_call_plan_report() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I select delete from dropdown$")
	public void i_select_delete_from_dropdown() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickShowMoreAction_Btn();
		salesforceOpportunityPage.clickDelete_Showmoreactions();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	@Then("^I verify if oppurtunity is in \"([^\"]*)\" Stage$")
	public void i_verify_if_oppurtunity_is_in_Stage(String arg1) {
		salesforceOpportunityPage.assertStage(arg1);
	}

	@Then("^I click on Delete button in delete task window$")
	public void i_click_on_Delete_button_in_delete_task_window() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		salesforceOpportunityPage.clickDelete_DeleteTask();

		try {
			Thread.sleep(700);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

}