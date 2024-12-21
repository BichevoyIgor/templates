**Spring REST + hibernate + postgresql data source**<br>

1. archetypes: maven-archetype-webapp
2. configuration - конфигурация Spring context на основе Java класса
3. dao - отвечает за взаимодействие с БД
4. service - отвечает за бизнес-операции над сущностью полученной из DAO
5. **@RestController** – это специальный контроллер который управляет Rest запросами и Rest ответами
6. **@ExceptionHandler** - помечается метод ответственный за обработку исключений
7. **@ControllerAdvice** - помечается класс ответственный за обработку исключений приложения (Global Exception Handler)



P.S: разобраться с @EnableTransactionManagement, что то транзакционность под управлением спринга не работает 

