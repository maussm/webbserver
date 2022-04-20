package se.mau.webbserver.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping()
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }

    @GetMapping("/{id}")
    public Activity getActivities(@PathVariable Long id) {
        return activityService.getActivity(id);
    }

    @PostMapping()
    public void addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);
    }

    @DeleteMapping("/{activityId}")
    public void deleteActivity(@PathVariable String activityId) {
        activityService.deleteActivity(activityId);
    }
}
