<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

    <img
        src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
        alt="">

    <div class="container" data-aos="zoom-out">
        <div class="row justify-content-center">
            <div class="col-lg-9">
                <form action="DomaineServlet?action=save" method="POST" class="form-container">
                    <div class="form-group">
                        <label for="nom" class="form-label">Nom:</label>
                        <input type="text" id="nom" name="nom" class="form-input" required>
                    </div>

                    <div class="form-group">
                        <label for="description" class="form-label">Description:</label>
                        <textarea id="description" name="description" class="form-input" rows="4" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="criteres" class="form-label">Critères:</label>
                        <input type="text" id="criteres" name="criteres" class="form-input" required>
                    </div>

                    <button type="submit" class="btn-submit">Enregistrer</button>
                </form>
            </div>
        </div>
    </div>
</section>
