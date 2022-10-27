# FOR RUN APPLICATION PUT:
    вставить в VM options, чтобы запускать из idea  
    1. editConfiguratio 
    2. vmOptions 
    3. -Dspring.profiles.active=local-chrome
    (local-chrome (запуск браузера, который нужен для теста))

    run chrome driver
    mvn clean verify -Dspring.profiles.active=local-chrome (запуск из консоли)
    
    run firefox driver
    mvn clean verify -Dspring.profiles.active=local-firefox

