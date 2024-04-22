package owner.deadlocks.demo;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan(basePackages = "owner.deadlocks.demo.dao")
@SpringBootApplication
public class DeadlocksApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(DeadlocksApplication.class, args);
        } catch (Exception e) {
            log.error("error:{}", e);
        }

    }
}


