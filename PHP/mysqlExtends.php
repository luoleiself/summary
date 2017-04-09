<?php 
  1. 数据库扩展:
    1. mysql: 
      $link = mysql_connect("mysql_host","mysql_user","mysql_password");
      mysql_select_db("dbName"); // 选择数据库
      mysql_query("set names 'utf8'"); // 设置编码格式
      $res = mysql_query('select * from user limit 1',$link); // 执行查询语句
      $row = mysql_fetch_assoc($res); // 获取查询结果集中的数据
      $result = mysql_query('insert into user(name,age,class) value("王五","27","大一班")');
      mysql_error($link); // 获取执行语句失败原因
      echo mysql_insert_id(); // 获取插入记录成功的id
      mysql_close($link); // 关闭数据库链接
      $bool = mysql_select_db("test"); // 选择数据库,选择成功返回true,否则返回false
    2. mysqli: $link = mysqli_connect("mysql_host","mysql_user","mysql_password");
    2. PDO:(php data object),PHP访问数据库定义了一个轻量级的一致接口
      1. $dsn = "mysql:dbname = testdb;host = 127.0.0.1";
      2. $user = "dbuser";
      3. $password = "dbpass";
      4. $dbh = new PDO($dsn,$user,$password);  
  2. mysql_fetch_array($result) == mysql_fetch_row($result,MYSQL_NUM) == mysql_fetch_assoc($result,MYSQL_ASSOC);
 ?>