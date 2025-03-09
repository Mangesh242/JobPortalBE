package org.da1.labormanagementbackend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends BaseModel {
    private int senderId;
    private int receiverId;
    private String content;

}

//Port : localhost:5000/index.html

//localhost:8080/hello
