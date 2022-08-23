<template>
  <div class="regist">
      <h1 class="underline">SSAFY 도서 수정</h1>
      <div class="regist_form">
      <label for="isbn">도서번호</label>
      <input
          type="number"
          :disabled="0"
          id="isbn"
          name="isbn"
          ref="isbn"
          :placeholder="book.isbn"
      />{{isbn}}<br />
      <label for="title">도서명</label>
      <input
          type="text"
          id="title"
          name="title"
          ref="title"
          v-model="title"
          :placeholder="book.title"
      /><br />
      <label for="author">저자</label>
      <input
          type="text"
          id="author"
          name="author"
          ref="author"
          v-model="author"
          :placeholder="book.author"
      /><br />
      <label for="price">가격</label>
      <input
          type="number"
          id="price"
          name="price"
          ref="price"
          v-model="price"
          :placeholder="book.price"
      /><br />
      <label for="content">설명</label>
      <br />
      <textarea
          id="content"
          name="content"
          ref="content"
          v-model="content"
          cols="35"
          rows="5"
          :placeholder="book.content"
      ></textarea
      ><br />
      <button @click="checkValue">수정</button>
      <button @click="moveList">목록</button>
      </div>
  </div>
</template>

<script>
export default {
  name: 'BookModify',
  data() {
    return {
      book: {},
      isbn: "",
      title: "",
      author: "",
      price: "",
      content: "",
    };
  },
  created() {
    const params = new URL(document.location).searchParams;
    let tempBook = localStorage.getItem(params.get("isbn"));
    this.book = JSON.parse(tempBook);
  },
  methods: {
    // 입력값 체크하고 저장.
    checkValue() {
      if (!this.title) {
        this.title = this.book.title;
      }
      if (!this.author) {
        this.author = this.book.author;
      }
      if (!this.price) {
        this.price = this.book.price;
      }
      if (!this.content) {
        this.content = this.book.content;
      }
      this.register();
    },
    register() {
      let userBook = {
        isbn: this.book.isbn,
        title: this.title,
        author: this.author,
        price: this.price,
        content: this.content,
      };
      localStorage.setItem(this.book.isbn, JSON.stringify(userBook));
      this.moveList();
    },
    moveList() {
      location.href = "list.html";
    },
  },
}
</script>
