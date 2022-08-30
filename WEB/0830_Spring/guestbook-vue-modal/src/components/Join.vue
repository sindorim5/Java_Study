<template>
  <div class="mt-2">
    <b-modal
      id="modal-prevent-closing"
      ref="modal"
      :title="mode"
      @shown="showModal"
      @hidden="resetModal"
      @ok="handleOk"
    >
      <form ref="form" @submit.stop.prevent="handleSubmit">
        <b-form-group label="이름" label-for="username-input" invalid-feedback="이름은 필수입니다." :state="userState_username" >
          <b-form-input id="username-input" v-model="modalUser.username" :state="userState_username"  required></b-form-input>
        </b-form-group>
        <b-form-group label="아이디" label-for="userid-input" invalid-feedback="아이디 필수입니다." :state="userState_userid" >
          <b-form-input id="userid-input" v-model="modalUser.userid" :state="userState_userid" required></b-form-input>
        </b-form-group>
        <b-form-group label="비밀번호" label-for="userpwd-input" invalid-feedback="비밀번호는 필수입니다." :state="userState_userpwd" >
          <b-form-input id="userpwd-input" v-model="modalUser.userpwd" :state="userState_userpwd"  required></b-form-input>
        </b-form-group>
        <b-form-group label="이메일" label-for="email-input" invalid-feedback="이메일은 필수입니다." :state="userState_email" >
          <b-form-input id="email-input" v-model="modalUser.email" :state="userState_email" required></b-form-input>
        </b-form-group>
        <b-form-group label="주소" label-for="address-input" invalid-feedback="주소는 필수입니다." :state="userState_address" >
          <b-form-input id="address-input" v-model="modalUser.address" :state="userState_address" required></b-form-input>
        </b-form-group>
      </form>
    </b-modal>
  </div>
</template>

<script>
import axios from '@/util/http-common';
import bus from '@/util/bus';

export default {
  props : {
    mode : {type:String},
    modifyUserId: {type:String},
  },
  data() {
    return {
      modalUser:{},
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
    showModal(){
      if(this.modifyUserId){
        axios
        .get(`/admin/user/${this.modifyUserId}`)
        .then(({ data }) => {
          this.modalUser = data
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
      }
    },
    resetModal() {
      this.modalUser = {}
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
        bus.$emit("addUser", this.modalUser);
      }else{
        bus.$emit("updateUser", this.modalUser);
      }
      // Hide the modal manually
      this.$nextTick(() => {
        this.$bvModal.hide('modal-prevent-closing')
      })
    }
  },
}
</script>