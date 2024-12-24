**SpringBoot REST + SpringData(JPA) + postgresql data source**<br>

1. SpringBoot + Spring Web, PostgreSQL Driver, Spring Data JPA
2. Создал: сущность, dao, service, rest контроллер с соответсвующими мапингами
3. dao - отвечает за взаимодействие с БД
4. service - отвечает за бизнес логику над сущностью полученной из DAO
5. @RestController – это специальный контроллер который управляет Rest запросами и Rest ответами
6. application.properties - параметры подключения к БД, параметры приложения...
```
GET: http://localhost:8080/api/employees
GET: http://localhost:8080/api/employees/15
DELETE: http://localhost:8080/api/employees/22
PUT/POST: http://localhost:8080/api/employees
{
    "id": 15,
    "name": "Ivan",
    "surname": "Sidorov",
    "department": "Sales",
    "salary": 120000
}
```
P.S.: пример из урока Трегулова, spring для начинающих