package org.shell.tcoe.test.enums;

public enum WaitEleName {

	PERMISSIONSETSFRAME("Permission Sets - Frame"), 
	BHARATAGARWALLOGIN("Bharath Agarwal - Login Link"),
	SETUP_LINK("Setup - Link"), SETUP_MENU("Setup - Menu"),
	QUICKFIND_TXTBOX("QuickFind_Txtbox"),
	PERMISSIONSSETS_BTN("PermissionsSets_Btn"),
	ACCREDITEDDEALMAKERCONTAINING_FRAME("AccreditedDealMakerContaining_Frame"),
	ACCREDITEDDEALMAKER_LINK("AccreditedDealMaker_Link"),
	MANAGEASSIGNMENTS_BTNCONTAINING_FRAME("ManageAssignments_BtnContaining_Frame"),
	MANAGEASSIGNMENTS_BTN("ManageAssignments_Btn"),
	OPPURTUNITY_LINK("Oppurtunity_Link");

	private final String name;

	private WaitEleName(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
