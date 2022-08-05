export default {
  template:`
    <div class="regist-table">
      <table style="text-align: center" border="1" style="border-collapse: collapse;">
        <tr>
          <th>도서번호</th>
          <td>
            <input type="text" :disabled="0" name="isbn" :value="book.isbn"><br />
          </td>
        </tr>
        <tr>
          <th>도서명</th>
          <td>
            <input type="text" name="title" :placeholder="'도서명을 입력하세요'" v-model="title" ><br />
          </td>
        </tr>
        <tr>
          <th>저자</th>
          <td>
            <input type="text" name="author" :placeholder="'저자를 입력하세요'" v-model="author"><br />
          </td>
        </tr>
        <tr>
          <th>가격</th>
          <td>
            <input type="number" name="price" v-model="price"><br />
          </td>
        </tr>
        <tr>
          <th>설명</th>
          <td>
            <textarea name="price" :placeholder="'설명을 입력하세요'" v-model="content" cols="35" rows="5"></textarea>
          </td>
        </tr>
      </table>
      <button v-on:click="checkValue">등록</button>
      <button v-on:click="moveList">목록</button>
    </div>
    `,
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
  methods: {
    getBook() {
      axios
        .get("http://127.0.0.1:9999/vuews/book/" + this.isbn)
        .then((response) => {
          this.book = response.data;
        })
        .catch((error) => {
          console.dir(error);
        });
    },
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
      this.updateBook();
    },
    updateBook() {
      axios
        .put("http://127.0.0.1:9999/vuews/book/" + this.isbn, {
          isbn: this.isbn, title: this.title, author: this.author, price: this.price,
          content: this.content
        })
        .then((response) => {
          alert("수정 성공")
          location.href = "./index.html#/book/list"
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    moveList() {
      location.href = "./index.html#/book/list"
    }
  },
  created() {
    this.isbn = this.$route.params.isbn;
    this.getBook();
  },
};



