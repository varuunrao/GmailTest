package config;


import org.testng.annotations.DataProvider;

public class EmailData {

    @DataProvider(name = "emailDataProvider")
    public static Object[][] emailData() {
        return new Object[][] {
                {"mailtestauto12@gmail.com", "Test123!"},
                {"mailtestauto12@gmail.com", "test123"}
                
        };
    }

}
