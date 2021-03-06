package myFunctions;

import java.util.Scanner;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//Functions that work with the browser
public class Browser {
	

	// A function that allows the user to select and to open the browser on which the tests will run.
	public static WebDriver Choosing() throws Exception{
		
		int browser;
		
		System.out.println("Please choose your browser:\nfor Chrome - press 1 and then Enter \nfor FireFox - press 2 and then Enter");
		Scanner input= new Scanner(System.in);
		browser=input.nextInt();
				
			switch(browser) {
			case 1: 
				return new ChromeDriver();				
			case 2:
				return new FirefoxDriver();				
			default: 
				throw new Exception ("Invalid choice, please try again");
			}		
			
	}

	
	// A function that receives the current browser name, and opens this browser again.
	public static WebDriver OpenAgain (String browser) throws Exception{
		
			if (browser.equals("chrome")){
				return new ChromeDriver();
			} else if (browser.equals("firefox")) {
				return new FirefoxDriver();
			} else {
				throw new Exception ("Browser error. Can't detect the curent browser");
			}	
			
	}

	
	// A function that receives the webdiver, and verifying it stays focus on the test-window.
	public static void Focus (WebDriver driver) throws Exception{
		
		String testWindowHandle = driver.getWindowHandle();	// Saving the current test-window handle
		((JavascriptExecutor)driver).executeScript("alert('Test')"); 	// Running  javascript and alert code:
		driver.switchTo().alert().accept();	// Every time the driver is focusing on other window,
		driver.switchTo().window(testWindowHandle);	//	It focusing back to to the test-window 

			
	}
	
	
}
