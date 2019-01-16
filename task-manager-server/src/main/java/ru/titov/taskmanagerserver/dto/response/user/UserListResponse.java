package ru.titov.taskmanagerserver.dto.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.response.Response;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserListResponse extends Response {

    private List<SimpleUser> users;

}
