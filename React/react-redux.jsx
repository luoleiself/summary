import { connect, Provider, connectAdvanced, batch} from 'react-redux';

// React-Redux
const ComponentName = connect([mapStateToProps], [mapDispatchToProps], [mergeProps], [options])(componentName); // 将两种(UI/容器)组件建立关系
/**
 * mapStateToProps 是一个函数，建立一个外部 State 对象到 UI 组件 Props 对象的映射关系
 *  订阅 Store, 当 state 更新时 会自动执行, 重新计算 UI 组件的参数
 *  也可省略此参数，UI 组件不会订阅 Store, 如果 Store 更新不会引起 UI 组件的更新
 * state => 数据对象
 * ownProps => 组件自身的 props 对象
 */
const mapStateToProps = (state, ownProps) => {
  return { todoList: state.todoList };
};

/**
 * mapDispatchToProps 用来建立 UI 组件的参数到 store.dispatch 方法的映射, 返回一个对象，定义了 UI 组件的响应行文
 *  1. 是一个函数, 接收 dispatch 和 ownProps 两个参数,
 *  2. 是一个对象,
 */
// 1.
const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    onClick: () => {
      dispatch({
        type: 'SET_VISIBILITY_FILTER',
        filter: ownProps.filter,
      });
    },
  };
};
// 2.
const mapDispatchToProps = {
  onClick: (filter) => ({
    type: 'SET_VISIBILITY_FILTER',
    filter: filter,
  }),
};
/**
 * mergeProps  mapStateToProps() 与 mapDispatchToProps() 的执行结果和组件自身的 props 将传入到这个回调函数中。
 * 该回调函数返回的对象将作为 props 传递到被包装的组件中。
 * 你也许可以用这个回调函数，根据组件的 props 来筛选部分的 state 数据，
 * 或者把 props 中的某个特定变量与 action creator 绑定在一起
 */
const mergeProps = function (stateProps, dispatchProps, ownProps) {
  return Object.assign({}, ownProps, stateProps, dispatchProps); // 默认情况下返回此项
};
/**
 * options 可以定制 connector 的行为
 */
const options = {
  context?: Object,
  pure?: boolean,  // connector 将执行 shouldComponentUpdate 并且浅对比 mergeProps 的结果，避免不必要的更新
  areStatesEqual?: Function,
  areOwnPropsEqual?: Function,
  areStatePropsEqual?: Function,
  areMergedPropsEqual?: Function,
  forwardRef?: boolean,
  withRef: false, // connector 会保存一个对被包装组件实例的引用，该引用通过 getWrappedInstance() 方法获得
};