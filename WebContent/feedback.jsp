<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
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
		<c:forEach var="name" items="${rs.rows}">
		<div class="d-flex justify-content-between p-3 mb-2 bg-secondary text-white"><h3><a href="home.jsp">Welcome:</a> ${name.fname} ${name.lname}</h3>
		
		<a href="./LogOut">Logout</a></div>
		</c:forEach> 
		 
		
	</c:when>
	<c:when test="${sessionScope.login==null }">
	<div class="col p-3 mb-2 bg-secondary text-white" >
  <a href="./RegisterUser.jsp">Register User</a>
		<a href="./loginuser.jsp">Login User</a>
		<a href="./loginAdmin.jsp">Login Admin</a>
		<a href="home.jsp">Home Page</a>
		</div>
	
</div>

		</c:when>
	
	
</c:choose>     
  <c:choose>
	<c:when test="${sessionScope.login!=null }">
	<div class="container " >



<div class="text-center card bg-primary mb-3">
	<form action="./CommentaireController" method="post">
	
  <div class="form-group">
   
    <input type="text" class="form-control" name="Feedback">
  </div>
   
  <button type="submit" class="btn btn-primary">Feedback</button>
  
 
</form>
</div>
</div>
	</c:when>
	</c:choose>
  

<sql:query dataSource="${db}" var="rs">  
SELECT * from feedback where idevn='${param.ide}';
</sql:query>  
		<c:forEach var="name" items="${rs.rows}">
		<div class="container " >
			<div class=" card  mb-3">
			<div class="alert alert-dismissible alert-warning">
	  			<p class="mb-0">${name.feedback}.</p>
	 		</div>
	 	</div>
	 	    </div>	
  		</c:forEach> 

</body>
</html>