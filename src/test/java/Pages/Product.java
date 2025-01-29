package Pages;

import Steps.Hooks;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Product {
    public WebDriver driver= Hooks.driver;

    public WebElement labtops()throws InterruptedException{
        return driver.findElement(By.xpath("//*[contains(text(), 'Laptops')]"));
    }
    public WebElement selectLaptopByIndex(int index) {
        return driver.findElement(By.xpath("(//a[@class='hrefch'])[" + index + "]"));
    }



    public WebElement Product_Store() throws InterruptedException {
        return driver.findElement(By.xpath("//a[@id='nava']"));
    }


    public WebElement addToCartButton()throws InterruptedException {
        return driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
    }

    public WebElement CartButtonHomepage()throws InterruptedException {
        return driver.findElement(By.xpath("//a[@id='cartur']"));
    }

    public WebElement Total()throws InterruptedException {
        return driver.findElement(By.xpath("//h3[@id='totalp']"));
    }

    public WebElement Place_holder_button()throws InterruptedException {
        return driver.findElement(By.cssSelector(".btn.btn-success"));
    }

    public WebElement total_amount_place_holder_page()throws InterruptedException {
        return driver.findElement(By.xpath("//label[@id='totalm']"));
    }

    public WebElement Name()throws InterruptedException {
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement Country()throws InterruptedException {
        return driver.findElement(By.xpath("//input[@id='country']"));
    }
    public WebElement City()throws InterruptedException {
        return driver.findElement(By.xpath("//input[@id='city']"));
    }
    public WebElement CreditCard()throws InterruptedException {
        return driver.findElement(By.xpath("//input[@id='card']"));
    }
    public WebElement Month()throws InterruptedException {
        return driver.findElement(By.xpath("//input[@id='month']"));
    }
    public WebElement Year()throws InterruptedException {
        return driver.findElement(By.xpath("//input[@id='year']"));
    }
    public WebElement PurchaseButton()throws InterruptedException {
        return driver.findElement(By.xpath("//button[normalize-space()='Purchase']"));
    }
    public WebElement SuccessMessage()throws InterruptedException {
        return driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your purchase!']"));
    }



}
