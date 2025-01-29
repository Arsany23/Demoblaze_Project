package Pages;

import Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUp {
    public WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds

    public WebElement SignUp_Button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='signin2']")));
    }

    public WebElement UserName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sign-username']")));
    }

    public WebElement Password() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sign-password']")));
    }

    public WebElement SignUpButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign up']")));
    }
}
