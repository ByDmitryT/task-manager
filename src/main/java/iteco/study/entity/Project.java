package iteco.study.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Project {

    private String id = UUID.randomUUID().toString();

    private String name = "new project";

    public Project() {
    }
}
