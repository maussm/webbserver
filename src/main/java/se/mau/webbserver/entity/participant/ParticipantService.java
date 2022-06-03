package se.mau.webbserver.entity.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen cost_center.
 */
@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;


    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param participantRepository kopplingen mot tabellen participant.
     */
    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av Participant med alla rader som finns.
     */
    public List<Participant> getParticipants() {
        return participantRepository.findAll();
    }

    /**
     * Hämtar Participant med ett visst id.
     * @param id Id som ska sökas på i databasen.
     * @return Participant om den finnas, annars kastas ett felmeddelande.
     */
    public Participant getParticipant(Integer id) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);

        if(optionalParticipant.isPresent()) {
            return optionalParticipant.get();
        } else {
            throw new IllegalStateException(String.format("Participant with id %s does not exist", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param participant Datan som ska läggas till.
     */
    public void addParticipant(Participant participant) {
        participantRepository.save(participant);
    }

    /**
     * Tar bort data med ett specifikt id från databasen.
     * @param id Id på den data som ska tas bort.
     */
    public void deleteParticipant(Integer id) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);

        if(optionalParticipant.isEmpty()) {
            throw new IllegalStateException(String.format("Participant with id %s does not exist.", id));
        }
        participantRepository.delete(optionalParticipant.get());
    }

    /**
     * Uppdaterar data i databasen.
     * @param id Id på den data som ska uppdateras.
     * @param participant Uppdaterade datan som ska sparas i databasen.
     */
    public void patchParticipant(Integer id, Participant participant) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);

        if(optionalParticipant.isEmpty()) {
            throw new IllegalStateException(String.format("Participant with id %s does not exist.", id));
        }

        Participant _participant = optionalParticipant.get();
        if(participant.getId() != null) {
            _participant.setId(participant.getId());
        }
        participantRepository.save(_participant);
    }
}
