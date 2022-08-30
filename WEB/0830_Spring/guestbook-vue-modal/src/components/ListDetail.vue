<template>
  <tr>
    <td>{{ user.userid }}</td>
    <td>{{ user.userpwd }}</td>
    <td><a href="#" @click="selectUser(user.userid)">{{ user.username }}</a></td>
    <td>{{ user.email }}</td>
    <td>{{ user.address }}</td>
    <td>{{ user.joindate }}</td>
    <td>
      <b-button variant="outline-primary mr-1" size="sm" @click="editUser(user.userid)">수정</b-button>
      <b-button variant="outline-danger" size="sm" @click="deleteUser(user.userid)">삭제</b-button>
    </td>
  </tr>
</template>

<script>
import bus from '@/util/bus';

export default {
  props : {
      user: {type:Object}
    },
  methods : { 
    selectUser(userid){
      bus.$emit("userDetail", userid)
    },
    editUser(userid){
      bus.$emit("editUser", userid)
    },
    deleteUser(userid){
      bus.$emit("deleteUser", userid)
    }
  }
}
</script>