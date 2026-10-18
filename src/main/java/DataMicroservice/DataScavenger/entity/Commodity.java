package DataMicroservice.DataScavenger.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String nominal;

    @Column(nullable = false, precision = 20, scale = 10)
    private BigDecimal price;

    @Column(name = "price_timestamp", nullable = false)
    private LocalDateTime timestamp;
}
