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
4、注册组件:
  1、//template
    <template>
      html代码
    </template>
    <script>
      js代码
    </script>
    <style>
      CSS代码
    </style>
    <body>
      <div id="app">//#app是Vue实例挂载的元素，应该在挂载元素范围内使用组件
        <my-component></my-component>
      </div>
    </body>
  2、//创建一个组件构建器
    var myComponent = Vue.extend({
      template:"<div>This is myComponent</div>",
    })
    //注册组件,并指定组件的标签,组件的Html标签定义为<my-component>
    Vue.component("my-component",myComponent);//第一个参数为组件的标签，第二个参数为组件构造器
    //渲染页面
    new Vue({
      el:"#app"
    })
  3、var myComponent = Vue.extend({
      template:"<div>This is my Component</div>"
    })
    new Vue({
      el:"#app",
      component:{
        "my-component":myComponent
      }
    })
