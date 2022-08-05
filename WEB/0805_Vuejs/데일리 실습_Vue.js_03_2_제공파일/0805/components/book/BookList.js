export default {
  template: `
  <div>
    <h3>도서 목록</h3>
    <button id="updateBtn">도서 등록</button>
    <div>
      <table style="text-align: center" border="1" style="border-collapse: collapse;">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 20%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>ISBN</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(book, index) in books">
            <td>{{index + 1}}</td>
            <td>{{book.isbn}}</td>
            <td><router-link :to="'/book/view/' + book.isbn">{{book.title}}</router-link></td>
            <td>{{book.author}}</td>
            <td>{{book.price}}원</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  `,
  data() {
    return {
      books: [],
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
  },
  created() {
    this.getAllBooks();
  },
};
