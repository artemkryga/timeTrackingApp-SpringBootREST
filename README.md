Final-Project-Spring

Задание:

Система Time-Tracking. Администратор закрепляет за пользователем
Активность. У пользователя может быть одна или несколько Активностей.
Пользователь отмечает кол-во затраченного времени на каждую активность.
Пользователь может отправить запрос на добавление/удаление Активности.

Как запустить?

Скачайте репозиторий
После - создайте необходимую БД, с помощью скриптов, которые находятся в "/resources/db/db.sql"
В папке /resources лежит файл application.properties помейняйте значение "spring.jpa.hibernate.ddl-auto" на "create-drop"
Далее запустите проект командой "mvn spring-boot:run"

Далее перейдите в репозиторий https://github.com/artemkryga/Vuejs-Server-for-SpringBoot-timetrackingApp.git
Данный репозиторий является front - end сервером для Spring Boot приложения. Общение происходит с помощью REST API.

Скачайте указанный репозиторий. 
Выполните запуск с помощью команды - npm run serve. Приложение подыметься на порту - 8080
