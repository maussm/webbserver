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
import se.mau.webbserver.entity.tk.alias.Alias;
import se.mau.webbserver.entity.tk.alias.AliasService;

import java.util.List;

/**
 * REST API klass för tabellen alias.
 */
@RestController
@RequestMapping("/api/alias")
public class AliasRestController {

    private final AliasService service;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param service Koppling mot tabellen alias.
     */
    @Autowired
    public AliasRestController(AliasService service) {
        this.service = service;
    }

    /**
     * URI: /api/alias
     * METOD: GET
     * Hämtar alla Alias.
     * @return Alla Alias som finns.
     */
    @GetMapping
    public List<Alias> getAlias() {
        return service.getAlias();
    }

    /**
     * URI: /api/alias/{id}
     * METOD: GET
     * Hämtar en Alias med angivet id.
     * @param id Id på alias.
     * @return En Alias med angivet id.
     */
    @GetMapping("/{id}")
    public Alias getAlias(@PathVariable Integer id) {
        return service.getAlias(id);
    }

    /**
     * URI: /api/alias
     * METOD: POST
     * Tar emot ett objekt i JSON format som sedan sparas i databasen.
     * @param alias Det objekt som ska läggs till i databasen.
     */
    @PostMapping
    public void addAlias(@RequestBody Alias alias) {
        service.addAlias(alias);
    }

    /**
     * URI: /api/alias/{id}
     * METOD: DELETE
     * Tar bort ett Alias från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteAlias(@PathVariable Integer id) {
        service.deleteAlias(id);
    }

    /**
     * URI: /api/alias/{id}
     * METOD: PATCH
     * Uppdaterar ett Alias i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchAlias(@PathVariable Integer id, @RequestBody Alias alias) {
        service.patchAlias(id, alias);
    }
}
