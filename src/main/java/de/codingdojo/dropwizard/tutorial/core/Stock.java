package de.codingdojo.dropwizard.tutorial.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "de.codingdojo.dropwizard.tutorial.core.Stock.findAll",
                query = "SELECT s FROM Stock s"
        )
})
public class Stock {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "fullName", nullable = false)
    private String symbol;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
