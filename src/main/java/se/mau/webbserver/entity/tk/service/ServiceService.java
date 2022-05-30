package se.mau.webbserver.entity.tk.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getService() {
        return serviceRepository.findAll();
    }

    public Service getService(Integer id) {
        Optional<Service> optionalService = serviceRepository.findByInternalId(id);

        if(optionalService.isPresent()) {
            return optionalService.get();
        } else {
            throw new IllegalStateException(String.format("Service with id %s does not exist.", id));
        }
    }

    public void addService(Service service) {
        Optional<Service> optionalService = serviceRepository.findById(service.getId());

        if(optionalService.isPresent()) {
            throw new IllegalStateException(String.format("Service with id %s already exists.", service.getInternalId()));
        }

        serviceRepository.save(service);
    }

    public void deleteService(Integer id) {
        Optional<Service> optionalService = serviceRepository.findByInternalId(id);

        if(optionalService.isEmpty()) {
            throw new IllegalStateException(String.format("Service with id %s does not exist.", id));
        }

        serviceRepository.delete(optionalService.get());
    }

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
