<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Hero Section -->
    <section id="hero" class="hero section dark-background">

      <img src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/hero-bg.jpeg" alt="" data-aos="fade-in" class="">

      <div class="container" data-aos="fade-up" data-aos-delay="100">
      <div class="card">
  <div class="card-body">
    <h4 class="card-title">Répondre à la Réclamation</h4>
    <form action="${pageContext.request.contextPath}/ReclamationAdmin" method="post">
      <input type="hidden" name="id" value="${reclamation.id}" />
      <div class="form-group">
        <label for="reponse">Réponse</label>
        <textarea id="reponse" name="reponse" class="form-control" rows="4" placeholder="Entrez votre réponse ici..." required></textarea>
      </div>
      <button type="submit" class="btn btn-success">Envoyer la Réponse</button>
      <a href="${pageContext.request.contextPath}/ReclamationAdmin" class="btn btn-secondary">Annuler</a>
    </form>
  </div>
</div>
 </div>

    </section>
