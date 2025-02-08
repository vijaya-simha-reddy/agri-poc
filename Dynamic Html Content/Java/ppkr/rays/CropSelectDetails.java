package ppkr.rays;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
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
@WebServlet("/CropSelectDetails")
public class CropSelectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CropSelectDetails() {
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
			ResultSet rs = st.executeQuery(
					"select F.NAME, C.NAME, C.TYPE, C.DENSITY, C.PLANTED_DATE, C.NO_OF_YIELDS from agri_poc_schema.FARMS F INNER JOIN agri_poc_schema.CROPS C ON F.ID=C.FARM_ID");
			output.append(
					"<table> <th> Farm Name </th> <th> Crop Name </th> <th> Type </th> <th> Density </th> <th> Planted Date </th> <th> No of Yields</th>");

			while (rs.next()) {
				output.append("<tr>");

				String farm_name = rs.getString(1);
				String crop_name = rs.getString(2);
				String crop_type = rs.getString(3);

				BigDecimal crop_density = rs.getBigDecimal(4);
				Date planted_date = rs.getDate(5);
				int no_of_yields = rs.getInt(6);
				
				output.append("<td>" + farm_name + "</td>");
				output.append("<td>" + crop_name + "</td>");
				output.append("<td>" + crop_type + "</td>");
				output.append("<td>" + crop_density + "</td>");
				output.append("<td>" + planted_date + "</td>");
				output.append("<td>" + no_of_yields + "</td>");

				
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
