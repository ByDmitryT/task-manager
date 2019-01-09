package iteco.study.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private String firstName = "first name";

    private String lastName = "last name";

    private String login;

    private String password;

}
