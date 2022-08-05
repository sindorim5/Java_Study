export default {
  template: `
  <div>
    <table style="text-align: center" border="1" style="border-collapse: collapse;">
      <colgroup>
        <col style="width: 20%" />
        <col style="width: 40%" />
        <col style="width: 20%" />
        <col style="width: 15%" />
      </colgroup>
      <thead>
        <tr>
          <th>도서번호</th>
          <th>제목</th>
          <th>저자</th>
          <th>가격</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{{book.isbn}}</td>
          <td>{{book.title}}</td>
          <td>{{book.author}}</td>
          <td>{{book.price}}원</td>
        </tr>
      </tbody>
    </table>
    <p>
      <router-link :to="'/book/update/' + book.isbn">수정</router-link>
      <a href="#" @click="deleteBook">삭제</a>
      <router-link :to="{name: 'book'}">목록</router-link>
    </p>
  </div>
  `,
  data() {
    return {
      book: {},
      books: [],
      isbn: ""
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
    deleteBook() {
      axios
        .delete("http://127.0.0.1:9999/vuews/book/" + this.isbn)
        .then((response) => {
          alert("삭제 성공");
          location.href = "./index.html#/book/list"
        })
        .catch((error) => {
          console.dir(error);
        });
    }
  },
  created() {
    this.isbn = this.$route.params.isbn;
    this.getBook();
  },
};
