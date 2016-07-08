package bindinds;

public interface MyWebDriverImpl {

	void openURL(String url) throws Exception;

	void fullSize() throws Exception;

	String getTitle() throws Exception;

	void clickElement(String using, String value) throws Exception;

	void closeBrowser() throws Exception;

	void typeTextInElement(String using, String value, String textToType) throws Exception;
}
