package kjstyle.webmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = WebMybatisApplication.class)
@SpringBootApplication
public class WebMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMybatisApplication.class, args);
    }

}
