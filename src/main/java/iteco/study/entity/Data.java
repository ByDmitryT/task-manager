package iteco.study.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Data {

    private List<Project> projects;

    private List<Task> tasks;

}
