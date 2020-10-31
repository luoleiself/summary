/**
 * render props
 *  是一种在 React 组件之间使用一个值为函数的 prop 共享代码的简单技术.
 *  具有 render prop 的组件接受一个函数，该函数返回一个 React 元素并调用它而不是实现自己的渲染逻辑.
 * 注意：
 *  1. render prop 是因为模式才被称为 render prop, 不一定非要用名为 render 的 prop 来使用这种模式.
 *  2. 将 render props 与 React.PureComponent 一起使用时要小心.
 *    1. render prop 会抵消使用 React.PureComponent 带来的优势，因为浅比较 props 的时候总会得到 false，
 *       并且在这种情况下每一个 render 对于 render prop 将会生成一个新的值.
 *
 */
class Cat extends React.Component {
  render() {
    const mouse = this.props.mouse;
    return (
      <div
        style={{
          width: '20px',
          height: '20px',
          background: '#0088ff',
          position: 'absolute',
          left: mouse.x,
          top: mouse.y,
        }}
      />
    );
  }
}

class Mouse extends React.Component {
  constructor(props) {
    super(props);
    this.handleMouseMove = this.handleMouseMove.bind(this);
    this.state = { x: 0, y: 0 };
  }

  handleMouseMove(event) {
    this.setState({
      x: event.clientX,
      y: event.clientY,
    });
  }

  render() {
    return (
      <div style={{ height: '100vh' }} onMouseMove={this.handleMouseMove}>
        {/*
          Instead of providing a static representation of what <Mouse> renders,
          use the `render` prop to dynamically determine what to render.
        */}
        {/* 如果 MouseTracker 使用 children prop 方式实现 */}
        {/* 此处需要使用 this.props.children(this.state) 调用 */}
        {this.props.render(this.state)}
      </div>
    );
  }
}

class MouseTracker extends React.Component {
  render() {
    return (
      <div>
        <h1>移动鼠标!</h1>
        {/* 此处可以使用 children prop 方式实现 */}
        {/* <Mouse>{(mouse) => <Cat mouse={mouse} />}</Mouse> */}
        <Mouse render={(mouse) => <Cat mouse={mouse} />} />
      </div>
    );
  }
}

ReactDOM.render(<MouseTracker />, document.getElementById('app'));
