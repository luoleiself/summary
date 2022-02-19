/**
 * React
 */
import React from 'react';
import ReactDOM from 'react-dom';

/* 使用 ES6 classes 方式定义 React 组件的基类 */
React.Component;
/* 作用同 React.Component 在提高性能优化方便可用，shouldComponentUpdate 仅作对象的浅层比较 */
React.PureComponent;
/* 高阶组件, 性能优化用，组件在相同 props 的情况下渲染相同的结果，可将其包装在此组件中，如果需要控制对比过程，传入第二个参数控制 */
React.memo(myComponent, areEqual);
/* 创建并返回指定类型的组件，jsx 是此方法的语法糖 */
React.createElement(type, [props], [...children]);
/** 以指定元素为样板克隆并返回会新的 React 元素，
 *  新元素的 props 是将新的 props 与原始元素的 props 浅层合并后的结果，原始元素的 key 和 ref 被保留
 */
React.cloneElement(element, [props], [...children]);
/* 返回指定类型 React 元素的函数，此辅助函数已废弃。可直接使用 jsx 或者 React.createElement 代替. */
React.createFactory(type);
/* 验证对象是否是 React 元素, 返回值为 true 或 false */
React.isValidElement(object);
/* 提供了用于处理 this.props.children 不透明数据结构的使用方法 */
React.Children;
React.Children.map(children, function () {}); // 在 children 里的每个直接子节点上调用一个函数.
React.Children.forEach(children, function () {}); // 与 React.Children.map 方法类似.
React.Children.count(children); // 统计 children 中的组件总数量.
React.Children.only(children); // 验证是否只有一个子节点(一个 React 元素), 如果有则返回它，否则此方法会抛出错误.
React.Children.toArray(children); // 将 children 这个负责的数据结构以数组的方式扁平展开并返回，并为每个子节点分配一个 key.
/**
 * 组件能够在不额外创建 DOM 元素的情况下，让 render() 方法中返回多个元素
 * 简写语法 <></>, 简写语法不能使用 key
 */
<React.Fragment></React.Fragment>;
/* 创建一个能够通过 ref 属性附加到 React 元素的 ref */
React.createRef();
/* 创建一个 React 组件，将其接受的 ref 属性转发到其他组件树下的另一个组件中. */
React.forwardRef((props, ref) => {
  return <MyComponent ref={ref} />;
});
/* 性能优化，定义一个动态加载的组件,配合 React.Suspense 使用 */
const Context = React.lazy(() => import('./context.jsx'));
<React.Suspense fallback={<div>正在加载中...</div>}>
  <Context />
</React.Suspense>;

/**
 * ReactDOM
 */
/**
 * 在 container 容器里面渲染一个 React 元素，并返回该组件的引用
 * 如果React 元素之前已经在 container 中渲染过，将会执行更新操作
 * 回调函数在组件被渲染或更新之后执行
 * 注意：
 *  1. 首次渲染时，container 中的所有 DOM 元素都会被替换，后续的调用则会使用 React 的 DOM 差分算法(DOM diffing)进行高效的更新
 *  2. 不会修改容器节点，只会修改容器的子节点
 *  3. 目前会返回对根组件 ReactComponent 实例的引用，应尽量避免使用返回的引用
 *  4. 对服务器端渲染容器进行 hydrate 操作的方式已经被废弃，使用 hydrate() 代替
 */
ReactDOM.render(element, container, [callback]);
/* 作用和 ReactDOM.render() 相同，用在 ReactDOMServer 渲染 */
ReactDOM.hydrate(element, container, [callback]);
/* 从 DOM 中卸载组件，会将其事件处理器和 state 一并删除，如果组件被移除则返回 true, 否则返回 false */
ReactDOM.unmountComponentAtNode(container);
/**
 * 返回浏览器中相应的原生 DOM 元素
 * 注意：
 *  1. 应急方案，不建议使用，会破坏组件的抽象结构，严格模式下该方法已废弃
 *  2. 只能用在已挂载的组件上，未挂载的组件上将会引发异常
 *  3. 不能用于函数组件
 */
ReactDOM.findDOMNode(component);
/* 创建 portal, 将子节点渲染到 DOM 组件的层次结构之外 */
ReactDOM.createPortal(child, container);

/************************************************/
// ReactDOM.createPortal(child, container); // 适用场景: 模态框,提示框,警告框等
const ModalRoot = document.getElementsByTagName('body')[0];
class App extends React.Component {
  constructor(props) {
    super(props);
    this.el = document.createElement('div');
  }
  componentDidMount() {
    modalRoot.appendChild(this.el);
  }
  componentWillUnmount() {
    modalRoot.removeChild(this.el);
  }
  render() {
    return ReactDOM.createPortal(<div>this is ReactDOM.createPortal(child,container)</div>, this.el);
  }
}
/************************************************/
