document.addEventListener("DOMContentLoaded", function () {
  // 1. local storage에 내용을 읽는다. 
  // 읽은 값이 없으면 
  //    "투표만들기" (id:make-new-vote) div 노출
  //    "진행중인 투표가 없습니다.(id:empty-vote) div 노출
  // 있으면 id:vote div 노출
  let question = localStorage.getItem('question');
  if (question) {
    //style.display  none, block 처리
    document.getElementById("make-new-vote").style.display = "none";
    document.getElementById("empty-vote").style.display = "none";
    document.getElementById("vote").style.display = "block";
    makeHtml();
  } else {
    //style.display  none, block 처리
    document.getElementById("make-new-vote").style.display = "block";
    document.getElementById("empty-vote").style.display = "block";
    document.getElementById("vote").style.display = "none";

    openPollWindow();
  }

  function openPollWindow() {
    document.getElementById("btn-makepoll").addEventListener("click", function () {
      window.open('makepoll.html', 'poll', 'width=500,height=300,top=300,left=400');
    })
  }
  

  //기존 html을 대체함. 
  function makeHtml() {
    var answers = localStorage.getItem('answers');
    //JSON 문자열 -> javascript object
    var answersArr = JSON.parse(answers);
    var len = answersArr.length;
    var poll = `
        <div class="vote-title">[ 당신의 선택 ]</div>
        <div class="vote-question">${question}</div>
        <div class="vote-answer">
          <ul>
      `;
    for (var i = 0; i < len; i++) {
      poll += `
            <li>
              <label><input type="radio" name="vote-answer" value="${answersArr[i]}" /> ${answersArr[i]}</label>
            </li>
        `;
    }
    poll += `
          </ul>
        </div>
        <div class="vote-button">
          <button id="btn-poll" class="button btn-primary">투표하기</button>
          <button class="button">결과보기</button>
        </div>
        <div class="vote-date">투표기간 : 22.08.01 ~ 22.08.31</div>
      `;
    //기존 html 대체
    document.getElementById("vote").innerHTML = poll;
  }

  //투표하기. //<button id="btn-poll" ...
  document.querySelector('#btn-poll').onclick = function () {
    var votes = document.getElementsByName('vote-answer');
    var selMenu = '';

    for (var i = 0; i < votes.length; i++) {
      if (votes[i].checked) {
        selMenu = votes[i].value;
        break;
      }
    }
    alert(selMenu + '를 선택했습니다.');
  };

});
