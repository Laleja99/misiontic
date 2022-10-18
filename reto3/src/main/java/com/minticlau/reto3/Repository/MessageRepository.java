package com.minticlau.reto3.Repository;

import com.minticlau.reto3.Model.Message;
import com.minticlau.reto3.Model.Skate;
import com.minticlau.reto3.Repository.Crud.MessageCrudRepositoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class MessageRepository {

    @Autowired
    private MessageCrudRepositoryInterface messageCrudRepositoryInterface;

    public List<Message> getMessageAll() {
        return (List<Message>) messageCrudRepositoryInterface.findAll();
    }

    public Optional<Message> getMessageId(Integer id) {
        return messageCrudRepositoryInterface.findById(id);
    }

    public Message saveMessage(Message message) {
        return messageCrudRepositoryInterface.save(message);
    }

    public void deleteMessage(Message message) {
        messageCrudRepositoryInterface.delete(message);

    }
}
