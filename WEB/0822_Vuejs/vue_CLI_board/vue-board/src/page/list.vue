<template>
  <div>
    <div v-if="items.length">
      <table class="table table-bordered table-condensed">
        <colgroup>
          <col :style="{ width: '5%' }" />
          <col :style="{ width: '40%' }" />
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '10%' }" />
        </colgroup>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
          <th>삭제</th>
        </tr>
        <list-row
          v-for="(item, index) in items"
          :key="`${index}_items`"
          :no="item.no"
          :title="item.title"
          :writer="item.writer"
          :regtime="item.regtime"
        />
      </table>
    </div>
    <div v-else>글이 없습니다.</div>
    <div class="text-right">
      <button class="btn btn-primary" @click="movePage">등록</button>
    </div>
  </div>
</template>

<script>
import http from '@/util/http-common';
import ListRow from '@/components/Row.vue';
import bus from '@/util/bus';

export default {
  name: 'list',
  components: {
    ListRow,
  },
  data: function() {
    return {
      items: [],
    };
  },
  created() {
    this.selectAll();
    bus.$on("deleteArticle", (no) => {
      this.deleteArticle(no)
    })
  },
  destroyed() {
    bus.$off('deleteArticle');
  },
  methods: {
    selectAll(){
      http
        .get('/board')
        .then(({ data }) => {
          this.items = data;
          console.log(data)
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    movePage() {
      this.$router.push('/create');
    },
    deleteArticle(no) {
      http
        .delete(`/board/${no}`)
        .then(({ data }) => {
          let msg = '삭제 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '삭제가 완료되었습니다.';
          }
          alert(msg);
          this.selectAll();
        })
        .catch(() => {
          alert('삭제 처리시 에러가 발생했습니다.');
        });
    },
  },
};
</script>

<style></style>
