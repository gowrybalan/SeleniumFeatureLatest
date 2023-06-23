import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.network.model.Request;
import org.openqa.selenium.devtools.v111.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bgowr\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		// Log file
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
			System.out.println("Request URL:"+req.getUrl());
			//req.getHeaders();
			
		});
		
		//event get fired 
		devTools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();
			//System.out.println(res.getUrl());
			System.out.println("Response status:"+res.getStatus());
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		


	}

}
