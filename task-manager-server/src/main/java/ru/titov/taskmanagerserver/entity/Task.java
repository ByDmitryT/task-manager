package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Task extends AbstractEntity implements Serializable {

    private String projectId;

    private String name = "new task";

    private String description = "do something";

    private String userId;

    @Override
    public String toString() {
        return "name: " + name + " description:" + description;
    }

}
