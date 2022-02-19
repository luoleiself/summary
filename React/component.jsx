import { PureComponent, Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return <div>Hello App</div>;
  }
}
// pureComponent shouldComponentUpdate 浅比较
class Index extends PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      data: { name: 'Tom', age: 18 },
    };
  }
  handleClick = () => {
    const { data } = this.state;
    data.age++;
    this.setState({ data });
  };
  render() {
    const { data } = this.state;
    return (
      <div>
        <p>姓名: {data.name}</p>
        <p>年龄: {data.age}</p>
        <button onClick={this.handleClick}>age++</button>
      </div>
    );
  }
}

/************************************************/
// 声明组件：第一种方式--函数--无状态组件
function Comment(props) {
  return (
    <div className='Comment'>
      <UserInfo user={props.author} />
      <div className='Comment-text'>{props.text}</div>
      <div className='Comment-date'>{formatDate(props.date)}</div>
    </div>
  );
}
function Avatar(props) {
  return <img className='Avatar' src={props.user.avatarUrl} alt={props.user.name} />;
}
function UserInfo(props) {
  return (
    <div className='UserInfo'>
      <Avatar user={props.user} />
      <div className='UserInfo-name'>{props.user.name}</div>
    </div>
  );
}
/************************************************/
// 声明组件：第二种方式--ES6的class--受控组件
class Toggle extends React.Component {
  constructor(props) {
    super(props);
    this.state = { isToggleOn: true };
    this.handleClick = this.handleClick.bind(this); // 事件绑定
    /*
		事件绑定有三种方式：建议使用第1、2种
			1、在构造函数中使用,
			2、属性初始化器语言	experimental
			3、回调函数中使用箭头函数, 如果回调函数作为属性值传递到低阶组件时,可能引起重新如渲染
	  */
  }
  /*
  // 2、属性初始化器语言
  handleClick = (e) =>{
    e.preventDefault();
    this.setState((preState,newState) => ({
      isToggleOn: !preState.isToggleOn
    }))
  }
  */
  handleClick(e) {
    e.preventDefault();
    this.setState((preState, newState) => ({
      isToggleOn: !preState.isToggleOn,
    }));
  }
  render() {
    return null; // 阻止组件渲染
    return (
      /*
		// 3、回调函数中使用箭头函数
		<button onClick={(e) => this.handleClick(e)}>
		*/
      <button onClick={this.handleClick}>{this.state.isToggleOn ? 'ON' : 'OFF'}</button>
      /*****************************************/
      // 事件传参：
      // 方式1：<button onClick={(e) => this.deleteRow(id, e)}>Delete Row</button> // 使用回调函数
      // 方式2：<button onClick={this.deleteRow.bind(this, id)}>Delete Row</button> // 使用bind绑定,事件方法可以不使用1,2写法
      // 通过 bind 方式向监听函数传参时,在类组件中定义的监听函数,事件对象e要排在所传递参数的后面
      /****************************************/
    );
  }
}
ReactDOM.render(<Toggle />, document.getElementById('root'));
