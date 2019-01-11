package ru.titov.taskmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Project implements Serializable {

    private String id = UUID.randomUUID().toString();

    private String name = "new project";

    private String userId;

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }

}
