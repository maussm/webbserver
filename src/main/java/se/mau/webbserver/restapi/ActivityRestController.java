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

    private final ActivityService activityService;

    @Autowired
    public ActivityRestController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getActivities() {
        return activityService.getActivity();
    }

    @GetMapping("/{id}")
    public Activity getActivity(@PathVariable Integer id) {
        return activityService.getActivity(id);
    }

    @PostMapping()
    public void addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
    }

    @PatchMapping("/{id}")
    public void patchActivity(@PathVariable Integer id, @RequestBody Activity activity) {
        activityService.patchActivity(id, activity);
    }
}
