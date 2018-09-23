package tests;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Sample {

	public static void main(String[] args) throws IOException, JSONException {
		
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{ \"query\": \"{ posts { title } }\" }");
		Request request = new Request.Builder()
		  .url("https://1jzxrj179.lp.gql.zone/graphql")
		  .post(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "305259a9-4df9-451e-6bc6-1771aabc010c")
		  .build();
		System.out.println(request);
		
		Response response = client.newCall(request).execute();
		
		JSONObject jobject = new JSONObject(response.body().string());
		JSONArray jarray = jobject.getJSONObject("data").getJSONArray("posts");
		System.out.println(jarray); 
		
		for (int i = 0; i < jarray.length(); i++) {
		    String str = jarray.getJSONObject(i).getString("title");
		    System.out.println(str);
		}		
	}
}
