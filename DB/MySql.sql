一、数据类型:
	1、数值类型:
		类型						大小       范围                            用途
		TINYINT:				1字节			(0,255)													小整数值
		SMALLINT:				2字节			(0,65535)												大整数值
		MEDIUMINT:			3字节			(0,16777215)										大整数值
		INT/INTEGER:		4字节			(0,4294967295)									大整数值
		BIGINT:					8字节			(0,18446744073709551615)				极大整数值
		FLOAT:					4字节     ()															单精度,浮点数值
		DOUBLE:					8字节     ()															双精度,浮点数值
		DECIMAL:				判断M和D																	小数值
	2、日期和时间类型:
		类型						大小				范围																					格式								用途
		DATE:						3字节			1000-01-01/9999-12-31													YYYY-MM-DD					 日期值
		TIME:						3字节			'-838:59:59'/'838:59:59'											HH:MM:SS						 时间值/持续时间
		YEAR:						1字节			1901/2155																			YYYY								 年份值
		DATETIME:				8字节     1000-01-01 00:00:00/9999-12-31 23:59:59		YYYY-MM-DD HH:MM:SS			 混合日期和时间值
		TIMESTAMP:			4字节     1970-01-01 00:00:00/2037 年某时           YYYYMMDD HHMMSS					 混合日期和时间值，时间戳
	3、字符串类型:
		类型						大小							用途
		CHAR						0-255字节									定长字符串
		VARCHAR					0-65535 字节							变长字符串
		TINYBLOB				0-255字节									不超过 255 个字符的二进制字符串
		TINYTEXT				0-255字节									短文本字符串
		BLOB						0-65 535字节							二进制形式的长文本数据
		TEXT						0-65 535字节							长文本数据
		MEDIUMBLOB			0-16 777 215字节					二进制形式的中等长度文本数据
		MEDIUMTEXT			0-16 777 215字节					中等长度文本数据
		LONGBLOB				0-4 294 967 295字节				二进制形式的极大文本数据
		LONGTEXT				0-4 294 967 295字节				极大文本数据
二、创建数据表:
	CREATE TABLE table_name (column_name column_type);
	CREATE TABLE runoob_tbl(
		runoob_id INT NOT NULL AUTO_INCREMENT,
		runoob_title VARCHAR(100) NOT NULL,
		runoob_author VARCHAR(40) NOT NULL,
		submission_date DATE,
		PRIMARY KEY ( runoob_id )
	);
	/*
		NOT NULL 设置该地段不能为null;
		AUTO_INCREMENT定义列为自增的属性，一般用于主键，数值会自动加1。
		PRIMARY KEY关键字用于定义列为主键。 您可以使用多列来定义主键，列间以逗号分隔。
	*/
三、插入数据:
	INSERT INTO table_name ( field1, field2,...fieldN ) VALUES( value1, value2,...valueN );
四、查询数据:
	1、SELECT column_name,column_name FROM table_name [WHERE Clause] [OFFSET M ][LIMIT N];
		AND OR
	2、内存释放:
		mysql_free_result($result);来实现内存的释放。
五、更新数据:
	UPDATE table_name SET field1=new-value1, field2=new-value2 [WHERE Clause];
六、删除数据:
	DELETE FROM table_name [WHERE Clause];
七、LIKE子句:
	SELECT field1, field2,...fieldN table_name1, table_name2... WHERE field1 LIKE condition1 [AND [OR]] filed2 = 'somevalue';
	1、WHERE子句中指定任何条件;
	2、WHERE子句中使用LIKE子句;
	3、使用LIKE子句代替等号(=);
	4、LIKE 通常与 % 一同使用，类似于一个元字符的搜索;
	5、使用AND或者OR指定一个或多个条件;
	6、DELETE 或 UPDATE 命令中使用 WHERE...LIKE 子句来指定条件;
八、WHERE子句:
	SELECT field1, field2,...fieldN FROM table_name1, table_name2... [WHERE condition1 [AND [OR]] condition2.....;
	1、可以使用一个或者多个表，表之间使用逗号(,)分割，并使用WHERE语句来设定查询条件;
	2、可以在WHERE子句中指定任何条件;
	3、可以使用AND或者OR指定一个或多个条件;
	4、WHERE子句也可以运用于SQL的 DELETE 或者 UPDATE 命令;
	5、WHERE 子句类似于程序语言中的if条件，根据 MySQL 表中的字段值来读取指定的数据;
九、排序: ORDER BY
	SELECT field1, field2,...fieldN table_name1, table_name2... ORDER BY field1, [field2...] [ASC [DESC]];
十、分组: GROUP BY #根据一个或多个列对结果集进行分组。	
	SELECT column_name, function(column_name) FROM table_name WHERE column_name operator value GROUP BY column_name;
	使用 WITH ROLLUP 可以实现在分组统计数据基础上再进行相同的统计（SUM,AVG,COUNT…）。
十一、多表联合查询:
	1、INNER JOIN（内连接,或等值连接）：获取两个表中字段匹配关系的记录。
		SELECT a.runoob_id, a.runoob_author, b.runoob_count FROM runoob_tbl a INNER JOIN tcount_tbl b ON a.runoob_author = b.runoob_author;
		SELECT a.runoob_id, a.runoob_author, b.runoob_count FROM runoob_tbl a, tcount_tbl b WHERE a.runoob_author = b.runoob_author;
	2、LEFT JOIN（左连接）：获取左表所有记录，即使右表没有对应匹配的记录。
	3、RIGHT JOIN（右连接）： 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。
十二、null值处理: 在MySQL中，NULL值与任何其它值的比较（即使是NULL）永远返回false，即 NULL = NULL 返回false 。
	1、IS NULL: 当列的值是NULL,此运算符返回true。
	2、IS NOT NULL: 当列的值不为NULL, 运算符返回true。
	3、<=>: 比较操作符（不同于=运算符），当比较的的两个值为NULL时返回true。
十三、正则表达式:
	SELECT name FROM person_tbl WHERE name REGEXP '^st'; #查询name字段中以'st'为开头的所有数据;
# mysqladmin -u root password "new_password";		/*修改用户密码*/
ps -ef | grep mysqld;		#测试MySql服务器是否启动;
SHOW DATABASES;		#显示所有数据库列表;
SHOW TABLES;	#显示指定数据库中的所有表;
SHOW COLUMNS FROM table;	#显示数据表的属性,属性类型,主键信息,是否为空,默认值等其他信息。
SHOW INDEX FROM table;	#显示数据表的详细索引信息,包括PRIMARY KEY(主键);
SHOW TABLE STATUS LIKE [FROM db_name] [LIKE 'pattern']\G;	#输出MySql数据库管理系统的性能及统计信息;\G 按列打印结果;
CREATE DATABASE database; #MySql创建数据库;
DROP DATABASE database; #MySql删除数据库;
DROP TABLE table_name ; #MySql删除表;
USE database; #MySql选择数据库;
mysql_function(value,value,......);	
mysql_connect($connect); 
	/* $connect = (server,user,passwd,new_link,client_flag);
		new_link:	可选。如果用同样的参数第二次调用 mysql_connect()，将不会建立新连接，而将返回已经打开的连接标识。
							参数 new_link 改变此行为并使 mysql_connect() 总是打开新的连接，
							甚至当 mysql_connect() 曾在前面被用同样的参数调用过。
		client_flag: 可选。client_flags 参数可以是以下常量的组合：
							MYSQL_CLIENT_SSL - 使用 SSL 加密
							MYSQL_CLIENT_COMPRESS - 使用压缩协议
							MYSQL_CLIENT_IGNORE_SPACE - 允许函数名后的间隔
							MYSQL_CLIENT_INTERACTIVE - 允许关闭连接之前的交互超时非活动时间
	*/
mysql_query($connect,"SQL语句");
mysql_fetch_array();
mysql_connect();
mysql_close();
mysql_select_db( db_name, connection ); #PHP语法选择数据库;
mysql登录数据库:参数
	-D,--database=name 打开指定数据库
	--delimiter=name 指定分隔符
	-E,--vertical 垂直显示结果
	-h,--host=name 服务器名称
	-H,--html 提供HTML输出
	-X,--xml 提供XML输出
	-p,--password[=name]密码
	-P,--port=# 端口号
	--prompt=name 设置提示符
	-u,--user=name 用户名
	-V，--version 输出版本信息并退出