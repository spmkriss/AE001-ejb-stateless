<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todo's</title>
</head>
<body>
	<h2>Hello World</h2>
	
	<form action="${pageContext.request.contextPath}" method="post">
		<input type="text" name="taskName" placeholder="Task Name" />
		<input type="text" name="taskDesc" placeholder="description" />
		<input type="submit" name="add" />
	</form>
	
	
	<c:if test="${not empty tasks}">
		<ul>
			<c:forEach var="task" items="${tasks}">
				<li><c:out value="${task.name }" />   <c:out value="${task.description }" /></li>
			</c:forEach>
		</ul>
	</c:if>

</body>
</html>