package se.mau.webbserver.entity.tk.alias;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AliasRepository extends JpaRepository<Alias, AliasId> {
    Optional<Alias> findByInternalId(Integer id);
}
