package fr.baldir.guidelines.emailing;

import lombok.extern.slf4j.Slf4j;

/**
 * No-op implémentation. Does nothing but logging.
 */
@Slf4j
// package protected. Please use the public interface to interact with this service.
class NoOpEmailSender implements EmailSender {
    private final String defaultSender;

    NoOpEmailSender(EmailingProperties emailingProperties) {
        log.info("Loading No-op implementation for EmailSender service");
        this.defaultSender = emailingProperties.getDefaultSender();
    }

    @Override
    public void send(String sender, String recipient, String content) {
        System.out.println("Sending email " +
                "from sender=\"" + sender + "\" " +
                "to recipient=\"" + recipient + "\". " +
                "Content = \"" + content + "\"");
    }

    @Override
    public void sendFromDefaultSender(String recipient, String content) {
        send(defaultSender, recipient, content);
    }
}
