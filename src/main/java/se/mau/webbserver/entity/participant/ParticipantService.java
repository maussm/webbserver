package se.mau.webbserver.entity.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> getParticipants() {
        return participantRepository.findAll();
    }

    public Participant getParticipant(Integer id) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);

        if(optionalParticipant.isPresent()) {
            return optionalParticipant.get();
        } else {
            throw new IllegalStateException(String.format("Participant with id %s does not exist", id));
        }
    }

    public void addParticipant(Participant participant) {
        participantRepository.save(participant);
    }

    public void deleteParticipant(Integer id) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);

        if(optionalParticipant.isEmpty()) {
            throw new IllegalStateException(String.format("Participant with id %s does not exist.", id));
        }
        participantRepository.delete(optionalParticipant.get());
    }

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
