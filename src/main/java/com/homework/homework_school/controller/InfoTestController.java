package com.homework.homework_school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("port")
@RestController("/getPort")
public class InfoTestController {

    @Value("${server.port}")
    private int port;


    @GetMapping
    public int getPort() {
        return port;
    }

}


