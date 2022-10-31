package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleHomePage {
    WebDriver driver;
    // 1. By Locators:
    @FindBy(name = "q")
    WebElement searchField;

    @FindBy(xpath = "//button[@id='L2AGLb']//div")
    WebElement cookies_accept;

    //@FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")
    @FindBy(linkText = "Google Search")
    WebElement searchButton;


    // 2. Constructor of the page class:
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public void acceptCookiesPolicy() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cookies_accept)).click();

    }

    public String getGooglePageTitle() {
        return driver.getTitle();
    }

    public void enterSearch(String searchString) {
        searchField.sendKeys(searchString);
    }

    public void clickOnSearchButton() {
        searchField.sendKeys(Keys.RETURN);
       // new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

}
