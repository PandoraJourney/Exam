package lt.akademija.repository;

import lt.akademija.model.entity.PriceQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceQuantityRepository extends JpaRepository<PriceQuantity, Long>{
}
