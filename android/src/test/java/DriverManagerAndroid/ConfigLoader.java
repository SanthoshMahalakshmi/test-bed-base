package DriverManagerAndroid;

import UtilitiesForAndroid.LogUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

public class ConfigLoader {
    private static final Logger logger = LogUtil.getLogger(ConfigLoader.class.getName());

    /**
     * Loads the configuration from the specified JSON file.
     *
     * @param filePath Path to the JSON file.
     * @return A map containing the configuration key-value pairs.
     */
    public static Map<String, Object> loadConfig(String filePath) {
        try {
            LogUtil.info("Loading configuration from: " + filePath);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration file: " + filePath, e);
        }
    }
}
