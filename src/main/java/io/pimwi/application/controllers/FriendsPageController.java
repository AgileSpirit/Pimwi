package io.pimwi.application.controllers;

import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.Session;
import io.pimwi.domain.services.SessionService;
import io.pimwi.domain.services.UserService;
import io.pimwi.infra.util.ApplicationException;
import io.pimwi.infra.util.CookieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 04/04/2014
 * Time: 20:31
 */
@Controller
@RequestMapping("/friends")
public class FriendsPageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FriendsPageController.class);

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
                try {
                    List<Person> friends = userService.findFriends(token, session.getUserId());
                    model.addAttribute("friends", friends);
                    return "friends";
                } catch (ApplicationException e) {
                    LOGGER.error(e.getMessage());
                    return "redirect:/error";
                }
            }
        }
        return "redirect:/error";
    }

    @RequestMapping(value = "/add/{personId}", method = RequestMethod.GET)
    public String doAdd(HttpServletRequest request, @PathVariable("personId") Long personId) {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String token = cookie.getValue();
            Session session = sessionService.getSession(token);
            if (session != null) {
                try {
                    userService.addFriend(token, personId);
                    return "redirect:/friends";
                } catch (ApplicationException e) {
                    LOGGER.error(e.getMessage());
                    return "redirect:/error";
                }
            }
        }
        return "redirect:/error";
    }


    @RequestMapping(value = "/remove/{personId}", method = RequestMethod.GET)
    public String doDelete(HttpServletRequest request, @PathVariable("personId") Long personId) {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String token = cookie.getValue();
            Session session = sessionService.getSession(token);
            if (session != null) {
                try {
                    userService.removeFriend(token, personId);
                    return "redirect:/friends";
                } catch (ApplicationException e) {
                    LOGGER.error(e.getMessage());
                    return "redirect:/error";
                }
            }
        }
        return "redirect:/error";
    }

}
