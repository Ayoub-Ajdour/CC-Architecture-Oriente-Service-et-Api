package ma.fpl.equipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class EquipeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipeApplication.class, args);
    }

}
