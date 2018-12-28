package com.example.demo.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MongoController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/addbaike")
    public Baike addDict(Baike baike) {
        baike.setCreateDate(new Date());
        mongoTemplate.insert(baike,"baike");
        return baike;
    }
}
