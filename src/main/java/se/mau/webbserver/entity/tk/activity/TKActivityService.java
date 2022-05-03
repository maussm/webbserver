package se.mau.webbserver.entity.tk.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TKActivityService {
    private final TKActivityRepository repository;

    @Autowired
    public TKActivityService(TKActivityRepository repository) {
        this.repository = repository;
    }

    public List<TKActivity> getActivities() {
        return repository.findAll();
    }

    public TKActivity getActivity(String name, String activityType) {
        Optional<TKActivity> optionalActivity = repository.findByNameAndActivityType(name, activityType);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s does not exist", name, activityType
            ));
        }
    }

    public void addActivity(TKActivity activity) {
        Optional<TKActivity> optionalActivity =
            repository.findByNameAndActivityType(activity.getName(), activity.getTypeId());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s already exist", activity.getName(), activity.getTypeId()
            ));
        }
        repository.save(activity);
    }

    public void deleteActivity(String name, String activityType) {
        Optional<TKActivity> optionalActivity =
            repository.findByNameAndActivityType(name, activityType);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s does not exist", name, activityType
            ));
        }
        repository.delete(optionalActivity.get());
    }
}
