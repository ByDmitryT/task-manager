package ru.titov.taskmanagerserver.dto.response.user;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.entity.User;

@NoArgsConstructor
public class SimpleUser {

    private String login;

    public SimpleUser(User user) {
        if (user != null) login = user.getLogin();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
