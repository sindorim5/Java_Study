export default {
  template: `
    <footer>
      <ul>
        <li><a class="" href="#">{{welcome}}</a></li>
        <li><a class="" href="#">개인정보처리방침</a></li>
        <li><a class="" href="#">이용약관</a></li>
        <li><a class="" href="#">오시는길</a></li>
        <li>&copy; SSAFY Corp.</li>
      </ul>
    </footer>`
  ,
  props: {
    welcome : String, // Vue.js 권장
  },  // ["welcome"]
  data() {
    return {

    }
  }
}
