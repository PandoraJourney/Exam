package lt.akademija.repository;


import lt.akademija.model.entity.AbstractProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractProductRepository extends JpaRepository<AbstractProduct, Long>{
}
