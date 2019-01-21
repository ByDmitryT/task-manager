package ru.titov.taskmanagerserver.dto.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.entity.User;

@Getter
@Setter
@NoArgsConstructor
public class SimpleUser {

    private String login;

    public SimpleUser(User user) {
        if (user != null) login = user.getLogin();
    }

}
