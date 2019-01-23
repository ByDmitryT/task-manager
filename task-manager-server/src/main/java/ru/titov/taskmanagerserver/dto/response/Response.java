package ru.titov.taskmanagerserver.dto.response;

import lombok.Getter;
import lombok.Setter;

public class Response {

    private boolean success = true;

    private String message = "[OK]";

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
