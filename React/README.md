# React

## 设计思想

### 变换

> 设计 React 的核心前提是认为 UI 只是把数据通过映射关系变换成另一种形式的数据。同样的输入必会有同样的输出。这恰好就是纯函数。

### 抽象

> 需要把 UI 抽象成多个隐藏内部细节，又可复用的函数。通过在一个函数中调用另一个函数来实现复杂的 UI

### 组合

> 将两个或者多个不同的抽象通过组合再次抽象成一个抽象

### 状态

> 使用不可变的数据模型, 把可以改变 state 的函数串联起来作为原点放置在顶层

## 深入 JSX

### 指定 React 元素类型

- React 必须在作用域内,否则无法编译

- JSX 类型中使用点语法

  ```jsx
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

  ```jsx
  // 两个JSX表达式是等价的,
  <MyComponent message="hello world" />
  <MyComponent message={'hello world'} />
  // 字符串字面量赋值给 prop 时，它的值是未转义的
  <MyComponent message="&lt;3" />
  <MyComponent message={'<3'} />
  ```

- Props 默认值为 True

  ```jsx
  <MyTextBox autocomplete />
  <MyTextBox autocomplete={true} />
  ```

- 属性展开

  ```jsx
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

  ```jsx
  <MyComponent>Hello world!</MyComponent>
  <div>This is valid HTML &amp; JSX at the same time.</div>
  ```

  - JSX 会移除行首尾的空格以及空行。

  - 与标签相邻的空行均会被删除，文本字符串之间的新行会被压缩为一个空格

- JSX 子元素

  - 字符串字面量与 JSX 子元素

    ```jsx
    <div>
      Here is a list:
      <ul>
        <li>Item 1</li>
        <li>Item 2</li>
      </ul>
    </div>
    ```

  - React 返回存储在数组中的一组元素

    ```jsx
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

  ```jsx
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

  ```jsx
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
  - 在 render() 方法执行前调用, 初始化挂载及后续更新都会被调用
  - 返回一个对象来更新 state, 如果返回 null, 则不更新任何内容
  - 无法访问组件实例
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
    - (state, props) => ({ })
  - 回调函数可在更新完 state 之后获取 state 的状态
- forceUpdate(callback)
  - 此方法会跳过组件的 shouldComponentUpdate() 方法，其子组件可正常触发此方法

#### class 属性

- defaultProps
  - 为 Class 组件添加默认 props
- displayName 用于调试信息展示

#### 实例属性

- props
  - props.children JSX 表达式中的子组件组成
- state 4 种条件判定是否可作为 state
  - 这个变量是否通过 props 从父组件种获取，如果是，则不是一个状态
  - 这个变量是否在组件的整个生命周期中都保持不变，如果是，则不是一个状态
  - 这个变量是否可以通过其他状态(state)或者属性(props)计算得到，如果是，则不是一个状态
  - 这个变量是否在组件的 render 方法中使用，如果不是，则不是一个状态

## DOM 元素

### 属性差异

> 在 React 中，所有的 DOM 特性和属性（包括事件处理）都应该是小驼峰命名的方式。例如，与 HTML 中的 tabindex 属性对应的 React 的属性是 tabIndex。例外的情况是 aria-_ 以及 data-_ 属性，一律使用小写字母命名。比如, 你依然可以用 aria-label 作为 aria-label。

- checked
  - 受控组件可以设置是否被选中
  - defaultChecked 非受控组件的属性，用于设置首次挂载时是否被选中
- className 指定 CSS 的 class
  - web Components 中使用 class 属性代替
- dangerouslySetInnerHTML React 为浏览器 DOM 提供 innerHTML 的替换方案

  - 直接设置 HTML 存在风险
  - key 为 \_\_html

  ```jsx
  function createMarkup() {
    return { __html: 'First &middot; Second' };
  }

  function MyComponent() {
    return <div dangerouslySetInnerHTML={createMarkup()} />;
  }
  ```

- htmlFor JavaScript 中的保留字，React 元素中需要使用 htmlFor 代替

  ```jsx
  <label htmlFor="htmlFor">htmlFor</label>
  <input name="htmlFor" id="htmlFor" value="" />
  ```

- onChange 表单字段变化时，该事件会被触发
- selected 如果将 option 标记为已选中状态时，需要在 option 中引用此选项
- style 不推荐使用此属性设置元素的样式，多数情况下，使用 className 属性代替
- suppressContentEditableWarning 此属性禁用 当 DOM 元素拥有 contentEditable 属性时，React 发出警告
- suppressHydrationWarning 此属性禁用 如果 React 服务器与客户端渲染不同的内容时发出警告
- value 受控组件的属性，非受控组件设置 defaultValue

### All Supported HTML Attributes

```html
accept acceptCharset accessKey action allowFullScreen alt async autoComplete autoFocus autoPlay capture cellPadding
cellSpacing challenge charSet checked cite classID className colSpan cols content contentEditable contextMenu controls
controlsList coords crossOrigin data dateTime default defer dir disabled download draggable encType form formAction
formEncType formMethod formNoValidate formTarget frameBorder headers height hidden high href hrefLang htmlFor httpEquiv
icon id inputMode integrity is keyParams keyType kind label lang list loop low manifest marginHeight marginWidth max
maxLength media mediaGroup method min minLength multiple muted name noValidate nonce open optimum pattern placeholder
poster preload profile radioGroup readOnly rel required reversed role rowSpan rows sandbox scope scoped scrolling
seamless selected shape size sizes span spellCheck src srcDoc srcLang srcSet start step style summary tabIndex target
title type useMap value width wmode wrap
```

- 自定义属性，属性名需要全小写

## 合成事件

### SyntheticEvent 事件包装器

#### 属性

> 事件处理函数返回 false 不再阻止事件冒泡，需要手动调用 e.stopPropagation() 或者 e.preventDefault()

- boolean bubbles
- boolean cancelable
- DOMEventTarget currentTarget
- boolean defaultPrevented
- number eventPhase
- boolean isTrusted
- DOMEvent nativeEvent 浏览器底层事件
- void preventDefault()
- boolean isDefaultPrevented()
- void stopPropagation()
- boolean isPropagationStopped()
- void persist()
- DOMEventTarget target
- number timeStamp
- string type

#### 事件池

> SyntheticEvent 是合成事件，事件回调函数被调用后，所有属性都会失效，异步访问事件无效，解决方案：需要在事件上调用 e.persist(), 此方法会从池中移除合成事件，允许保留对事件的引用

```jsx
function onClick(event) {
  console.log(event); // => nullified object.
  console.log(event.type); // => "click"
  const eventType = event.type; // => "click"

  setTimeout(function () {
    console.log(event.type); // => null
    console.log(eventType); // => "click"
  }, 0);

  // 不起作用，this.state.clickEvent 的值将会只包含 null
  this.setState({ clickEvent: event });

  // 你仍然可以导出事件属性
  this.setState({ eventType: event.type });
}
```

#### 支持的事件

> 默认的事件处理函数在冒泡阶段触发，如果需要在捕获阶段触发，需要为事件名添加 Capture

```jsx
onClick => // 冒泡阶段触发
onClickCapture => // 捕获阶段触发
```

##### 剪贴板事件

- 事件名
  - onCopy onCut onPast
- 属性
  - DOMDataTransfer clipboardData

##### 复合事件

- 事件名
  - onCompositionEnd onCompositionStart onCompositionUpdate
- 属性
  - string data

##### 键盘事件

- 事件名
  - onKeyDown onKeyPress onKeyUp
- 属性
  - boolean altKey
  - number charCode
  - boolean ctrlKey
  - boolean getModifierState(key)
  - string key
  - number keyCode
  - string locale
  - number location
  - boolean metaKey
  - boolean repeat
  - boolean shiftKey
  - number which

##### 焦点事件

- 事件名
  - onFocus onBlur
- 属性
  - DOMEventTarget relatedTarget

##### 表单事件

- 事件名
  - onChange onInput onInvalid onReset onSubmit

##### 通用事件

- 事件名
  - onError onLoad

##### Mouse Event

- 事件名
  - onClick
  - onContextMenu
  - onDoubleClick
  - onDrag
  - onDragEnd
  - onDragEnter
  - onDragExit
  - onDragLeave
  - onDragOver
  - onDragStart
  - onDrop
  - onMouseDown
  - onMouseEnter
  - onMouseLeave
  - onMouseMove
  - onMouseOut
  - onMouseOver
  - onMouseUp
- 属性
  - boolean altKey
  - number button
  - number buttons
  - number clientX
  - number clientY
  - boolean ctrlKey
  - boolean getModifierState(key)
  - boolean metaKey
  - number pageX
  - number pageY
  - DOMEventTarget relatedTarget
  - number screenX
  - number screenY
  - boolean shiftKey

##### 指针事件

- 事件名
  - onPointerDown
  - onPointerMove
  - onPointerUp
  - onPointerCancel
  - onGotPointerCapture
  - onLostPointerCapture
  - onPointerEnter
  - onPointerLeave
  - onPointerOver
  - onPointerOut
- 属性
  - number pointerId
  - number width
  - number height
  - number pressure
  - number tangentialPressure
  - number tiltX
  - number tiltY
  - number twist
  - string pointerType
  - boolean isPrimary

##### 选择事件

- 事件名
  - onSelect

##### 触摸事件

- 事件名
  - onTouchCancel onTouchEnd onTouchMove onTouchStart
- 属性
  - boolean altKey
  - DOMTouchList changedTouches
  - boolean ctrlKey
  - boolean getModifierState(key)
  - boolean metaKey
  - boolean shiftKey
  - DOMTouchList targetTouches
  - DOMTouchList touches

##### UI 事件

- 事件名
  - onScroll
- 属性
  - number detail
  - DOMAbstractView view

##### 滚轮事件

- 事件名
  - onWheel
- 属性
  - number deltaMode
  - number deltaX
  - number deltaY
  - number deltaZ

##### 媒体事件

- 事件名
  - onAbort onCanPlay onCanPlayThrough onDurationChange onEmptied onEncrypted
    onEnded onError onLoadedData onLoadedMetadata onLoadStart onPause onPlay
    onPlaying onProgress onRateChange onSeeked onSeeking onStalled onSuspend
    onTimeUpdate onVolumeChange onWaiting

##### 图像事件

- 事件名
  - onLoad onError

##### 动画事件

- 事件名
  - onAnimationStart onAnimationEnd onAnimationIteration
- 属性
  - string animationName
  - string pseudoElement
  - float elapsedTime

##### 过渡事件

- 事件名
  - onTransitionEnd
- 属性
  - string propertyName
  - string pseudoElement
  - float elapsedTime

##### 其他事件

- 事件名
  - onToggle

## Hook

- React 16.8 新增
- 可以在函数组件内"钩入" React State 及生命周期等特性的函数
- 不能在 class 组件中使用

### Hook 规则

- 只能在函数最顶层调用 Hook, 不要在循环、条件判断或者嵌套函数中调用
- 只能在 React 的函数组件中调用 Hook, 不要在其他 JavaScript 函数中调用

### 内置 Hook

#### State Hook

- useState 返回的更新状态函数使用时不会把新的 state 和旧的 state 进行合并
- 初始 state 参数只在第一次渲染时会被用到

```jsx
const [count, setCount] = useState(0);
const [fruit, setFruit] = useState('banana');
const [todos, setTodos] = useState([{ text: 'learn React Hooks' }]);
setTodos([...todos, { text: 'Hello setTodos' }]); // 和 this.setState 的区别: 不会进行 state 合并
```

```jsx
// useState 实现原理
let _state = []; // 把 state 存储在外面
let index = 0;

function useState(initialValue) {
  const currentIndex = index;
  index += 1;
  _state[currentIndex] = _state[currentIndex] || initialValue;
  _state = _state || initialValue;
  function setState(newState) {
    _state[currentIndex] = newState;
    ReactDom.render(<App />, document.getElementById('app'));
  }
  return [_state[currentIndex], setState];
}
```

#### Effect Hook

- 每次渲染会生成新的 effect
- 默认情况下，它在第一次渲染之后和每次更新之后都会执行
- 异步执行，不会阻塞浏览器更新
- useEffect 每次在调用一个新的 effect 之前对前一个 effect 进行清理，防止内存泄漏或崩溃的问题
- 第二个参数控制执行 effect 的时机

```jsx
useEffect(() => {
  // ...
  return () => {}; // 组件卸载时调用, 可选
  // effect 会比较数组中所有参数是否和前一次的参数全等，如果有一个不相等则执行 effect
  // 数组为空，只执行一次 effect
}, [count]); // 仅在 count 更改时更新
```

### 自定义 Hook

- 名称以 use 开头, 函数内部可以调用其他的 Hook
```jsx

```