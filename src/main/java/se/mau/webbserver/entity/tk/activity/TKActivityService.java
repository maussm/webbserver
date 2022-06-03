package se.mau.webbserver.entity.tk.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen tk_activity.
 */
@Service
public class TKActivityService {
    private final TKActivityRepository tkActivityRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param tkActivityRepository kopplingen mot tabellen tk_activity.
     */
    @Autowired
    public TKActivityService(TKActivityRepository tkActivityRepository) {
        this.tkActivityRepository = tkActivityRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av TKActivity med alla rader som finns.
     */
    public List<TKActivity> getTKActivities() {
        return tkActivityRepository.findAll();
    }

    /**
     * Hämtar TKActivity med ett visst id.
     * @param id Id som ska sökas på i databasen.
     * @return TKActivity om den finnas, annars kastas ett felmeddelande.
     */
    public TKActivity getTKActivities(Integer id) {
        Optional<TKActivity> optionalActivity = tkActivityRepository.findByInternalId(id);

        if(optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new IllegalStateException(String.format("Activity with id %s does not exist", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param tkActivity Datan som ska läggas till.
     */
    public void addTKActivity(TKActivity tkActivity) {
        Optional<TKActivity> optionalActivity = tkActivityRepository.findById(tkActivity.getId());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException(String.format("Activity with id %s already exist", tkActivity.getInternalId()));
        }
        tkActivityRepository.save(tkActivity);
    }

    /**
     * Tar bort data med ett specifikt id från databasen.
     * @param id Id på den data som ska tas bort.
     */
    public void deleteTKActivity(Integer id) {
        Optional<TKActivity> optionalActivity = tkActivityRepository.findByInternalId(id);

        if(optionalActivity.isEmpty()) {
            throw new IllegalStateException(String.format("Activity with id %s does not exist", id));
        }
        tkActivityRepository.delete(optionalActivity.get());
    }

    /**
     * Uppdaterar data i databasen.
     * @param id Id på den data som ska uppdateras.
     * @param tkActivity Uppdaterade datan som ska sparas i databasen.
     */
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
