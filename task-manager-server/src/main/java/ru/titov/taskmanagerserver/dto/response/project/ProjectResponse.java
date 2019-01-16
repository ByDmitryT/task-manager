package ru.titov.taskmanagerserver.dto.response.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.response.Response;

@Getter
@Setter
@NoArgsConstructor
public class ProjectResponse extends Response {

    private SimpleProject project;

}
