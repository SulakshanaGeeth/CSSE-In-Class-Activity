import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class c1 {

	public static final Properties p = new Properties();

	static {
		try {
			p.load(c2.class.getResourceAsStream("../config/config.properties"));
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
