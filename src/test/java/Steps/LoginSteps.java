package Steps;

import Pages.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver = Hooks.driver;
    private Login login;

    // Constructor to initialize Login class with WebDriver
    public LoginSteps() {
        login = new Login(driver);
    }
    @When("user clicks on the login button in the header")
    public void ClickOnLoginButton(){
        login.LoginButton_Homepage().click();
    }

    @And ("user fills in the login form with username {string} and password {string}")
    public void enterValidLogin(String username,String password)  {
        login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        login.userName().sendKeys(username);
        login.Password().sendKeys(password);
        login.LoginButton_SignInPage().click();
    }

    @Then("make sure that user logged in")
    public void myAccountIsOpenedSuccessfully(){

        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait = new WebDriverWait(login.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(login.LogoutButton_HomepageBY()));
        softAssert.assertTrue(login.LogoutButton_Homepage().isDisplayed(), "- Login was not successful.\n - Log out button is not visible.");
        softAssert.assertAll();
    }
}
