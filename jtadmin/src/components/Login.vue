<!-- 定义模版对象 -->
<template>
    <div class="login_container">
      <div class="login_box">
        <!-- 头像区域-->
        <div class="avatar_box">
          <img src="../assets/logo.png" alt="VUE图片" />
        </div>

        <!-- 登陆表单区域
              ref: form 表单可以通过ref进行引用 代表当前表单引用对象
             :model  对整个表单进行数据的绑定
        -->
        <el-form ref="loginFormRef" label-width="0"  :rules="rules" class="login_form" :model="loginForm" >
          <el-form-item  prop="username" >
            <el-input  prefix-icon="iconfont iconuser" v-model="loginForm.username"></el-input>
          </el-form-item>
          <el-form-item  prop="password" >
            <el-input  prefix-icon="iconfont iconsuo" type="password" v-model="loginForm.password"></el-input>
          </el-form-item>
          <el-form-item class="btns" >
              <el-button type="primary" @click="login">登录</el-button>
              <el-button type="info" @click="reset">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
</template>

<!-- 定义JS变量 -->
<script>
export default {
  data(){
    return {
      loginForm: {
        username: '',
        password: ''
      },
      rules:{//表单验证
        username:[
          /* required 是否为必填项  message: 提示信息   trigger: 触发条件*/
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' }
        ],
        password:[
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    reset(){
      //将表单数据改为空串
      /* 常规操作
         this.loginForm.username = ''
         this.loginForm.passworld = '' */
      //this:代表当前的Vue的组件对象
      /* $refs
          1.$从vue对象中获取数据
          2.从vue组件对象中获取全部ref标签
      */
      this.$refs.loginFormRef.resetFields()
    },
    login(){
      this.$refs.loginFormRef.validate(async valid =>{
        if(!valid) return
        //1.获取表单数据
        this.$refs.loginFormRef.validate(async valid =>{
          //2.当程序没有通过效验时  程序终止
          if(!valid) return

          //3.发起ajax请求,实现业务调用
          let {data:result} =
          await this.$http.post("/user/login",this.loginForm)
          console.log(result)
          if(result.status!=200){
            return this.$message.error("用户名或密码错误")
          }

          this.$message.success("恭喜你登录成功");
          //如何获取 token  result.data
          //将用户信息保存到session中
          window.sessionStorage.setItem("token",result.data)
          //window.sessionStorage.removeItem("token")//删除
          //window.sessionStorage.clear()//全部删除



          //5.登录成功之后,跳转到/home页面中
          this.$router.push("/home")

        })

        // this.$http.post("/user/login",this.loginForm)
        // .then(result =>{
        //   console.log(JSON.stringify(result.data))
        //   if(result.data.status!=200) return this.$message.error("用户名或密码错误")

        //   this.$message.success("登录成功")
        // })

      })




    }
  }
}
</script>

<!-- 防止组件冲突 -->
<style lang="less" scoped>
.login_container{
  background-color: #2b4b6b;
  height: 100%;
}

.login_box {
  width: 450px;
  height: 300px;
  background-color: #FFFFFF;
  /* 设定圆弧角*/
  border-radius: 10px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);

  .avatar_box {
    height: 130px;
    width: 130px;
    border: 1px solid #EEEEEE;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #DDDDDD; /* 添加阴影*/
    position: absolute;           /* 绝对定位*/
    left: 50%;                    /* 距离左侧50%*/
    transform: translate(-50%,-50%);   /*回调50%*/
    background-color: #FFFFFF;
    img {
      height: 100%;
      width: 100%;
      border-radius: 50%;
      background-color: #EEEEEE;
    }
  }

  .btns {
    display: flex;
    justify-content: flex-end;

  }

  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }
}
</style>
