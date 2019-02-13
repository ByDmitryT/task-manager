package ru.titov.taskmanagerserver.dto.secure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenData {

    private String userId;

    private String login;

    private long created;

}
