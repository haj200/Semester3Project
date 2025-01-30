<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Hero Section -->
    <section id="hero" class="hero section dark-background">

      <img src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/hero-bg.jpeg" alt="" data-aos="fade-in" class="">

      <div class="container" data-aos="fade-up" data-aos-delay="100">
       <div class="card-body">
  <h4 class="card-title" style='font-size: 1.5rem; font-weight: bold; color: #ffffff; text-transform: uppercase; text-align: center; padding: 10px; margin: 20px 0; border-bottom: 3px solid #1E90FF; display: inline-block; background: #2874a6 ; border-radius: 5px;'>FeedBacks</h4>
  <p class="card-description"></p>
  <div class="table-responsive">
    <table class="table table-striped">
      <thead>
        <tr>
          <th>ID</th>
          <th>Message</th>
          <th>Proposition</th>
          <th>Soumis Par</th>
          <th>En faveur du Projet</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="feedback" items="${feedbacks}">
          <tr>
            <td class="py-1">${feedback.id}</td>
            <td class="py-1">${feedback.message}</td>
            <td class="py-1">${feedback.proposition}</td>
            <td>${feedback.habitant.nom} ${feedback.habitant.prenom}</td>
            <td>${feedback.projet.titre}</td>
            <td>
              <a href="${pageContext.request.contextPath}/FeedBackAdmin?action=view&id=${feedback.id}" 
                 class="btn btn-primary btn-sm">
                Voir
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
 </div>

    </section>
