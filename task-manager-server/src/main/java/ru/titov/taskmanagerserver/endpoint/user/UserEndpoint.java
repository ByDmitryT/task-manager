package ru.titov.taskmanagerserver.endpoint.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.dto.response.Response;
import ru.titov.taskmanagerserver.dto.response.token.TokenResponse;
import ru.titov.taskmanagerserver.dto.response.user.SimpleUser;
import ru.titov.taskmanagerserver.dto.response.user.UserListResponse;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;
import ru.titov.taskmanagerserver.util.TokenUtil;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class UserEndpoint {

    @Inject
    private ServiceLocator serviceLocator;

    @WebMethod
    @NotNull
    public TokenResponse signIn(
            @WebParam(name = "login", partName = "login")
            @Nullable final String login,

            @WebParam(name = "password", partName = "password")
            @Nullable final String password
    ) {
        final TokenResponse tokenResponse = new TokenResponse();
        try {
            final String token = serviceLocator.getUserService().signIn(login, PasswordHashUtil.md5(password));
            tokenResponse.setToken(token);
        } catch (Exception e) {
            tokenResponse.setSuccess(false);
            tokenResponse.setMessage(e.getMessage());
        }
        return tokenResponse;
    }

    @WebMethod
    @NotNull
    public Response signUp(
            @Nullable @WebParam(name = "login", partName = "login") final String login,
            @Nullable @WebParam(name = "password", partName = "password") final String password
    ) {
        final Response response = new Response();
        try {
            serviceLocator.getUserService().signUp(login, PasswordHashUtil.md5(password));
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    @NotNull
    public Response changePassword(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "newPassword", partName = "newPassword") final String newPassword
    ) {
        final Response resultResponse = new Response();
        try {
            serviceLocator.getUserService().changePassword(token, PasswordHashUtil.md5(newPassword));
        } catch (Exception e) {
            resultResponse.setSuccess(false);
            resultResponse.setMessage(e.getMessage());
        }
        return resultResponse;
    }

    @WebMethod
    @NotNull
    public UserListResponse viewAll(
            @Nullable @WebParam(name = "token", partName = "token") final String token
    ) {
        final UserListResponse userListResponse = new UserListResponse();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            serviceLocator.getUserService().getById(tokenData.getUserId());
            final List<SimpleUser> users = new ArrayList<>();
            for (final User user : serviceLocator.getUserService().getAll()) {
                if (user == null) continue;
                users.add(new SimpleUser(user));
            }
            userListResponse.setUsers(users);
        } catch (Exception e) {
            userListResponse.setSuccess(false);
            userListResponse.setMessage(e.getMessage());
        }
        return userListResponse;
    }
}
