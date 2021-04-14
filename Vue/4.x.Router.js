import { createApp } from 'vue';
import {
  createRouter,
  createWebHistory,
  createWebHashHistory,
  createMemoryHistory,
  useRouter,
  useRoute,
  useLink,
  RouterLink,
  onBeforeRouteLeave,
  onBeforeRouteUpdate,
  parseQuery,
  stringifyQuery,
} from 'vue-router';
// new Router 更改为 createRouter
// 变更 mode 配置项为 history 配置项, 并且需要调用适当的函数
const router = createRouter({
  history: createWebHistory(),
  history: createWebHashHistory(),
  history: createMemoryHistory(),
  routes: [],
});

// 移动 base 配置项被作为 createWebHistory 的第一个参数传递
createWebHistory('/app/');

// 删除 * 通配符路由

// 将 onReady 方法改为 isReady方法: 将一个回调排队, 在路由完成初始导航时调用, 它可以解析所有的异步进入钩子和路由初始化相关联的异步组件
router.onReady(onSuccess, onError);
router.isReady().then(onSuccess).catch(onError);

// scrollBehavior 返回的对象: x 改为 left, y 改为 top

// <router-view>、<keep-alive> 和 <transition> 必须通过 v-slot API 在 RouterView 内部使用
<router-view v-slot='{ Component }'>
  <transition>
    <keep-alive>{/* <component :is="Component" /> */}</keep-alive>
  </transition>
</router-view>;

// 删除 router-link 中的 append、event、tag、exact 属性, 可以使用 v-slot API 定制

// 忽略 mixins 中的导航守卫, 目前暂时不支持 mixins 中的导航守卫

// router.match 改为 router.resolve
// router.addRoutes 已废弃, 使用 router.addRoute 代替, Vue Router 3.x 已支持

// 删除 router.getMatchedComponents 方法, 可从 router.currentRoute.value.mixed 获取, 此方法只在 SSR 中使用

// 所有的导航现在都是异步的

// 删除 router.app, 表示注入路由的最后一个根组件, 现在可以被多个 Vue 程序同时安全使用
const app = createApp({}).use(router);
router.app = app;

// 将内容传递给路由组件的 <slot>
<router-view>
  <p>In Vue Router 3, I render inside the route component</p> // 此处错误, 需要使用 v-slot API, 见上方示例
</router-view>;

// parent 从路由地址中移除

// 删除 pathToRegexpOptions 配置项:
// pathToRegexpOptions 和 caseSensitive 被 createRouter API中的 sensitive 和 strict 配置取代

// 取消 path-to-regexp, 删除未命名的参数

// 参数格式化
console.log(stringifyQuery({ name: 'hello', age: 18 }));
console.log(parseQuery('name=Hello&age=18'));

// 组合式 API
// useRouter 路由实例
// useRoute  路由信息对象
// useLink 将 RouterLink 的内部行为作为一个组合式 API 函数公开
// onBeforeRouteLeave 当组件离开之前触发
// onBeforeRouteUpdate 当作组件更新之前触发
export default {
  props: {
    ...RouterLink.props,
  },
  setup(props, { attrs, emit, slots }) {
    const router = useRouter(); // 路由实例
    const route = useRoute(); // 路由信息对象

    const { route, href, isActive, isExactActive, navigate } = useLink(props);

    // 无法访问 this
    onBeforeRouteLeave((to, from) => {
      const query = {
        name: Math.random().toString(16).toUpperCase().substr(2),
        age: Math.ceil(Math.random() * 100),
      };
      const sQuery = stringifyQuery(query);
      const pQuery = parseQuery(sQuery);
      console.log('onBeforeRouteLeave use Vue-Router 4.x stringifyQuery %s parseQuery %o', sQuery, pQuery);
      router.replace({ query: pQuery });
    });

    // 无法访问 this
    onBeforeRouteUpdate((to, from) => {
      const query = {
        name: Math.random().toString(16).toUpperCase().substr(2),
        age: Math.ceil(Math.random() * 100),
      };
      const sQuery = stringifyQuery(query);
      const pQuery = parseQuery(sQuery);
      console.log('onBeforeRouteUpdate use Vue-Router 4.x stringifyQuery %s parseQuery %o', sQuery, pQuery);
      router.replace({ query: pQuery });
    });

    return {};
  },
  beforeMount() {
    console.log('beforeMount... ', this.$router, this.$route);
  },
};
