package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractEntity implements Serializable {

    private String login;

    private String passwordHash;

    @Override
    public String toString() {
        return login + " (" + id + ")";
    }
}
