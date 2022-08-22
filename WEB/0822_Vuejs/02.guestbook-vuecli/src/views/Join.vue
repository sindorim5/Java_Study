<template>
  <div class="mt-2" align="left">
    <h3>{{mode}}</h3>
      <b-form ref="form" @submit.stop.prevent="handleSubmit">
        <b-form-group label="이름" label-for="username-input" invalid-feedback="이름은 필수입니다." :state="userState_username" >
          <b-form-input id="username-input" v-model="username" :state="userState_username" required disabled v-if="mode == '회원수정'"></b-form-input>
          <b-form-input id="username-input" v-model="username" :state="userState_username" required v-else ></b-form-input>
        </b-form-group>
        <b-form-group label="아이디" label-for="userid-input" invalid-feedback="아이디 필수입니다." :state="userState_userid" >
          <b-form-input id="userid-input" v-model="userid" :state="userState_userid" required disabled v-if="mode == '회원수정'"></b-form-input>
          <b-form-input id="userid-input" v-model="userid" :state="userState_userid" required v-else ></b-form-input>
        </b-form-group>
        <b-form-group label="비밀번호" label-for="userpwd-input" invalid-feedback="비밀번호는 필수입니다." :state="userState_userpwd" >
          <b-form-input id="userpwd-input" v-model="userpwd" :state="userState_userpwd"  required></b-form-input>
        </b-form-group>
        <b-form-group label="이메일" label-for="email-input" invalid-feedback="이메일은 필수입니다." :state="userState_email" >
          <b-form-input id="email-input" v-model="email" :state="userState_email" required></b-form-input>
        </b-form-group>
        <b-form-group label="주소" label-for="address-input" invalid-feedback="주소는 필수입니다." :state="userState_address" >
          <b-form-input id="address-input" v-model="address" :state="userState_address" required></b-form-input>
        </b-form-group>
        
        <div align="right">
          <b-button variant="outline-primary mr-1"  @click="handleOk">저장</b-button>
          <router-link :to="{name:'list'}"><b-button variant="outline-success">목록</b-button></router-link>
        </div>
      </b-form>
  </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
  props : {
    modifyUserId: {type:String},
  },
  data() {
    return {
      mode : {type:String},
      username:"",
      userid:"",
      userpwd:"",
      email:"",
      address:"",
      userState_username:null,
      userState_userid:null, 
      userState_userpwd:null, 
      userState_email:null, 
      userState_address:null,    
    }
  },
  methods: {
    checkFormValidity() {
      this.userState_username = this.$refs.form[0].checkValidity()
      this.userState_userid = this.$refs.form[1].checkValidity()
      this.userState_userpwd = this.$refs.form[2].checkValidity()
      this.userState_email = this.$refs.form[3].checkValidity()
      this.userState_address = this.$refs.form[4].checkValidity() 
      
      // console.log(this.userState.address);
      const valid = this.$refs.form.checkValidity() //전부 통과면 true리턴
      return valid;
    },
    resetModal() {
      this.userState_username=null,
      this.userState_userid=null, 
      this.userState_userpwd=null, 
      this.userState_email=null, 
      this.userState_address=null
    },
    handleOk(bvModalEvt) {
      // Prevent modal from closing
      bvModalEvt.preventDefault()
      // Trigger submit handler
      this.handleSubmit()
    },
    handleSubmit() {
      // Exit when the form isn't valid
      if (!this.checkFormValidity()) {
        return
      }

      if(this.mode == "회원가입"){
        //저장.
        axios
        .post('/admin/user', {
          userid : this.userid,
          username : this.username,
          userpwd : this.userpwd,
          email : this.email,
          address : this.address
        })
        .then(() => {
          this.makeToast('success','저장 성공')
        })
        .catch(() => {
          this.makeToast('warning','에러가 발생했습니다.')
        });    
      }else{
        //수정  
        axios
        .put(`/admin/user/${this.userid}`, {
          userid : this.userid,
          username : this.username,
          userpwd : this.userpwd,
          email : this.email,
          address : this.address
        })
        .then(() => {
          this.makeToast('success','저장 성공')
        })
        .catch(() => {
          this.makeToast('warning','에러가 발생했습니다.')
        });
      }
      // Hide the modal manually
      this.$nextTick(() => {
        this.$bvModal.hide('modal-prevent-closing')
      })
    },
    makeToast(variant = null, message) {
        this.$bvToast.toast(message, {
          title: `Result: ${variant || 'default'}`,
          variant: variant,
          solid: true
        })
      }
  },
  created () {
    let id = this.$route.params.userid
    if(id){
      this.mode = '회원수정'
    }else{
      this.mode = '회원가입'
    }
      axios
        .get(`/admin/user/${this.$route.params.userid}`)
        .then(({ data }) => {
          this.username = data.username
          this.userid = data.userid
          this.userpwd = data.userpwd
          this.email = data.email
          this.address = data.address
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
  }, 
}
</script>