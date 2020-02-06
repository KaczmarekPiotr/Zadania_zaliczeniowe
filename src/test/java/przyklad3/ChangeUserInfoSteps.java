package przyklad3;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import przyklad2.LoginPage;
import przyklad3.UserInfoPage;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {

    UserInfoPage userInfoPage;
    WebDriver driver;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLoggedInToCodersLabShop() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
            userInfoPage = new UserInfoPage(driver);
    }

    @When("^User goes to UserInformationPage$")
    public void userGoesToUserInformationPage() {
            userInfoPage.goToAccountDetail();
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
            userInfoPage.signInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
            userInfoPage.submitUserInfo();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
        driver.quit();

        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}
