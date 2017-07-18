### [README_E1.md](https://github.com/luoleiself/summary/blob/master/vueJs/VueRouter/README_E1.md)
### Router
   1. `<router-link>` => `<a href='...'>`
      * to： String | Object，required，表示目标路由的链接，可以是字符串或者对象，当点击时内部将 to 的值传递给 `router.push()`
```   
          <router-link to="home">Home</router-link> // 字符串
          <router-link :to="'home'">Home</router-link> // v-bind 绑定方式 
          <router-link :to="{ path: 'home' }">Home</router-link> // 对象方式
          <router-link :to="{ name: 'user', params: { userId: 123 }}">User</router-link> // 命名路由
          <router-link :to="{ path: 'register', query: { plan: 'private' }}">Register</router-link> // 带查询参数的路由
```
      * replace： Boolean，default：false，当点击时会调用 `router.replace()`，导航不会留下历史记录 
``` 
          <router-link :to="{ path: '/abc'}" replace></router-link>
```
      * append： Boolean，default：false，在当前(相对)路径前添加基路径，例如，我们从 /a 导航到一个相对路径 b，如果没有配置 append，则路径为 /b，如果配了，则为 /a/b
```
          <router-link :to="{ path: 'relative/path'}" append></router-link>
```
      * tag： String，default：'a'，指定以哪种标签渲染路由
```
          <router-link to="/foo" tag="li">foo</router-link>
          <!-- 渲染结果 -->
          <li>foo</li>
```
      * active-class： String，default：'router-link-active'，设置链接激活时使用的 CSS 类名，通过构造配置的 `linkActiveClass` 选项配置
      * exact： Boolean，default：false，是否激活" 默认类名的依据是 inclusive match （全包含匹配）。 举个例子，如果当前的路径是 /a 开头的，那么 <router-link to="/a"> 也会被设置 CSS 类名
      * events： String | Array&lt;String&gt;，default：false，声明可以用来触发导航的事件。可以是一个字符串或是一个包含字符串的数组
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
            redirect?: string | Location | Function;
            alias?: string | Array<string>;
            children?: Array<RouteConfig>; // for nested routes
            beforeEnter?: (to: Route, from: Route, next: Function) => void;
            meta?: any;
        }
```
 5. Router实例：
    1. 属性：
      * router.app： Vue instance，配置了 router 的 Vue 根实例
      * router.mode： String，default：'hash'，路由使用的模式
      * router.currentRoute：Route，当前路由对应的 路由信息对象
    2. 方法：
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

            


