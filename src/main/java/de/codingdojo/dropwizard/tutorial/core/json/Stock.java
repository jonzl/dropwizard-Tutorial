
package de.codingdojo.dropwizard.tutorial.core.json;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "name",
        "price",
        "symbol",
        "ts",
        "type",
        "utctime",
        "volume"
})
public class Stock {

    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("ts")
    private String ts;
    @JsonProperty("type")
    private String type;
    @JsonProperty("utctime")
    private String utctime;
    @JsonProperty("volume")
    private String volume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    private long id;
    /**
     *
     * @return
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The price
     */
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The symbol
     */
    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol
     * The symbol
     */
    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return
     * The ts
     */
    @JsonProperty("ts")
    public String getTs() {
        return ts;
    }

    /**
     *
     * @param ts
     * The ts
     */
    @JsonProperty("ts")
    public void setTs(String ts) {
        this.ts = ts;
    }

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The utctime
     */
    @JsonProperty("utctime")
    public String getUtctime() {
        return utctime;
    }

    /**
     *
     * @param utctime
     * The utctime
     */
    @JsonProperty("utctime")
    public void setUtctime(String utctime) {
        this.utctime = utctime;
    }

    /**
     *
     * @return
     * The volume
     */
    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }

    /**
     *
     * @param volume
     * The volume
     */
    @JsonProperty("volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}