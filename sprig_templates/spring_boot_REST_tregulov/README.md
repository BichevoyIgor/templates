**SpringBoot REST + SpringData(JPA) + postgresql data source**<br>

1. New Project - Spring Boot + Spring Web, PostgreSQL Driver, Spring Data JPA
2. Создал: сущность, dao repository (dao - отвечает за взаимодействие с БД)
3. Прописал в pom 
```
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```
4. application.properties - параметры подключения к БД, параметры приложения...
5. под капотом Spring, уже реализован REST контроллер.
```
GET: http://localhost:8080/employees
GET: http://localhost:8080/employees/1
POST: http://localhost:8080/employees
    {
        "name": "Vasilii",
        "surname": "Pupkin",
        "department": "IT",
        "salary": 120
    }
PUT: http://localhost:8080/employees/14 - для изменения необходимо в URL прописывать id
    {
        "name": "Vasilii",
        "surname": "Pupkin",
        "department": "IT",
        "salary": 120000
    }
DELETE: http://localhost:8080/employees/14

```