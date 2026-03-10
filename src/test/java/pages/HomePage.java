package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    By botaoCursos = By.id("btn-ver-cursos");
    By campoEmail = By.id("email");
    By botaoEnviarCupom = By.id("button");
    By botaoCupom = By.cssSelector("#cupom button, form button[type='submit']");
    By textoCupom = By.cssSelector("#cupom, [id*='cupom']");

    public void acessarSite(){
        driver.get("https://qazando.com.br/curso.html");
    }

    public boolean validarSite(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(botaoCursos));

        return driver.findElement(botaoCursos).isDisplayed();
    }

    public void rolarTela(){

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail));
        scrollAte(email);
    }

    public void preencherEmail(String email){

        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail));

        WebElement inputEmail = driver.findElement(campoEmail);
        inputEmail.clear();
        inputEmail.sendKeys(email);
        inputEmail.sendKeys(Keys.TAB);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                inputEmail
        );

        wait.until(driver -> driver.findElement(botaoEnviarCupom).isEnabled());
    }

    public void clicarCupom(){

        WebElement botao = wait.until(ExpectedConditions.presenceOfElementLocated(botaoCupom));
        scrollAte(botao);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(botao)).click();
        } catch (TimeoutException | ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botao);
        }
    }

    public String pegarCupom(){

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String mensagem = alert.getText();
            alert.accept();
            return mensagem;
        } catch (TimeoutException ignored) {
            WebElement cupom = wait.until(driver -> {
                WebElement elemento = driver.findElement(textoCupom);
                String texto = elemento.getText().trim();
                return texto.isEmpty() ? null : elemento;
            });

            return cupom.getText().trim();
        }
    }

    private void scrollAte(WebElement elemento) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});",
                elemento
        );
    }
}
