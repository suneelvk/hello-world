package org.suneel.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.suneel.base.TestBase;
import org.suneel.pageobjects.SalesforceLoginPageControls;
import org.suneel.pageobjects.SalesforceOpportunityControls;
import org.suneel.test.enums.WaitEleName;
import org.suneel.test.enums.WaitOppEleName;
import org.springframework.aop.ThrowsAdvice;
import org.testng.Assert;

import com.google.common.base.Function;

public class SalesforceOpportunityPage {
	WebDriver driver;
	SalesforceOpportunityControls salesforceOpportunityControls;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public SalesforceOpportunityPage(WebDriver driver, SalesforceOpportunityControls salesforceOpportunityControls) {
		this.driver = driver;
		this.salesforceOpportunityControls = salesforceOpportunityControls;
		PageFactory.initElements(driver, this.salesforceOpportunityControls);
	}

	public void refreshBrowser() {

		driver.navigate().refresh();
	}

	public void navigateToPermissionsPage() {

		/*
		 * driver.navigate().to("\r\n" +
		 * "https://shellcatalysttechnologies--fmuat.lightning.force.com/lightning/setup/PermSets/page?address=%2F005%3Fid%3D0PS1t000002O0ze%26ispsg%3D0%26isUserEntityOverride%3D1%26sfdcIFrameOrigin%3Dhttps%253A%252F%252Fshellcatalysttechnologies--fmuat.lightning.force.com%26clc%3D1"
		 * );
		 */
		
		if (System.getProperty("SalesForcePermmissionURL") != null ) {
			this.driver.navigate().to(System.getProperty("SalesForcePermmissionURL"));
		}
		else {
			this.driver.navigate().to(TestBase.global_configProperties.get("salesforcePermissions_URL"));
		}

		//driver.navigate().to(TestBase.global_configProperties.get("salesforcePermissions_URL"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (salesforceOpportunityControls.AuthenticateSubmit_Btn.isDisplayed())
				salesforceOpportunityControls.AuthenticateSubmit_Btn.click();
			; // Shell SSO

		} catch (Exception e) {
		}

		waitforElementforInterval(WaitOppEleName.PERMISSIONSETSFRAME,
				TestBase.global_configProperties.get("waituntil"));

		this.driver.switchTo().frame(salesforceOpportunityControls.PermissionSets_Frame);

	}

	// *************************CASE
	// CREATION**********************************************************************************************

	public boolean CheckCasesLinkAppears() {
		WaitUntilElementAppears(salesforceOpportunityControls.Cases_link, 120, 10, "CaseCreation >> Cases _ link");

		return salesforceOpportunityControls.Cases_link.isDisplayed();

	}

	public void clickCases() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", salesforceOpportunityControls.Cases_link);

	}

	public void CasesWindow() {
		System.out.println("New Cases window appears");
	}

	public void selectType() {
		WaitUntilElementAppears(salesforceOpportunityControls.Type_Dropdown, 120, 10,
				"While	 creating - new case >> Type_Dropdown");

		salesforceOpportunityControls.Type_Dropdown.click();
		salesforceOpportunityControls.Question_Type.click();

	}

	public void selectCaseReason() {
		WaitUntilElementAppears(salesforceOpportunityControls.CaseReason_Dropdown, 120, 10,
				"While Editing - Case Creation >> CaseReason_Dropdown");

		salesforceOpportunityControls.CaseReason_Dropdown.click();
		salesforceOpportunityControls.NewProblem_CaseReason.click();
	}

	public void selectPriority() {
		WaitUntilElementAppears(salesforceOpportunityControls.Priority_Dropdown, 120, 10,
				"While 		 Editing - Case Creation >> Priority_Dropdown");
		salesforceOpportunityControls.Priority_Dropdown.click();
		salesforceOpportunityControls.Medium_Priority.click();
	}

	public void selectPriority_High() {
		WaitUntilElementAppears(salesforceOpportunityControls.Priority_Dropdown, 120, 10,
				"While	 Editing - Case Creation >> Priority_Dropdown");

		salesforceOpportunityControls.Priority_Dropdown.click();
		salesforceOpportunityControls.High_Priority.click();
	}

	public void selectStatus() {
		WaitUntilElementAppears(salesforceOpportunityControls.Status_Dropdown, 120, 10,
				"While	 Editing - Oppurtunity >> Status_Dropdown");
		salesforceOpportunityControls.Status_Dropdown.click();
		salesforceOpportunityControls.New_Status.click();
	}

	public void selectCategory() {
		WaitUntilElementAppears(salesforceOpportunityControls.Category_Dropdown, 120, 10,
				"While	 Editing - Oppurtunity >> Category_Dropdown");
		salesforceOpportunityControls.Category_Dropdown.click();
		salesforceOpportunityControls.Mobile_Category.click();
	}

	/*
	 * public void selectStatus_InDevelopment() { //
	 * salesforceOpportunityControls.Status_OnHold_Dropdown.click();
	 * salesforceOpportunityControls.Status_Dropdown_Default_New.click(); try {
	 * salesforceOpportunityControls.InDevelopment_Status.click(); } catch
	 * (Exception e) { }
	 * 
	 * }
	 */

	public void selectStatus_InDevelopment() {
		// salesforceOpportunityControls.Status_OnHold_Dropdown.click();
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */

		WaitUntilElementAppears(salesforceOpportunityControls.Status_Dropdown_Default_New, 120, 10,
				"While Editing - oppurtunity >> Status_Dropdown");

		salesforceOpportunityControls.Status_Dropdown_Default_New.click();
		try {
			salesforceOpportunityControls.InDevelopment_Status.click();
		} catch (Exception e) {
		}

	}

	public void inputSubject(String arg0) {
		WaitUntilElementAppears(salesforceOpportunityControls.Subject_txtbox, 120, 10,
				"While Editing - oppurtunity >> Subject_txtbox");
		salesforceOpportunityControls.Subject_txtbox.sendKeys(arg0);
	}

	public void inputDescription_Case(String arg0) {
		WaitUntilElementAppears(salesforceOpportunityControls.Description_txtarea, 120, 10,
				"While Editing - oppurtunity >> Description_txtarea");
		salesforceOpportunityControls.Description_txtarea.sendKeys(arg0);
	}

	public void clickSave_Case() {
		WaitUntilElementAppears(salesforceOpportunityControls.Save_btn, 120, 10,
				"While Editing - oppurtunity >> Save_btn");
		salesforceOpportunityControls.Save_btn.click();
	}

	public void clickSave_EditCase_btn() {
		WaitUntilElementAppears(salesforceOpportunityControls.Save_EditCase_btn, 120, 10,
				"While Editing - oppurtunity >> Save_EditCase_btn");
		salesforceOpportunityControls.Save_EditCase_btn.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	public void clickAdd_Case() {

		waitforElementforInterval(WaitOppEleName.CASE_ADD_BTN, TestBase.global_configProperties.get("waituntil"));

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.Add_btn, 120, 10,
		 * "While Editing - oppurtunity >> Add_btn");
		 */
		salesforceOpportunityControls.Add_btn.click();
	}

	public void inputName_txtbox(String arg0) {
		WaitUntilElementAppears(salesforceOpportunityControls.Name_txtbox, 120, 10,
				"While Editing - oppurtunity >> Name_txtbox");
		salesforceOpportunityControls.Name_txtbox.sendKeys(arg0);
		// salesforceOpportunityControls.TestAutomationAccount_Name.click();
	}

	public void clickTestAutomationAccount_Name() {

		salesforceOpportunityControls.TestAutomationAccount_Name.click();
	}

	public void clickSave_CaseDemo_btn() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,60)");

		try {

			// WebElement Save_CaseDemo_btnele=
			// salesforceOpportunityControls.Save_CaseDemo_btn;
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// Save_CaseDemo_btnele);
			// ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)");
			// Thread.sleep(300);
			// salesforceOpportunityControls.Save_CaseDemo_btn.click();

			// salesforceOpportunityControls.Save_CaseDemo_btn.click();
			WebElement ele = salesforceOpportunityControls.Save_CaseDemo_btn;

			new Actions(driver).moveToElement(ele, 0, 0).perform();
			new Actions(driver).moveToElement(ele, 0, 0).moveToElement(ele).click(ele).perform();

		} catch (Exception e) {
			throw e;
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}

	public void scrollDownSave() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WaitUntilElementAppears(salesforceOpportunityControls.Save_CaseDemo_btn, 120, 10,
				"While Editing - oppurtunity >> Save_CaseDemo_btn");

		WebElement ele = salesforceOpportunityControls.Save_CaseDemo_btn;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	/*
	 * public void clickNewTask_link() {
	 * 
	 * try { Thread.sleep(10000); } catch (InterruptedException e)
	 * 
	 * { e.printStackTrace(); } salesforceOpportunityControls.NewTask_link.click();
	 * 
	 * System.out.println("New Tasked clicked"); }
	 */

	public void clickNewTask_link() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 20);");

		waitforElementforInterval(WaitOppEleName.NEWTASK_LINK, TestBase.global_configProperties.get("waituntil"));

		WaitUntilElementAppears(salesforceOpportunityControls.NewTask_link, 120, 10, "NewTask_link");
		salesforceOpportunityControls.NewTask_link.click();

		System.out.println("New Tasked clicked");
	}

	public void inputSubject_NewTask_txtbox(String arg0) {

		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e)
		 */

		/*
		 * { e.printStackTrace(); }
		 */

		WaitUntilElementAppears(salesforceOpportunityControls.Subject_NewTask_txtbox, 120, 10,
				"Subject_NewTask_txtbox");

		try {
			salesforceOpportunityControls.Subject_NewTask_txtbox.sendKeys(arg0);
		} catch (Exception e) {
		}

	}

	public void inputSubject_NewEvent_txtbox(String arg0) {

		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e)
		 * 
		 * { e.printStackTrace(); }
		 */
		WaitUntilElementAppears(salesforceOpportunityControls.Subject_NewEvent_txtbox, 120, 10,
				"Subject_NewEvent_txtbox");
		salesforceOpportunityControls.Subject_NewEvent_txtbox.sendKeys(arg0);

	}

	public void clickDueDate_txtbox() {

		waitForEditDateWindow();

		WaitUntilElementAppears(salesforceOpportunityControls.DueDate_txtbox, 120, 10, "DueDate_txtbox");

		salesforceOpportunityControls.DueDate_txtbox.click();
	}

	public void clickNewEvent_link() {

		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e)
		 * 
		 * { e.printStackTrace(); }
		 */
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 20);");

		waitforElementforInterval(WaitOppEleName.NEWEVENT_LINK, TestBase.global_configProperties.get("waituntil"));

		WaitUntilElementAppears(salesforceOpportunityControls.NewEvent_link, 120, 10, "NewEvent_link");
		salesforceOpportunityControls.NewEvent_link.click();
		System.out.println("New Event tab appears");
	}

	public void inputLocation_txtbox(String arg0) {
		salesforceOpportunityControls.Location_txtbox.sendKeys(arg0);

	}

	public void clickPost_link() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		waitforElementforInterval(WaitOppEleName.POST_LINK, TestBase.global_configProperties.get("waituntil"));

		WaitUntilElementAppears(salesforceOpportunityControls.Post_link, 120, 10, "Post_link");

		salesforceOpportunityControls.Post_link.click();
		System.out.println("Post tab appears");

	}

	public void inputShareanUpdate_txtbox(String arg0) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,120)");

		WaitUntilElementAppears(salesforceOpportunityControls.ShareanUpdate_txtbox, 120, 10, "ShareanUpdate_txtbox");
		salesforceOpportunityControls.ShareanUpdate_txtbox.click();
		salesforceOpportunityControls.ShareanUpdate_txtbox.sendKeys(arg0);

	}

	public void clickShare_btn() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WaitUntilElementAppears(salesforceOpportunityControls.Share_btn, 120, 10, "Share_btn");
		// WebElement ele= salesforceOpportunityControls.Share_btn;
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// salesforceOpportunityControls.Share_btn);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,120)");
		salesforceOpportunityControls.Share_btn.click();
	}

	public void clickCloseCase_link() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

		WaitUntilElementAppears(salesforceOpportunityControls.CloseCase_link, 120, 10, "CloseCase_link");

		salesforceOpportunityControls.CloseCase_link.click();
	}

	public void clickStatus_CaseDemo_Dropdown() {

		salesforceOpportunityControls.Status_CaseDemo_Dropdown.click();
		salesforceOpportunityControls.OnHold_Status.click();
	}

	public void clickNewNote_btn() {

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		WaitUntilElementAppears(salesforceOpportunityControls.NewNote_btn, 300, 10, "NewNote_btn");

		salesforceOpportunityControls.NewNote_btn.click();

		System.out.println("New Note clicked");

	}

	public void inputUntitledNote_txtbox(String arg0) {

		WaitUntilElementAppears(salesforceOpportunityControls.UntitledNote_txtbox, 120, 10, "UntitledNote_txtbox");

		salesforceOpportunityControls.UntitledNote_txtbox.sendKeys(arg0);

	}

	public void inputEnteraNote_txtbox(String arg0) {

		WaitUntilElementAppears(salesforceOpportunityControls.EnteraNote_txtbox, 120, 10, "EnteraNote_txtbox");

		salesforceOpportunityControls.EnteraNote_txtbox.sendKeys(arg0);

	}

	public void clickDone_btn() {

		WaitUntilElementAppears(salesforceOpportunityControls.Done_btn, 120, 10, "Done_btn");

		salesforceOpportunityControls.Done_btn.click();

	}

	public void clickRelated_button() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

		WaitUntilElementAppears(salesforceOpportunityControls.Related_button, 300, 10, "Related_button");

		salesforceOpportunityControls.Related_button.click();

	}

	public void clickNew_button() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitUntilElementAppears(salesforceOpportunityControls.New_CaseComments, 120, 10, "New_CaseComments");
		salesforceOpportunityControls.New_CaseComments.click();

	}

	public void NewCaseWindow() {
		System.out.println("New Case Comment Window appears");
	}

	public void inputBody_txtbox(String arg0) {
		WaitUntilElementAppears(salesforceOpportunityControls.Body_txtbox, 120, 10, "Body_txtbox");
		salesforceOpportunityControls.Body_txtbox.sendKeys(arg0);

	}

	// ---------Call
	// Plan/Report-----------------------------------------------------------------------------------------------

	public void clickCallPlanReport_link() {

		waitforElementforInterval(WaitOppEleName.OPPURTUNITY_LINK, TestBase.global_configProperties.get("waituntil"));

		WaitUntilElementAppears(salesforceOpportunityControls.CallPlanReports_link, 240, 10, "CallPlanReports _ link");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.CallPlanReports_link);

	}

	public void NewCallPlanReport_DialogueWindowAppears() {

		waitforElementforInterval(WaitOppEleName.NEW_CALLPLANREPORTS_WINDOW,
				TestBase.global_configProperties.get("waituntil"));

	}

	public void CallPlanReport_WindowAppears() {

		waitforElementforInterval(WaitOppEleName.CALLPLANREPORTS_RECENTLYVIEWED_LBL,
				TestBase.global_configProperties.get("waituntil"));

	}

	public void inputCallPlanReportName(String Name) {

		waitforElementforInterval(WaitOppEleName.CALLPLANREPORTNAME_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.
		 * CallPlanReportName_Txtbox, 120, 10, "CallPlanReports _ link");
		 */

		salesforceOpportunityControls.CallPlanReportName_Txtbox.sendKeys(Name);
	}

	// **************************OPPORTUNITY***********************************************************************************************

	public boolean CheckOpportunityLinkAppears() {

		try {
			return salesforceOpportunityControls.Opportunities_Btn.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkForEditWindow() {

		try {
			return salesforceOpportunityControls.Save_EditRiskBNonThirdParty.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkForNew_Btn() {

		try {
			return salesforceOpportunityControls.New_Btn.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkForLogOutLink() {

		try {
			return salesforceOpportunityControls.LogoutBharatAgrawal.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkPageLoaded() {

		try {
			return salesforceOpportunityControls.Stage_Discover_btn.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOpportunity() {

		waitforElementforInterval(WaitOppEleName.OPPURTUNITY_LINK, TestBase.global_configProperties.get("waituntil"));

		// QUARTERLYPERFORMANCE_LBL
		// waitforElementforInterval(WaitOppEleName.QUARTERLYPERFORMANCE_LBL,
		// TestBase.global_configProperties.get("waituntil"));

		// salesforceOpportunityControls.Opportunities_Btn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Opportunities_Btn);
	}

	public void clickRiskBLS_link() {

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		// salesforceOpportunityControls.OppurtunitySearch_TxtBox.sendKeys(arg1 +
		// Keys.ENTER);

		salesforceOpportunityControls.Refresh_Btn.click();

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYNAME_TABLE,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.REFRESH_BTN, TestBase.global_configProperties.get("waituntil"));

		int tryCount = 0;

		while (checkForOpportunitySpinner() && tryCount < 4) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tryCount++;
		}

		salesforceOpportunityControls.RiskBLSDemo_Link.click();
	}

	public void clickRiskCnonThirdParty_link() {
		salesforceOpportunityControls.RiskCnonThirdParty_Link.click();
	}

	public void clickRiskCnonThirdParty_link(String arg1) {

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		// salesforceOpportunityControls.OppurtunitySearch_TxtBox.sendKeys(arg1 +
		// Keys.ENTER);

		salesforceOpportunityControls.Refresh_Btn.click();

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYNAME_TABLE,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.REFRESH_BTN, TestBase.global_configProperties.get("waituntil"));

		int tryCount = 0;

		while (checkForOpportunitySpinner()
				&& tryCount < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tryCount++;
		}

		WaitUntilElementAppears(salesforceOpportunityControls.RiskALSDemo_Link_str(arg1), 120, 10,
				"RiskALSDemo_Link_str");

		salesforceOpportunityControls.RiskALSDemo_Link_str(arg1).click();
	}

	public void clickRiskBnonThirdParty_link() {
		salesforceOpportunityControls.RiskBnonThirdParty_Link.click();
	}

	public void clickRiskBnonThirdParty_link(String arg1) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salesforceOpportunityControls.RiskALSDemo_Link_str(arg1).click();
	}

	public void clickRiskALS_link(String arg1) {
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		// salesforceOpportunityControls.OppurtunitySearch_TxtBox.sendKeys(arg1 +
		// Keys.ENTER);

		salesforceOpportunityControls.Refresh_Btn.click();

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYNAME_TABLE,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.REFRESH_BTN, TestBase.global_configProperties.get("waituntil"));

		int tryCount = 0;

		while (checkForOpportunitySpinner()
				&& tryCount < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tryCount++;
		}

		salesforceOpportunityControls.RiskALSDemo_Link_str(arg1).click();
	}

	public boolean checkForOpportunitySpinner() {

		try {
			return salesforceOpportunityControls.OppurtunityNameWindow_Spinner.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickRiskCLS_link() {

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		// salesforceOpportunityControls.OppurtunitySearch_TxtBox.sendKeys(arg1 +
		// Keys.ENTER);

		salesforceOpportunityControls.Refresh_Btn.click();

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYSEARCH_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.OPPURTUNITYNAME_TABLE,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.REFRESH_BTN, TestBase.global_configProperties.get("waituntil"));

		int tryCount = 0;

		while (checkForOpportunitySpinner()
				&& tryCount < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tryCount++;
		}

		salesforceOpportunityControls.RiskCLSDemo_Link.click();
	}

	public void closeGetContractSignedPopup() {

		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// waitForNewButton();

		try {
			/*
			 * if
			 * (salesforceOpportunityControls.GetContractSignedPopup_Close_Btn.isDisplayed()
			 * )
			 * 
			 */
			while (salesforceOpportunityControls.GetContractSignedPopup_Close_Btn.isDisplayed()) {

				salesforceOpportunityControls.GetContractSignedPopup_Close_Btn.click();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} catch (Exception e) {
			System.out.println("THE GetContractSignedPopup_Close_Btn was not found");
		}

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickNewBtn() {

		waitforElementforInterval(WaitOppEleName.CREATE_OPP_NEW_BTN, TestBase.global_configProperties.get("waituntil"));

		// WaitUntilElementAppears(salesforceOpportunityControls.New_Btn, 240, 10, "New
		// _ Btn");

		// salesforceOpportunityControls.New_Btn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", salesforceOpportunityControls.New_Btn);

	}

	public void inputAccountName(String strAccountname) {
		// salesforceOpportunityControls.AccountName_Txtbox.clear();
		waitforElementforInterval(WaitOppEleName.ACCOUNTNAME_TXTBOX, TestBase.global_configProperties.get("waituntil"));
		salesforceOpportunityControls.AccountName_Txtbox.sendKeys(strAccountname);

	}

	public void inputAccountName2(String strAccountname) {
		// salesforceOpportunityControls.AccountName_Txtbox.clear();

		waitforElementforInterval(WaitOppEleName.ACCOUNTNAME2_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		salesforceOpportunityControls.AccountName2_Txtbox.sendKeys(strAccountname);

	}

	public void inputParentAccount(String strAccountname) {
		// salesforceOpportunityControls.AccountName_Txtbox.clear();
		waitforElementforInterval(WaitOppEleName.PARENTACCOUNT_TXTBOX,
				TestBase.global_configProperties.get("waituntil"));

		salesforceOpportunityControls.ParentAccount_Txtbox.sendKeys(strAccountname);

	}

	public void inputAccount(String strAccountname) {

		waitforElementforInterval(WaitOppEleName.ACCOUNT_TXTBOX, TestBase.global_configProperties.get("waituntil"));

		// WaitUntilElementAppears(salesforceOpportunityControls.Account_Txtbox, 300,
		// 10, "Account_Txtbox");

		salesforceOpportunityControls.Account_Txtbox.sendKeys(strAccountname);

	}

	public void clickAutomation2() {

		waitforElementforInterval(WaitOppEleName.AUTOMATION2, TestBase.global_configProperties.get("waituntil"));

		salesforceOpportunityControls.Automation2.click();

	}

	public void clickAutomation2(String arg) {

		int ct = 0;

		while (!salesforceOpportunityControls.AccountName_Item_StringText(arg).isDisplayed()
				&& ct < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			System.out.println("Waiting for - AccountName-DropDown Menu");

			inputForAccountName(arg);

			ct++;
			if (ct == Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
				throw new NoSuchElementException("WebElement:: 'AccountName' -DropDown Menu Not Found");
			}

		}

		salesforceOpportunityControls.AccountName_Item_StringText(arg).click();

	}

	public void inputForAccountName(String arg1) {

		inputAccountName(Keys.BACK_SPACE.toString());
		inputAccountName(Keys.BACK_SPACE.toString());
		inputAccountName(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputAccountName(Keys.BACK_SPACE.toString());
		inputAccountName(Keys.BACK_SPACE.toString());
		inputAccountName(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(300);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inputForLegalAdvisor(String arg1) {
		inputLegalAdvisor_Txtbox(arg1);
		inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputLegalAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickMRD1() {

		salesforceOpportunityControls.MRD1.click();

	}

	public void inputOpportunityName(String strOpportunityname) {

		WaitUntilElementAppears(salesforceOpportunityControls.OppurtunityName_Txtbox, 120, 10,
				"OppurtunityName_Txtbox");

		salesforceOpportunityControls.OppurtunityName_Txtbox.clear();
		salesforceOpportunityControls.OppurtunityName_Txtbox.sendKeys(strOpportunityname);
	}

	public void inputTotalRevenue(String strRevenue) {

		WaitUntilElementAppears(salesforceOpportunityControls.TotalRevenue_Txtbox, 120, 10, "TotalRevenue_Txtbox");

		salesforceOpportunityControls.TotalRevenue_Txtbox.clear();
		salesforceOpportunityControls.TotalRevenue_Txtbox.sendKeys(strRevenue);
	}

	public void clickStage() {
		
		
		WaitUntilElementAppears(salesforceOpportunityControls.Stage_Dropdown, 120, 10, "Stage_Dropdown");
		
		WebElement ele = salesforceOpportunityControls.Stage_Dropdown;
		((JavascriptExecutor)
				 driver).executeScript("arguments[0].scrollIntoView(true);",ele);
		
		// ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 100);");
	


		salesforceOpportunityControls.Stage_Dropdown.click(); // have to select from dropdown
	}

	public void clickDiscoverStage(String arg) {
		
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WaitUntilElementAppears(salesforceOpportunityControls.Discover_Stage, 120, 10, "Discover_Stage");
		salesforceOpportunityControls.Discover_Stage(arg).click(); // have to select from dropdown
		
		
		}

	public void clickExpectedDate() {
		WaitUntilElementAppears(salesforceOpportunityControls.ExpectedDateOfContract_Txtbox, 120, 10,
				"ExpectedDateOfContract_Txtbox");

		salesforceOpportunityControls.ExpectedDateOfContract_Txtbox.click();
	}

	public void clickCurrentDate() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitUntilElementAppears(salesforceOpportunityControls.Current_Date, 120, 10, "Current_Date");
		salesforceOpportunityControls.Current_Date.click();
	}

	public void clickOpportunityType() {

		WaitUntilElementAppears(salesforceOpportunityControls.OpportunityType_Dropdown, 120, 10,
				"OpportunityType_Dropdown");

		salesforceOpportunityControls.OpportunityType_Dropdown.click();
	}

	public void clickLiceningorServices_OpportunityType(String arg1) {

		WaitUntilElementAppears(salesforceOpportunityControls.LiceningorServices_OpportunityType, 120, 10,
				"LiceningorServices_OpportunityType");

		salesforceOpportunityControls.LiceningorServices_OpportunityType(arg1).click();
	}

	public void clickNon3rdPartyLicensingampServicesUpstreamampIntegratedGas_OpportunityType() {

		WaitUntilElementAppears(
				salesforceOpportunityControls.Non3rdPartyLicensingampServicesUpstreamampIntegratedGas_OpportunityType,
				120, 10, "Non3rdPartyLicensingampServicesUpstreamampIntegratedGas_OpportunityType");

		salesforceOpportunityControls.Non3rdPartyLicensingampServicesUpstreamampIntegratedGas_OpportunityType.click();
	}

	public void inputDescription(String strDescription) {
		WaitUntilElementAppears(salesforceOpportunityControls.Description_Txtbox, 120, 10, "Description_Txtbox");

		salesforceOpportunityControls.Description_Txtbox.clear();
		salesforceOpportunityControls.Description_Txtbox.sendKeys(strDescription);
	}

	public void clickSave() {

		WaitUntilElementAppears(salesforceOpportunityControls.Save_Btn, 300, 10, "Save_Btn");

		salesforceOpportunityControls.Save_Btn.click();

		try {
			Thread.sleep(10000); // Thread.sleep(10000); Thread.sleep(1000);

		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickEdit() {
		/*
		 * try { Thread.sleep(2000); // Thread.sleep(10000); // Thread.sleep(1000); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		waitforElementforInterval(WaitOppEleName.EDIT_BTN, TestBase.global_configProperties.get("waituntil"));

		// WaitUntilElementAppears(salesforceOpportunityControls.Edit_Btn, 300, 10,
		// "Edit_Btn");
		salesforceOpportunityControls.Edit_Btn.click();
		/*
		 * try { Thread.sleep(10000); Thread.sleep(12000); // Thread.sleep(1000); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		waitForEditWindow();

		System.out.println("Edit window appears");
	}

	public void clickDeliveryRegion() {
		WaitUntilElementAppears(salesforceOpportunityControls.DeliveryRegion_Dropdown, 300, 10,
				"DeliveryRegion_Dropdown");
		salesforceOpportunityControls.DeliveryRegion_Dropdown.click(); // select delivery region
	}

	public void clickAmericas_DeliveryRegion(String arg1) {
		WaitUntilElementAppears(salesforceOpportunityControls.Americas_DeliveryRegion, 300, 10,
				"Americas_DeliveryRegion");
		salesforceOpportunityControls.Americas_DeliveryRegion(arg1).click();
	}

	public void clickRiskCategory() {
		WaitUntilElementAppears(salesforceOpportunityControls.RiskCategory_Dropdown, 300, 10, "RiskCategory_Dropdown");
		salesforceOpportunityControls.RiskCategory_Dropdown.click();
	}

	public void clickA_RiskCategory(String arg1) {
		// WaitUntilElementAppears(salesforceOpportunityControls.A_RiskCategory, 300,
		// 10, "A_RiskCategory");
		salesforceOpportunityControls.A_RiskCategory(arg1).click();
	}

	public void clickB_RiskCategory(String arg1) {

		salesforceOpportunityControls.B_RiskCategory(arg1).click();
	}

	public void clickC_RiskCategory(String arg1) {

		salesforceOpportunityControls.C_RiskCategory(arg1).click();
	}

	public void clickCatalystIntegratedOpportunity() {

		WaitUntilElementAppears(
				salesforceOpportunityControls.CatalystIntegratedOpportunity_Dropdown,
				100, 10, "Edit Oppurtunity >> CatalystIntegratedOpportunity_Dropdown");
		
		salesforceOpportunityControls.
		CatalystIntegratedOpportunity_Dropdown.click();
	}

	public void clickYes_CatalystIntegratedOpportunity(String arg1) {

	
		
		salesforceOpportunityControls.Yes_CatalystIntegratedOpportunity(arg1).click();
	}

	public void clickContractCategory() {
		WaitUntilElementAppears(
		salesforceOpportunityControls.ContractCategory_Dropdown,
		100, 10, "Edit Oppurtunity >> ContractCategory_Dropdown");
		
		salesforceOpportunityControls.ContractCategory_Dropdown.click();
	}

	public void clickCatalystNBD_ContractCategory(String arg1) {
		salesforceOpportunityControls.CatalystNBD_ContractCategory(arg1).click();
	}

	public void clickContractType() {
		
		WaitUntilElementAppears(
				salesforceOpportunityControls.ContractType_Dropdown,
				100, 10, "Edit Oppurtunity >> ContractType_Dropdown");
		

		salesforceOpportunityControls.ContractType_Dropdown.click();
	}

	public void clickDSLicenseAgreement_ContractType() {
		
		WaitUntilElementAppears(
				salesforceOpportunityControls.DSLicenseAgreement_ContractType,
				100, 10, "Edit Oppurtunity >> DSLicenseAgreement_ContractType");

		salesforceOpportunityControls.DSLicenseAgreement_ContractType.click();
	}

	public void clickWorkOrder_ContractType() {
		
		WaitUntilElementAppears(
				salesforceOpportunityControls.WorkOrder_ContractType,
				100, 10, "Edit Oppurtunity >> WorkOrder_ContractType");


		salesforceOpportunityControls.WorkOrder_ContractType.click();
	}

	public void clickContractSubType() {
		
		WaitUntilElementAppears(
				salesforceOpportunityControls.ContractSubType_Dropdown,
				100, 10, "Edit Oppurtunity >> ContractSubType_Dropdown");


		salesforceOpportunityControls.ContractSubType_Dropdown.click();
	}

	public void clickCrudeDistillerUnit_ContractSubType() {
		
		WaitUntilElementAppears(
				salesforceOpportunityControls.CrudeDistillerUnit_ContractSubType,
				100, 10, "Edit Oppurtunity >> CrudeDistillerUnit_ContractSubType");


		salesforceOpportunityControls.CrudeDistillerUnit_ContractSubType.click();
	}

	public void clickServiceMandate() {

		salesforceOpportunityControls.ServicesMandate_Dropdown.click();
	}

	public void clickStrategic_ServicesMandate(String arg1) {

		salesforceOpportunityControls.Strategic_ServicesMandate(arg1).click();
	}

	public void clickStartDate() {

		salesforceOpportunityControls.StartDate_Txtbox.clear();
		salesforceOpportunityControls.StartDate_Txtbox.click();
	}

	public void clickEndDate() {

		salesforceOpportunityControls.EndDate_Txtbox.clear();
		// salesforceOpportunityControls.EndDate_Txtbox.click();
		// String strStartDate =
		// salesforceOpportunityControls.StartDate_Txtbox.getText().toString().trim();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.now();
		String strStartDate = dtf.format(localDate).toString().trim();
		// Add 2 days to currrent Date
		String strEndDate = addDaysToGivenDate(strStartDate, "dd-MM-yyyy", 2).toString().trim();

		salesforceOpportunityControls.EndDate_Txtbox.sendKeys(strEndDate);

	}

	public String addDaysToGivenDate(String dateToModify, String dateFormat, int noOfDaysToAdd) {

		if (dateToModify == null || dateFormat == null || noOfDaysToAdd == 0)
			return null;

		// String oldDate = "30/11/2019";//"2017-01-29";
		String oldDate = dateToModify;
		System.out.println("Date before Addition: " + oldDate);
		System.out.println("Date Format input: " + dateFormat);
		System.out.println("Days to add : " + noOfDaysToAdd);

		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //new
		// SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); // new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(oldDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Incrementing the date by 1 day
		// c.add(Calendar.DAY_OF_MONTH, 2);
		c.add(Calendar.DAY_OF_MONTH, noOfDaysToAdd);
		String newDate = sdf.format(c.getTime());
		System.out.println("Date Incremented : " + newDate);
		return newDate;
	}

	public void inputThirdPartyCostExpenses(String ThirdPartyCostExpenses) {

		salesforceOpportunityControls.ThirdPartyCostExpenses_Txtbox.sendKeys(ThirdPartyCostExpenses);
	}

	public void inputTravelExpenses(String travelExpenses) {

		salesforceOpportunityControls.TravelExpenses_Txtbox.sendKeys(travelExpenses);
	}

	public void clickSaveButton() {

		salesforceOpportunityControls.Save_Edit.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickSave_Edit_RiskALS() {

		salesforceOpportunityControls.Save_Edit_RiskALS.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickSave_Edit_RiskBLS() {

		salesforceOpportunityControls.Save_Edit_RiskBLS.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickSave_Edit_RiskCLS() {

		salesforceOpportunityControls.Save_Edit_RiskCLS.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickMarkStageasComplete() {

		/*
		 * try { Thread.sleep(500);
		 * 
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		try {
			WebElement ele = salesforceOpportunityControls.SubmitForApproval_Btn;

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			WebElement ele = salesforceOpportunityControls.SubmitForApproval_Btn;

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

		} catch (Exception e) {
			// Edit_Btn

			try {
				WebElement ele = salesforceOpportunityControls.Edit_Btn;

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		waitforElementforInterval(WaitOppEleName.MARKSTAGEASCOMPLETE_BTN,
				TestBase.global_configProperties.get("waituntil"));

		/* Thread.sleep(500); */
		try {
			WebElement ele = salesforceOpportunityControls.MarkStageAsComplete_Btn;

			new Actions(driver).moveToElement(ele, 0, 0).perform();
			new Actions(driver).moveToElement(ele, 0, 0).moveToElement(ele).click(ele).perform();

			// driver.findElement(By.xpath("//a[@title='New'][@role='menuitem']")).click();

			try {
				Thread.sleep(500);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			;
		} catch (NoSuchElementException e) {
			try {
				WebElement ele = salesforceOpportunityControls.MarkStageAsComplete_Btn;

				new Actions(driver).moveToElement(ele, 0, 0).perform();
				new Actions(driver).moveToElement(ele, 0, 0).moveToElement(ele).click(ele).perform();

				// driver.findElement(By.xpath("//a[@title='New'][@role='menuitem']")).click();

			} catch (NoSuchElementException ex) {
				throw ex;
			}

		}

//		try {
//			Thread.sleep(10000);
//			Thread.sleep(5000);
//			Thread.sleep(5000);
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		WebElement ele= salesforceOpportunityControls.MarkStageAsComplete_Btn;
////		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//		salesforceOpportunityControls.MarkStageAsComplete_Btn.click();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void clickMarkStageasComplete2() {
		try {
			Thread.sleep(10000);
			Thread.sleep(5000);
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ele = salesforceOpportunityControls.MarkStageAsComplete_Btn;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		salesforceOpportunityControls.MarkStageAsComplete_Btn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inputValueHypothesis(String strValuehypothesis) {
		salesforceOpportunityControls.ValueHypothesis_Txtbox.clear();
		salesforceOpportunityControls.ValueHypothesis_Txtbox.sendKeys(strValuehypothesis);
	}

	public void inputOpportunityAdvisor(String str_Opportunityadvisor) {
		// salesforceOpportunityControls.OpportunityAdvisor_Txtbox.clear();
		salesforceOpportunityControls.OpportunityAdvisor_Txtbox.sendKeys(str_Opportunityadvisor);
	}

	public void inputGeneralManager_Txtbox(String str_GeneralManager) {
		// salesforceOpportunityControls.OpportunityAdvisor_Txtbox.clear();
		salesforceOpportunityControls.GeneralManager_Txtbox.sendKeys(str_GeneralManager);
	}

	public void inputLegalAdvisor_Txtbox(String str_LegalAdvisor) {
		// salesforceOpportunityControls.OpportunityAdvisor_Txtbox.clear();
		salesforceOpportunityControls.LegalAdvisor_Txtbox.sendKeys(str_LegalAdvisor);
	}

	public void inputTaxAdvisor_Txtbox(String str_TaxAdvisor) {
		// salesforceOpportunityControls.OpportunityAdvisor_Txtbox.clear();
		salesforceOpportunityControls.TaxAdvisor_Txtbox.sendKeys(str_TaxAdvisor);
	}

	public void clickOpportunityAdvisor(String arg1) {

		int ct = 0;

		while (!checkForOpportunityAdvisorLink(arg1)
				&& ct < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			System.out.println("Waiting for - OppurtunityAdvisor-DropDown Menu");

			inputForOppurtunityAdvisor(arg1);

			ct++;
			if (ct == Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
				throw new NoSuchElementException("WebElement:: 'OppurtunityAdvisor' -DropDown Menu Not Found");
			}

		}

		salesforceOpportunityControls.OpportunityAdvisor(arg1).click();
	}

	public boolean checkForOpportunityAdvisorLink(String arg) {

		try {
			return salesforceOpportunityControls.OpportunityAdvisor(arg).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void inputForOppurtunityAdvisor(String arg1) {

		inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
		inputOpportunityAdvisor(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickDishaAmin() {

		salesforceOpportunityControls.DishaAmin.click();
	}

	public void clickGeneralManager(String arg1) {

		// salesforceOpportunityControls.GeneralManager_str(arg1).click();

		int ct = 0;

		while (!checkForGeneralManagerLink(arg1)
				&& ct < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			System.out.println("Waiting for - GeneralManager - DropDown Menu");

			inputFoGeneralManager(arg1);

			ct++;
			if (ct == Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
				throw new NoSuchElementException("WebElement:: 'GeneralManager' -DropDown Menu Not Found");
			}

		}

		WebElement ele = salesforceOpportunityControls.GeneralManager_str(arg1);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		// salesforceOpportunityControls.GeneralManager_str(arg1).click();
	}

	public boolean checkForGeneralManagerLink(String arg) {

		try {
			return salesforceOpportunityControls.GeneralManager_str(arg).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void scrolltoLegacyID_Label() {
		WebElement ele = salesforceOpportunityControls.LegacyID_Label;

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void inputFoGeneralManager(String arg1) {

		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(Keys.BACK_SPACE.toString());
		inputGeneralManager_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickLegalAdvisor(String arg1) {

		// salesforceOpportunityControls.LegalAdvisor_str(arg1).click();

		int ct = 0;

		while (!checkForLegalAdvisorLink(arg1)
				&& ct < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			System.out.println("Waiting for - LegalAdvisor_str-DropDown Menu");

			inputForLegalAdvisor_str(arg1);

			ct++;
			if (ct == Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
				throw new NoSuchElementException("WebElement:: 'LegalAdvisor_strr' -DropDown Menu Not Found");
			}

		}

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.LegalAdvisor_str(arg1));

	}

	public boolean checkForLegalAdvisorLink(String arg) {

		try {
			return salesforceOpportunityControls.OpportunityAdvisor(arg).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void inputForLegalAdvisor_str(String arg1) {

		inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputLegalAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputLegalAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputLegalAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickTaxAdvisor(String arg1) {

		// salesforceOpportunityControls.TaxAdvisor_str(arg1).click();

		int ct = 0;

		while (!checkForTaxAdvisorLink(arg1)
				&& ct < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			System.out.println("Waiting for - TaxAdvisor-DropDown Menu");

			inputForTaxAdvisor_str(arg1);

			ct++;
			if (ct == Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
				throw new NoSuchElementException("WebElement:: 'TaxAdvisor_str' -DropDown Menu Not Found");
			}

		}

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.TaxAdvisor_str(arg1));

	}

	public boolean checkForTaxAdvisorLink(String arg) {

		try {
			return salesforceOpportunityControls.OpportunityAdvisor(arg).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void inputForTaxAdvisor_str(String arg1) {

		inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputTaxAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputTaxAdvisor_Txtbox(Keys.BACK_SPACE.toString());
		inputTaxAdvisor_Txtbox(arg1.substring(arg1.length() - 2, arg1.length()));

		try {
			Thread.sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void inputEstimatedAquisitioncost(String strEstimatedaquisitioncost) {
		salesforceOpportunityControls.EstimatedAquisitioncost_Txtbox.clear();
		salesforceOpportunityControls.EstimatedAquisitioncost_Txtbox.sendKeys(strEstimatedaquisitioncost);
	}

	public void clickResponsetoITBRFQ() {

		salesforceOpportunityControls.ResponsetoITBRFQ_Dropdown.click();

	}

	public void Yes_ResponsetoITBRFQ(String arg1) {

		salesforceOpportunityControls.Yes_ResponsetoITBRFQ(arg1).click();

	}

	public void ClickSpecialtaxcondsideration() {

		salesforceOpportunityControls.SpecialTaxConsiderations_Dropdown.click();
	}

	public void Select_Specialtaxcondsideration(String arg1) {
		if (arg1.contains("Yes"))
			salesforceOpportunityControls.Yes_SpecialTaxConsiderations.click();
		else
			salesforceOpportunityControls.No_SpecialTaxConsiderations.click();

	}
//	
//	public void checkaccounttradecontrolled() {
//		
//		salesforceOpportunityControls.AccountTradeControlled.click(); // check
//	}
//	
//	public void checkendcustomertradecontrolled() {
//		
//		salesforceOpportunityControls.EndCustomerTradeControlled.click(); //check
//	}

	public void inputGoGetEvidence(String strGoGetEevidence) {

		salesforceOpportunityControls.GoGetEvidence_Txtbox.sendKeys(strGoGetEevidence);
	}

	public void inputValuetoCustomer(String strValuetoCustomer) {

		salesforceOpportunityControls.ValuetoCustomer_Txtbox.sendKeys(strValuetoCustomer);
	}

	public void inputValueShellPartner(String strValueShellPartner) {

		salesforceOpportunityControls.ValueShellPartner_Txtbox.sendKeys(strValueShellPartner);
	}

	public void inputWinningStrategy(String strWinningStrategy) {

		salesforceOpportunityControls.WinningStrategy_Txtbox.sendKeys(strWinningStrategy);
	}

	public void inputMainDeliveryGroup1(String strMainDeliveryGroup1) {

		salesforceOpportunityControls.MainDeliveryGroup1_Txtbox.sendKeys(strMainDeliveryGroup1);
	}

	public void inputMainDeliveryGroup2(String strMainDeliveryGroup2) {

		salesforceOpportunityControls.MainDeliveryGroup2_Txtbox.sendKeys(strMainDeliveryGroup2);
	}

	public void inputMainDeliveryGroup3(String strMainDeliveryGroup3) {

		salesforceOpportunityControls.MainDeliveryGroup3_Txtbox.sendKeys(strMainDeliveryGroup3);
	}

	public void inputMainDeliveryGroup4(String strMainDeliveryGroup4) {

		salesforceOpportunityControls.MainDeliveryGroup4_Txtbox.sendKeys(strMainDeliveryGroup4);
	}

	public void inputMainDeliveryGroup5(String strMainDeliveryGroup5) {

		salesforceOpportunityControls.MainDeliveryGroup5_Txtbox.sendKeys(strMainDeliveryGroup5);
	}

	public void inputCalDayXBorder(String strCalDayXBorder) {
		salesforceOpportunityControls.CalDayXBorder_Txtbox.clear();
		salesforceOpportunityControls.CalDayXBorder_Txtbox.sendKeys(strCalDayXBorder);
	}

	public void clickConfirmedByCatGM() {

		salesforceOpportunityControls.ConfirmedByCatGM_Dropdown.click();
	}

	public void clickNA_ConfirmedByCatGM(String arg1) {

		salesforceOpportunityControls.NA_ConfirmedByCatGM(arg1).click();
	}

	public void clickYes_ConfirmedByCatGM() {

		salesforceOpportunityControls.Yes_ConfirmedByCatGM.click();
	}

	public void clickShellEntity() {

		salesforceOpportunityControls.ShellEntity_Dropdown.click();
	}

	public void clickShellChinaPTLimitedCN40_ShellEntity(String arg1) {

		salesforceOpportunityControls.ShellChinaPTLimitedCN40_ShellEntity(arg1).click();
	}

	public void clickShellGlobalSolutionsIntlBVNL27_ShellEntity() {

		salesforceOpportunityControls.ShellGlobalSolutionsIntlBVNL27_ShellEntity.click();
	}

	public void clickShellGasNigeriaBVNL40_ShellEntity() {

		salesforceOpportunityControls.ShellGasNigeriaBVNL40_ShellEntity.click();
	}

	public void clickMovingforwardStandaloneBasis() {

		salesforceOpportunityControls.MovingforwardStandalonBasis_Dropdown.click();
	}

	public void clickYes_MovingforwardStandalonBasis() {
		salesforceOpportunityControls.Yes_MovingforwardStandalonBasis.click();
		;
	}

	public void clickNo_MovingforwardStandalonBasis() {
		salesforceOpportunityControls.No_MovingforwardStandalonBasis.click();
		;
	}

	public void clickYes_StandardTermsConditions() {
		salesforceOpportunityControls.Yes_StandardTermsConditions.click();
	}

	public void clickNo_StandardTermsConditions() {
		salesforceOpportunityControls.No_StandardTermsConditions.click();
	}

	public void clickYes_MovingforwardStandalonBasis(String arg1) {

		// salesforceOpportunityControls.Yes_MovingforwardStandalonBasis(arg1).click();

		WebElement ele = salesforceOpportunityControls.Yes_MovingforwardStandalonBasis(arg1);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		salesforceOpportunityControls.Yes_MovingforwardStandalonBasis(arg1).click();
	}

	public void clickStandardTermsConditions() {

		salesforceOpportunityControls.StandardTermsConditions_Dropdown.click();
	}

	public void clickYes_StandardTermsConditions(String arg1) {

		// salesforceOpportunityControls.Yes_StandardTermsConditions(arg1).click();

		WebElement ele = salesforceOpportunityControls.Yes_StandardTermsConditions(arg1);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		salesforceOpportunityControls.Yes_StandardTermsConditions(arg1).click();
	}

	public void clickStandardRateseesampPaymentTerms() {

		salesforceOpportunityControls.StandardRateseesampPaymentTerms_Dropdown.click();
	}

	public void clickYes_StandardRateseesampPaymentTerms(String arg1) {
		if (arg1.trim().toLowerCase().contains("yes"))
			salesforceOpportunityControls.Yes_StandardRateseesampPaymentTerms.click();
		else
			salesforceOpportunityControls.No_StandardRateseesampPaymentTerms.click();

		/*
		 * WebElement ele=
		 * salesforceOpportunityControls.Yes_StandardRateseesampPaymentTerms(arg1);
		 * ((JavascriptExecutor)driver).executeScript(
		 * "arguments[0].scrollIntoView(true);", ele);
		 */

		// salesforceOpportunityControls.Yes_StandardRateseesampPaymentTerms(arg1).click();

		// salesforceOpportunityControls.Yes_StandardRateseesampPaymentTerms(arg1).click();
	}

	public void clickAllDesignProductsSoftwareIPinBSP_Dropdown() {

		salesforceOpportunityControls.AllDesignProductsSoftwareIPinBSP_Dropdown.click();
	}

	public void clickYes_AllDesignProductsSoftwareIPinBSP(String arg1) {

		// salesforceOpportunityControls.Yes_AllDesignProductsSoftwareIPinBSP(arg1).click();
		if (arg1.trim().toLowerCase().contains("yes"))
			salesforceOpportunityControls.Yes_AllDesignProductsSoftwareIPinBSP.click();
		else
			salesforceOpportunityControls.No_AllDesignProductsSoftwareIPinBSP.click();

	}

	public void clickLumpSum_Dropdown() {

		salesforceOpportunityControls.LumpSum_Dropdown.click();
	}

	public void clickYes_LumpSum(String arg1) {
		if (arg1.trim().toLowerCase().contains("yes"))
			salesforceOpportunityControls.Yes_LumpSum.click();
		else
			salesforceOpportunityControls.No_LumpSum.click();
	}

	public void inputExpenses(String strExpenses) {
		salesforceOpportunityControls.Expenses_Txtbox.clear();
		salesforceOpportunityControls.Expenses_Txtbox.sendKeys(strExpenses);
	}

	public void clickSave_EditRiskANonThirdParty() {
		salesforceOpportunityControls.Save_EditRiskANonThirdParty.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickSave_EditRiskBNonThirdParty() {
		salesforceOpportunityControls.Save_EditRiskBNonThirdParty.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickSave_EditRiskCnonThirdParty() {
		salesforceOpportunityControls.Save_Edit_RiskCnonThirdParty.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * <<<<<<< HEAD public void inputipfees(String ipfees) {
	 * 
	 * salesforceOpportunityControls.IPFees.sendKeys(ipfees); }
	 * 
	 * public void inputmanpowercosts(String manpowercosts) {
	 * 
	 * salesforceOpportunityControls.ManpowerCosts.sendKeys(manpowercosts); }
	 * 
	 * public void inputmanpowerhours(String manpowerhours) {
	 * 
	 * salesforceOpportunityControls.ManpowerHours.sendKeys(manpowerhours); }
	 * 
	 * public void inputbillingaccountant(String billingaccountant) {
	 * 
	 * salesforceOpportunityControls.BillingAccountant.sendKeys(billingaccountant);
	 * }
	 * 
	 * public void checkemailprojectsetup() {
	 * 
	 * salesforceOpportunityControls.em }
	 * 
	 * // ---------Input for Add Cash Forecast-----------------------
	 * 
	 * public void clickaddcashforecast() {
	 * 
	 * salesforceOpportunityControls.AddCashForcast.click(); }
	 * 
	 * public void inputrevenueamount(String revenueamount) {
	 * 
	 * salesforceOpportunityControls.RevenueAmount.sendKeys(revenueamount); }
	 * 
	 * public void selectmonth(String month) {
	 * 
	 * salesforceOpportunityControls.Month_AddCashForecast.sendKeys(month); }
	 * 
	 * public void selectyear(String year) {
	 * 
	 * salesforceOpportunityControls.Year_AddCashForecast.sendKeys(year); }
	 * 
	 * public void inputdescriptionaddcashforecast(String description) {
	 * 
	 * salesforceOpportunityControls.Description_AddCashForecast.sendKeys(
	 * description); }
	 * 
	 * public void clicksaveaddcashforecast() {
	 * 
	 * salesforceOpportunityControls.SaveAddCashForecast.click(); }
	 */

	// #--------Fill the details for New Opportunity Risk Assessment: Services Risk
	// When I click on "New" option in Opportunity Risk Assessments - drop menu

	public void clickOpportunityRiskAssessments_DropDown() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		
//		salesforceOpportunityControls.New_OpportunityRiskAssessments_Menu_Btn.click();

		// -------------------------------------

		// WebElement ele = driver.findElement(By.xpath(
		// "//div[contains(@class,'windowViewMode-normal oneContent active
		// lafPageHost')]//span[@title='Approval History']"));

		WebElement ele = salesforceOpportunityControls.RightSide_Section_ApprovalHistory_Lbl;

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

		/* Thread.sleep(500); */
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		waitforElementforInterval(WaitOppEleName.RIGHTHND_OPPORTUNITYRISKASSESSMENTS_DEPR_LINK,
				TestBase.global_configProperties.get("waituntil"));

		try {

			salesforceOpportunityControls.RightHnd_OpportunityRiskAssessments_Depr_Link.click();
			;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			waitforElementforInterval(WaitOppEleName.RIGHTHND_OPPORTUNITYRISKASSESSMENTS_DEPR_WINDOW_NEW_BTN,
					TestBase.global_configProperties.get("waituntil"));

			salesforceOpportunityControls.RightHnd_OpportunityRiskAssessments_Depr_ClikLink_New_Btn.click();

			// Modified the flow below as the dropdown was no more available
			/*
			 * ele = salesforceOpportunityControls.
			 * AlreadyOppExists_OpportunityRiskAssessments_Btn;
			 * 
			 * new Actions(driver).moveToElement(ele, 0, 0).perform(); new
			 * Actions(driver).moveToElement(ele, 0,
			 * 0).moveToElement(ele).click(ele).perform();
			 * 
			 * //
			 * driver.findElement(By.xpath("//a[@title='New'][@role='menuitem']")).click();
			 * 
			 * try { Thread.sleep(500); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 * salesforceOpportunityControls.New_OpportunityRiskAssessments_Menu_Btn.click()
			 * ; ;
			 */
		} catch (NoSuchElementException e) {
			/*
			 * try { ele =
			 * salesforceOpportunityControls.Normal_OpportunityRiskAssessments_Btn;
			 * 
			 * new Actions(driver).moveToElement(ele, 0, 0).perform(); new
			 * Actions(driver).moveToElement(ele, 0,
			 * 0).moveToElement(ele).click(ele).perform();
			 * 
			 * //
			 * driver.findElement(By.xpath("//a[@title='New'][@role='menuitem']")).click();
			 * salesforceOpportunityControls.New_OpportunityRiskAssessments_Menu_Btn.click()
			 * ; } catch (NoSuchElementException ex) { throw ex; }
			 */

		}

	}
	
	
	public void checkaccount_gets_created(String arg1) {
		
		waitforElementforInterval(WaitOppEleName.VIEWACCOUNTHIERARCHY_BTN,
				TestBase.global_configProperties.get("waituntil"));
		
		waitforElementforInterval(WaitOppEleName.NEWACCOUNT__ACCOUNT_LBL,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.NEWACCOUNT__ACCOUNT_NAME,
				TestBase.global_configProperties.get("waituntil"));

		Assert.assertTrue(
				salesforceOpportunityControls.NewAccount__Account_Name.getAttribute("title").toLowerCase().trim()
						.contains(arg1.toLowerCase().trim()),
				"\n********************************************************************************************************************************************\n"
						+ "The contact with  name : " + arg1 + "was not created."
						+ "\n********************************************************************************************************************************************\n");


	}

	public void clickTestAutomationServicesLLC2() {

		salesforceOpportunityControls.TestAutomationServicesLLC2.click();

	}

	// -------------------------------------

	public void clickOpportunityRiskAssessments_ShowMoreAction_Btn() {

//		WebElement ele = salesforceOpportunityControls.OpportunityRiskAssessments_ShowMoreAction_Btn;
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

//			ele = salesforceOpportunityControls.OpportunityRiskAssessments_ShowMoreAction_Btn;
//
//			new Actions(driver).moveToElement(ele, 0, 0).perform();
//			new Actions(driver).moveToElement(ele, 0, 0).moveToElement(ele).click(ele).perform();

		salesforceOpportunityControls.OpportunityRiskAssessments_ShowMoreAction_Btn.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		salesforceOpportunityControls.New_OpportunityRiskAssessments_Menu_Btn.click();

	}

	public void clickNext_OpportunityRiskAssessments_Btn() {
		try {
			Thread.sleep(500);
			/*
			 * driver.findElement(By.xpath(
			 * "//h2[text()='New Opportunity Risk Assessment']/../../following-sibling::div//span[text()='Next']/parent::button"
			 * )) .click();
			 */
			salesforceOpportunityControls.Next_OpportunityRiskAssessments_Btn.click();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickNext_OpportunityRiskAssessmentsDepr_Btn() {
		try {
			Thread.sleep(500);
			/*
			 * driver.findElement(By.xpath(
			 * "//h2[text()='New Opportunity Risk Assessment']/../../following-sibling::div//span[text()='Next']/parent::button"
			 * )) .click();
			 */
			salesforceOpportunityControls.Next_OpportunityRiskAssessmentsDepr_Btn.click();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	    //#--------Fill details for Compliance|Compliance SME's-------------------------------
//	    Then "New Opportunity Risk Assessment: Service Risk Assessment" appears
//	    Then I select "A" for HSSE
	public void selectHSSE_DropDown() {
		salesforceOpportunityControls.HSSE_Dropdown.click();

	}

	public void selectAHSSE(String arg1) {

		if (arg1.trim().equals("A"))
			salesforceOpportunityControls.A_HSSE.click();
		else if (arg1.trim().equals("B"))
			salesforceOpportunityControls.B_HSSE.click();
		else
			salesforceOpportunityControls.C_HSSE.click();
	}

//public void selectBHSSE(String arg1){
//		
//		salesforceOpportunityControls.A_HSSE(arg1).click();
//	}

//	    Then I select "A" for Compliance
	public void selectCompliance_DropDown() {
		salesforceOpportunityControls.Compliance_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE(arg1).click();
	}

	public void selectBCompliance_DropDown() {
		salesforceOpportunityControls.Compliance_Dropdown.click();

		// salesforceOpportunityControls.B_HSSE.click();
	}

//	    Then I select "A" for Export Control incl. GEC
	public void selectExportControlIncGEC_DropDown() {
		salesforceOpportunityControls.ExportControlIncGEC_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Conflict of Interest
	public void selectConflictofInterest_Dropdownn() {
		salesforceOpportunityControls.ConflictofInterest_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Competitively Sensitive Information
	public void selectCompetitivelySensitiveInformation_Dropdown() {
		salesforceOpportunityControls.CompetitivelySensitiveInformation_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Anti-bribery and Corruption Risk
	public void selectAntiBriberyCorruptionRisk_Dropdown() {
		salesforceOpportunityControls.AntiBriberyCorruptionRisk_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    //#---------Fill details for Scope|Delivery Groups--------------------------
//	    Then I select "A" for Delays
	public void selectDelays_Dropdown() {
		salesforceOpportunityControls.Delays_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

	public void selectBDelays_Dropdown() {
		salesforceOpportunityControls.Delays_Dropdown.click();

		// salesforceOpportunityControls.B_HSSE.click();
	}

//	    Then I select "A" for SCope Change
	public void selectScopeChange_Dropdown() {
		salesforceOpportunityControls.ScopeChange_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Technical Delivery
	public void selectTechnicalDelivery_Dropdown() {
		salesforceOpportunityControls.TechnicalDelivery_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Catalyst Availability
	public void selectCatalystAvailability_Dropdown() {
		salesforceOpportunityControls.CatalystAvailability_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Secondment
	public void selectSecondment_Dropdown() {
		salesforceOpportunityControls.Secondment_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

	public void selectBSecondment_Dropdown() {
		salesforceOpportunityControls.Secondment_Dropdown.click();

		// salesforceOpportunityControls.B_HSSE.click();
	}

//	    Then I select "A" for Visitors to Customer Plant
	public void selectA_VisitorsToCustomerPlant_Dropdown() {
		salesforceOpportunityControls.VisitorsToCustomerPlant_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for PE - Onsite Presence
	public void selectPEOnsitePresence_Dropdown() {
		salesforceOpportunityControls.PEOnsitePresence_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

	public void selectBPEOnsitePresence_Dropdown() {
		salesforceOpportunityControls.PEOnsitePresence_Dropdown.click();

		// salesforceOpportunityControls.B_HSSE.click();
	}

//	    Then I select "A" for Baseline Data Volatility
	public void selectBaselineDataVolatility_Dropdownn() {
		salesforceOpportunityControls.BaselineDataVolatility_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Freedom of Action
	public void selectFreedomOfAction_Dropdown() {
		salesforceOpportunityControls.FreedomOfAction_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    //#--------Fill details for Legal|Legal Services(may be different across regions)
//	    Then I select "A" for IP Contamination
	public void selectIPContamination_Dropdown() {
		salesforceOpportunityControls.IPContamination_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

	public void selectBIPContamination_Dropdown() {
		salesforceOpportunityControls.IPContamination_Dropdown.click();

		// salesforceOpportunityControls.B_HSSE.click();
	}

//	    Then I select "A" for Liability
	public void selectLiability_Dropdown() {
		salesforceOpportunityControls.Liability_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Indemnity
	public void selectIndemnity_Dropdown() {
		salesforceOpportunityControls.Indemnity_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Insurance
	public void selectInsurance_Dropdown() {
		salesforceOpportunityControls.Insurance_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Law arbitration
	public void selectLawArbitration_Dropdown() {
		salesforceOpportunityControls.LawArbitration_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Force Majeure
	public void selectForceMajeure_Dropdown() {
		salesforceOpportunityControls.ForceMajeure_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Change Of Onwership
	public void selectChangeofOwnership_Dropdown() {
		salesforceOpportunityControls.ChangeofOwnership_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    //#--------Fill details for Financial| Commercial Finance Advisor--------------
//	    Then I select "A" for Payment Structure 
	public void selectPaymentStructure_Dropdown() {
		salesforceOpportunityControls.PaymentStructure_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Payment Terms
	public void selectPaymentTerms_Dropdown() {
		salesforceOpportunityControls.PaymentTerms_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Late Payment: Interest Rate
	public void selectLatePaymentInterestRate_Dropdown() {
		salesforceOpportunityControls.LatePaymentInterestRate_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Deal Customer Credit Check
	public void selectDealCustomerCreditCheck_Dropdown() {
		salesforceOpportunityControls.DealCustomerCreditCheck_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Foreign Exchange Rate
	public void selectForeignExchangeRate_Dropdown() {
		salesforceOpportunityControls.ForeignExchangeRate_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Taxes
	public void selectTaxes_Dropdown() {
		salesforceOpportunityControls.Taxes_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Inflation
	public void selectInflation_Dropdown() {
		salesforceOpportunityControls.Inflation_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Assignment
	public void selectAssignment_Dropdown() {
		salesforceOpportunityControls.Assignment_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Provide Bank Guarantee
	public void selectProvideBankGuarantee_Dropdown() {
		salesforceOpportunityControls.ProvideBankGuarantee_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Audit Rights
	public void selectAuditRights_Dropdown() {
		salesforceOpportunityControls.AuditRights_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    //#----------Fill details for Commercial | Line of Business Management-------
//	    Then I select "A" for Agreement Value
	public void selectAgreementValue_Dropdown() {
		salesforceOpportunityControls.AgreementValue_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Commercial Rates Inflator
	public void selectCommercialRatesInflator_Dropdown() {
		salesforceOpportunityControls.CommercialRatesInflator_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Margin
	public void selectMargin_Dropdown() {
		salesforceOpportunityControls.Margin_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Margin On Manpower
	public void selectMarginOnManPower_Dropdown() {
		salesforceOpportunityControls.MarginOnManPower_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Cash Flow
	public void selectCashFlow_Dropdown() {
		salesforceOpportunityControls.CashFlow_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Brand/Reputation
	public void selectBrandRaputation_Dropdown() {
		salesforceOpportunityControls.BrandRaputation_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Effective Date
	public void selectEffectiveDate_Dropdown() {
		salesforceOpportunityControls.EffectiveDate_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Waranty Guarantees
	public void selectWarantyGuarantees_Dropdown() {
		salesforceOpportunityControls.WarantyGuarantees_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Termination
	public void selectTermination_Dropdown() {
		salesforceOpportunityControls.Termination_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Professional Certification/Registration
	public void selectProfessionalCertificationRegistration_Dropdown() {
		salesforceOpportunityControls.ProfessionalCertificationRegistration_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I select "A" for Relationship Risks
	public void selectRelationshipRisks_Dropdown() {
		salesforceOpportunityControls.RelationshipRisks_Dropdown.click();

		// salesforceOpportunityControls.A_HSSE.click();
	}

//	    Then I input "test" for Others
	public void inputOtherOpportunity_Textbox() {
		salesforceOpportunityControls.OtherOpportunity_Textbox.clear();
		salesforceOpportunityControls.OtherOpportunity_Textbox.sendKeys("test");
	}

//	    And I click on Save button
	public void selectSave_Opportunity_Btn() {
		salesforceOpportunityControls.Save_Opportunity_Btn.click();

		try {
			Thread.sleep(1000);
			// Thread.sleep(10000);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectSave_OpportunityDepr_Btn() {

		try {
			Thread.sleep(1000);
			// Thread.sleep(10000);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		salesforceOpportunityControls.Save_OpportunityDepr_Btn.click();

		try {
			Thread.sleep(1000);
			// Thread.sleep(10000);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	    //#---------Submit for Approval------------------------------------- 
//	    When I click on Submit for Approval
	public void submitForApproval_Btn() {

		waitforElementforInterval(WaitOppEleName.SUBMITFORAPPROVAL_BTN,
				TestBase.global_configProperties.get("waituntil"));

		// WaitUntilElementAppears(salesforceOpportunityControls.SubmitForApproval_Btn,
		// 120, 10, "SubmitForApproval_Btn");

		salesforceOpportunityControls.SubmitForApproval_Btn.click();
		/*
		 * try { Thread.sleep(200); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		// waitForSubmitForApprovalWindow();

		if (checkForSubmitForApprovalWindow()) {
		} else {
			// check for 'No Applicable process available' - dialogue appears
			try {
				if (salesforceOpportunityControls.NoApplicableProcessAvailable_Label.isDisplayed()) {
					Assert.fail("'No Applicable process available' - dialogue appears");
					throw new NoSuchElementException("'No Applicable process available' - dialogue appears");

				}

			} catch (Exception e) {
				System.out.println("'No Applicable process available' - dialogue did not appear");
			}
		}

		waitforElementforInterval(WaitOppEleName.SUBMITFORAPPROVALWINDOW,
				TestBase.global_configProperties.get("waituntil"));

	}

//	    Then Submit for Approval window appears
	public void SubmitForApproval_WindowAppears() {
		System.out.println("Then Submit for Approval window appears");

	}

//	    And I click on Submit button
	public void submit_SubmitBtnForApproval() {

		WaitUntilElementAppears(salesforceOpportunityControls.Submit_SubmitForApproval, 120, 10,
				"Submit_SubmitForApproval");

		salesforceOpportunityControls.Submit_SubmitForApproval.click();

		try {
			Thread.sleep(1000); // Thread.sleep(10000); // Thread.sleep(10000);
		}

		catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		// waitForSubmitForApprovalWindow();

		// check for 'No Applicable process available' - dialogue appears
		try {
			if (salesforceOpportunityControls.NoApplicableProcessAvailable_Label.isDisplayed()) {
				Assert.fail("'No Applicable process available' - dialogue appears");
				throw new NoSuchElementException("'No Applicable process available' - dialogue appears");

			}

		} catch (Exception e) {
			System.out.println("'No Applicable process available' - dialogue did not appear");
		}

	}

	public void clickLogoutBharatAgrawal() {

		waitforElementforInterval(WaitOppEleName.LOGOUTBHARATAGRAWAL_LINK,
				TestBase.global_configProperties.get("waituntil"));

		// waitForLogOutLink();

		salesforceOpportunityControls.LogoutBharatAgrawal.click();

		/*
		 * try { salesforceOpportunityControls.LogoutBharatAgrawal.click(); } catch
		 * (NoSuchElementException e) { // TODO Auto-generated catch block try {
		 * Thread.sleep(500); salesforceOpportunityControls.LogoutBharatAgrawal.click();
		 * } catch (InterruptedException ie) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (NoSuchElementException ne) { // TODO
		 * Auto-generated catch block throw ne; } //
		 * salesforceOpportunityControls.LogoutBharatAgrawal.click(); } catch
		 * (TimeoutException e) { // TODO Auto-generated catch block try { Robot robot;
		 * try { robot = new Robot(); robot.keyPress(KeyEvent.VK_F5);
		 * robot.keyRelease(KeyEvent.VK_F5); } catch (AWTException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } } catch (TimeoutException
		 * te) { throw te; } }
		 */

		try {
			Thread.sleep(10000);
			Thread.sleep(10000);
			// Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Logout Bharat Agrawal");
		
		//Check for SSo - Card Authentication
		try {
			if(salesforceOpportunityControls.AuthenticateSubmit_Btn.isDisplayed())
				salesforceOpportunityControls.AuthenticateSubmit_Btn.click();; // Shell SSO		

		} catch (Exception e) {
		}
		
		

	}
//	    //#---------Approve the opportunity---------------------------------
//	    When I click on Opportunity Advisor Approval under Approval History

	public void clickOpportunityAdvisorApprovalunderApprovalHistory() {

		WebElement ele = salesforceOpportunityControls.MarkStageAsComplete_Btn;

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

		// Under Approval history >> ("//a[text()='Approval Request Submitted']")
		try {
			if (salesforceOpportunityControls.ApprovalRequestSubmitted_Link.isDisplayed()) {
				System.out.println("Under Approval history >> Approval Request Submitted - Link appears");

			}
		} catch (NoSuchElementException e) {
			System.out.println("Under Approval history >> Approval Request Submitted - Link doesnt appears");
			throw e;
		}

		// Under Approval history >> click Oppurtnity Advisor Approval
		try {
			if (salesforceOpportunityControls.OpportunityAdvisorApproval_Link.isDisplayed()) {
				System.out.println("Under Approval history >> Approval Request Submitted - Link appears");
				salesforceOpportunityControls.OpportunityAdvisorApproval_Link.click();

			}
		} catch (NoSuchElementException e) {
			System.out.println("Under Approval history >> Approval Request Submitted - Link doesnt appears");
			throw e;
		}

	}

	public void clickOpportunityAdvisorfinalApproval() {

		// Under Approval history >> click Oppurtnity Advisor Approval
		try {
			if (salesforceOpportunityControls.OpportunityAdvisorfinalApproval_Link.isDisplayed()) {
				System.out.println("Under Approval history >> Approval Request Submitted - Link appears");
				salesforceOpportunityControls.OpportunityAdvisorfinalApproval_Link.click();

			}
		} catch (NoSuchElementException e) {
			System.out.println("Under Approval history >> Approval Request Submitted - Link doesnt appears");
			throw e;
		}
	}

	public void clickRegionalManagerApproval() {

		salesforceOpportunityControls.RegionalManagerApproval.click();
	}

	public void clickSalesReviewBoardSecretary() {

		salesforceOpportunityControls.SalesReviewBoardSecretary.click();
	}

	public void clickRegionalManagerGoNoGoApproval() {

		try {
			Thread.sleep(20000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		salesforceOpportunityControls.RegionalManagerGoNoGoApproval.click();

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean checkPendingApprovals() {
		try {
			return salesforceOpportunityControls.Approve_Btn.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkIfApprovalHistoryAppears() {
		try {
			return salesforceOpportunityControls.RightSide_Section_ApprovalHistory_Lbl.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void completeApprovalActivity() {

		waitforElementforInterval(WaitOppEleName.MARKSTAGEASCOMPLETE_BTN,
				TestBase.global_configProperties.get("waituntil"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				salesforceOpportunityControls.MarkStageAsComplete_Btn);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-30)");

		waitforElementforInterval(WaitOppEleName.APPROVAL_DROPDOWN, TestBase.global_configProperties.get("waituntil"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.RightSide_Section_ApprovalHistory_Link);

		waitforElementforInterval(WaitOppEleName.APPROVALHISTORY_WINDOW,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.APPROVALHISTORYWINDOW_TABLE,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.APPROVALHISTORYWINDOW_APPROVE_BTN,
				TestBase.global_configProperties.get("waituntil"));

		int tryCount = 0;

		while (checkForApprovalHistoryWindow_Approve_Btn() && tryCount < 4) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e)

			{
				e.printStackTrace();
			}

			salesforceOpportunityControls.ApprovalHistoryWindow_Approve_Btn.click();

			waitforElementforInterval(WaitOppEleName.APPROVEOPPORTUNITY_WINDOW,
					TestBase.global_configProperties.get("waituntil"));

			// clicking on APPROVEOPPORTUNITY_WINDOW >> Approve - Btn
			salesforceOpportunityControls.Approve_ApproveOpportunity_Btn.click();

			waitforElementforInterval(WaitOppEleName.APPROVALHISTORY_WINDOW,
					TestBase.global_configProperties.get("waituntil"));

			waitforElementforInterval(WaitOppEleName.APPROVALHISTORYWINDOW_TABLE,
					TestBase.global_configProperties.get("waituntil"));

			try {
				if (checkForApprovalHistoryWindow_Approve_Btn())
					Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.driver.navigate().refresh();

			waitforElementforInterval(WaitOppEleName.APPROVALHISTORY_WINDOW,
					TestBase.global_configProperties.get("waituntil"));

			waitforElementforInterval(WaitOppEleName.APPROVALHISTORYWINDOW_TABLE,
					TestBase.global_configProperties.get("waituntil"));

			tryCount++;
		}

		this.driver.navigate().back();

		waitforElementforInterval(WaitOppEleName.OPPURTUNITY_LINK, TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.PAGELOAD, TestBase.global_configProperties.get("waituntil"));

	}

	public boolean checkForApprovalHistoryWindow_Approve_Btn() {

		try {
			return salesforceOpportunityControls.ApprovalHistoryWindow_Approve_Btn.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickShow4moreaction() {

		/*
		 * ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)");
		 * 
		 * ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)");
		 */

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				salesforceOpportunityControls.MarkStageAsComplete_Btn);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-30)");

		waitforElementforInterval(WaitOppEleName.APPROVAL_DROPDOWN, TestBase.global_configProperties.get("waituntil"));

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.Show4moreactions, 300,
		 * 10, "Show - moreactions - dropdown");
		 */
		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(salesforceOpportunityControls.Show4moreactions));

		try {
			salesforceOpportunityControls.Show4moreactions.click();
		} catch (ElementClickInterceptedException e) {
			try {
				Thread.sleep(2000);
				// salesforceOpportunityControls.Show4moreactions.click();

			} catch (InterruptedException ie) {
				e.printStackTrace();
			}

		}

		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickShow4moreaction_Second() {

		salesforceOpportunityControls.Show4moreactions_second.click();

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	    Then Test Demo for Risk A L&S tab opens up
	public void OppurtunityForApprove_PageAppears() {
		System.out.println("Test Demo for Risk A L&S tab opens up");
	}

//	    When I click on Approve button
	public void ClickApprove_Link() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			if (salesforceOpportunityControls.OpportunityAdvisorPending_Label.isDisplayed()) {
				salesforceOpportunityControls.Approve_Btn.click();

			}
		} catch (NoSuchElementException e) {
			System.out.println("in 'Opportunity Approval' - page >> the status is not pending. ");
			throw e;
		}
	}

	public void clickApproveButtton() {
		/*
		 * try { Thread.sleep(2000); Thread.sleep(2000); Thread.sleep(2000); } catch
		 * (InterruptedException e)
		 * 
		 * { e.printStackTrace(); }
		 */

		// salesforceOpportunityControls.Approve_Btn.click();

		waitforElementforInterval(WaitOppEleName.APPROVAL_DROPDOWN_MENU,
				TestBase.global_configProperties.get("waituntil"));

		try {
			WebElement ele = salesforceOpportunityControls.Approve_Btn;

			new Actions(driver).moveToElement(ele, 0, 0).perform();
			new Actions(driver).moveToElement(ele, 0, 0).moveToElement(ele).click(ele).perform();

			try {
				Thread.sleep(500);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			;
		} catch (NoSuchElementException e) {
			try {

				clickShow4moreaction();

				WebElement ele = salesforceOpportunityControls.Approve_Btn;

				new Actions(driver).moveToElement(ele, 0, 0).perform();
				new Actions(driver).moveToElement(ele, 0, 0).moveToElement(ele).click(ele).perform();

			} catch (NoSuchElementException ex) {
				throw ex;
			}

		}

	}

	public void clickApproveRiskCButtton() {
		try {
			Thread.sleep(20000);
			Thread.sleep(2000);
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityControls.Approve_RiskC_Btn.click();
	}

	public void clickApproveRiskBButton() {
		try {
			Thread.sleep(20000);
			Thread.sleep(2000);
			Thread.sleep(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		salesforceOpportunityControls.Approve_RiskB_Btn.click();
	}

//	    Then Approve Opportunity window appears
	public void ApproveOpportunityWindowAppears() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Approve Opportunity window appears");
	}

//	    Then I input "test" in comments edit box
	public void inputCommentsEditBox() {

		System.out.println("I input \"test\" in comments edit box");
	}

//	    And click on Approve button 
	public void clickApproveButton() {

		salesforceOpportunityControls.Approve_ApproveOpportunity_Btn.click();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyOppurtunityApproved() {

		// on the page - Oppurtnity Approval [approved Status]
		try {
			if (salesforceOpportunityControls.OpportunityApproved_Label.isDisplayed()) {
				System.out.println("in 'Opportunity Approval' - page >> the status is Approved. ");

			}
		} catch (NoSuchElementException e) {
			System.out.println("in 'Opportunity Approval' - page >> the status is not Approved. ");
			throw e;
		}
	}

//=======
	public void inputIPFees(String strIPfees) {
		salesforceOpportunityControls.IPFees_Txtbox.clear();
		salesforceOpportunityControls.IPFees_Txtbox.sendKeys(strIPfees);
	}

	public void inputManpowerCosts(String strManpowerCosts) {
		salesforceOpportunityControls.ManpowerCosts_Txtbox.clear();
		salesforceOpportunityControls.ManpowerCosts_Txtbox.sendKeys(strManpowerCosts);
	}

	public void inputManpowerHours(String strManpowerHours) {
		salesforceOpportunityControls.ManpowerHours_Txtbox.clear();
		salesforceOpportunityControls.ManpowerHours_Txtbox.sendKeys(strManpowerHours);
	}

	public void clickTypeofRates_Dropdown() {

		salesforceOpportunityControls.TypeofRates_Dropdown.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salesforceOpportunityControls.CostTariffs_TypesofRates.click();
	}

	public void inputBillingAccountant(String strBillingAccountant) {
		salesforceOpportunityControls.BillingAccountant_Txtbox.clear();
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(strBillingAccountant);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys("m");
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys("m");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys("m");
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys("m");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys("m");
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys("m");

	}

	public void clickBillingAccountant(String arg1) {

//		WebElement eleBillingAccountant = null;
//		
//		try {
//			eleBillingAccountant = salesforceOpportunityControls.BillingAccountant(arg1);
//		} catch (Exception e) {
//		}

		int ct = 0;

		while (!checkForBillingAccountLink(arg1)
				&& ct < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
			System.out.println("Waiting for - BillingAccountant-DropDown Menu");

			inputForBillingAccountant(arg1);

			ct++;
			if (ct == Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {
				throw new NoSuchElementException("WebElement:: 'BillingAccountant' -DropDown Menu Not Found");
			}

		}

		WebElement ele = salesforceOpportunityControls.BillingAccountant(arg1);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}

	public boolean checkForBillingAccountLink(String arg) {

		try {
			return salesforceOpportunityControls.BillingAccountant(arg).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void inputForBillingAccountant(String arg1) {

		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox
				.sendKeys(arg1.substring(arg1.length() - 2, arg1.length()));
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox.sendKeys(Keys.BACK_SPACE);
		salesforceOpportunityControls.BillingAccountant_Txtbox
				.sendKeys(arg1.substring(arg1.length() - 2, arg1.length()));
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkmailProjectSetup() {

		salesforceOpportunityControls.EmailProjectSetup_Checkbox.click();

	}

	// ****************Add Cash Forecast***************************************

	public void clickAddCashForcast() {

		waitforElementforInterval(WaitOppEleName.ADDCASHFORCAST_BTN, TestBase.global_configProperties.get("waituntil"));

		salesforceOpportunityControls.AddCashForcast_Btn.click();

		// SaveAddCashForecast_Btn
		waitforElementforInterval(WaitOppEleName.ADDCASHFORECAST_WINDOW,
				TestBase.global_configProperties.get("waituntil"));

		System.out.println("Add Cash to Forcast appears");
	}

	public void inputRevenueAmount(String strRevenueAmount) {
		salesforceOpportunityControls.RevenueAmount_Txtbox.clear();
		salesforceOpportunityControls.RevenueAmount_Txtbox.sendKeys(strRevenueAmount);
	}

	public void clickMonth_AddCashForecast() {

		salesforceOpportunityControls.Month_AddCashForecast_Dropdown.click();
	}

	public void clickJanuary_Month_AddCashForecast(String arg1) {

		salesforceOpportunityControls.January_Month_AddCashForecast(arg1).click();
	}

	public void clickYear_AddCashForecastDropdown() {

		salesforceOpportunityControls.Year_AddCashForecast_Dropdown.click();
	}

	public void clickYear_AddCashForecast(String arg1) {

		salesforceOpportunityControls.Year_AddCashForecast(arg1).click();
	}

	public void inputDescription_AddCashForecast(String strDescription) {
		salesforceOpportunityControls.Description_AddCashForecast_Txtbox.clear();
		salesforceOpportunityControls.Description_AddCashForecast_Txtbox.sendKeys(strDescription);
	}

	public void clickSaveAddCashForecast() {

		salesforceOpportunityControls.SaveAddCashForecast_Btn.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public void clickOpportunityRiskAssessments() {
	 * 
	 * salesforceOpportunityControls.OpportunityRiskAssessments_Btn.click(); }
	 * 
	 * public void clickNew_OpportunityRiskAssessments() {
	 * 
	 * salesforceOpportunityControls.New_OpportunityRiskAssessments_Btn.click(); }
	 */

	public void clickNext_OpportunityRiskAssessments() {

		salesforceOpportunityControls.Next_OpportunityRiskAssessments_Btn.click();
	}

	public void clickHSSE() {

		salesforceOpportunityControls.HSSE_Dropdown.click();
	}

	public void clickA_HSSE() {

		salesforceOpportunityControls.A_HSSE.click();
	}

	public void clickCompliance() {

		salesforceOpportunityControls.Compliance_Dropdown.click();
	}

	public void clickA_Compliance() {

		salesforceOpportunityControls.A_Compliance.click();
	}

	public void clickExportControlIncGEC() {

		salesforceOpportunityControls.ExportControlIncGEC_Dropdown.click();
	}

	public void clickA_ExportControlIncGEC() {

		salesforceOpportunityControls.A_ExportControlIncGEC.click();
	}

	public void clickConflictofInterest() {

		salesforceOpportunityControls.ConflictofInterest_Dropdown.click();
	}

	public void clickA_ConflictofInterest() {

		salesforceOpportunityControls.A_ConflictofInterest.click();
	}

	public void clickCompetitivelySensitiveInformation() {

		salesforceOpportunityControls.CompetitivelySensitiveInformation_Dropdown.click();
	}

	public void clickA_CompetitivelySensitiveInformation() {

		salesforceOpportunityControls.A_CompetitivelySensitiveInformation.click();
	}

	public void clickAntiBriberyCorruptionRisk() {

		salesforceOpportunityControls.AntiBriberyCorruptionRisk_Dropdown.click();
	}

	public void clickA_AntiBriberyCorruptionRisk() {

		salesforceOpportunityControls.A_AntiBriberyCorruptionRisk.click();
	}

	public void clickDelays() {

		salesforceOpportunityControls.Delays_Dropdown.click();
	}

	public void clickA_Delays() {

		salesforceOpportunityControls.A_Delays.click();
	}

	public void clickScopeChange() {

		salesforceOpportunityControls.ScopeChange_Dropdown.click();
	}

	public void clickA_ScopeChange() {

		salesforceOpportunityControls.A_ScopeChange.click();
	}

	public void clickTechnicalDelivery() {

		salesforceOpportunityControls.TechnicalDelivery_Dropdown.click();
	}

	public void clickA_TechnicalDelivery() {

		salesforceOpportunityControls.A_TechnicalDelivery.click();
	}

	public void clickCatalystAvailability() {

		salesforceOpportunityControls.CatalystAvailability_Dropdown.click();
	}

	public void clickA_CatalystAvailability() {

		salesforceOpportunityControls.A_CatalystAvailability.click();
	}

	public void clickSecondment_Dropdown() {

		salesforceOpportunityControls.Secondment_Dropdown.click();
	}

	public void clickA_Secondment() {

		salesforceOpportunityControls.A_Secondment.click();
	}

	public void clickVisitorsToCustomerPlant() {

		salesforceOpportunityControls.VisitorsToCustomerPlant_Dropdown.click();
	}

	public void clickA_VisitorsToCustomerPlant() {

		salesforceOpportunityControls.A_VisitorsToCustomerPlant.click();
	}

	public void clickPEOnsitePresence() {

		salesforceOpportunityControls.PEOnsitePresence_Dropdown.click();
	}

	public void clickA_PEOnsitePresence() {

		salesforceOpportunityControls.A_PEOnsitePresence.click();
	}

	public void clickBaselineDataVolatility() {

		salesforceOpportunityControls.BaselineDataVolatility_Dropdown.click();
	}

	public void clickA_BaselineDataVolatility() {

		salesforceOpportunityControls.A_BaselineDataVolatility.click();
	}

	public void clickFreedomOfAction() {

		salesforceOpportunityControls.FreedomOfAction_Dropdown.click();
	}

	public void clickA_FreedomOfAction() {

		salesforceOpportunityControls.A_FreedomOfAction.click();
	}

	public void clickIPContamination() {

		salesforceOpportunityControls.IPContamination_Dropdown.click();
	}

	public void clickA_IPContamination() {

		salesforceOpportunityControls.A_IPContamination.click();
	}

	public void clickLiability() {

		salesforceOpportunityControls.Liability_Dropdown.click();
	}

	public void clickA_Liability() {

		salesforceOpportunityControls.A_Liability.click();
	}

	public void clickIndemnity() {

		salesforceOpportunityControls.Indemnity_Dropdown.click();
	}

	public void clickA_Indemnity() {

		salesforceOpportunityControls.A_Indemnity.click();
	}

	public void clickInsurance() {

		salesforceOpportunityControls.Insurance_Dropdown.click();
	}

	public void clickA_Insurance() {

		salesforceOpportunityControls.A_Insurance.click();
	}

	public void clickLawArbitration() {

		salesforceOpportunityControls.LawArbitration_Dropdown.click();
	}

	public void clickA_LawArbitration() {

		salesforceOpportunityControls.A_LawArbitration.click();
	}

	public void clickForceMajeure() {

		salesforceOpportunityControls.ForceMajeure_Dropdown.click();
	}

	public void clickA_ForceMajeure() {

		salesforceOpportunityControls.A_ForceMajeure.click();
	}

	public void clickChangeofOwnership() {

		salesforceOpportunityControls.ChangeofOwnership_Dropdown.click();
	}

	public void clickA_ChangeofOwnership() {

		salesforceOpportunityControls.A_ChangeofOwnership.click();
	}

	public void clickPaymentStructure() {

		salesforceOpportunityControls.PaymentStructure_Dropdown.click();
	}

	public void clickA_PaymentStructure() {

		salesforceOpportunityControls.A_PaymentStructure.click();
	}

	public void clickPaymentTerms() {

		salesforceOpportunityControls.PaymentTerms_Dropdown.click();
	}

	public void clickA_PaymentTerms() {

		salesforceOpportunityControls.A_PaymentTerms.click();
	}

	public void clickLatePaymentInterestRate_Dropdown() {

		salesforceOpportunityControls.LatePaymentInterestRate_Dropdown.click();
	}

	public void clickA_LatePaymentInterestRate() {

		salesforceOpportunityControls.A_LatePaymentInterestRate.click();
	}

	public void clickDealCustomerCreditCheck() {

		salesforceOpportunityControls.DealCustomerCreditCheck_Dropdown.click();
	}

	public void clickA_DealCustomerCreditCheck() {

		salesforceOpportunityControls.A_DealCustomerCreditCheck.click();
	}

	public void clickForeignExchangeRate() {

		salesforceOpportunityControls.ForeignExchangeRate_Dropdown.click();
	}

	public void clickA_ForeignExchangeRate() {

		salesforceOpportunityControls.A_ForeignExchangeRate.click();
	}

	public void clickTaxes() {

		salesforceOpportunityControls.Taxes_Dropdown.click();
	}

	public void clickA_Taxes() {

		salesforceOpportunityControls.A_Taxes.click();
	}

	public void clickInflation() {

		salesforceOpportunityControls.Inflation_Dropdown.click();
	}

	public void clickA_Inflation() {

		salesforceOpportunityControls.A_Inflation.click();
	}

	public void clickAssignment() {

		salesforceOpportunityControls.Assignment_Dropdown.click();
	}

	public void clickA_Assignment() {

		salesforceOpportunityControls.A_Assignment.click();
	}

	public void clickProvideBankGuarantee() {

		salesforceOpportunityControls.ProvideBankGuarantee_Dropdown.click();
	}

	public void clickA_ProvideBankGuarantee() {

		salesforceOpportunityControls.A_ProvideBankGuarantee.click();
	}

	public void clickAuditRights() {

		salesforceOpportunityControls.AuditRights_Dropdown.click();
	}

	public void clickA_AuditRights() {

		salesforceOpportunityControls.A_AuditRights.click();
	}

	public void clickAgreementValue() {

		salesforceOpportunityControls.AgreementValue_Dropdown.click();
	}

	public void clickA_AgreementValue() {

		salesforceOpportunityControls.A_AgreementValue.click();
	}

	public void clickCommercialRatesInflator() {

		salesforceOpportunityControls.CommercialRatesInflator_Dropdown.click();
	}

	public void clickA_CommercialRatesInflator() {

		salesforceOpportunityControls.A_CommercialRatesInflator.click();
	}

	public void clickMargin() {

		salesforceOpportunityControls.Margin_Dropdown.click();
	}

	public void clickA_Margin() {

		salesforceOpportunityControls.A_Margin.click();
	}

	public void clickMarginOnManPower() {

		salesforceOpportunityControls.MarginOnManPower_Dropdown.click();
	}

	public void clickA_MarginOnManPower() {

		salesforceOpportunityControls.A_MarginOnManPower.click();
	}

	public void clickCashFlow() {

		salesforceOpportunityControls.CashFlow_Dropdown.click();
	}

	public void clickA_CashFlow() {

		salesforceOpportunityControls.A_CashFlow.click();
	}

	public void clickBrandRaputation() {

		salesforceOpportunityControls.BrandRaputation_Dropdown.click();
	}

	public void clickA_BrandRaputation() {

		salesforceOpportunityControls.A_BrandRaputation.click();
	}

	public void clickEffectiveDate() {

		salesforceOpportunityControls.EffectiveDate_Dropdown.click();
	}

	public void clickA_EffectiveDate() {

		salesforceOpportunityControls.A_EffectiveDate.click();
	}

	public void clickWarantyGuarantees() {

		salesforceOpportunityControls.WarantyGuarantees_Dropdown.click();
	}

	public void clickA_WarantyGuarantees() {

		salesforceOpportunityControls.A_WarantyGuarantees.click();
	}

	public void clickTermination() {

		salesforceOpportunityControls.Termination_Dropdown.click();
	}

	public void clickA_Termination() {

		salesforceOpportunityControls.A_Termination.click();
	}

	public void clickProfessionalCertificationRegistration() {

		salesforceOpportunityControls.ProfessionalCertificationRegistration_Dropdown.click();
	}

	public void clickA_ProfessionalCertificationRegistration() {

		salesforceOpportunityControls.A_ProfessionalCertificationRegistration.click();
	}

	public void clickRelationshipRisks() {

		salesforceOpportunityControls.RelationshipRisks_Dropdown.click();
	}

	public void clickA_RelationshipRisks() {

		salesforceOpportunityControls.A_RelationshipRisks.click();
	}

	public void inputOtherOpportunity_Textbox(String strOther) {
		salesforceOpportunityControls.OtherOpportunity_Textbox.clear();
		salesforceOpportunityControls.OtherOpportunity_Textbox.sendKeys(strOther);
	}

	public void clickSave_Opportunity_Btn() {

		salesforceOpportunityControls.Save_Opportunity_Btn.click();
	}

//***********************Submit for Approval**************************

	public void clickSubmitForApproval() {

		salesforceOpportunityControls.SubmitForApproval_Btn.click();
	}

	public void clickSubmit_SubmitForApproval() {

		salesforceOpportunityControls.Submit_SubmitForApproval.click();
	}

//********************Approve Opportunity*******************************
	/* >>>>>>> 1a6b6233a42405972b847868d7cabc777ccb8aa1 */

	public void clickOpportunityAdvisorApproval() {

		salesforceOpportunityControls.OpportunityAdvisorApproval_Link.click();
	}

	public void clickApprove() {

		salesforceOpportunityControls.Approve_Btn.click();
	}

	public void inputComments_ApproveOpportunity_Txtbox(String strComments_ApproveOpportunity) {
		salesforceOpportunityControls.Comments_ApproveOpportunity_Txtbox.clear();
		salesforceOpportunityControls.Comments_ApproveOpportunity_Txtbox.sendKeys(strComments_ApproveOpportunity);
	}

	public void clickApprove_ApproveOpportunity() {

		salesforceOpportunityControls.Approve_ApproveOpportunity_Btn.click();
	}

	public void clickTestDemoforRiskALS() {

		salesforceOpportunityControls.TestDemoforRiskALS_Link.click();
	}

	public void clickRiskBLSDemo() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.RiskBLSDemo_link);

//		salesforceOpportunityControls.RiskBLSDemo_link.click();
	}

	public void clickRiskCLS() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.RiskCLSDemo_link);

//		salesforceOpportunityControls.RiskBLSDemo_link.click();
	}

	public void clickRiskCLSDemo() {

		salesforceOpportunityControls.TestRiskCLS_Link.click();
	}

	public void clickRiskCLS_Link() {

		salesforceOpportunityControls.RiskCLS_Link.click();
	}

	public void clickRiskAnon3rdpartyDemo() {

		salesforceOpportunityControls.RiskAnonThirdParty_Link.click();
	}

	public void clickOpportunityApproved_Label() {

		salesforceOpportunityControls.OpportunityApproved_Label.click();
	}

	public void chkErrorsInEditDialogue() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (salesforceOpportunityControls.Reload_Btn.isDisplayed()) {
				salesforceOpportunityControls.Reload_Btn.click();
				try {
					Thread.sleep(1000);
					// Thread.sleep(10000);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clickEdit();
//				inputValueHypothesis("test");
//				inputOpportunityAdvisor("Pa");
//				inputOpportunityAdvisor("ul");
//				inputOpportunityAdvisor("ine Ho");
//				inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
//				inputOpportunityAdvisor("o");
//				inputOpportunityAdvisor(Keys.BACK_SPACE.toString());
//				inputOpportunityAdvisor("o");
//
//				clickPaulineHo(arg1);
//				inputEstimatedAquisitioncost("565656");
//
//				clickResponsetoITBRFQ();
//				Yes_ResponsetoITBRFQ();
//				inputGoGetEvidence("test");
//				inputValuetoCustomer("test");
//				inputValueShellPartner("test");
//				inputWinningStrategy("test");
				clickSaveButton();
			}
		} catch (NoSuchElementException e) {
			System.out.println("No error occured");
			// throw e;
		}

	}

	public void chkErrorsInDesignEditDialogue() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (salesforceOpportunityControls.Reload_Btn.isDisplayed()) {
				salesforceOpportunityControls.Reload_Btn.click();

				String arg1 = null;

				clickEdit();
				inputMainDeliveryGroup1("test");
				inputMainDeliveryGroup2("test");
				inputMainDeliveryGroup3("test");
				inputMainDeliveryGroup4("test");
				inputMainDeliveryGroup5("test");
				inputCalDayXBorder("34");
				clickConfirmedByCatGM();
				clickNA_ConfirmedByCatGM(arg1);
				clickShellEntity();
				clickShellChinaPTLimitedCN40_ShellEntity(arg1);
				inputExpenses("1000");
				clickMovingforwardStandaloneBasis();
				clickYes_MovingforwardStandalonBasis(arg1);
				clickStandardTermsConditions();
				clickYes_StandardTermsConditions(arg1);
				inputIPFees("10");
				inputManpowerCosts("200");
				inputManpowerHours("46");
				inputBillingAccountant("Lavakumara arunachalam");
				clickBillingAccountant(arg1);
				checkmailProjectSetup();
				clickSaveButton();
				// clickSaveButton();
			}
		} catch (NoSuchElementException e) {
			System.out.println("No error occured");
			// throw e;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// **************************Call
	// Plan/Report*********************************************************************************

	public void clickAccounts_link() {

		/*
		 * try { Thread.sleep(200); } catch (InterruptedException e)
		 * 
		 * { e.printStackTrace(); }
		 */

		waitforElementforInterval(WaitOppEleName.ACCOUNTS_LINK, TestBase.global_configProperties.get("waituntil"));

		// WaitUntilElementAppears(salesforceOpportunityControls.Accounts_link, 120, 10,
		// "Accounts _ link");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Accounts_link);

	}

	public void clickNext_NewAccounts() {

		/*
		 * try { Thread.sleep(200); } catch (InterruptedException e)
		 * 
		 * { e.printStackTrace(); }
		 */

		waitforElementforInterval(WaitOppEleName.NEXT_NEWACCOUNTS, TestBase.global_configProperties.get("waituntil"));

		// WaitUntilElementAppears(salesforceOpportunityControls.Next_NewAccounts, 120,
		// 10, "Next _ NewAccounts");

		salesforceOpportunityControls.Next_NewAccounts.click();
	}

	public void clickTestAutomationServicesLLC() {

		salesforceOpportunityControls.TestAutomationServicesLLC.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickParentAccDropdownElement(String ddName) {

		//salesforceOpportunityControls.ParentAccount_Dropdown_Element(ddName).click();
		salesforceOpportunityControls.ParentAccountDropdown(ddName).click();
		
		//ParentAccountDropdown
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkActivity_CallEmail_Tab(String callplan) {
		
		

		waitforElementforInterval(WaitOppEleName.

				NEWCALLPLANWINDOW_CALLPLAN_LBL, TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.

				NEWCALLPLANWINDOW_CALLPLAN_NAME, TestBase.global_configProperties.get("waituntil"));
		
		Assert.assertTrue(
				salesforceOpportunityControls.NewCallPlanWindow_CallPlan_Name.getText().toLowerCase().trim()
						.contains(callplan.toLowerCase().trim()),
				"\n********************************************************************************************************************************************\n"
						+ "The contact with  name : " + callplan + "was not created."
						+ "\n********************************************************************************************************************************************\n");

	}

	public void clickActivity_CallEmail_Tab() {

		WaitUntilElementAppears(salesforceOpportunityControls.Activity_CallEmail_Tab, 120, 10,
				"Activity_CallEmail_Tab");

		salesforceOpportunityControls.Activity_CallEmail_Tab.click();
	}

	public void clickEmail_CallEmail_Link() {

		// salesforceOpportunityControls.Email_CallEmail_Link.click();
		WaitUntilElementAppears(salesforceOpportunityControls.Email_CallEmail_Link, 120, 10, "Email_CallEmail_Link");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Email_CallEmail_Link);
	}

	public void clickWriteAnEmail_Button() {

		// salesforceOpportunityControls.WriteAnEmail_Button.click();
		WaitUntilElementAppears(salesforceOpportunityControls.WriteAnEmail_Button, 120, 10, "WriteAnEmail_Button");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.WriteAnEmail_Button);
	}

	public void inputTo_Txtbox(String text) {

		WaitUntilElementAppears(salesforceOpportunityControls.To_Txtbox, 120, 10, "To_Txtbox");

		salesforceOpportunityControls.To_Txtbox.sendKeys(text);
	}

	public void clickSend_Email_Btn() {

		// salesforceOpportunityControls.Send_Email_Btn.click();

		WaitUntilElementAppears(salesforceOpportunityControls.Send_Email_Btn, 120, 10, "Send_Email_Btn");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Send_Email_Btn);
	}

	public void clickToday_Dropdown() {

		// salesforceOpportunityControls.Today_Dropdown.click();

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,500);");

		WaitUntilElementAppears(salesforceOpportunityControls.Today_Dropdown, 120, 10, "Today_Dropdown");

		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Today_Dropdown);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	public void clickDelete_Today() {

		WaitUntilElementAppears(salesforceOpportunityControls.Delete_Today, 120, 10, "Delete_Today");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Delete_Today);
	}

	public void clickDelete_DeleteEmailMessage_Btn() {
		WaitUntilElementAppears(salesforceOpportunityControls.Delete_DeleteEmailMessage_Btn, 120, 10,
				"Delete_DeleteEmailMessage_Btn");

		salesforceOpportunityControls.Delete_DeleteEmailMessage_Btn.click();
	}

	// ********NEW
	// CONTACT************************************************************************************************************************************************************

	public void clickContacts_link() {

		WaitUntilElementAppears(salesforceOpportunityControls.Contacts_link, 120, 10, "Contacts_link");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Contacts_link);

	}

	public void PlanOrReportwindow() {

		System.out.println("Plan/Report tab opens");

		/*
		 * waitforElementforInterval(WaitOppEleName.CONTACTSTAB__SENDLISTEMAIL_BTN,
		 * TestBase.global_configProperties.get("waituntil"));
		 */

	}

	public void Contactwindow() {

		System.out.println("Contact tab opens");

		waitforElementforInterval(WaitOppEleName.CONTACTSTAB__SENDLISTEMAIL_BTN,
				TestBase.global_configProperties.get("waituntil"));

	}

	public void NewContactWindow() {

		System.out.println("New Contact Window appears");

		waitforElementforInterval(WaitOppEleName.CONTACTSTAB__SAVE_NEWCONTACT,
				TestBase.global_configProperties.get("waituntil"));
	}

	public void SelectSalutation() {

		WaitUntilElementAppears(salesforceOpportunityControls.Salutation_Dropdown, 120, 10, "Salutation_Dropdown");

		salesforceOpportunityControls.Salutation_Dropdown.click();
		salesforceOpportunityControls.Mr_Salutation.click();

	}
	
	public String getURL() {

		String url = this.driver.getCurrentUrl();

		return url;
	}
	
	public void navigateToURL(String url) {

		this.driver.navigate().to(url);;

	}

	public String input_LastName() {

		String lastName = "xyz";

		Random Rand = new Random();
		int rand_int1 = Rand.nextInt(1000);

		StringBuffer sb = new StringBuffer();
		sb.append(lastName);
		sb.append(rand_int1);

		// sb = new StringBuffer("xyz824");

		WaitUntilElementAppears(salesforceOpportunityControls.LastName_Txtbox, 120, 10, "LastName_Txtbox");

		salesforceOpportunityControls.LastName_Txtbox.sendKeys(sb);

		return sb.toString();
	}

	public void input_Email() {

		String lastName = "xyz";
		String syntax = "@xx.com";

		Random Rand = new Random();
		int rand_int1 = Rand.nextInt(1000);

		StringBuffer sb = new StringBuffer();
		sb.append(lastName);
		sb.append(rand_int1);
		sb.append(syntax);

		// sb = new StringBuffer("xyz275@xx.com");

		WaitUntilElementAppears(salesforceOpportunityControls.Email_Txtbox, 120, 10, "Email_Txtbox");

		salesforceOpportunityControls.Email_Txtbox.sendKeys(sb);
	}

	public void click_Save_NewContacts() {

		WaitUntilElementAppears(salesforceOpportunityControls.Save_NewContact, 120, 10, "Save_NewContact");

		salesforceOpportunityControls.Save_NewContact.click();

		/*
		 * waitforElementforInterval(WaitOppEleName.
		 * CONTACTSTAB__SENDLISTEMAIL_BTN,TestBase.global_configProperties.get(
		 * "waituntil"));
		 */

	}

	public boolean checkForDuplcateContactWindow() {

		try {
			return salesforceOpportunityControls.DuplicateContact__Window.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkForNewContact__Contact_Lbl() {

		try {
			return salesforceOpportunityControls.NewContact__Contact_Lbl.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void chec_new_contact_created(String contactName) {

		int tryCount = 0;

		while (!checkForNewContact__Contact_Lbl()
				&& tryCount < Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) {

			if (checkForDuplcateContactWindow()) {
				waitforElementforInterval(WaitOppEleName.DUPLICATECONTACT__WINDOW_SAVE_BTN,
						TestBase.global_configProperties.get("waituntil"));
				salesforceOpportunityControls.DuplicateContact__Window_Save_Btn.click();
			}

			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tryCount++;
		}

		waitforElementforInterval(WaitOppEleName.NEWCONTACT__CONTACT_LBL,
				TestBase.global_configProperties.get("waituntil"));

		waitforElementforInterval(WaitOppEleName.NEWCONTACT__CONTACT_NAME,
				TestBase.global_configProperties.get("waituntil"));

		Assert.assertTrue(
				salesforceOpportunityControls.NewContact__Contact_Name.getAttribute("title").toLowerCase().trim()
						.contains(contactName.toLowerCase().trim()),
				"\n********************************************************************************************************************************************\n"
						+ "The contact with last name : " + contactName + "was not created."
						+ "\n********************************************************************************************************************************************\n"

		);

		/*
		 * Assert.assertEquals(contactName.trim().toLowerCase(),
		 * salesforceOpportunityControls.ContactsTab__ContactsTable_LastName.getText().
		 * trim().toLowerCase(),
		 * "\n********************************************************************************************************************************************\n"
		 * +"The contact with last name : "+contactName +"was not created."+
		 * "\n********************************************************************************************************************************************\n"
		 * 
		 * );
		 * 
		 * 
		 * waitforElementforInterval(WaitOppEleName.
		 * REFRESH_BTN,TestBase.global_configProperties.get("waituntil"));
		 * 
		 * waitforElementforInterval(WaitOppEleName.
		 * CONTACTSTAB__CONTACTSTABLE_CONTACTOWNERALIAS_LBL,TestBase.
		 * global_configProperties.get("waituntil"));
		 * 
		 * salesforceOpportunityControls.Refresh_Btn.click();
		 * 
		 * 
		 * int tryCount = 0;
		 * 
		 * while (checkForOpportunitySpinner() && tryCount <
		 * Integer.parseInt(TestBase.global_configProperties.get("waituntil"))) { try {
		 * Thread.sleep(800); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } tryCount++; }
		 * 
		 * 
		 * waitforElementforInterval(WaitOppEleName.
		 * CONTACTSTAB__SENDLISTEMAIL_BTN,TestBase.global_configProperties.get(
		 * "waituntil"));
		 * 
		 * waitforElementforInterval(WaitOppEleName.
		 * CONTACTSTAB__CONTACTSTABLE_CONTACTOWNERALIAS_LBL,TestBase.
		 * global_configProperties.get("waituntil"));
		 * 
		 * waitforElementforInterval(WaitOppEleName.
		 * CONTACTSTAB__CONTACTSTABLE_LASTNAME,TestBase.global_configProperties.get(
		 * "waituntil"));
		 * 
		 * Assert.assertEquals(contactName.trim().toLowerCase(),
		 * salesforceOpportunityControls.ContactsTab__ContactsTable_LastName.getText().
		 * trim().toLowerCase(),
		 * "\n********************************************************************************************************************************************\n"
		 * +"The contact with last name : "+contactName +"was not created."+
		 * "\n********************************************************************************************************************************************\n"
		 * 
		 * );
		 */

	}

	// ***************LOG A
	// CALL***************************************************************************************************************************************************************************************

	public void clickLogaCall() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		// salesforceOpportunityControls.LogaCall_Link.click();

		WaitUntilElementAppears(salesforceOpportunityControls.LogaCall_Link, 120, 10, "LogaCall_Link");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.LogaCall_Link);

	}

	public void input_Comments_logacall_textarea(String text) {

		waitForEditCommentsWindow();

		WaitUntilElementAppears(salesforceOpportunityControls.Comments_logacall_textarea, 120, 10,
				"Comments_logacall_textarea");

		salesforceOpportunityControls.Comments_logacall_textarea.sendKeys(text);

	}

	public void click_Save_Logacall_btn() {

		// salesforceOpportunityControls.Save_Logacall_btn.click();

		WaitUntilElementAppears(salesforceOpportunityControls.Save_Logacall_btn, 120, 10, "Save_Logacall_btn");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Save_Logacall_btn);
	}

	public void clickShowMoreAction_Btn() {

		// salesforceOpportunityControls.ShowMoreAction_Btn.click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		waitForShowMoreAction_Btn();
		
		

		WaitUntilElementAppears(salesforceOpportunityControls.ShowMoreAction_Btn, 120, 10, "ShowMoreAction_Btn");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.ShowMoreAction_Btn);
	}

	public void clickEdit_ShowMoreAction() {

		// salesforceOpportunityControls.Edit_ShowMoreAction.click();

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.Edit_ShowMoreAction
		 * ,120,10,"Edit_ShowMoreAction");
		 */

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Edit_ShowMoreAction);
	}

	public void clickSave_EditCall() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		waitForEditCallWindow();

		WaitUntilElementAppears(salesforceOpportunityControls.Save_EditCall, 120, 10, "Save_EditCall");
		salesforceOpportunityControls.Save_EditCall.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// salesforceOpportunityControls.Save_EditCall);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}

	public void clickEditComments_ShowMoreAction() {

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.
		 * EditComments_ShowMoreAction ,120,10,"EditComments_ShowMoreAction");
		 */

		// salesforceOpportunityControls.EditComments_ShowMoreAction.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.EditComments_ShowMoreAction);
	}

	public void clickSave_EditComments() {

		// salesforceOpportunityControls.Save_EditComments.click();

		WaitUntilElementAppears(salesforceOpportunityControls.Save_EditComments, 120, 10, "Save_EditComments");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Save_EditComments);
	}

	public void clickChangeDate_ShowMoreAction() {

		// salesforceOpportunityControls.ChangeDate_ShowMoreAction.click();

//		WaitUntilElementAppears(salesforceOpportunityControls.ChangeDate_ShowMoreAction
//				,120,10,"ChangeDate_ShowMoreAction");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.ChangeDate_ShowMoreAction);
	}

	public void clickSave_ChangeDate() {

		// salesforceOpportunityControls.Save_ChangeDate.click();

		WaitUntilElementAppears(salesforceOpportunityControls.Save_ChangeDate, 120, 10, "Save_ChangeDate");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Save_ChangeDate);
	}

	public void clickChangeStatus_ShowMoreAction() {

		// salesforceOpportunityControls.ChangeStatus_ShowMoreAction.click();

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.
		 * ChangeStatus_ShowMoreAction ,120,10,"ChangeStatus_ShowMoreAction");
		 */

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.ChangeStatus_ShowMoreAction);
	}

	public void selectStatus_ChangeStatus() {

		waitForChangeStatusWindow();

		WaitUntilElementAppears(salesforceOpportunityControls.Status_ChangeStatus_Dropdown, 120, 10,
				"Status_ChangeStatus_Dropdown");

		salesforceOpportunityControls.Status_ChangeStatus_Dropdown.click();

		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// salesforceOpportunityControls.Save_EditComments);

		salesforceOpportunityControls.Open_Status_ChangeStatus.click();

		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// salesforceOpportunityControls.Save_EditComments);

	}

	public void clickSave_ChangeStatus() {

		// salesforceOpportunityControls.Save_ChangeStatus.click();

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.Save_ChangeStatus
		 * ,120,10,"Save_ChangeStatus");
		 */

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Save_ChangeStatus);
	}

	public void clickChangePriority_ShowMoreAction() {

		// salesforceOpportunityControls.ChangePriority_ShowMoreAction.click();

		/*
		 * WaitUntilElementAppears(salesforceOpportunityControls.
		 * ChangePriority_ShowMoreAction ,120,10,"ChangePriority_ShowMoreAction");
		 */

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.ChangePriority_ShowMoreAction);
	}

	public void selectPriority_ChangePriority() {

		waitForChangePriorityWindow();

		salesforceOpportunityControls.Priority_ChangePriority_Dropdown.click();
		salesforceOpportunityControls.High_Priority_ChangePriority.click();

	}

	public void clickSave_ChangePriority() {

		WaitUntilElementAppears(salesforceOpportunityControls.Save_ChangePriority, 120, 10, "Save_ChangePriority");

		salesforceOpportunityControls.Save_ChangePriority.click();
	}

	/*
	 * public void clickDelete_Showmoreactions() {
	 * 
	 * // salesforceOpportunityControls.Delete_Showmoreactions.click();
	 * 
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	 * salesforceOpportunityControls.Delete_Showmoreactions); }
	 */

	public void clickDelete_Showmoreactions() {

		// salesforceOpportunityControls.Delete_Showmoreactions.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				salesforceOpportunityControls.Delete_Showmoreactions);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void assertStage(String arg1) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

		String actColor = null;

		if (arg1.contains("Discover")) {
			WaitUntilElementAppears(salesforceOpportunityControls.Stage_Discover_btn, 300, 10, "Stage_Discover_btn");
			actColor = Color.fromString(salesforceOpportunityControls.Stage_Discover_btn.getCssValue("color")).asHex();
		} else if (arg1.contains("Diagnose")) {
			WaitUntilElementAppears(salesforceOpportunityControls.Stage_Diagnose_btn, 300, 10, "Stage_Diagnose_btn");
			actColor = Color.fromString(salesforceOpportunityControls.Stage_Diagnose_btn.getCssValue("color")).asHex();
		} else if (arg1.contains("Design")) {
			WaitUntilElementAppears(salesforceOpportunityControls.Stage_Design_btn, 300, 10, "Stage_Design_btn");
			actColor = Color.fromString(salesforceOpportunityControls.Stage_Design_btn.getCssValue("color")).asHex();
		} else if (arg1.contains("Deliver")) {
			WaitUntilElementAppears(salesforceOpportunityControls.Stage_Delivery_btn, 300, 10, "Stage_Delivery_btn");
			actColor = Color.fromString(salesforceOpportunityControls.Stage_Delivery_btn.getCssValue("color")).asHex();
		}

		Assert.assertEquals("#ffffff", actColor, "Not moved to " + arg1 + "- Stage");

	}

	public void clickDelete_DeleteTask() {

		salesforceOpportunityControls.Delete_DeleteTask_btn.click();
	}

	/*
	 * public void WaitUntilElementAppears(final WebElement webElement,int
	 * intWaitFor,int intpollingEvery ,String errMsg) { WebElement elementFi = null;
	 * Wait wait = new FluentWait(driver)
	 * .withTimeout(Duration.ofSeconds(intWaitFor))
	 * .pollingEvery(Duration.ofSeconds(intpollingEvery))
	 * .ignoring(NoSuchElementException.class); try { elementFi = (WebElement)
	 * wait.until(new Function<WebDriver, WebElement>() { public WebElement
	 * apply(WebDriver driver) {
	 * 
	 * WebElement element = webElement;; return element;
	 * 
	 * } }); }catch(Exception te) { throw new
	 * NoSuchElementException("Object Not Found: "+webElement+"\n"+String.
	 * format("**** \n Details:  %s \n****",errMsg ) ); }
	 * 
	 * }
	 */

	public void WaitUntilElementAppears(WebElement webElement, int intWaitFor, int intpollingEvery, String errMsg) {
		try {
			new FluentWait<WebElement>(webElement).withTimeout(Duration.ofSeconds(intWaitFor))
					.pollingEvery(Duration.ofSeconds(intpollingEvery)).ignoring(NoSuchElementException.class)
					.ignoring(NoSuchElementException.class).until(new Function<WebElement, Boolean>() {
						@Override
						public Boolean apply(WebElement element) {
							return element.isDisplayed() && element.isEnabled();
						}
					});
		} catch (Exception e) {
			throw new NoSuchElementException(
					"Object Not Found: " + webElement + "\n" + String.format("**** \n Details:  %s \n****", errMsg));
		}

	}

	public void page_load_Wait() {

		if (checkPageLoaded()) {
			System.out.println("page has loaded");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkPageLoaded()) {
			System.out.println("page has loaded");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void waitForLogOutLink() {

		if (checkForLogOutLink()) {
			System.out.println("Logout Link appaers");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForLogOutLink()) {
			System.out.println("Logout Link appaers");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void waitForNewButton() {

		if (checkForNew_Btn()) {
			System.out.println("New - Button Under 'Oppurtunities' appaers");
		} else {
			try {
				Thread.sleep(10000);
				// Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void waitForEditWindow() {

		waitforElementforInterval(WaitOppEleName.OPPURTUNITY_EDIT_WINDOW,
				TestBase.global_configProperties.get("waituntil"));

		if (checkForEditWindow()) {
			System.out.println("Edit Window appaers");
		} else {
			try {
				Thread.sleep(10000);
				// Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForEditWindow()) {
			System.out.println("Edit Window appaers");
		} else {
			try {
				Thread.sleep(12000);
				// Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void waitForEditCallWindow() {

		if (checkForEditCallWindow()) {
			System.out.println("Edit Call Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForEditCallWindow()) {
			System.out.println("Edit Call Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean checkForEditCallWindow() {

		try {
			return salesforceOpportunityControls.Save_EditCall.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkForEditCommentsWindow() {

		try {
			return salesforceOpportunityControls.Save_EditComments.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForEditCommentsWindow() {

		if (checkForEditCommentsWindow()) {
			System.out.println("Edit Comments Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForEditCommentsWindow()) {
			System.out.println("Edit Call Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// salesforceOpportunityControls.Save_ChangeDate
	public boolean checkForEditDateWindow() {

		try {
			return salesforceOpportunityControls.Save_ChangeDate.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForEditDateWindow() {

		if (checkForEditDateWindow()) {
			System.out.println("Edit Date Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForEditDateWindow()) {
			System.out.println("Edit Date Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Save_ChangeStatus
	public boolean checkForChangeStatusWindow() {

		try {
			return salesforceOpportunityControls.Save_ChangeStatus.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForChangeStatusWindow() {

		if (checkForChangeStatusWindow()) {
			System.out.println("Edit ChangeStatus Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForChangeStatusWindow()) {
			System.out.println("Edit ChangeStatus Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Save_ChangePriority

	public boolean checkForChangePriorityWindow() {

		try {
			return salesforceOpportunityControls.Save_ChangePriority.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForChangePriorityWindow() {

		if (checkForChangePriorityWindow()) {
			System.out.println("Edit ChangePriority Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForChangePriorityWindow()) {
			System.out.println("Edit ChangePriority Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// ShowMoreAction_Btn
	public boolean checkForShowMoreAction_Btn() {

		try {
			return salesforceOpportunityControls.ShowMoreAction_Btn.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForShowMoreAction_Btn() {
		
		waitforElementforInterval(WaitOppEleName.SHOWMOREACTIONS_DROPDOWN,
				TestBase.global_configProperties.get("waituntil"));


		if (checkForShowMoreAction_Btn()) {
			System.out.println("Edit ShowMoreAction_Btn appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForShowMoreAction_Btn()) {
			System.out.println("Edit ShowMoreAction_Btn appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void check_ForHome_Page() {

		waitforElementforInterval(WaitOppEleName.OPPURTUNITY_LINK, TestBase.global_configProperties.get("waituntil"));

		if (CheckOpportunityLinkAppears()) {
			System.out.println("I am on the Home - page");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (CheckOpportunityLinkAppears()) {
			System.out.println("I am on the Home - page");
		} else {
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				/*
				 * Thread.sleep(10000); Thread.sleep(10000);
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// ShowMoreAction_Btn
	public boolean checkForSubmitForApprovalWindow() {

		try {
			return salesforceOpportunityControls.Submit_SubmitForApproval.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForSubmitForApprovalWindow() {

		if (checkForSubmitForApprovalWindow()) {
			System.out.println("Submit for Approval - Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (checkForSubmitForApprovalWindow()) {
			System.out.println("Submit for Approval - Window appaers");
		} else {
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/*
	 * public void waitforDropDownItemWithInterval(WaitOppEleName eleName, String
	 * waitUntil, String arg1) { int ct = 0;
	 * 
	 * while (!checkOppPagePagedisply(eleName) && ct < Integer.parseInt(waitUntil))
	 * { System.out.println("Waiting for - " + eleName.getName()); switch (eleName)
	 * { case ACCOUNTNAME_DROPDOWN_ITEM: inputForLegalAdvisor(arg1); default: try {
	 * throw new Exception("Not a valid input passed to wait for the WebElement"); }
	 * catch (Exception e) {
	 * 
	 * } ct++; if (ct == Integer.parseInt(waitUntil)) { throw new
	 * NoSuchElementException("WebElement:: " + eleName.getName() + "Not Found"); }
	 * 
	 * } }
	 * 
	 * }
	 */

	public void waitforElementforInterval(WaitOppEleName eleName, String waitUntil) {
		int ct = 0;

		while (!checkOppPagePagedisply(eleName) && ct < Integer.parseInt(waitUntil)) {
			System.out.println("Waiting for - " + eleName.getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct++;
			if (ct == Integer.parseInt(waitUntil)) {
				throw new NoSuchElementException("WebElement:: " + eleName.getName() + "Not Found");
			}

		}
	}

	public boolean checkOppPagePagedisply(WaitOppEleName eleName) {

		// switch statement with int data type
		switch (eleName) {
		case PERMISSIONSETSFRAME:
			try {
//					return driver.findElement(By.xpath("//iframe[@title='Assigned Users : C&T Accredited Deal Maker ~ Salesforce - Unlimited Edition']"))
//							.isDisplayed();
				return salesforceOpportunityControls.PermissionSets_Frame.isDisplayed();
			} catch (Exception e) {
				return false;
			}

		case BHARATAGARWALLOGIN:
			try {
//					return driver.findElement(By.xpath("//a[text()='Agrawal, Bharat']"))
//							.isDisplayed();
				return salesforceOpportunityControls.AgrawalBharat_Link.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case OPPURTUNITY_LINK:
			try {
//					return driver.findElement(By.xpath("//a[text()='Agrawal, Bharat']"))
//							.isDisplayed();
				return salesforceOpportunityControls.Opportunities_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case CREATE_OPP_NEW_BTN:
			try {
//					return driver.findElement(By.xpath("//a[text()='Agrawal, Bharat']"))
//							.isDisplayed();
				return salesforceOpportunityControls.New_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case NEW_OPP_WINDOW:
			try {
//					return driver.findElement(By.xpath("//a[text()='Agrawal, Bharat']"))
//							.isDisplayed();
				return salesforceOpportunityControls.Save_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
			// Stage_Discover_btn
		case PAGELOAD:
			try {
				return salesforceOpportunityControls.Stage_Discover_btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case EDIT_BTN:
			try {
				return salesforceOpportunityControls.Edit_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case OPPURTUNITY_EDIT_WINDOW:
			try {
				return salesforceOpportunityControls.Save_EditRiskBNonThirdParty.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case MARKSTAGEASCOMPLETE_BTN:
			try {
				return salesforceOpportunityControls.MarkStageAsComplete_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case ADDCASHFORCAST_BTN:
			try {
				return salesforceOpportunityControls.AddCashForcast_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case ADDCASHFORECAST_WINDOW:
			try {
				return salesforceOpportunityControls.SaveAddCashForecast_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}

		case RIGHTHND_OPPORTUNITYRISKASSESSMENTS_DEPR_LINK:
			try {
				return salesforceOpportunityControls.RightHnd_OpportunityRiskAssessments_Depr_Link.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case RIGHTHND_OPPORTUNITYRISKASSESSMENTS_DEPR_WINDOW_NEW_BTN:
			try {
				return salesforceOpportunityControls.RightHnd_OpportunityRiskAssessments_Depr_ClikLink_New_Btn
						.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case SUBMITFORAPPROVAL_BTN:
			try {
				return salesforceOpportunityControls.SubmitForApproval_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case SUBMITFORAPPROVALWINDOW:
			try {
				return salesforceOpportunityControls.Submit_SubmitForApproval.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case LOGOUTBHARATAGRAWAL_LINK:
			try {
				return salesforceOpportunityControls.LogoutBharatAgrawal.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case APPROVAL_DROPDOWN:
			try {
				return salesforceOpportunityControls.Show4moreactions.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case APPROVAL_DROPDOWN_MENU:
			try {
				return salesforceOpportunityControls.Approve_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case APPROVAL_DROPDOWN_BTN:
			try {
				return salesforceOpportunityControls.Approve_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case CALLPLANREPORTNAME_TXTBOX:
			try {
				return salesforceOpportunityControls.CallPlanReportName_Txtbox.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case ACCOUNTS_LINK:
			try {
				return salesforceOpportunityControls.Accounts_link.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case NEXT_NEWACCOUNTS:
			try {
				return salesforceOpportunityControls.Next_NewAccounts.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case ACCOUNTNAME_TXTBOX:
			try {
				return salesforceOpportunityControls.AccountName_Txtbox.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case ACCOUNTNAME2_TXTBOX:
			try {
				return salesforceOpportunityControls.AccountName2_Txtbox.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case PARENTACCOUNT_TXTBOX:
			try {
				return salesforceOpportunityControls.ParentAccount_Txtbox.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case ACCOUNT_TXTBOX:
			try {
				return salesforceOpportunityControls.Account_Txtbox.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case AUTOMATION2:
			try {
				return salesforceOpportunityControls.Automation2.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case CASE_ADD_BTN:
			try {
				return salesforceOpportunityControls.Add_btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case NEWTASK_LINK:
			try {
				return salesforceOpportunityControls.NewTask_link.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case NEWEVENT_LINK:
			try {
				return salesforceOpportunityControls.NewEvent_link.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case POST_LINK:
			try {
				return salesforceOpportunityControls.Post_link.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case APPROVALHISTORY_WINDOW:
			try {
				return salesforceOpportunityControls.ApprovalHistory_Window.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case APPROVALHISTORYWINDOW_TABLE:
			try {
				return salesforceOpportunityControls.ApprovalHistoryWindow_Table.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case APPROVALHISTORYWINDOW_APPROVE_BTN:
			try {
				return salesforceOpportunityControls.ApprovalHistoryWindow_Approve_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case APPROVEOPPORTUNITY_WINDOW:
			try {
				return salesforceOpportunityControls.Approve_ApproveOpportunity_Btn.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case OPPURTUNITYSEARCH_TXTBOX:
			try {
				return salesforceOpportunityControls.OppurtunitySearch_TxtBox.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		case OPPURTUNITYNAME_TABLE:
			try {
				return salesforceOpportunityControls.OppurtunityName_Table.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case REFRESH_BTN:
			try {
				return salesforceOpportunityControls.Refresh_Btn.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case QUARTERLYPERFORMANCE_LBL:
			try {
				return salesforceOpportunityControls.AccreditedUser_QuarterlyPerformance_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case ADMIN_RECENTRECORDS_LBL:
			try {
				return salesforceOpportunityControls.Admin_RecentRecords_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case CONTACTSTAB__SENDLISTEMAIL_BTN:
			try {
				return salesforceOpportunityControls.ContactsTab__SendListEmail_Btn.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case CONTACTSTAB__SAVE_NEWCONTACT:
			try {
				return salesforceOpportunityControls.Save_NewContact.isEnabled();
			} catch (Exception e) {
				return false;
			}

		case CONTACTSTAB__CONTACTSTABLE_CONTACTOWNERALIAS_LBL:
			try {
				return salesforceOpportunityControls.ContactsTab__ContactsTable_ContactOwnerAlias_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case CONTACTSTAB__CONTACTSTABLE_LASTNAME:
			try {
				return salesforceOpportunityControls.ContactsTab__ContactsTable_ContactOwnerAlias_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case NEWCONTACT__CONTACT_LBL:
			try {
				return salesforceOpportunityControls.NewContact__Contact_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case NEWCONTACT__CONTACT_NAME:
			try {
				return salesforceOpportunityControls.NewContact__Contact_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case DUPLICATECONTACT__WINDOW:
			try {
				return salesforceOpportunityControls.DuplicateContact__Window.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case DUPLICATECONTACT__WINDOW_SAVE_BTN:
			try {
				return salesforceOpportunityControls.DuplicateContact__Window_Save_Btn.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case CALLPLANREPORTS_RECENTLYVIEWED_LBL:
			try {
				return salesforceOpportunityControls.CallPlanReports_RecentlyViewed_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case NEW_CALLPLANREPORTS_WINDOW:
			try {
				return salesforceOpportunityControls.Save_Btn.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case NEWCALLPLANWINDOW_CALLPLAN_LBL:
			try {
				return salesforceOpportunityControls.NewCallPlanWindow_CallPlan_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case NEWCALLPLANWINDOW_CALLPLAN_NAME:
			try {
				return salesforceOpportunityControls.NewCallPlanWindow_CallPlan_Name.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case SHOWMOREACTIONS_DROPDOWN:
			try {
				return salesforceOpportunityControls.ShowMoreAction_Btn.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case VIEWACCOUNTHIERARCHY_BTN:
			try {
				return salesforceOpportunityControls.ViewAccountHierarchy_Btn.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case NEWACCOUNT__ACCOUNT_LBL:
			try {
				return salesforceOpportunityControls.NewAccount__Account_Lbl.isEnabled();
			} catch (Exception e) {
				return false;
			}
		case NEWACCOUNT__ACCOUNT_NAME:
			try {
				return salesforceOpportunityControls.NewAccount__Account_Name.isEnabled();
			} catch (Exception e) {
				return false;
			}
		

			// ACCOUNTNAME_DROPDOWN_ITEM

		default:
			try {
				throw new Exception("Not a valid input passed to wait for the WebElement");
			} catch (Exception e) {
				return false;
			}
		}
	}

}
