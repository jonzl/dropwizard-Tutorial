package de.codingdojo.dropwizard.tutorial.resources;


import com.codahale.metrics.annotation.Timed;
import de.codingdojo.dropwizard.tutorial.core.Stock;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/financeData")
@Produces(MediaType.APPLICATION_JSON)
public class YahooFinanceResource {
    private final String template;
    HttpRequest httpRequest;
    public YahooFinanceResource(String template) {
    this.template = template;
        httpRequest = new HttpRequest();
    }

    @GET
    @Timed
    @Path("/updateDatabase")
    public Stock updateDB(@QueryParam("symbol") String symbol){
        Stock stock = new Stock();

        try {
            stock = httpRequest.getStockBySymbol(symbol);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stock;
    }

    @GET
    @Timed
    @Path("/getStockInfo")
    public Stock getStockInfo(@QueryParam("symbol") String symbol){
        Stock stock = new Stock();
        try {
            stock = httpRequest.getStockBySymbol(symbol);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stock;
    }
}
