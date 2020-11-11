# React

## 深入 JSX

### 指定 React 元素类型

- React 必须在作用域内,否则无法编译

- JSX 类型中使用点语法

```javascript
import React from 'react';

const MyComponents = {
  DatePicker: function DatePicker(props) {
    return <div>Imagine a {props.color} datepicker here.</div>;
  },
};

function BlueDatePicker() {
  // MyComponents.DatePicker 是一个组件
  return <MyComponents.DatePicker color='blue' />;
}
```

- 自定义的组件必须以大写字母开头

### JSX 中的 Props

- JavaScript 表达式作为 Props

- 字符串字面量

```javascript
// 两个JSX表达式是等价的,
<MyComponent message="hello world" />
<MyComponent message={'hello world'} />
// 字符串字面量赋值给 prop 时，它的值是未转义的
<MyComponent message="&lt;3" />
<MyComponent message={'<3'} />
```

- Props 默认值为 True

```javascript
<MyTextBox autocomplete />
<MyTextBox autocomplete={true} />
```

- 属性展开

```javascript
// 此方法容易将不必要的 props 传递给不相关的组件，
// 或者将无效的 HTML 属性传递给 DOM,谨慎使用该语法.
const Button = (props) => {
  const { kind, ...other } = props;
  const className = kind === 'primary' ? 'PrimaryButton' : 'SecondaryButton';
  return <button className={className} {...other} />;
};

const App = () => {
  return (
    <div>
      <Button kind='primary' onClick={() => console.log('clicked!')}>
        Hello World!
      </Button>
    </div>
  );
};
```

### JSX 中的子元素

- 字符串字面量,

  > 包含在开始和结束标签之间的 JSX 表达式内容将作为特定属性 props.children 传递给外层组件.

  ```javascript
  <MyComponent>Hello world!</MyComponent>
  <div>This is valid HTML &amp; JSX at the same time.</div>
  ```

  - JSX 会移除行首尾的空格以及空行。

  - 与标签相邻的空行均会被删除，文本字符串之间的新行会被压缩为一个空格

- JSX 子元素

  - 字符串字面量与 JSX 子元素

  ```javascript
  <div>
    Here is a list:
    <ul>
      <li>Item 1</li>
      <li>Item 2</li>
    </ul>
  </div>
  ```

  - React 返回存储在数组中的一组元素

  ```javascript
    render() {
      // 不需要用额外的元素包裹列表元素！
      return [
        // 不要忘记设置 key :)
        <li key="A">First item</li>,
        <li key="B">Second item</li>,
        <li key="C">Third item</li>,
      ];
    }
  ```

- JavaScript 表达式作为子元素

- 函数作为子元素

```javascript
// 调用子元素回调 numTimes 次，来重复生成组件
function Repeat(props) {
  let items = [];
  for (let i = 0; i < props.numTimes; i++) {
    items.push(props.children(i));
  }
  return <div>{items}</div>;
}

function ListOfTenThings() {
  return <Repeat numTimes={10}>{(index) => <div key={index}>This is item {index} in the list</div>}</Repeat>;
}
```

- 布尔类型、Null 以及 Undefined 将会忽略

```javascript
false, null, undefined, and true 是合法的子元素。但它们并不会被渲染
// 以下表达式的渲染结果相同
<div />

<div></div>

<div>{false}</div>

<div>{null}</div>

<div>{undefined}</div>

<div>{true}</div>
```

## React.Component

### 组件的生命周期

#### 挂载

- constructor(props)
  - 初始化内部 state，只能在构造函数中直接为 state 赋值，其他方法中应使用 this.setState()
  - 为事件处理函数绑定实例
- static getDerivedStateFromProps(props, state)
- render() class 组件中唯一必须实现的方法, 返回以下类型之一
  - React 元素
  - 数组或者 Fragments
  - Portals
  - 字符串或者数值类型
  - 布尔类型或者 null,什么都不渲染
- componentDidMount()
  - 组件挂载后立即调，DOM 节点的初始化应该放在这里

#### 更新

- static getDerivedStateFromProps(props, state)
  - 在 render() 方法执行前调用, 初始化挂载及后续更新都会被调用
  - 返回一个对象来更新 state, 如果返回 null, 则不更新任何内容
  - 无法访问组件实例
- shouldComponentUpdate(nextProps, nextState)
  - 返回值影响组件是否会重新渲染
  - 默认返回值为 true
  - 首次渲染或者使用 forceUpdate() 时不会调用该方法
  - 返回 false 不会调用 render() 和 componentDidUpdate() 方法
- render()
- getSnapshotBeforeUpdate(prevProps, prevState)
  - 在最近一次渲染输出(提交到 DOM 节点)之前调用
  - 返回值作为 componentDidUpdate 方法的第三个参数 snapshot 传递,否则此参数为 undefined
- componentDidUpdate(prevProps, prevState, snapshot)

#### 卸载

- componentWillUnmount() 组件卸载及销毁之前直接调用,此方法中不应该使用 setState() 方法,组件不会被重新渲染

#### 错误处理

- static getDerivedStateFromError(error)
  - 接收一个后代组件抛出错误作为参数并被调用
  - 返回一个值更新 state
- componentDidCatch(error, info)

- 其中任何一个方法都可以将组件变成 Error Boundaries 组件

#### 其他 APIs

- setState(updater, [callback])
  - updater 可以为函数
    - (state, props) => ({})
- forceUpdate(callback)
  - 此方法会跳过组件的 shouldComponentUpdate() 方法，其子组件可正常触发此方法

#### class 属性

- defaultProps
  - 为 Class 组件添加默认 props
- displayName 用于调试信息展示

#### 实例属性

- props
  - props.children JSX 表达式中的子组件组成
- state
