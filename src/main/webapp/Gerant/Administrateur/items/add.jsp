<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
		alt="">

	<div class="container" data-aos="zoom-out">
		<div class="row justify-content-center">
			<div class="col-lg-9">
<form action="AdministrateurServlet?action=save" method="POST" class="form-container">
    <div class="form-group">
        <label for="nom" class="form-label">Nom:</label>
        <input type="text" id="nom" name="nom" class="form-input" required>
    </div>

    <div class="form-group">
        <label for="prenom" class="form-label">Prénom:</label>
        <input type="text" id="prenom" name="prenom" class="form-input" required>
    </div>

    <div class="form-group">
        <label for="username" class="form-label">Username:</label>
        <input type="text" id="username" name="username" class="form-input" required>
    </div>

    <div class="form-group">
        <label for="email" class="form-label">Email:</label>
        <input type="email" id="email" name="email" class="form-input" required>
    </div>

    <div class="form-group">
        <label for="password" class="form-label">Mot de passe:</label>
        <input type="password" id="password" name="password" class="form-input" required>
    </div>

    <button type="submit" class="btn-submit">Enregistrer</button>
</form>
</div>
</div>
</div>
</section>
