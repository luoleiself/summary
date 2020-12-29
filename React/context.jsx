/**
 * 图例:
 *  1. 总结中的 MyContext 全部使用 $c 表示.
 * 总结:
 *  1. 如果需要使用 defaultValue 时,则不需要使用 $c.Provider 组件.
 *  2. 如果使用了 $c.Provider 组件时,必须提供其 value 属性. 即使 undefined 值也会导致 defaultValue 不生效
 *  3. 如果使用了 $c.Consumer 组件时,则需要在 $c.Consumer 组件内部提供回调函数,参数为 context. 不需要在组件内部获取 context
 *  4. 如果不使用 $c.Consumer 组件时,则需要将渲染组件的 contextType 属性设置为 $c, 在渲染组件内部使用 this.context 获取 $c.
 */
const defaultValue = {
  name: 'Hello Context.defaultValue',
};
const MyContext = React.createContext(defaultValue); // 创建一个 context 对象
class App extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div>
        <MyContext.Provider value={{ name: 'Hello MyContext.Provider' }}>
          <Content />
        </MyContext.Provider>
      </div>
    );
  }
}

class Content extends React.Component {
  static contextType = MyContext; // way2 可以使用静态属性代替外面原型挂载方式
  constructor(props) {
    super(props);
  }
  render() {
    // const ctx = this.context; // way2
    return (
      <React.Fragment>
        <MyContext.Consumer>{(ctx) => ctx.name}</MyContext.Consumer> // 使用 Consumer 时不需要在组件内部获取 context
      </React.Fragment>
    );
  }
}
// Content.contextType = MyContext; // way2

ReactDOM.render(<App />, document.getElementById('root'));
