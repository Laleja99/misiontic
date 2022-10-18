package com.minticlau.reto3.Repository;

import com.minticlau.reto3.Model.Skate;
import com.minticlau.reto3.Repository.Crud.SkateCrudRepositoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class SkateRepository  {
   
    @Autowired

    private SkateCrudRepositoryInterface skateCrudRepositoryInterface;

    public List<Skate> getSkateAll() {
        return (List<Skate>) skateCrudRepositoryInterface.findAll();
    }

    public Optional<Skate> getSkateId(Integer id){
        return skateCrudRepositoryInterface.findById(id);
    }

    public Skate saveSkate(Skate skate){
        return skateCrudRepositoryInterface.save(skate);
    }
 
    public void deleteSkate(Skate skate){
        skateCrudRepositoryInterface.delete(skate);
            
}
    
}
