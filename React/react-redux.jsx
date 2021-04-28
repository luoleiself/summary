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
 *  2. 是一个对象, 对象所定义的方法名将作为属性名, 每个方法将返回一个新的函数.
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
 * 作用：过滤 mapStateToProps 和 mapDispatchToProps 的返回结果并传递给组件的 props
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

/** react-redux 部分实现源码 react-redux@7.2.3 **/
function createConnect(_temp) {
  var _ref = _temp === void 0 ? {} : _temp,
      _ref$connectHOC = _ref.connectHOC,
      connectHOC = _ref$connectHOC === void 0 ? connectAdvanced : _ref$connectHOC,
      _ref$mapStateToPropsF = _ref.mapStateToPropsFactories,
      mapStateToPropsFactories = _ref$mapStateToPropsF === void 0 ? defaultMapStateToPropsFactories :
      _ref$mapStateToPropsF,
      _ref$mapDispatchToPro = _ref.mapDispatchToPropsFactories,
      mapDispatchToPropsFactories = _ref$mapDispatchToPro === void 0 ?
      defaultMapDispatchToPropsFactories : _ref$mapDispatchToPro,
      _ref$mergePropsFactor = _ref.mergePropsFactories,
      mergePropsFactories = _ref$mergePropsFactor === void 0 ? defaultMergePropsFactories :
      _ref$mergePropsFactor,
      _ref$selectorFactory = _ref.selectorFactory,
      selectorFactory = _ref$selectorFactory === void 0 ? finalPropsSelectorFactory :
      _ref$selectorFactory;
  return function connect(mapStateToProps, mapDispatchToProps, mergeProps, _ref2) {
      if (_ref2 === void 0) {
          _ref2 = {};
      }
      var _ref3 = _ref2,
          _ref3$pure = _ref3.pure,
          pure = _ref3$pure === void 0 ? true : _ref3$pure,
          _ref3$areStatesEqual = _ref3.areStatesEqual,
          areStatesEqual = _ref3$areStatesEqual === void 0 ? strictEqual : _ref3$areStatesEqual,
          _ref3$areOwnPropsEqua = _ref3.areOwnPropsEqual,
          areOwnPropsEqual = _ref3$areOwnPropsEqua === void 0 ? shallowEqual :
          _ref3$areOwnPropsEqua,
          _ref3$areStatePropsEq = _ref3.areStatePropsEqual,
          areStatePropsEqual = _ref3$areStatePropsEq === void 0 ? shallowEqual :
          _ref3$areStatePropsEq,
          _ref3$areMergedPropsE = _ref3.areMergedPropsEqual,
          areMergedPropsEqual = _ref3$areMergedPropsE === void 0 ? shallowEqual :
          _ref3$areMergedPropsE,
          extraOptions = _objectWithoutPropertiesLoose(_ref3, ["pure", "areStatesEqual",
              "areOwnPropsEqual", "areStatePropsEqual", "areMergedPropsEqual"]);
      var initMapStateToProps = match(mapStateToProps, mapStateToPropsFactories,
          'mapStateToProps');
      var initMapDispatchToProps = match(mapDispatchToProps, mapDispatchToPropsFactories,
          'mapDispatchToProps');
      var initMergeProps = match(mergeProps, mergePropsFactories, 'mergeProps');
      return connectHOC(selectorFactory, _extends({
          // used in error messages
          methodName: 'connect',
          // used to compute Connect's displayName from the wrapped component's displayName.
          getDisplayName: function getDisplayName(name) {
              return "Connect(" + name + ")";
          },
          // if mapStateToProps is falsy, the Connect component doesn't subscribe to store state changes
          shouldHandleStateChanges: Boolean(mapStateToProps),
          // passed through to selectorFactory
          initMapStateToProps: initMapStateToProps,
          initMapDispatchToProps: initMapDispatchToProps,
          initMergeProps: initMergeProps,
          pure: pure,
          areStatesEqual: areStatesEqual,
          areOwnPropsEqual: areOwnPropsEqual,
          areStatePropsEqual: areStatePropsEqual,
          areMergedPropsEqual: areMergedPropsEqual
      }, extraOptions));
  };
};
var connect = createConnect();
