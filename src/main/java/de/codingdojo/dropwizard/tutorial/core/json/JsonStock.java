package de.codingdojo.dropwizard.tutorial.core.json;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "list"
})
public class JsonStock {

    @JsonProperty("list")
    private StockList stockList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The list
     */
    @JsonProperty("list")
    public StockList getStockList() {
        return stockList;
    }

    /**
     *
     * @param stockList
     * The list
     */
    @JsonProperty("list")
    public void setStockList(StockList stockList) {
        this.stockList = stockList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ArrayList<Resource> getResources(){
        return (ArrayList<Resource>) ((StockList) stockList).getResources();
            }

    public ArrayList<Stock> getAllStock(){
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        for(Resource resource : getResources()){
            stocks.add(resource.getResource().getStock());
        }
        return  stocks;
    }

    public Stock getStockBySymbol(String symbol){
        ArrayList<Stock> stocks = getAllStock();
        for(Stock stock : stocks){
            if(stock.getSymbol().equals(symbol)){
                return stock;
            }
        }
        return null;
    }
}
