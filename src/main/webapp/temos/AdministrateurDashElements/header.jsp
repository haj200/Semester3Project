<header id="header" class="header dark-background d-flex flex-column">
	<i class="header-toggle d-xl-none bi bi-list"></i>

	<div class="profile-img">
		<img
			src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/ic.png"
			alt="" class="img-fluid rounded-circle">
	</div>

	<a href="index.html"
		class="logo d-flex align-items-center justify-content-center">
		<h1 class="sitename">${user.nom}${user.prenom}</h1>
	</a>

	<div class="social-links text-center">
		<a href="#" class="twitter"><i class="bi bi-twitter"></i></a> <a
			href="#" class="facebook"><i class="bi bi-facebook"></i></a> <a
			href="#" class="instagram"><i class="bi bi-instagram"></i></a> <a
			href="#" class="google-plus"><i class="bi bi-google"></i></a> <a
			href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
	</div>

	<nav id="navmenu" class="navmenu">
		<ul>
			<li><a
				href="${pageContext.request.contextPath}/Administrateur/dashboard.jsp"><i
					class="bi bi-house-fill navicon"></i>Accueil</a></li>
			<li><a href="${pageContext.request.contextPath}/ProjetAdmin"><i
					class="bi bi-briefcase-fill navicon"></i>Projets</a></li>
			<li><a
				href="${pageContext.request.contextPath}/ReclamationAdmin"><i
					class="bi bi-envelope-open-fill navicon"></i>Réclamations</a></li>
			<li><a href="${pageContext.request.contextPath}/FeedBackAdmin"><i
					class="bi bi-chat-left-text-fill navicon"></i>Feedbacks</a></li>
			<li><a href="${pageContext.request.contextPath}/logout"> <i
					class="bi bi-box-arrow-right navicon"></i><span>Logout</span>
			</a></li>

		</ul>
	</nav>
</header>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        const currentPath = window.location.pathname;

        // Clear all active classes
        document.querySelectorAll('#navmenu a').forEach(link => {
            link.classList.remove('active');
        });

        // Add active class to the link matching the current path
        document.querySelectorAll('#navmenu a').forEach(link => {
            const href = link.getAttribute('href');
            if (href === currentPath || currentPath.startsWith(href)) {
                link.classList.add('active');
            }
        });
    });
</script>
