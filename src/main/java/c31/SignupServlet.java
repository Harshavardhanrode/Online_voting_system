package c31;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String voterId = request.getParameter("voterid");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        

        try (Connection conn = DBConnection.getConnection()) {
            // Check if voter ID already exists
            String checkQuery = "SELECT * FROM users WHERE voter_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, voterId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
            	request.setAttribute("errorMessage", "Voter ID already exists, Please login.");
            	request.getRequestDispatcher("signup.jsp").include(request, response);
            	
                
            } else {
                // Insert user into the database
                String insertQuery = "INSERT INTO users (name, email, username, voter_id) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, name);
                insertStmt.setString(2, email);
                insertStmt.setString(3, username);
                insertStmt.setString(4, voterId);

                int rows = insertStmt.executeUpdate();
                if (rows > 0) {
                    out.println("<p style='color:green;'>Signup successful!</p>");
                    response.sendRedirect("/online_voting_system/login.jsp");
                } else {
                    out.println("<p style='color:red;'>Signup failed. Please try again.</p>");
                    request.getRequestDispatcher("signup.html").include(request, response);
                }
            }
        } catch (SQLException e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        }
	}

}
