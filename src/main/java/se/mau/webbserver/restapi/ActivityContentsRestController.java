package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.activity.ActivityService;
import se.mau.webbserver.entity.activity_contents.ActivityContents;
import se.mau.webbserver.entity.activity_contents.ActivityContentsDTO;
import se.mau.webbserver.entity.activity_contents.ActivityContentsId;
import se.mau.webbserver.entity.activity_contents.ActivityContentsService;
import se.mau.webbserver.entity.participant.Participant;
import se.mau.webbserver.entity.participant.ParticipantService;
import java.util.List;

@RestController
@RequestMapping("/api/activity_contents")
public class ActivityContentsRestController {

    private final ActivityContentsService service;
    private final ActivityService activityService;
    private final ParticipantService participantService;

    @Autowired
    public ActivityContentsRestController(ActivityContentsService service, ActivityService activityService, ParticipantService participantService) {
        this.service = service;
        this.activityService = activityService;
        this.participantService = participantService;
    }

    @GetMapping
    public List<ActivityContents> getActivityContents() {
        return service.getActivityContents();
    }

    // @GetMapping("/activityId/{id}")
    // public List<ActivityContents> getActivityContents(@PathVariable Integer id) {
    //     return service.getActivityContentsByActivityId(id);
    // }

    @PostMapping
    public void addActivityContents(@RequestBody ActivityContentsDTO activityContentsDTO) {

        Activity activity = activityService.getActivity(activityContentsDTO.getActivity_id());
        Participant participant = participantService.getParticipant(activityContentsDTO.getParticipant_id());

        ActivityContentsId activityContentsId = new ActivityContentsId();
        activityContentsId.setActivityId(activity.getId());
        activityContentsId.setParticipantId(participant.getId());

        ActivityContents activityContents = new ActivityContents();
        activityContents.setActivity(activity);
        activityContents.setParticipant(participant);
        activityContents.setId(activityContentsId);

        service.addActivityContents(activityContents);
    }

    // @DeleteMapping("/{id}")
    // public void deleteActivityContents(@PathVariable Integer id) {
    //     service.deleteActivityContents(id);
    // }
}
