
package bindinds.custom.selenium;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface WebDriver extends SearchContext {

	void get(String url) throws Exception;

	String getCurrentUrl() throws Exception;

	String getTitle() throws Exception;

	List<WebElement> findElements(By by);

	WebElement findElement(By by);

	String getPageSource() throws Exception;

	void close() throws Exception;

	void quit() throws Exception;

	Set<String> getWindowHandles() throws Exception;

	String getWindowHandle() throws Exception;

	TargetLocator switchTo() throws Exception;

	Navigation navigate() throws Exception;

	Options manage() throws Exception;

	interface Options {

		void deleteCookieNamed(String name) throws Exception;

		void deleteAllCookies() throws Exception;

		Timeouts timeouts() throws Exception;

		ImeHandler ime() throws Exception;

		Window window() throws Exception;

	}

	interface Timeouts {

		Timeouts setScriptTimeout(long time, TimeUnit unit) throws Exception;

		Timeouts implicitlyWait(long time, TimeUnit unit) throws Exception;

		Timeouts pageLoadTimeout(long time, TimeUnit unit) throws Exception;
	}

	interface TargetLocator {

		WebDriver frame(int index) throws Exception;

		WebDriver frame(String nameOrId) throws Exception;

		WebDriver frame(WebElement frameElement) throws Exception;

		WebDriver parentFrame() throws Exception;

		WebDriver window(String nameOrHandle) throws Exception;

		WebDriver defaultContent() throws Exception;

		WebElement activeElement() throws Exception;

	}

	interface Navigation {
		void back() throws Exception;

		void forward() throws Exception;

		void to(String url) throws Exception;

		void to(URL url) throws Exception;

		void refresh() throws Exception;
	}

	interface ImeHandler {
		List<String> getAvailableEngines() throws Exception;

		String getActiveEngine() throws Exception;

		boolean isActivated() throws Exception;

		void deactivate() throws Exception;

		void activateEngine(String engine) throws Exception;
	}

	interface Window {
		void setSize(Dimension targetSize) throws Exception;

		void setPosition(Point targetPosition) throws Exception;

		Dimension getSize() throws Exception;

		Point getPosition() throws Exception;

		void maximize() throws Exception;

		void fullscreen() throws Exception;
	}
}
