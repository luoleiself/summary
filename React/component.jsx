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
