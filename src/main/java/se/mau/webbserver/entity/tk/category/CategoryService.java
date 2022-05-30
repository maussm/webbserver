package se.mau.webbserver.entity.tk.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new IllegalStateException(String.format("Category with id %s does not exist.", id));
        }
    }

    public void addCategory(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if(optionalCategory.isPresent()) {
            throw new IllegalStateException(String.format("Category with id %s already exists.", category.getId()));
        }

        categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isEmpty()) {
            throw new IllegalStateException(String.format("Category with id %s does not exist.", id));
        }

        categoryRepository.delete(optionalCategory.get());
    }

    public void patchCategory(Integer id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isEmpty()) {
            throw new IllegalStateException(String.format("Category with id %s does not exist.", id));
        }

        Category _category = optionalCategory.get();

        if(category.getName() != null) {
            _category.setName(category.getName());
        }
        if(category.getIdExt() != null) {
            _category.setIdExt(category.getIdExt());
        }
        categoryRepository.save(_category);
    }
}
