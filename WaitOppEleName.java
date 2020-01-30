package org.shell.tcoe.test.enums;


public enum WaitOppEleName {

	PERMISSIONSETSFRAME("Permission Sets - Frame"), 
	BHARATAGARWALLOGIN("Bharath Agarwal - Login Link"),
	OPPURTUNITY_LINK("Oppurtunity Link"),
	CREATE_OPP_NEW_BTN("Oppurtunity - New Btn"),
	NEW_OPP_WINDOW("New Oppurtunity - Dialogue Window"),
	PAGELOAD("Stage_Discover_btn"),
	EDIT_BTN("Edit_Btn"),
	OPPURTUNITY_EDIT_WINDOW("oppurtunity_edit_window"),
	MARKSTAGEASCOMPLETE_BTN("MarkStageAsComplete_Btn"),
	ADDCASHFORCAST_BTN("AddCashForcast_Btn"),
	ADDCASHFORECAST_WINDOW("AddCashForecast_Window"),
	RIGHTHND_OPPORTUNITYRISKASSESSMENTS_DEPR_LINK("RightHnd_OpportunityRiskAssessments_Depr_Link"),
	RIGHTHND_OPPORTUNITYRISKASSESSMENTS_DEPR_WINDOW_NEW_BTN("RightHnd_OpportunityRiskAssessments_Depr_Window_New_Btn")
	,SUBMITFORAPPROVAL_BTN("SubmitForApproval_Btn")
	,SUBMITFORAPPROVALWINDOW("SubmitForApproval - Window")
	,LOGOUTBHARATAGRAWAL_LINK("LogoutBharatAgrawal - Link")
	,APPROVAL_DROPDOWN("Approval_Dropdown")
	,APPROVAL_DROPDOWN_MENU("Approval_Dropdown_Menu")
	,APPROVAL_DROPDOWN_BTN("Approval_Dropdown_Btn")
	,CALLPLANREPORTNAME_TXTBOX("CallPlanReportName_Txtbox")
	,ACCOUNTS_LINK("Accounts_link")
	,NEXT_NEWACCOUNTS("Next_NewAccounts")
	,ACCOUNTNAME_TXTBOX("AccountName_Txtbox")
	,ACCOUNTNAME2_TXTBOX("AccountName2_Txtbox")
	,PARENTACCOUNT_TXTBOX("ParentAccount_Txtbox")
	,ACCOUNT_TXTBOX("Account_Txtbox")
	,AUTOMATION2("Automation2")
	,CASE_ADD_BTN("Case_Add_btn")
	,NEWTASK_LINK("NewTask_link")
	,NEWEVENT_LINK("NewEvent_link")
	,POST_LINK("Post_link")
	,APPROVALHISTORY_WINDOW("ApprovalHistory_Window")
	,APPROVALHISTORYWINDOW_TABLE("ApprovalHistoryWindow_Table")
	,APPROVALHISTORYWINDOW_APPROVE_BTN("ApprovalHistoryWindow_Approve_Btn")
	,APPROVEOPPORTUNITY_WINDOW("ApproveOpportunity_Window")
	,OPPURTUNITYSEARCH_TXTBOX("OppurtunitySearch_TxtBox")
	,OPPURTUNITYNAME_TABLE("OppurtunityName_Table")	
	,REFRESH_BTN("Refresh_Btn")
	,QUARTERLYPERFORMANCE_LBL("QuarterlyPerformance_Label")
	,ADMIN_RECENTRECORDS_LBL("Admin_RecentRecords_Lbl")
	,CONTACTSTAB__SENDLISTEMAIL_BTN("ContactsTab__SendListEmail_Btn")
	,CONTACTSTAB__SAVE_NEWCONTACT("ContactsTab__Save_NewContact")
	,CONTACTSTAB__CONTACTSTABLE_CONTACTOWNERALIAS_LBL("ContactsTab__ContactsTable_ContactOwnerAlias_Lbl")
	,CONTACTSTAB__CONTACTSTABLE_LASTNAME("ContactsTab__ContactsTable_LastName")
	,NEWCONTACT__CONTACT_LBL("NewContact__Contact_Lbl")
	,NEWCONTACT__CONTACT_NAME("NewContact__Contact_Name")
	,DUPLICATECONTACT__WINDOW("DuplicateContact__Window")
	,DUPLICATECONTACT__WINDOW_SAVE_BTN("DuplicateContact__Window_Save_Btn")
	,CALLPLANREPORTS_RECENTLYVIEWED_LBL("CallPlan_Reports__RecentlyViewed_Lbl")
	,NEW_CALLPLANREPORTS_WINDOW("New CallPlan_Reports - Dialogue Window")
	,NEWCALLPLANWINDOW_CALLPLAN_LBL("NewCallPlanWindow_CallPlan_Lbl")
    ,NEWCALLPLANWINDOW_CALLPLAN_NAME("NewCallPlanWindow_CallPlan_Name")
    ,SHOWMOREACTIONS_DROPDOWN("Show more actions_DropDown")
    ,VIEWACCOUNTHIERARCHY_BTN("ViewAccountHierarchy_Btn")
    ,NEWACCOUNT__ACCOUNT_LBL("NewAccount__Account_Lbl")
    ,NEWACCOUNT__ACCOUNT_NAME("NewAccount__Account_Name")

	
	
	;;


	private final String name;

	private WaitOppEleName(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
