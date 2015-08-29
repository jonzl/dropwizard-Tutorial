import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.codingdojo.dropwizard.tutorial.core.json.JsonStock;
import de.codingdojo.dropwizard.tutorial.core.json.Stock;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

public class StockTest{


private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

        @Test
        public void deserializesFromJSON() throws Exception {
            final Stock stock = new Stock();
            stock.setName("Google Inc.");
            stock.setType("equity");
            stock.setSymbol("GOOG");
            MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            assertThat( MAPPER.readValue(fixture("fixtures/google.json"), JsonStock.class).getStockBySymbol(stock.getSymbol()).getName()).isEqualTo(stock.getName());
        }
}
