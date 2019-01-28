package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends AbstractEntity implements Serializable {

    private String login;

    private String passwordHash;

    @OneToMany(mappedBy = "user")
    private List<Project> projects;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @Override
    public String toString() {
        return login + " (" + id + ")";
    }
}
