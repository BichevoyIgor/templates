**Spring Security**

* Реализация на основе объяснения Трегулова на курсе Spring для начинающих
* Ограничение прав доступа на определенные URL описывается в SecurityConfig.configure(HttpSecurity http)
* Ограничения видимости элементов на странице, прописываются в коде представления
* если создать таблицу нижеуказанной структуры, то не нужно писать обработчика авторизации, достаточно прописать auth.jdbcAuthentication().dataSource(dataSource); в SecurityConfig.configure...<br>
Пароль в таблице содержится в виде: {алгоритм шифрования}пароль<br>
{noop} - никакого шифрования<br>
{bcrypt} - шифрование с помощью хэш функции bcrypt. Пароль в БД хранится в зашифрованном виде.
```
--Postgresql
-- Create the users table
CREATE TABLE users (
username VARCHAR(15) PRIMARY KEY,
password VARCHAR(100),
enabled BOOLEAN
);

-- Create the authorities table
CREATE TABLE authorities (
username VARCHAR(15),
authority VARCHAR(25),
FOREIGN KEY (username) REFERENCES users(username)
);

-- Insert data into the users table
INSERT INTO users (username, password, enabled)
VALUES
('zaur', '{noop}zaur', TRUE),
('elena', '{noop}elena', TRUE),
('ivan', '{bcrypt}$2y$10$.BJN9OO1S82U0ff/Ki7tX.iqXDI8OK5n0IOg68jQYX1C7JcH8E/L6', TRUE);

-- Insert data into the authorities table
INSERT INTO authorities (username, authority)
VALUES
('zaur', 'ROLE_EMPLOYEE'),
('elena', 'ROLE_HR'),
('ivan', 'ROLE_HR'),
('ivan', 'ROLE_MANAGER');
```