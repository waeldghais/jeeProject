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
     url="jdbc:mysql://localhost:3306/test"  
     user="root"  password="0000"/> 
<c:choose>
	<c:when test="${sessionScope.loginAdmin!=null }">
		<sql:query dataSource="${db}" var="rs">  
			SELECT * from admin where Email='${sessionScope.loginAdmin}';  
		</sql:query>  
		<c:forEach var="name" items="${rs.rows}">
				<div class="d-flex justify-content-between p-3 mb-2 bg-secondary text-white"><h3>Welcome: ${name.fname} ${name.lname}</h3>
				<a href="DashbordAdmin.jsp">Dashbord Home</a></div>
		</c:forEach> 
	<c:choose>
	<c:when test="${sessionScope.Sidevn!=null }">
	<sql:query dataSource="${db}" var="rs">  
			SELECT * from evenment where idEvn='${sessionScope.Sidevn}';  
		</sql:query> 
		<c:forEach var="even" items="${rs.rows}">
			<div class="container " >
				<form method="post" action="./EvenController">
				<input type="hidden" name="action" value="UpdateEv">
					<div class="form-group">
						<label for="exampleInputEmail1">Name Even:</label>
						<input type="text" name="Ename" class="form-control" value="${even.name}">
					</div>
					<div class="form-group">
					<label for="exampleInputEmail1">Descr Even:</label>
						<textarea rows="8" " name="Edescr" class="form-control" >${even.description}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Date Even</label>
						<input type="date" id="start" name="Edate"
						       value="${even.dateEvn}"
						       min="2021-01-01" max="2021-12-31" class="form-control">
					</div>
					
					<button type="submit" class="btn btn-primary" >Add</button>
			</form>
		</div>
		</c:forEach>
		</c:when>
		<c:when test="${sessionScope.Sidevn==null }">
	<c:redirect url="./home.jsp">
	
	</c:redirect>
	</c:when>
		</c:choose>
	</c:when>
	<c:when test="${sessionScope.loginAdmin==null }">
	<c:redirect url="./home.jsp">
	
	</c:redirect>
	</c:when>
</c:choose>
</body>
</html>