package ru.titov.taskmanagerserver.dto.response.user;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.dto.response.Response;

import java.util.List;

@NoArgsConstructor
public class UserListResponse extends Response {

    private List<SimpleUser> users;

    public List<SimpleUser> getUsers() {
        return users;
    }

    public void setUsers(List<SimpleUser> users) {
        this.users = users;
    }

}
