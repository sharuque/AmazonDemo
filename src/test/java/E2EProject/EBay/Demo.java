package E2EProject.EBay;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Demo {

	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		Demo();
	}
	public static void Demo() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Moto G5S Plus");
		cap.setCapability("udid", "ZY32286SLC");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Application started");
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/sign_in_button")).click();
		Thread.sleep(3000);
//		driver.findElement(By.id("ap_email_login")).click(); 
		driver.findElement(By.id("continue")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("ap_password")).sendKeys("Xerox01!");
//		driver.findElement(By.id("signInSubmit")).click();
		
		//After login
		
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("moto mobiles");
		
		MobileElement element=driver.findElement(By.id("com.amazon.mShop.android.shopping:id/list_product_description_layout"));
		TouchActions action = new TouchActions(driver);
		 action.scroll(element, 10, 100);
		 action.perform();
		 
		 driver.findElement(By.id("offers-announce")).click();
		 driver.findElement(By.className("android.widget.Button")).click();
		 
		 //to check if the item is added to cart
		 driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_count")).click();
		 //proceed to buy
		 driver.findElement(By.className("android.widget.Button")).click();
		
		
		
		
		
	}
	

}
