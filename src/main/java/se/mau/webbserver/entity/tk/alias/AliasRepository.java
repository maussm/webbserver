package se.mau.webbserver.entity.tk.alias;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mau.webbserver.entity.cost_center.CostCenter;
import java.util.List;
import java.util.Optional;

public interface AliasRepository extends JpaRepository<Alias, AliasId> {
    Optional<Alias> findByInternalId(Integer id);
    Optional<List<Alias>> findByCostCenter(CostCenter costCenter);
}
