<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.move.BookDto, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<c:if test="${bookinfo == null}">

<script>
alert("Book 정보가 없습니다.");
</script>

</c:if>

<c:if test="${bookinfo != null}">
    <title>책정보(book_el.jsp)</title>
    </head>
    <body>
    <div>
        <h3>[${bookinfo.bookName}] 정보</h3>
        ISBN : ${bookinfo.getIsbn()} <br>
        출판사 : ${bookinfo.getPublisher()} <br>
        가격 : ${bookinfo.price}원<br>
    </div>
</c:if>
</body>
</html>