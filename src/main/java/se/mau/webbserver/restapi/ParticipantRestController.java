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
import se.mau.webbserver.entity.participant.Participant;
import se.mau.webbserver.entity.participant.ParticipantService;
import java.util.List;

/**
 * REST API klass för tabellen participant.
 */
@RestController
@RequestMapping("/api/participant")
public class ParticipantRestController {
    private final ParticipantService restService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param restService Koppling mot tabellen participant.
     */
    @Autowired
    public ParticipantRestController(ParticipantService restService) {
        this.restService = restService;
    }

    /**
     * URI: /api/participant
     * METOD: GET
     * Hämtar alla Participant.
     * @return Alla Participant som finns.
     */
    @GetMapping
    public List<Participant> getParticipants() {
        return restService.getParticipants();
    }

    /**
     * URI: /api/participant/{id}
     * METOD: GET
     * Hämtar en Participant med angivet id.
     * @param id Id på Participant.
     * @return En Participant med angivet id.
     */
    @GetMapping("/{id}")
    public Participant getParticipant(@PathVariable Integer id) {
        return restService.getParticipant(id);
    }

    /**
     * URI: /api/participant
     * METOD: POST
     * Tar emot ett objekt i JSON format som sedan sparas i databasen.
     * @param participant Det objekt som ska läggs till i databasen.
     */
    @PostMapping
    public void addParticipant(@RequestBody Participant participant) {
        restService.addParticipant(participant);
    }

    /**
     * URI: /api/participant/{id}
     * METOD: DELETE
     * Tar bort en Participant från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Integer id) {
        restService.deleteParticipant(id);
    }

    /**
     * URI: /api/participant/{id}
     * METOD: PATCH
     * Uppdaterar en Participant i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchParticipant(@PathVariable Integer id, @RequestBody Participant participant) {
        restService.patchParticipant(id, participant);
    }
 }
