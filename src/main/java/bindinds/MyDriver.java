package bindinds;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MyDriver implements MyWebDriverImpl {

	String sessionID;

	String localHost = "http://localhost:9515/session/";

	private void createSession() throws UnirestException {
		JSONObject j = new JSONObject();
		JSONObject j1 = new JSONObject();
		j1.put("browser", "chrome");
		j.put("desiredCapabilities", j1);
		System.out.println(j);
		HttpResponse<JsonNode> res = Unirest.post("http://localhost:9515/session").body(j).asJson();
		JsonNode node = res.getBody();
		sessionID = node.getObject().get("sessionId").toString();
		System.out.println(sessionID);
	}

	@Override
	public void openURL(String url) throws Exception {
		createSession();
		JSONObject j = new JSONObject();
		j.put("url", url);
		System.out.println("url obj=" + j);
		String urlGen = localHost + sessionID + "/url";
		System.out.println(urlGen);

		Unirest.post(urlGen).body(j).asJson();
	}

	@Override
	public void fullSize() throws Exception {

	}

	@Override
	public String getTitle() throws Exception {
		return "" + Unirest.get(localHost + sessionID + "/title").asJson().getBody().getObject().get("value");
	}

	@Override
	public void clickElement(String using, String value) throws Exception {
		JSONObject j = new JSONObject();
		j.put("using", using);
		j.put("value", value);
		System.out.println("element json=" + j);
		HttpResponse<JsonNode> res = Unirest.post(localHost + sessionID + "/element").body(j).asJson();
		String elementID = res.getBody().getObject().getJSONObject("value").get("ELEMENT").toString();
		Unirest.post(localHost + sessionID + "/element/" + elementID + "/click").body(j).asJson();
		System.out.println();
	}

	@Override
	public void typeTextInElement(String using, String value, String textToType) throws Exception {
		JSONObject j = new JSONObject();
		j.put("using", using);
		j.put("value", value);
		System.out.println("element type json=" + j);
		HttpResponse<JsonNode> res = Unirest.post(localHost + sessionID + "/element").body(j).asJson();
		String elementID = res.getBody().getObject().getJSONObject("value").get("ELEMENT").toString();
		Unirest.post(localHost + sessionID + "/element/" + elementID + "/value").body("{\"value\":[\"" + textToType + "\"]}").asJson();
	}

	@Override
	public void closeBrowser() throws UnirestException {
		Unirest.delete(localHost + sessionID + "/window").asJson();

	}
}
