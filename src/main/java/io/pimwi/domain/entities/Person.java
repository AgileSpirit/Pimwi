package io.pimwi.domain.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * User: OCTO-JBU
 * Date: 02/04/2014
 * Time: 19:07
 */
@Entity
@Table(name = "PERSONS")
@NamedQueries({
        @NamedQuery(name = "Person.findByFirstNameOrLastName", query = "SELECT DISTINCT p FROM Person p WHERE UPPER(firstName) LIKE :query OR UPPER(lastName) LIKE :query")
})
public class Person extends AbstractPersistable<Long> {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Column(columnDefinition = "text")
    private String picture;

    @OneToOne(mappedBy = "identity")
    private User user;

    /*
     * GETTERS / SETTERS
     */

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

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
