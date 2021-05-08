<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost:3306/tpbd"  
     user="root"  password="0000"/> 
<c:choose>
	<c:when test="${sessionScope.login!=null }">
		<sql:query dataSource="${db}" var="rs">  
			SELECT * from user where email='${sessionScope.login}';  
		</sql:query>  
		<!-- if Login -->
	<c:forEach var="name" items="${rs.rows}">
		<div class="d-flex justify-content-between p-3 mb-2 bg-secondary text-white"><h3>Welcome: ${name.fname} ${name.lname}</h3>
<<<<<<< HEAD
			<form action="./UserController" method="post">
				<input type="hidden" name="action" value="LogoutUser">
				<button type="submit" class="btn btn-primary">Logout</button>
			</form>
		</div>
=======
		<a href="./LogOut">Logout</a></div>
>>>>>>> a3c3ebcd64ad5af141adf7ead316e8c725ac9d34
	</c:forEach> 
	</c:when>
	<c:when test="${sessionScope.login==null }">
		<!-- if Not Login -->
		<div class="col p-3 mb-2  text-white" >
  			
			<div class="d-flex justify-content-between p-3 mb-2 bg-secondary text-white">
			<a href="./RegisterUser.jsp" class="text-white">Register User</a>
			<a href="./loginuser.jsp" class="text-white">Login User</a>
			<a href="./loginAdmin.jsp" class="text-white">Login Admin</a>
			</div>
		</div>
	</c:when>
	
	
</c:choose>
<div class=" mx-3 bg-secondary" >
  			
<div class=" text-white text-center">
<h1 class="text-center" >Home Page</h1>
</div>
</div>


<sql:query dataSource="${db}" var="rs">  
SELECT * from evenment ;  
</sql:query>  
   
 
 
 <div class="mx-5 my-5">
 	<div class="row">
 		
 <c:forEach var="table" items="${rs.rows}"> 
 <div class="col-md-4 ">			 
  <div class="card text-white bg-primary mb-3" >
  <img class="card-img-top" src=<c:out value="${table.image}"/> width="200" height="200" alt="Card image cap">
  <div class="card-body">
  	<h5 class="card-title">${table.name}</h5>
    <p class="card-text">${table.descr}</p>
    <small>${table.date}</small>
    <br>
    <c:choose>
	<c:when test="${sessionScope.login!=null }">

	</c:when>
	</c:choose>
    <a href="./Feedback?ide=${table.idev}" style="color: red">All Feedback</a>
  </div>
</div>
</div>
</c:forEach> 
 		
 	</div>
 	<div class="row">
 	
 	</div>
 </div>
 

</body>
</html>