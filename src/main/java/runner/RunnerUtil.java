package runner;

import bindinds.custom.implementation.CustomDriver;
import bindinds.custom.selenium.By;

/**
 * 
 * @author PARAS<parasp443@gmail.com>
 *
 */
public class RunnerUtil {
	public static void main(String... arg) throws Exception {
		CustomDriver driver = new CustomDriver();
		driver.get("http://google.co.in");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("")).click();
		System.out.println(driver.getWindowHandle());
		driver.quit();
		System.out.println("Success");
	}

}