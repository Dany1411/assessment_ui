package metro.assessment.utils;

import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.log4j.Logger;

public class SerenityProperties {

    private static final Logger LOGGER = Logger.getLogger(SerenityProperties.class.getName());
    private static EnvironmentVariables properties;

    static {
        properties = SystemEnvironmentVariables.createEnvironmentVariables();
        LOGGER.info("Successfully loaded Serenity Properties");
    }

    public static void setProperties(EnvironmentVariables properties) {
        SerenityProperties.properties = properties;
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }


}
