package com.sadtech.collections.greeting;

import com.mongodb.WriteResult;
import com.sadtech.collections.domain.Domain;
import com.sadtech.collections.domain.DomainRepositoryCustom;
import com.sun.rowset.internal.InsertRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.List;

public class GreetingRepositoryImpl implements GreetingRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int updateGreeting(long id, String content) {

        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("content", content);

        WriteResult result = mongoTemplate.updateFirst(query, update, Greeting.class);

        if(result!=null)
            return result.getN();
        else
            return 0;

    }

    @Override
    public void insertGreeting(Greeting greeting) {
        mongoTemplate.insert(greeting,"greeting");
    }
}
