package com.minticlau.reto3.Service;

import com.minticlau.reto3.Model.Category;
import com.minticlau.reto3.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //esta clase va a ser el servicio

public class CategoryService {

    @Autowired

    private CategoryRepository categoryRepository;

    public List<Category> getCategoryAll() {
        return categoryRepository.getCategoryAll();
    }

    public Optional<Category> getCategoryId(Integer id) {
        return categoryRepository.getCategoryId(id);
    }

    public Category saveCategory(Category category) {
        if (category.getId() == null) {
            return categoryRepository.saveCategory(category);
        } else {
            Optional<Category> categoryAuxiliar = categoryRepository.getCategoryId(category.getId());
            if (categoryAuxiliar.isEmpty()) {
                return categoryRepository.saveCategory(category);
            } else {
                return category;
            }
        }
    }

    public Category updateCategory(Category category) {
        if (category.getId() != null) {
            Optional<Category> categoryAuxiliar = categoryRepository.getCategoryId(category.getId());
            if (category.getDescription() != null) {
                categoryAuxiliar.get().setDescription(category.getDescription());
            }
            if (category.getName() != null) {
                categoryAuxiliar.get().setName(category.getName());
            }
            return categoryRepository.saveCategory(categoryAuxiliar.get());
        }
        return category;
    }

    public boolean deleteCategory(Integer categoryId) {
        boolean flag = false;
        Optional<Category> categoryAuxiliar = categoryRepository.getCategoryId(categoryId);
        if (categoryAuxiliar.isPresent()) {
            categoryRepository.deleteCategory(categoryAuxiliar.get());
        }
        return flag;

    }

}
