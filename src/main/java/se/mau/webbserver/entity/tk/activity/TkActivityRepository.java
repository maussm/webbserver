package se.mau.webbserver.entity.tk.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TkActivityRepository extends JpaRepository<TkActivity, Long> {
    Optional<TkActivity> findByNameAndActivityType(String name, String activityType);
}
