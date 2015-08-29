package de.codingdojo.dropwizard.tutorial.resources;

import de.codingdojo.dropwizard.tutorial.core.json.Stock;

/**
 * @author Harm Norden, Cofinpro AG
 */
public class StockResource {

    private Stock stock;

    public StockResource(Stock stock) {
        this.stock = stock;
    }
}
