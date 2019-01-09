package iteco.study.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private String id = UUID.randomUUID().toString();

    private String firstName = "first name";

    private String lastName = "last name";

    private String login;

    private int password;

}
