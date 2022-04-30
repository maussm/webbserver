package se.mau.webbserver.entity.cost_center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import java.util.Optional;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
}
