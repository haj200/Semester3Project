<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Projet Unité</title>
<meta name="description" content="">
  <meta name="keywords" content="">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/Dist/assets1/img/favicon.ico" rel="icon">
  <link href="${pageContext.request.contextPath}/Dist/assets1/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com" rel="preconnect">
  <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/aos/aos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Main CSS File -->
  <link href="${pageContext.request.contextPath}/Dist/assetsAdministrateur/css/main.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: iPortfolio
  * Template URL: https://bootstrapmade.com/iportfolio-bootstrap-portfolio-websites-template/
  * Updated: Jun 29 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body class="index-page">

  <%@ include file="/temos/AdministrateurDashElements/header.jsp" %>

  <main class="main">

    <!-- Hero Section -->
    <section id="hero" class="hero section dark-background">

      <img src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/hero-bg.jpeg" alt="" data-aos="fade-in" class="">

      <div class="container" data-aos="fade-up" data-aos-delay="100">
       <h2>${user.nom } ${user.prenom }</h2>
        <p>Bienvenue dans votre espace dédié  <span class="typed" data-typed-items="à la Gestion, à la Coordination, à l'Administration, à la Supervision, au Pilotage, au Management, au Suivi, à la Direction">gestion </span> <br> des projets communautaires... </p>
      </div>

    </section>

      

  </main>

  <%@ include file="/temos/AdministrateurDashElements/footer.jsp" %>

  <!-- Scroll Top -->
  <a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Preloader -->
  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/php-email-form/validate.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/aos/aos.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/typed.js/typed.umd.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Main JS File -->
  <script src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/js/main.js"></script>

</body>

</html>