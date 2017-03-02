1、安装:官方命令行工具
  1、npm install -g vue-cli //全局安装vue-cli命令行工具
  2、vue init webpack projectName //初始化一个基于webpack模板的新项目
  3、cd projectName 
  4、npm install //安装依赖
  5、npm run dev //启动服务
2、vue重要组件:
  1、data:{a:1,b:[]} // vue对象中的数据,
  2、methods:{doSomething:function(){
    cosole.log(this.a);
  }}//定义vue对象的方法
  3、watch:{'a':function(val,oldVal){
    console.log(val,oldVal);
  }}//对vue对象的监听
3、模板指令:写在Html中的指令
  1、{{}}:
  2、v-text:处理后的html数据
  3、v-html:保存了html结构的数据
  4、v-if:控制模块隐藏,不渲染html
  5、v-show:控制模块显示,渲染html
  6、v-for:循环渲染html
  7、v-on:click:事件绑定
    7.1 @click:事件绑定
  8、v-bind:src:
    8.1 :class="{red:isRed}"   [classA,classB]
4、数据观测的实现:
  1、AngularJs:数据观测采用的是脏检查(dirty checking)机制,每一个指令都有一个对应的用来观测数据的对象watcher,一个作用域中会有很多个watcher。
    每当界面需要更新时，Angular会遍历当前作用域里的所有watcher，对它们一一求值，然后和之前保存的旧值进行比较。
    如果求值的结果变化了,就触发对应的更新,这个过程叫做digest cycle,出现的问题:
      1、任何数据变动都意味着当前作用域的每一个watcher需要被重新求值,当watcher的数量庞大时,应用的性能会受到影响,优化困难
      2、当数据变动时,框架并不能主动侦测到变化的发生,需要手动触发digest cycle才能触发相应的DOM 更新,
        Angular通过在DOM事件处理函数中自动触发digest cycle部分规避了这个问题，但还是有很多情况需要用户手动进行触发
  2、VueJs:采用的则是基于依赖收集的观测机制,Vue.js利用了ES5的Object.defineProperty方法,直接将原生数据对象的属性改造为getter和setter,
      在这两个函数内部实现依赖的收集和触发,而且完美支持嵌套的对象结构
    1、将原生的数据改造成 “可观察对象”。一个可观察对象可以被取值,也可以被赋值
    2、在watcher的求值过程中,每一个被取值的可观察对象都会将当前的watcher注册为自己的一个订阅者,并成为当前watcher的一个依赖
    3、当一个被依赖的可观察对象被赋值时,它会通知所有订阅自己的watcher重新求值,并触发相应的更新
    4、依赖收集的优点在于可以精确、主动地追踪数据的变化,不存在上述提到的脏检查的两个问题
5、组件:扩展HTML元素，封装可重用的HTML代码
  1、核心概念:
    1、模板(Tmplate):模板声明了数据和最终展现给用户的DOM之间的映射关系
    2、初始数据(data):一个组件的初始数据状态.对于可复用的组件来说,这通常是私有的状态
    3、接受的外部参数(props):组件之间通过参数来进行数据的传递和共享.参数默认是单向绑定(由上至下),但也可以显式地声明为双向绑定
    4、方法(methods):对数据的改动操作一般都在组件的方法内进行,可以通过v-on指令将用户输入事件和组件方法进行绑定
    5、生命周期钩子函数(lifecycle hooks):一个组件会触发多个生命周期钩子函数，比如created，attached，destroyed等等。
        在这些钩子函数中，我们可以封装一些自定义的逻辑。
        和传统的MVC相比，可以理解为 Controller的逻辑被分散到了这些钩子函数中
    6、私有资源(assets):Vue.js当中将用户自定义的指令、过滤器、组件等统称为资源.
        由于全局注册资源容易导致命名冲突,一个组件可以声明自己的私有资源.
        有资源只有该组件和它的子组件可以调用
  2、全局注册:
    1、第一种方式:
      1、//定义组件
        eg:var defineComponent = Vue.extend({template:"<div>This is define component</div>"});
      2、//注册组件
        eg:Vue.component("global-component",defineComponent);
      3、//渲染组件
        eg:var vm = new Vue({el:"#globalComponent"});
    2、第二种方式:
      1、//定义和注册组件
        eg:Vue.component("global-component",{tempalte:"<div>This is signin global component"});
      2、//渲染组件
        eg:var vm = new Vue({el:"#globalComponent"});
  3、局部注册:
      eg:var vm2 = new Vue({
          el:"#local",
          components:{
            local:{
              template:"<p @click='change'>{{msg}}</p>",
              data:function(){
                return {msg:"这是局部注册的组件"}
              },
              methods:{
                change:function(){
                  console.log(this);
                }
              }
            }
          }
        })
  4、实例属性:
    vm.$data: Vue 实例观察的数据对象
    vm.$el: Vue 实例使用的根 DOM 元素
    vm.$options: 用于当前 Vue 实例的初始化选项
    vm.$parent: 父实例,如果当前实例有的话
    vm.$root: 当前组件树的根 Vue 实例
    vm.$children: 当前实例的直接子组件
    vm.$slots: 用来访问被 slot 分发的内容
    vm.$scopedSlots
    vm.$refs: 一个对象,其中包含了所有拥有 ref 注册的子组件
    vm.$isServer: 当前 Vue 实例是否运行于服务器





