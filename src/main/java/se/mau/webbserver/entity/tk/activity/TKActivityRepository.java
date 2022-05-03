package se.mau.webbserver.entity.tk.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TKActivityRepository extends JpaRepository<TKActivity, Long> {
    Optional<TKActivity> findByNameAndActivityType(String name, String activityType);
}
