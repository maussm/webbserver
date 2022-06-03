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
import se.mau.webbserver.entity.tk.service.Service;
import se.mau.webbserver.entity.tk.service.ServiceService;

import java.util.List;

/**
 * REST API klass för tabellen service.
 */
@RestController
@RequestMapping("/api/service")
public class ServiceRestController {

    private final ServiceService serviceService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param serviceService Koppling mot tabellen service.
     */
    @Autowired
    public ServiceRestController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    /**
     * URI: /api/service
     * METOD: GET
     * Hämtar alla Service.
     * @return Alla Service som finns.
     */
    @GetMapping
    public List<Service> getServices() {
        return serviceService.getService();
    }

    /**
     * URI: /api/service/{id}
     * METOD: GET
     * Hämtar en Service med angivet id.
     * @param id Id på den som ska hämtas.
     * @return En Service med angivet id.
     */
    @GetMapping("/{id}")
    public Service getService(@PathVariable Integer id) {
        return serviceService.getService(id);
    }

    /**
     * URI: /api/service
     * METOD: POST
     * Tar emot ett objekt i JSON format som sedan sparas i databasen.
     * @param service Det objekt som ska läggs till i databasen.
     */
    @PostMapping
    public void addService(@RequestBody Service service) {
        serviceService.addService(service);
    }

    /**
     * URI: /api/service/{id}
     * METOD: DELETE
     * Tar bort en Service från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);
    }

    /**
     * URI: /api/service/{id}
     * METOD: PATCH
     * Uppdaterar en Service i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchService(@PathVariable Integer id, @RequestBody Service service) {
        serviceService.patchService(id, service);
    }

}
