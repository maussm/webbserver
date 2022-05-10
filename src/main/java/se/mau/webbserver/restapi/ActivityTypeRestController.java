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
import se.mau.webbserver.entity.tk.activity_type.ActivityType;
import se.mau.webbserver.entity.tk.activity_type.ActivityTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/activity_type")
public class ActivityTypeRestController {

    private final ActivityTypeService service;

    @Autowired
    public ActivityTypeRestController(ActivityTypeService service) {
        this.service = service;
    }
    /*
    @GetMapping
    public List<ActivityType> getActivityTypes() {
        return service.getActivityTypes();
    }*/

    @GetMapping
    public ActivityType getActivityType(String name, Long serviceId) {
        return service.getActivityType(name, serviceId);
    }

    @PostMapping
    public void addActivityType(@RequestBody ActivityType activityType) {
        service.addActivityType(activityType);
    }

    @DeleteMapping("/{id}")
    public void deleteActivityType(@PathVariable String name, @PathVariable Long id) {
        service.deleteActivityType(name, id);
    }

    @PatchMapping("/{id}")
    public void patchActivityType(@PathVariable Long id, @RequestBody ActivityType activityType) {
        service.patchActivityType(id, activityType);
    }
}

