package ru.titov.taskmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    private String id = UUID.randomUUID().toString();

    private String login;

    private String passwordHash;

    @Override
    public String toString() {
        return login + " (" + id + ")";
    }
}
