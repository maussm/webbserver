package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.tk.activity.TkActivity;
import se.mau.webbserver.entity.tk.activity.TkActivityService;
import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class TkActivityRestController {
    private final TkActivityService service;

    @Autowired
    public TkActivityRestController(TkActivityService service) {
        this.service = service;
    }

    @GetMapping
    public List<TkActivity> getActivities() {
        return service.getActivities();
    }

    @GetMapping("/{name}&{activityType}")
    public TkActivity getActivities(@PathVariable String name, @PathVariable String activityType) {
        return service.getActivity(name, activityType);
    }

    @PostMapping
    public void addActivity(@RequestBody TkActivity activity) {
        service.addActivity(activity);
    }

    @DeleteMapping("/{name}&{activityType}")
    public void deleteActivity(@PathVariable String name, @PathVariable String activityType) {
        service.deleteActivity(name, activityType);
    }
}
