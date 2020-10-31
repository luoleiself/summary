/**
 * portals 将子节点渲染到存在于父组件之外的DOM节点上.
 * 尽管 portal 可以被放置在 DOM 树中的任何地方，但在任何其他方面，其行为和普通的 React 子节点行为一致。
 * 由于 portal 仍存在于 React 树， 且与 DOM 树 中的位置无关，那么无论其子节点是否是 portal，像 context 这样的功能特性都是不变的
 */
// 在 DOM 中有两个容器是兄弟级 （siblings）
const appRoot = document.getElementById('app-root');
const modalRoot = document.getElementById('modal-root');

class Modal extends React.Component {
  constructor(props) {
    super(props);
    this.el = document.createElement('div');
  }

  componentDidMount() {
    // 在 Modal 的所有子元素被挂载后，
    // 这个 portal 元素会被嵌入到 DOM 树中，
    // 这意味着子元素将被挂载到一个分离的 DOM 节点中。
    // 如果要求子组件在挂载时可以立刻接入 DOM 树，
    // 例如衡量一个 DOM 节点，
    // 或者在后代节点中使用 ‘autoFocus’，
    // 则需添加 state 到 Modal 中，
    // 仅当 Modal 被插入 DOM 树中才能渲染子元素。
    modalRoot.appendChild(this.el);
  }

  componentWillUnmount() {
    modalRoot.removeChild(this.el);
  }

  render() {
    return ReactDOM.createPortal(this.props.children, this.el);
  }
}

class Parent extends React.Component {
  constructor(props) {
    super(props);
    this.state = { clicks: 0 };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    // 当子元素里的按钮被点击时，
    // 这个将会被触发更新父元素的 state，
    // 即使这个按钮在 DOM 中不是直接关联的后代
    this.setState((state) => ({
      clicks: state.clicks + 1,
    }));
  }

  render() {
    return (
      <div onClick={this.handleClick}>
        <p>Number of clicks: {this.state.clicks}</p>
        <p>
          Open up the browser DevTools to observe that the button is not a child of the div with the onClick handler.
        </p>
        <Modal>
          <Child />
        </Modal>
      </div>
    );
  }
}

function Child() {
  // 这个按钮的点击事件会冒泡到父元素
  // 因为这里没有定义 'onClick' 属性
  return (
    <div className='modal'>
      <button>Click</button>
    </div>
  );
}

ReactDOM.render(<Parent />, appRoot);
/****************************************************************************/
/**
 * profiler 测量渲染一个 React 应用多久渲染一次以及渲染一次的“代价”, 目的是识别出应用中渲染较慢的部分.
 * 注意:
 *  1. 增加了额外的开支,在生产构建中会被禁用.
 * 用法:
 *  1. 需要接收两个 prop
 *    1. id(string)
 *    2. onRender(function): 当前组件树中的组件'提交'更新的时候被 React 调用的回调函数.
 *      回调函数参数:
 *        1. id: string - 发生提交的 Profiler 树的 id。 如果有多个 profiler，它能用来分辨树的哪一部分发生了“提交”。
 *        2. phase: "mount" | "update" - 判断是组件树的第一次装载引起的重渲染，还是由 props、state 或是 hooks 改变引起的重渲染。
 *        3. actualDuration: number - 本次更新在渲染 Profiler 和它的子代上花费的时间。 这个数值表明使用 memoization 之后能表现得多好。（例如 React.memo，useMemo，shouldComponentUpdate）。 理想情况下，由于子代只会因特定的 prop 改变而重渲染，因此这个值应该在第一次装载之后显著下降。
 *        4. baseDuration: number - 在 Profiler 树中最近一次每一个组件 render 的持续时间。 这个值估计了最差的渲染时间。（例如当它是第一次加载或者组件树没有使用 memoization）。
 *        5. startTime: number - 本次更新中 React 开始渲染的时间戳。
 *        6. commitTime: number - 本次更新中 React commit 阶段结束的时间戳。 在一次 commit 中这个值在所有的 profiler 之间是共享的，可以将它们按需分组。
 *        7. interactions: Set - 当更新被制定时，“interactions” 的集合会被追踪。（例如当 render 或者 setState 被调用时）。
 */
// 测量向同一个子树下的不同组件.
render(
  <App>
    <Profiler id='Panel' onRender={callback}>
      <Panel {...props}>
        <Profiler id='Content' onRender={callback}>
          <Content {...props} />
        </Profiler>
        <Profiler id='PreviewPane' onRender={callback}>
          <PreviewPane {...props} />
        </Profiler>
      </Panel>
    </Profiler>
  </App>
);
