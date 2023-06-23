import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bgowr\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		// https://chromedevtools.github.io/devtools-protocol/

		//System.setProperty("webdriver.chrome.driver","/Users/bgowr/Documents/chromedriver_win32");
		ChromeDriver driver=new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//send command to CDP methods ===> CDP methods will be invoke and get access to chrome devtools
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		
		driver.close();

	}

}
