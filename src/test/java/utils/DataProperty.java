package utils;

import java.io.InputStream;
import java.util.Properties;

public class DataProperty {

    private static final String CONFIG_FILE = "data.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = DataProperty.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getStandardUsername() {
        return properties.getProperty("STANDARD_USERNAME");
    }

    public String getStandardPassword() {
        return properties.getProperty("STANDARD_PASSWORD");
    }

    public String getLockedoutUsername() {
        return properties.getProperty("LOCKEDOUT_USERNAME");
    }

    public String getLockedoutPassword() {
        return properties.getProperty("LOCKEDOUT_PASSWORD");
    }

    public String getLockedoutUserErrorMessage() {
        return properties.getProperty("LOCKEDOUTUSER_ERRORMESSAGE");
    }

}
