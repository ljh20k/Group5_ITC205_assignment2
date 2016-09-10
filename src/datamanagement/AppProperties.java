
package datamanagement;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
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
     * set up a memory for property for reading property file.
     */
    private AppProperties() {
        properties = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("Properties.prop");
            properties.load(input);
        } catch (IOException e) {
            //if any error occurs
            throw new RuntimeException("Could not read property file");
        } finally {
            try{
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Could not close in stream");
            }
        }
    }

    /**
     * @return properties by implementing getProperties method.
     */
    public Properties getProperties() {
        return properties;
    }
}
