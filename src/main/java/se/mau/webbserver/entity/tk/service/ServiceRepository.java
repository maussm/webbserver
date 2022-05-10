package se.mau.webbserver.entity.tk.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, ServiceId> {
    Optional<Service> findByInternalId(Integer id);
}
