package se.mau.webbserver.entity.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository repository;

    @Autowired
    public ActivityService(ActivityRepository repository) {
        this.repository = repository;
    }

    public List<Activity> getActivities() {
        return repository.findAll();
    }

    public Activity getActivity(Long id) {
        Optional<Activity> optionalActivity = repository.findById(id);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format("%s does not exist", id));
        }
    }

    public void addActivity(Activity activity) {
        Optional<Activity> optionalActivity = repository.findActivityByActivityId(activity.getActivityId());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException("Activity taken");
        }

        repository.save(activity);
    }

    public void deleteActivity(String activityId) {
        // boolean exists = activityRepository.existsById(activityId);

        Optional<Activity> optionalActivity = repository.findActivityByActivityId(activityId);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity %s does not exist.", activityId));
        }
        repository.delete(optionalActivity.get());
    }

    public void patchActivity(Long id, Activity activity) {
        Optional<Activity> optionalActivity = repository.findById(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity %s does not exist.", id));
        }

        Activity _activity = optionalActivity.get();

        if(!(_activity.equals(activity))) {
            if(activity.getDate() != null) {
                _activity.setDate(activity.getDate());
            }
            if(activity.getReported() != null) {
                _activity.setReported(activity.getReported());
            }
            if(activity.getCostCenter() != null) {
                _activity.setCostCenter(activity.getCostCenter());
            }
            if(activity.getActivityId() != null) {
                _activity.setActivityId(activity.getActivityId());
            }
            if(activity.getNrOfParticipants() != null) {
                _activity.setNrOfParticipants(activity.getNrOfParticipants());
            }

            repository.save(_activity);
        }
    }
}
