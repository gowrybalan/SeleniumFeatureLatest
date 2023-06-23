import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class GetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bgowr\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		
		//spain 403 3
		Map<String, Object> coordinates =new HashMap<String, Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates );
		
		driver.get("http://google.com");
		Thread.sleep(3000);

		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title = driver.findElement(By.xpath("//h1[@class='default-ltr-cache-19f4kxn ejqbulh8']")).getText();
		System.out.println(title);
		

	}

}
