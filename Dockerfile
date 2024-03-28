# После FROM указываются необходимые для приложения Images
FROM openjdk:17

# EXPOSE Задаёт порт
EXPOSE 8080:8080

# Создаём корневую папку для приложения внутри Image
RUN mkdir /app

# В Dockerfile описывается как формируется образ проекта.
# После COPY указываются файлы и папки, которые копируются из проекта в Image (1)  и папку внутри Image, куда нужно скопировать
COPY build/libs/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]

# Команда для создания образа:  docker build -t name-of-image .