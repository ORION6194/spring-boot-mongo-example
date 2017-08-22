package com.sadtech.api;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.sadtech.collections.greeting.Greeting;
import com.sadtech.collections.greeting.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    GreetingRepository greetingRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Greeting> greeting() {
        return greetingRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public Greeting findById(@PathVariable Long id) {
        return greetingRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/content/{content}")
    public Collection<Greeting> greeting(@PathVariable String content) {
        return greetingRepository.findByContentLikeIgnoreCase(content);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity<?> updateGreeting(@RequestBody Greeting greeting) {
        greetingRepository.updateGreeting(greeting.getId(),greeting.getContent());
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public ResponseEntity<?> insertGreeting(@RequestBody Greeting greeting) {
        greetingRepository.insertGreeting(greeting);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}