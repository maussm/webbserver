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

    public List<Activity> getActivity() {
        return repository.findAll();
    }

    public Activity getActivity(Long id) {
        Optional<Activity> optionalActivity = repository.findById(id);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }
    }

    public void addActivity(Activity activity) {
        Optional<Activity> optionalActivity = repository.findById(activity.getId());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException(String.format("Activity with %s already exists.", activity.getId()));
        }

        repository.save(activity);
    }

    public void deleteActivity(Long id) {
        Optional<Activity> optionalActivity = repository.findById(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }

        repository.delete(optionalActivity.get());
    }

    public void patchActivity(Long id, Activity activity) {
        Optional<Activity> optionalActivity = repository.findById(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }

        Activity _activity = optionalActivity.get();

        if(!(_activity.equals(activity))) {
            if(activity.getDate() != null) {
                _activity.setDate(activity.getDate());
            }
            if(activity.getOccurrence() != null) {
                _activity.setOccurrence(activity.getOccurrence());
            }
            if(activity.getCostCenterId() != null) {
                _activity.setCostCenterId(activity.getCostCenterId());
            }
            if(activity.getActivityName() != null) {
                _activity.setActivityName(activity.getActivityName());
            }
            if(activity.getNbrOfParticipants() != null) {
                _activity.setNbrOfParticipants(activity.getNbrOfParticipants());
            }
            repository.save(_activity);
        }
    }
}
