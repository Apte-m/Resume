# FOR RUN APPLICATION PUT:

    run chrome driver
    mvn clean verify -Dspring.profiles.active=local-chrome
    
    run firefox driver
    mvn clean verify -Dspring.profiles.active=local-firefox

