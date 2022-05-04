package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.activity_contents.ActivityContents;
import se.mau.webbserver.entity.activity_contents.ActivityContentsService;

import java.util.List;

@RestController
@RequestMapping("/api/activity_contents")
public class ActivityContentsRestController {

    private final ActivityContentsService service;

    @Autowired
    public ActivityContentsRestController(ActivityContentsService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityContents> getActivityContents() {
        return service.getActivityContents();
    }

    @GetMapping("/{id}")
    public ActivityContents getActivityContents(@PathVariable Long activityId) {
        return service.getActivityContents(activityId);
    }

    @PostMapping
    public void addActivityContents(@RequestBody ActivityContents activityContents) {
        service.addActivityContents(activityContents);
    }

    @DeleteMapping("/{id}")
    public void deleteActivityContents(@PathVariable Long activityId) {
        service.deleteActivityContents(activityId);
    }

    @PatchMapping("/{id}")
    public void patchActivityContents(@PathVariable Long activityId, Long participantId, @RequestBody ActivityContents activityContents) {
        service.patchActivityContents(participantId, activityId, activityContents);
    }
}
