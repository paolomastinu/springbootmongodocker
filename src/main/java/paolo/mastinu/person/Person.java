package paolo.mastinu.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {

    @Id
    private String id;

    @Indexed(unique = true)
    private String fiscalCode;

    private String firstName;

    private String lastName;

    public Person(String id, String firstName, String lastName, String fiscalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fiscalCode = fiscalCode;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
