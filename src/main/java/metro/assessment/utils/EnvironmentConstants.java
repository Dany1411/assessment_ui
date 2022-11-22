package metro.assessment.utils;

public class EnvironmentConstants {
    public static final String ENVIRONMENT = metro.assessment.utils.SerenityProperties.getProperty("runningUrl").toUpperCase();
    public static final String WEB_DRIVER = metro.assessment.utils.SerenityProperties.getProperty("driver");


    public static final String TEST_DATA_DIR = "testdata/";

    private EnvironmentConstants() {
    }
}
