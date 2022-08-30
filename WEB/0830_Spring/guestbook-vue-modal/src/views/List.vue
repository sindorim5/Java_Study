<template>
  <div id="app" class="container">
    <div id="nav">
      <img src="../assets/ssafy_logo.png" id="ssafy_logo">
      <h3>SSAFY 방명록!!!(Spring-REST-VUE)</h3>
      <h3>회원목록</h3>
    </div>
    <div align="right"><b-button variant="outline-success" @click="regist">등록</b-button></div>    
    <join :mode="mode" :modifyUserId="modifyUserId"/>
    <single-detail :selectedUserId="selectedUserId"/>
    <div>
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
import Join from '../components/Join.vue'
import axios from '@/util/http-common';
import bus from '@/util/bus';
import SingleDetail from '../components/SingleDetail.vue';

export default {
	components: { ListDetail, Join, SingleDetail, },
  data() {
    return {
      users :[],
      selectedUserId : "",
      modifyUserId : "",
      mode:""
    }
  },
  methods : {
    regist(){
      this.mode="회원가입"
      this.modifyUserId = ""
      this.$bvModal.show('modal-prevent-closing')
    },
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
    addUser(modalUser){
      //저장.
      axios
      .post('/admin/user', {
        userid : modalUser.userid,
        username : modalUser.username,
        userpwd : modalUser.userpwd,
        email : modalUser.email,
        address : modalUser.address
      })
      .then(() => {
        this.selectAll()
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });    
    },
    updateUser(modalUser){
      //수정  
      axios
      .put(`/admin/user/${modalUser.userid}`, {
        userid : modalUser.userid,
        username : modalUser.username,
        userpwd : modalUser.userpwd,
        email : modalUser.email,
        address : modalUser.address
      })
      .then(() => {
          this.selectAll()
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
    }
  }, 
  created() {
    this.selectAll(),
    bus.$on("addUser", (modalUser) => {
      this.addUser(modalUser)
    }),
    bus.$on("userDetail", (userid) => {
      this.selectedUserId = userid;
      this.$bvModal.show('modal-center')
    }),
    bus.$on("deleteUser", (userid) => {
      this.deleteUser(userid)
    }),
    bus.$on("editUser", (userid) => {
      this.modifyUserId = userid
      this.mode="회원수정"
      this.$bvModal.show('modal-prevent-closing')
    }),
    bus.$on("updateUser", (modalUser) => {
      this.updateUser(modalUser);
    })
  }, 
  destroyed() {
    bus.$off('addUser')
    bus.$off('userDetail')
    bus.$off('deleteUser')
    bus.$off('editUser')
    bus.$off('updateUser')
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
