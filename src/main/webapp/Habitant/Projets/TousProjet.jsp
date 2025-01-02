
<h1>Projets:</h1>

<!-- Affichage de la liste des projets -->
<c:forEach var="projet" items="${projects}">
    <!-- Affichage des informations sur chaque projet -->
    <p>
        <strong>ID:</strong> <c:out value="${projet.id}" /><br>
        <strong>Titre:</strong> <c:out value="${projet.titre}" /><br>
        <strong>Description:</strong> <c:out value="${projet.description}" /><br>
        <strong>Objectifs:</strong> <c:out value="${projet.objectifs}" /><br>
        <strong>Budget:</strong> <c:out value="${projet.budget}" /><br>
        <strong>Localisation:</strong> <c:out value="${projet.localisation}" /><br>
        <strong>Bénéfice:</strong> <c:out value="${projet.benefice}" /><br>
        <strong>Est validé:</strong> <c:out value="${projet.estValide}" /><br>
        <strong>Gain:</strong> <c:out value="${projet.gain}" /><br>

        <!-- Affichage de l'habitant associé au projet -->
        <strong>Habitant:</strong> <c:out value="${projet.habitant.nom} ${projet.habitant.prenom}" /><br>
        
        <!-- Affichage du domaine associé au projet -->
        <strong>Domaine:</strong> <c:out value="${projet.domaine.nom}" /><br>

        
        
    </p>
</c:forEach>

<!-- Lien vers la page d'ajout d'un projet -->
<a href="ProjetHabitant?action=new" class="button">Ajouter un Projet</a>

