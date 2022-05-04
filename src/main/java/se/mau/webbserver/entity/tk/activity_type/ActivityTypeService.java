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

    private Optional<ActivityType> findById(String name, Long serviceId) {
        return repository.findByNameAndServiceId(name, serviceId);
    }

    public List<ActivityType> getActivityTypes() {
        return repository.findAll();
    }

    public ActivityType getActivityType(String name, Long serviceId) {
        Optional<ActivityType> optionalActivityType = findById(name, serviceId);

        if(optionalActivityType.isPresent()) {
            return optionalActivityType.get();
        } else {
            throw new IllegalStateException(String.format(
                "Activity type with name %s and service %s does not exist", name, serviceId
            ));
        }
    }

    public void addActivityType(ActivityType activityType) {
        Optional<ActivityType> optionalActivityType = findById(activityType.getName(), activityType.getServiceId());

        if(optionalActivityType.isPresent()) {
            throw new IllegalStateException(String.format(
                "Activity type with name %s and service %s already exist",
                activityType.getName(), activityType.getServiceId()
            ));
        }
        repository.save(activityType);
    }

    public void deleteActivityType(String name, Long serviceId) {
        Optional<ActivityType> optionalActivityType = findById(name, serviceId);

        if(optionalActivityType.isEmpty()) {
            throw new IllegalStateException(String.format(
                "Activity type with name %s and service %s does not exist", name, serviceId
            ));
        }
        repository.delete(optionalActivityType.get());
    }
}
