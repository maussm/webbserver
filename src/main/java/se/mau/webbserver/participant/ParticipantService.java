package se.mau.webbserver.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository repository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.repository = participantRepository;
    }
    public List<Participant> getParticipants() {return repository.findAll();}
}
