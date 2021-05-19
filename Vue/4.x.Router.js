// vue-router@4.0.6
import { createApp, defineComponent } from 'vue';
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
router.onReady(onSuccess, onError); // 方法已废弃
router.isReady().then(onSuccess).catch(onError);

// scrollBehavior 返回的对象: x 改为 left, y 改为 top

// <router-view>、<keep-alive> 和 <transition> 必须通过 v-slot API 在 RouterView 内部使用
<router-view v-slot='{ Component }'>
  <transition name="fade">
    <keep-alive>{/* <component :is="Component" /> */}</keep-alive>
  </transition>
</router-view>;

// 删除 router-link 中的 append、event、tag、exact 属性, 可以使用 v-slot API 定制
<router-link to="/about" custom v-slot='{ navigate }'>
  <span v-on:click="navigate" role="link">About</span>
</router-link>

// 忽略 mixins 中的导航守卫, 目前暂时不支持 mixins 中的导航守卫

// router.match 改为 router.resolve

// router.addRoutes 已废弃, 使用 router.addRoute 代替, Vue Router 3.x 已支持
router.addRoute(parentName, route); // 添加子路由

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

// 带有空 path 的命名子路由不再添加斜线
const routes = [
  {
    path: '/parent',
    component: Parent,
    children: [
      { path: '', redirect: 'home' }, // 将重定向到 '/home' 非 '/parent/home'
      { path: 'home', component: Home },
    ],
  },
];

// $route 属性编码, params, query, hash 中的编码保持一致, 便于使用

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

// RouterLink 实现源码 -> vue-router@4.0.6
const RouterLinkImpl = defineComponent({
  name: 'RouterLink',
  props: {
    to: {
      type: [String, Object],
      required: true,
    },
    replace: Boolean,
    activeClass: String,
    // inactiveClass: String,
    exactActiveClass: String,
    custom: Boolean,
    ariaCurrentValue: {
      type: String,
      default: 'page',
    },
  },
  setup(props, { slots }) {
    const link = vue.reactive(useLink(props));
    const { options } = vue.inject(routerKey);
    const elClass = vue.computed(() => ({
      [getLinkClass(props.activeClass, options.linkActiveClass, 'router-link-active')]: link.isActive,
      // [getLinkClass(
      //   props.inactiveClass,
      //   options.linkInactiveClass,
      //   'router-link-inactive'
      // )]: !link.isExactActive,
      [getLinkClass(
        props.exactActiveClass,
        options.linkExactActiveClass,
        'router-link-exact-active'
      )]: link.isExactActive,
    }));
    {
      const instance = vue.getCurrentInstance();
      vue.watchEffect(
        () => {
          if (!instance) return;
          instance.__vrl_route = link.route;
        },
        {
          flush: 'post',
        }
      );
      vue.watchEffect(
        () => {
          if (!instance) return;
          instance.__vrl_active = link.isActive;
          instance.__vrl_exactActive = link.isExactActive;
        },
        {
          flush: 'post',
        }
      );
    }
    return () => {
      const children = slots.default && slots.default(link);
      return props.custom
        ? children
        : vue.h(
            'a',
            {
              'aria-current': link.isExactActive ? props.ariaCurrentValue : null,
              href: link.href,
              // this would override user added attrs but Vue will still add
              // the listener so we end up triggering both
              onClick: link.navigate,
              class: elClass.value,
            },
            children
          );
    };
  },
});
// RouterView 实现源码 -> vue-router@4.0.6
const RouterViewImpl = defineComponent({
  name: 'RouterView',
  // #674 we manually inherit them
  inheritAttrs: false,
  props: {
    name: {
      type: String,
      default: 'default',
    },
    route: Object,
  },
  setup(props, { attrs, slots }) {
    warnDeprecatedUsage();
    const injectedRoute = vue.inject(routerViewLocationKey);
    const routeToDisplay = vue.computed(() => props.route || injectedRoute.value);
    const depth = vue.inject(viewDepthKey, 0);
    const matchedRouteRef = vue.computed(() => routeToDisplay.value.matched[depth]);
    vue.provide(viewDepthKey, depth + 1);
    vue.provide(matchedRouteKey, matchedRouteRef);
    vue.provide(routerViewLocationKey, routeToDisplay);
    const viewRef = vue.ref();
    // watch at the same time the component instance, the route record we are
    // rendering, and the name
    vue.watch(
      () => [viewRef.value, matchedRouteRef.value, props.name],
      ([instance, to, name], [oldInstance, from, oldName]) => {
        // copy reused instances
        if (to) {
          // this will update the instance for new instances as well as reused
          // instances when navigating to a new route
          to.instances[name] = instance;
          // the component instance is reused for a different route or name so
          // we copy any saved update or leave guards. With async setup, the
          // mounting component will mount before the matchedRoute changes,
          // making instance === oldInstance, so we check if guards have been
          // added before. This works because we remove guards when
          // unmounting/deactivating components
          if (from && from !== to && instance && instance === oldInstance) {
            if (!to.leaveGuards.size) {
              to.leaveGuards = from.leaveGuards;
            }
            if (!to.updateGuards.size) {
              to.updateGuards = from.updateGuards;
            }
          }
        }
        // trigger beforeRouteEnter next callbacks
        if (
          instance &&
          to &&
          // if there is no instance but to and from are the same this might be
          // the first visit
          (!from || !isSameRouteRecord(to, from) || !oldInstance)
        ) {
          (to.enterCallbacks[name] || []).forEach((callback) => callback(instance));
        }
      },
      {
        flush: 'post',
      }
    );
    return () => {
      const route = routeToDisplay.value;
      const matchedRoute = matchedRouteRef.value;
      const ViewComponent = matchedRoute && matchedRoute.components[props.name];
      // we need the value at the time we render because when we unmount, we
      // navigated to a different location so the value is different
      const currentName = props.name;
      if (!ViewComponent) {
        return normalizeSlot(slots.default, {
          Component: ViewComponent,
          route,
        });
      }
      // props from route configuration
      const routePropsOption = matchedRoute.props[props.name];
      const routeProps = routePropsOption
        ? routePropsOption === true
          ? route.params
          : typeof routePropsOption === 'function'
          ? routePropsOption(route)
          : routePropsOption
        : null;
      const onVnodeUnmounted = (vnode) => {
        // remove the instance reference to prevent leak
        if (vnode.component.isUnmounted) {
          matchedRoute.instances[currentName] = null;
        }
      };
      const component = vue.h(
        ViewComponent,
        assign({}, routeProps, attrs, {
          onVnodeUnmounted,
          ref: viewRef,
        })
      );
      return (
        // pass the vnode to the slot as a prop.
        // h and <component :is="..."> both accept vnodes
        normalizeSlot(slots.default, {
          Component: component,
          route,
        }) || component
      );
    };
  },
});
// createRouter 部分实现源码 -> vue-router@4.0.6
function createRouter(options) {
  /*.....*/
  const router = {
    currentRoute,
    addRoute,
    removeRoute,
    hasRoute,
    getRoutes,
    resolve,
    options,
    push,
    replace,
    go,
    back: () => go(-1),
    forward: () => go(1),
    beforeEach: beforeGuards.add,
    beforeResolve: beforeResolveGuards.add,
    afterEach: afterGuards.add,
    onError: errorHandlers.add,
    isReady,
    install(app) {
      const router = this;
      app.component('RouterLink', RouterLink);
      app.component('RouterView', RouterView);
      app.config.globalProperties.$router = router;
      Object.defineProperty(app.config.globalProperties, '$route', {
        get: () => vue.unref(currentRoute),
      });
      // this initial navigation is only necessary on client, on server it doesn't
      // make sense because it will create an extra unnecessary navigation and could
      // lead to problems
      if (
        isBrowser &&
        // used for the initial navigation client side to avoid pushing
        // multiple times when the router is used in multiple apps
        !started &&
        currentRoute.value === START_LOCATION_NORMALIZED
      ) {
        // see above
        started = true;
        push(routerHistory.location).catch((err) => {
          warn('Unexpected error when starting the router:', err);
        });
      }
      const reactiveRoute = {};
      for (let key in START_LOCATION_NORMALIZED) {
        // @ts-ignore: the key matches
        reactiveRoute[key] = vue.computed(() => currentRoute.value[key]);
      }
      app.provide(routerKey, router);
      app.provide(routeLocationKey, vue.reactive(reactiveRoute));
      app.provide(routerViewLocationKey, currentRoute);
      let unmountApp = app.unmount;
      installedApps.add(app);
      app.unmount = function () {
        installedApps.delete(app);
        if (installedApps.size < 1) {
          removeHistoryListener();
          currentRoute.value = START_LOCATION_NORMALIZED;
          started = false;
          ready = false;
        }
        unmountApp();
      };
      {
        addDevtools(app, router, matcher);
      }
    },
  };
  return router;
  /*.....*/
}
exports.RouterLink = RouterLinkImpl; // 导出
exports.RouterView = RouterViewImpl; // 导出
exports.createRouter = createRouter; // 导出
exports.routerKey = /*#__PURE__*/ PolySymbol('router'); // 导出
