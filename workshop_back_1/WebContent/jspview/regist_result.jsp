<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.backend.dto.Book"%>
<!DOCTYPE html>
<html>
<head>
<%
Book bookDto = (Book) request.getAttribute("bookinfo");
if(bookDto == null) {
%>
<script>
alert("Book 정보가 없습니다.");
</script>
<%    
} else {
%>

<meta charset="UTF-8">
<title>책정보(book)</title>
</head>
<body>
<div>
<h3>[<%= bookDto.getTitle() %>] 정보</h3>
ISBN : <%= bookDto.getIsbn() %><br>
저자 : <%= bookDto.getAuthor() %><br>
가격 : <%= bookDto.getPrice() %>원<br>
설명 : <%= bookDto.getDesc() %><br>
</div>
<%
}
%>
</body>
</html>