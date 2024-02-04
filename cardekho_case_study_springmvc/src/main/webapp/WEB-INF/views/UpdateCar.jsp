  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <jsp:include page="Navbar.jsp"/>
    <%@page import="com.jspiders.cardekho_case_study_springmvc.pojo.CarPOJO"%>
<%@page import="java.util.List" %>
 <%
     List<CarPOJO> cars=(List<CarPOJO>)request.getAttribute("cars");
     CarPOJO pojo=(CarPOJO)request.getAttribute("car");
    String msg=(String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


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

.form-group span {
    display: inline-block;
    margin-bottom: 5px;
}

.form-group input[type="text"] {
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
/* Style for the form container */
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

.form-group input[type="text"] {
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

</style>
</head>
<body>
     <div align="center">
       <%if(pojo==null){
    	  %>
    	 <div class="form-container">
        <h2>Select a Car</h2>
        <form action="./update" method="post">
            <div class="form-group">
                <label for="car_id">Enter ID</label>
                <input type="text" id="car_id" name="car_id">
            </div>
            <input type="submit" value="SELECT" class="btn">
        </form>
    </div>
       <%if(msg !=null){
    	   %>
    	   <h4><%=msg %></h4>
    	   <%} %>
    	    <%
     if(cars !=null){
       %>
      <div class="table-container">
      <table class="car-table">
        <tr>
          <td>Car_ID</td>
          <td>NAME</td>
          <td>Model</td>
          <td>Brand</td>
          <td>Fuel_Type</td>
          <td>Price</td>
        </tr>
        <% for(CarPOJO car:cars){ %>
         <tr>
          <td><%=car.getCar_id() %></td>
          <td><%=car.getName() %></td>
          <td><%=car.getModel() %></td>
          <td><%=car.getBrand() %></td>
          <td><%=car.getFuel_type() %></td>
          <td><%=car.getPrice() %></td>
        </tr>
        <%} %>
      </table>
      
      </div>
    <% }
	 
     } else{%>
     
      <div class="form-container">
        <h2>Update Car</h2>
        <form action="./updateCar" method="post">
            <div class="form-group">
                <label for="car_id">ID</label>
                <span><%= pojo.getCar_id() %></span>
                <input type="text" name="car_id" value="<%= pojo.getCar_id() %>" hidden="true">
            </div>
            <div class="form-group">
                <label for="name">NAME</label>
                <input type="text" name="name" value="<%= pojo.getName() %>">
            </div>
            <div class="form-group">
                <label for="brand">BRAND</label>
                <input type="text" name="brand" value="<%= pojo.getBrand() %>">
            </div>
            <div class="form-group">
                <label for="model">MODEL</label>
                <input type="text" name="model" value="<%= pojo.getModel() %>">
            </div>
            <div class="form-group">
                <label for="fuel_type">FUELTYPE</label>
                <input type="text" name="fuel_type" value="<%= pojo.getFuel_type() %>">
            </div>
            <div class="form-group">
                <label for="price">PRICE</label>
                <input type="text" name="price" value="<%= pojo.getPrice() %>">
            </div>
            <input type="submit" value="UPDATE" class="btn">
        </form>
    </div>	
      <%} %>
     </div>
</body>
</html>