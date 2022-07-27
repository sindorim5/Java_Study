<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.move.BookDto, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%
ArrayList<BookDto> bookList = (ArrayList<BookDto>) request.getAttribute("bookList");
if(bookList == null) {
%>
<script>
alert("Book 정보가 없습니다.");
</script>
<%    
} else {
%>

<meta charset="UTF-8">
<title>책정보(booklist.jsp)</title>
</head>
<body>
<div>
    <% for (BookDto bookDto : bookList){ %>
        <h3>[<%= bookDto.getBookName() %>] 정보</h3>
        ISBN : <%= bookDto.getIsbn() %><br>
        출판사 : <%= bookDto.getPublisher() %><br>
        가격 : <%= bookDto.getPrice() %>원<br>
        </div>
    <%} %>
<%
}
%>
</body>
</html>