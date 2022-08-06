package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class day3
{
	public WebDriver d;
	
  @Test(groups = "sanity",priority = 1)
  public void first() 
  {
	  System.setProperty("webdriver.chrome.driver", "C://jeet material//chromedriver.exe");
	  d =new ChromeDriver();
	  d.get("https://www.amazon.com");
	  d.manage().window().maximize();
  }
  @Test(groups = "regression",priority = 2)
  public void second()
  {
	  JavascriptExecutor j = (JavascriptExecutor)d;
	  WebElement search = d.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	  WebElement cli =  d.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
	  j.executeScript("arguments[0].value='iphone 13'", search);
	  j.executeScript("arguments[0].click()", cli);
	  String title = d.getTitle();
	  System.out.println(title);
  }
  @Test(priority = 3)
  public void third()
  {
	  d.close();
	  
  }
   
}

