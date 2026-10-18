package DataMicroservice.DataScavenger.repository;

import DataMicroservice.DataScavenger.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityRepository extends JpaRepository<Commodity,Long> {
}
