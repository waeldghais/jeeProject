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
	<c:when test="${sessionScope.loginAdmin!=null }">
	<sql:query dataSource="${db}" var="rs">  
SELECT * from admin where Email='${sessionScope.loginAdmin}';  
</sql:query>  
		<c:forEach var="name" items="${rs.rows}">
		<div class="d-flex justify-content-between p-3 mb-2 bg-secondary text-white"><h3>Welcome: ${name.fname} ${name.lname}</h3>
		<a href="./LogoutAdmin">Logout</a></div>
		</c:forEach> 
		 <h1>Dashbord Admin</h1>

<form method="get" action="./AddEven">

<button type="submit" class="btn btn-primary btn-sm">Add Even</button>
</form>

<sql:query dataSource="${db}" var="rs">  
SELECT * from evenment ;  
</sql:query>  
   <c:if test="${empty rs.rows}">
    Not Even
</c:if>
<c:if test="${not empty rs.rows}">
    <table border="2" width="100%">  
<tr>  
 
<th>Name Even</th>  
<th>Descr Even</th>  
<th>date of Even</th>  
<th>image</th>
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
 
<td><c:out value="${table.name}"/></td>  
<td><c:out value="${table.description}"/></td>  
<td><c:out value="${table.dateEvn}"/></td>  
<td><img src=<c:out value="${table.imgEvn}"/>  width="40" height="40"></td> 
</tr>  
</c:forEach>  
</table>
</c:if>

		
	</c:when>
	<c:when test="${sessionScope.loginAdmin==null }">
		<c:redirect url="./loginAdmin.jsp">
	
	</c:redirect>
		</c:when>
	
	
</c:choose>

</body>
</html>