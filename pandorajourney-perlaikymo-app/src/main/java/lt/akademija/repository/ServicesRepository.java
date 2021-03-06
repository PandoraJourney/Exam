package lt.akademija.repository;

import lt.akademija.model.entity.Provider;
import lt.akademija.model.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long>{

    Services findOneByName(String name);

    Long countById(Long id);
}
