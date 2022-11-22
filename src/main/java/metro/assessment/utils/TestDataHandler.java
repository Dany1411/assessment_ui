package metro.assessment.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.log4j.Logger;
import java.io.InputStream;

public class TestDataHandler extends metro.assessment.utils.JsonMapper {
    private static String envJson = "environment.json";
    private static final Logger LOGGER = Logger.getLogger(TestDataHandler.class.getName());

    private static InputStream inputStreamFile(String fileName) {
        return TestDataHandler.class.getClassLoader().getResourceAsStream(EnvironmentConstants.TEST_DATA_DIR+ fileName);
    }

    public static JsonNode getJsonData (String node){
        return JsonMapper.retrieveJsonNode(inputStreamFile(envJson), node );
    }
}
