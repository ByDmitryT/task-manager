package ru.titov.taskmanagerserver.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.SimpleUser;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserListResponse extends Response {

    private List<SimpleUser> users;

}
