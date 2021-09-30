package fr.baldir.guidelines.emailing;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Externalized configuration for the Emailing module.
 */
@ConfigurationProperties(prefix = "my-app-name.emailing")
@Data
// this class is package private so it won't be accessed from other module
// its only purpose is to be used from EmailingConf
class EmailingProperties {

    /**
     * Enables emailing module.
     */
    private boolean enabled = false;
    /**
     * When not specified, emails will be sent from this email address.
     */
    private String defaultSender = "noreply@example.org";

    /**
     * Allows to choose which implementation to use to send emails.
     * Allowed values :
     * <ul>
     *     <li>"no-op" : Only logs to console</li>
     *     <li>"some-vendor" : Emails will be sent through some-vendor Api</li>
     * </ul>
     * Any other value will result in a configuration exception.
     */
    private String provider = "no-op";

    @NestedConfigurationProperty
    private SomeVendorProviderEmailingProperties someVendor;

    @Data
    public static class SomeVendorProviderEmailingProperties {
        private String apiKey;
    }
}
