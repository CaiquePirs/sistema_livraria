package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigBD {
    private static final Properties properties = new Properties();

    static {
        try{
            FileInputStream file = new FileInputStream("src/main/resources/database.properties");
            properties.load(file);
        } catch (IOException e){
            System.out.println("Erro ao carregar configurações do banco: " + e.getMessage());
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUser() {
        return properties.getProperty("db.user");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }

}
