package se.mau.webbserver.entity.tk.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository repository;

    @Autowired
    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<Service> getService() {
        return repository.findAll();
    }

    public Service getService(String name) {
        Optional<Service> optionalService = repository.findById(name);

        if(optionalService.isPresent()) {
            return optionalService.get();
        } else {
            throw new IllegalStateException(String.format("Service with id %s does not exist.", name));
        }
    }

    public void addService(Service service) {
        Optional<Service> optionalService = repository.findById(service.getName());

        if(optionalService.isPresent()) {
            throw new IllegalStateException(String.format("Service with id %s already exists.", service.getName()));
        }

        repository.save(service);
    }

    public void deleteService(String name) {
        Optional<Service> optionalService = repository.findById(name);

        if(optionalService.isEmpty()) {
            throw new IllegalStateException(String.format("Service with id %s does not exist.", name));
        }

        repository.delete(optionalService.get());
    }
}
