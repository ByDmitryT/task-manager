package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Project extends AbstractEntity implements Serializable {

    private String userId;

    private String name = "new project";

    @Override
    public String toString() {
        return "name: " + name;
    }

}
