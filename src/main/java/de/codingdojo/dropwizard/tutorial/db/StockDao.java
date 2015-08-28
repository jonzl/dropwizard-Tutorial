package de.codingdojo.dropwizard.tutorial.db;

import com.google.common.base.Optional;
import de.codingdojo.dropwizard.tutorial.core.Stock;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class StockDao extends AbstractDAO<Stock> {

    public StockDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Stock> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Stock create(Stock stock) {
        return persist(stock);
    }

    public List<Stock> findAll() {
        return list(namedQuery("de.codingdojo.dropwizard.tutorial.core.Stock.findAll"));
    }

}
