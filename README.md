[![Build Status](https://travis-ci.org/IvanPJF/job4j.svg?branch=master)](https://travis-ci.org/IvanPJF/job4j)
[![codecov](https://codecov.io/gh/IvanPJF/job4j/branch/master/graph/badge.svg)](https://codecov.io/gh/IvanPJF/job4j)    

# Репозиторий Ивана Криницына

Я прохожу обучение по курсу [Job4j]( http://job4j.ru/).
Планирую его пройти к середине 2020 года. Ниже находятся наиболее интересные проекты, которые я реализовывал во время обучения.

## Проекты

+ [Трекер](#Трекер)
+ [Парсер вакансий](#Парсер)
+ [Игра бомбермен](#Бомбермен)

## Трекер
__Описание:__    
Консольное приложение.    
Пользователю отображается меню с возможностями программы.    

__Возможности программы:__
+ Добавлять заявку;
+ Заменять заявку на новую по ID;
+ Удалять заявку по ID;
+ Отображать список всех заявок;
+ Производить поиск по имени заявки.

__Запуск приложения:__    
Для запуска нужно использовать класс [StartUI](https://github.com/IvanPJF/job4j/blob/master/chapter_002/src/main/java/ru/job4j/tracker/StartUI.java).

[Source](https://github.com/IvanPJF/job4j/tree/master/chapter_002/src/main/java/ru/job4j/tracker)    
[К списку проектов](#Проекты)

## Парсер
__Описание:__    
Приложение собирает Java вакансии с сайта [sql.ru](http://sql.ru/forum/job-offers).    
Для парсинга страниц используется библиотека [Jsoup](https://jsoup.org).    
Система запускается с заданной периодичностью, которая устанавливается благодаря использованию библиотеки [quartz](http://quartz-scheduler.org).    

__Возможности программы:__
+ Во время первого запуска, приложение собирает все Java вакансии за прошедший год.
Последующие запуски проверяют и добавляют только новые объявления;    
+ Настройки БД и периодичности запуска приложения имеются в файле [app.properties](https://github.com/IvanPJF/job4j/blob/master/chapter_008/src/main/resources/app.properties).
При желании можно создать свой файл настроек и передать его в параметры при запуске приложения, но он должен быть той же структуры что и файл app.properties.    

__Запуск приложения:__    
Для запуска нужно использовать класс [StartSchedule](https://github.com/IvanPJF/job4j/blob/master/chapter_008/src/main/java/ru/job4j/parser/StartSchedule.java)
с передачей в параметры имени файла настроек.

[Source](https://github.com/IvanPJF/job4j/tree/master/chapter_008/src/main/java/ru/job4j/parser)    
[К списку проектов](#Проекты)

## Бомбермен
__Описание:__    
Реализация игры бомбермен. Отсутствуют графика, меню и пользовательский ввод.    
Приложение демонстрирует простую работу с многопоточностью.    

__Возможности программы:__
+ Имеется поле(двумерный массив);
+ Герои - бомбермен и чудовища;
+ Поле имеет непроходимые участки.

__Запуск приложения:__    
Для запуска нужно использовать класс [PlayGame](https://github.com/IvanPJF/job4j/blob/master/chapter_011_1/src/main/java/ru/job4j/bomberman/PlayGame.java).

[Source](https://github.com/IvanPJF/job4j/tree/master/chapter_011_1/src/main/java/ru/job4j/bomberman)    
[К списку проектов](#Проекты)