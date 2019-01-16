package ru.titov.taskmanagerclient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.titov.taskmanagerclient.group.SoapGroup;
import ru.titov.taskmanagerserver.endpoint.user.TokenResponse;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpointService;

public class UserEndpointTest {

    @Test
    @Category(SoapGroup.class)
    public void shouldSignInWithNewPasswordWhenUserChangesPassword() {
        final String login = "test";
        final String password = "test";
        final String newPassword = "12345";
        final UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
        userEndpoint.signUp(login, password);
        final TokenResponse tokenResponse = userEndpoint.signIn(login, password);
        final String token = tokenResponse.getToken();
        userEndpoint.changePassword(token, newPassword);
        final TokenResponse tokenResponse1 = userEndpoint.signIn(login, newPassword);
        Assert.assertTrue(tokenResponse1.isSuccess());
    }

}