<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:forEach var="guestbook" items="${dtoList}" >
    <span>${guestbook.articleno }</span>
    <span>${guestbook.subject }</span>
    <span>${guestbook.content }</span>
    <br>
</c:forEach>
</body>
</html>
