/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minticlau.reto3.Repository.Crud;

import com.minticlau.reto3.Model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author familia
 */
public interface CategoryCrudRepositoryInterface extends CrudRepository <Category, Integer> {
    
}
