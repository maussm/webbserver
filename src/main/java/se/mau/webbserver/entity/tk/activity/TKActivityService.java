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

    public List<TKActivity> getTKactivities() {
        return repository.findAll();
    }

    public TKActivity getTKactivities(String name, Long typeId) {
        Optional<TKActivity> optionalActivity = repository.findByNameAndTypeId(name, typeId);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s does not exist", name, typeId
            ));
        }
    }

    public void addTKactivity(TKActivity activity) {
        Optional<TKActivity> optionalActivity =
            repository.findByNameAndTypeId(activity.getName(), activity.getTypeId());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s already exist", activity.getName(), activity.getTypeId()
            ));
        }
        repository.save(activity);
    }

    public void deleteTKactivity(String name, Long typeId) {
        Optional<TKActivity> optionalActivity =
            repository.findByNameAndTypeId(name, typeId);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format(
                "Activity with name %s and type %s does not exist", name, typeId
            ));
        }
        repository.delete(optionalActivity.get());
    }
}
