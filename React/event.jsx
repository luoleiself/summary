/**
 * 阻止事件冒泡: e.preventDefault();
 */
// 事件绑定: 第一种方式
class Toggle extends React.Component {
  constructor(props) {
    super(props);
    this.state = { isToggleOn: true };

    // 为了在回调中使用 `this`，这个绑定是必不可少的
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState((state) => ({
      isToggleOn: !state.isToggleOn,
    }));
  }

  render() {
    return <button onClick={this.handleClick}>{this.state.isToggleOn ? 'ON' : 'OFF'}</button>;
  }
}

// 事件绑定: 第二种方式: create-react-app 默认启用此语法
class LoggingButton extends React.Component {
  // 此语法确保 `handleClick` 内的 `this` 已被绑定。
  // 注意: 这是 *实验性* 语法。
  handleClick = () => {
    console.log('this is:', this);
  };

  render() {
    return <button onClick={this.handleClick}>Click me</button>;
  }
}

// 事件绑定: 第三种方式: 官方不推荐此用法,原因是如果事件对象作为props继续向下传递时,可能会导致额外的重新渲染.
// 官方建议使用第一种或者第二种方式.
class LoggingButton extends React.Component {
  handleClick() {
    console.log('this is:', this);
  }

  render() {
    // 此语法确保 `handleClick` 内的 `this` 已被绑定。
    return <button onClick={() => this.handleClick()}>Click me</button>;
  }
}

// 事件绑定: 第四种方式: 此方式同时可以传参
class LoggingButton extends React.Component {
  deleteRow(id) {
    console.log(id);
  }

  render() {
    let id = Math.floor(Math.random() * 10);
    return (
      // 方式1：<button onClick={(e) => this.deleteRow(id, e)}>Delete Row</button> // 使用箭头函数，需要显示传递事件对象
      // 方式2： // 使用bind绑定,事件方法可以不使用1,2写法
      <button onClick={this.deleteRow.bind(this, id)}>Delete Row</button>
    );
  }
}

// 事件传参方式
class LoggingButton extends React.Component {
  deleteRow(id) {
    console.log(id);
  }

  render() {
    let id = Math.floor(Math.random() * 10);
    return (
      // 方式1：<button onClick={(e) => this.deleteRow(id, e)}>Delete Row</button> // 使用箭头函数，需要显示传递事件对象
      // 方式2： // 使用bind绑定,事件方法可以不使用1,2写法
      <button onClick={this.deleteRow.bind(this, id)}>Delete Row</button>
    );
  }
}

ReactDOM.render(<Toggle />, document.getElementById('root'));
