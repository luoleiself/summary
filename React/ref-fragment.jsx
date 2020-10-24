/**
 * 以下是对上述示例发生情况的逐步解释：
 *
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
const ref = React.createRef();
<FancyButton ref={ref}>Click me!</FancyButton>;
/***********************************************/
/**
 * Fragments 允许将子列表分组，而无需向 DOM 添加额外节点
 * <React.Fragment> </React.Fragment>
 * <> </>
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
