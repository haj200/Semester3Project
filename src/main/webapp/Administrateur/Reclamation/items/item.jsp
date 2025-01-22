<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Hero Section -->
    <section id="hero" class="hero section dark-background">

      <img src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/hero-bg.jpeg" alt="" data-aos="fade-in" class="">

      <div class="container" data-aos="fade-up" data-aos-delay="100">
       <div class="card">
  <div class="card-body">
    <h4 class="card-title">Détails de la Réclamation</h4>
    <table class="table">
      <tbody>
        <tr>
          <th>ID</th>
          <td>${reclamation.id}</td>
        </tr>
        <tr>
          <th>Message</th>
          <td>${reclamation.message}</td>
        </tr>
        <tr>
          <th>Soumis Par</th>
          <td>${reclamation.habitant.nom} ${reclamation.habitant.prenom}</td>
        </tr>
        <c:choose>
          <c:when test="${reclamation.est_repondu == 1}">
            <tr>
              <th>Réponse</th>
              <td>${reclamation.reponse}</td>
            </tr>
          </c:when>
          <c:otherwise>
            <tr>
              <th>Réponse</th>
              <td>Pas encore répondu.</td>
            </tr>
          </c:otherwise>
        </c:choose>
      </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/ReclamationAdmin" class="btn btn-secondary">Retour à la liste</a>
  </div>
</div>
 </div>

    </section>
