#language: ru

@ApplicationRequest
Функциональность: Авторизация
  Предыстория:
    Затем на "страница авторизации" для елемента "почта" ввести "testTestovichTestovSimbirSoft"
    Затем на "страница авторизации" для елемента "пароль" ввести "testTestovichTestovSimbir"



  Сценарий: Авторизация на главной странице
    Затем  на "страница яндекс диск" нажать на "создать"
    Затем  на "страница яндекс диск" нажать на "создать папку"
    Затем  на "дирректория" для елемента "имя дирректории" ввести "Тестовая дирректория"
    Затем  на "страница яндекс диск"  переместить "файлы"
    Затем  на "страница яндекс диск" выполнить двойной клик "файлы"
    И на "страница яндекс диск" проверить файлы по имени "имя файла"






