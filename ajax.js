一、Asynchronous JavaScript and XML ：异步的js和xml
特点：
  1、局部无刷新的页面更新
  2、动态页面静态化
二、HTTP请求：一种无状态协议(不建立持久的连接)
  1、步骤：
    1、建立TCP连接
    2、Web浏览想Web服务器发送请求命令
    3、Web浏览器发送请求头信息
    4、Web服务器应答
    5、Web服务器发送应答头信息
    6、Web服务器向浏览器发送数据
    7、Web服务器关闭TCP连接
  2、请求消息：
    1、请求起始行：
        请求方法(get,post,put,delete,trace,option,connect,head) 
        请求地址
        版本号
    2、请求头部：
      1、通用头部：
          Connection:keep-alive  告诉对方启用持久连接
          Cach-Control:no-cache/max-age=3600/max-age=0(秒)
            --------告诉对方如何缓存当前消息主体中的数据
          Expires:Wed,11 May 2016 03:06:58 GMT
            -------告诉对方此次消息主体中数据的过期时间
          Date:Wed,11 May 2016 03:06:58 GMT
            --------当前消息的发起时间
      2、专用头部：
          Host:wwww.baidu.com
            --------客户端表明此次请求的虚拟主机上的资源
          Accept:text/html  客户端表明自己可以接收的响应的类型
          User-Agent:Mozilla/5.0  客户端告诉服务器自己的类型
          Accept-Encoding:gzip  客户端表明自己能否接收压缩后的响应数据
          Accept-Language:zh-CN 客户端表明自己能接收的自然语言
          Cookie:       客户端初始保存在浏览器中的Cookie
          Referer:http:127.0.0.1/1.html 
            --------客户端表明自己当前的请求发自哪个页面引用
      3、请求主体描述头部：
          Content-Type:告诉服务器请求消息主体的编码类型
            application/x-www-form-urlencoded;
            text/plain;
            multipart/form-data;
      4、自定义请求头部：  
    3、CRLF
    4、请求主体：
  3、响应消息：
    1、响应起始行：
        版本号：  ------HTTP/1.1
        响应状态码： 100,200,300,400,500
    2、响应头部：
      1、通用头部：
      2、专用头部：
      3、主体描述头部：
      4、请求自定义头部：
    3、CRLF
    4、响应主体
XMLHttpRrequest对象：
    浏览器：var xmlhttp = new XMLHttpRrequest()
    IE(5/6)：var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP")
open(method,url,async)
setRequestHeader("Content-Type","application/x-www-form-urlencoded")  
send(string)
responseText:获得字符串形式的响应数据
responseXML：获得XML形式的响应数据
status和statusText：以数字和文本形式返回HTTP状态码
getAllResponseHeader():获取所有的响应报头
getResponseHeader():查询响应中的某个字段的值。
readyState:
  0:请求未初始化，open还没有调用。
  1:服务器连接已建立，open已经调用。
  2:请求已接收，接收到头信息。
  3:请求处理中，接收到响应主体。
  4:请求已完成。
JSON:JavaScript对象表示法(JavaScript Objcet Notation)
JSON在线校验工具JSONLint 

JSONP：跨域请求
  1、HTML5提供的XMLHttpRequest Level2实现跨域请求。
  2、IE10以下的版本的浏览器都不支持。
  3、服务器端的配置：
    header('Access-Control-Allow-Origin:*');
    header('Access-Control-Allow-Methods:POST,GET'); 
