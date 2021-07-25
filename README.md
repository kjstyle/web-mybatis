dockerizing
===
### jar 파일명을 특정하도록 pom.xml 조정
```xml
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
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### docker build
```
docker build -f Dockerfile -t spring-web-mybatis .
```

### docker image 생성 확인
```kjstyleui-MacBook-Pro:web-mybatis kjstyle$ docker images
REPOSITORY                     TAG       IMAGE ID       CREATED          SIZE
spring-web-mybatis             latest    9abacae16b47   11 minutes ago   691MB
docker101tutorial              latest    9146c87a5e36   6 hours ago      28.2MB
alpine/git                     latest    b8f176fa3f0d   2 months ago     25.1MB

```

### docker run
* host의 9090에서 container의 8080로 연결해서
```
docker run -d -p 9090:8080 spring-web-mybatis
```

```
kjstyleui-MacBook-Pro:web-mybatis kjstyle$ docker run -d -p 80:9090 spring-web-mybatis
e64d72aefe1769fbc5e005e0cf80fa54b5bc9aba4a8cf75931dda46934bd8f63
kjstyleui-MacBook-Pro:web-mybatis kjstyle$ docker ps
CONTAINER ID   IMAGE                COMMAND               CREATED         STATUS         PORTS                                   NAMES
e64d72aefe17   spring-web-mybatis   "java -jar app.jar"   6 seconds ago   Up 4 seconds   0.0.0.0:80->9090/tcp, :::80->9090/tcp   affectionate_chatterjee
```

### docker logs [pid]
```
kjstyleui-MacBook-Pro:web-mybatis kjstyle$ docker logs 7dc218fc093a

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.2)

2021-07-25 09:58:16.897  INFO 1 --- [           main] k.webmybatis.WebMybatisApplication       : Starting WebMybatisApplication v2.5.2 using Java 11.0.12 on 7dc218fc093a with PID 1 (/app.jar started by root in /)
2021-07-25 09:58:16.902  INFO 1 --- [           main] k.webmybatis.WebMybatisApplication       : No active profile set, falling back to default profiles: default
2021-07-25 09:58:18.577  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2021-07-25 09:58:18.580  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2021-07-25 09:58:18.596  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 10 ms. Found 0 JDBC repository interfaces.
2021-07-25 09:58:18.614  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2021-07-25 09:58:18.616  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2021-07-25 09:58:18.627  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 3 ms. Found 0 JPA repository interfaces.
2021-07-25 09:58:19.682  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-07-25 09:58:19.706  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-07-25 09:58:19.706  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.48]
2021-07-25 09:58:19.837  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-07-25 09:58:19.837  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2796 ms
2021-07-25 09:58:19.916  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-07-25 09:58:20.311  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-07-25 09:58:20.320  INFO 1 --- [           main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:mybatis-test'
2021-07-25 09:58:20.574  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-07-25 09:58:20.672  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.32.Final
2021-07-25 09:58:20.874  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2021-07-25 09:58:21.078  INFO 1 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2021-07-25 09:58:21.442  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-07-25 09:58:21.456  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-07-25 09:58:21.902  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2021-07-25 09:58:22.531  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-07-25 09:58:22.547  INFO 1 --- [           main] k.webmybatis.WebMybatisApplication       : Started WebMybatisApplication in 7.053 seconds (JVM running for 7.916)
```

### 브라우저 확인
![localhost_9090_members](https://user-images.githubusercontent.com/21075371/126895876-5c18a931-1975-49a5-bde7-7701e6076ba5.jpg)

