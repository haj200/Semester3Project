<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Projet</title>
</head>
<body>
    <h2>Ajouter un Projet</h2>
    <form action="ProjectServlet?action=add" method="post" enctype="multipart/form-data">
        <label for="titre">Titre :</label>
        <input type="text" name="titre" required><br><br>

        <label for="description">Description :</label>
        <textarea name="description" required></textarea><br><br>

        <label for="objectifs">Objectifs :</label>
        <textarea name="objectifs" required></textarea><br><br>

        <label for="budget">Budget :</label>
        <input type="number" name="budget" step="0.01" required><br><br>

        <label for="localisation">Localisation :</label>
        <input type="text" name="localisation" required><br><br>

        <label for="benefice">Bénéfice :</label>
        <input type="text" name="benefice" required><br><br>

        <label for="planBusiness">Plan Business :</label>
        <input type="file" name="planBusiness" required><br><br>

        <label for="etudeFinanciere">Étude Financière :</label>
        <input type="file" name="etudeFinanciere" required><br><br>

        <label for="photo">Photo :</label>
        <input type="file" name="photo" required><br><br>

        <label for="fullDescriptif">Full Descriptif :</label>
        <input type="file" name="fullDescriptif" required><br><br>

        <button type="submit">Ajouter le Projet</button>
    </form>
</body>
</html>
