package testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pagelayer.Homepage;

public class Testbase {
	
	
	public static WebDriver driver;
	public static Homepage homepageobj; 
	
	@Parameters("browser")
	@BeforeMethod
	public void teststart(String br) {
		
		if (br.equals("chrome")){
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			
			option.addArguments("desable-notification");
			 WebDriverManager.chromedriver().driverVersion("116").setup();
			driver = new ChromeDriver(option);
			
		}
		
		else if(br.equals("firefox")) {
			FirefoxOptions option = new FirefoxOptions ();
			driver = new FirefoxDriver(option);
			
			
			
		}
		
		else {
			
			System.out.println("enter correct details");
		
		
		}
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		homepageobj = new Homepage();

		
		
	}
	
	
	@AfterMethod
	public void stop() {
		driver.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
