<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card">
  <div class="card-body">
    <h4 class="card-title">D�tails de la R�clamation</h4>
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
              <th>R�ponse</th>
              <td>${reclamation.reponse}</td>
            </tr>
          </c:when>
          <c:otherwise>
            <tr>
              <th>R�ponse</th>
              <td>Pas encore r�pondu.</td>
            </tr>
          </c:otherwise>
        </c:choose>
      </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/ReclamationAdmin" class="btn btn-secondary">Retour � la liste</a>
  </div>
</div>
