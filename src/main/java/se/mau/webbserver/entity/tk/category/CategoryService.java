package se.mau.webbserver.entity.tk.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen category.
 */
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param categoryRepository Kopplingen mot tabellen category.
     */
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av Category med alla rader som finns.
     */
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    /**
     * Hämtar alla Category med ett visst id.
     * @param id Id som ska sökas på i databasen.
     * @return En lista av Category med alla rader som har angivna id.
     */
    public Category getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new IllegalStateException(String.format("Category with id %s does not exist.", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param category Datan som ska läggas till.
     */
    public void addCategory(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if(optionalCategory.isPresent()) {
            throw new IllegalStateException(String.format("Category with id %s already exists.", category.getId()));
        }

        categoryRepository.save(category);
    }

    /**
     * Tar bort data med ett specifikt id från databasen.
     * @param id Id på den data som ska tas bort.
     */
    public void deleteCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isEmpty()) {
            throw new IllegalStateException(String.format("Category with id %s does not exist.", id));
        }

        categoryRepository.delete(optionalCategory.get());
    }

    /**
     * Uppdaterar data i databasen.
     * @param id Id på den data som ska uppdateras.
     * @param category Uppdaterade datan som ska sparas i databasen.
     */
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
