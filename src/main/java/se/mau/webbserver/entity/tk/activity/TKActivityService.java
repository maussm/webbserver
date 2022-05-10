package se.mau.webbserver.entity.tk.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TKActivityService {
    private final TKActivityRepository tkActivityRepository;

    @Autowired
    public TKActivityService(TKActivityRepository tkActivityRepository) {
        this.tkActivityRepository = tkActivityRepository;
    }

    public List<TKActivity> getTKActivities() {
        return tkActivityRepository.findAll();
    }

    public TKActivity getTKActivities(Integer id) {
        Optional<TKActivity> optionalActivity = tkActivityRepository.findByInternalId(id);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format("Activity with id %s does not exist", id));
        }
    }

    public void addTKActivity(TKActivity tkActivity) {
        Optional<TKActivity> optionalActivity = tkActivityRepository.findById(tkActivity.getId());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException(String.format("Activity with id %s already exist", tkActivity.getInternalId()));
        }
        tkActivityRepository.save(tkActivity);
    }

    public void deleteTKActivity(Integer id) {
        Optional<TKActivity> optionalActivity = tkActivityRepository.findByInternalId(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist", id));
        }
        tkActivityRepository.delete(optionalActivity.get());
    }

    public void patchTKActivity(Integer id, TKActivity tkActivity) {
        Optional<TKActivity> optionalTKActivity = tkActivityRepository.findByInternalId(id);

        if(optionalTKActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist.", id));
        }

        TKActivity _tkActivity = optionalTKActivity.get();

        if(tkActivity.getIdExt() != null) {
            _tkActivity.setIdExt(tkActivity.getIdExt());
        }
    }
}
