package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

/**
 * REST API klass för tabellen activity_contents.
 */
@RestController
@RequestMapping("/api/activity_contents")
public class ActivityContentsRestController {

    private final ActivityContentsService service;
    private final ActivityService activityService;
    private final ParticipantService participantService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param service Koppling mot tabellen activity_contents.
     * @param activityService Koppling mot tabellen activity.
     * @param participantService Koppling mot tabellen participant.
     */
    @Autowired
    public ActivityContentsRestController(ActivityContentsService service, ActivityService activityService, ParticipantService participantService) {
        this.service = service;
        this.activityService = activityService;
        this.participantService = participantService;
    }

    /**
     * URI: /api/activity_contents
     * METOD: GET
     * Hämtar alla ActivityContents.
     * @return Alla ActivityContents som finns.
     */
    @GetMapping
    public List<ActivityContents> getActivityContents() {
        return service.getActivityContents();
    }

    /**
     * URI: /api/activity_contents/activityId/{id}
     * METOD: GET
     * Hämtar alla ActivityContents med angivet activity_id.
     * @param id Id på aktiviteten.
     * @return En lista av ActivityContents som har activity_id med angivet id.
     */
    @GetMapping("/activityId/{id}")
    public List<ActivityContents> getActivityContents(@PathVariable Integer id) {
        return service.getActivityContentsByActivityId(id);
    }

    /**
     * URI: /api/activity_contents
     * METOD: POST
     * Tar emot ett objekt i JSON format och bygger upp en ActivityContents som sedan sparas i databasen.
     * @param activityContentsDTO Det objekt som ska läggs till i databasen.
     */
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
}
