package se.mau.webbserver.entity.tk.alias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mau.webbserver.entity.cost_center.CostCenter;

import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen tk_alias.
 */
@Service
public class AliasService {
    private final AliasRepository aliasRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param aliasRepository Kopplingen mot tabellen tk_alias.
     */
    @Autowired
    public AliasService(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av Alias med alla rader som finns.
     */
    public List<Alias> getAlias() {
        return aliasRepository.findAll();
    }

    /**
     * Hämtar alla Alias med ett visst id.
     * @param id Id som ska sökas på i databasen.
     * @return En lista av Alias med alla rader som har angivna id.
     */
    public Alias getAlias(Integer id) {
        Optional<Alias> optionalAlias = aliasRepository.findByInternalId(id);

        if(optionalAlias.isPresent()) {
            return optionalAlias.get();
        } else {
            throw new IllegalStateException(String.format("Alias with id %s does not exist.", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param alias Datan som ska läggas till.
     */
    public void addAlias(Alias alias) {
        Optional<Alias> optionalAlias = aliasRepository.findById(alias.getId());

        if(optionalAlias.isPresent()) {
            throw new IllegalStateException(String.format("Alias with id %s already exists.", alias.getInternalId()));
        }
        aliasRepository.save(alias);
    }

    /**
     * Tar bort data med ett specifikt id från databasen.
     * @param id Id på den data som ska tas bort.
     */
    public void deleteAlias(Integer id) {
        Optional<Alias> optionalAlias = aliasRepository.findByInternalId(id);

        if(optionalAlias.isEmpty()) {
            throw new IllegalStateException(String.format("Alias with id %s does not exist.", id));
        }
        aliasRepository.delete(optionalAlias.get());
    }

    /**
     * Hämtar alla alias för ett visst kostnadsställe.
     * @param costCenterId Id på kostnadsstället.
     * @return Alla alias som finns, om inga finns kastas ett felmeddelande.
     */
    public List<Alias> getAliasesPerCostCenter(Integer costCenterId) {
        CostCenter cc = new CostCenter();
        cc.setId(costCenterId);
        Optional<List<Alias>> optionalAliases = aliasRepository.findByCostCenter(cc);
        if(optionalAliases.isPresent()) {
            return optionalAliases.get();
        } else {
            throw new IllegalStateException(String.format("Aliases for Cost Center %s does not exist.", costCenterId));
        }
    }

    /**
     * Uppdaterar data i databasen.
     * @param id Id på den data som ska uppdateras.
     * @param alias Uppdaterade datan som ska sparas i databasen.
     */
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
