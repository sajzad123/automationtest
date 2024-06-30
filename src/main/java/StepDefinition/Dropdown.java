package StepDefinition;

import java.time.Duration;
import io.cucumber.core.cli.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class Dropdown {
	
	WebDriver driver;
	
	@Given("when i navigate to page")
	public void when_i_navigate_to_page() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://practice.expandtesting.com/dropdown");
        driver.manage().window().maximize();
        System.out.println("Navigating to the login page");
	}
	 


	@And("click on drop down")
	public void click_on_drop_down() {
		HomeClass home=PageFactory.initElements(driver, HomeClass.class);
		Select dropdown= new Select(home.dropdown);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dropdown.selectByVisibleText("Option 1");
		Select elementPerPage= new Select(home.ElementPerPage);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		elementPerPage.selectByIndex(2);
		Select countryselect=new Select(home.country);
		countryselect.selectByVisibleText("India");
		driver.close();
		driver.quit();
	
	    		
	}
}



