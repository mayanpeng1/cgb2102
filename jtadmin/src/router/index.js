// import 导入vue.js   需要提前依赖
import Vue from 'vue'
// import 导入router
import VueRouter from 'vue-router'
//手动导入自己的组件
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import User from '../components/user/user.vue'
import Welcome from '../components/Welcome.vue'
import ItemCat from '../components/items/ItemCat.vue'

//在vue对象中声明路由对象 整个脚手架 中都可以引用路由
Vue.use(VueRouter)
const routes = [
  {path: '/', redirect: '/login'},
  {path: '/login', component: Login},
  {path:'/home', component: Home, redirect:'/welcome',
    children:[
      {path:'/user',component:User},
      {path:'/welcome', component:Welcome},
      {path:'/itemCat',component:ItemCat}
  ]}
]

//创建路由对象
const router = new VueRouter({
  routes
})

//定义路由导航首位  考点: 拦截器
/**
 * 1.遍历的每个路由都会制定回调函数
 * 2.参数信息: 3个
 *    2.1 to: 请求访问的地址      到哪去
 *    2.2 from: 请求从哪里跳转来  从哪来
 *    2.3 next: 是一个函数  next()  请求放行
 *                         next("/login")  发起login请求
 */
router.beforeEach((to,from,next) =>{
  //1.如果用户访问/login 的请求,应该直接放行
  if(to.path=="/login") return next();

  //2.不是访问的登录页面,所以判断用户是否登录, 判断依据 token
  let token = window.sessionStorage.getItem("token")

  //3.如果!token  没有值,则执行if之后的操作
  if(!token) return next("/login")

  //4.如果代码能执行到这一行,说明用户已经登录,则放行
  next()
})

export default router
