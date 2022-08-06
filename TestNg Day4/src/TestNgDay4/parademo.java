package TestNgDay4;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class parademo 
{
	//in order to execute mul func first we used dependes on method
  @Test(dependsOnMethods = "multiplication")
  @Parameters({"a","b"})
  public void sum(int a, int b) 
  {
	  int sum;
	  sum = a+b;
	  System.out.println("Addition is:"+sum);  
  }
  @Test
  @Parameters({"a","b"})
  public void multiplication(int a1, int b1)
  {
	  int mul;
	  mul=a1*b1;
	  System.out.println("Multiplicati is:"+mul);
	  
  }
}
