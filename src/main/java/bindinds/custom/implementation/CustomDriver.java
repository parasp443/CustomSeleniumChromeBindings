package bindinds.custom.implementation;

import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

import bindinds.custom.selenium.By;
import bindinds.custom.selenium.WebDriver;
import bindinds.custom.selenium.WebElement;

/**
 * 
 * @author PARAS<parasp443@gmail.com>
 *
 */
public class CustomDriver implements WebDriver {

	public CustomDriver() throws UnirestException {
		CommandExecutor.createSession();
	}

	@Override
	public void get(String url) throws Exception {
		CommandExecutor.executeCommand("post", Command.OPEN_URL, "url", url);
	}

	@Override
	public String getCurrentUrl() {
		return null;
	}

	@Override
	public String getTitle() throws JSONException, UnirestException {
		JSONObject json = CommandExecutor.executeCommand(MethodType.GET, Command.TITLE);
		return "" + json.get("value");
	}

	@Override
	public String getPageSource() throws Exception {
		JSONObject json = CommandExecutor.executeCommand(MethodType.GET, Command.PAGE_SOURCE);
		return "" + json.get("value");
	}

	@Override
	public void close() throws UnirestException {
		CommandExecutor.executeCommand(MethodType.DELETE, Command.CLOSE);
	}

	@Override
	public void quit() throws UnirestException {
		CommandExecutor.executeCommand(MethodType.DELETE, Command.QUIT);
	}

	@Override
	public Set<String> getWindowHandles() {
		return null;
	}

	@Override
	public String getWindowHandle() throws JSONException, UnirestException {
		JSONObject json = CommandExecutor.executeCommand(MethodType.GET, Command.WINDOW_HANDLE);
		return "" + json.get("value");
	}

	@Override
	public TargetLocator switchTo() {
		return null;
	}

	@Override
	public Navigation navigate() {
		return null;
	}

	@Override
	public Options manage() {
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		return null;
	}

}
