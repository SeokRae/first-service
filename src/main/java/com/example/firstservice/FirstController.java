package com.example.firstservice;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstController {

    Environment environment;

    @Autowired
    public FirstController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/health-check")
    public String welcome(HttpServletRequest request) {
        log.info("Server port : {}", request.getServerPort());
        return String.format("It's First Service, Port: %s", environment.getProperty("local.server.port"));
    }
}
