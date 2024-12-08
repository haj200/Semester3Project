<!DOCTYPE html>
<html>
<head>
    <title>modifier un Projet</title>
</head>
<body>
    <h2>Modifier un Projet</h2>
    <form action="ProjectServlet?action=update&id=${projet.id}" method="post" enctype="multipart/form-data">
        <label for="titre">Titre :</label>
        <input type="text" name="titre" value="${projet.titre}" required><br><br>

        <label for="description">Description :</label>
        <textarea name="description"  required>${projet.titre}</textarea><br><br>

        <label for="objectifs">Objectifs :</label>
        <textarea name="objectifs" required>${projet.objectifs}</textarea><br><br>

        <label for="budget">Budget :</label>
        <input type="number" name="budget" step="0.01" value="${projet.budget}" ><br><br>

        <label for="localisation">Localisation :</label>
        <input type="text" name="localisation" value="${projet.localisation}" ><br><br>

        <label for="benefice">Bénéfice :</label>
        <input type="text" name="benefice" value="${projet.benefice}" ><br><br>

        <label for="planBusiness">Plan Business :</label>
        <input type="file" name="planBusiness"  ><br><br>

        <label for="etudeFinanciere">Étude Financière :</label>
        <input type="file" name="etudeFinanciere" ><br><br>

        <label for="photo">Photo :</label>
        <input type="file" name="photo" ><br><br>

        <label for="fullDescriptif">Full Descriptif :</label>
        <input type="file" name="fullDescriptif" ><br><br>

        <button type="submit">Modifier le Projet</button>
    </form>
</body>
</html>
