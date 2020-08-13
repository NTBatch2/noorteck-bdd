package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.base.BaseClass;

public class DashboardPage  extends BaseClass {
	
	@FindBy(xpath = "//li[@class='page-title']")
	WebElement dashboardTitle;
	
	@FindBy(id = "account-name")
	WebElement accountName;
	
	@FindBy(xpath = "//span[contains(text(),'schedule')]")
	WebElement pendTimeSheetIcon;
	
	@FindBy(xpath = "//span[contains(text(),'insert_invitation')]")
	WebElement pendLeaveReqIcon;
	
	@FindBy(xpath= "//span[contains(text(),'contact_phone')]")
	WebElement scheduleRecEventIcon;
	
	@FindBy(xpath = "//i[@class='material-icons']")
	WebElement userMenuDropdown;
	
	@FindBy(id = "logoutLink")
	WebElement logoutOption;
		
	public DashboardPage() {		
		PageFactory.initElements(driver, this);
	}
		
	public String getDashboardTitle() {			
		return getText(dashboardTitle);
	}
		
	public String getAccountName() {		
		return getText(accountName);
	}	
	
	public boolean isPendTimeSheetIconVisible() {
		return isDisplayed(pendTimeSheetIcon);
	}
	
	public boolean isPendLeaveRequIconVisible() {
		return isDisplayed(pendLeaveReqIcon);
	}
	
	public boolean isScheduleRecIconVisible() {
		return isDisplayed(scheduleRecEventIcon);
	}
	
	
	public void clickUserMenuDropdown() {
		click(userMenuDropdown);
	}
	
	public void clickLogOutOption() {
		click(logoutOption);
	}
}
