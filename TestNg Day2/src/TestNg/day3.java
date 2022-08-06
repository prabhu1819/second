package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class day3
{
	public WebDriver d;
	
  @Test(groups = "sanity")
  public void first() 
  {
	  System.setProperty("webdriver.chrome.driver", "C://jeet material//chromedriver.exe");
	  d =new ChromeDriver();
	  d.get("https://www.amazon.com");
	  d.manage().window().maximize();
  }
  @Test(groups = "regression")
  public void second()
  {
	  JavascriptExecutor j = (JavascriptExecutor)d;
	  WebElement search = d.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	  WebElement cli =  d.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
	  j.executeScript("arguments[0].value='iphone 13'", search);
	  j.executeScript("arguments[0].click()", cli);
	  d.getTitle();
  }
   
}
