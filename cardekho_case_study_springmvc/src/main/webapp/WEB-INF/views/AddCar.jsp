<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jspiders.cardekho_case_study_springmvc.pojo.CarPOJO" %>
     <jsp:include page="Navbar.jsp"/>
     <%@page import="java.util.List" %>
     <% String msg=(String)request.getAttribute("msg"); 
        List<CarPOJO> cars=(List<CarPOJO>)request.getAttribute("cars");
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

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

/* Style for form groups */
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

/* Style for the submit button */
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
		<div class="form-container">
        <h2>Add a Car</h2>
        <form action="./add" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="brand">Brand</label>
                <input type="text" id="brand" name="brand" required>
            </div>
            <div class="form-group">
                <label for="model">Model</label>
                <input type="text" id="model" name="model" required>
            </div>
            <div class="form-group">
                <label for="fuelType">Fuel Type</label>
                <input type="text" id="fuel_type" name="fuel_type" required>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input type="text" id="price" name="price" required>
            </div>
            <input type="submit" value="ADD" class="btn">
        </form>
    </div>
       <%if(msg !=null){
    	   
        %>
        <h4><%=msg %></h4>
        <%} %>
        <%
     if(cars !=null){
       %>
      <div  class="table-container">
       <table class="car-table" >
        <tr>
          <td>ID</td>
          <td>NAME</td>
          <td>EMAIL</td>
          <td>CONTACT</td>
          <td>ADDRESS</td>
        </tr>
        <% for(CarPOJO pojo:cars){ %>
         <tr>
          <td><%=pojo.getCar_id() %></td>
          <td><%=pojo.getName() %></td>
          <td><%=pojo.getModel() %></td>
          <td><%=pojo.getBrand() %></td>
           <td><%=pojo.getFuel_type() %></td>
          <td><%=pojo.getPrice() %></td>
        </tr>
        <%} %>
      </table>
      
      </div>
    <% } %>
    </div>
</body>
</html>