<!-- 定义模版对象 -->
<template>
    <div class="login_container">
      <div class="login_box">
        <!-- 头像区域-->
        <div class="avatar_box">
          <img src="../assets/logo.png" alt="VUE图片" />
        </div>

        <!-- 登陆表单区域
              ref代表当前表单引用对象
             :model 是表格中封装的对象
        -->
        <el-form ref="loginFormRef" label-width="0" class="login_form"  >
          <el-form-item prop="username">
            <el-input  prefix-icon="iconfont iconuser" v></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input  prefix-icon="iconfont iconsuo" type="password" ></el-input>
          </el-form-item>
          <el-form-item class="btns">
             <el-button type="primary" @click="login">登录</el-button>
              <el-button type="info" @click="resetBtn">重置</el-button>
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

    }
  },
  methods: { }
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
