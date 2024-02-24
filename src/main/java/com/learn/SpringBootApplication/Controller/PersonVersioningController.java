package com.learn.SpringBootApplication.Controller;

import com.learn.SpringBootApplication.Bean.Version.Name;
import com.learn.SpringBootApplication.Bean.Version.PersonV1;
import com.learn.SpringBootApplication.Bean.Version.PersonV2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
    @GetMapping(path="/v1/person")
    public PersonV1 getPersonV1(){
        return new PersonV1("barath");
    }

    @GetMapping(path="/v2/person")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("barath","kumar"));
    }
}
