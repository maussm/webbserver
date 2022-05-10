package se.mau.webbserver.entity.tk.alias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AliasService {
    private final AliasRepository aliasRepository;

    @Autowired
    public AliasService(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    public List<Alias> getAlias() {
        return aliasRepository.findAll();
    }

    public Alias getAlias(Integer id) {
        Optional<Alias> optionalAlias = aliasRepository.findByInternalId(id);

        if(optionalAlias.isPresent()) {
            return optionalAlias.get();
        } else {
            throw new IllegalStateException(String.format("Alias with id %s does not exist.", id));
        }
    }

    public void addAlias(Alias alias) {
        Optional<Alias> optionalAlias = aliasRepository.findById(alias.getId());

        if(optionalAlias.isPresent()) {
            throw new IllegalStateException(String.format("Alias with id %s already exists.", alias.getInternalId()));
        }
        aliasRepository.save(alias);
    }

    public void deleteAlias(Integer id) {
        Optional<Alias> optionalAlias = aliasRepository.findByInternalId(id);

        if(optionalAlias.isEmpty()) {
            throw new IllegalStateException(String.format("Alias with id %s does not exist.", id));
        }
        aliasRepository.delete(optionalAlias.get());
    }

    public void patchAlias(Integer id, Alias alias) {
        Optional<Alias> optionalAlias = aliasRepository.findByInternalId(id);

        if(optionalAlias.isEmpty()) {
            throw new IllegalStateException(String.format("Alias with id %s does not exist.", id));
        }

        Alias _alias = optionalAlias.get();

        if(alias.getIdExt() != null) {
            _alias.setIdExt(alias.getIdExt());
        }
        aliasRepository.save(_alias);
    }
}
