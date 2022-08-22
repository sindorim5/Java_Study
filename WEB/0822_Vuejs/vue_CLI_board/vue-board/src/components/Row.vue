<template>
  <tr>
    <td>{{ no }}</td>
    <td>
      <router-link :to="`/read?no=${no}`">{{ title }}</router-link>
    </td>
    <td>{{ writer }}</td>
    <td>{{ getFormatDate(regtime) }}</td>
    <td>
        <button class="btn btn-outline-danger" @click="deleteArticle(no)">삭제</button>
    </td>
  </tr>
</template>

<script>
import moment from 'moment';
import bus from '@/util/bus';

export default {
  name: 'row',
  props: {
    no: { type: Number },
    writer: { type: String },
    title: { type: String },
    regtime: { type: String },
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD');
    },
    deleteArticle(no) {
      bus.$emit("deleteArticle", no);
    },
  },
};
</script>
