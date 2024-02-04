<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jspiders.cardekho_case_study_springmvc.pojo.CarPOJO"%>
    <%@page import="java.util.List" %>
     <jsp:include page="Navbar.jsp"/>
     <%
       List<CarPOJO> cars=(List<CarPOJO>)request.getAttribute("cars");
       String msg=(String)request.getAttribute("msg");
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
     
          <h2>Remove Car</h2>
           <div class="form-container">
           
           <form action="./remove" method="post">
              
            <div class="form-group">
                <label for="id">Enter ID</label>
                <input type="text" id="id" name="car_id">
            </div>
            <input type="submit" value="REMOVE" class="btn">
       
          
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
      <%} %>
    
    </div>
</body>
</html>