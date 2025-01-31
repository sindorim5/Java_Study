export default {
    template: `
    <div class="content">
    <!-- 왼쪽 Content Start  -->
    <div class="content_left">
      <!-- 프로필 사진 Start  -->
      <div class="profile">
        <img class="profile_img" src="img/noimg.png" alt="" />
        <img class="profile_img" src="img/profile.png" alt="" />
      </div>
      <!-- 프로필 사진 End  -->
      <!-- 메뉴 Start  -->
      <div class="store_title">
        <div class="store_display">전국매장펼치기</div>
        <div class="store_display" style="display: none">전국매장접기</div>
        <ul class="store_item">
          <li>
            <a class="store_area">서울</a>
            <div class="store_item_sub">
              <ul>
                <li>역삼점</li>
                <li>선릉점</li>
              </ul>
            </div>
          </li>
          <li>
            <a class="store_area">대전</a>
            <div class="store_item_sub">
              <ul>
                <li>학하점</li>
                <li>봉명점</li>
              </ul>
            </div>
          </li>
          <li>
            <a class="store_area">구미</a>
            <div class="store_item_sub">
              <ul>
                <li>인동점</li>
                <li>공단점</li>
              </ul>
            </div>
          </li>
          <li>
            <a class="store_area">광주</a>
            <div class="store_item_sub">
              <ul>
                <li>하남산단점</li>
                <li>광주역점</li>
              </ul>
            </div>
          </li>
        </ul>
      </div>
      <!-- 메뉴 End  -->
      <!-- 설문조사 Start  -->
      <div class="vote">
        <div class="vote_title">[ 당신의 선택 ]</div>
        <div class="vote_question">공부하고 싶은 분야를 골라 주세요!!!</div>
        <div class="vote_answer">
          <ul>
            <li>
              <input type="radio" name="vote_answer" id="" />
              <img src="img/poll/python.png" alt="" /> Python
            </li>
            <li>
              <input type="radio" name="vote_answer" id="" />
              <img src="img/poll/html5.png" alt="" /> HTML5
            </li>
            <li>
              <input type="radio" name="vote_answer" id="" />
              <img src="img/poll/vuejs.png" alt="" /> Vue.js
            </li>
            <li>
              <input type="radio" name="vote_answer" id="" />
              <img src="img/poll/java.png" alt="" /> Java
            </li>
          </ul>
        </div>
        <div class="vote_button">
          <button class="button btn_primary">투표하기</button>
          <button class="button">결과보기</button>
        </div>
        <div class="vote_date">투표기간 : 21.03.01 ~ 21.03.31</div>
      </div>
      <!-- 설문조사 End  -->
    </div>
    <!-- 왼쪽 Content End  -->

    <!-- 중앙 Content Start  -->
    <div class="content_body">
      <!-- 프로그래밍 Section Start  -->
      <section class="menu">
        <h3 class="menu_title">[ 프로그래밍 언어 ]</h3>
        <ul>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/p_book01.png" alt="" />
              </div>
              <div class="menu_item_info">Do it! 점프 투 파이썬<br />(18,800원)</div>
            </div>
          </li>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/p_book02.png" alt="" />
              </div>
              <div class="menu_item_info">HTML5 API 프로그래밍<br />(23,000원)</div>
            </div>
          </li>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/p_book03.png" alt="" />
              </div>
              <div class="menu_item_info">백견불여일타 Vue.js입문<br />(22,000원)</div>
            </div>
          </li>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/p_book04.png" alt="" />
              </div>
              <div class="menu_item_info">Java 프로그래밍<br />(26,500원)</div>
            </div>
          </li>
        </ul>
      </section>
      <!-- 프로그래밍 Section End  -->

      <!-- 에세이 Section Start  -->
      <section class="menu">
        <h3 class="menu_title">[ 에세이 ]</h3>
        <ul>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/e_book01.png" alt="" />
              </div>
              <div class="menu_item_info">2인조<br />(14800원)</div>
            </div>
          </li>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/e_book02.png" alt="" />
              </div>
              <div class="menu_item_info">안녕, 소중한 사람<br />(15,000원)</div>
            </div>
          </li>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/e_book03.png" alt="" />
              </div>
              <div class="menu_item_info">꽃을 보든 너를 본다<br />(10,000원)</div>
            </div>
          </li>
          <li>
            <div class="menu_item">
              <div class="menu_item_img">
                <img src="img/book/e_book04.png" alt="" />
              </div>
              <div class="menu_item_info">곰돌이 푸, 행복한 일은 매일 있어 (12,000원)</div>
            </div>
          </li>
        </ul>
      </section>
      <!-- 에세이 Section End  -->

      <section class="article">
        <!-- 인기글 Article Start  -->
        <article class="article_popular">
          <h3>[ 인기글 ]</h3>
          <table class="table table_striped">
            <thead>
              <tr>
                <th class="title">제목</th>
                <th>작성자</th>
                <th>조회수</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>자바공부 쉽게하는법!!</td>
                <td>이쎄림</td>
                <td>1756</td>
              </tr>
              <tr>
                <td>알고리즘은 자바? 파이썬?</td>
                <td>홍정밍</td>
                <td>998</td>
              </tr>
              <tr>
                <td>스프링 정복하기~</td>
                <td>김나켠</td>
                <td>856</td>
              </tr>
            </tbody>
          </table>
        </article>
        <!-- 인기글 Article End  -->

        <!-- 최신글 Article Start  -->
        <article class="article_new">
          <h3>[ 최신글 ]</h3>
          <table class="table table_bordered table_hover">
            <thead>
              <tr>
                <th class="title">제목</th>
                <th>작성자</th>
                <th>조회수</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>web 관련 질문있어요.</td>
                <td>이주녕</td>
                <td>12</td>
              </tr>
              <tr>
                <td>vuejs는 이렇게 공부해보세요.</td>
                <td>조밍기</td>
                <td>98</td>
              </tr>
              <tr>
                <td>꽃길만 걸어요.</td>
                <td>류해면</td>
                <td>56</td>
              </tr>
            </tbody>
          </table>
        </article>
        <!-- 최신글 Article End  -->
      </section>
    </div>
    <!-- 중앙 Content End  -->
  </div>
    `
}
