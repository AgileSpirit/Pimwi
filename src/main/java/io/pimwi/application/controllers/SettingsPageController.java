package io.pimwi.application.controllers;

import io.pimwi.application.model.SettingsForm;
import io.pimwi.domain.entities.Session;
import io.pimwi.domain.entities.User;
import io.pimwi.domain.factories.UserFactory;
import io.pimwi.domain.services.SessionService;
import io.pimwi.domain.services.UserService;
import io.pimwi.infra.util.ApplicationException;
import io.pimwi.infra.util.CookieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: OCTO-JBU
 * Date: 04/04/2014
 * Time: 20:31
 */
@Controller
@RequestMapping("/settings")
public class SettingsPageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsPageController.class);

    @Inject
    SessionService sessionService;

    @Inject
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, ModelMap model) throws ApplicationException {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String token = cookie.getValue();
            Session session = sessionService.getSession(token);
            if (session != null) {
                User user = userService.get(token, session.getUserId());
                SettingsForm settings = SettingsForm.create(user);
                model.put("settings", settings);
                return "settings";
            }
        }
        return "redirect:/error";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, @ModelAttribute("settings") SettingsForm settings) throws ApplicationException {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String sessionToken = cookie.getValue();
            Session session = sessionService.getSession(sessionToken);
            if (session != null) {

                // Create a temporary User with updated data
                Map<String, String> characteristics = new HashMap<>();
                characteristics.put(UserFactory.FIRST_NAME, settings.getFirstName());
                characteristics.put(UserFactory.LAST_NAME, settings.getLastName());
                characteristics.put(UserFactory.EMAIL, settings.getEmail());
                characteristics.put(UserFactory.PHONE_NUMBER, settings.getPhoneNumber());

                LOGGER.info("I'm before picture...");

                // Set picture
                MultipartFile file = settings.getFile();
                if (!file.isEmpty()) {
                    LOGGER.info("I'm in !");

                    String image = buildPicture(file);
                    if (image != null) {
                        settings.setPicture(image);
                    }
                } else {
                    LOGGER.info("File is empty");
                    settings.setPicture(null);
                }
                characteristics.put(UserFactory.PICTURE, settings.getPicture());

                User user = UserFactory.create(characteristics);
                userService.update(sessionToken, user);

                return "redirect:/settings";
            }
        }
        return "redirect:/error";
    }

    private String buildPicture(MultipartFile file) {
        LOGGER.info("ENTER buildPicture(...)");
        String result = null;
        try {
            result = "data:" + file.getContentType() + ";base64," + DatatypeConverter.printBase64Binary(file.getBytes());
        } catch (IOException e) {
            LOGGER.error("Putain je suis mort !");
        }
        LOGGER.info("String result -> '" + result + "' ");
        LOGGER.info("EXIT buildPicture(...)");
        return result;
    }

}
