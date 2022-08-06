package TestNgDay1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class day1 
{
	public WebDriver d;
  @Test
  public void launching() 
  {
	  System.setProperty("webdriver.chrome.driver", "C://jeet material//chromedriver.exe");
	  d = new ChromeDriver();
	  d.get("https:\\www.amazon.com");
	  String s = d.getTitle();
	  System.out.println(s);
	  d.manage().window().fullscreen();
  }
}
