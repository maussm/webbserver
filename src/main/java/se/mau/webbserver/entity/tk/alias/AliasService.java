package se.mau.webbserver.entity.tk.alias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AliasService {
    private final AliasRepository repository;

    @Autowired
    public AliasService(AliasRepository repository) {
        this.repository = repository;
    }

    public List<Alias> getAlias() {
        return repository.findAll();
    }

    public Alias getAlias(String name) {
        Optional<Alias> optionalAlias = repository.findById(name);

        if(optionalAlias.isPresent()) {
            return optionalAlias.get();
        } else {
            throw new IllegalStateException(String.format("Alias with id %s does not exist.", name));
        }
    }

    public void addAlias(Alias alias) {
        Optional<Alias> optionalAlias = repository.findById(alias.getDefinition());

        if(optionalAlias.isPresent()) {
            throw new IllegalStateException(String.format("Alias with id %s already exists.", alias.getDefinition()));
        }
        repository.save(alias);
    }

    public void deleteAlias(String name) {
        Optional<Alias> optionalAlias = repository.findById(name);

        if(optionalAlias.isEmpty()) {
            throw new IllegalStateException(String.format("Alias with id %s does not exist.", name));
        }
        repository.delete(optionalAlias.get());
    }

    public void patchAlias(String name, Alias alias) {
        Optional<Alias> optionalAlias = repository.findById(name);

        if(optionalAlias.isEmpty()) {
            throw new IllegalStateException(String.format("Alias with name %s does not exist.", name));
        }
        Alias _alias = optionalAlias.get();

        if(!(_alias.equals(alias))) {
            if(alias.getCostCenter() != null) {
                _alias.setCostCenter(alias.getCostCenter());
            }
            if(alias.getActivityName() != null) {
                _alias.setActivityName(alias.getActivityName());
            }
            repository.save(_alias);
        }
    }
}
