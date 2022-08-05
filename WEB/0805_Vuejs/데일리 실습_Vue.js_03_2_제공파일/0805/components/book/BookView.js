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
      <router-link :to="{name: 'update'}">수정</router-link>
      <router-link :to="{name: 'book'}">삭제</router-link>
      <router-link :to="{name: 'book'}">목록</router-link>
    </p>
  </div>
  `,
  data() {
    return {
      books: [],
      book: {},
    };
  },
  methods: {
    getBook() {
      axios
        .get("http://127.0.0.1:9999/vuews/book")
        .then((response) => {
          this.books = response.data;
          for (var i = 0; i < this.books.length; i++) {
            if (this.isbn === this.books[i].isbn) {
              this.book = this.books[i];
            }
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },
  },
  created() {
    this.isbn = this.$route.params.isbn;
    this.getBook();
  },
};
