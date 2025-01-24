package c31;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testdb")
public class DatabaseTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:mysql://localhost:3306/user_management?useSSL=false";
    private static final String USER = "root"; // Replace with your username
    private static final String PASSWORD = "Harsh.0027"; // Replace with your password

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Optional: Explicitly load the driver if needed
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            if (conn != null) {
                out.println("<p style='color:green;'>Database connection successful!</p>");
            } else {
                out.println("<p style='color:red;'>Database connection failed!</p>");
            }
        } catch (ClassNotFoundException e) {
            out.println("<p style='color:red;'>MySQL JDBC Driver not found: " + e.getMessage() + "</p>");
        } catch (SQLException e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }
}
