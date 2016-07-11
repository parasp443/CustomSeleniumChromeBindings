package bindinds.custom;

/**
 * 
 * @author PARAS<parasp443@gmail.com>
 *
 */
public enum Command {

	TITLE("title"),

	PAGE_SOURCE("source"),

	CLICK("click"),

	TYPE("value"),

	CLEAR("clear"),

	CREATE_SESSION("session"),

	OPEN_URL("url"),

	QUIT("window"),

	CLOSE(""),

	WINDOW_HANDLE("window_handle"),

	WINDOW_HANDLES("window_handles"),

	SCREENSHOT("screenshot"),

	;
	private String value;

	private Command(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
