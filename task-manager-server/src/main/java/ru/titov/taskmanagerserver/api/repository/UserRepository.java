package ru.titov.taskmanagerserver.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.entity.User;

public interface UserRepository extends Repository<User> {

    @Nullable
    User getByLogin(@NotNull String login);

    boolean containsByLogin(@NotNull String login);

}
