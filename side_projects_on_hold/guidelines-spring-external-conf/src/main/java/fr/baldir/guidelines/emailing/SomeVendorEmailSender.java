package fr.baldir.guidelines.emailing;

import lombok.extern.slf4j.Slf4j;

/**
 * Some vendor implementation. It seems to use an api key...
 */
@Slf4j
// package protected. Please use the public interface to interact with this service.
class SomeVendorEmailSender implements EmailSender {
    private final String defaultSender;
    private final String vendorApiKey;

    SomeVendorEmailSender(EmailingProperties emailingProperties) {
        log.info("Loading Some-vendor implementation for EmailSender service");
        this.defaultSender = emailingProperties.getDefaultSender();
        // init some vendor configuration
        this.vendorApiKey = emailingProperties.getSomeVendor().getApiKey();
    }

    @Override
    public void send(String sender, String recipient, String content) {
        // Some vendor client call
    }

    @Override
    public void sendFromDefaultSender(String recipient, String content) {
        send(defaultSender, recipient, content);
    }
}
