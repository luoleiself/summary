/**
 * ref:  对该节点的引用可以在 ref 的 current 属性中被访问.
 *  使用场景
 *    1. 管理焦点，文本或媒体播放.
 *    2. 触发强制动画.
 *    3. 继承第三方 DOM 库.
 *  注意: 
 *    1. 不能在函数组件上使用 ref 属性，因为它们没有实例(可以使用 forwardRef 或者 useImperativeHandle 结合使用).
 * 
 * 以下是对上述示例发生情况的逐步解释：
 *  1. 我们通过调用 React.createRef 创建了一个 React ref 并将其赋值给 ref 变量.
 *  2. 我们通过指定 ref 为 JSX 属性，将其向下传递给 <FancyButton ref={ref}>.
 *  3. React 传递 ref 给 forwardRef 内函数 (props, ref) => ...，作为其第二个参数. (第二个参数 ref 只在使用 React.forwardRef 定义组件时存在。常规函数和 class 组件不接收 ref 参数，且 props 中也不存在 ref)
 *  4. 我们向下转发该 ref 参数到 <button ref={ref}>，将其指定为 JSX 属性.
 *  5. 当 ref 挂载完成，ref.current 将指向 <button> DOM 节点.
 */
const FancyButton = React.forwardRef((props, ref) => (
  <button ref={ref} className='FancyButton'>
    {props.children}
  </button>
));

// 你可以直接获取 DOM button 的 ref：
class App extends React.Component {
  constructor(props) {
    super(props);
    this.ref = React.createRef();
  }

  render() {
    return <FancyButton ref={this.ref}>Click me!</FancyButton>;
  }
}
/* HOC */
function logProps(Component) {
  class LogProps extends React.Component {
    componentDidUpdate(prevProps) {
      console.log('old props:', prevProps);
      console.log('new props:', this.props);
    }

    render() {
      const { forwardedRef, ...rest } = this.props;

      // 将自定义的 prop 属性 “forwardedRef” 定义为 ref
      return (
        <React.Fragment>
          <h1>高阶组件中使用 React.forwardRef</h1>
          <p>HOC and React.forwardRef</p>
          <hr />
          <Component ref={forwardedRef} {...rest} />
        </React.Fragment>
      );
    }
  }

  // 注意 React.forwardRef 回调的第二个参数 “ref”。
  // 我们可以将其作为常规 prop 属性传递给 LogProps，例如 “forwardedRef”
  // 然后它就可以被挂载到被 LogProps 包裹的子组件上。
  return React.forwardRef((props, ref) => {
    return <LogProps {...props} forwardedRef={ref} />;
  });
}
/***********************************************/
/**
 * Fragments 允许将子列表分组，而无需向 DOM 添加额外节点
 * 使用方式:
 *  <React.Fragment> </React.Fragment>
 *  <> </> 空标签不支持 key 或者 属性
 */
class List extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <React.Fragment>
        <ChildA />
        <ChildB />
        <ChildC />
      </React.Fragment>
    );
  }
}
