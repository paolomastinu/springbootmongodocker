package paolo.mastinu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import paolo.mastinu.person.Person;
import paolo.mastinu.person.PersonRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        personRepository.deleteAll();

        // save a couple of customers
        personRepository.save(new Person("1","Alice", "Smith", "MSsddsfsd"));
        personRepository.save(new Person("2","Bob", "Smith", "dfsdfsdfsd"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Person customer : personRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(personRepository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Person customer : personRepository.findByLastName("Smith")) {
            System.out.println(customer);
        }

        long n = personRepository.updatePerson("MSsddsfsd", "Prudenzia", "Delogu");
        System.out.println("Number of records updated : " + n);

    }

}