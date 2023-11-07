package basefunctions;

/**
 * @author : ahamu
 * @created : 2023-10-20,7:44 p.m.
 * @Email : alimhamut.job@gmail.com
 **/
public class DataClass {
    FunctionLibrary functionLibrary = new FunctionLibrary();
    private final String fileName="config.properties";
    private final String url = functionLibrary.readFromConfig(fileName,"local_dburl");
    private final String port = functionLibrary.readFromConfig(fileName,"local_dbport");
    private final String username = functionLibrary.readFromConfig(fileName,"local_dbusername");
    private final String password = functionLibrary.readFromConfig(fileName,"local_dbpassword");
    private final String defaultDB = functionLibrary.readFromConfig(fileName,"local_dbname");

    public String getFileName() {
        return fileName;
    }

    public String getUrl() {
        return url;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDefaultDB() {
        return defaultDB;
    }
}
