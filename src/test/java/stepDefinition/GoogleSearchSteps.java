package stepDefinition;

import com.pages.GoogleHomePage;

import com.pages.JPHomePage;
import com.pages.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {
    WebDriver driver;
    GoogleHomePage homePage;
    SearchResultsPage googleResultPage;
    JPHomePage jphomePage;


    @Before
    public void setUp() {
        // To make it generic use driver factory utility to use browser of choice & run it on parallel on different browsers
        // Use configReader to get browser dynamically
        // This test will run on chrome browser

        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver", "path to driver file";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("user navigates to google website")
    public void user_navigates_to_google_website() {
        driver.get("https://www.google.com");

        homePage = new GoogleHomePage(driver);
        homePage.acceptCookiesPolicy();
    }

    @When("the search phrase {string} is entered")
    public void the_search_phrase_is_entered(String companyName) {
        homePage.enterSearch(companyName);
        String title = homePage.getGooglePageTitle();
        Assert.assertTrue(title.contains("Google"));
    }

    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
        homePage.clickOnSearchButton();
    }

    @Then("results for {string} are shown")
    public void results_for_are_shown(String res) {
        googleResultPage = new SearchResultsPage(driver);
        String resultText = googleResultPage.resultText();
        Assert.assertTrue(resultText.contains(res));
    }


    @Given("user search for {string} on google")
    public void user_search_for_on_google(String company) {
        driver.get("https://www.google.com");

        homePage = new GoogleHomePage(driver);
        homePage.acceptCookiesPolicy();
        homePage.enterSearch(company);
        homePage.clickOnSearchButton();
        String title = homePage.getGooglePageTitle();
        //Assert if search is suffessful
        Assert.assertTrue(title.contains("Google"));
    }

    @When("user click on first link of results page")
    public void user_click_on_first_link_of_results_page() {
        googleResultPage = new SearchResultsPage(driver);
        //Click on first link of search
        googleResultPage.clickFirstResultLink();

    }

    @Then("logo image of J. P. Morgan is shown")
    public void logo_image_of_j_p_morgan_is_shown() {
        jphomePage = new JPHomePage(driver);
        String title = jphomePage.getJPPageTitle();
        Assert.assertTrue(title.contains("Morgan"));
     // Verify JP logo exists
        Assert.assertTrue(jphomePage.logoImagePresent());

    }


}
