package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	static WebDriver driver=null;
	
	public static void initializeBrowser(String browserName) {
		
		
		if(browserName.equals("chrome"))
		{
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			ChromeOptions options= new ChromeOptions();
			options.merge(caps);
			driver= new ChromeDriver(options);
		}
		else if(browserName.equals("edge"))
		{
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			EdgeOptions options= new EdgeOptions();
			options.merge(caps);
			driver= new EdgeDriver(options);
			
		}
			
		else if(browserName.equals("firefox"))
				{
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			FirefoxOptions options= new FirefoxOptions();
			options.merge(caps);
			driver= new FirefoxDriver(options);
				}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
public static WebDriver getDriver() {
	return driver;
}
}
