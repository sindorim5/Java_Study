<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY - 글작성</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.ico">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script type="text/javascript">
	    window.addEventListener('DOMContentLoaded', function() {
	        document.getElementById('writeBtn').onclick = function() {
	            let userid = document.getElementById("userid").value;
	            let subject = document.getElementById("subject").value;
	            let content = document.getElementById("content").value;
	            if(userid == ""){
	                alert("작성자를 입력하세요.");
	            }else if(subject == ""){
	                alert("제목을 입력하세요.");
	            }else if(content == ""){
	                alert("내용을 입력하세요.");
	            }else{
	                document.getElementById('writeform').submit();
	            }
	        }
	    });
    </script>
</head>
<body>

<div class="container" align="center">
    <div class="col-lg-6" align="center">
        <h2>방명록 글쓰기</h2>
        <form id="writeform" method="post" action="/guestbookjsp/guestbook/articlewrite.jsp">
            <div class="form-group" align="left">
                <label for="userid">작성자:</label>
                <input type="text" class="form-control" id="userid" name="userid">
            </div>
            <div class="form-group" align="left">
                <label for="subject">제목:</label>
                <input type="text" class="form-control" id="subject" name="subject">
            </div>
            <div class="form-group" align="left">
                <label for="content">내용:</label>
                <textarea class="form-control" rows="15" id="content" name="content"></textarea>
            </div>
            <button type="button" id="writeBtn" class="btn btn-primary">글작성</button>
            <button type="reset" class="btn btn-warning">초기화</button>
        </form>
    </div>
</div>

</body>
</html>