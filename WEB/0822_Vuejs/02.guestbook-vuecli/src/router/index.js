import Vue from "vue";
import VueRouter from "vue-router";
import List from "../views/List.vue";
import SingleDetail from "../views/SingleDetail.vue";
import Join from "../views/Join.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "list",
    component: List,
  },
  {
    path: "/detail/:userid",
    name: "detail",
    component: SingleDetail,
  },
  {
    path: "/update/:userid",
    name: "update",
    component: Join,
  },
  {
    path: "/join",
    name: "join",
    component: Join,
  },
  // {
  //   path: "/about",
  //   name: "About",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/About.vue"),
  // },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
