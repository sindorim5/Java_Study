export default {
  template:`
    <div class="regist-table">
      <table style="text-align: center" border="1" style="border-collapse: collapse;">
        <tr>
          <th>도서번호</th>
          <td>
            <input type="number" name="isbn" v-model="isbn" :placeholder="'10자리 숫자'"><br />
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
      books: [],
      book: {},
      isbn: "",
      title: "",
      author: "",
      price: "",
      content: ""
    };
  },
  methods: {
    getAllBooks() {
      axios
        .get("http://127.0.0.1:9999/vuews/book")
        .then((response) => {
          this.books = response.data;
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    convertISBN(isbn) {
      return isbn.replace(/^(\d{3})(\d{3})(\d{4})/g, "$1-$2-$3");
    },
    duplicateCheck(isbn) {
      for (var i = 0; i < this.books.length; i++) {
        if (isbn === this.books[i].isbn) {
          alert("ISBN 중복입니다.");
          return false;
        }
        return true;
      }
    },
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
      } else if (this.isbn.length != 10) {
        alert("ISBN은 10자리 숫자입니다.");
      } else {
        this.isbn = this.convertISBN(this.isbn);
        if (this.duplicateCheck(this.isbn)) {
          this.writeBook();
        }
      }
    },
    writeBook() {
      axios({
        method: 'post',
        url: "http://127.0.0.1:9999/vuews/book",
        data: {
          isbn: this.isbn, title: this.title, author: this.author,
          price: this.price, content: this.content, img: null }
        })
        .then((response) => {
          alert("저장 성공")
          location.href = "./index.html#/book/list"
        })
        .catch((error) => {
          console.dir(error);
        });
      this.isbn="";
      this.title="";
      this.author = "";
      this.price = "";
      this.content = "";
    },
    moveList() {
      location.href = "./index.html#/book/list"
    }
  },
  created() {
    this.getAllBooks();
  },
};
