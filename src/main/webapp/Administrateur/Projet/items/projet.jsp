<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card">
  <div class="card-header">
    <h4 class="card-title">Détails du Projet</h4>
  </div>
  <div class="card-body">
    <h5 class="card-title text-primary">${projet.titre}</h5>
    <p class="card-text"><strong>Domaine :</strong> ${projet.domaine.nom}</p>
    <p class="card-text"><strong>Description :</strong> ${projet.description}</p>
    <p class="card-text"><strong>Objectifs :</strong> ${projet.objectifs}</p>
    <p class="card-text"><strong>Budget :</strong> ${projet.budget} MAD</p>
    <p class="card-text"><strong>Localisation :</strong> ${projet.localisation}</p>
    <p class="card-text"><strong>Proposé par :</strong> ${projet.habitant.nom} ${projet.habitant.prenom}</p>
    <div class="d-flex justify-content-end">
      <a href="" 
         class="btn btn-success btn-sm mx-2">télécharger documents</a>
     <c:choose>
    <c:when test="${projet.estValide == 0}">
        
            <a href="${pageContext.request.contextPath}/ProjetAdmin?action=validate&id=${projet.id}&est_valide=1" 
         class="btn btn-info btn-sm" 
         >valider</a>
         <a href="${pageContext.request.contextPath}/ProjetAdmin?action=validate&id=${projet.id}&est_valide=-1" 
         class="btn btn-danger btn-sm mx-2" 
         >non valider</a>
       
    </c:when>
    <c:when test="${projet.estValide == 1}">
        <td>Validé</td>
    </c:when>
    <c:otherwise>
        <td>Non Validé</td>
    </c:otherwise>
</c:choose>
      
    </div>
  </div>
</div>
