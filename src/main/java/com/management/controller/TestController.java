package com.management.controller;

import com.management.proxy.CurrentUser;
import com.management.proxy.UserComponent;
import com.management.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserComponent userComponent;
    @GetMapping
    public String pingPong(@RequestParam("userId") String userId){
        LOG.info("pingpong");
        LOG.error("ping pong error");
        return "ping Pong"+userComponent.getCurrentUser().getUserId();
    }
}
