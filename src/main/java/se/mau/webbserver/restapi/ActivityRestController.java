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
import java.util.List;

/**
 * REST API klass för tabellen activity.
 */
@RestController
@RequestMapping("/api/activity")
public class ActivityRestController {

    private final ActivityService activityService;
    private final CostCenterService costCenterService;
    private final TKActivityService tkActivityService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param activityService Koppling mot tabellen activity.
     * @param costCenterService Koppling mot tabellen cost_center.
     * @param tkActivityService Koppling mot tabellen tk_activity.
     */
    @Autowired
    public ActivityRestController(ActivityService activityService, CostCenterService costCenterService, TKActivityService tkActivityService) {
        this.activityService = activityService;
        this.costCenterService = costCenterService;
        this.tkActivityService = tkActivityService;
    }

    /**
     * URI: /api/activity
     * METOD: GET
     * Hämtar alla Activity.
     * @return Alla Activity som finns.
     */
    @GetMapping
    public List<Activity> getActivities() {
        return activityService.getActivity();
    }

    /**
     * URI: /api/activity/{id}
     * METOD: GET
     * Hämtar en Activity med angivet id.
     * @param id Id på aktiviteten.
     * @return En Activity med angivet id.
     */
    @GetMapping("/{id}")
    public Activity getActivity(@PathVariable Integer id) {
        return activityService.getActivity(id);
    }

    /**
     * URI: /api/activity/cost_center_occurrence_date/{id}/{sdate}
     * METOD: GET
     * Hämtar alla Activity för ett visst kostnadsställe på angivet datum.
     * @param id Id för ett kostnadsställe.
     * @param sdate Datum som sträng i formatet ÅÅÅÅ-MM-DD.
     * @return En lista av Activity.
     */
    @GetMapping("/cost_center_occurrence_date/{id}/{sdate}")
    public List<Activity> getActivityByCostCenter(@PathVariable Integer id, @PathVariable String sdate) {
        LocalDate date = LocalDate.parse(sdate);

        return activityService.getActivityByCostCenterAndOccurrenceDate(id, date);
    }

    /**
     * URI: /api/activity
     * METOD: POST
     * Tar emot ett objekt i JSON format och bygger upp en Activity som sedan sparas i databasen.
     * @param activityDTO Det objekt som ska läggs till i databasen.
     * @return Id på den skapade aktivteten.
     */
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

    /**
     * URI: /api/activity/{id}
     * METOD: DELETE
     * Tar bort en Activity från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
    }

    /**
     * URI: /api/activity/{id}
     * METOD: PATCH
     * Uppdaterar en Activity i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchActivity(@PathVariable Integer id, @RequestBody Activity activity) {
        activityService.patchActivity(id, activity);
    }
}
