package se.mau.webbserver.entity.tk.activity_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, ActivityType> {
    Optional<ActivityType> findByNameAndServiceType(String name, String serviceType);
}
