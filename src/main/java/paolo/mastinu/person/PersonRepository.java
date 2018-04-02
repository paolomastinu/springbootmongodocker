package paolo.mastinu.person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, Long>, PersonRepositoryCustom {

    Person findFirstByFirstName(String firstName);

    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);

    //Supports native JSON query string
    @Query("{firstName:'?0'}")
    Person findCustomByFirstName(String firstName);

    @Query("{firstName: { $regex: ?0 } })")
    List<Person> findCustomByRegExFirstName(String firstName);

}
