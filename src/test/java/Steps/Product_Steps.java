package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import Pages.Product;

import java.time.Duration;

import static Steps.Hooks.driver;

public class Product_Steps {

    Product product = new Product();
    public int p;
    public double x=0 ;

    @Given("Click on Laptops in categories in home page")
    public void pressOnLabtopButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for page to fully load
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));

        // Wait for the "Laptops" button to be visible & clickable
        WebElement laptopsButton = wait.until(ExpectedConditions.elementToBeClickable(product.labtops()));
        laptopsButton.click();
        System.out.println("✅ Clicked on 'Laptops' category.");

        Thread.sleep(2000); // Sleep for 2 seconds to observe the step
    }
    @When("user clicks on {int} laptop")
    public void userClicksOnLaptop(int laptopIndex) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the laptop to appear & be clickable
        WebElement laptop = wait.until(ExpectedConditions.elementToBeClickable(product.selectLaptopByIndex(laptopIndex)));
        laptop.click();

        System.out.println("✅ Clicked on laptop #" + laptopIndex);
        Thread.sleep(2000); // Sleep for 2 seconds to observe the step
    }

    @And("Click on Add to cart button")
    public void pressOnProductButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the price element before clicking "Add to Cart"
        WebElement priceElement = driver.findElement(By.xpath("//h3[@class='price-container']")); // Adjust XPath if needed
        String priceText = priceElement.getText().replaceAll("[^\\d.]", "");
        double productPrice = Double.parseDouble(priceText);

        // Add the extracted price to the total
        x += productPrice;
        System.out.println("✅ Added Laptop Price: " + productPrice + " | Running Total: " + x);

        // Wait for the "Add to Cart" button to be clickable
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(product.addToCartButton()));
        addToCartButton.click();

        System.out.println("✅ Clicked on 'Add to Cart' button.");

        Thread.sleep(2000); // Sleep for 2 seconds to observe the step
    }
    @Then("Validate that product is successfully added")
    public void Validate_that_product_is_successfully_added() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(product.driver, Duration.ofSeconds(15));

        try {
            // Wait for alert to be present
            wait.until(ExpectedConditions.alertIsPresent());
            String ActualResult = product.driver.switchTo().alert().getText();

            // Debugging: Print the alert text
            System.out.println("🔍 Debug: Alert message is -> " + ActualResult);

            String ExpectedResult = "Product added.";
            softAssert.assertEquals(ActualResult, ExpectedResult, "❌ Alert text does not match expected message!");

            // Accept the alert
            product.driver.switchTo().alert().accept();
            System.out.println("✅ Alert accepted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error: Alert did not appear or was not handled correctly: " + e.getMessage());
        }

        softAssert.assertAll();

        // Wait before clicking on the cart
        Thread.sleep(2000);

        // Click on the Cart button
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(product.CartButtonHomepage()));
        cartButton.click();
        System.out.println("✅ Clicked on 'Cart' button.");

        Thread.sleep(3000); // Sleep for 3 seconds to observe the cart page
    }
    @Given("Click on Product Store button in the Header")
    public void user_click_on_Product_Store_button() throws InterruptedException {
        product.Product_Store().click();
    }
    @And("user clicks on {string} laptop")
    public void userClicksOnLaptop2(int laptopIndex) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the laptop to appear & be clickable
        WebElement laptop = wait.until(ExpectedConditions.elementToBeClickable(product.selectLaptopByIndex(laptopIndex)));
        laptop.click();

        System.out.println("✅ Clicked on laptop #" + laptopIndex);
        Thread.sleep(2000); // Sleep for 2 seconds to observe the step
    }

    @Given("Validate that total amount is calculated correctly")
    public void Validate_that_total_amount_is_calculated_correctly() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait until the total price is displayed
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOf(product.Total()));

        // Get the total amount from the UI and remove non-numeric characters
        String totalText = totalElement.getText().replaceAll("[^\\d.]", "");
        double actualTotal = Double.parseDouble(totalText);

        // Debugging output
        System.out.println("🔍 Expected Total: " + x);
        System.out.println("✅ Actual Total from UI: " + actualTotal);

        // Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTotal, x, "❌ Total amount calculation is incorrect!");
        softAssert.assertAll();
    }
    @When("Click on Place holder button")
    public void Click_on_Place_holder_button() throws InterruptedException {

        product.Place_holder_button().click();
        Thread.sleep(5000);
    }
    @And("Validate that total amount is calculated correctly in place holder page")
    public void Validate_that_total_amount_is_calculated_correctly_in_place_holder_page() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait until the total price in the place order page is displayed
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOf(product.total_amount_place_holder_page()));

        // Get the total amount from the UI and remove non-numeric characters
        String totalText = totalElement.getText().replaceAll("[^\\d.]", "");
        double actualTotal = Double.parseDouble(totalText);

        // Debugging output
        System.out.println("🔍 Expected Total: " + x);
        System.out.println("✅ Actual Total from UI in Place Order Page: " + actualTotal);

        // Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTotal, x, "❌ Total amount calculation is incorrect in place order page!");
        softAssert.assertAll();
        Thread.sleep(1000);
    }
    @And("Filling Name {string}, Country {string}, City {string}, Credit Card {string}, Month {string} and Year {string}")
    public void FillingPlaceHolderForm(String name,String country,String city,String creditCart,String month,String year) throws InterruptedException {
        product.Name().sendKeys(name);
        Thread.sleep(1000);
        product.Country().sendKeys(country);
        Thread.sleep(1000);
        product.City().sendKeys(city);
        Thread.sleep(1000);
        product.CreditCard().sendKeys(creditCart);
        Thread.sleep(1000);
        product.Month().sendKeys(month);
        Thread.sleep(1000);
        product.Year().sendKeys(year);
        Thread.sleep(1000);
    }
    @And("Click on Purchase button in place holder Form")
    public void Click_on_Purchase_button_in_place_holder_Form() throws InterruptedException {

        product.PurchaseButton().click();
        Thread.sleep(3000);
    }
    @Then("Validate that {string} should be displayed")
    public void Validate_that_message_should_be_displayed(String expectedMessage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait until the success message is visible
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(product.SuccessMessage()));

        // Get the actual message from the UI
        String actualMessage = successMessageElement.getText().trim(); // Trim to remove extra spaces

        // Debugging output
        System.out.println("🔍 Expected Message: " + expectedMessage);
        System.out.println("✅ Actual Message from UI: " + actualMessage);

        // Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, expectedMessage, "❌ The displayed message is incorrect!");
        softAssert.assertAll();
        Thread.sleep(3000);
    }



}
