package se.mau.webbserver.entity.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterRepository;
import se.mau.webbserver.entity.tk.activity.TKActivity;
import se.mau.webbserver.entity.tk.activity.TKActivityRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final CostCenterRepository costCenterRepository;
    private final TKActivityRepository tkActivityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, CostCenterRepository costCenterRepository, TKActivityRepository tkActivityRepository) {
        this.activityRepository = activityRepository;
        this.costCenterRepository = costCenterRepository;
        this.tkActivityRepository = tkActivityRepository;
    }

    public List<Activity> getActivity() {
        return activityRepository.findAll();
    }

    public Activity getActivity(Integer id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }
    }

    public void addActivity(Activity activity) {
        activityRepository.save(activity);
    }

    public void deleteActivity(Integer id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }

        activityRepository.delete(optionalActivity.get());
    }

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
