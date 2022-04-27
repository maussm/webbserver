package se.mau.webbserver.restapi.costcenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import java.util.Optional;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
    @Override
    Optional<CostCenter> findById( Long costCenterId);
}
