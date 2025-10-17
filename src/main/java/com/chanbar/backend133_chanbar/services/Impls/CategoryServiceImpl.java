package com.chanbar.backend133_chanbar.services.Impls;

import com.chanbar.backend133_chanbar.DTOs.CategoryDTO;
import com.chanbar.backend133_chanbar.exceptions.BaseException;
import com.chanbar.backend133_chanbar.exceptions.ErrorsType;
import com.chanbar.backend133_chanbar.models.Category;
import com.chanbar.backend133_chanbar.repositories.CategoryRepository;
import com.chanbar.backend133_chanbar.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        CategoryDTO newCategory = new CategoryDTO();
        Category category = new Category();

        category.setCategoryName(categoryDTO.getCategoryName());

        categoryRepository.save(category);
        log.info("Category was saved successfully : {}",category.getCategoryName());

        newCategory.setCategoryName(category.getCategoryName());

        return newCategory;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

       List<Category> categoryList = categoryRepository.findAll();

       List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (Category category : categoryList) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {

        Optional<Category> categoryById = categoryRepository.findById(id);
        try {

            if (categoryById.isPresent()) {
        //            Category category = categoryById.get();
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryName(categoryById.get().getCategoryName());
                return categoryDTO;
            }
        } catch (Exception e) {
            throw new BaseException(ErrorsType.NO_DATA_FOUND,e.getMessage());
        }
        return null;
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {

        Optional<Category> categoryById = categoryRepository.findById(id);
        if(categoryById.isPresent()){
            Category category = categoryById.get();
            category.setCategoryName(categoryDTO.getCategoryName());
            categoryRepository.save(category);
            CategoryDTO updatedCategory = new CategoryDTO();
            updatedCategory.setCategoryName(category.getCategoryName());
            return updatedCategory;
        }
        log.error("Not find by Id:{}",id);
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryById = categoryRepository.findById(id);
        try{
            if(categoryById.isPresent()){
                categoryRepository.deleteById(id);
            }
            else{
                throw new BaseException(ErrorsType.NO_DATA_FOUND,"");
            }
        } catch (Exception e) {
            throw new BaseException(ErrorsType.NO_DATA_FOUND,e.getMessage());
        }
    }
}
