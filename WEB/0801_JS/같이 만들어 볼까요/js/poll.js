document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("btn-add").addEventListener("click", function () {
    appendChild();
  })

  let listDiv = document.getElementById("poll-answer-list")

  //자식노드 추가
  function appendChild() {
  //   <!--div class="poll-answer-item">
  //   <input type="text" name="answer" />
  //   <button type="button" class="button">삭제</button>
  //   </div -->
    let divElement = document.createElement("div"); // <div></div>
    //<div class="poll-answer-item"></div>
    divElement.setAttribute("class", "poll-answer-item");

    //<input type="text" name="answer" />
    let inputElement = document.createElement("input");
    inputElement.setAttribute("type", "text");
    inputElement.setAttribute("name", "answer");

    //<button type="button" class="button">삭제</button>
    let buttonElement = document.createElement("button");
    buttonElement.setAttribute("type", "button");
    buttonElement.setAttribute("class", "button");
    let text = document.createTextNode("삭제");
    buttonElement.appendChild(text);

    buttonElement.addEventListener('click', function () {
      let parent = this.parentNode;  //buttonElement의 parent는 listDiv
      console.log(parent)
      listDiv.removeChild(parent);
    });

    divElement.appendChild(inputElement);
    divElement.appendChild(buttonElement);

    listDiv.appendChild(divElement)
  }


  // 투표 만들기.
  document.querySelector('#btn-make').addEventListener('click', function () {
    var question = document.querySelector('#question').value;
    if (!question) {
      alert('질문 내용 입력!!!');
      return;
    }

    var answers = document.getElementsByName('answer');
    for (var i = 0; i < answers.length; i++) {
      if (!answers[i].value) {
        alert('답변 항목 입력!!!');
        return;
      }
    }
    var answerArr = [];
    for (var i = 0; i < answers.length; i++) {
      answerArr.push(answers[i].value);
    }

    //   localStorage에 저장.
    localStorage.setItem('question', question);
    // Javascript Object -> JSON 문자열로 변환
    localStorage.setItem('answers', JSON.stringify(answerArr));

    alert('투표를 생성합니다.');
    opener.location.reload();
    self.close();
  });

})


