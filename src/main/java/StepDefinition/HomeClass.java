package StepDefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeClass {
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="dropdown")
	WebElement dropdown;
	
	@FindBy(id="elementsPerPageSelect")
	WebElement ElementPerPage;

}
