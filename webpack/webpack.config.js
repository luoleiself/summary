var htmlWebpackPlugin = require("html-webpack-plugin");
module.exports = {
  // entry:"./src/script/main.js",
  // entry:["./src/script/main.js","./src/script/index.js"],
  /*entry:{
    main:"./src/script/main.js",
    index:["./src/script/index.js","./src/script/indexa.js"]
  },*/
  entry:{
    a:"./src/script/a.js",
    b:"./src/script/b.js",
    c:"./src/script/c.js"
  },
  /*output:{
    path:"./dist",
    filename:"js/bundle.js",
    publicPath:"http://cdn.com/"
  },*/
  output:{
    path:"./dist",
    filename:"js/[name]-[chunkhash].js",
    publicPath:"http://cdn.com/"
  },
  module:{
    loaders:[
      {test:/\.js$/,loader:"babel",query:{presets:["latest"]}},
    ]
  },
  plugins:[
    // new htmlWebpackPlugin({
    //   template:"index.html",
    //   filename:"index.html", // 指定文件名
    //   // filename:"index-[hash].html", // 指定hash文件名
    //   inject:"head", // 将js文件放在head还是body中
    //   // inject:false,
    //   title:"webpack is good", // 设置html文件title
    //   /*<title><%= htmlWebpackPlugin.options.title %></title>*/
    //   date:new date(),
    //   /*<body><%= htmlWebpackPlugin.options.date %></body>*/
    //   minify:{　// 压缩文件　
    //     removeComments:true, // 删除注释
    //     collapseWhitespace:true, // 删除空格
    //   }
    // }),
    new htmlWebpackPlugin({
      filename:"a.html",
      template:"index.html",
      inject:false,
      title:"this is a html",
      // chunks:["main","a"], // 只加载
      excludeChunks:["b","c"] // 排除不加载
    }),
    new htmlWebpackPlugin({
      filename:"b.html",
      template:"index.html",
      inject:false,
      title:"this is b html",
      // chunks:["b"],
      excludeChunks:["a","c"]
    }),
    new htmlWebpackPlugin({
      filename:"c.html",
      template:"index.html",
      inject:false,
      title:"this is c html",
      // chunks:["c"],
      excludeChunks:["a","b"]
    })
  ]
}