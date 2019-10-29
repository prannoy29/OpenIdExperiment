package org.baeldung.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/username/")
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping
    @ResponseBody
    public String home(Authentication authentication) {
        System.out.println(authentication.getName());
        return "Welcome, " ;
    }

}
