package paolo.mastinu.person;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long updatePerson(String fiscalCode, String firstName, String lastName) {

        Query query = new Query(Criteria.where("fiscalCode").is(fiscalCode));
        Update update = new Update();
        update.set("firstName", firstName);
        update.set("lastName", lastName);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Person.class);

        if(result!=null)
            return result.getModifiedCount();
        else
            return 0;

    }

}
