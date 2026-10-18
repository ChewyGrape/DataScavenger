package DataMicroservice.DataScavenger.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlphaVantageGoldSilverResponse {
    private String nominal;
    private String timestamp;

    @JsonProperty("price")
    private BigDecimal price;

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getParsedTimestamp() {
        return LocalDateTime.parse(
                timestamp,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
    }
}
