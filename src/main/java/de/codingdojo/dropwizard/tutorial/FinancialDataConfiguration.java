package de.codingdojo.dropwizard.tutorial;

import de.codingdojo.dropwizard.tutorial.health.TemplateHealthCheck;
import de.codingdojo.dropwizard.tutorial.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FinancialDataConfiguration extends Application<FinanceConfiguration> {
    public static void main(String[] args) throws Exception {
        new FinancialDataConfiguration().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<FinanceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(FinanceConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);


        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
