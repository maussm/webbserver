package se.mau.webbserver.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public List<Activity> findAllById(Long id) {
        return activityRepository.findAllById(List.of(id));
    } //TODO Test Method. Method takes the internal DB ID of a Cost Center and returns all activities pertaining to that Cost Center
}