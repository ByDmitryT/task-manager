package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task extends AbstractEntity implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    private String name;

    private String description;

    @Override
    public String toString() {
        return "Task{" +
                "user=" + user +
                ", project=" + project +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
