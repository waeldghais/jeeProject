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
     url="jdbc:mysql://localhost:3306/test"  
     user="root"  password="0000"/> 
<c:choose>
	<c:when test="${sessionScope.login!=null }">
	  
		
		<div class="d-flex justify-content-between p-3 mb-2 bg-secondary text-white"><h3><a href="home.jsp">Home</a></h3>
		<form action="./UserController" method="post">
				<input type="hidden" name="action" value="LogoutUser">
				<button type="submit" class="btn btn-primary">Logout</button>
			</form>
		</div>

		 
		
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
    <sql:query dataSource="${db}" var="rss">  
SELECT * from evenment where idEvn='${param.ide}';
</sql:query>  
<c:forEach var="name" items="${rss.rows}">
<div class="card text-white bg-primary mb-3">
<div class="card-body">
<div class="container">
  <div class="row">
    <div class="col-sm">
      <img src="${name.imgEvn}" width="300" height="200">
    </div>
    <div class="col-sm">
      <h3>${name.name}</h3>
      <p>${name.description}</p>
      <p>Date: ${name.dateEvn}</p>
    </div>
    
  </div>
</div>
	
    
   </div>
  </div>
	 	
	 	  
  		</c:forEach> 

  

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
  <c:choose>
	<c:when test="${sessionScope.login!=null }">
	<div class="container " >



<div class="text-center card bg-primary mb-3">
	<form action="./CommentaireController" method="post">
	
  <div class="form-group">
   <input type="hidden" name="action" value="addfeed">
    <input type="text" class="form-control" name="Feedback">
  </div>
   
  <button type="submit" class="btn btn-primary">Feedback</button>
  
 
</form>
</div>
</div>
	</c:when>
	</c:choose>
</body>
</html>