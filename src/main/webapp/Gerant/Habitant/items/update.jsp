<section id="hero" class="hero section bg-light text-dark">
  <img src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png" alt="">

  <div class="container" data-aos="zoom-out">
    <div class="row justify-content-center">
      <div class="container mt-5">
        <div class="card shadow" style="background-color: rgba(101,98,98, 0.5); color: #FFFFFF;">
          <div class="card-header text-center" style="background-color: rgba(101,98,98, 0.7); color: #FFFFFF;">
            <h3>Mettre à Jour un Habitant</h3>
          </div>
          <div class="card-body">
            <form action="HabitantServlet?action=save" method="POST">
              <!-- Add hidden input for ID -->
              <input type="hidden" name="id" value="${h.id}" />

              <div class="form-group mb-3">
                <label for="username" class="form-label">Nom d'utilisateur</label>
                <input type="text" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="username" 
                       name="username" 
                       value="${h.username}" 
                       placeholder="Entrer le nom d'utilisateur" required>
              </div>

              <div class="form-group mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="nom" 
                       name="nom" 
                       value="${h.nom}" 
                       placeholder="Entrer le nom" required>
              </div>

              <div class="form-group mb-3">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="prenom" 
                       name="prenom" 
                       value="${h.prenom}" 
                       placeholder="Entrer le prénom" required>
              </div>

              <div class="form-group mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="email" 
                       name="email" 
                       value="${h.email}" 
                       placeholder="Entrer l'email" required>
              </div>

              <div class="form-group mb-3">
                <label for="cin" class="form-label">CIN</label>
                <input type="text" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="cin" 
                       name="cin" 
                       value="${h.cin}" 
                       placeholder="Entrer le CIN" required>
              </div>

              <div class="form-group mb-3">
                <label for="addresse" class="form-label">Adresse</label>
                <input type="text" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="addresse" 
                       name="addresse" 
                       value="${h.addresse}" 
                       placeholder="Entrer l'adresse" required>
              </div>

              <div class="form-group mb-3">
                <label for="dateDeNaissance" class="form-label">Date de Naissance</label>
                <input type="date" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="dateDeNaissance" 
                       name="dateDeNaissance" 
                       value="${h.dateDeNaissance}" 
                       required>
              </div>

              <div class="form-group mb-3">
                <label for="metier" class="form-label">Métier</label>
                <input type="text" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="metier" 
                       name="metier" 
                       value="${h.metier}" 
                       placeholder="Entrer le métier" required>
              </div>

              <div class="form-group mb-3">
                <label for="password" class="form-label">Mot de Passe</label>
                <input type="password" style="background-color: rgba(101,98,98, 0.7);" 
                       class="form-control text-light border-light" 
                       id="password" 
                       name="password" 
                       value="${h.password}" 
                       placeholder="Entrer le mot de passe" required>
              </div>

              <div class="text-center">
                <button type="submit" class="btn btn-success">Mettre à Jour</button>
                <a href="HabitantServlet" class="btn btn-secondary">Annuler</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
