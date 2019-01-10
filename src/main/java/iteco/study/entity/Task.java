package iteco.study.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task implements Serializable {

    private String id = UUID.randomUUID().toString();

    private String projectId;

    private String name = "new task";

    private String description = "do something";

    private String userId;

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", description='" + description + '\'';
    }

}
