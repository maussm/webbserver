package se.mau.webbserver.entity.tk.activity;

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

    public Activity getActivity(String name, String activityType) {
        Optional<Activity> optionalActivity = repository.findByNameAndActivityType(name, activityType);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s does not exist", name, activityType
            ));
        }
    }

    public void addActivity(Activity activity) {
        Optional<Activity> optionalActivity =
            repository.findByNameAndActivityType(activity.getName(), activity.getActivityType());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s already exist", activity.getName(), activity.getActivityType()
            ));
        }

        repository.save(activity);
    }

    public void deleteActivity(String name, String activityType) {
        Optional<Activity> optionalActivity =
            repository.findByNameAndActivityType(name, activityType);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s does not exist", name, activityType
            ));
        }
        repository.delete(optionalActivity.get());
    }
}
