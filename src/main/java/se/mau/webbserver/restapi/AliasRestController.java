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

@RestController
@RequestMapping("/api/alias")
public class AliasRestController {

    private final AliasService service;

    @Autowired
    public AliasRestController(AliasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alias> getAlias() {
        return service.getAlias();
    }

    @GetMapping("/{id}")
    public Alias getAlias(@PathVariable String name) {
        return service.getAlias(name);
    }

    @PostMapping
    public void addAlias(@RequestBody Alias alias) {
        service.addAlias(alias);
    }

    @DeleteMapping("/{id}")
    public void deleteAlias(@PathVariable String name) {
        service.deleteAlias(name);
    }

    @PatchMapping("/{id}")
    public void patchAlias(@PathVariable String name, @RequestBody Alias alias) {
        service.patchAlias(name, alias);
    }
}
