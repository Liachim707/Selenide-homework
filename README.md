# Selenide Homework

Maven-проект на Java 17, Selenide и JUnit 5.

## Проверяемые сценарии

### jQuery UI Menu
Страница: https://the-internet.herokuapp.com/jqueryui/menu

- отображение меню и подменю при наведении;
- доступность пунктов CSV и Excel;
- отключённое состояние пункта PDF (он отключён на стороне сайта).

### DemoQA Practice Form
Страница: https://demoqa.com/automation-practice-form

- видимость полей;
- ввод имени, фамилии, электронной почты, телефона и адреса;
- выбор пола и хобби;
- выбор предмета через автодополнение;
- HTML5-валидация обязательного поля First Name;
- успешная отправка формы и отображение окна подтверждения.

## Структура
- `src/main/java/pages/MenuPage.java` — Page Object меню.
- `src/main/java/pages/FormPage.java` — Page Object формы.
- `src/test/java/tests/MenuTests.java` — тесты меню.
- `src/test/java/tests/FormTests.java` — тесты формы.
- `pom.xml` — зависимости и настройки Maven.

## Требования
- JDK 17 или новее;
- Maven 3.8+;
- Google Chrome.

## Запуск
Из корневой папки проекта:

```bash
mvn clean test
```

## Скриншоты и видео
После локального запуска добавьте скриншоты или видеозапись выполнения тестов в репозиторий. Отчёты Maven Surefire создаются в `target/surefire-reports`.
