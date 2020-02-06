package Zadanie_warsztaty_1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CreateNewAddress {

    private WebDriver driver;

    @Given("^an open browser with https://prod-kurs\\.coderslab\\.pl$")
    public void anOpenBrowserWithHttpsProdKursCoderslabPl() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
    }

    @When("^select Sign in button$")
    public void selectSignInButton() {
        WebElement SignInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        SignInButton.click();
    }

    @And("^Email (.*) is entered in E-mail input field$")
    public void emailEmailIsEnteredInEMailInputField( String email ) {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
    }

    @And("^Password (.*) is entered in Password input field$")
    public void passwordPasswordIsEnteredInPasswordInputField( String password ) {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
    }

    @And("^sign in button is selected$")
    public void signInButtonIsSelected() {
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @And("^ADDRESSES button is selected$")
    public void addressesButtonIsSelected() {
        WebElement addressButton = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span/i"));
        addressButton.click();
    }

    @And("^\\+ Create new address option is chosen$")
    public void createNewAddressOptionIsChosen() {
        WebElement createNewAddressButton = driver.findElement(By.xpath("//*[@data-link-action='add-address']"));
        createNewAddressButton.click();
    }

    @And("^a (.*) is entered in Alias input field$")
    public void aKeywordAliasIsEnteredInAliasInputField( String alias ) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);
    }

    @And("^a (.*) is entered in address input field$")
    public void aKeywordAddressIsEnteredInAddressInputField( String address ) {
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);
    }

    @And("^a (.*) is entered in City input field$")
    public void aKeywordCityIsEnteredInCityInputField( String city ) {
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);
    }

    @And("^a (.*) is entered in Zip / Postal Code input field$")
    public void aKeywordZipCodeIsEnteredInZipPostalCodeInputField( String zipCode ) {
        WebElement zipCodeInput = driver.findElement(By.name("postcode"));
        zipCodeInput.sendKeys(zipCode);
    }

    @And("^a (.*) is entered in Phone input field$")
    public void aKeywordPhoneIsEnteredInPhoneInputField( String phone ) {
        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys(phone);
    }

    @And("^Save button is clicked$")
    public void saveButtonIsClicked() {
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click();
    }


    @Then("^New Address is added and equals (.*), (.*), (.*), (.*)$")
    public void newAddressIsAddedAndEqualsKeywordAddressKeywordCityKeywordZipCodeKeywordPhone( String address, String city, String zipCode, String phone ) {
        List<WebElement> addresses = driver.findElements(By.xpath("//address"));
        System.out.println(addresses.get(addresses.size()-1).getText());
        String newAdress = "Piotr Kaczmarek" + "\n" + address + "\n" + city + "\n" + zipCode + "\n" + "United Kingdom" + "\n" + phone;
        System.out.println(newAdress);
        Assert.assertEquals(addresses.get(addresses.size()-1).getText(), newAdress);
        // System.out.println(addresses.get(addresses.size()-1).findElement(By.xpath("./preceding-sibling::h4")).getText()); - taki moj tescik :)
    }
}
