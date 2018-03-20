package lt.akademija.repository;

import com.google.common.collect.Table;
import lt.akademija.model.entity.Tablet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabletRepository extends JpaRepository<Tablet, Long>{
}
