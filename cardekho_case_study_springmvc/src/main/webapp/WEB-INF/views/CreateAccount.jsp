<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div align="center">
    <fieldset>
     <legend>Create Account Page</legend>
    <form action="./createAccount" method="post">
     <table>
      <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
      
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password"></td>
      
      </tr>
     </table>
       <input type="submit" value="create Account">
    
    </form>
    </fieldset>
   
  </div>
</body>
</html>