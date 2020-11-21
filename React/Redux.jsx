import { createStore, combineReducers, applyMiddleware } from 'redux';

import ReduxThunk from 'redux-thunk'; // 改造 store.dispatch() 支持函数作为参数 内部方法接收两个 store 的方法：dispatch, getState
import ReduxPromise from 'redux-promise'; // 改造 store.dispatch() 支持 Promise 对象作为参数

import { connect, Provider } from 'react-redux';

/**
 * Store 的职责
 *  1. 维持应用的 state
 *  2. 提供 getState() 方法获取 state
 *  3. 提供 dispatch(action) 方法更新 state
 *  4. 通过 subscribe(listener) 注册监听器
 *  5. 通过 subscribe(listener) 返回的函数注销监听器
 *
 * 创建 store
 * reducer state 的自动计算过程，必须是一个纯函数, 接收 state 和 action 作为参数
 *  1. 不能改写参数
 *  2. 不能调用系统 I/O 的 API
 *  3. 不能调用 Date.now() 或 Math.random() 等不纯的方法，导致每次会得到不一样的结果
 * defaultState 整个应用的默认初始状态值，如果提供会覆盖 Reducer 函数的默认初始值
 * applyMiddleware 混合中间件方法
 */
const store = createStore(reducer, [defaultState], [applyMiddleware(ReduxThunk, ReduxPromise, ...middleWare)]);
// 对当前数据生成快照
const state = store.getState();

const reducer = function (state = {}, action) {
  return {};
};

/**
 * combineReducers 生成一个函数, 调用一系列 reducer, 每个 reducer 根据 key 来筛选出 state 中的一部分数据并处理
 * 然后这个生成的函数再将 reducer 的结果合并成一个大的对象
 */
const reducer = combineReducers({});

/***********************************************************************/
/**
 * 两个方法完全等价
 */
const reducer = combineReducers({
  a: doSomethingWithA,
  b: processB,
  c: c,
});
function reducer(state = {}, action) {
  return {
    a: doSomethingWithA(state.a, action),
    b: processB(state.b, action),
    c: c(state.c, action),
  };
}
/***********************************************************************/

// 更新 state
store.dispatch({ type: 'ADD_TODO', payload: { name: 'hello world', age: 18 } });

// 订阅 store，自动更行
const unSubscribe = store.subscribe(listener); // unSubscribe 取消监听

// 中间件 redux-thunk
const fetchPosts = (postTitle) => (dispatch, getState) => {
  dispatch(requestPosts(postTitle));
  return fetch(`/some/API/${postTitle}.json`)
    .then((response) => response.json())
    .then((json) => dispatch(receivePosts(postTitle, json)));
};
// 使用方法一
store.dispatch(fetchPosts('reactjs'));
// 使用方法二
store.dispatch(fetchPosts('reactjs')).then(() => console.log(store.getState()));

// 中间件 redux-promise
// 写法一： 返回一个 Promise 对象
const fetchPosts = (dispatch, postTitle) =>
  new Promise(function (resolve, reject) {
    dispatch(requestPosts(postTitle));
    return fetch(`/some/API/${postTitle}.json`).then((response) => ({
      type: 'FETCH_POSTS',
      payload: response.json(),
    }));
  });
// 写法二：Action 的 payload 属性是一个 Promise 对象，需要借助 redux-actions 模块中的 createActions 方法
import { createAction } from 'redux-actions';
class AsyncApp extends Component {
  componentDidMount() {
    const { dispatch, selectedPost } = this.props;
    // 发出同步 Action
    dispatch(requestPosts(selectedPost));
    // 发出异步 Action
    dispatch(
      createAction(
        'FETCH_POSTS',
        fetch(`/some/API/${postTitle}.json`).then((response) => response.json())
      )
    );
  }
}

/**********************************************************************************************/
// React-Redux
const ComponentName = connect([mapStateToProps], [mapDispatchToProps])(componentName); // 将两种(UI/容器)组件建立关系
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
