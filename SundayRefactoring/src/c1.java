import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Properties;


public class c1 {

	public static final Properties properties = new Properties();

	static {
		try {
			properties.load(c2.class.getResourceAsStream("../config/config.properties"));
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
