### VueJs [官网](https://cn.vuejs.org) iView [Vue UI](https://www.iviewui.com/)
> computed 和  watched 属性
   
    `var vm = new Vue({
        el:"#app",
        data:{
          firstName: "Foo",
          lastName: "Bar
        },
        /*watch:{
          firstName: function(val) {
            this.fullName = val + " " + this.lastName;
          },
          lastName: function(val) {
            this.fullName = this.firstName + " " + val;
          }
        },*/
        /*computed: {
          fullName: function() {
            return this.firstName + " " + this.lastName;
          }
        },*/
        computed: {
          fullName: {
            get: function() {
              return this.firstName + " " + this.lastName;
            },
            set: function(newVal) {
              var names = newVal.split(" ");
              this.firstName = names[0];
              this.lastName = names[names.length - 1];
            }
          }
        }
    })`
## 修饰符
   1. **事件**修饰符:
      `.stop.prevent.capture.self.once` `.native:监听原生事件` `.sync:双向数据绑定-语法糖`
   2. **按键**修饰符:
      `.enter.tab.delete.esc.space.up.down.left.right .ctrl.alt.shift.meta`
   3. **v-model**:
      `.lazy .number .trim`
   4. slot name;template scope;component is;ref
## 组件 :Props(外->内),Events(内->外),Slots(额外添加)
   1. 作用域独立,父子组件通信`prop down,events up`
   2. data必须是函数,每个组件有独立的data对象互不影响
   3. Prop验证:需要用对象的形式,而不能用字符串数组

          `props:{    
            propA:{
              type:String,
              required:true 
            },
            propB:[String,Number],
            propC:{
              type:Number,
              default:100
            },
            propD:{
              type:Object,
              default:function(){
                return {}
              }
            },
            propE:{
              validator:function(value){
                return value > 10;
              }
            }
          }`
   4. 自定义事件: 父组件监听子组件绑定事件,由子组件触发事件

          `<div id="app-5">
             <p>{{total}}</p>
             <button-counter v-on:increment="incrementTotal"></button-counter>
             <button-counter v-on:increment="incrementTotal"></button-counter>
           </div>
           var app5 = new Vue({
            el:"#app-5",
            data: {
              total: 0
            },
            methods: {
              incrementTotal: function() {
                this.total++;
              }
            },
            components: {
              'button-counter': {
                template: "<button v-on:click='increment'>{{counter}}</button>",
                data: function() {
                  return {
                    counter: 0
                  }
                },
                methods: {
                  increment: function() {
                    this.counter++;
                    this.$emit('increment');
                  }
                }
              }
            }
          })`
   5. slot：内容分发,混合父组件的内容与子组件自己的模板(组件的组合)
      1. 单个slot：除非子组件模板包含至少一个 `<slot>` 插口，否则父组件的内容将会被丢弃,当子组件模板只有一个没有属性的 `<slot>` 时，父组件整个内容片段将插入到 `<slot>` 所在的 DOM 位置，并替换掉 `<slot>` 标签本身
          > 最初在 `<slot>` 标签中的任何内容都被视为备用内容，备用内容在子组件的作用域内编译，并且只有在宿主元素为空，且没有要插入的内容时才显示备用内容
      
                `<div id="app-6">
                   <h3>这是父组件的标题</h3>
                   <child-component>
                     <p>这是一些初始内容</p>
                     <p>这是更多的初始内容</p>
                   </child-component>
                 </div>
                 var app6 = new Vue({
                    el: "#app-6",
                    components: {
                      "child-component": {
                        template: "<div><h3>这是子组件的标题</h3><slot>宿主内容为空才会显示该内容</slot></div>"
                      }
                    }
                 })`
      2. 具名slot：可以用一个特殊的属性 name 来配置如何分发内容。多个 `<slot>` 可以有不同的名字。具名 `<slot>` 将匹配内容片段中有对应 `<slot>` 特性的元素 
          > 仍然可以有一个匿名 `<slot>` ，它是默认 `<slot>` ，作为找不到匹配的内容片段的备用插槽。如果没有默认的 `<slot>` ，这些找不到匹配的内容片段将被抛弃
              
                `<div id="app-7">
                    <app-layout>
                      <h3 slot="header">设置name属性的slot的header</h3>
                      <p>没有设置slot属性的显示信息main1</p>
                      <p>没有设置slot属性的显示信息main2</p>
                      <h3 slot="footer">设置name属性的slot的footer</h3>
                    </app-layout>
                 </div>
                 var app7 = new Vue({
                    el:"#app-7",
                    components:{
                      'app-layout':{
                        template:"<div class='container'>
                                    <header>
                                       <slot name='header'>宿主元素为空时显示</slot>
                                    </header>
                                    <main>
                                       <slot>宿主元素为空时显示</slot>
                                    </main>
                                    <footer>
                                       <slot name='footer'>宿主元素为空时显示</slot>
                                    </footer>
                                  </div>"
                      }
                    }
                 })`
      3. 作用域插槽：是一种特殊类型的插槽，用作使用一个（能够传递数据到）可重用模板替换已渲染元素，在子组件中，只需将数据传递到插槽，就像你将 prop 传递给组件一样
          > 具有特殊属性 scope 的 `<template>` 元素，表示它是作用域插槽的模板。scope 的值对应一个临时变量名，此变量接收从子组件中传递的 prop 对象

                `<div id="app-8" class="parent">
                    <child>
                      <template scope="props">
                        <p>Hello from parent</p>
                        <p>{{props.text}}</p>
                      </template>
                    </child>
                </div>
                var app8 = new Vue({
                    el: "#app-8",
                    components: {
                      'child': {
                        template: "<div class='child'>
                                      <slot text='Hello from child'></slot>
                                   </div>"
                      }
                    }
                 })`
                 
            **作用域插槽列表组件应用,`<template>`元素也可以使用slot属性**
            
                `<div id='app-9'>
                    <my-awesome-list :items="items">
                      <!-- 作用域插槽也可以是具名的 -->
                      <template slot="item" scope="props">
                        <li class="my-fancy-item">{{ props.text }}</li>
                      </template>
                    </my-awesome-list>
                 </div>
                 var app9 = new Vue({
                    el: "#app-9",
                    data: {
                      items: [{
                        text: "item-1"
                      }, {
                        text: "item-2"
                      }, {
                        text: "item-3"
                      }, {
                        text: "item-4"
                      }]
                    },
                    components: {
                      'my-awesome-list': {
                        template: '<ul>
                                    <slot name="item" v-for="item in items" :text="item.text"></slot>
                                   </ul>',
                        props: ["items"]
                      }
                    }
                 })`
   6. 动态组件:通过使用保留的 `<component>` 元素，动态地绑定到它的 `is` 特性，我们让多个组件可以使用同一个挂载点
      
          `<div id="app-10">
              <componet :is="currentView"></component>
           </div>
           var app10 = new Vue({
              el: "#app-10",
              data: {
                 currentView: "home"
              },
              components: {
                 home: {template: "<p>this is a home page</p>"},
                 posts: {template: "<p>this is a posts page</p>"},
                 archive: {template: "<p>this is a archive page</p>"}
              }
            })`

   7. 内联模板：如果子组件有 inline-template 特性，组件将把它的内容当作它的模板，而不是把它当作分发内容
          
          `<my-component inline-template>
              <div>
                <p>These are compiled as the component's own template.</p>
                <p>Not parent's transclusion content.</p>
              </div>
           </my-component>`
   8. X-templates：在 JavaScript 标签里使用 text/x-template 类型，并且指定一个id

          `<script type="text/x-template" id="hello-world-template">
              <p>Hello hello hello</p>
           </script>
           Vue.component('hello-world', {
              template: '#hello-world-template'
           })`
## 响应式
   1. 响应属性和对象的绑定
      1. Vue.set(vm.someObject,key,value); // 将响应属性添加到对象上
      2. vm.$set(vm.someObject,key,value); // Vue.Set方法的别名
   2. 异步更新队列： Vue.nextTick(callback);
      > Vue 异步执行 DOM 更新，只要观察到数据变化，Vue 将开启一个队列，并缓冲在同一事件循环中发生的所有数据改变。如果同一个 watcher 被多次触发，只会一次推入到队列中。这种在缓冲时去除重复数据对于避免不必要的计算和 DOM 操作上非常重要
        
            `var vm = new Vue({
                el: '#example',
                data: {
                  message: '123'
                }
             })
             vm.message = 'new message' // 更改数据
             vm.$el.textContent === 'new message' // false
             Vue.nextTick(function () {
                vm.$el.textContent === 'new message' // true
             })` 

          **回调函数在 DOM 更新完成后就会调用**

            `Vue.component('example', {
               template: '<span>{{ message }}</span>',
               data: function () {
                  return {
                    message: '没有更新'
                  }
               },
               methods: {
                  updateMessage: function () {
                    this.message = '更新完成'
                    console.log(this.$el.textContent) // => '没有更新'
                    this.$nextTick(function () {
                      console.log(this.$el.textContent) // => '更新完成'
                    })
                  }
               }
             })`
## 过渡组件:`<transition name=''>`
   1. 过渡的类名：
      `v-enter;v-enter-active;v-enter-to;;v-leave;v-leave-active;v-leave-to`
   2. 自定义过渡类名:`enter-class;enter-active-class;leave-class;leave-active-class`
 
           `<div id="app-2">
              <button @click="show = !show">
                Toggle render
              </button>
              <transition name="custom-classes-transition" enter-active-class="animated tada" leave-active-class="animated bounceOutRight">
                <p v-if="show">hello</p>
              </transition>
            </div>
            var app2 = new Vue({
              el: '#app-2',
              data: {
                show: true
              }
            })`
  3. 初始渲染过渡和Js钩子：`appear appear-class appear-active-class`
            
            `<transition appear appear-class="" appear-active-class="" v-on:before-appear='' v-on:appear=''>
                <!-- **** -->
             </transition>`
  4. 列表渲染： `transition-group` [FLIP](https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.14.1/lodash.min.js)
    * 默认渲染为 `span` ，通过 `tag` 特性指定标签
    * 内部元素需要提供唯一的 `key` 属性值 
    * `transition-group` 的 `v-move` 特性
  5. 列表位移渲染：

            `<style>
              .list-complete-item {
                transition: all 1s;
                display: inline-block;
                margin-right: 10px;
              }
              .list-complete-enter,
              .list-complete-leave-active {
                opacity: 0;
                transform: translateY(30px);
              }
              .list-complete-leave-active {
                position: absolute;
              }
            </style>
            <button v-on:click="shuffle">Shuffle</button>
            <button v-on:click="add">Add</button>
            <button v-on:click="remove">Remove</button>
            <transition-group name="list-complete" tag="p">
              <span v-for="item in items" v-bind:key="item" class="list-complete-item">
              {{ item }}
            </span>
            </transition-group>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.14.1/lodash.min.js"></script>
            var app6 = new Vue({
              el: '#app-6',
              data: {
                items: [1, 2, 3, 4, 5, 6, 7, 8, 9],
                nextNum: 10
              },
              methods: {
                randomIndex: function() {
                  return Math.floor(Math.random() * this.items.length)
                },
                add: function() {
                  this.items.splice(this.randomIndex(), 0, this.nextNum++)
                },
                remove: function() {
                  this.items.splice(this.randomIndex(), 1)
                },
                shuffle: function() {
                  this.items = _.shuffle(this.items)
                }
              }
            })`
   6. 列表渐进渲染：
            
            `<script src="https://cdnjs.cloudflare.com/ajax/libs/velocity/1.2.3/velocity.min.js"></script>
             <div id="app-7">
               <input v-model="query">
               <transition-group name="staggered-fade" tag="ul" v-bind:css="false" v-on:before-enter="beforeEnter" v-on:enter="enter" v-on:leave="leave">
                 <li v-for="(item, index) in computedList" v-bind:key="item.msg" v-bind:data-index="index">
                   {{ item.msg }}
                 </li>
               </transition-group>
             </div>
             var app7 = new Vue({
                  el: '#app-7',
                  data: {
                    query: '',
                    list: [{
                      msg: 'Bruce Lee'
                    }, {
                      msg: 'Jackie Chan'
                    }, {
                      msg: 'Chuck Norris'
                    }, {
                      msg: 'Jet Li'
                    }, {
                      msg: 'Kung Fury'
                    }]
                  },
                  computed: {
                    computedList: function() {
                      var vm = this
                      return this.list.filter(function(item) {
                        return item.msg.toLowerCase().indexOf(vm.query.toLowerCase()) !== -1
                      })
                    }
                  },
                  methods: {
                    beforeEnter: function(el) {
                      el.style.opacity = 0
                      el.style.height = 0
                    },
                    enter: function(el, done) {
                      var delay = el.dataset.index * 150
                      setTimeout(function() {
                        Velocity(
                          el, {
                            opacity: 1,
                            height: '1.6em'
                          }, {
                            complete: done
                          }
                        )
                      }, delay)
                    },
                    leave: function(el, done) {
                      var delay = el.dataset.index * 150
                      setTimeout(function() {
                        Velocity(
                          el, {
                            opacity: 0,
                            height: 0
                          }, {
                            complete: done
                          }
                        )
                      }, delay)
                    }
                  }
                })`
        