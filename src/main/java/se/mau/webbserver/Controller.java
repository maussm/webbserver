package se.mau.webbserver;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.mau.webbserver.activity.Activity;
import se.mau.webbserver.activity.ActivityService;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private final ActivityService activityService;

    public Controller(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Activity> activities = activityService.getActivities();
        model.addAttribute("activites", activities);
        return "index";
    }
}
