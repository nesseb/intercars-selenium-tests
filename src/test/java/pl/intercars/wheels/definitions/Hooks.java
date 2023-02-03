package pl.intercars.wheels.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import pl.intercars.WebDriverUtils;

import static pl.intercars.wheels.utils.WheelsUrl.TIRES_HOME_URL;

@CucumberOptions(glue = "pl.intercars", features = { "src/test/resources/features/ShoppingBasket.feature" })
public class Hooks extends AbstractTestNGCucumberTests {

    @Before(order = 1)
    public static void setUp() {
        WebDriverUtils.setUpDriver();
        WebDriverUtils.openPage(TIRES_HOME_URL);
    }

    @After
    public static void tearDown() {
        WebDriverUtils.tearDown();
    }
}
