package pe.personal;

import io.cucumber.junit.CucumberOptions;
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

    public static String ANSI_GREEN = "\u001B[32m";

    @BeforeClass
    public static void init() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    }

    @AfterClass
    public static void end() {
        System.out.println(ANSI_GREEN + ANSI_GREEN);
    }
}
