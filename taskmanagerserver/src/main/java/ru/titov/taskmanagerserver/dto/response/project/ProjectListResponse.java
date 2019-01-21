package ru.titov.taskmanagerserver.dto.response.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.response.Response;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProjectListResponse extends Response {

    private List<SimpleProject> projects;

}
