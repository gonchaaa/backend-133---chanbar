package com.chanbar.backend133_chanbar.controllers;

import com.chanbar.backend133_chanbar.DTOs.CategoryDTO;
import com.chanbar.backend133_chanbar.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping()
    CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){ return categoryService.createCategory(categoryDTO);};

    @GetMapping()
    List<CategoryDTO> getAllCategories(){
      return categoryService.getAllCategories();
    };

    @GetMapping("/{id}")
    CategoryDTO getCategoryById(@PathVariable(name="id") Long id){
        return categoryService.getCategoryById(id);
    };

    @PutMapping("/update/{id}")
    CategoryDTO updateCategory(@PathVariable(name="id") Long id,@RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(id,categoryDTO);
    };

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable(name="id") Long id){
        categoryService.deleteCategory(id);
    }
}
