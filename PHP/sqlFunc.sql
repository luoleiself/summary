2017年05月06日
  1.设置默认存储引擎: default-storage-engine=INNODB
  2.查看创建表的引擎: SHOW CREATE TABLE tableName;
  3.显示索引: SHOW INDEXS FROM provinces;
  4.添加外键约束: 
    CREATE TABLE provinces(
      id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
      pname VARCHAR(20) NOT NULL
    );
    CREATE TABLE users(
      id SMALLINT UNSIENED PRIMARY KEY AUTO_INCREMENT,
      username VARCHAR(10) NOT NULL,
      pid SMALLINT UNSIGNED,
      FOREIGN KEY (pid) REFERENCES provinces (id) ON DELETE CASCADE
    );
  5.外键约束的参照(物理约束):
      CASCADE: 从父表删除或更新且自动删除或更新子表中匹配的行
      SET NULL: 从设置父表删除或更新行,并设置子表中的外键列为NULL,如果使用该选项,必须保证子表列约束不为NOT NULL
      RESTRICT: 拒绝对父表的删除或更新操作
      NO ACTION: 标准SQL的关键字,在MYSQL中与RESTRICT相同
  6.表级约束与列级约束:
      对一个数据列建立的约束,列级约束
      对多个数据列建立的约束,表级约束
      表级约束只能在列定义后声明;
  7.修改数据表:
      添加单列: ALTER TABLE tbl_name ADD column_name column_definition [FIRST | AFTER column_name ];
      添加多列: ALTER TABLE tbl_name ADD (column_name column_definition,...);
      删除列:   ALTER TABLE tbl_name DROP column_name1,DROP column_name2,...;
      添加主键/唯一/默认/外键/约束: ALTER TABLE tbl_name ADD PRIMAREY KEY (column_name);
      添加/删除默认约束: ALTER TABLE tbl_name ALTER column_name {SET DEFAULT literal | DROP DEFAULT};
      删除主键约束: ALTER TABLE tbl_name DROP PRIMARY KEY;
      删除唯一约束: ALTER TABLE tbl_name DROP INDEX cloumn_name;
      删除外键约束: ALTER TABLE tbl_name DROP FORIGN KEY column_name;
      修改列定义: ALTER TABLE tbl_name MODIFY column_name column_definition [FIRST | AFTER column_name];
      修改列名称: ALTER TABLE tbl_name CHANGE old_col_name new_col_name column_definition [FIRST | AFTER column_name];
      修改多个表名: RENAME TABLE tbl_name TO new_tbl_name [,tbl_name2 TO new_tbl_name,...];
  8.总结:
      约束: NOT NULL,PRIMARY KEY,UINQUE KEY,DEFAULT,FOREIGN KEY,表级约束,列级约束
      修改数据表:增加/删除字段、列定义、列名称、列定义、表名(两种方式)
  9.操作记录:
      插入记录(insert,insert select,insert set): INSERT [INTO] tbl_name [(column_name,...)] VALUES ({expr | DEFAULT});
      更新记录(单表操作、多表操作): UPDATE tbl_name SET column_name = {expr | DEFAULT},...[WHERE where_condition];
      删除记录(单表操作、多表操作): DELETE FROM tbl_name [WHERE where_condition];
      查找记录: 
        AS:查询字段别名,username AS name
        WHERE:查询条件
        GROUP BY:查询结果分组,[GROUP BY{col_name | position} [ASC | DESC],]
        HAVING:分组条件,SELECT sex FROM users GROUP BY sex HAVING count(id) > 5;
        ORDER BY:查询结果排序,[ORDER BY{col_name | position} [ASC | DESC],]
        LIMIT:限制结果数量,SELECT * FROM tbl_name LIMIT 2,2; // 返回3,4两条记录
 10.子查询: 出现在其他SQL语句内的select子句
      使用比较运算符的子查询;
      ANY,SOME,ALL修饰符:
      IN/NOT IN:
      EXISTS/NOT EXISTS:
 11.多表更新:
      UPDATE tdb_goods INNER JOIN tdb_goods_cates ON goods_cate = cate_name SET goods_cate = cate_id
      CREATE TABLE [IF NOT EXISTS] tbl_name  SELECT select_statement
      别名:UPDATE tdb_goods AS g INNER JOIN tdb_goods_brands AS b ON g.brand_name = b.brand_name SET g.brand_name = b.brand_id 
 12.连接: JOIN == CROSS JOIN == INNER JOIN
      内连接(INNER JOIN): 仅显示符合连接条件的记录
        SELECT goods_id,goods_name,cate_name FROM tdb_goods INNER JOIN tdb_goods_cates ON tdb_goods.cate_id = tdb_goods_cates.cate_id;
      左外连接(LEFT [OUTER] JOIN):仅显示左表的全部记录及右表符合连接条件的记录
        SELECT goods_id,goods_name,cate_name FROM tdb_goods LEFT JOIN tdb_goods_cates ON tdb_goods.cate_id = tdb_goods_cates.cate_id;
      右外连接(RIGHT [OUTER] JOIN): 仅显示右表的全部记录及左表符合连接条件的记录
        SELECT goods_id,goods_name,cate_name FROM tdb_goods RIGHT JOIN tdb_goods_cates ON tdb_goods.cate_id = tdb_goods_cates.cate_id;
      多表连接:
        SELECT goods_id,goods_name,cate_name,brand_name,goods_price FROM tdb_goods AS g INNER JOIN tdb_goods_cates AS c ON g.cate_id = c.cate_id INNER JOIN tdb_goods_brands AS b On g.brand_id = b.brand_id;
2017年05月07日    
  1.字符函数:
    CONCAT(str1,str2);字符连接
    CONCAT_WS(Separator,str1,str2);使用指定的分隔符进行字符连接
    FORMAT(number,DecimalDigit);数字格式化
    LOWER(str);转换成小写
    UPPER(str);转换成大写
    LEFT(str,num);获取左侧字符
    RIGHT(str,num);获取右侧字符
    LENGTH(str);获取字符串的长度
    LTRIM(str);删除字符左侧空格
    RTRIM(str);删除字符串末尾空格
    TRIM(str);删除字符串两端空格
    SUBSTRING(str,startIndex,num);字符串的截取
    [NOT] LIKE;模式匹配,SELECT "MySQL" LIKE "%1%%" EASCAPE "1";
    REPLACE(str,ostr,nstr);字符串替换
2017年05月13日
  1.数值运算符:
	  CEIL();进一取整,CEIL(3.01); # 4
	  FLOOR();减一取整,FLOOR(3.01); # 3
	  DIV();整数除法,DIV(3/4); # 0
	  MOD();取余数
	  POWER();幂运算
	  ROUND();四舍五入
	  TRUNCATE();数字截取
  2.比较运算符:
	  [NOT]BETWEEN... AND...;[不]在范围之内
	  [NOT]IN();[不]在列出值范围内
	  IS [NOT] NULL;[不]为空
  3.日期时间函数:
	  NOW();当前日期和时间
	  CURDATE();当前日期
	  CURTIME();当前时间
	  DATE_ADD();日期变化
	  DATEDIFF(date1,date2);获取两个日期时间之间的差值
	  DATE_FORMAT();日期格式化
  4.信息函数:
	  CONNECTION_ID();连接ID
	  DATEBASE();当前数据库
	  LAST_INSERT_ID();最后插入记录的id
	  USER();当前用户
	  VERSION();版本信息
  5.聚合函数:
	  AVG();平均值
	  COUNT();计数
	  MAX();最大值
	  MIN();最小值
	  SUM();求和
  6.加密函数:
	  MD5();信息摘要算法
	  PASSWORD();密码算法
