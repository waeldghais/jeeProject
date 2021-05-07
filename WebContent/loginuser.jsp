<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.login==null }">
	<div class="col p-3 mb-2  text-white" >
  			
			<div class="d-flex justify-content-between p-3 mb-2 bg-secondary text-white">
			<a href="./register.jsp" class="text-white">Register User</a>
			<a href="./home.jsp" class="text-white">Home Page</a>
			<a href="./loginAdmin.jsp" class="text-white">Login Admin</a>
			</div>
		</div> 
		
<div class="container " >
<div class="text-center card bg-primary mb-3">
		<form method="post" action="./UserController" class="center">
		<input type="hidden" name="action" value="LoginUser">
		<div class="center container">
	<div class="form-group">
<label for="exampleInputEmail1">Email</label>
<input type="email" name="email" class="form-control" >
</div>
<div class="form-group">
<label for="exampleInputPassword1">Password</label>
<input type="password" name="passsword" class="form-control" >
</div>
<button type="submit" class="btn btn-secondary">login</button>
</div>
</form>
</div>
</div>
	
	</c:when>
	<c:when test="${sessionScope.login!=null }">
	<c:redirect url="./home.jsp">
	
	</c:redirect>
	</c:when>

</c:choose>
</body>
</html>