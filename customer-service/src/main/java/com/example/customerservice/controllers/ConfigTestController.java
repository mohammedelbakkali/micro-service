package com.example.customerservice.controllers;


import com.example.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    /**
     * global.params.a=33
     * global.params.b=22
     * customer.params.x=44
     * customer.params.y=11
     * */
    @Value("${global.params.a}") // il va se charge le global.params.a dans l'attribut a
    private int a;
    @Value("${global.params.b}")
    private int b;
    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.y}")
    private int y;

    @GetMapping("/testconfig")
    public Map<String,Integer> getConfigTest(){
         return Map.of("a",a,"b",b,"x",x,"y",y);
    }

   //================ Methode ==============
    @Autowired
    private GlobalConfig globalConfig;
    @GetMapping("/testconfig2")
    public GlobalConfig globalConfigTest(){
        return globalConfig;
    }

}
