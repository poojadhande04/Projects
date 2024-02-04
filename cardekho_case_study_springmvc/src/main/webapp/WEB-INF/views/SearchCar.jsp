
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="Navbar.jsp"/>
     <%@page import="com.jspiders.cardekho_case_study_springmvc.pojo.CarPOJO" %>
     <%@page import="java.util.List" %>
    <%
     String msg=(String)request.getAttribute("msg");
     CarPOJO pojo=(CarPOJO)request.getAttribute("car");
     List<CarPOJO> cars=(List<CarPOJO>)request.getAttribute("cars");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.form-container {
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	padding: 20px;
	max-width: 400px;
	margin: 20px auto;
}

.form-container h2 {
	text-align: center;
}

.form-group {
	margin-bottom: 10px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-group select, .form-group input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
}

.btn {
	background-color: #52cffe;
	color: #fff;
	border: none;
	border-radius: 5px;
	padding: 10px 20px;
	cursor: pointer;
	font-size: 18px;
	transition: background-color 0.3s;
}

.btn:hover {
	background-color: #41dfff;
}

.table-container {
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	padding: 20px;
	max-width: 800px;
	margin: 20px auto;
}

.table-container h2 {
	text-align: center;
}

.car-table {
	width: 100%;
	border-collapse: collapse;
}

.car-table th, .car-table td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

.car-table th {
	background-color: #333;
	color: white;
}
</style>
</head>
<body>
   <div align="center">
    <div>
        <h2>Search Car</h2>
        <form action="./search" method="post">
           <div class="form-group">
              <label for="searchParam">Search By</label>
              <select name="searchParam" id="searchParam">
                 <option value="id">ID</option>
                  <option value="name">Name</option>
                   <option value="brand">Brand</option>
                    <option value="model">Model</option>
                     <option value="fuel_type">Fuel_type</option>
              </select>
           </div>
           <div class="form-group">
            <label for="searchval">Value</label>
            <input type="text" name="searchVal" id="searchVal" required>
          </div>
           <div>
             <input type="submit" value="SEARCH" class="btn">
           </div>
           </form>
            </div>
     <%
    if(msg !=null){
    	
    %>
    <h3><%=msg %></h3>
     <%} %>
     <%if(pojo !=null){
	   %>
    <table class="car-table">
      <tr>
        <td>ID</td>
        <td>Car NAME</td>
        <td>MOdel</td>
        <td>Brand</td>
        <td>FuelType</td>
        <td>Price</td>
      </tr>
       <tr>
        <td><%=pojo.getCar_id() %></td>
        <td><%=pojo.getName() %></td>
        <td><%=pojo.getModel() %></td>
        <td><%=pojo.getBrand() %></td>
        <td><%=pojo.getFuel_type() %></td>
        <td><%=pojo.getPrice() %></td>
      </tr>
    </table>
  
   <%} %>
   <%
		if (cars != null) {
		%>
		<div class="table">
			<table class="car-table">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>BRAND</th>
					<th>MODEL</th>
					<th>FUELTYPE</th>
					<th>PRICE</th>
				</tr>
				<%
				for (CarPOJO car : cars) {
				%>
				<tr>
					<td><%=car.getCar_id()%></td>
					<td><%=car.getName()%></td>
					<td><%=car.getBrand()%></td>
					<td><%=car.getModel()%></td>
					<td><%=car.getFuel_type()%></td>
					<td><%=car.getPrice()%></td>
				</tr>
			</table>
		</div>

		<%
		}
		}
		%>
   
  
   </div>
</body>
</html>