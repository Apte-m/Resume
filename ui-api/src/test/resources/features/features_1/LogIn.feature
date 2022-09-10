#language: ru

@ApplicationRequest
Функциональность: Авторизация


  Структура сценария: Авторизация на главной странице

    Дано переходим на "страница авторизации" и вводим для эедемента "password" значение в поле "<password>"
    Дано переходим на "страница авторизации" и вводим для эедемента "email" значение в поле "<email>"
    Примеры:
      | password | email              |
      | password | email@email.com    |
      |          | email@email.com    |
      | password |                    |
      |          | email@email.com'-- |
      |          | email@email.com'#  |




