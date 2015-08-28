package de.codingdojo.dropwizard.tutorial.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codingdojo.dropwizard.tutorial.core.Stock;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private final String USER_AGENT = "Mozilla/5.0";
    private String urlFormat = "http://finance.yahoo.com/webservice/v1/symbols/%s/quote?format=json";


    public Stock getStockBySymbol(String symbol) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String url = String.format(urlFormat,symbol);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

              Stock stock = mapper.readValue(new InputStreamReader(con.getInputStream()),Stock.class);
        return stock;
    }


}
