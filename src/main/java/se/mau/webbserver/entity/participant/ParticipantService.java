package se.mau.webbserver.entity.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository repository;

    @Autowired
    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public List<Participant> getParticipants() {
        return repository.findAll();
    }

    public Participant getParticipant(Long id) {
        Optional<Participant> optionalParticipant = repository.findById(id);

        if(optionalParticipant.isPresent()) {
            return optionalParticipant.get();
        } else {
            throw new IllegalStateException(String.format("Participant with id %s does not exist", id));
        }
    }

    public void addParticipant(Participant participant) {
        Optional<Participant> optionalParticipant = repository.findById(participant.getId());

        if(optionalParticipant.isPresent()) {
            throw new IllegalStateException(String.format("Participant with id %s already exist", participant.getId()));
        }

        repository.save(participant);
    }

    public void deleteParticipant(Long id) {
        Optional<Participant> optionalParticipant = repository.findById(id);

        if(optionalParticipant.isEmpty()) {
            throw new IllegalStateException(String.format("Participant with id %s does not exist.", id));
        }

        repository.delete(optionalParticipant.get());
    }

    public void patchParticipant(Long id, Participant participant) {
        Optional<Participant> optionalParticipant = repository.findById(id);

        if(optionalParticipant.isEmpty()) {
            throw new IllegalStateException(String.format("Participant with id %s does not exist.", id));
        }

        Participant _participant = optionalParticipant.get();
        if(!(_participant.equals(participant))) {
            if(participant.getName() != null) {
                _participant.setName(participant.getName());
            }

            repository.save(_participant);
        }
    }
}
