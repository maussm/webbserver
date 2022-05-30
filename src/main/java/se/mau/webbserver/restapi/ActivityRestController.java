package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.activity.ActivityDTO;
import se.mau.webbserver.entity.activity.ActivityService;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import se.mau.webbserver.entity.tk.activity.TKActivity;
import se.mau.webbserver.entity.tk.activity.TKActivityService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/activity")
public class ActivityRestController {

    private final ActivityService activityService;
    private final CostCenterService costCenterService;
    private final TKActivityService tkActivityService;

    @Autowired
    public ActivityRestController(ActivityService activityService, CostCenterService costCenterService, TKActivityService tkActivityService) {
        this.activityService = activityService;
        this.costCenterService = costCenterService;
        this.tkActivityService = tkActivityService;
    }

    @GetMapping
    public List<Activity> getActivities() {
        return activityService.getActivity();
    }

    @GetMapping("/{id}")
    public Activity getActivity(@PathVariable Integer id) {
        return activityService.getActivity(id);
    }

    @GetMapping("/cost_center_occurrence_date/{id}/{sdate}")
    public List<Activity> getActivityByCostCenter(@PathVariable Integer id, @PathVariable String sdate) {
        LocalDate date = LocalDate.parse(sdate);

        return activityService.getActivityByCostCenterAndOccurrenceDate(id, date);
    }

    @ResponseBody
    @PostMapping
    public Integer addActivity(@RequestBody ActivityDTO activityDTO) {
        CostCenter costCenter = costCenterService.getCostCenter(activityDTO.getCostCenterId());
        TKActivity tkActivity = tkActivityService.getTKActivities(activityDTO.getTkActivityId());

        Activity activity = new Activity();
        activity.setReportedDate(activityDTO.getReportedDate());
        activity.setOccurrenceDate(activityDTO.getOccurrenceDate());
        activity.setCostCenter(costCenter);
        activity.setTkActivity(tkActivity);
        activity.setParticipants(activityDTO.getParticipants());

        activityService.addActivity(activity);
        return activity.getId();
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
