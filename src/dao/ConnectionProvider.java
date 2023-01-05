
package dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionProvider {

	public static Connection getcon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starmansys", "root", "");
			return con;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}
		return con;
	}
}
