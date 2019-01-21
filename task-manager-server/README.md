# Менеджер задач сервер

## Используемые технологии
* Java (1.8.0_192)
* Maven (3.6.0)

## Структура прокета
    * [api]
        * [controller]
        * [repository]
        * [service]
    * [config]
    * [controller]
    * [dto]
        * [domain]
        * [response]
        * [secure]
    * [endpoint]
        * [project]
        * [task]
        * [user]
    * [entity]
    * [error]
        * [project]
        * [task]
        * [user]
    * [service]
    * [util]

## Сборка проекта
    mvn clean install

## Запуск
    java -jar ./task-manager-server.jar