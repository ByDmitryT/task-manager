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
public class Task extends AbstractEntity implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();

    private String userId;

    private String projectId;

    private String name;

    private String description;

    @Override
    public String toString() {
        return "name: " + name + " description:" + description;
    }

}
