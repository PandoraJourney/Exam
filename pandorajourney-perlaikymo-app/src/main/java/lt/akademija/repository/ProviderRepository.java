package lt.akademija.repository;


import lt.akademija.model.entity.Provider;
import lt.akademija.model.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{

    Provider findOneByName(String name);
    List<Provider> findAllByType(String type);
}
