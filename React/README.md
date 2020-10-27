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
