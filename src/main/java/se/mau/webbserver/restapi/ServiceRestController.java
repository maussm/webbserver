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

@RestController
@RequestMapping("/api/service")
public class ServiceRestController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceRestController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getServices() {
        return serviceService.getService();
    }

    @GetMapping("/{name}")
    public Service getService(String name) {
        return serviceService.getService(name);
    }

    @PostMapping
    public void addService(@RequestBody Service service) {
        serviceService.addService(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable String name) {
        serviceService.deleteService(name);
    }

    @PatchMapping
    public void patchService(@PathVariable String name, @RequestBody Service service) {
        serviceService.serviceService(service);
    }

}
