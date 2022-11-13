package CustomerModule.Customer.Controller;

import CustomerModule.Customer.Repo.CustomerRepo;
import CustomerModule.Customer.errorhandling.CustomerMismatchException;
import CustomerModule.Customer.errorhandling.CustomerNotFoundException;
import CustomerModule.Customer.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http calls defined here
@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    public CustomerRepo customerRepo;

    //GET request for all customers
    @GetMapping("/allcustomers")
    public Iterable findAll() {
        return customerRepo.findAll();
    }

    //GET list of all customers
    @GetMapping("/allCustomers")
    public List findAllCustomers() {
        return customerRepo.findAll();
    }

    //GET request for customer details by Id
    @GetMapping("/CustomersId/{id}")
    public Customer findOne(@PathVariable Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException());
    }

    //GET request customer details by last name
    @GetMapping("/lastName/{lastName}")
    public List<Customer> findByLastName(@PathVariable("lastName") String lastName) {
        return customerRepo.findByLastName(lastName);
    }

    //GET request customer details by first name
    @GetMapping("/firstName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable("firstName") String firstName) {
        return customerRepo.findByFirstName(firstName);
    }

    //GET request customer details by email
    @GetMapping("/email/{email}")
    public List<Customer> findByEmail(@PathVariable("email") String email) {
        return customerRepo.findByEmail(email);
    }

    //GET request customer details by phone number
    @GetMapping("/phoneNumber/{phoneNumber}")
    public List<Customer> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return customerRepo.findByPhoneNumber(phoneNumber);
    }


    //POST request customer creation
    @PostMapping("/createCustomer")
    Customer newCustomer(@RequestBody Customer newCustomer) {return customerRepo.save(newCustomer);}



    //DELETE  customer
    @DeleteMapping("/deleteCustomer/{id}")
    public void delete(@PathVariable Long id){
        customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException());
        customerRepo.deleteById(id);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) throws CustomerMismatchException{
        if (customer.getId() !=id){
            throw new CustomerMismatchException();
        }
        customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException());
        return customerRepo.save(customer);
    }
}