## Проект по автоматизации тестирования для сайта [Т—Ж (Тинькофф журнал)](https://journal.tinkoff.ru/)
## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Список авто/ручных тестов](#tests-список-авто/ручных-тестов)
- [Список проверок, реализованных в автотестах](#arrow_forward-запуск-тестов-из-терминала)
- [Запуск тестов из терминала](#arrow_forward-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

  ## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.java.com/"><img src="image/logo/Java.svg" width="70" height="70"  alt="Java"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="image/logo/Intelij_IDEA.svg" width="70" height="70"  alt="IDEA"/></a>
<a href="https://www.selenide.org/"><img src="image/logo/Selenide.svg" width="70" height="70" alt="Selenide" title="Selenide"/></a> 
<a href="https://aerokube.com/selenoid/"><img src="image/logo/Selenoid.svg" width="70" height="70"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework"><img src="image/logo/Allure.svg" width="70" height="70"  alt="Allure"/></a>
<a href="https://gradle.org/"><img src="image/logo/Gradle.svg" width="70" height="70"  alt="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="image/logo/JUnit5.svg" width="70" height="70"  alt="JUnit 5"/></a>
<a href="https://www.jenkins.io/"><img src="image/logo/Jenkins.svg" width="70" height="70"  alt="Jenkins"/></a>
<a href="https://www.atlassian.com/software/jira/"><img src="image/logo/Jira.svg" width="70" height="70" alt="Jira" title="Jira"/></a> 
<a href="https://github.com/"><img src="image/logo/Github.svg" width="70" height="70"  alt="GitHub"/></a>
<a href="https://web.telegram.org/"><img src="image/logo/Telegram.svg" width="70" height="70"  alt="Telegram"/></a>
</p>

- В проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/).
- Cборщик - <code>Gradle</code>.  
- Использован <code>JUnit 5</code> в качестве фреймворка модульного тестирования.
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. 
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>.
  
Содержание Allure-отчета для каждого кейса:
- Шаги теста и результат их выполнения
- Скриншот страницы на последнем шаге (возможность визуально проанализировать, почему упал тест)
- Page Source (возможность открыть source страницы в новой вкладке и посмотреть причину падения теста)
- Логи консоли браузера
- Видео выполнения автотеста.

  
## Список авто/ручных тестов
**Автотесты на основном сайте Т-Ж**
- [x] Проверка списка потоков в меню
- [x] Проверка перехода по нажатию кнопки "Смотреть всё" на страницу потоков
- [x] Проверка наличия ссылки на Телеграмм

**Автотесты на страницу поиска постов**
- [x] Проверка поиска по слову
- [x] Раздел первой карточки релевантен поисковому запросу
- [x] Проверка нотифкации при отсутсвии результатов поиска

**Автотесты на страницу создания поста**
- [x] Проверка текста страницы создания поста
- [x] Проверка наличие ссылки на Правила
- [x] Проверка выделения незаполненного поля e-mail

**Список проверок ручного тестирования**
- [x] Проверка регистрации на сайте
- [x] Проверка прокрутки актуальных постов
- [x] Проверка перехода в Учебник


## :arrow_forward: Запуск автотестов

### Запуск тестов на удаленном браузере
Локальный запуск тестов
```
gradle clean test 
```
При необходимости также можно переопределить параметры запуска

```
gradle clean test 
main -Dbrowser="${BROWSER}"
-DbrowserVersion="${VERSION}"
-DbrowserSize="${SIZE}"
-DremoteVideo="${REMOTE_VIDEO}"
-DremoteURL="https://user1:1234@${REMOTE_URL}/wd/hub"
```
## <img src="image/logo/Jenkins.svg" title="Allure TestOps" width="4%"/> Созданный проект в [Jenkins](https://jenkins.autotests.cloud/job/Jenkins_UI_T-J/)
<p align="center">
<img title="allure-report" src="image/screenshots/JenkinsProject.png">
</p>

### Параметры сборки
В сборку были добавлены следующие параметры:
* <code>TASK</code> (набор тестов для запуска)
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По умолчанию - <code>chrome</code>.
* <code>SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию 1920x1080
* <code>VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию - <code>100.0</code>.
* <code>REMOTE_VIDEO</code> – адрес для сохранения видео выполнения теста.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## <img src="image/logo/Jenkins.svg" title="Jenkins" width="4%"/> Страница запуска в Jenkins
<p align="center">
<img title="allure-report" src="image/screenshots/JenkinsJob.png">
</p>

## <img src="image/logo/Allure.svg" title="Allure TestOps" width="4%"/> Пример [Allure-отчета](https://jenkins.autotests.cloud/job/Jenkins_UI_T-J/13/allure/)
В отчете отображены пройденные автотесты. На приложенном изображении открыт тест кейс, отображены его шаги, прикреплены логи, скрины и видео
<p align="center">
<img title="Allure Overview" src="image/screenshots/Allure-report.png">
</p>

## Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4538/dashboards)

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="image/screenshots/AllureTestOps.png">
</p>

## <img src="image/logo/Jira.svg" title="Allure TestOps" width="4%"/> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1378)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="image/screenshots/JiraTask.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="image/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img title="Telegram Notifications" src="image/screenshots/TelegramBot.png"  width="400">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="image/video/video.gif">
</p>
