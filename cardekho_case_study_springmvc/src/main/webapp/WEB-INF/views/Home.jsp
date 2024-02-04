<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <jsp:include page="Navbar.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CarDekhoCaseStudy Spring MVC</title>
<style type="text/css">
.header {
	position: relative;
	background-image: url("https://img.freepik.com/premium-photo/front-view-generic-brandless-moder-car_110488-502.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	width: 100%;
	height: 100%;
}
.header img {
	width: 100%;
	
}
.header-overlay {
	position: absolute;
	top: 40%;
	left: 50%;
	transform: translate(-80%, -80%);
	text-align: center;
	color: white;
	background: rgba(0, 0, 0, 0,0.5); 
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	}
	.header-overlay h1 {
	font-size: 50px;
	
}
.header-overlay p {
	font-size: 20px;
	
}
 
</style>
</head>
<body>
  <header class="header">
   
   <img  alt="car-img" src="https://img.freepik.com/premium-photo/front-view-generic-brandless-moder-car_110488-502.jpg">
    <div class="header-overlay">
			<h1>Welcome to Car Dekho</h1>
			<p>Find here your car information...</p>
		</div>
  </header>
</body>
</html>