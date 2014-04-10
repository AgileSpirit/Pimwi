package io.pimwi.application.model;

import io.pimwi.domain.entities.User;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * User: OCTO-JBU
 * Date: 07/04/2014
 * Time: 17:52
 */
public class SettingsForm {

    private String picture;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private CommonsMultipartFile file;

    /*
     * GETTERS / SETTERS
     */

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    public static SettingsForm create(User user) {
        SettingsForm form = new SettingsForm();
        form.picture = user.getIdentity().getPicture();
        form.login = user.getLogin();
        form.password = user.getPassword();
        form.firstName = user.getIdentity().getFirstName();
        form.lastName = user.getIdentity().getLastName();
        form.email = user.getIdentity().getEmail();
        form.phoneNumber = user.getIdentity().getPhoneNumber();
        form.file = null;
        return form;
    }

}
