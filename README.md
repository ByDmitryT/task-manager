# Менеджер задач

Используемые технологии 
* Java (1.8.0_192)
* Maven (3.6.0)

## Структура прокета
* [api]
* [command]
* [entity]
  * Project - проект
  * Task - задача
* [error]
* [repository]
  * ProjectRepository - класс для созднания и управления группами
  * TaskRepository - класс для создания и управления задачами
* [controller]
  * Bootstrap - класс объединяющий сервисы и команды 
* [service]
  * ProjectService - сервис проектов
  * TaskService - сервис задач
* App - основной класс 

## Сборка проекта
    mvn clean install

 
## Запуск
    java -jar ./to-do-list.jar
