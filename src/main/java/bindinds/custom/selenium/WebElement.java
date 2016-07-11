
package bindinds.custom.selenium;

import java.util.List;

public interface WebElement extends SearchContext, TakesScreenshot {

	void click();

	void submit();

	void sendKeys(CharSequence... keysToSend);

	void clear();

	String getTagName();

	String getAttribute(String name);

	boolean isSelected();

	boolean isEnabled();

	String getText();

	List<WebElement> findElements(By by);

	WebElement findElement(By by);

	boolean isDisplayed();

	Point getLocation();

	Dimension getSize();

	String getCssValue(String propertyName);
}
