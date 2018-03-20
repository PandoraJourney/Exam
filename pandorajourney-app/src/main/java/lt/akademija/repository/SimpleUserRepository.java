package lt.akademija.repository;

import lt.akademija.model.entity.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleUserRepository extends JpaRepository< SimpleUser, Long> {
}
