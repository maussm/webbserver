package se.mau.webbserver.entity.activity_contents;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityContentsRepository extends JpaRepository<ActivityContents, ActivityContentsId> {
    // Optional<List<ActivityContents>> findByActivityId(Integer id);
    // OOptional<List<ActivityContents>> findByParticipantId(Integer id);
}
