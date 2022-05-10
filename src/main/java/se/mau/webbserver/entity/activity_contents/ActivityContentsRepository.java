package se.mau.webbserver.entity.activity_contents;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActivityContentsRepository extends JpaRepository<ActivityContents, ActivityContentsId> {
    Optional<ActivityContents> findByInternalId(Integer id);
}
