
package datamanagement;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * class AppProperties.
 */
public  final class AppProperties {
    /**  set the static value of AppProperties null.  */
    private static AppProperties self = null;
    /**
     * import class properties.
     */
    private Properties properties;

    /**
     * implement the get instance method to share the instance of AppProperties.
     * @return instance of AppProperties
     */
    public static AppProperties getInstance() {
        if (self == null) {
            self = new AppProperties();
        }
        return self;
    }

    /**
     * set up a memory for property to read property file.
     */
    private AppProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("Properties.prop"));
        } catch (IOException e) {
            //if any error occurs
            throw new RuntimeException("Could not read property file");
        }
    }

    /**
     * @return properties by implementing getProperties method.
     */
    public Properties getProperties() {
        return properties;
    }
}
