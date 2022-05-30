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

@RestController
@RequestMapping("/api/participant")
public class ParticipantRestController {
    private final ParticipantService restService;

    @Autowired
    public ParticipantRestController(ParticipantService restService) {
        this.restService = restService;
    }

    @GetMapping
    public List<Participant> getParticipants() {
        return restService.getParticipants();
    }

    @GetMapping("/{id}")
    public Participant getParticipant(@PathVariable Integer id) {
        return restService.getParticipant(id);
    }

    @PostMapping
    public void addParticipant(@RequestBody Participant participant) {
        restService.addParticipant(participant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Integer id) {
        restService.deleteParticipant(id);
    }

    @PatchMapping("/{id}")
    public void patchParticipant(@PathVariable Integer id, @RequestBody Participant participant) {
        restService.patchParticipant(id, participant);
    }
 }
