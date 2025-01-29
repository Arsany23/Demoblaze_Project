package Steps;

import Pages.SignUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SignUp_Steps {
   public WebDriver driver=Hooks.driver;
    SignUp signup =new SignUp();

    @Given("user navigate into web")
    public void user_navigate_into_web(){
        driver.get("https://demoblaze.com/");
    }
    @When("user click on Sign up button in the Header")
    public void user_click_on_SignUp_Button() throws InterruptedException {
        signup.SignUp_Button().click();

    }
    @And("user enter Username {string}")
    public void name(String name) throws InterruptedException {
        signup.UserName().sendKeys(name);
    }

    @And("user enter Password {string}")
    public void user_enter_password(String password) throws InterruptedException {
        signup.Password().sendKeys(password);
    }
    @And("user click on SignUp button")
    public void user_click_on_SIGNUP_button() throws InterruptedException {
        signup.SignUpButton().click();
    }
    @Then("A success {string} should be displayed")
    public void successfully_message(String expectedMessage) {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert

        String actualResult = driver.switchTo().alert().getText(); // Get alert text
        softAssert.assertEquals(actualResult, expectedMessage, "Alert message does not match!");

        softAssert.assertAll();

        try {
            Thread.sleep(2000); // Pause for 2 seconds before closing the alert
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().accept(); // Accept alert
    }

    @And("The user fills in their Invalid username {string} and password {string} in the form fields and The user submits the form.")
    public void User_Enter_InValid_data(String username,String password) throws InterruptedException {
        signup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signup.UserName().sendKeys(username);
        signup.Password().sendKeys(password);
        signup.SignUpButton().click();
    }
    @Then("Validate that Wrong message is {string}")
    public void Wrong_message(String message) {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(signup.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert

        String ActualResult = signup.driver.switchTo().alert().getText();
        softAssert.assertEquals(message, ActualResult);

        softAssert.assertAll();

        try {
            Thread.sleep(2000); // Wait for 2 seconds before accepting the alert
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        signup.driver.switchTo().alert().accept(); // Accept the alert after delay
    }


}
