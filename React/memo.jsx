import { memo, Component } from 'react';
/**
 * React.memo 作性能优化用
 *  如果组件在相同 props 的情况下渲染相同的结果，那么可以通过将其包裹在 React.memo 中调用，
 *  以此通过记忆组件渲染结果的方式提高组件的性能表现,此种情况下，React 会跳过渲染组件的操作
 *  并复用最近一次渲染的结果.
 *
 *  默认情况只会对复杂对象做浅层对比，和 React.PureComponent 类似。如果需要控制对比过程，可以传入第二个参数实现.
 *
 *  仅检查 props 变更，如果函数组件被 React.memo 包裹，且其实现中拥有 useState 或者 useEffect 的 hook，
 *  当 context 发生变化时，它仍会重新渲染.
 *
 *  注意：
 *    与 class 组件中 shouldComponentUpdate() 方法不同的是，
 *    如果 props 相等，areEqual 会返回 true；如果 props 不相等，则返回 false。
 *    这与 shouldComponentUpdate 方法的返回值相反.
 */

function MyComponent(props) {
  /* 使用 props 渲染 */
}
function areEqual(prevProps, nextProps) {
  /*
  如果把 nextProps 传入 render 方法的返回结果与
  将 prevProps 传入 render 方法的返回结果一致则返回 true，
  否则返回 false
  */
}
export default memo(MyComponent, areEqual);

// eg: React.memo 仅能检查 props 变更, 第二个参数返回 true 不渲染，返回 false 重新渲染
function TextMemo(props) {
  console.log('子组件渲染');
  if (props) return <div>hello,world</div>;
}
const controlIsIsRender = (prevProps, nextProps) => {
  if (prevProps.number === nextProps.number) {
    return true; // 不渲染组件
  } else if (prevProps.number !== nextProps.number && prevProps.number > 5) {
    return true; // 不渲染组件
  } else {
    return false; // 渲染组件
  }
};
const NewTextMemo = memo(TextMemo, controlIsIsRender);
class Index extends Component {
  constructor(props) {
    super(props);
    this.state = { number: 1, num: 1 };
  }
  render() {
    const { num, number } = this.state;
    return (
      <div>
        <div>
          改变 num: 当前值 {num}
          <button onClick={() => this.setState({ num: num + 1 })}>num ++</button>
          <button onClick={() => this.setState({ num: num - 1 })}>num --</button>
        </div>
        <div>
          改变 number: 当前值 {number}
          <button onClick={() => this.setState({ number: number + 1 })}>number ++</button>
          <button onClick={() => this.setState({ number: number - 1 })}>number --</button>
        </div>
        <NewTextMemo num={num} number={number} />
      </div>
    );
  }
}
