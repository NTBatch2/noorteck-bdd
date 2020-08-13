package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.base.BaseClass;

public class SalaryComponentPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'Components')]")
	WebElement salaryCompMenu;

	@FindBy(xpath = "//i[contains(text(),'add')]")
	WebElement addIcon;

	@FindBy(id = "name")
	WebElement nameField;

	@FindBy(xpath = "//label[contains(text(),'Deduction')]")
	WebElement deductionRadio;

	@FindBy(xpath = "//label[contains(text(),'Total Payable')]")
	WebElement totalPayableRadio;

	@FindBy(xpath = "//label[contains(text(),'Company')]")
	WebElement costToCompanyCheckbox;

	@FindBy(xpath = "//label[contains(text(),'Amount')]")
	WebElement amountCheckbox;

	@FindBy(xpath = "//label[contains(text(),'Percentage')]")
	WebElement percentageCheckbox;

	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
	WebElement successMessage;

	public SalaryComponentPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickSalaryComponent() {
		click(salaryCompMenu);
	}

	public void clickAddIcon() {
		click(addIcon);
	}

	public void enterComponentName(String value) {
		enter(nameField, value);
	}

	public void clickDeductionRadio() {
		click(deductionRadio);
	}

	public void clickTotalPayRadio() {
		click(totalPayableRadio);
	}

	public void clickCostToCompCheckbox() {
		click(costToCompanyCheckbox);
	}

	public void clickAmountCheckbox() {
		click(amountCheckbox);
	}

	public void clickPercentageCheckbox() {
		click(percentageCheckbox);
	}

	public void clickSave() {
		click(saveButton);
	}

	public boolean isSuccessMessageDisp() {
		return isDisplayed(successMessage);
	}

}
