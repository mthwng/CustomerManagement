package CustomerModule.Customer.model;


import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

@Entity
@Table (name = "customer")
public class Customer {

    //default constructor
    public Customer(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phoneNumber;


    //getter + setter Customer id


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    //or should the getter return a string?

    //getter + setter first name
    public void setFirstName(String a) {
        if(firstName.length() > 50){
            throw new IllegalArgumentException("Input length exceeds limit");
        }
        else this.firstName= a;
    }

    public String getFirstName() {return firstName;}


    //getter + setter for last name
    public void setLastName(String b) {
        if(lastName.length() > 50){
            throw new IllegalArgumentException("Input length exceeds limit");
        }
        else this.lastName = b;
    }

    public String getLastName(){return lastName; }


    //getter + setter for email

    public String getEmail() {return email;}

    public void setEmail(String c){
        if(!patternMatches(email)){
            throw new InputMismatchException("please enter valid email address");
        }
        else this.email = c;
    }
    //helper method for email
    public static boolean patternMatches(String s){
        String regexPattern = "^(.+)@(\\S=)$";
        return Pattern.compile(regexPattern)
                .matcher(s)
                .matches();
    }

//getter + setter for phone number
    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String d){
        if((phoneNumber.length() >20) || !phoneNumber.startsWith("+")){
            throw new IllegalArgumentException("Please ensure your number starts with '+' followed by your country code eg. +6581435628");
        }
        else this.phoneNumber = d;
    }
}
