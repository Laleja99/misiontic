package com.minticlau.reto3.Service;

import com.minticlau.reto3.Model.Category;
import com.minticlau.reto3.Model.Skate;
import com.minticlau.reto3.Repository.SkateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SkateService {

    @Autowired

    private SkateRepository skateRepository;

    public List<Skate> getSkateAll() {
        return skateRepository.getSkateAll();
    }

    public Optional<Skate> getSkateId(Integer id) {
        return skateRepository.getSkateId(id);
    }

    public Skate saveSkate(Skate skate) {
        if (skate.getId() == null) {
            return skateRepository.saveSkate(skate);
        } else {
            Optional<Skate> skateAuxiliar = skateRepository.getSkateId(skate.getId());
            if (skateAuxiliar.isEmpty()) {
                return skateRepository.saveSkate(skate);
            } else {
                return skate;
            }
        }
    }

    public Skate updateSkate(Skate skate) {
        if (skate.getId() != null) {
            Optional<Skate> skateAuxiliar = skateRepository.getSkateId(skate.getId());
            if (skate.getName()!= null) {
                skateAuxiliar.get().setName(skate.getName());
            }
            if (skate.getBrand()!= null) {
                skateAuxiliar.get().setBrand(skate.getBrand());
            }
            if (skate.getYear()!= null) {
                skateAuxiliar.get().setYear(skate.getYear());
            }
            if (skate.getDescription()!= null) {
                skateAuxiliar.get().setDescription(skate.getDescription());
            }
            return skateRepository.saveSkate(skateAuxiliar.get());
        }
        return skate;
    }
        
    public boolean deleteSkate(Integer skateId) {
        boolean flag = false;
        Optional<Skate> skateAuxiliar = skateRepository.getSkateId(skateId);
        if (skateAuxiliar.isPresent()) {
            skateRepository.deleteSkate(skateAuxiliar.get());
        }
        return flag;

    }

}
