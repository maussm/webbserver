package se.mau.webbserver.costcenter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
}
