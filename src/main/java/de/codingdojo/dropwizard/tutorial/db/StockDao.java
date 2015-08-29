package de.codingdojo.dropwizard.tutorial.db;

import de.codingdojo.dropwizard.tutorial.core.json.Stock;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class StockDao extends AbstractDAO<Stock> {

    public StockDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Stock findById(Long id) {
        return get(id);
    }

    public long create(Stock fund) {
        return persist(fund).getId();
    }

    public List<Stock> findAll() {
        return list(namedQuery("de.codingdojo.dropwizard.core.Stock.findAll"));
    }

}
