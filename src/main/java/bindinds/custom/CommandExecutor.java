package bindinds.custom;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
/**
 * 
 * @author PARAS<parasp443@gmail.com>
 *
 */
class CommandExecutor {

	private static String sessionID;

	private static String localHost = "http://localhost:9515/session/";

	private CommandExecutor() {

	}

	static void createSession() throws UnirestException {
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

	static JSONObject executeCommand(String methodType, Command command) throws JSONException, UnirestException {
		if (methodType.equals(MethodType.GET))
			return Unirest.get(localHost + sessionID + "/" + command.getValue()).asJson().getBody().getObject();
		else if (methodType.equals(MethodType.DELETE))
			return Unirest.delete(localHost + sessionID + "/" + command.getValue()).asJson().getBody().getObject();
		return null;
	}

	static JSONObject executeCommand(String methodType, Command command, String attributeName, String attributeValue) throws JSONException, UnirestException {
		JSONObject json = new JSONObject();
		json.put("url", attributeValue);
		System.out.println("created json = "+json);
		return Unirest.post(localHost + sessionID + "/" + command.getValue()).body(json).asJson().getBody().getObject();
	}
}
