package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    WebDriver driver;

    // 1. By Locators
    @FindBy(xpath = "//div[@id='search']//div[@class='g']//div[@class='g']//a")
    WebElement firstResult;

    // 2. Constructor of the page class:
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getSearchResultsPageTitle() {
        return driver.getTitle();
    }

    public String resultText() {

        return firstResult.getText();
    }

    public void clickFirstResultLink(){

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(firstResult)).click();

    }

}
