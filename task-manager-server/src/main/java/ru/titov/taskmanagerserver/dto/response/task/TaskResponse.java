package ru.titov.taskmanagerserver.dto.response.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.response.Response;

@Getter
@Setter
@NoArgsConstructor
public class TaskResponse extends Response {

    public SimpleTask task;

}
