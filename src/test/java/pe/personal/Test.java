package pe.personal;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriverService;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "pe.personal")
public class Test {

    /*@AfterClass
    public static void end() {
        Serenity.getWebdriverManager().getCurrentDriver().quit();
    }*/
}
