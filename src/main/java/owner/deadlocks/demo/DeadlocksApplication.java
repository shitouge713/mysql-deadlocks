package owner.deadlocks.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "owner.deadlocks.demo.dao")
@SpringBootApplication
public class DeadlocksApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeadlocksApplication.class, args);
    }
}


