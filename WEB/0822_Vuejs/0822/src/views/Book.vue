<template>
    <div>
        <h1 class="underline">도서 목록</h1>
        <div style="text-align: right">
        <button @click="moveCreate()">도서 등록</button>
        </div>
        <div>
        <table style="text-align: center">
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
                <td>{{ index + 1 }}</td>
                <td>{{ book.isbn | bookISBN }}</td>
                <td @click="moveView(book.isbn)">{{ book.title }}</td>
                <td>{{ book.author }}</td>
                <td>{{ book.price }}원</td>
            </tr>
            </tbody>
        </table>
        </div>
        <div v-if="(books.length = 0)">게시글이 없습니다.</div>
    </div>
</template>

<script>
export default {
  name: 'book-list',
  data() {
    return {
      // 도서목록을 저장할 배열
      books: [],
    };
  },
  created() {
    let bookKeys = Object.keys(localStorage);
    for (var i = 0; i < bookKeys.length; i++) {
      let tempBook = localStorage.getItem(bookKeys[i]);
      this.books.push(JSON.parse(tempBook));
    }
  },
  methods: {
    moveView(isbn) {
      location.href = "view.html?isbn=" + isbn;
    },
    moveCreate() {
      location.href = "create.html";
    },
  },
}
</script>
