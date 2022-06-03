package se.mau.webbserver.entity.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterRepository;
import se.mau.webbserver.entity.tk.activity.TKActivity;
import se.mau.webbserver.entity.tk.activity.TKActivityRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen Activity.
 */
@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final CostCenterRepository costCenterRepository;
    private final TKActivityRepository tkActivityRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param activityRepository Kopplingen till tabellen activity.
     * @param costCenterRepository Koppling till tabellen cost_center.
     * @param tkActivityRepository Koppling till tabellen tk_activity.
     */
    @Autowired
    public ActivityService(ActivityRepository activityRepository, CostCenterRepository costCenterRepository, TKActivityRepository tkActivityRepository) {
        this.activityRepository = activityRepository;
        this.costCenterRepository = costCenterRepository;
        this.tkActivityRepository = tkActivityRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return Alla rader som finns i form av en lista med Activity.
     */
    public List<Activity> getActivity() {
        return activityRepository.findAll();
    }

    /**
     * Hämtar en lista med aktiviteter för ett angivet kostnadsställe och datum.
     * @param id ID från tabellen cost_center.
     * @param date Datum för när aktiviteten var.
     * @return En lista med alla aktiviteter för det angivna kostnadsstället och datumet om något finns, annars null.
     */
    public List<Activity> getActivityByCostCenterAndOccurrenceDate(Integer id, LocalDate date) {
        Optional<List<Activity>> activities = activityRepository.findByCostCenter_IdAndOccurrenceDate(id, date);
        return activities.orElse(null);
    }

    /**
     * Hämtar en specifik aktivitet.
     * @param id ID på aktiviteten att hämta.
     * @return Aktiviteten med ID om den finns, annars kastas felmeddelande.
     */
    public Activity getActivity(Integer id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }
    }

    /**
     * Lägger till en ny aktivitet i databasen.
     * @param activity Aktivteten att spara i databasen.
     */
    public void addActivity(Activity activity) {
        activityRepository.save(activity);
    }

    /**
     * Tar bort en aktivitet från databasen.
     * @param id ID på den aktivitet att ta bort.
     */
    public void deleteActivity(Integer id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }

        activityRepository.delete(optionalActivity.get());
    }

    /**
     * Uppdaterar en aktivitet.
     * @param id ID på den aktivitet att uppdatera.
     * @param activity En aktivitet som innehåller all data som ska uppdateras.
     */
    public void patchActivity(Integer id, Activity activity) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }

        Activity _activity = optionalActivity.get();

        if(activity.getReportedDate() != null) {
            _activity.setReportedDate(activity.getReportedDate());
        }
        if(activity.getOccurrenceDate() != null) {
            _activity.setOccurrenceDate(activity.getOccurrenceDate());
        }
        if(activity.getCostCenter().getId() != null) {
            int costCenterId = activity.getCostCenter().getId();
            Optional<CostCenter> costCenter = costCenterRepository.findById(costCenterId);

            if(costCenter.isEmpty()) {
                throw new IllegalStateException("Cost center was not found.");
            }

            _activity.setCostCenter(costCenter.get());
        }
        if(activity.getTkActivity() != null) {
            int tkActivityId = activity.getTkActivity().getInternalId();
            Optional<TKActivity> tkActivity = tkActivityRepository.findByInternalId(tkActivityId);

            if(tkActivity.isEmpty()) {
                throw new IllegalStateException("TKActivity was not found.");
            }

            _activity.setTkActivity(tkActivity.get());
        }
        if(activity.getParticipants() != null) {
            _activity.setParticipants(activity.getParticipants());
        }
        activityRepository.save(_activity);
    }
}
