package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "message")
@Entity(name = "message")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "str")
    private String text;
    @Column(name = "author")
    private String author;
    public Message(Integer id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }
}
