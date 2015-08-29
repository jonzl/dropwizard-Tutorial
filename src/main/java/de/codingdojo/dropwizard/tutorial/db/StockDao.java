package de.codingdojo.dropwizard.tutorial.db;

import de.codingdojo.dropwizard.tutorial.core.StockEntity;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class StockDao extends AbstractDAO<StockEntity> {

    public StockDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<StockEntity> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public StockEntity create(StockEntity stock) {
        return persist(stock);
    }

    public List<StockEntity> findAll() {
        return list(namedQuery("de.codingdojo.dropwizard.tutorial.core.StockEntity.findAll"));
    }

}
