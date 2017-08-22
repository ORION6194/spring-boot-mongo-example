package com.sadtech.collections.greeting;

public interface GreetingRepositoryCustom {
    int updateGreeting(long id,String content);
    void insertGreeting(Greeting greeting);
}
