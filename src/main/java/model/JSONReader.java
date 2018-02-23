package model;

import org.json.JSONArray;
import org.json.JSONException;


import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONReader {

     private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONArray readJsonFromUrl(String URL)throws IOException,JSONException{
        InputStream start=new URL(URL).openStream();
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(start, Charset.forName("UTF-8")));
            String jsonText=readAll(reader);
            return new JSONArray(jsonText);
        }finally {
            start.close();
        }
    }
    static void showJSON(String postCode) throws IOException,JSONException {
        JSONArray jsonArray=readJsonFromUrl("http://kodypocztowe-api.pl/"+postCode);
        System.out.println(jsonArray.toString());
    }

}




