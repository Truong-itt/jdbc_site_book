<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="icon" type="image/x-icon"
 href="<c:url value='/template/web/assets/favicon.ico' />" />
<!-- Bootstrap icons-->
<link  href="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css' />"
	rel="stylesheet" type="text/css" />
<!-- Google fonts-->
<link  href="<c:url value='https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic' />"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<!-- 
<link href="css/styles.css" rel="stylesheet" />
 href="<c:url value='' />"
 -->

        <link rel="stylesheet" href="<c:url value='/template/web/css/styles.css' />" type="text/css">
        
</head>
<body>
   <div class="container">
    	<dec:body/>
    </div>
    <!-- 
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    
    <link href="css/styles.css" rel="stylesheet" />
     -->
    	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>