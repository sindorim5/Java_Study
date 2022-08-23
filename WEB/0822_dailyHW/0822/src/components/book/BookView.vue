<template>
  <div class="regist">
  <h1 class="underline">SSAFY 도서 정보</h1>
    <div class="regist_form">
      <label for="isbn">도서번호</label>
      <div class="view">{{book.isbn}}</div>
      <label for="title">도서명</label>
      <div class="view">{{book.title}}</div>
      <label for="author">저자</label>
      <div class="view">{{book.author}}</div>
      <label for="price">가격</label>
      <div class="view">{{book.price}}</div>
      <label for="content">설명</label>
      <div class="view">{{book.content}}</div>
      <div style="padding-top: 15px">
        <a :href="'modify.html?isbn=' + book.isbn" class="btn">수정</a>
        <a :href="'delete.html?isbn=' + book.isbn" class="btn">삭제</a>
        <a href="./list.html" class="btn">목록</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      book: {},
    };
  },
  created() {
    const params = new URL(document.location).searchParams;
    let tempBook = localStorage.getItem(params.get("isbn"));
    this.book = JSON.parse(tempBook);
    console.log(this.book);
  },
  methods: {},
}
</script>
