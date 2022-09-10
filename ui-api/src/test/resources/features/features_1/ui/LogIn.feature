#language: ru

@ApplicationRequest
Функциональность: Авторизация


  Структура сценария: Авторизация на главной странице

    Дано переходим на "страница авторизации" и вводим для эедемента "password" значение в поле "<password>"
    Дано переходим на "страница авторизации" и вводим для эедемента "email" значение в поле "<email>"
    Затем на "страница авторизации" нажать "come in"

    И проверяем, что url соотвествует "<url>"
    Примеры:
      | password | email              | url                                                                                           |
      | password | email@email.com    | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | email@email.com    | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      | password |                    | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          |                    | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | ' or 1=1--"        | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | ' or 1=1#"         | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | ' or 1=1/*"        | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | ') or '1'='1--"    | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | ') or ('1'='1--"   | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | "♣"                | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | email@email.com'-- | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |
      |          | email@email.com'#  | https://account.habr.com/login/?state=7b8700f3c5b4dff83e6f7477043fc7f5&consumer=habr&hl=ru_RU |


  Структура сценария: Проверка элементов

    Затем на "страница авторизации"  провереям наличие текста  "<текст>" и он равен ожидаемому "<результат>"
    Примеры:
      | текст                      | результат      |
      | shadow-box__title          | Вход           |
      | form__remind-password-link | Забыли пароль? |


  Сценарий:  Проверка элементов коллекции

    Затем на "страница авторизации"  провереям наличие  "коллекции"
      | Почта  | E-mail                                |
      | Пароль | Пароль                                |
      | Другое | Или войдите с помощью других сервисов |




