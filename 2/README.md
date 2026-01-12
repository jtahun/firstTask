# CRUD Console Application

Простое консольное CRUD приложение для управления сущностями Writer, Post и Label с использованием JSON файлов в качестве хранилища данных.

## Функциональность

- Создание, чтение, обновление и удаление (мягкое удаление) сущностей
- Каждая сущность имеет статус (ACTIVE/DELETED)
- Данные хранятся в JSON файлах
- Консольный интерфейс для взаимодействия с пользователем

## Сущности

### Writer
- id: Long
- firstName: String
- lastName: String
- posts: List<Post>
- status: Status

### Post
- id: Long
- title: String
- content: String
- labels: List<Label>
- status: Status

### Label
- id: Long
- name: String
- status: Status

### Status (enum)
- ACTIVE
- DELETED

## Архитектура

Приложение построено по многослойной архитектуре:

1. **Model** - POJO классы сущностей
2. **Repository** - доступ к данным в JSON файлах
3. **Controller** - бизнес-логика приложения
4. **View** - консольный интерфейс

## Технологии

- Java 11
- Gson 2.8.9 (для работы с JSON)
- Maven

## Запуск приложения

1. Клонируйте репозиторий
2. Соберите проект: `mvn clean compile`
3. Запустите: `mvn exec:java -Dexec.mainClass="com.example.Main"`

## Использование

При запуске откроется консольное меню с возможностью выбора действий для работы с каждой сущностью.