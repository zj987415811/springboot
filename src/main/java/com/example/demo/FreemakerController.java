package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/json")
public class FreemakerController {


    @GetMapping("/now.json")
    public @ResponseBody Map dateTime() {
        Map map = new HashMap();
        map.put("时间",new Date());
        return map;
    }

}
