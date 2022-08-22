<template>
  <tr>
    <td>{{ user.userid }}</td>
    <td>{{ user.userpwd }}</td>
    <td><router-link :to="`/detail/${user.userid}`">{{ user.username }}</router-link></td>
    <!-- <td><a @click="selectUser(user.userid)">{{ user.username }}</a></td> -->
    <td>{{ user.email }}</td>
    <td>{{ user.address }}</td>
    <td>{{ user.joindate }}</td>
    <td>
      <router-link :to="`/update/${user.userid}`">
        <b-button variant="outline-primary mr-1" size="sm">수정</b-button>
      </router-link>
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
    deleteUser(userid){
      bus.$emit("deleteUser", userid)
    }
  }
}
</script>