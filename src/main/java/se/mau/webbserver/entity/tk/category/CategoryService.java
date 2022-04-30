package se.mau.webbserver.entity.tk.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getCategory() {
        return repository.findAll();
    }

    public Category getCategory(String name) {
        Optional<Category> optionalCategory = repository.findById(name);

        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new IllegalStateException(String.format("Category with id %s does not exist.", name));
        }
    }

    public void addCategory(Category category) {
        Optional<Category> optionalCategory = repository.findById(category.getName());

        if(optionalCategory.isPresent()) {
            throw new IllegalStateException(String.format("Category with id %s already exists.", category.getName()));
        }

        repository.save(category);
    }

    public void deleteCategory(String name) {
        Optional<Category> optionalCategory = repository.findById(name);

        if(optionalCategory.isEmpty()) {
            throw new IllegalStateException(String.format("Category with id %s does not exist.", name));
        }

        repository.delete(optionalCategory.get());
    }
}
