import org.xml.sax.SAXException;
import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.PreparedStatement;
import javax.xml.xpath.XPathExpressionException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.logging.Level;
import java.sql.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class JDBConnect extends c1 {

	private final ArrayList<Employee> employees = new ArrayList<Employee>();

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;

	public JDBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void readFilesPath() {

		try {
			int s = saveFilesPath.xmlxpaths().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = saveFilesPath.xmlxpaths().get(i);
				Employee EMPLOYEE = new Employee();
				EMPLOYEE.setEmployeeID(l.get("XpathEmployeeIDKey"));
				EMPLOYEE.setFullName(l.get("XpathEmployeeNameKey"));
				EMPLOYEE.setAddress(l.get("XpathEmployeeAddressKey"));
				EMPLOYEE.setFacultyName(l.get("XpathFacultyNameKey"));
				EMPLOYEE.setDepartment(l.get("XpathDepartmentKey"));
				EMPLOYEE.setDesignation(l.get("XpathDesignationKey"));
				employees.add(EMPLOYEE);
				System.out.println(EMPLOYEE.toString() + "\n");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();

		} catch (NegativeArraySizeException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void updateEmployeeDetails() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(c2.Q("q2"));
			statement.executeUpdate(c2.Q("q1"));

		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertEmployeeDetails() {
		try {
			preparedStatement = connection.prepareStatement(c2.Q("q3"));
			connection.setAutoCommit(false);
			for (int i = 0; i < employees.size(); i++) {
				Employee e = employees.get(i);
				preparedStatement.setString(1, e.getEmplyeeID());
				preparedStatement.setString(2, e.getFullName());
				preparedStatement.setString(3, e.getFacultyName());
				preparedStatement.setString(4, e.getFacultyName());
				preparedStatement.setString(5, e.getDepartment());
				preparedStatement.setString(6, e.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();

		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void employeeGetById(String eid) {

		Employee e = new Employee();
		try {
			preparedStatement = connection.prepareStatement(c2.Q("q4"));
			preparedStatement.setString(1, eid);
			ResultSet R = preparedStatement.executeQuery();
			while (R.next()) {
				e.setEmployeeID(R.getString(1));
				e.setFullName(R.getString(2));
				e.setAddress(R.getString(3));
				e.setFacultyName(R.getString(4));
				e.setDepartment(R.getString(5));
				e.setDesignation(R.getString(6));
			}
			ArrayList<Employee> l = new ArrayList<Employee>();
			l.add(e);
			employeeOutPut(l);

		} catch (SQLException e1) {
			e1.printStackTrace();

		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}

	public void employeeDelete(String eid) {

		try {
			preparedStatement = connection.prepareStatement(c2.Q("q6"));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void readEmployeesDetails() {

		ArrayList<Employee> l = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(c2.Q("q5"));
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
				Employee e = new Employee();
				e.setEmployeeID(r.getString(1));
				e.setFullName(r.getString(2));
				e.setAddress(r.getString(3));
				e.setFacultyName(r.getString(4));
				e.setDepartment(r.getString(5));
				e.setDesignation(r.getString(6));
				l.add(e);
			}
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		employeeOutPut(l);
	}

	public void employeeOutPut(ArrayList<Employee> l) {

		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println(
				"================================================================================================================");
		for (int i = 0; i < l.size(); i++) {
			Employee e = l.get(i);
			System.out.println(e.getEmplyeeID() + "\t" + e.getFullName() + "\t\t" + e.getAddress() + "\t"
					+ e.getFacultyName() + "\t" + e.getDepartment() + "\t" + e.getDesignation() + "\n");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
		}

	}
}
