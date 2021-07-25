dockerizing
===
### jar 파일명을 특정하도록 pom.xml 조정
```
....
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>

        <!-- 빌드될 jar파일 이름을 강제화 -->
        <finalName>app</finalName>
    </build>
....
```

### Dockerfile
```
FROM openjdk:11
ADD target/app.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### docker build
```
docker build -f Dockerfile -t kjstyle79/spring-web-mybatis .
```
