

<div class="container">
    <!-- Section Titre -->
    <div class="title">Inscription</div>
    <div class="content">
      <!-- Formulaire d'inscription -->
      <form action="signin" method="POST">
        <div class="user-details">
          <!-- Champ pour le Nom -->
          <div class="input-box">
            <span class="details">Nom</span>
            <input type="text" name="nom" placeholder="Entrez votre nom" required>
          </div>
          <!-- Champ pour le Pr�nom -->
          <div class="input-box">
            <span class="details">Pr�nom</span>
            <input type="text" name="prenom" placeholder="Entrez votre pr�nom" required>
          </div>
          <!-- Champ pour le Nom d'utilisateur -->
          <div class="input-box">
            <span class="details">Nom d'utilisateur</span>
            <input type="text" name="username" placeholder="Entrez votre nom d'utilisateur" required>
          </div>
          <!-- Champ pour l'Email -->
          <div class="input-box">
            <span class="details">Email</span>
            <input type="email" name="email" placeholder="Entrez votre email" required>
          </div>
          <!-- Champ pour le Num�ro de t�l�phone (CIN) -->
          <div class="input-box">
            <span class="details">Num�ro de t�l�phone (CIN)</span>
            <input type="text" name="cin" placeholder="Entrez votre CIN" required>
          </div>
          <!-- Champ pour l'Adresse -->
          <div class="input-box">
            <span class="details">Adresse</span>
            <input type="text" name="adresse" placeholder="Entrez votre adresse" required>
          </div>
          <!-- Champ pour la Date de Naissance -->
          <div class="input-box">
            <span class="details">Date de naissance</span>
            <input type="date" name="dateDeNaissance" placeholder="Entrez votre date de naissance" required>
          </div>
          <!-- Champ pour le M�tier -->
          <div class="input-box">
            <span class="details">M�tier</span>
            <input type="text" name="metier" placeholder="Entrez votre m�tier" required>
          </div>
          <!-- Champ pour le Mot de Passe -->
          <div class="input-box">
            <span class="details">Mot de passe</span>
            <input type="password" name="password" placeholder="Entrez votre mot de passe" required>
          </div>
          <!-- Champ pour la Confirmation du Mot de Passe -->
          <div class="input-box">
            <span class="details">Confirmer le mot de passe</span>
            <input type="password" name="confirmPassword" placeholder="Confirmez votre mot de passe" required>
          </div>
        </div>
        
        <!-- Bouton d'envoi -->
        <div class="button">
          <input type="submit" value="S'inscrire">
        </div>
      </form>
    </div>
</div>
