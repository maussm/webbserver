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

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    private final CategoryService service;

    @Autowired
    public CategoryRestController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getCategories() {
        return service.getCategory();
    }

    @GetMapping("/{name}")
    public Category getCategory(String name) {
        return service.getCategory(name);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        service.addCategory(category);
    }

    @DeleteMapping
    public void deleteCategory(@PathVariable String name) {
        service.deleteCategory(name);
    }

}
