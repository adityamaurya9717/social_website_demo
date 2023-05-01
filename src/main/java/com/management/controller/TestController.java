package com.management.controller;

import com.management.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @GetMapping
    public String pingPong(){
        LOG.info("pingpong");
        LOG.error("ping pong error");
        return "ping Pong";
    }
}
