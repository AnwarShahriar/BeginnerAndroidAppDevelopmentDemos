package me.anwarshahriar.webservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanService {

    public static List<Human> humans() throws IOException, JSONException {
        JSONArray json = getHumans();
        List<Human> humans = new ArrayList<>(json.length());
        if (json != null) {
            for (int i = 0; i < json.length(); i++) {
                JSONObject humanJson = json.getJSONObject(i);
                String id = humanJson.getString("id");
                String name = humanJson.getString("name");
                Human human = new Human(id, name);
                humans.add(human);
            }
        }
        return humans;
    }

    private static JSONArray getHumans() throws IOException, JSONException {
        URL url = new URL("http://10.0.2.2:3000/humans");
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        InputStream in =
                new BufferedInputStream(connection.getInputStream());
        Scanner scanner = new Scanner(in);
        scanner.useDelimiter("\\A");

        String resp = null;
        if (scanner.hasNext()) {
            resp = scanner.next();
            connection.disconnect();
        }

        JSONArray arr = null;
        if (resp != null) {
            arr = new JSONArray(resp);
        }

        return arr;
    }
}
