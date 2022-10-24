import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class EmployeeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JDBConnect con = new JDBConnect();
		try {
			saveFilesPath.requestTransform();
			con.readFilesPath();
			con.updateEmployeeDetails();
			con.insertEmployeeDetails();
//			employeeService.eMPLOYEEGETBYID("EMP10004");
//			employeeService.EMPLOYEEDELETE("EMP10001");
			con.readEmployeesDetails();
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
