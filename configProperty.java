package tester;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configProperty {

	public static void main(String[] args) throws IOException {
		
		// we use config.properties when some values are common in multiple test cases
		  // Location of properties file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testData/config.properties");

        // Loading properties file
        Properties propertiesobj = new Properties();
        propertiesobj.load(file);

        // Reading data from properties file
        String url = propertiesobj.getProperty("appurl");
        String email = propertiesobj.getProperty("email");
        String pwd = propertiesobj.getProperty("password");
        String orid = propertiesobj.getProperty("orderid");
        String custid = propertiesobj.getProperty("customerid");

        System.out.println(url + " " + email + " " + pwd + " " + orid + " " + custid);
	}

}
