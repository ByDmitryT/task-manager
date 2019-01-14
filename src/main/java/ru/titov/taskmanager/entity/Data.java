package ru.titov.taskmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Data implements Serializable {

    private List<Project> projects;

    private List<Task> tasks;

    private List<User> users;

}
