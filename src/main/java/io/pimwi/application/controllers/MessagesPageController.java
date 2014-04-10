package io.pimwi.application.controllers;

import io.pimwi.domain.entities.Session;
import io.pimwi.domain.services.SessionService;
import io.pimwi.domain.services.UserService;
import io.pimwi.infra.util.CookieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * User: OCTO-JBU
 * Date: 04/04/2014
 * Time: 20:31
 */
@Controller
@RequestMapping("/messages")
public class MessagesPageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagesPageController.class);

    @Inject
    SessionService sessionService;

    @Inject
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, ModelMap model) {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String token = cookie.getValue();
            Session session = sessionService.getSession(token);
            if (session != null) {
                // TODO
                return "messages";
            }
        }
        return "redirect:/error";
    }


}
