package ppkr.rays;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectDetails
 */
@WebServlet("/FarmSelectDetails")
public class FarmSelectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FarmSelectDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}

		StringBuffer output = new StringBuffer();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "jaiHind@1979");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from "+DBConstants.getSchemaQualifiedName(DBConstants.AGRI_SCHEMA_NAME, DBConstants.FARMS_TABLE_NAME));

			output.append(
					"<table> <th> Farm Name </th> <th> Owner Name </th> <th> Location </th> <th> Area </th> <th> Sy No </th>");

			while (rs.next()) {
				output.append("<tr>");

				String name = rs.getString(2);
				String owner_name = rs.getString(3);
				String location = rs.getString(4);

				BigDecimal area = rs.getBigDecimal(5);
				String syNo = rs.getString(6);

				output.append("<td>" + name + "</td>");
				output.append("<td>" + owner_name + "</td>");
				output.append("<td>" + location + "</td>");
				output.append("<td>" + area + "</td>");
				output.append("<td>" + syNo + "</td>");

				output.append("</tr>");
			}
			output.append("</table>");

			rs.close();
			st.close();
			conn.close();

			response.getWriter().append(output);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection successful");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
