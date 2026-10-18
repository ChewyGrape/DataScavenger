package DataMicroservice.DataScavenger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AlphaVantageApiConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://www.alphavantage.co")
                .build();
    }
}

