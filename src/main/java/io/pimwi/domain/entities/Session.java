package io.pimwi.domain.entities;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "SESSIONS")
public class Session implements Persistable<String> {

    /**
     * The name of the cookie that stores the session ID.
     */
    public static final String SMART_SESSION_ID = "SMART_SESSION_ID";

    /**
     * The maximum time-to-live of a Session (in minutes).
     */
    public static final int SESSION_DURATION = 30;

    /**
     * The delay (in minutes) from which the session timestamp is updated ; before this limit, if the session is
     * required, its timestamp is no refreshed, in order to minimize the writing DB requests.
     *
     * Notice : <code>SESSION_UPDATE_DELAY</code> must be less than <code>SESSION_DURATION</code>
     */
    public static final int SESSION_UPDATE_DELAY = 10;

    @Id
    private String token;

    @Column(nullable = false, unique = true)
    private Long userId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    /**
     * Generate a random session token formatted as a JSESSIONID
     *
     * @return The session token
     */
    public static String generateToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getId() {
        return token;
    }

    @Override
    public boolean isNew() {
        return null == getId();
    }

}
