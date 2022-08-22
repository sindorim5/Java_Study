<template>
  <div>
    <div align="right">
      <router-link :to="`/join`">
        <b-button variant="outline-success">등록</b-button>
      </router-link>
    </div>    
    <div class="m-2">
      <b-table-simple>
        <colgroup>
          <col width="120">
          <col width="120">
          <col width="120">
          <col width="170">
          <col width="*">
          <col width="120">
          <col width="150">
        </colgroup>
        <b-thead head-variant="light">
          <b-tr>
            <b-th>아이디</b-th>
            <b-th>비밀번호</b-th>
            <b-th>이름</b-th>
            <b-th>이메일</b-th>
            <b-th>주소</b-th>
            <b-th>가입일</b-th>
            <b-th>수정/삭제</b-th>
          </b-tr>
        </b-thead>
        <b-tbody>
          <list-detail v-for="(user,index) in users" :key="index" :user="user"></list-detail>
        </b-tbody>
        <b-tfoot><b-tr><b-td colspan="7" ></b-td></b-tr></b-tfoot>
      </b-table-simple>

    </div>
  </div>
</template>

<script>
import ListDetail from '../components/ListDetail.vue'
import axios from '@/util/http-common';
import bus from '@/util/bus';

export default {
	components: { ListDetail,  },
  data() {
    return {
      users :[],
      selectedUserId : "",
      modifyUserId : "",
      mode:"회원가입"
    }
  },
  methods : {
    selectAll() {
      axios
      .get('/admin/user')
      .then(({ data }) => {
        this.users = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
    }, 
    deleteUser(userid) {
      console.log("deleteUser....."+userid)
      let test = confirm("정말로 삭제하시겠습니까?");
      if(test){
        axios
        .delete(`/admin/user/${userid}`)
        .then(() => {
          this.selectAll()
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
      }
    },
  }, 
  created() {
    this.selectAll(),
    bus.$on("deleteUser", (userid) => {
      this.deleteUser(userid)
    })
  },
  destroyed() {
    bus.$off('deleteUser');
  },
}
</script>


<style>
#ssafy_logo{
	width: 150px;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
