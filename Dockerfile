# back
# устанавливаем самую лёгкую версию JVM
FROM openjdk:8-jdk-slim

# указываем точку монтирования для внешних данных внутри контейнера (как мы помним, это Линукс)
VOLUME /tmp

# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8080

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=build/libs/skill-recommendation-0.0.1-SNAPSHOT-plain.jar

# добавляем джарник в образ под именем rebounder-chain-backend.jar
ADD ${JAR_FILE} skill-recommendation.jar

# команда запуска джарника
ENTRYPOINT ["java", "-jar", "/skill-recommendation.jar"]
