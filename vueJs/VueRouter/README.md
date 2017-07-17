### [README_E1.md](https://github.com/luoleiself/summary/blob/master/vueJs/VueRouter/README_E1.md)
### Router
   1. 构造配置：`var router = new VueRouter({})`
      
        `var router = new VueRouter({
            base:"/",    // 应用基路径
            mode:"hash", // 路由模式,'hash(浏览器环境)/history/abstract(NodeJs环境)'
            linkActiveClass:'router-link-active', // 默认class类名
            scrollBehavior:function(){}, // 滚动行为
            routes: [{
                path: '/user/:id',
                component: User,
                children: [
                  { path: '', component: UserHome },
                  { path: 'profile', component: UserProfile },
                  { path: 'posts', component: UserPosts }
                ]
            }]
         })`
  2. 路由信息对象： `$route`
     1. `$route.path`：String，对应当前路由的路径，总是解析为绝对路径，如 "/foo/bar"
     2. `$route.params`：Object，一个 key/value 对象，包含了 动态片段 和 全匹配片段，如果没有路由参数，就是一个空对象
     3. `$route.query`：Object，一个 key/value 对象，表示 URL 查询参数。例如，对于路径 /foo?user=1，则有 $route.query.user == 1，如果没有查询参数，则是个空对象
     4. `$route.hash`：String，当前路由的 hash 值 (带 #) ，如果没有 hash 值，则为空字符串
     5. `$route.fullPath`：String，完成解析后的 URL，包含查询参数和 hash 的完整路径
     6. `$route.name`：String，当前路由的名称，如果有的话
     7. `$route.matched`：Array，一个数组，包含当前路由的所有嵌套路径片段的 路由记录 。路由记录就是 routes 配置数组中的对象副本（还有在 children 数组）

            `const router = new VueRouter({
                routes: [// 下面的对象就是 route record
                  { path: '/foo', component: Foo,children: [
                    { path: 'bar', component: Bar }]// 这也是个 route record
                  }
                ]
            })`


