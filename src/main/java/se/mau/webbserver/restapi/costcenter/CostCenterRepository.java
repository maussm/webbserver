package se.mau.webbserver.restapi.costcenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import java.util.Optional;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
    @Override
    @NonNull
    Optional<CostCenter> findById(@NonNull Long costCenterId);
}
