<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>

<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Projet Unité-Espace Administrateur</title>
<meta name="description" content="">
  <meta name="keywords" content="">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/Dist/assets1/img/favicon.ico" rel="icon">
  <link href="${pageContext.request.contextPath}/Dist/assets1/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- base:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets3/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets3/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets3/css/style.css">
</head>
<body>
  <div class="container-scroller d-flex">
    <!-- partial:./partials/_sidebar.html -->
     <%@ include file="/temos/AdministrateurDashElements/leftNav.jsp" %> 
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:./partials/_navbar.html -->
      <%@ include file="/temos/AdministrateurDashElements/header.jsp" %> 
      <!-- partial -->
      <%@ include file="/Administrateur/Reclamation/items/reponse.jsp" %>
          <!-- row end -->
        
        <!-- content-wrapper ends -->
        <!-- partial:./partials/_footer.html -->
       
        <!-- partial -->
     </div>
      <!-- main-panel ends -->
    
    <!-- page-body-wrapper ends -->
  
  <!-- container-scroller -->
</div>
  <!-- base:js -->
  <script src="${pageContext.request.contextPath}/Dist/assets3/vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="${pageContext.request.contextPath}/Dist/assets3/vendors/chart.js/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assets3/js/jquery.cookie.js" type="text/javascript"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath}/Dist/assets3/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assets3/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/Dist/assets3/js/template.js"></script>
  <!-- endinject -->
  <!-- plugin js for this page -->
    <script src="${pageContext.request.contextPath}/Dist/assets3/js/jquery.cookie.js" type="text/javascript"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="${pageContext.request.contextPath}/Dist/assets3/js/dashboard.js"></script>
  <!-- End custom js for this page-->
</body>

</html>