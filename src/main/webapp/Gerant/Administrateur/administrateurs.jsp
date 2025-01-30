<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Projet Unité</title>
<meta name="description" content="">
<meta name="keywords" content="">

<!-- Favicons -->
<link
	href="${pageContext.request.contextPath}/Dist/assets1/img/favicon.ico"
	rel="icon">
<link
	href="${pageContext.request.contextPath}/Dist/assets1/img/apple-touch-icon.png"
	rel="apple-touch-icon">
<!-- Fonts -->

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com" rel="preconnect">
<link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/aos/aos.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Main CSS File -->
<link
	href="${pageContext.request.contextPath}/Dist/assetsGerant/css/main.css"
	rel="stylesheet">

<style>
.table-dark {
	background-color: rgba(52, 58, 64, 0.9);
	/* Couleur sombre avec transparence */
	color: #f8f9fa;
}

.table-hover tbody tr:hover {
	background-color: rgba(73, 80, 87, 0.9);
	/* Couleur au survol avec transparence */
	transition: background-color 0.3s ease;
}

.container {
	margin-top: 50px;
	padding: 20px;
	background: rgba(147, 142, 147, 0.4);
	/* Fond sombre semi-transparent */
	border-radius: 10px;
}
.pagination {
    display: flex;
    justify-content: center;
    margin: 20px;
    list-style: none; /* Supprime les puces des éléments */
    padding: 0;
}

.pagination li {
    margin:  5px; /* Espacement entre les éléments */
}

.pagination a, .pagination span {
    display: inline-block;
    padding: 8px 16px;
    text-decoration: none;
    background-color: #212529; /* Fond sombre pour le mode dark */
    border: 1px solid #343a40; /* Bordure sombre */
    color: #adb5bd; /* Couleur de texte claire */
    border-radius: 0.25rem; /* Coins légèrement arrondis */
    transition: all 0.2s ease-in-out; /* Transition fluide pour le hover */
}

.pagination a:hover {
    background-color: #B4B0B4; /* Couleur de survol */
    color: #ffffff; /* Texte blanc sur hover */
}

.pagination .active a {
    background-color: #B4B0B4; /* Couleur bleue pour l'élément actif */
    border-color: #B4B0B4; /* Bordure bleue pour l'élément actif */
    color: #ffffff; /* Texte blanc pour l'élément actif */
    cursor: default; /* Désactive le curseur pour la page active */
}

.pagination .disabled a, .pagination .disabled span {
    background-color: #343a40; /* Fond désactivé */
    color: #6c757d; /* Couleur de texte grisée */
    border-color: #343a40; /* Bordure désactivée */
    pointer-events: none; /* Empêche le clic */
}



</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <script src="https://kit.fontawesome.com/e04a0d333b.js" crossorigin="anonymous"></script>
  
</head>

<body class="index-page">

	<%@ include file="/temos/GerantDashElements/header.jsp"%>

	<main class="main">


		<%@ include file="./items/list.jsp"%>


	</main>

	<%@ include file="/temos/GerantDashElements/footer.jsp"%>

	<!-- Scroll Top -->
	<a href="#" id="scroll-top"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Preloader -->
	<div id="preloader"></div>

	<!-- Vendor JS Files -->
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/php-email-form/validate.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/aos/aos.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/typed.js/typed.umd.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/purecounter/purecounter_vanilla.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/waypoints/noframework.waypoints.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/glightbox/js/glightbox.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/vendor/swiper/swiper-bundle.min.js"></script>

	<!-- Main JS File -->
	<script
		src="${pageContext.request.contextPath}/Dist/assetsGerant/js/main.js"></script>

</body>

</html>