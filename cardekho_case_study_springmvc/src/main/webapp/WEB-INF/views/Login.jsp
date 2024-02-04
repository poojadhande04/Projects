<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
 <style>
        * {
            box-sizing: border-box;
        }

        h2 {
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        }

        body {
            /* background-image: url(./beach\ img.jpg);*/
          background: rgb(63,94,251);
background: radial-gradient(circle, rgba(63,94,251,1) 0%, rgba(252,70,107,1) 100%);
             background-position:center;
            background-repeat: no-repeat;
            background-size: cover;
        }
       #parent {
            position: center;
            height: 600px;
            width: 500px;
            margin:auto;
            border-radius:10px;
            /* border: 1px solid; */
            color:white;
            box-shadow: 3px 3px 10px purple;
            padding: 30px;
           /* margin: 150px 20px 50px 450px;*/
            text-align:center;
            background:rgba(0,0,0,0.5);
            box-shadow: -5px -5px rgba(0, 0,0, 0.5);
           background-position:center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        #first {
            height: 20px;
            width: 20px;
            border: 1px solid;
            background-color: dodgerblue;
            box-shadow:2px 2px 5px white ;  

        }

        #second {
            height: 20px;
            width: 20px;
            border: 1px solid;
            background-color: dodgerblue;
            box-shadow: 2px 2px 5px white;
        }

        #third {
            height: 20px;
            width: 20px;
            border: 1px solid;
            background-color: dodgerblue;
            box-shadow:2px 2px 6px white ;  

        }

       
        .input {
            display: inline-block;
            width: 100%;
         }

        .inp-field {
            /* height:70%; */
            width: 50%;
            padding:10px;
           box-shadow: 0px 0px 5px black;
            border:1 px solid;
            border-radius: 5px;
            margin-top: 15px;
            outline: none;
        }

        .btn {
            padding: 10px 15px 10px 20px;
            border-radius: 40px;
            margin: 10px  auto;
            text-align: center;
            background-color:cornflowerblue;
            box-shadow: 2px 2px 5px white; 
        }

        #icon {
            margin-top: 20px;
            padding-left: 30px;
            font-size: 40px;
            

        }
        #forget{
            margin-left:120px;
        }
    </style>
</head>
<body>
 <div align="center">
  <%
   if(msg !=null){
	   
 %>
 <h4>
 <%=msg %>
 </h4>
 <%  } %>
     <div id="parent">
        <form action="./login" method="post">
            <h2>Registration Form</h2>
            <div class="input">
                <i id="first" class="fa fa-user" aria-hidden="true"></i>
                <input class="inp-field" type="text" name="username" placeholder="Username"><br>

                 <i id="third" class="fa fa-key" aria-hidden="true"></i>
                <input class="inp-field" type="password" name="password" id="" placeholder="Password"><br>
                <label for="" id="forget">forget password?</label><br>
                 <button type="submit" class="btn">Login</button>
              
               <div id="icon">
        <i class="fa fa-instagram" aria-hidden="true" style="background-color: hotpink;"><a href="https://www.instagram.com/"></a></i>
        <i class="fa fa-facebook-official" aria-hidden="true" style="color:white"><a href="https://www.facebook.com/"></a></i>
        <i class="fa fa-skype" aria-hidden="true" style="background-color: deepskyblue;"><a href="https://www.skype.com/en/"></a></i>
                </div>
            </div>
        </form>
    </div>
      <a href="http://localhost:8080/cardekho_case_study_springmvc/createAccount">Create Account</a>
  </div>
</body>
</html>