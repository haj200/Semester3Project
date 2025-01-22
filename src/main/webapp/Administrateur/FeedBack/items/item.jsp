<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Hero Section -->
    <section id="hero" class="hero section dark-background">

      <img src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/hero-bg.jpeg" alt="" data-aos="fade-in" class="">

      <div class="container" data-aos="fade-up" data-aos-delay="100">
       <div class="card">
  <div class="card-body">
    <h4 class="card-title">Détails du Feedback</h4>
    <table class="table">
      <tbody>
        <tr>
          <th>ID</th>
          <td>${feedback.id}</td>
        </tr>
        <tr>
          <th>Message</th>
          <td>${feedback.message}</td>
        </tr>
        <tr>
          <th>Proposition</th>
          <td>${feedback.proposition}</td>
        </tr>
        <tr>
          <th>Soumis Par</th>
          <td>${feedback.habitant.nom} ${feedback.habitant.prenom}</td>
        </tr>
        <tr>
          <th>En faveur du Projet</th>
          <td>${feedback.projet.titre}</td>
        </tr>
        
      </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/FeedBackAdmin" class="btn btn-secondary">Retour à la liste</a>
  </div>
</div>
</div>

    </section>
