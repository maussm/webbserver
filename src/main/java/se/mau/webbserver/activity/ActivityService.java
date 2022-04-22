package se.mau.webbserver.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Activity getActivity(Long id) {
        Optional<Activity> activity = activityRepository.findById(id);

        if(activity.isPresent()) {
            return activity.get();
        } else {
            throw new IllegalStateException(String.format("%s does not exist", id));
        }
    }

    public void addActivity(Activity activity) {
        Optional<Activity> activityOptional = activityRepository.findActivityByActivityId(activity.getActivityId());

        if(activityOptional.isPresent()) {
            throw new IllegalStateException("Activity taken");
        }

        activityRepository.save(activity);
    }

    public void deleteActivity(String activityId) {
        // boolean exists = activityRepository.existsById(activityId);

        Optional<Activity> activityOptional = activityRepository.findActivityByActivityId(activityId);

        if(activityOptional.isEmpty()) {
            throw new IllegalStateException(String.format("Activity %s does not exist.", activityId));
        }
        activityRepository.delete(activityOptional.get());
    }
}
