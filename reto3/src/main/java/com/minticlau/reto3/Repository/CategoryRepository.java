package com.minticlau.reto3.Repository;

import com.minticlau.reto3.Model.Category;
import com.minticlau.reto3.Repository.Crud.CategoryCrudRepositoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class CategoryRepository {

    @Autowired

    private CategoryCrudRepositoryInterface categoryCrudRepositoryInterface;

    public List<Category> getCategoryAll() {
        return (List<Category>) categoryCrudRepositoryInterface.findAll();
    }

    public Optional<Category> getCategoryId(Integer id){
        return categoryCrudRepositoryInterface.findById(id);
    }

    public Category saveCategory(Category category){
        return categoryCrudRepositoryInterface.save(category);
    }
    
    public void deleteCategory(Category category){
        categoryCrudRepositoryInterface.delete(category);
        
    }
    
}
