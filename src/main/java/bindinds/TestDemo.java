package bindinds;

public class TestDemo {
	public void main() throws Exception {
		System.out.println("starts");
		MyDriver chrome = new MyDriver();
		chrome.fullSize();
		chrome.openURL("http://facebook.com");
		chrome.typeTextInElement("id", "email", "seleniumhq");
		chrome.typeTextInElement("id", "pass", "seleniumhq");
		chrome.clickElement("xpath", "//input[@value='Log In']");
		System.out.println(chrome.getTitle());
		Thread.sleep(5000);
		chrome.closeBrowser();
		System.out.println("Success");
	}

}