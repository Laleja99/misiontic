package com.minticlau.reto3.Service;

import com.minticlau.reto3.Model.Client;
import com.minticlau.reto3.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //esta clase va a ser el servicio
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientAll() {
        return clientRepository.getClientAll();
    }

    public Optional<Client> getClientId(Integer id) {
        return clientRepository.getClientId(id);
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientAuxiliar = clientRepository.getClientId(client.getIdClient());
            if (!clientAuxiliar.isEmpty()) {
                if (client.getName() != null) {
                    clientAuxiliar.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    clientAuxiliar.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    clientAuxiliar.get().setPassword(client.getPassword());
                }
                clientRepository.saveClient(clientAuxiliar.get());
                return clientAuxiliar.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public Client saveClient(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.saveClient(client);
        } else {
            Optional<Client> clientAuxiliar = clientRepository.getClientId(client.getIdClient());
            if (clientAuxiliar.isEmpty()) {
                return clientRepository.saveClient(client);
            } else {
                return client;
            }
        }
    }

    public boolean deleteClient(Integer id) {
        boolean flag = false;
        Optional<Client> clientAuxiliar = clientRepository.getClientId(id);
        if (clientAuxiliar.isPresent()) {
            clientRepository.deleteClient(clientAuxiliar.get());
            flag = true;
        }
        return flag;
    }

}
