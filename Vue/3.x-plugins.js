// 方式一
export default {
  install(app, options) {
    // 应用实例 app 作为第一个参数传入
    // 传给 use 的其他 options 参数作为后续参数传入该安装方法
    app.config.globalProperties.$plugins = () => {};
  },
};
// 方式二
export default function (app, options) {
  app.config.globalProperties.$plugins = () => {};
}
