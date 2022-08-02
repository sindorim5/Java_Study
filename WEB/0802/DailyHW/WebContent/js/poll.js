document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("btn-add").addEventListener("click", function () {
        appendChild();
    })

    let listDiv = document.getElementById("pollAnswerList");

    // 자식노드 추가
    function appendChild() {
        // <div></div>
        let divElement = document.createElement("div");
        divElement.setAttribute("class", "pollAnswerItem");

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
            //buttonElement의 parent는 listDiv
            let parent = this.parentNode;
            listDiv.removeChild(parent);
        });

        // divElement에 추가
        divElement.appendChild(inputElement);
        divElement.appendChild(buttonElement);

        // listDiv에 divElement 추가
        listDiv.appendChild(divElement)
    }

    // 투표 만들기
    document.querySelector("#btn-make").addEventListener("click", function () {
        var question = document.querySelector("#question").value;
        if (!question) {
            alert("질문 내용 입력!!!");
            return;
        }

        var answers = document.getElementsByName("answer");
        for (var i = 0; i < answers.length; i++) {
            if (!answers[i].value) {
                alert("답변 항목 입력!!!");
                return;
            }
        }
        var answerArr = [];
        for (var i = 0; i < answers.length; i++) {
            answerArr.push(answers[i].value);
        }

        //  localStorage에 저장.
        localStorage.setItem('question', question);
        //  Javascript Object을 JSON 문자열로 변환
        localStorage.setItem('answers', JSON.stringify(answerArr));
        alert('투표를 생성합니다.');
        opener.location.reload();
        self.close();
    });
})
