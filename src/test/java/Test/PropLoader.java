package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropLoader {

    public static Properties loadProperties() throws IOException {

        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("D:\\WebAutomation\\src\\test\\java\\Test\\General.properties")) {
            properties.load(input);

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        if(properties.isEmpty()){

            throw new NullPointerException("Failed to load properties");
        }
        return properties;
    }

}
