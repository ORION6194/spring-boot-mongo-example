package com.sadtech.collections.greeting;

import com.sadtech.collections.greeting.Greeting;
import com.sadtech.collections.greeting.GreetingRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GreetingRepository extends MongoRepository<Greeting, Long>, GreetingRepositoryCustom {

    Greeting findFirstByContentLike(String content);

    List<Greeting> findByContentLikeIgnoreCase(String content);

    Greeting findById(long id);

    //Mongo JSON query string
    @Query("{content:'?0'}")
    Greeting findCustomByContent(String content);

    @Query("{content: { $regex: ?0 } })")
    List<Greeting> findCustomByRegExContent(String content);

}
