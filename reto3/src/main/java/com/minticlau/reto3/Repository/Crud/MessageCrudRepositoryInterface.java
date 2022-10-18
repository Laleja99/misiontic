
package com.minticlau.reto3.Repository.Crud;


import com.minticlau.reto3.Model.Message;
import org.springframework.data.repository.CrudRepository;



public interface MessageCrudRepositoryInterface extends CrudRepository <Message, Integer> {
    
}
