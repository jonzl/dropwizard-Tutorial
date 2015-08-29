
package de.codingdojo.dropwizard.tutorial.core.json;

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
        "classname",
        "fields"
})
public class Resource_ {

    @JsonProperty("classname")
    private String classname;
    @JsonProperty("fields")
    private Stock stock;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The classname
     */
    @JsonProperty("classname")
    public String getClassname() {
        return classname;
    }

    /**
     *
     * @param classname
     * The classname
     */
    @JsonProperty("classname")
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     *
     * @return
     * The stock
     */
    @JsonProperty("fields")
    public Stock getStock() {
        return stock;
    }

    /**
     *
     * @param stock
     * The stock
     */
    @JsonProperty("fields")
    public void setStock(Stock stock) {
        this.stock = stock;
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