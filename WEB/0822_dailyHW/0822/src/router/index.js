import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from "../views/Home.vue";
import Book from "../views/Book.vue";
import BookCreate from "../components/book/BookCreate.vue"
import BookList from "../components/book/BookList.vue"
import BookModify from "../components/book/BookModify.vue"
import BookView from "../components/book/BookView.vue"
Vue.use(VueRouter);


export const router = new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "home",
      component: Home,
    },
    {
      path: "/book",
      name: "book",
      component: Book,
      children: [
        {
          path: "",
          name: "book-list",
          component: () => import("@/components/book/BookList.vue")
        },
        {
          path: "/create",
          name: "book-create",
          component: () => import("@/components/book/BookCreate.vue")
        },
        {
          path: "/modify",
          name: "book-modify",
          component: () => import("@/components/book/BookModify.vue")
        },
        {
          path: "/view",
          name: "book-view",
          component: () => import("@/components/book/BookView.vue")
        },
      ]
    },
  ]
});

export default router;
