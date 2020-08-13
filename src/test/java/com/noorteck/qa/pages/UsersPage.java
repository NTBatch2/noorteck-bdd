package com.noorteck.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.base.BaseClass;

public class UsersPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'User Management')]")
	WebElement userManagementMenu;

	@FindBy(xpath = "//span[contains(text(),'Users')]")
	WebElement usersMenu;

	@FindBy(xpath = "//table//tr//td[2]//span")
	List<WebElement> usernameColumn;

	@FindBy(xpath = "//table//tr//td[4]//span")
	List<WebElement> employeeNameColumn;

	public UsersPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickUsersMenu() {
		jobTitlesObj.clickAdminMenu();
		click(userManagementMenu);
		click(usersMenu);
 		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isUsernameAndEmpNameMatch(String expEmpName, String expUsername) {
		boolean isMatched = false;
		for (int i = 0; i < usernameColumn.size(); i++) {

			String actUsername = getText(usernameColumn.get(i));
			String actEmpName = getText(employeeNameColumn.get(i));

			if (actUsername.equalsIgnoreCase(expUsername) && actEmpName.equalsIgnoreCase(expEmpName)) {
				isMatched = true;
				break;
			}
		}
		return isMatched;
	}
	
	
	
}
