package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void start(){
        driver = new ChromeDriver();
    }

    @After
    public void stop(){
        driver.quit();
        System.out.println("Finalizou!");
    }
}