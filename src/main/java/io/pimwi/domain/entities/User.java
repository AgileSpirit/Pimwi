package io.pimwi.domain.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    private Person identity;

    @OneToMany(mappedBy="publisher", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<News> news;

    @ManyToMany
    @JoinTable(name = "FRIENDS",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERSON_ID")}
    )
    private Set<Person> friends;

    /*
     * BEHAVIOURS
     */

    public void add(Person friend) {
        friends.add(friend);
    }

    public void remove(Person friend) {
        friends.remove(friend);
    }

    public void add(News message) {
        news.add(message);
    }

    /*
     * GETTERS / SETTERS
     */

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

    public Person getIdentity() {
        return identity;
    }

    public void setIdentity(Person identity) {
        this.identity = identity;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
