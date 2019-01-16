package ru.titov.taskmanagerserver.dto.response.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.response.Response;

@Getter
@Setter
@NoArgsConstructor
public class TokenResponse extends Response {

    private String token;

}
