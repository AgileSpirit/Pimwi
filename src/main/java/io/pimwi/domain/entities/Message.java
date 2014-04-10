package io.pimwi.domain.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

/**
 * User: OCTO-JBU
 * Date: 08/04/2014
 * Time: 19:16
 */
@Entity
@Table(name = "MESSAGES")
public class Message extends AbstractPersistable<Long> {

    private String content;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="SENDER_ID")
    private User sender;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="RECEIVER_ID")
    private User receiver;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissionDate;

    /*
     * GETTERS / SETTERS
     */

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

}
