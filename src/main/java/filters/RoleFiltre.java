package filters;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RoleFiltre implements Filter {

    // Rôles autorisés
    private static final String ADMIN = "administrateur";
    private static final String GERANT = "gerant";
    private static final String HABITANT = "habitant";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Récupérer la session et le type d'utilisateur
        HttpSession session = httpRequest.getSession(false);
        String typeUser = (session != null) ? (String) session.getAttribute("typeUser") : null;

        // Si l'utilisateur n'est pas authentifié, rediriger vers la page de connexion
        if (typeUser == null) {
            httpResponse.sendRedirect("login.jsp?error=unauthorized");
            return;
        }

        String uri = httpRequest.getRequestURI();

        // Vérifier le rôle en fonction de l'URL demandée
        if (uri.contains("/admin") && ADMIN.equals(typeUser)) {
            chain.doFilter(request, response);  // Autoriser l'accès à l'admin
        } else if (uri.contains("/gerant") && GERANT.equals(typeUser)) {
            chain.doFilter(request, response);  // Autoriser l'accès au gérant
        } else if (uri.contains("/habitant") && HABITANT.equals(typeUser)) {
            chain.doFilter(request, response);  // Autoriser l'accès à l'habitant
        } else {
            // Rediriger si l'utilisateur n'a pas les droits nécessaires
            httpResponse.sendRedirect("login.jsp?error=unauthorized");
        }
    }
}
