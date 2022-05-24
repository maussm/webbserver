package se.mau.webbserver.entity.activity_contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityContentsService {
    private final ActivityContentsRepository activityContentsRepository;

    @Autowired
    public ActivityContentsService(ActivityContentsRepository activityContentsRepository) {
        this.activityContentsRepository = activityContentsRepository;
    }

    public List<ActivityContents> getActivityContents() {
        return activityContentsRepository.findAll();
    }

    public ActivityContents getActivityContents(Integer id) {
        Optional<ActivityContents> optionalActivityContents = activityContentsRepository.findByInternalId(id);

        if(optionalActivityContents.isPresent()) {
            return optionalActivityContents.get();
        } else {
            throw new IllegalStateException(String.format("ActivityContents with id %s does not exist.", id));
        }
    }

    public void addActivityContents(ActivityContents activityContents) {
        activityContentsRepository.save(activityContents);
    }

    public void deleteActivityContents(Integer id) {
        Optional<ActivityContents> optionalActivityContents = activityContentsRepository.findByInternalId(id);

        if(optionalActivityContents.isEmpty()) {
            throw new IllegalStateException(String.format("Activity contents with id %s does not exist.", id));
        }

        activityContentsRepository.delete(optionalActivityContents.get());
    }
}
