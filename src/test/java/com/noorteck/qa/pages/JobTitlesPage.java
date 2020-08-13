package com.noorteck.qa.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.base.BaseClass;

public class JobTitlesPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	WebElement adminMenu;

	@FindBy(xpath = "//span[contains(text(),'Job')]")
	WebElement jobMenu;

	@FindBy(xpath = "//span[contains(text(),'Job Titles')]")
	WebElement jobTitles;

	@FindBy(xpath = "//i[@class='large material-icons']")
	WebElement addIcon;

	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement saveButton;

	@FindBy(id = "jobTitleName")
	WebElement jobTitleNameField;

	@FindBy(id = "jobDescription")
	WebElement jobDescriptionField;

	@FindBy(id = "note")
	WebElement noteField;
//***************************************************************************
	@FindBy(xpath = "//*[contains(text(),'edit')]")   //add
	WebElement editIcon;

	@FindBy(xpath = "//*[contains(text(),'Successfully')]")  //updated
	WebElement successMessage;

	
	public void clickEditIcon() {  //add
		click(editIcon);
	}
	
	//***************************************************************************
	public JobTitlesPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickAdminMenu() {
		click(adminMenu);
	}

	public void clickJobMenu() {
		click(jobMenu);
	}

	public void clickJobTitlesMenu() {
		click(jobTitles);
	}

	public void clickAddIcon() {
		click(addIcon);
	}

	public void clickSaveButton() {
		click(saveButton);
	}

	public void enterJobTitleName(String jobTitle) {
		
	 
		
		enter(jobTitleNameField, jobTitle);
	}

	public void enterJobDescription(String jobDescription) {
		enter(jobDescriptionField, jobDescription);
	}

	public void enterNote(String note) {
		enter(noteField, note);
	}

	public String getSuccessMessage() {
		return getText(successMessage);
	}

 
}
