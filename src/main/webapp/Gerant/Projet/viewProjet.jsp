<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Projet Unit�</title>
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
  <link href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/aos/aos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Main CSS File -->
  <script src="https://kit.fontawesome.com/e04a0d333b.js" crossorigin="anonymous"></script>
  
  <link href="${pageContext.request.contextPath}/Dist/assetsGerant/css/main.css" rel="stylesheet">

 
</head>

<body class="index-page">

  <%@ include file="/temos/GerantDashElements/header.jsp" %>

  <main class="main">

   <%@ include file="./items/item.jsp" %>

   

  </main>

  <%@ include file="/temos/GerantDashElements/footer.jsp" %>

  <!-- Scroll Top -->
  <a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Preloader -->
  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/php-email-form/validate.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/aos/aos.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/typed.js/typed.umd.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Main JS File -->
  <script src="${pageContext.request.contextPath}/Dist/assetsGerant/js/main.js"></script>

</body>

</html>