package de.codingdojo.dropwizard.tutorial.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import de.codingdojo.dropwizard.tutorial.db.StockDao;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import de.codingdojo.dropwizard.tutorial.core.json.Stock;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
public class StockResource {

    private StockDao dao;

    public StockResource(StockDao dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    public Stock findStock(@PathParam("id") LongParam id) {
        final Optional<Stock> stock = dao.findById(id.get());
        if (!stock.isPresent()) {
            throw new NotFoundException("No such stock.");
        }
        return stock.get();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/all")
    public List<Stock> getAllStocks() {
        return dao.findAll();
    }

    @POST
    @Timed
    @UnitOfWork
    public Stock createStock(Stock stock) {
        return dao.create(stock);
    }

}
