package DataMicroservice.DataScavenger.service;


import DataMicroservice.DataScavenger.dto.AlphaVantageGoldSilverResponse;
import DataMicroservice.DataScavenger.entity.Commodity;
import jakarta.transaction.Transactional;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import DataMicroservice.DataScavenger.repository.CommodityRepository;

@Service
public class CommodityService {

    private final RestClient restClient;
    private final CommodityRepository repository;
    private final String apiKey;

    public CommodityService(RestClient restClient, CommodityRepository repository, @Value("${alphavantage.api.key}") String apiKey) {

        this.restClient = restClient;
        this.repository = repository;
        this.apiKey = apiKey;
    }

    @Transactional
    public Commodity fetchAndSaveGoldPrice() {

        AlphaVantageGoldSilverResponse response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "GOLD_SILVER_SPOT")
                        .queryParam("symbol", "GOLD")
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .body(AlphaVantageGoldSilverResponse.class);

        if (response == null
                || response.getNominal() == null
                || response.getPrice() == null
                || response.getTimestamp() == null) {
            throw new IllegalStateException(
                    "Invalid or empty response from Alpha Vantage");
        }

        Commodity commodityPrice = new Commodity();
        commodityPrice.setNominal(response.getNominal());
        commodityPrice.setPrice(response.getPrice());
        commodityPrice.setTimestamp(response.getParsedTimestamp());

        return repository.save(commodityPrice);
    }


}
