export default {
  template: `<div>
    게시물 등록폼
    <hr>
    <router-link :to="{name: 'boardlist'}">목록</router-link>
   </div>`,
  data() {
    return {
      no: 0,
    };
  },
  created() {
    console.dir(this.$route); // 현재 호출된 해당 라우터 정보
    this.no = this.$route.params.no;
  },
};
