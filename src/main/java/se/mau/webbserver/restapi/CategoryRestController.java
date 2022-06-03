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
import se.mau.webbserver.entity.tk.category.Category;
import se.mau.webbserver.entity.tk.category.CategoryService;

import java.util.List;

/**
 * REST API klass för tabellen category.
 */
@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    private final CategoryService categoryService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param categoryService Koppling mot tabellen category.
     */
    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * URI: /api/category
     * METOD: GET
     * Hämtar alla Category.
     * @return Alla Category som finns.
     */
    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategory();
    }

    /**
     * URI: /api/category/{id}
     * METOD: GET
     * Hämtar en Category med angivet id.
     * @param id Id på Category.
     * @return En Category med angivet id.
     */
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id) {
        return categoryService.getCategory(id);
    }

    /**
     * URI: /api/category
     * METOD: POST
     * Tar emot ett objekt i JSON format som sedan sparas i databasen.
     * @param category Det objekt som ska läggs till i databasen.
     */
    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    /**
     * URI: /api/category/{id}
     * METOD: DELETE
     * Tar bort en Category från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    /**
     * URI: /api/category/{id}
     * METOD: PATCH
     * Uppdaterar en Category i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchCategory(@PathVariable Integer id, @RequestBody Category category) {
        categoryService.patchCategory(id, category);
    }
}
