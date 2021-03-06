package de.codingdojo.dropwizard.tutorial;

import de.codingdojo.dropwizard.tutorial.core.StockEntity;
import de.codingdojo.dropwizard.tutorial.db.StockDao;
import de.codingdojo.dropwizard.tutorial.health.TemplateHealthCheck;
import de.codingdojo.dropwizard.tutorial.resources.HelloWorldResource;
import de.codingdojo.dropwizard.tutorial.resources.StockResource;
import de.codingdojo.dropwizard.tutorial.resources.YahooFinanceResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FinancialDataApplication extends Application<FinanceConfiguration> {

    private final HibernateBundle<FinanceConfiguration> hibernate = new HibernateBundle<FinanceConfiguration>(StockEntity.class) {
        public DataSourceFactory getDataSourceFactory(FinanceConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    private final MigrationsBundle<FinanceConfiguration> liquibase = new MigrationsBundle<FinanceConfiguration>() {
        public DataSourceFactory getDataSourceFactory(FinanceConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new FinancialDataApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<FinanceConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(liquibase);
    }

    @Override
    public void run(FinanceConfiguration configuration,
                    Environment environment) {

        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final YahooFinanceResource yahooFinanceResource = new YahooFinanceResource(
                configuration.getTemplate()
        );
        environment.jersey().register(yahooFinanceResource);
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

        final StockDao dao = new StockDao(hibernate.getSessionFactory());
        environment.jersey().register(new StockResource(dao));
    }

}
