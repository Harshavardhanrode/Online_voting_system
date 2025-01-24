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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String username = request.getParameter("username");
        String voterId = request.getParameter("voterid");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DBConnection.getConnection()) {
            // Query to check if the username and voter ID match an existing user
            String query = "SELECT * FROM users WHERE username = ? AND voter_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, voterId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	
            	HttpSession session = request.getSession();
                session.setAttribute("voter_id", voterId);
                session.setAttribute("user_name", username);
                
            	request.setAttribute("Message", username);
            	request.getRequestDispatcher("Voter.jsp").include(request, response);
                
            } else {
                request.setAttribute("errorMessage", "Invalid username or voter ID. Please try again.");
                request.getRequestDispatcher("login.jsp").include(request, response);
                
            }
        } catch (SQLException e) {
        	request.setAttribute("errorMessage", "Error: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

}
