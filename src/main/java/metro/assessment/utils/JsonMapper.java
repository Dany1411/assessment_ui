package metro.assessment.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JsonMapper {

    private static final Logger LOGGER = Logger.getLogger(JsonMapper.class.getName());

    static JsonNode retrieveJsonNode(InputStream file, String node) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();

        try {
            rootNode = mapper.readTree(file);
        } catch (FileNotFoundException err) {
            LOGGER.error("[FAIL] Desired FileName does not exist ", err);
        } catch (IOException err) {
            LOGGER.error(err);
        }
        return rootNode.get(node);
    }

    JsonMapper() {
    }
}
