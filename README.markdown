# Система управления клиентской информацией

Веб-приложение на Java для управления клиентскими данными, включая физических лиц, компании, организационно-правовые формы и регистрации. Разработано с использованием **Spring Boot** и предоставляет безопасный и удобный интерфейс для операций CRUD.

---

## 📋 Обзор

Это веб-приложение на Java EE предназначено для эффективного управления клиентской информацией. Оно использует **Spring Security** для аутентификации, **Spring Data JPA** для работы с базой данных и **Thymeleaf** для динамических веб-страниц с оформлением на основе Bootstrap.

### Основные возможности
- **Операции CRUD**: Управление сущностями (`Person`, `Company`, `OrgLegForm`, `OrgRegistration`) через веб-интерфейс.
- **Безопасная аутентификация**: Вход с использованием Spring Security (по умолчанию: логин `user`, пароль `password`).
- **Интеграция с базой данных**: PostgreSQL с автоматическим обновлением схемы через Hibernate.
- **Адаптивный интерфейс**: Шаблоны Thymeleaf с Bootstrap для современного дизайна.
- **Тестирование**: Модульные и интеграционные тесты с использованием JUnit и Mockito.

---

## 🛠️ Технологии

| Технология              | Версия   |
|-------------------------|----------|
| Java                    | 17       |
| Spring Boot             | 3.4.6    |
| Spring Security         | 6.4.6    |
| Spring Data JPA         | 3.4.6    |
| Thymeleaf               | 3.1.3    |
| PostgreSQL              | 42.7.5   |
| Maven                   | -        |
| JUnit 5 и Mockito       | -        |

---

## 🚀 Начало работы

### Требования
- **Java 17** или выше
- **Maven 3.6+**
- **PostgreSQL 14+** с базой данных `clientdb`
- **IntelliJ IDEA** или другая IDE (опционально)

### Установка

1. **Клонируйте репозиторий**:
   ```bash
   git clone https://github.com/your-username/clientinfosystem.git
   cd clientinfosystem
   ```

2. **Настройте PostgreSQL**:
   - Создайте базу данных:
     ```bash
     psql -U postgres -c "CREATE DATABASE clientdb;"
     ```
   - Настройте `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/clientdb
     spring.datasource.username=postgres
     spring.datasource.password=ваш_пароль
     spring.jpa.hibernate.ddl-auto=update
     spring.thymeleaf.cache=false
     spring.sql.init.mode=always
     ```

3. **Соберите проект**:
   ```bash
   mvn clean install
   ```

4. **Запустите приложение**:
   ```bash
   mvn spring-boot:run
   ```

5. **Откройте приложение**:
   - Перейдите по адресу `http://localhost:8080/` в браузере.
   - Войдите, используя:
     - **Логин**: `user`
     - **Пароль**: `password`

---

## 🧪 Запуск тестов

Проект включает модульные и интеграционные тесты для сервисов (`PersonService`, `CompanyService`, `OrgLegFormService`, `OrgRegistrationService`).

Запустите тесты:
```bash
mvn test
```

Тесты находятся в:
```
src/test/java/com/example/clientinfosystem/service/
```

---

## 📂 Структура проекта

```
clientinfosystem/
├── src/
│   ├── main/
│   │   ├── java/com/example/clientinfosystem/
│   │   │   ├── config/           # Конфигурация Spring Security
│   │   │   ├── controller/       # Веб-контроллеры
│   │   │   ├── model/            # Сущности JPA
│   │   │   ├── repository/       # Репозитории Spring Data JPA
│   │   │   └── service/          # Бизнес-логика
│   │   └── resources/
│   │       ├── templates/        # Шаблоны Thymeleaf
│   │       ├── application.properties  # Конфигурация
│   │       └── data.sql          # Скрипт инициализации базы данных
│   └── test/
│       └── java/com/example/clientinfosystem/service/  # Тесты
├── pom.xml
├── README.md
└── sql/
    └── init.sql
```

---

## 🗄️ Инициализация базы данных

Скрипт `data.sql` в `src/main/resources/` заполняет базу данных тестовыми данными при запуске приложения (если установлено `spring.sql.init.mode=always`). Схема базы данных автоматически управляется Hibernate (`spring.jpa.hibernate.ddl-auto=update`).

---

## 🤝 Как внести вклад

1. Сделайте форк репозитория.
2. Создайте новую ветку (`git checkout -b feature-branch`).
3. Внесите изменения и закоммитьте их (`git commit -m "Добавлена новая функция"`).
4. Отправьте изменения в ветку (`git push origin feature-branch`).
5. Создайте Pull Request.

---

## 📜 Лицензия

Проект распространяется под лицензией MIT.

---

## 📬 Контакты

Если у вас есть вопросы или предложения, свяжитесь через [GitHub Issues](https://github.com/your-username/clientinfosystem/issues).