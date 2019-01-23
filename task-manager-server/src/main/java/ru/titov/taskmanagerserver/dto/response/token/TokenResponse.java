package ru.titov.taskmanagerserver.dto.response.token;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.dto.response.Response;

@NoArgsConstructor
public class TokenResponse extends Response {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
