package de.codingdojo.dropwizard.tutorial.resources;

import com.codahale.metrics.annotation.Timed;
import de.codingdojo.dropwizard.tutorial.core.Stock;
import de.codingdojo.dropwizard.tutorial.db.StockDao;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public Stock findStock(@PathParam("id") LongParam id) {
        return dao.findById(id.get());
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/all")
    public List<Stock> getAllStocks() {
        return dao.findAll();
    }

}
