# gatling-performance-tests

## Что это?
* [Описание](https://habr.com/ru/companies/alfastrah/articles/808281/);

## Для чего это?
* Шаблонный проект для запуска нагрузочных тестов;

## Где это используется?
* При локальном запуске -> через локальный запуск;
* В тестовой среде **[dev]** -> через запуск maven с параметрами для проверки интеграционного окружения;
* В продуктивной среде **[master]** -> тесты не запускаются, но мастер ветка актуализируется;

## Где посмотреть результаты работы?
* При локальном запуске -> при локальном выполнении тестов, конце будет ссылка на отчет;
* В тестовой среде -> на странице [gitlab pages](TBD);

## Безопасность
* Сервис не содержит секретов и публичных данных;

## Метрики производительности
* Метрики производительности:
  * Параметры соединения - [ConnectionParameters](src/test/java/parameters/ParametersExecution.java)
  * Параметры исполнения тестовых стратегий - [PerformanceParameters](src/test/java/parameters/ParametersExecution.java)
    * Могут передаваться вместе с запуском maven в формате - `mvn -D[наименование параметра]=[значение параметра] gatling:test`
* Среда тестирования (k8s) по производительности в 3 раза ниже prod -> Линейной экстрополяцией можно оценить предполагаемые значения производительности;

## Тестовые стратегии
* В проекте реализованы 2 вида тестовых стратегий:
  
  * *injectionConstantRateProfile* -> 
    * Заданное количество пользователей в течении определенного периода времени.
  
  * *injectionRampRateProfile* -> 
    * Увеличение количества пользователей с 
      течением времени. Начинается c заданного значения и
      увеличивается автоматически до определенного значения;
    * Темп добавления пользователей определяется автоматически;

* Cтратегия "по-умолчанию" -> injectionConstantRateProfile;

## Алгоритм запуска проекта
* Локально:
  * Запуск проекта через выполнения maven:
    * Скрипт с параметрами по умолчанию - `mvn gatling:test`
    * Скрипт с параметрами `mvn -D[наименование параметра]=[значение параметра] gatling:test`
    * Параметры, которые можно задать/переопределить -> [PerformanceParameters](src/test/java/parameters/ParametersExecution.java)
* Среда тестирования:
  * Запускается при merge в среду тест после интеграционных тестов;

## С кем поговорить, если есть вопросы?

| № | Если вопрос про                     | Контакт              |
|---|-------------------------------------|----------------------|
| 0 | Код, настройки                      | in86@inbox.ru        |

