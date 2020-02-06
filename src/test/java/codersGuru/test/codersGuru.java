package codersGuru.test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class codersGuru {

    private WebDriver driver;
    private String keyword;

    @Given("^an open browser with https://tester\\.codersguru\\.pl/$")
    public void anOpenBrowserWithHttpsTesterCodersguruPl() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://tester.codersguru.pl");
    }

    @When("zaloz konto button is selected")
    public void zalozKontoButtonIsSelected() {
        WebElement zalozKonto = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        zalozKonto.click();
    }

    @And("a keyword (.*) is entered in E-mail input field")
    public void aKeywordPyaEveavComIsEnteredInEMailInputField(String email) {
        WebElement emailInput = driver.findElement(By.id("fos_user_registration_form_email"));
        emailInput.sendKeys(email);
    }

    @And("a keyword (.*) is entered in Imie input field")
    public void aKeywordZenekIsEnteredInImieInputField(String imie) {
        WebElement imieInput = driver.findElement(By.id("fos_user_registration_form_name"));
        imieInput.sendKeys(imie);
    }

    @And("a keyword (.*) is entered in Nazwisko input field")
    public void aKeywordZenkowskiIsEnteredInNazwiskoInputField(String nazwisko) {
        WebElement nazwiskoInput = driver.findElement(By.id("fos_user_registration_form_lastname"));
        nazwiskoInput.sendKeys(nazwisko);
    }

    @And("a keyword (.*) is entered in Haslo input field")
    public void aKeywordIsEnteredInHasloInputField(String haslo) {
        WebElement hasloInput = driver.findElement(By.id("fos_user_registration_form_plainPassword_first"));
        hasloInput.sendKeys(haslo);
    }

    @And("a keyword (.*) is entered in Powtorz haslo input field")
    public void aKeywordIsEnteredInPowtorzHasloInputField(String haslo2) {
        WebElement haslo2Input = driver.findElement(By.id("fos_user_registration_form_plainPassword_second"));
        haslo2Input.sendKeys(haslo2);
    }

    @And("a keyword (.*) is entered in Miasto input field")
    public void aKeywordKatowiceIsEnteredInMiastoInputField(String miasto) {
        WebElement miastoInput = driver.findElement(By.id("form_city"));
        miastoInput.sendKeys(miasto);
    }

    @And("a keyword (.*) is entered in Kod pocztowy input field")
    public void aKeywordIsEnteredInKodPocztowyInputField(String kod) {
        WebElement kodInput = driver.findElement(By.id("form_postal_code"));
        kodInput.sendKeys(kod);
    }

    @And("a keyword (.*) is entered in Ulica input field")
    public void aKeywordPolnaIsEnteredInUlicaInputField(String ulica) {
        WebElement ulicaInput = driver.findElement(By.id("form_street"));
        ulicaInput.sendKeys(ulica);
    }

    @And("a keyword (.*) is entered in Numer domu input field")
    public void aKeywordIsEnteredInNumerDomuInputField(String nrDomu) {
        WebElement nrDomuInput = driver.findElement(By.id("form_number"));
        nrDomuInput.sendKeys(nrDomu);
    }

    @And("Regulamin is checked and Zarejestruj button is clicked")
    public void regulaminIsCheckedAndZarejestrujButtonIsClicked() {
        WebElement regButton = driver.findElement(By.xpath("//*[@id=\"registration-main-form\"]/div[12]/input"));
        regButton.click();
        WebElement submitButton = driver.findElement(By.id("register-submit-btn"));
        submitButton.submit();
    }

    @Then("the logged in user is (.*)")
     public void theLoggedInUserIsZenek( String imie) {
        WebElement user = driver.findElement(By.id("user-name"));
        Assert.assertEquals(user.getText(), imie);
    }
    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }

}
