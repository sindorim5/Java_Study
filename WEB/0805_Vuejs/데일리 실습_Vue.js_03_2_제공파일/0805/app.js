import Main from "./components/Main.js";
import QnA from "./components/QnA.js";
import Gallery from "./components/Gallery.js";
import Book from "./components/Book.js";
import BookList from "./components/book/BookList.js";
import BookView from "./components/book/BookView.js";
import BookUpdate from "./components/book/BookUpdate.js";
import BookWrite from "./components/book/BookWrite.js";

const router = new VueRouter({
  routes: [
    {
      path: "/",
      name: "main",
      component: Main,
    },
    {
      path: "/book",
      name: "book",
      component: Book,
      redirect: "book/list",
      children: [
        {
          path: "list",
          name: "booklist",
          component: BookList,
        },
        {
          path: "view/:isbn",
          name: "bookview",
          component: BookView,
        },
        {
          path: "update/:isbn",
          name: "update",
          component: BookUpdate,
        },
        {
          path: "write",
          name: "write",
          component: BookWrite,
        },
      ],
    },
    {
      path: "/qna",
      name: "qna",
      component: QnA,
    },
    {
      path: "/gallery",
      name: "gallery",
      component: Gallery,
    },
  ],
});

const app = new Vue({
  el: "#app",
  router,
});
