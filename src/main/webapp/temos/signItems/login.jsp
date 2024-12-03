<div class="container">
    <!-- Section Titre -->
    <div class="title">Connexion</div>
    <div class="content">
        <!-- Formulaire de connexion -->
        <form action="login" method="POST">
            <div class="user-details">
                <!-- Champ pour le Nom d'utilisateur -->
                <div class="input-box">
                    <span class="details">Nom d'utilisateur</span>
                    <input type="text" name="username" placeholder="Entrez votre nom d'utilisateur" required>
                </div>
                <!-- Champ pour le Mot de passe -->
                <div class="input-box">
                    <span class="details">Mot de passe</span>
                    <input type="password" name="password" placeholder="Entrez votre mot de passe" required>
                </div>
            </div>
            <!-- Bouton d'envoi -->
            <div class="button">
                <input type="submit" value="Se connecter">
            </div>
        </form>
        
        <!-- Options d'authentification avec Google et Facebook -->
        <div class="social-login">
            <p>Ou connectez-vous avec:</p>
            <div class="social-buttons">
                <a href="google-auth-url" class="google-btn">Se connecter avec Google</a>
                <a href="facebook-auth-url" class="facebook-btn">Se connecter avec Facebook</a>
            </div>
        </div>
        
        <!-- Lien pour s'inscrire ou réinitialiser le mot de passe -->
        <div class="extra-links">
            <p>Pas encore inscrit? <a href="signin">Créer un compte</a></p>
            <p>Mot de passe oublié? <a href="forgot-password">Réinitialisez-le</a></p>
        </div>
    </div>
</div>

