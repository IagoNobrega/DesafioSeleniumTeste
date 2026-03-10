package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void start(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @After
    public void stop(Scenario scenario){

        if(driver != null && scenario.isFailed()){
            salvarDiagnostico();
        }

        if(driver != null){
            driver.quit();
        }

        System.out.println("Finalizou!");
    }

    private void salvarDiagnostico() {
        try {
            Path diagnosticoDir = Path.of("target", "diagnostico");
            Files.createDirectories(diagnosticoDir);

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(diagnosticoDir.resolve("falha.png"), screenshot);

            Files.writeString(diagnosticoDir.resolve("falha.html"), driver.getPageSource());
        } catch (IOException e) {
            System.out.println("Nao foi possivel salvar o diagnostico: " + e.getMessage());
        }
    }
}
