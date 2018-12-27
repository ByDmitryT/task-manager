package iteco.study.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Task {

    private String id = UUID.randomUUID().toString();

    private String projectId = null;

    private String name = "new task";

    private String description = "do something";

    public Task() {
    }

    @Override
    public String toString() {
        return ", name='" + name + '\'' + ", description='" + description + '\'';
    }
}
