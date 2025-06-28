import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class TestAquariumBookingDetails 
{
   	//use the respective variable 
	//do not change the method and variable declaration
	private static WebDriver driver;
	private static String successMsg;
	
	private String baseUrl="https://webapps.tekstac.com/StarfishJS/StarFishJS.html#booking";
	
	AquariumBookingDetails obj;

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	//Apply the required annotation	
	@BeforeClass
	public WebDriver setUp() {
		//create the driver using method 'getDriver' in class DriverSetup.
		//Assign it to the variable 'driver'
		//Navigate to the baseUrl
		driver = DriverSetup.getDriver();
  		driver.get(baseUrl);
  		
  		//do not change it
  		obj=new AquariumBookingDetails(driver);
  		return driver;
	}	 	  	      		      	   	     	     	 	
	
	//Apply the required annotation
	@DataProvider(name="getValidData")
	public static String[][] getExcelData() throws Exception {

		//Call the method 'readExcelData' in class 'ExcelUtils' using file name 'AquariumBookingDetails.xlsx ' and sheet name 'booking_details'
		//Return the value
		String[][] exceldata=ExcelUtils.readExcelData("AquariumBookingDetails.xlsx","booking_details");
		return exceldata;
	}

	//Apply the required annotation
	@Test(dataProvider="getValidData")
	public void testValidAquariumBookingDetails(String name, String email, String phoneNumber, String packageType, String bookingDate, String count, String otherInfo) throws Exception{	
			
		//Using 'obj' object, set the form values passed as the parameter using DataProvider method 'getValidData'
		
		//Use 'obj' object and call the method setName() and pass the 'name' as parameter. 
		//Use 'obj' object and call the method setEmail() and pass the 'email' as parameter. 
		//Use 'obj' object and call the method setPhoneNumber() and pass the'phoneNumber' as parameter. 
		//Use 'obj' object and call the method setPackageType() and pass the 'packageType' as parameter.
		//Use 'obj' object and call the method setBookingDate() and pass the 'bookingDate' as parameter.
		//Use 'obj' object and call the method setPeopleCount() and pass the 'count' as parameter.
		//Use 'obj' object and call the method setOtherInformation() and pass the 'otherInfo' as parameter.
		
		//Use 'obj' object and call the method submitForm() to click the 'Click Here' button. 
			
		//Use 'obj' object and call the method getResult().
				
		//Retrieve the message returned by getResult() and store it in the variable 'successMsg'
			
		//Finally display the 'successMsg'
		
		    obj.setName(name);
			obj.setEmail(email);
			obj.setPhoneNumber(phoneNumber);
			obj.setPackageType(packageType);
			obj.setBookingDate(bookingDate);
			obj.setPeopleCount(count);
			obj.setOtherInformation(otherInfo);
			obj.submitForm();
			
			successMsg=obj.getResult();
			setSuccessMsg(successMsg);
	 		System.out.println("Success msg is ------------" +successMsg );
    }	 	  	      		      	   	     	     	 	
}
