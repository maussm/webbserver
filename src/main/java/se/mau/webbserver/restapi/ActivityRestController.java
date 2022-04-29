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
import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.activity.ActivityService;
import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityRestController {
    private final ActivityService service;

    @Autowired
    public ActivityRestController(ActivityService service) {
        this.service = service;
    }

    @GetMapping
    public List<Activity> getActivities() {
        return service.getActivities();
    }

    @GetMapping("/{id}")
    public Activity getActivities(@PathVariable Long id) {
        return service.getActivity(id);
    }

    @PostMapping
    public void addActivity(@RequestBody Activity activity) {
        service.addActivity(activity);
    }

    @DeleteMapping("/{activityId}")
    public void deleteActivity(@PathVariable String activityId) {
        service.deleteActivity(activityId);
    }

    @PatchMapping("/{id}")
    public void patchActivity(@PathVariable Long id, @RequestBody Activity activity) {
        service.patchActivity(id, activity);
    }
}
