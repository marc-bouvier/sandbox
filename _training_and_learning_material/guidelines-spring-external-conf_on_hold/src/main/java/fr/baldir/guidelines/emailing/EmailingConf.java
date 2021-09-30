package fr.baldir.guidelines.emailing;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of the module for sending emails.
 */
@Configuration
// Only scan for this properties in the configuration of this module.
// There is no reason to access it from outside (other than bad module design).
@EnableConfigurationProperties(EmailingProperties.class)
public class EmailingConf {

    @Bean
    EmailSender emailSender(EmailingProperties emailingProperties) {
        String provider = emailingProperties.getProvider();
        if ("no-op".equals(provider)) {
            return new NoOpEmailSender(emailingProperties);
        }
        if ("some-vendor".equals(provider)) {
            if (emailingProperties.getSomeVendor() == null) {
                throw new EmailingConfigurationException("No configuration found for mailing provider : \"" + provider + "\"");
            }
            var someVendor = emailingProperties.getSomeVendor();
            if (someVendor.getApiKey() == null) {
                throw new EmailingConfigurationException("Api key is required for mailing provider : \"" + provider + "\"");
            }
            return new SomeVendorEmailSender(emailingProperties);
        }
        throw new EmailingConfigurationException("Unsupported or empty mailing provider : \"" + provider + "\"");
    }

    // inner class because wa have no reason to throw it outside from this EmailingConf class
    private static class EmailingConfigurationException extends RuntimeException {
        public EmailingConfigurationException(String message) {
            super(message);
        }
    }
}
