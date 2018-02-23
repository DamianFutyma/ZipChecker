package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.TreeSet;

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
        Set<String> listOfLocation=new TreeSet<String>();
        for (int i = 0; i <jsonArray.length() ; i++) {
            JSONObject location=jsonArray.getJSONObject(i);
            listOfLocation.add(location.getString("miejscowosc"));
        }
        if(listOfLocation.size()==0){
            System.out.println("Sorry, I can't found any location using this zip code :(");
        }else{
            System.out.printf("Program found %s location using this zip code\n",listOfLocation.size());
            System.out.println(listOfLocation);
        }
    }

}




