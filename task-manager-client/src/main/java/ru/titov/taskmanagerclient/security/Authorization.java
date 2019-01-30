package ru.titov.taskmanagerclient.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;

@Getter
@Setter
@NoArgsConstructor
@ApplicationScoped
public class Authorization {

    private String token;

}
