<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card-body">
  <h4 class="card-title">Projets</h4>
  <p class="card-description">
    <code></code>
  </p>
  <div class="table-responsive">
    <table class="table table-striped">
      <thead>
        <tr>
          <th></th>
          <th>Titre</th>
          <th>Domaine</th>
          <th>Description</th>
          <th>Objectifs</th>
          <th>Budget</th>
          <th>Localisation</th>
          <th>Proposé par</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="projet" items="${projets}">
          <tr>
            <td class="py-1">${projet.id}</td>
            <td class="py-1">${projet.titre}</td>
            <td>${projet.domaine.nom}</td>
            <td>${projet.description}</td>
            <td>${projet.objectifs}</td>
            <td>${projet.budget}</td>
            <td>${projet.localisation}</td>
            <td>${projet.habitant.nom} ${projet.habitant.prenom}</td>
            <td>
              <a href="${pageContext.request.contextPath}/ProjetAdmin?action=view&id=${projet.id}" 
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
