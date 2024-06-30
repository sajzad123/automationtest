package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicTableSteps {
    WebDriver driver;
    WebDriverWait wait;
    String cpuLoad="";

    @Given("I am on the dynamic table page")
    public void i_am_on_the_dynamic_table_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        driver.navigate().to("https://practice.expandtesting.com/dynamic-table");
        System.out.println("Navigating to the dynamic table page");
    }

    @When("I get the value of CPU load for Chrome")
    public void i_get_the_value_of_CPU_load_for_Chrome() {
        // Find the row for Chrome
        WebElement chromeRow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'Chrome')]/parent::tr")));

        // Get the CPU load value from the row
        WebElement cpuCell = chromeRow.findElement(By.xpath("./td[contains(text(),'%')]"));
        cpuLoad = cpuCell.getText();
        System.out.println("CPU Load for Chrome: " + cpuLoad);
        
        // Store the CPU load value in the context (for comparison later)
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("I compare it with the value in the yellow label")
    public void i_compare_it_with_the_value_in_the_yellow_label() {
        // Get the value from the yellow label
        WebElement yellowLabel = driver.findElement(By.id("yellowLabelId")); // Replace with the actual ID of the yellow label
        String yellowLabelValue = yellowLabel.getText();
        System.out.println("Value in the yellow label: " + yellowLabelValue);

        // Assert that the values are equal
        Assert.assertEquals(cpuLoad, yellowLabelValue, "The CPU load values do not match!");
    }
}
