package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
    WebDriver driver;

    @Given("I want to login")
    public void i_want_to_login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://practice.expandtesting.com/login");
        driver.manage().window().maximize();
        System.out.println("Navigating to the login page");
    }

    @And("enters {string} and {string}")
    public void enters_username_and_password(String username, String password) {
        System.out.println("Entering username: " + username);
        System.out.println("Entering password: " + password);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I complete action clicking on login")
    public void i_complete_action_clicking_on_login() {
        System.out.println("Clicking on the login button");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).sendKeys(Keys.ENTER);
    }

    @Then("I am taken to the next page")
    public void i_am_taken_to_the_next_page() {
        System.out.println("Verifying navigation to the next page");
        try {
        	Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
        	e.printStackTrace();
        }
       
        
         String currentUrl=driver.getCurrentUrl();
         System.out.println("url is" +currentUrl);
         if(currentUrl.equals("https://practice.expandtesting.com/secure"))
         { 
        	 System.out.println("Succesful");
         }
         else {
         driver.close();
         }
         driver.close();
    }
}
