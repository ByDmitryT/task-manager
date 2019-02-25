# Менеджер задач

## Используемые технологии
* Java (1.8.0_192)
* Maven (3.6.0)
* Spring (5.0.8)
* Hibernate (5.4.1)
* Jsf (2.2.18)

## Структура прокета
    * [api]
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
    * [enumerated]
    * [error]
        * [project]
        * [task]
        * [user]
    * [jsf]
    * [service]
    * [util]

## Сборка проекта
    mvn clean install

## Запуск
    mvn wildfly:deploy