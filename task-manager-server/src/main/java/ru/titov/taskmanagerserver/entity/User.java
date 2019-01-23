package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends AbstractEntity implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();

    private String login;

    private String passwordHash;

    @Override
    public String toString() {
        return login + " (" + id + ")";
    }
}
