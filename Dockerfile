FROM openjdk:17
ADD ./target/animals-0.0.1-SNAPSHOT.jar animals.java
ENTRYPOINT ["java", "-jar", "animals.java"]