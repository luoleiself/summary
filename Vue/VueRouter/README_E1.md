### Router
   1. 动态路由匹配：使用 `:` 标记，所有模式匹配到的路由，全部都映射到同一个组件中，当匹配到一个路由时，参数值会被设置到  `this.$route.params` ， 一个路由可以设置多段路由参数
```
   <div id="app">
      <p>
         <router-link to="/user/foo?name=zhangsan">/user/foo</router-link>
         <router-link to="/user/bar?name=lisi">/user/bar</router-link>
         <router-link to="/user/foo/post/123?name=zhangsansan&age=28">/user/foo/post/123</router-link>
         <router-link to="/user/bar/post/789?name=lisisi&age=300">/user/bar/post/789</router-link>
      </p>
      <router-view></router-view>
   </div>
   const User = {
      template: '<div>User <span> {{ $route.params.id }} </span><br>
                           <span> {{ $route.path }} </span><br>
                           <span> {{ $route.query }} </span>
                </div>'
   }
   const router = new VueRouter({
      routes: [
         { path: '/user/:id', component: User },
         { path: '/user/:id/post/:post_id', component: User }
      ]
   })
   const app = new Vue({ router }).$mount('#app1')
```
   2. 嵌套路由： `children` 属性
``` 
   <div id="app">
      <p>
         <router-link to="/user/foo">/user/foo</router-link>
         <router-link to="/user/foo/profile">/user/foo/profile</router-link>
         <router-link to="/user/foo/posts">/user/foo/posts</router-link>
      </p>
      <router-view></router-view>
   </div>
   var User = {
      template: '<div class="user">
                     <h2>User {{ $route.params.id }}</h2>
                     <router-view></router-view>
                  </div>'
   }
   var UserHome = { template: '<div>Home</div>' }
   var UserProfile = { template: '<div>Profile</div>' }
   var UserPosts = { template: '<div>Posts</div>' }
   var router = new VueRouter({
      routes: [{
         path: '/user/:id',
         component: User,
         children: [
            // UserHome will be rendered inside User's <router-view>
            // when /user/:id is matched
            { path: '', component: UserHome },

            // UserProfile will be rendered inside User's <router-view>
            // when /user/:id/profile is matched
            { path: 'profile', component: UserProfile },

            // UserPosts will be rendered inside User's <router-view>
            // when /user/:id/posts is matched
            { path: 'posts', component: UserPosts }
         ]
      }]
   })
   var app = new Vue({ router }).$mount('#app')
   var app = new Vue({
      router,
      el:'#app'
   })
```   
   
   
