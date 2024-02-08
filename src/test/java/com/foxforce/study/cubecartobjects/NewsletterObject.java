package com.foxforce.study.cubecartobjects;

public class NewsletterObject {
    private String newsLetterSubject;
    private String senderName;
    private String senderEmail;
    private String htmlContent;
    private String plainTextContent;
    private String recipientEmail;

    public NewsletterObject() {
    }

    public NewsletterObject(String newsLetterSubject, String senderName, String senderEmail, String htmlContent, String plainTextContent, String recipientEmail) {
        this.newsLetterSubject = newsLetterSubject;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.htmlContent = htmlContent;
        this.plainTextContent = plainTextContent;
        this.recipientEmail = recipientEmail;
    }

    public String getNewsLetterSubject() {
        return newsLetterSubject;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public String getPlainTextContent() {
        return plainTextContent;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }
}
