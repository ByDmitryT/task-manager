# Менеджер задач

## Используемые технологии
* Java (1.8.0_192)
* Maven (3.6.0)

## Структура прокета
* [api]
    * [controller]
        * Bootstrap
    * [repository]
        * ProjectRepository
        * TaskRepository
        * UserRepository
    * [service]
        * ProjectService
        * TaskService
        * UserService
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
    * BootstrapImpl
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
    * ProjectRepositoryImpl
    * TaskRepositoryImpl
    * UserRepositoryImpl
* [service]
    * ProjectServiceImpl
    * TaskServiceImpl
    * UserServiceImpl
* [util]
    * PasswordHashUtil
* App

## Сборка проекта
    mvn clean install
 
## Запуск сервера
    java -jar ./task-manager-server.jar

## Запуск клиента
    java -jar ./task-manager-сlient.jar

## Учетные записи по умолчанию
    [Логин]     [Пароль]
    admin       admin
    test        test
