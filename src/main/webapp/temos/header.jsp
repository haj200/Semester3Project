<header id="header" class="header d-flex align-items-center fixed-top">
    <div class="container-fluid position-relative d-flex align-items-center justify-content-between">

        <a href="index" class="logo d-flex align-items-center me-auto me-xl-0">
            <h1 class="sitename">Projet <span style="font-size: 2em;">Unité</span></h1><span>.</span>
        </a>

        <nav id="navmenu" class="navmenu">
            <ul>
                <li><a href="#" class="active">Accueil</a></li>
                <li><a href="#">À propos</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Critères</a></li>
                <li><a href="#">Projets Communautaires</a></li>
                <li><a href="#">Équipe Administrative</a></li>
                <li class="dropdown">
                    <a href="#"><span>Domaines intégrables</span> <i class="bi bi-chevron-down toggle-dropdown"></i></a>
                    <ul>
                        <li class="dropdown">
                            <a href="#"><span>Culturel</span> <i class="bi bi-chevron-down toggle-dropdown"></i></a>
                            <ul>
                                <li><a href="#">Critères Particuliers</a></li>
                                <li><a href="#">Aide</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#"><span>Industriel</span> <i class="bi bi-chevron-down toggle-dropdown"></i></a>
                            <ul>
                                <li><a href="#">Critères Particuliers</a></li>
                                <li><a href="#">Aide</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#"><span>Aide</span> <i class="bi bi-chevron-down toggle-dropdown"></i></a>
                            <ul>
                                <li><a href="#">Critères Particuliers</a></li>
                                <li><a href="#">Aide</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">Contact</a></li>
            </ul>
            <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
        </nav>

        <!-- Bouton Se Connecter -->
        <a id="login-btn" class="btn-getstarted" href="${pageContext.request.contextPath}/login">Se Connecter</a>

    </div>
</header>

<script>
    // Vérifie l'URL actuelle
    document.addEventListener("DOMContentLoaded", function () {
        const currentUrl = window.location.href;
        const loginButton = document.getElementById("login-btn");

        // Cache le bouton si l'URL correspond à la page de connexion
        if (currentUrl.includes("/Semester3Project/login")) {
            loginButton.style.display = "none";
        }
    });
</script>
