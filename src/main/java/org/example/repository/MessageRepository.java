package org.example.repository;

import org.example.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    public Message findMessageById(Integer id);
    public Message deleteMessageById(Integer id);
    // public Message updateMessageById(Integer id, Message message);
}
