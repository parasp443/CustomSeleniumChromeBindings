package runner;

import bindinds.custom.implementation.CustomDriver;

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
		System.out.println(driver.getWindowHandle());
		driver.quit();
		System.out.println("Success");
	}

}