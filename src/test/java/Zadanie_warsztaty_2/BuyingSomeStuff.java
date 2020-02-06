package Zadanie_warsztaty_2;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Hu;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;


public class BuyingSomeStuff {

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

    @And("^(.*) and (.*) is entered$")
    public void emailAndPasswordIsEntered( String email, String password ) {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @And("^CLOTHES button is selected$")
    public void clothesButtonIsSelected() {
        WebElement clothesButton = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        clothesButton.click();
    }

    @And("^Hummingbird Printed Sweater is chosen$")
    public void hummingbirdPrintedSweaterIsChosen() {
        WebElement HummingBirdItem = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/div[1]/h2/a"));
        HummingBirdItem.click();
    }

    @And("^Size (.*) is selected$")
    public void sizeIsSelected( String sizeDefined ) {
        Select sizeDropDown = new Select(driver.findElement(By.name("group[1]")));
        sizeDropDown.selectByVisibleText(sizeDefined);
    }

    @And("^Quantity (.*) is chosen$")
    public void quantityIsChosen( int quantity ) throws InterruptedException {
        WebElement QuantityButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i"));
        for ( int i = 0; i < quantity; i++ ) {
        QuantityButton.click();
        Thread.sleep(300);
        }
        //WebElement QuantityBox = driver.findElement(By.name("qty"));
        //QuantityBox.clear();
        //QuantityBox.sendKeys(quantity);
    }

    @And("^Add to cart is selected$")
    public void addToCartIsSelected() throws InterruptedException {
        Thread.sleep(1000);
        WebElement AddToCartButton = driver.findElement(By.xpath("//*[@class='btn btn-primary add-to-cart']"));
        AddToCartButton.click();
    }

    @And("^Proceed to checkout is selected$")
    public void proceedToCheckoutIsSelected() throws InterruptedException {
        Thread.sleep(1000);
        WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        Checkout.click();
        Thread.sleep(1000);
        WebElement ProceedCheckout = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        ProceedCheckout.click();
        Thread.sleep(1000);
    }

    @And("^Address is confirmed$")
    public void addressIsConfirmed() throws InterruptedException {
        WebElement confirmAddress = driver.findElement(By.xpath("//*[@name='confirm-addresses']"));
        confirmAddress.click();
        Thread.sleep(1000);
    }

    @And("^Shipping metode is chosen to PresaShop \"pick up in store\"$")
    public void shippingMetodeIsChosenToPresaShop() {
        WebElement PrestaShop = driver.findElement(By.id("delivery_option_1"));
        WebElement ContinueButton = driver.findElement(By.name("confirmDeliveryOption"));
        if ( PrestaShop.isSelected() ) {
            ContinueButton.click();
        } else {
            PrestaShop.click();
            ContinueButton.click();
        }
    }

    @And("^Pay by check is chosen and terms of service are checked$")
    public void payByCheckIsChosenAndTermsOfServiceAreChecked() {
        WebElement payByCheck = driver.findElement(By.id("payment-option-1"));
        payByCheck.click();

        WebElement termsOfService = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        termsOfService.click();
    }

    @And("^Order button is clicked$")
    public void orderButtonIsClicked() {
        WebElement orderButton = driver.findElement(By.xpath("//*[@class='btn btn-primary center-block']"));
        orderButton.click();
    }

    @Then("^Printscreen of order confirmation is done$")
    public void printscreenOfOrderConfirmationIsDone() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("/home/piotr/Pictures/screenshot-1.png"));
    }
}
