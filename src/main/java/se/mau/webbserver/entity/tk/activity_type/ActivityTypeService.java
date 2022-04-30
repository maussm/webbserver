package se.mau.webbserver.entity.tk.activity_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityTypeService {
    private final ActivityTypeRepository repository;

    @Autowired
    public ActivityTypeService(ActivityTypeRepository repository) {
        this.repository = repository;
    }

    private Optional<ActivityType> findById(String name, String serviceName) {
        return repository.findByNameAndServiceType(name, serviceName);
    }

    public List<ActivityType> getActivityTypes() {
        return repository.findAll();
    }

    public ActivityType getActivityType(String name, String serviceName) {
        Optional<ActivityType> optionalActivityType = findById(name, serviceName);

        if(optionalActivityType.isPresent()) {
            return optionalActivityType.get();
        } else {
            throw new IllegalStateException(String.format(
                "Activity type with name %s and service %s does not exist", name, serviceName
            ));
        }
    }

    public void addActivityType(ActivityType activityType) {
        Optional<ActivityType> optionalActivityType = findById(activityType.getName(), activityType.getServiceType());

        if(optionalActivityType.isPresent()) {
            throw new IllegalStateException(String.format(
                "Activity type with name %s and service %s already exist",
                activityType.getName(), activityType.getServiceType()
            ));
        }

        repository.save(activityType);
    }

    public void deleteActivityType(String name, String activityType) {
        Optional<ActivityType> optionalActivityType = findById(name, activityType);

        if(optionalActivityType.isEmpty()) {
            throw new IllegalStateException(String.format(
                "Activity type with name %s and service %s does not exist", name, activityType
            ));
        }
        repository.delete(optionalActivityType.get());
    }
}
