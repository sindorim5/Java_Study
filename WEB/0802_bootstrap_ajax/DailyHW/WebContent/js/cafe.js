document.addEventListener("DOMContentLoaded", function () {
    let loginToken = localStorage.getItem("loginToken");

    if (!loginToken) {
        document.getElementById("logout").style.display = "none";
        document.getElementById("myPage").style.display = "none";
        document.getElementById("admin").style.display = "none";
        document.getElementById("profileImg").style.display = "none";

        document.getElementById("seoulItemSub").style.display = "none";
        document.getElementById("daejeonItemSub").style.display = "none";
        document.getElementById("gumiItemSub").style.display = "none";
        document.getElementById("kwangjuItemSub").style.display = "none";
    } else {
        document.getElementById("login").style.display = "none";
        document.getElementById("signIn").style.display = "none";
        document.getElementById("noImg").style.display = "none";
        document.getElementById("logout").style.display = "block";
        document.getElementById("myPage").style.display = "block";
        document.getElementById("admin").style.display = "block";
        document.getElementById("profileImg").style.display = "inline";

        document.getElementById("seoulItemSub").style.display = "none";
        document.getElementById("daejeonItemSub").style.display = "none";
        document.getElementById("gumiItemSub").style.display = "none";
        document.getElementById("kwangjuItemSub").style.display = "none";
    }


    document.querySelector('#login').onclick = function () {
        let id = "ssafy";
        let pw = "1234";
        var inputId = prompt('아이디입력');
        var inputPw = prompt('비밀번호입력');

        if (id == inputId && pw == inputPw) {
            alert('로그인 성공!!!');
            document.getElementById("login").style.display = "none";
            document.getElementById("signIn").style.display = "none";
            document.getElementById("noImg").style.display = "none";
            document.getElementById("logout").style.display = "block";
            document.getElementById("myPage").style.display = "block";
            document.getElementById("admin").style.display = "block";
            document.getElementById("profileImg").style.display = "inline";
            localStorage.setItem("loginToken", 1);
        } else {
            alert('로그인 실패!!!');
        }
    }

    document.querySelector('#logout').onclick = function () {
        document.getElementById("login").style.display = "block";
        document.getElementById("signIn").style.display = "block";
        document.getElementById("noImg").style.display = "block";
        document.getElementById("logout").style.display = "none";
        document.getElementById("myPage").style.display = "none";
        document.getElementById("admin").style.display = "none";
        document.getElementById("profileImg").style.display = "none";
        alert('로그아웃 되었습니다.');
    }

    document.getElementById("allStore").addEventListener("click", allStoreToggle);

    function allStoreToggle() {
        if (document.getElementById("allStore").textContent == '전국매장펼치기') {
            document.getElementById("allStore").textContent = '전국매장접기'
            document.getElementById("seoulItemSub").style.display = "block";
            document.getElementById("daejeonItemSub").style.display = "block";
            document.getElementById("gumiItemSub").style.display = "block";
            document.getElementById("kwangjuItemSub").style.display = "block";
        } else {
            document.getElementById("allStore").textContent = '전국매장펼치기'
            document.getElementById("seoulItemSub").style.display = "none";
            document.getElementById("daejeonItemSub").style.display = "none";
            document.getElementById("gumiItemSub").style.display = "none";
            document.getElementById("kwangjuItemSub").style.display = "none";
        }
    }

    document.querySelector('#seoul').onclick = function () {
        if (document.getElementById("seoulItemSub").style.display === "none"){
            document.getElementById("seoulItemSub").style.display = "block";
        } else {
            document.getElementById("seoulItemSub").style.display = "none"
        }
    }

    document.querySelector('#daejeon').onclick = function () {
        if (document.getElementById("daejeonItemSub").style.display === "none"){
            document.getElementById("daejeonItemSub").style.display = "block";
        } else {
            document.getElementById("daejeonItemSub").style.display = "none"
        }
    }

    document.querySelector('#gumi').onclick = function () {
        if (document.getElementById("gumiItemSub").style.display === "none"){
            document.getElementById("gumiItemSub").style.display = "block";
        } else {
            document.getElementById("gumiItemSub").style.display = "none"
        }
    }

    document.querySelector('#kwangju').onclick = function () {
        if (document.getElementById("kwangjuItemSub").style.display === "none"){
            document.getElementById("kwangjuItemSub").style.display = "block";
        } else {
            document.getElementById("kwangjuItemSub").style.display = "none"
        }
    }


    // pollmake.html
    document.querySelector('#admin').onclick = function () {
        window.open('pollmake.html', 'poll', 'width=500,height=300,top=300,left=400');
    }

    let question = localStorage.getItem("question");
    if (question) {
        makeHtml();
    }

    //기존 html을 대체
    function makeHtml() {
        var answers = localStorage.getItem('answers');
        //JSON 문자열 -> javascript object
        var answersArr = JSON.parse(answers);
        var len = answersArr.length;
        var poll = `
            <div class="vote_title">[ 당신의 선택 ]</div>
            <div class="vote_question">${question}</div>
            <div class="vote_answer">
                <ul>
            `;
        for (var i = 0; i < len; i++) {
            poll += `
                <li>
                    <label><input type="radio" name="vote_answer" value="${answersArr[i]}" /> ${answersArr[i]}</label>
                </li>
            `;
        }
        poll += `
                </ul>
            </div>
            <div class="vote_button">
                <button id="voteBtn" class="button btn_primary">투표하기</button>
                <button class="button">결과보기</button>
            </div>
            <div class="vote_date">투표기간 : 22.08.01 ~ 22.08.31</div>
            `;
        //기존 html 대체
        document.getElementById("vote").innerHTML = poll;
    }

    //투표하기.
    document.querySelector("#voteBtn").onclick = function () {
        var votes = document.getElementsByName("vote_answer");
        var selMenu = "";

        for (var i = 0; i < votes.length; i++) {
            if (votes[i].checked) {
                selMenu = votes[i].value;
                break;
            }
        }
        alert(selMenu + '를 선택했습니다.');
    };
});


