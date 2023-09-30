package pagelayer;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.collections.Lists;

import testbase.Testbase;

public class Homepage extends Testbase {

	@FindBy(xpath="//a[@id=\"nav-logo-sprites\"]")
	private WebElement logo;
	
	@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
	private WebElement searchbar;
	
	@FindBy(xpath="//select[@id=\"searchDropdownBox\"]")
	private WebElement dropdown;
	
	@FindBy(xpath="//input[@id=\"nav-search-submit-button\"]")
	private WebElement searchbutton;
	
	@FindBy(xpath="//img[@src=\"https://m.media-amazon.com/images/I/61Id6WJDWqL._AC_SY135_.jpg\"]")
	private WebElement zpro;
	
	@FindBy(xpath="//a[@aria-label=\"miniTV\"]")
	private WebElement minitv;
	
	@FindBy(xpath="//a[@data-csa-c-content-id=\"nav_cs_mobiles\"]")
    private WebElement mobiles;
	
	@FindBy(xpath="//span[contains(text(),'Fashion')]")
	private WebElement flip;
	
	public Homepage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void verifylogo() {
		
		if(logo.isDisplayed()) {
			
			System.out.println(logo.isDisplayed());
		}
		
	}
	
	public void searchbar() {
		
		searchbar.sendKeys("samsungmobiles");
		
	}
	
	public void searchbutton() throws InterruptedException{
		searchbutton.click();
	  driver.navigate().back();
	}
	

	public void dropdown() {
		Select o = new Select(dropdown);
		o.selectByVisibleText("Books");
		
	 java.util.List <WebElement> options = o.getOptions();
	   int count     = options.size();
	System.out.println(count);
	
	for(int i=0;i<=count-1;i++) {
		
	String Text	= options.get(i).getText();
	System.out.println(Text);

	}
	}
	public void verifymob() {
		JavascriptExecutor k = ((JavascriptExecutor)driver);
		k.executeScript("arguments[0].scrollIntoView(true)",mobiles);
		mobiles.click();
		driver.navigate().back();
		

	}
	
   public void flip() {
	   
	   driver.get("https://www.flipkart.com/");
	   
	   driver.findElement(By.xpath("//span[@role=\"button\"]")).click();
	   
	   Actions y = new Actions(driver);
	   
	   y.moveToElement(flip).perform();
	   
	   driver.findElement(By.xpath("//body/div[4]/div[1]/object[1]/a[3]")).click();
	   
	   
	   String expectedtext = "Women Ethnic Wear";
	   WebElement Actual = driver.findElement(By.xpath("//h1[contains(text(),'Women Ethnic Wear')]"));
	   
	   if(expectedtext.equals("Actual")) {
		   System.out.println(Actual+"true");
	   }
	   
	   
	   
	   
	   
   }
	
	
	
	}
	

	
	
	
	

