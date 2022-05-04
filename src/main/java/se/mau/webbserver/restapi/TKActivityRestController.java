package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.tk.activity.TKActivity;
import se.mau.webbserver.entity.tk.activity.TKActivityService;
import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class TKActivityRestController {
    private final TKActivityService service;

    @Autowired
    public TKActivityRestController(TKActivityService service) {
        this.service = service;
    }

    @GetMapping
    public List<TKActivity> getActivities() {
        return service.getActivities();
    }

    @GetMapping("/{name}&{activityType}")
    public TKActivity getActivities(@PathVariable String name, @PathVariable Long activityId) {
        return service.getActivity(name, activityId);
    }

    @PostMapping
    public void addActivity(@RequestBody TKActivity activity) {
        service.addActivity(activity);
    }

    @DeleteMapping("/{name}&{activityType}")
    public void deleteActivity(@PathVariable String name, @PathVariable Long activityId) {
        service.deleteActivity(name, activityId);
    }
}
