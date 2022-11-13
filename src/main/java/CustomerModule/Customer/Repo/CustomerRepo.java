package CustomerModule.Customer.Repo;

import CustomerModule.Customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface CustomerRepo extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer>{
    @Override
    List<Customer> findAllById(Iterable<Long> Longs);
    List<Customer> findByFirstName(String lastName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByEmail(String email);
    List<Customer> findByPhoneNumber(String phoneNumber);

}
