package c31;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class submit_vote
 */
@WebServlet("/submit_vote")
public class submit_vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit_vote() {
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
		
		String selectedParty = request.getParameter("party");

        // Retrieve the voter's ID from the session
        HttpSession session = request.getSession();
        String voterId = (String) session.getAttribute("voter_id");
        String username = (String) session.getAttribute("user_name");
        

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        

        // Check if the voter is logged in
        if (voterId == null) {
            out.println("<p style='color:red;'>User not logged in. Please log in to vote.</p>");
            out.println("<a href='/online_voting_system/login.jsp' style='color:red; font-size:20px;'>Login</a>");
            return;
        }

        // Database operation
        try (Connection conn = DBConnection.getConnection()) {
            // Query to update the vote
            String updateQuery = "UPDATE users SET votefor = ? WHERE voter_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, selectedParty);
            stmt.setString(2, voterId);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
            	out.println("<h1 style='color:green;'>Thanks , "+ username+" </h1>  " );
                out.println("<h1 style='color:green;'>Your vote for " + selectedParty + " has been successfully recorded!</h1>");
                out.println("<a href='/online_voting_system/LogoutServlet' style='color:red; font-size:20px;'>Logout</a>");
            } else {
                out.println("<p style='color:red;'>Error: Unable to record your vote. Please try again later.</p>");
            }
        } catch (SQLException e) {
            out.println("<p style='color:red;'>Database error: " + e.getMessage() + "</p>");
        }
	}

}
