package org.example.controller;

import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class MessageController {
    //ArrayList<Message> messages = new ArrayList<>();
    @Autowired
    MessageRepository messageRepository;
    @GetMapping
    public List<Message> getAllMessages() {
        //Message message = new Message(1, "123", "auth");
        /*Message message = new Message();
        message.setId(1);
        message.setText("123");
        message.setAuthor("auth");
        messages.add(message);
        return messages;*/
        return messageRepository.findAll();
    };

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        //messages.add(message);
        messageRepository.saveAndFlush(message);
        return message;
    }

    @PutMapping("{id}")
    public Message upgradeMessage(@PathVariable Integer id, @RequestBody Message message) {
        /*int i;
        for (i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId() == id) {
                messages.get(i).setText(message.getText());
                messages.get(i).setAuthor(message.getAuthor());
                break;
            }
        }
        return messages.get(i);*/

        Message messageOld = messageRepository.findMessageById(id);
        if (messageOld != null) {
            message.setId(id);
            messageRepository.saveAndFlush(message);
        }
        return messageOld;

        /*ArrayList<Message> messages2 = messages.stream().filter(it -> {return it.getId() == id;}).collect(Collectors.toList());
        if (messages2.size() > 0) {
            message.setId(id);
            messages.set(messages.indexOf(messages2.get(0)), message);
            //return messages2.get(0);
            return true;
        }
        return false;*/
    }

    @DeleteMapping("{id}")
    public Message deleteMessage(@PathVariable Integer id) {
        /*int i;
        Message temp = null;
        for (i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId() == id) {
                temp = messages.get(i);
                messages.remove(i);
                break;
            }
        }
        return temp;*/

        //return messageRepository.deleteMessageById(id);
        Message temp = messageRepository.findMessageById(id);
        messageRepository.deleteById(id);
        return temp;

        /*ArrayList<Message> messages2 = messages.stream().filter(it -> {return it.getId() == id;}).collect(Collectors.toList());
        if (messages2.size() > 0) {
            Message msg = messages2.get(0);
            messages.remove(msg);
            return msg;
        }*/
    }
}


/*
    psql -V
    createdb -U postgres testdb
    admin
    new connection
    connection -> public
    open sql console
    create table Message(

        id int primary key,
        str text,
        author text

    );
     */