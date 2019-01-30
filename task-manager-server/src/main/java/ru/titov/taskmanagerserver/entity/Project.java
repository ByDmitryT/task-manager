package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Project extends AbstractEntity implements Serializable {

    @ManyToOne
    private User user;

    private String name;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    @Override
    public String toString() {
        return "name: " + name;
    }

}
