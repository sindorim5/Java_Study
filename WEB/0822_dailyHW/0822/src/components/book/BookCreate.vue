<template>
  <div class="regist">
    <h1 class="underline">SSAFY 도서 등록</h1>
    <div class="regist_form">
      <label for="isbn">도서번호</label>
      <input type="number" id="isbn" name="isbn" ref="isbn" v-model="isbn" /><br />
      <label for="title">도서명</label>
      <input type="text" id="title" name="title" ref="title" v-model="title" /><br />
      <label for="author">저자</label>
      <input type="text" id="author" name="author" ref="author" v-model="author" /><br />
      <label for="price">가격</label>
      <input type="number" id="price" name="price" ref="price" v-model="price" /><br />
      <label for="content">설명</label>
      <br />
      <textarea
        id="content"
        name="content"
        ref="content"
        cols="35"
        rows="5"
        v-model="content"
      ></textarea
      ><br />
      <button @click="checkValue">등록</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookCreate',
  data() {
    return {
      isbn: "",
      title: "",
      author: "",
      price: "",
      content: "",
    };
  },
  methods: {
    checkValue() {
      if (!this.isbn) {
        alert("도서번호 입력!");
      } else if (!this.title) {
        alert("도서명 입력!");
      } else if (!this.author) {
        alert("저자 입력!");
      } else if (!this.price) {
        alert("가격 입력!");
      } else if (!this.content) {
        alert("설명 입력!");
      } else if (this.isbn.length != 11) {
        alert("ISBN은 11자리 숫자입니다.");
      } else {
        this.register();
      }
    },
    checkDuplication(isbn) {
      let bookKeys = Object.keys(localStorage);
      for (var i = 0; i < bookKeys.length; i++) {
        if (isbn === bookKeys[i]) {
          return 1;
        }
      }
      return 0;
    },
    register() {
      let userBook = {
        isbn: this.isbn,
        title: this.title,
        author: this.author,
        price: this.price,
        content: this.content,
      };
      if (this.checkDuplication(this.isbn) == 1) {
        alert("중복된 책이 있습니다!");
      } else {
        localStorage.setItem(this.isbn, JSON.stringify(userBook));
        this.moveList();
      }
    },

    moveList() {
      location.href = "list.html";
    },
  },
};
</script>
