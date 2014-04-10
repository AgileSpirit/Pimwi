package io.pimwi.application.model;

/**
 * User: OCTO-JBU
 * Date: 04/04/2014
 * Time: 08:52
 */
public class NewsModel {

    private String publisherName;
    private Long publisherId;
    private String publisherPicture;
    private String content;

    /*
     * GETTERS / SETTERS
     */

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherPicture() {
        return publisherPicture;
    }

    public void setPublisherPicture(String publisherPicture) {
        this.publisherPicture = publisherPicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
