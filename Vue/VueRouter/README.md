### [README_E1.md](https://github.com/luoleiself/summary/blob/master/vueJs/VueRouter/README_E1.md)
### Router
   1. `<router-link>` => `<a href='...'>`
      * to： String | Object，required，表示目标路由的链接，可以是字符串或者对象，当点击时内部将 to 的值传递给 `router.push()`
      * replace： Boolean，default：false，当点击时会调用 `router.replace()`，导航不会留下历史记录 
      * append： Boolean，default：false，在当前(相对)路径前添加基路径，
                 例如，我们从 /a 导航到一个相对路径 b，如果没有配置 append，则路径为 /b，如果配了，则为 /a/b
      * tag： String，default：'a'，指定以哪种标签渲染路由
      * active-class： String，default：'router-link-active'，
                     设置链接激活时使用的 CSS 类名，通过构造配置的 `linkActiveClass` 选项配置
      * exact： Boolean，default：false，是否激活" 默认类名的依据是 inclusive match （全包含匹配）。 
                举个例子，如果当前的路径是 /a 开头的，那么 <router-link to="/a"> 也会被设置 CSS 类名
      * events： String | Array&lt;String&gt;，default：false，声明可以用来触发导航的事件。

            ` <!-- 使用 v-bind 的 JS 表达式 -->
              <router-link v-bind:to="'home'">Home</router-link>
              <!-- 命名的路由 -->
              <router-link :to="{ name: 'user', params: { userId: 123 }}">User</router-link>
              <!-- 带查询参数，下面的结果为 /register?plan=private -->
              <router-link :to="{ path: 'register', query: { plan: 'private' }}">Register</router-link>
              <!-- 字符串 -->
              <router-link to="home" tag='li' replace append events='["mouseenter","mouseout"]'>Home</router-link>`

   2. `<router-view>`： functional 组件，渲染路径匹配到的视图组件，可以嵌套使用
      * name： String，default：'default'，如果 <router-view>设置了名称，则会渲染对应的路由配置中 components 下的相应组件
      * 可以配置 Vue 组件使用
```
        <transition>
          <keep-alive>
            <router-view></router-view>
          </keep-alive>
        </transition>
```
   3. 构造配置：`var router = new VueRouter({})`
      * base： String，应用基路径，default：'/'
      * mode： String，配置路由模式，'hash/history/abstract(NodeJs环境)'，default：'hash'
      * linkActiveClass： String，全局配置 `<router-link>` 的默认激活 class 类名，default：`router-link-active`
      * scrollBehavior： Function，滚动行为
      * routes： Array&lt;RouteConfig&gt;，路由类型定义，
```      
           const router = new VueRouter({
               base: '', // default: '/'
               mode: '', // 'hash/history(H5 HistoryAPI)/abstract(NodeJs环境)', default: 'hash'
               linkActiveClass: '', // default: 'router-link-active'
               scrollBehavior: function(){},
               routes: [// 下面的对象就是 route record
                  {  path: '/foo', 
                     component: Foo,
                     children: [
                        { path: 'bar', component: Bar }]// 这也是个 route record
                  }
               ]
           })
```
  4. 路由信息对象： `$route`
     * `$route.path`： String，对应当前路由的路径，总是解析为绝对路径，如 "/foo/bar"
     * `$route.params`： Object，一个 key/value 对象，包含了 动态片段 和 全匹配片段，如果没有路由参数，就是一个空对象
     * `$route.query`： Object，一个 key/value 对象，表示 URL 查询参数。例如，对于路径 /foo?user=1，则有 $route.query.user == 1，如果没有查询参数，则是个空对象
     * `$route.hash`： String，当前路由的 hash 值 (带 #) ，如果没有 hash 值，则为空字符串
     * `$route.fullPath`： String，完成解析后的 URL，包含查询参数和 hash 的完整路径
     * `$route.name`： String，当前路由的名称，如果有的话
     * `$route.matched`： Array，一个数组，包含当前路由的所有嵌套路径片段的 路由记录 。路由记录就是 routes 配置数组中的对象副本（还有在 children 数组）
```
        declare type RouteConfig = {
            path: string;
            component?: Component;
            name?: string; // for named routes (命名路由)
            components?: { [name: string]: Component }; // for named views (命名视图组件)
            redirect?: string | Location | Function; // 重定向
            alias?: string | Array<string>; // 别名
            // 嵌套路由
            children?: Array<RouteConfig>; // for nested routes
            // 路由导航钩子
            beforeEnter?: (to: Route, from: Route, next: Function) => void; 
            meta?: any; // 路由元信息
        }
```
 5. Router实例：
      * 属性：
         * router.app： Vue instance，配置了 router 的 Vue 根实例
         * router.mode： String，default：'hash'，路由使用的模式
         * router.currentRoute：Route，当前路由对应的 路由信息对象
      * 方法：
         * router.beforeEach(guard)
         * router.afterEach(hook)
         * router.push(location)
         * router.replace(location)
         * router.go(n)
         * router.back()
         * router.forward()
         * router.getMatchedComponents(location?)：返回目标位置或是当前路由匹配的组件数组
         * router.resolve(location, current?, append?)：解析目标位置
         * router.addRoutes(routes)：动态添加更多的路由规则。参数必须是一个符合 routes 选项要求的数组
         * router.onReady(callback)
6. 命名路由和命名视图：`name`，`default`，
  
        `// 命名路由
        const router = new VueRouter({
            routes: [
              {
                path: '/user/:userId',
                name: 'user',
                component: User
              }
            ]
        })
        // 命名视图
        <div id="app">
            <h1>Named Views</h1>
            <router-link to="/">/</router-link>
            <router-link to="/other">/other</router-link>
            
            <router-view class="view one"></router-view>
            <router-view class="view two" name="a"></router-view>
            <router-view class="view three" name="b"></router-view>
        </div>
        const Foo = { template: '<div>foo</div>' }
        const Bar = { template: '<div>bar</div>' }
        const Baz = { template: '<div>baz</div>' }
        const router = new VueRouter({
            mode: 'history',
            routes: [{ 
                path: '/',
                components: {
                  default: Foo,
                  a: Bar,
                  b: Baz
                }
              },{
                path: '/other',
                components: {
                  default: Baz,
                  a: Bar,
                  b: Foo
                }
            }]
        })
        new Vue({
	   router,
           el: '#app'
        })`
7. 重定向和别名：
    1. 重定向： `redirect`：String | Location | Function
        * 普通方式：从 `/a` 重定向到 `/b`
        
                  `const router = new VueRouter({
                      routes: [
                        { path: '/a', redirect: '/b' }
                      ]
                   })`        
        * 命名路由方式：命名路由的重定向：
        
                  `const router = new VueRouter({
                      routes: [
                        { path: '/a', redirect: { name: 'foo' }}
                      ]
                   })`
        * 方法返回值：动态返回重定向目标
       
                  `const router = new VueRouter({
                      routes: [
                        { path: '/a', redirect: to => {
                          // 方法接收 目标路由 作为参数
                          // return 重定向的 字符串路径/路径对象
                         }}
                      ]
                   })`
    2. 别名： `alias`： string | Array&lt;String&gt;
          
            ` <div id='app'>
                  <router-link to='/home/foo'>/home/foo (renders /home/foo)</router-link>
                  <router-link to='/home/bar-alias'>/home/bar-alias (renders /home/bar)</router-link>
                  <router-link to='/home/baz'>/home/baz (renders /home/baz)</router-link>
                  <router-link to='/home/baz-alias'>/home/baz-alias (renders /home/baz)</router-link>

                  <router-view></router-view>
              </div>
              const Home = { template: '<div><h1>Home</h1><router-view></router-view></div>' }
              const Foo = { template: '<div>foo</div>' }
              const Bar = { template: '<div>bar</div>' }
              const Baz = { template: '<div>baz</div>' }
              const router = new VueRouter({
                  mode: 'history',
                  base: __dirname,
                  routes: [
                    { path: '/home', component: Home,
                      children: [
                        // absolute alias
                        { path: 'foo', component: Foo, alias: '/foo' },
                        // relative alias (alias to /home/bar-alias)
                        { path: 'bar', component: Bar, alias: 'bar-alias' },
                        // multiple aliases
                        { path: 'baz', component: Baz, alias: ['/baz', 'baz-alias'] }
                      ]
                    }
                  ]
               })
              const app = new Vue({
                  router,
                  el: '#app'
              })`
8. H5-History：需要后台配置
    * Apache

            `<IfModule mod_rewrite.c>
                RewriteEngine On
                RewriteBase /
                RewriteRule ^index\.html$ - [L]
                RewriteCond %{REQUEST_FILENAME} !-f
                RewriteCond %{REQUEST_FILENAME} !-d
                RewriteRule . /index.html [L]
             </IfModule>`
    * nginx

            `location / {
                try_files $uri $uri/ /index.html;
             }`
    * Node.Js(Express) [NodeJs配置](https://github.com/bripkens/connect-history-api-fallback)

              `// 覆盖所有路由，指定路由渲染页面
              const router = new VueRouter({
                mode: 'history',
                routes: [
                  { path: '*', component: NotFoundComponent }
                ]
             })`
9. 导航钩子：导航钩子主要用来拦截导航，让它完成跳转或取消。
    1. 全局导航钩子：钩子是异步解析执行，此时导航在所有钩子 resolve 完之前一直处于 等待中
       * to: Route, 即将进入的目标 路由对象
       * from: Route, 当前导航正要离开的 路由
       * next: Function, 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数
          * next(): 进行管道中的下一个钩子。如果全部钩子执行完了，则导航的状态就是 confirmed （确认的）
          * next(false): 中断当前的导航。如果浏览器的 URL 改变了（可能是用户手动或者浏览器后退按钮），那么 URL 地址会重置到 from 路由对应的地址
          * next('/') / next({path: '/'}): 跳转到一个不同的地址。当前的导航被中断，然后进行一个新的导航 
    
                    `const router = new VueRouter({ ... })
                        router.beforeEach((to, from, next) => {
                        // ...
                     })`
    2. 某个路由独享的钩子： 方法参数和全局钩子的方法的 参数 一致
        
              `const router = new VueRouter({
                  routes: [
                    {
                      path: '/foo',
                      component: Foo,
                      beforeEnter: (to, from, next) => {
                        // ...
                      }
                    }
                  ]
               })`
    3. 组件内的钩子： `beforeRouteEnter` `beforeRouteUpdate` `beforeRouteLeave`
    
              `const Foo = {
                  template: `...`,
                  beforeRouteEnter (to, from, next) {
                    // 在渲染该组件的对应路由被 confirm 前调用
                    // 不！能！获取组件实例 `this`
                    // 因为当钩子执行前，组件实例还没被创建
                  },
                  beforeRouteUpdate (to, from, next) {
                    // 在当前路由改变，但是该组件被复用时调用
                    // 举例来说，对于一个带有动态参数的路径 /foo/:id，在 /foo/1 和 /foo/2 之间跳转的时候，
                    // 由于会渲染同样的 Foo 组件，因此组件实例会被复用。而这个钩子就会在这个情况下被调用。
                    // 可以访问组件实例 `this`
                  },
                  beforeRouteLeave (to, from, next) {
                    // 导航离开该组件的对应路由时调用
                    // 可以访问组件实例 `this`
                  }
              }`
10. 路由元信息： `meta`
    
        `const router = new VueRouter({
            routes: [
              {
                path: '/foo',
                component: Foo,
                children: [
                  {
                    path: 'bar',
                    component: Bar,
                    // a meta field
                    meta: { requiresAuth: true }
                  }
                ]
              }
            ]
        })`
11. 过渡动效： `<transition><router-view></router-view></transition>`
    1. 单个路由的过渡动效：    
            
              `const Foo = {
                  template: `
                    <transition name="slide">
                      <div class="foo">...</div>
                    </transition>
                  `
               }
               const Bar = {
                  template: `
                    <transition name="fade">
                      <div class="bar">...</div>
                    </transition>
                  `
               }`
    2. 基于路由的动态过渡：
        
              ` <!-- 使用动态的 transition name -->
                <transition :name="transitionName">
                    <router-view></router-view>
                </transition>
                // 接着在父组件内
                // watch $route 决定使用哪种过渡
                watch: {
                  '$route' (to, from) {
                    const toDepth = to.path.split('/').length
                    const fromDepth = from.path.split('/').length
                    this.transitionName = toDepth < fromDepth ? 'slide-right' : 'slide-left'
                  }
                }`
12. 数据获取：
    1. 导航完成之前获取： 使用 `created` 钩子函数获取数据
        
              `export default {
                  data () {
                    return {
                      post: null,
                      error: null
                    }
                  },
                  beforeRouteEnter (to, from, next) {
                    getPost(to.params.id, (err, post) => 
                      if (err) {
                        // display some global error message
                        next(false)
                      } else {
                        next(vm => {
                          vm.post = post
                        })
                      }
                    })
                  },
                  // 路由改变前，组件就已经渲染完了
                  // 逻辑稍稍不同
                  watch: {
                    $route () {
                      this.post = null
                      getPost(this.$route.params.id, (err, post) => {
                        if (err) {
                          this.error = err.toString()
                        } else {
                          this.post = post
                        }
                      })
                    }
                  }
                }`
    2. 导航完成之后获取： 使用 `beforeRouteEnter` 钩子方法和 `next` 方法

              `<template>
                <div class="post">
                  <div class="loading" v-if="loading">
                    Loading...
                  </div>

                  <div v-if="error" class="error">
                    {{ error }}
                  </div>

                  <div v-if="post" class="content">
                    <h2>{{ post.title }}</h2>
                    <p>{{ post.body }}</p>
                  </div>
                </div>
              </template>
              export default {
                data () {
                  return {
                    loading: false,
                    post: null,
                    error: null
                  }
                },
                created () {
                  // 组件创建完后获取数据，
                  // 此时 data 已经被 observed 了
                  this.fetchData()
                },
                watch: {
                  // 如果路由有变化，会再次执行该方法
                  '$route': 'fetchData'
                },
                methods: {
                  fetchData () {
                    this.error = this.post = null
                    this.loading = true
                    // replace getPost with your data fetching util / API wrapper
                    getPost(this.$route.params.id, (err, post) => {
                      this.loading = false
                      if (err) {
                        this.error = err.toString()
                      } else {
                        this.post = post
                      }
                    })
                  }
                }
              }`
13. 滚动行为：history 模式下可用
14. 懒加载：

  
