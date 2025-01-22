<header id="header"
	class="header d-flex flex-column justify-content-center">
	<i class="header-toggle d-xl-none bi bi-list"></i>

	<nav id="navmenu" class="navmenu">
		<ul>
			<!-- Accueil -->
			<li><a
				href="${pageContext.request.contextPath}/DashboardGerantServlet"
				class="${request.getRequestURI().endsWith('/DashboardGerantServlet') || request.getRequestURI().equals(pageContext.request.contextPath + "/") ? 'active' : ''}">
					<i class="bi bi-house navicon"></i><span>Accueil</span>
			</a></li>
			<!-- Admins -->
			<li><a
				href="${pageContext.request.contextPath}/AdministrateurServlet"
				class="${request.getRequestURI().contains('/AdministrateurServlet') ? 'active' : ''}">
					<i class="bi bi-person navicon"></i><span>Admins</span>
			</a></li>
			<!-- Resume -->
			<li><a href="${pageContext.request.contextPath}/HabitantServlet"
				class="${request.getRequestURI().contains('/HabitantServlet') ? 'active' : ''}">
					<i class="fa-solid fa-users-line"></i> <span>Habitants</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/DomaineServlet"
				class="${request.getRequestURI().contains('/DomaineServlet') ? 'active' : ''}">
					<i class="fa-solid fa-bars"></i> <span>Domaines</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/ProjectServlet"
				class="${request.getRequestURI().contains('/ProjectServlet') ? 'active' : ''}">
					<i class="fa-solid fa-diagram-project"></i> <span>Projets</span>
			</a></li>
			<!-- Portfolio -->
			<li><a href="${pageContext.request.contextPath}/FeedbackServlet"
				class="${request.getRequestURI().contains('/FeedbackServlet') ? 'active' : ''}"> <i class="fa-solid fa-comment"></i><span>FeedBacks</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/ReclamationServlet"
				class="${request.getRequestURI().contains('/ReclamationServlet') ? 'active' : ''}"> <i class="fa-regular fa-message"></i><span>réclamate</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/logout"
				> <i class="fa-solid fa-right-from-bracket"></i><span>logout</span>
			</a></li>
		</ul>
	</nav>
</header>

<script>
    // JavaScript for activating the correct link
    document.addEventListener('DOMContentLoaded', () => {
        const currentPath = window.location.pathname;
        const currentHash = window.location.hash;

        // Clear all active classes
        document.querySelectorAll('.navmenu a').forEach(link => {
            link.classList.remove('active');
        });

        // Highlight the correct link based on URL
        document.querySelectorAll('.navmenu a').forEach(link => {
            const href = link.getAttribute('href');
            if (href === currentPath || href === currentHash) {
                link.classList.add('active');
            }
        });
    });
</script>
