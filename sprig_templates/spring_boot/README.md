**Стартовый шаблон Spring Boot для WEB проекта** <br><br>
Spring Boot + Dependencies: Spring Web, Thymeleaf<br>
В properties прописан `server.servlet.context-path=/spring-MVC`<br>

ru.bichevoy.persist - демонстрационный слой данных


* @PostConstruct - сработает перед отдачей бина в работу, поэтому действия по какой-либо инициализации лучше выполнять в методе, чтобы уберечься от null.
* @Controller - особый вид бина для DispatcherServlet.
* @RequestMapping("/path") - часть URL на который будет отзываться контроллер.
* @GetMapping - помечается метод, который будет обрабатывать GET запросы.
* model.addAttribute("**users**", listUsers) - наполнение модели

URL-запрос для обращения к методу контроллера формируется следующим образом:<br/>
`http://localhost:8080/app/home/start`<br/>
`[http://localhost]:[8080]/[app]/[home]/[start]`<br/>
`[хост]:[порт]/[название проекта]/[путь из @RequestMapping класса]/[ путь из @RequestMapping метода]`<br/>

**Работа с thymeleaf**

* Для того чтобы "оживить" html, необходимо тег html привести к виду `<html lang="en" xmlns:th="http://www.thymeleaf.org">`
* Для доступа к model используется ${...}
* Что бы оживить тег к нему прибавляется th: т.е th:href="@{...}" или th:text="${user.id}"
* Если атрибут модели - список, то перебрать его можно tr:each="user : ${**users**}".
  Через user можно получить значения полей класса: user.id, user.username... при наличии соответствующих геттеров

**Для подключения SpringData:**  <br>
1. добавляем зависимость spring-boot-starter-data-jpa, 
2. конфигурируем свойства подключения в application.properties
3. создаем класс сущность
4. создаем интерфейс репозитория и наследуем его от JpaRepository<ClassName, typeID> //JpaRepository<User, Long>






