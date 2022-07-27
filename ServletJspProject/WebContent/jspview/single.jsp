<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>SSAFY-파라미터전달(Single)</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="col-lg-5">
            <h5 class="text-center">JSP를 이용한 파라미터 전달(Single)</h5>
            <form name="paramform" method="get" action="/jspview/singleparam.jsp">
                <div class="form-group">
                    <label for="userid">아이디:</label> <input type="text"
                        class="form-control" placeholder="아이디 입력" name="userid">
                </div>
                <div class="form-group">
                    <label for="username">이름:</label> <input type="text"
                        class="form-control" placeholder="이름 입력" name="username">
                </div>
                <div class="form-group">
                    <label for="area">지역:</label> <select name="area"
                        class="custom-select">
                        <option value="0">서울</option>
                        <option value="1">대전</option>
                        <option value="2" selected>구미</option>
                        <option value="3">광주</option>
                        <option value="4">부울경</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">전송</button>
            </form>
        </div>
    </div>
</body>
</html>