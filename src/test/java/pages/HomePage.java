package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By botaoCursos = By.id("btn-ver-cursos");
    By campoEmail = By.id("email");
    By botaoCupom = By.id("button");
    By textoCupom = By.cssSelector("#cupom > h2 > span");

    public void acessarSite(){
        driver.get("https://qazando.com.br/curso.html");
    }

    public boolean validarSite(){
        return driver.findElement(botaoCursos).isDisplayed();
    }

    public void rolarTela(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,10000)");
    }

    public void preencherEmail(String email){
        driver.findElement(campoEmail).sendKeys(email);
    }

    public void clicarCupom(){
        driver.findElement(botaoCupom).click();
    }

    public String pegarCupom(){
        return driver.findElement(textoCupom).getText();
    }
}