package basefunctions;

public class TestDataHolder {
    FunctionLibrary functionLibrary=new FunctionLibrary();
    public String url = functionLibrary.readFromConfig("config.properties","url");
    public String userName = functionLibrary.readFromConfig("config.properties","username1");
    public String passWord = functionLibrary.readFromConfig("config.properties","password");
}
