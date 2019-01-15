package ru.titov.taskmanagerserver.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    protected boolean success = true;

    protected String message = "[OK]";

}
