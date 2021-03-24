/**
 * 特点:
 *  1. 复用逻辑: 高阶组件批量对原有组件进行加工,包装处理.
 *  2. 强化Props: 劫持传入的 props，增强组件的功能.
 *  3. 赋能组件: 为包装的组件提供一些扩展功能.
 *  4. 控制渲染: 
 * 注意:
 *  1. HOC 名称尽量以 with 开头.
 *  2. 不要在 render 方法中使用 HOC, 可能会导致组件及其子组件的状态丢失.
 *  3. 务必复制静态方法, 新组件没有原始组件的任何静态方法.
 *  4. refs 不会被传递.
 */
// 定义高阶组件, 第一个参数为组件...
function withSubscription(WrappedComponent, selectData) {
  // ...并返回另一个组件...
  return class extends React.Component {
    constructor(props) {
      super(props);
      this.handleChange = this.handleChange.bind(this);
      this.state = {
        data: selectData(DataSource, props),
      };
    }

    componentDidMount() {
      // ...负责订阅相关的操作...
      DataSource.addChangeListener(this.handleChange);
    }

    componentWillUnmount() {
      DataSource.removeChangeListener(this.handleChange);
    }

    handleChange() {
      this.setState({
        data: selectData(DataSource, this.props),
      });
    }

    render() {
      // ... 并使用新数据渲染被包装的组件!
      // 请注意，我们可能还会传递其他属性
      return <WrappedComponent data={this.state.data} {...this.props} />;
    }
  };
}
// 评论 增强组件
const CommentListWithSubscription = withSubscription(CommentList, (DataSource) => DataSource.getComments());
// 订阅博客 增强组件
const BlogPostWithSubscription = withSubscription(BlogPost, (DataSource, props) => DataSource.getBlogPost(props.id));
/**************************************************************/
// 复制静态方法
function withMyHoc(WrappedComponent) {
  class Enhance extends React.Component {
    constructor(props) {
      super(props);
    }
    render() {
      return <WrappedComponent {...this.props} />;
    }
  }
  // 必须准确知道应该拷贝哪些方法 :(
  Enhance.staticMethod = WrappedComponent.staticMethod;
  return Enhance;
}
