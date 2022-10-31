package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class JPHomePage {
    WebDriver driver;
    // 1. By Locators:
    @FindBy(xpath = "//div[@class='logo-mobile-only']//img")
    WebElement logoImage;

    // 2. Constructor of the page class:
    public JPHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getJPPageTitle() {
        return driver.getTitle();
    }

    public boolean logoImagePresent() {

        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logoImage);
        if (!ImagePresent) {
            System.out.println("Logo not displayed.");
        } else {
            System.out.println("Logo displayed.");
        }
        return ImagePresent;
    }
}
