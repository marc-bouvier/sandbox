package fr.bouvier.marc.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static fr.bouvier.marc.util.Assert.assertValidPropertiesFile;


/**
 * Allows plugins instantiation.
 * <p>Reads properties from a configuration file whose path is defined by environment
 * variable : {@link #CONF_PATH} </p>
 * <p>Plugin implementations must be part of the classpath</p>
 */
public class PluginFactory {

    /** Storage for plugin configurations.*/
    private final static Properties properties = new Properties();
    /** Environment variable key for  plugin configuration propeties file. */
    private final static String CONF_PATH = "P4EE_PLUGIN_CONSUMER_CONF_PATH";

    static {
        loadPluginConfigurationProperties();
    }

    /**
     * Loads an instance of a plugin implementation from it's interface as configured from
     * plugin configuration {@link #CONF_PATH}
     *
     * @param pluginInterface interface
     * @return instance du plugin
     */
    public static <T> T loadPlugin(Class<T> pluginInterface) {
        final String pluginName = pluginInterface.getCanonicalName();
        final String propertiesPluginKey = "plugin.internal." + pluginName;
        final String pluginImplementationName = properties.getProperty(propertiesPluginKey);
        if (pluginImplementationName == null) {
            throw new CannotLoadPluginException(String.format("Cannot load plugin. Make sure the property " +
                    "key \"%s\" exists in file \"%s\"", propertiesPluginKey, System.getenv(CONF_PATH)));
        }
        try {
            return (T) Class.forName(pluginImplementationName).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new PluginInstantiationException(e);
        }
    }

    /** Loads configuration for plugin loading. */
    private static void loadPluginConfigurationProperties() {
        try {
            assertValidPropertiesFile(
                    System.getenv(CONF_PATH),
                    String.format("The environment variable \"%s\" should contain a valid path " +
                            "for a properties configuration file", CONF_PATH));
            try (InputStream propertiesFIS = new FileInputStream(System.getenv(CONF_PATH))) {
                properties.load(propertiesFIS);
            } catch (IOException e) {
                throw new CannotLoadPluginsConfigurationFileException(e);
            }
        } catch (IllegalArgumentException e) {
            throw new CannotLoadPluginsConfigurationFileException(e);
        }
    }


}
