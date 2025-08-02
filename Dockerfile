FROM openjdk:17-jdk-slim

WORKDIR /app

# Gradle Wrapper 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# 소스 코드 복사
COPY src src

# 실행 권한 부여
RUN chmod +x ./gradlew

# 빌드
RUN ./gradlew build -x test

# JAR 파일 실행
CMD ["java", "-jar", "build/libs/backend-0.0.1-SNAPSHOT.jar"]
