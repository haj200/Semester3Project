package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Gerant;


@SuppressWarnings("serial")
@WebServlet("/DashboardGerantServlet")
public class DashboardGerantServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the session user
        Gerant gerant = (Gerant) request.getSession().getAttribute("user");

        // Security check to ensure only gerants access this servlet
        if (gerant == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Add any gerant-specific logic/data here
        request.getRequestDispatcher("Gerant/dashboard.jsp").forward(request, response);
    }

}
