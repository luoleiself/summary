/**
 * ReactDOMServer 允许将组件渲染成静态标记, 一般用于服务器端渲染
 */
// ES modules
import ReactDOMServer from 'react-dom/server';
// CommonJS
var ReactDOMServer = require('react-dom/server');

/* 将 React 元素渲染为初始化 HTML，返回一个 HTML 字符串 */
ReactDOMServer.renderToString(element);

/**
 * 和 renderToString 方法相似，但不会在 React 内部创建额外的 DOM 属性(eg: data-reactRoot)，可作为静态页面生成器
 * 注意：
 *  1. 如果需要在前端使用 React 使标记可交互，则需要使用 renderToString 或者 ReactDOM.hydrate() 方法代替
 */
ReactDOMServer.renderToStaticMarkup(element);

/**
 * 和 renderToString 方法相似，返回一个可输出 HTML 字符串的可读流，
 * 注意：
 *  1. 此方法只能用在服务器端，
 *  2. 默认返回一个 UTF8 编码的字节流，可修改编码
 */
ReactDOMServer.renderToNodeStream(element);

/**
 * 和 renderToNodeStream 方法相似， 但不会在 React 内部创建额外的 DOM 属性(eg: data-reactRoot), 可作为静态页面生成器
 * 注意：
 *  1. 如果需要在前端使用 React 使标记可交互，则需要使用 renderToNodeStream 或则在前端使用 ReactDOM.hydrate() 方法代替
 *  2. 此方法只能用在服务器端
 *  3. 默认返回一个 UTF8 编码的字节流，可修改编码
 */
ReactDOMServer.renderToStaticNodeStream(element);
