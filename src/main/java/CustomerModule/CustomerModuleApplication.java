package CustomerModule;

import CustomerModule.Customer.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("CustomerModule.Customer.Repo")
@SpringBootApplication
@EntityScan("CustomerModule.Customer.model")
public class CustomerModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerModuleApplication.class, args);
    }
}
