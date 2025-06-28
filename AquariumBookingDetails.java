import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

public class AquariumBookingDetails 
{
    /* Use the below declared variable */
    private WebDriver driver;
	
	//DO NOT change
	public AquariumBookingDetails(){}
	
	//DO NOT change the constructor
	public AquariumBookingDetails(WebDriver driver) {
		this.driver= driver;
	}
    
    public void setName(String name) {
		// Locate the input box of 'Name' using specific locators.                                                    
		// Using sendKeys() method, fill 'Name' with the value being passed to this method.
		driver.findElement(By.id("cname")).sendKeys(name);
	}

    public void setEmail(String email) {
    	// Locate the input box of 'Email' sing specific locators.                                                    
    	// Using sendKeys() method, fill 'Email' with the value being passed to this method.
		driver.findElement(By.id("email")).sendKeys(email);
	}

    public void setPhoneNumber(String phoneno) {
    	// Locate the input box of 'Phone number' using specific locators.                                                    
    	// Using sendKeys() method, fill 'Phone number' with the value being passed to this method.
		driver.findElement(By.id("phoneno")).sendKeys(phoneno);
	}
    
    public void setPackageType(String packageType) {	 	  	      		      	   	     	     	 	
    	// Locate the input box of 'Package Type' using specific locators.                                                    
    	// Using sendKeys() method, fill 'Package Type' with the value being passed to this method.
		driver.findElement(By.id("pack")).sendKeys(packageType);
	}
    
    public void setBookingDate(String bookingDate) {
    	// Using JavascriptExecutor and executeScript, fill 'Boooking Date' with the value passed to this method                                                    
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].value = arguments[1]", driver.findElement(By.id("bdate")), bookingDate);
	}
    
    public void setPeopleCount(String count) {
    	// Locate the input box of 'People Count' using specific locators.                                                    
    	// Using sendKeys() method, fill 'People Count' with the value being passed to this method.
		driver.findElement(By.id("count")).sendKeys(count);
	}
    
    public void setOtherInformation(String otherInfo) {
    	// Locate the input box of 'Other Information' using specific locators.                                                    
    	// Using sendKeys() method, fill 'Other Information' with the value being passed to this method.
		driver.findElement(By.id("msg")).sendKeys(otherInfo);
	}
	
	public void submitForm() {
		// Locate the 'Click Here' button using specific locators.
		// Click the 'Click Here' button and submit the form.
		driver.findElement(By.id("click")).click();
	}
    
    public String getResult() {
		// Locate the confirmation message using specific locators and return it
		return driver.findElement(By.id("result")).getText();
	}
}
	 	  	      		      	   	     	     	 	
