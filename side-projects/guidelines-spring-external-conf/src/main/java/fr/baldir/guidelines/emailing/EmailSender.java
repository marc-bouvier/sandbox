package fr.baldir.guidelines.emailing;

/**
 * API to send emails.
 */
public interface EmailSender {

    /**
     * Sends email from a sender to a recipient.
     * @param sender
     * @param recipient
     * @param content
     */
    void send(String sender,String recipient,String content);

    /**
     * Sends email from a the default sender to a recipient.
     * @param recipient
     * @param content
     */
    void sendFromDefaultSender(String recipient,String content);
}
