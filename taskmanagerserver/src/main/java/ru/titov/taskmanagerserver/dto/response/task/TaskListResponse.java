package ru.titov.taskmanagerserver.dto.response.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.response.Response;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaskListResponse extends Response {

    private List<SimpleTask> tasks;

}
