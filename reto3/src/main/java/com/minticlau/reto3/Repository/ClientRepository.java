package com.minticlau.reto3.Repository;

import com.minticlau.reto3.Model.Client;
import com.minticlau.reto3.Repository.Crud.ClientCrudRepositoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepositoryInterface clientCrudRepositoryInterface;

    public List<Client> getClientAll() {
        return (List<Client>) clientCrudRepositoryInterface.findAll();
    }

    public Optional<Client> getClientId(Integer id){
        return clientCrudRepositoryInterface.findById(id);
    }

    public Client saveClient(Client client){
        return clientCrudRepositoryInterface.save(client);
    }
    
     public void deleteClient(Client client) {
        clientCrudRepositoryInterface.delete(client);

    }
    
}
