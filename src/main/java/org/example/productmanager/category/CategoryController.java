package org.example.productmanager.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("repository")
    public List<CategoryData> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping()
    public CategoryData createCategory(@RequestBody CategoryData category) {
        return categoryRepository.save(category);
    }
}
