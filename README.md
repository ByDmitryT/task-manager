# Менеджер задач

## Используемые технологии
* Java (1.8.0_192)
* Maven (3.6.0)

## Структура прокета
* [api]
    * [controller]
        * IBootstrap
    * [repository]
        * IProjectRepository
        * ITaskRepository
        * IUserRepository
    * [service]
        * IProjectService
        * ITaskService
        * IUserService
* [command]
    * [data]
        * DataLoadCommand
        * DataLoadFromJsonCommand
        * DataLoadFromXmlCommand
        * DataSaveCommand
        * DataSaveToJsonCommand
        * DataSaveToXmlCommand
    * [help]
        * HelpCommand
    * [project]
        * ProjectCreateCommand
        * ProjectDeleteCommand
        * ProjectUpdateCommand
        * ProjectViewAllCommand
        * ProjectViewCommand
    * [task]
        * TaskCreateCommand
        * TaskDeleteCommand
        * TaskUpdateCommand
        * TaskViewAllCommand
        * TaskViewCommand
    * [user]
        * UserLogoutCommand
        * UserSignInCommand
        * UserSignUpCommand
        * UserViewAllCommand
    * AbstractCommand
* [controller]
    * Bootstrap
* [entity]
    * Data
    * Project
    * Task
    * User
* [error]
    * [command]
        * NoSuchCommandsException
    * [project]
        * AbstractProjectException
        * InvalidProjectIdException
        * InvalidProjectInputException
        * InvalidProjectOrderIndexException
    * [task]
        * AbstractTaskException
        * InvalidTaskIdException
        * InvalidTaskInputException
        * InvalidTaskOrderIndexException
    * [user]
        * AbstractUserException
        * InvalidUserInputException
        * InvalidUserLoginException
        * InvalidUserPasswordException
        * UserLoginExistsException
* [repository]
    * ProjectRepository
    * TaskRepository
    * UserRepository
* [service]
    * ProjectService
    * TaskService
    * UserService
* [util]
    * PasswordHashUtil
* App

## Сборка проекта
    mvn clean install
 
## Запуск
    java -jar ./task-manager.jar

## Учетные записи по умолчанию
    [Логин]     [Пароль]
    admin       admin
    test        test
