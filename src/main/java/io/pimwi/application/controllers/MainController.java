package io.pimwi.application.controllers;

import io.pimwi.domain.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    @Inject
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndexPage(@CookieValue(value = "token", required = false) String token) {
        return "redirect:news";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String displayErrorPage() {
        return "error";
    }

}
