<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>SSAFY-파라미터전달(Multi)</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="col-lg-5">
            <h5 class="text-center">JSP를 이용한 파라미터 전달(Multi)</h5>
            <form name="paramform" method="get" action="/jspview/multiparam.jsp">
                <div class="form-group">
                    <label for="userid">아이디:</label> <input type="text"
                        class="form-control" placeholder="아이디 입력" name="userid">
                </div>
                <div class="form-group">
                    <label for="username">이름:</label> <input type="text"
                        class="form-control" placeholder="이름 입력" name="username">
                </div>
                <div class="form-group">
                    <label for="">좋아하는 과일:</label>
                </div>
                <div class="form-group form-check">
                    <div class="form-check-inline">
                        <label class="form-check-label"> <input type="checkbox"
                            name="fruit" class="form-check-input" value="딸기">딸기
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label"> <input type="checkbox"
                            name="fruit" class="form-check-input" value="수박">수박
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label"> <input type="checkbox"
                            name="fruit" class="form-check-input" value="포도">포도
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label"> <input type="checkbox"
                            name="fruit" class="form-check-input" value="사과">사과
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>