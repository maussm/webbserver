package se.mau.webbserver.entity.tk.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen service.
 */
@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param serviceRepository Kopplingen mot tabellen service.
     */
    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av Service med alla rader som finns.
     */
    public List<Service> getService() {
        return serviceRepository.findAll();
    }

    /**
     * Hämtar alla Service med ett visst id.
     * @param id Id som ska sökas på i databasen.
     * @return En lista av Service med alla rader som har angivna id.
     */
    public Service getService(Integer id) {
        Optional<Service> optionalService = serviceRepository.findByInternalId(id);

        if(optionalService.isPresent()) {
            return optionalService.get();
        } else {
            throw new IllegalStateException(String.format("Service with id %s does not exist.", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param service Datan som ska läggas till.
     */
    public void addService(Service service) {
        Optional<Service> optionalService = serviceRepository.findById(service.getId());

        if(optionalService.isPresent()) {
            throw new IllegalStateException(String.format("Service with id %s already exists.", service.getInternalId()));
        }

        serviceRepository.save(service);
    }

    /**
     * Tar bort data med ett specifikt id från databasen.
     * @param id Id på den data som ska tas bort.
     */
    public void deleteService(Integer id) {
        Optional<Service> optionalService = serviceRepository.findByInternalId(id);

        if(optionalService.isEmpty()) {
            throw new IllegalStateException(String.format("Service with id %s does not exist.", id));
        }

        serviceRepository.delete(optionalService.get());
    }

    /**
     * Uppdaterar data i databasen.
     * @param id Id på den data som ska uppdateras.
     * @param service Uppdaterade datan som ska sparas i databasen.
     */
    public void patchService(Integer id, Service service) {
        Optional<Service> optionalService = serviceRepository.findByInternalId(id);

        if(optionalService.isEmpty()) {
            throw new IllegalStateException(String.format("Service with id %s does not exist.", id));
        }

        Service _service = optionalService.get();

        if(service.getIdExt() != null) {
            _service.setIdExt(service.getIdExt());
        }
        serviceRepository.save(_service);
    }
}
