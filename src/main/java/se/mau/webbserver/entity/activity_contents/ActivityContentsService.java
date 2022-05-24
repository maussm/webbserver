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

    // public List<ActivityContents> getActivityContentsByActivityId(Integer id) {
    //     Optional<List<ActivityContents>> optionalActivityContents = activityContentsRepository.findByActivityId(id);
    //
    //     if(optionalActivityContents.isPresent()) {
    //         return optionalActivityContents.get();
    //     } else {
    //         throw new IllegalStateException(String.format("ActivityContents with activity id %s does not exist.", id));
    //     }
    // }

    public void addActivityContents(ActivityContents activityContents) {
        activityContentsRepository.save(activityContents);
    }

    // public void deleteActivityContentsActivityId(Integer id) {
    //     Optional<ActivityContents> optionalActivityContents = activityContentsRepository.findByActivityId(id);
    //
    //     if(optionalActivityContents.isEmpty()) {
    //         throw new IllegalStateException(String.format("Activity contents with activity id %s does not exist.", id));
    //     }
    //
    //     activityContentsRepository.delete(optionalActivityContents.get());
    // }


    // public ActivityContents getActivityContentsByParticipantId(Integer id) {
    //     Optional<ActivityContents> optionalActivityContents = activityContentsRepository.findByParticipantId(id);
    //
    //     if(optionalActivityContents.isPresent()) {
    //         return optionalActivityContents.get();
    //     } else {
    //         throw new IllegalStateException(String.format("ActivityContents with participant id %s does not exist.", id));
    //     }
    // }

    // public void deleteActivityContentsParticipantId(Integer id) {
    //     Optional<ActivityContents> optionalActivityContents = activityContentsRepository.findByParticipantId(id);
    //
    //     if(optionalActivityContents.isEmpty()) {
    //         throw new IllegalStateException(String.format("Activity contents with participant id %s does not exist.", id));
    //     }
    //
    //     activityContentsRepository.delete(optionalActivityContents.get());
    // }
}
