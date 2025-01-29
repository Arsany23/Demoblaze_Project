package Pages;

import Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login {
    public WebDriver driver;

    // Constructor to initialize WebDriver
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement LoginButton_Homepage() {
        return driver.findElement(By.xpath("//a[@id='login2']"));
    }

    public WebElement userName() {
        return driver.findElement(By.xpath("//input[@id='loginusername']"));
    }

    public WebElement Password() {
        return driver.findElement(By.xpath("//input[@id='loginpassword']"));
    }

    public WebElement LoginButton_SignInPage() {
        return driver.findElement(By.xpath("//button[normalize-space()='Log in']"));

    }
    public WebElement LogoutButton_Homepage() {
        By.xpath("//a[@id='logout2']");
        driver.findElement(By.xpath("//a[@id='logout2']"));
        return driver.findElement(By.xpath("//a[@id='logout2']"));
    }

    public By LogoutButton_HomepageBY() {
        By logout=By.xpath("//a[@id='logout2']");
        return logout;
    }


}
