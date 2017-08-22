package com.sadtech.collections.greeting;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "greeting")
public class Greeting {
    @Id
    private long id;

    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting() {
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}