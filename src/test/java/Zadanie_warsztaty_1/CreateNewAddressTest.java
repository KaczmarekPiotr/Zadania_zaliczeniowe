package Zadanie_warsztaty_1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/CreateNewAddress.feature", plugin = {"pretty","html:out"})

public class CreateNewAddressTest {
}
