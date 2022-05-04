package se.mau.webbserver.entity.activity_contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityContentsService {
    private final ActivityContentsRepository repository;

    @Autowired
    public ActivityContentsService(ActivityContentsRepository repository) {
        this.repository = repository;
    }

    public List<ActivityContents> getActivityContents() {
        return repository.findAll();
    }

    public ActivityContents getActivityContents(Long participantId, Long activityId) {
        Optional<ActivityContents> optionalActivityContents =
            repository.findByParticipantIdAndActivityId(participantId, activityId);

        if(optionalActivityContents.isPresent()) {
            return optionalActivityContents.get();
        } else {
            throw new IllegalStateException(String.format(
                "ActivityContents with participantId %s and activityId %s does not exist.", participantId, activityId));
        }
    }

    public ActivityContents getActivityContents(Long activityId) {
        Optional<ActivityContents> optionalActivityContents =
                repository.findById(activityId);

        if(optionalActivityContents.isPresent()) {
            return optionalActivityContents.get();
        } else {
            throw new IllegalStateException(String.format(
                    "ActivityContents with activityId %s does not exist.", activityId));
        }
    }

    public void addActivityContents(ActivityContents activityContents) {
        Long participantId = activityContents.getParticipantId();
        Long activityId = activityContents.getActivityId();
        Optional<ActivityContents> optionalActivityContents =
            repository.findByParticipantIdAndActivityId(participantId, activityId);

        if(optionalActivityContents.isPresent()) {
            throw new IllegalStateException(String.format(
                "ActivityContents with participantId %s and activityId %s already exists.", participantId, activityId
            ));
        }

        repository.save(activityContents);
    }

    public void deleteActivityContents(Long participantId, Long activityId) {
        Optional<ActivityContents> optionalActivityContents =
            repository.findByParticipantIdAndActivityId(participantId, activityId);

        if(optionalActivityContents.isEmpty()) {
            throw new IllegalStateException(String.format(
                "Activity contents with participantId %s and activityId %s does not exist.", participantId, activityId
            ));
        }

        repository.delete(optionalActivityContents.get());
    }


    public void deleteActivityContents(Long activityId) {
        Optional<ActivityContents> optionalActivityContents =
                repository.findById(activityId);

        if(optionalActivityContents.isEmpty()) {
            throw new IllegalStateException(String.format(
                    "Activity contents with activityId %s does not exist.", activityId
            ));
        }
        repository.delete(optionalActivityContents.get());
    }

    public void patchActivityContents(Long participantId, Long activityId, ActivityContents activityContents) {
        Optional<ActivityContents> optionalActivityContents =
            repository.findByParticipantIdAndActivityId(participantId, activityId);

        if(optionalActivityContents.isEmpty()) {
            throw new IllegalStateException(String.format(
                "Activity contents with participantId %s and activityId %s does not exist.", participantId, activityId)
            );
        }

        ActivityContents _activity = optionalActivityContents.get();

        if(!(_activity.equals(activityContents))) {
            if(activityContents.getParticipantId() != null) {
                _activity.setParticipantId(activityContents.getParticipantId());
            }
            if(activityContents.getActivityId() != null) {
                _activity.setActivityId(activityContents.getActivityId());
            }
            repository.save(_activity);
        }
    }
}
