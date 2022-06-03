package se.mau.webbserver.entity.activity_contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen activity_contents.
 */
@Service
public class ActivityContentsService {
    private final ActivityContentsRepository activityContentsRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param activityContentsRepository Kopplingen mot tabellen activity_contents.
     */
    @Autowired
    public ActivityContentsService(ActivityContentsRepository activityContentsRepository) {
        this.activityContentsRepository = activityContentsRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av ActivityContents med alla rader som finns.
     */
    public List<ActivityContents> getActivityContents() {
        return activityContentsRepository.findAll();
    }

    /**
     * Hämtar alla ActivityContents med ett visst id.
     * @param id id som ska sökas på i databasen.
     * @return En lista av ActivityContents med alla rader som har angivna id.
     */
    public List<ActivityContents> getActivityContentsByActivityId(Integer id) {
        Optional<List<ActivityContents>> optionalActivityContents = activityContentsRepository.findByActivityId(id);

        if(optionalActivityContents.isPresent()) {
            return optionalActivityContents.get();
        } else {
            throw new IllegalStateException(String.format("ActivityContents with activity id %s does not exist.", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param activityContents Datan som ska läggas till.
     */
    public void addActivityContents(ActivityContents activityContents) {
        activityContentsRepository.save(activityContents);
    }
}
